package edu.teacherScheduling;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import edu.teacherScheduling.TeacherManagementGrpc.TeacherManagementImplBase;
import edu.teacherScheduling.UpdateTeacherScheduleRequest;
import edu.teacherScheduling.UpdateTeacherScheduleResponse;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.atomic.AtomicBoolean;

public class TeacherManagementService extends TeacherManagementImplBase {
	private AtomicBoolean isCallCompleted = new AtomicBoolean(false);

    private Map<String, List<String>> teacherSchedules;

    public TeacherManagementService(Map<String, List<String>> teacherSchedules) {
        this.teacherSchedules = teacherSchedules;
    }

    public TeacherManagementService() {
        this.teacherSchedules = new HashMap<>();
    }

    @Override
    public void addTeacherSchedule(AddTeacherScheduleRequest request,
                                   StreamObserver<AddTeacherScheduleResponse> responseObserver) {
        teacherSchedules.put(request.getTeacherId(), request.getCourseIdsList());

        AddTeacherScheduleResponse response = AddTeacherScheduleResponse.newBuilder()
                .setStatus("success")
                .setMessage("Teacher schedule of (Teacher ID: " + request.getTeacherId() + ") and (Course IDs: " + request.getCourseIdsList() + ") is(are) added successfully")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getTeacherScheduleById(GetTeacherScheduleByIdRequest request,
                                       StreamObserver<GetTeacherScheduleByIdResponse> responseObserver) {
        List<String> courseIds = teacherSchedules.getOrDefault(request.getTeacherId(), new ArrayList<>());

        GetTeacherScheduleByIdResponse response = GetTeacherScheduleByIdResponse.newBuilder()
                .setTeacherId(request.getTeacherId())
                .addAllCourseIds(courseIds)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

 // UpdateTeacherSchedules service implementation
    @Override
    public StreamObserver<UpdateTeacherScheduleRequest> updateTeacherSchedules(StreamObserver<UpdateTeacherScheduleResponse> responseObserver) {
        return new StreamObserver<UpdateTeacherScheduleRequest>() {
            @Override
            public void onNext(UpdateTeacherScheduleRequest request) {
                String teacherId = request.getTeacherId();
                List<String> courseIds = request.getCourseIdsList();
                teacherSchedules.put(teacherId, courseIds);

                // Simulate server generating response data
                List<TeachingItem> teachingItems = new ArrayList<>();
                for (String courseId : courseIds) {
                    TeachingItem teachingItem = TeachingItem.newBuilder()
                            .setTeacherId(teacherId)
                            .setCourseIds(courseId)
                            .build();
                    teachingItems.add(teachingItem);
                }

                UpdateTeacherScheduleResponse response = UpdateTeacherScheduleResponse.newBuilder()
                        .addAllTeachingItem(teachingItems)
                        .build();

                responseObserver.onNext(response);
            }

            @Override
            public void onError(Throwable t) {
                responseObserver.onError(t);
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }





public static void main(String[] args) {
    // Register the services and start the server
    int port = 50053;
    try {
        Server server = ServerBuilder.forPort(port)
                .addService(new TeacherManagementService())
                .build()
                .start();

        // Register service to JmDNS
        try (JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost())) {
            ServiceInfo TeacherServiceInfo = ServiceInfo.create("_TeacherManagement._tcp.local.", "Scheduling", port, "Teacher Management Service");

            System.out.println("Scheduling Services' information ...");
            System.out.println("Third service: ");
            System.out.println("\t service_type: _TeacherManagement._tcp.local.");
            System.out.println("\t service_name: Teacher Management Service");
            System.out.println("\t service_description: Teacher Scheduling");
            System.out.println("\t service_port: " + port);
            System.out.println();

            jmdns.registerService(TeacherServiceInfo);

            System.out.println("Services of Teacher Management Service were registered");
            System.out.println("Scheduling Server started, listening on port " + port);

            // Keep the server running until terminated
            server.awaitTermination();

        } catch (IOException e) {
            e.printStackTrace();
        }

    } catch (IOException | InterruptedException e) {
        e.printStackTrace();
    }
  }
}