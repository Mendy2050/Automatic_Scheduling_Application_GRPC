package edu.studentScheduling;

import edu.studentScheduling.StudentManagementGrpc.StudentManagementImplBase;
import edu.studentScheduling.AddStudentScheduleRequest;
import edu.studentScheduling.AddStudentScheduleResponse;
import edu.studentScheduling.GetStudentScheduleByIdRequest;
import edu.studentScheduling.GetStudentScheduleByIdResponse;
import edu.studentScheduling.UpdateStudentScheduleRequest;
import edu.studentScheduling.UpdateStudentScheduleResponse;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

public class StudentManagementService extends StudentManagementImplBase {
    private Map<String, List<String>> studentSchedules;

    public StudentManagementService(Map<String, List<String>> studentSchedules) {
        this.studentSchedules = studentSchedules;
    }

    public StudentManagementService() {
        this.studentSchedules = new HashMap<>();
    }

    @Override
    public void addStudentSchedule(AddStudentScheduleRequest request,
                                   StreamObserver<AddStudentScheduleResponse> responseObserver) {
        studentSchedules.put(request.getStudentId(), request.getCourseIdsList());

        AddStudentScheduleResponse response = AddStudentScheduleResponse.newBuilder()
                .setStatus("success")
                .setMessage("Student schedule of (Student ID: " + request.getStudentId() + ") and (Course IDs: " + request.getCourseIdsList() + ") is(are) added successfully")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getStudentScheduleById(GetStudentScheduleByIdRequest request,
                                       StreamObserver<GetStudentScheduleByIdResponse> responseObserver) {
        List<String> courseIds = studentSchedules.getOrDefault(request.getStudentId(), new ArrayList<>());

        GetStudentScheduleByIdResponse response = GetStudentScheduleByIdResponse.newBuilder()
                .setStudentId(request.getStudentId())
                .addAllCourseIds(courseIds)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<UpdateStudentScheduleRequest> updateStudentSchedules(
            StreamObserver<UpdateStudentScheduleResponse> responseObserver) {
        return new StreamObserver<UpdateStudentScheduleRequest>() {
            private UpdateStudentScheduleRequest lastRequest;

            @Override
            public void onNext(UpdateStudentScheduleRequest request) {
                studentSchedules.put(request.getStudentId(), request.getCourseIdsList());
                lastRequest = request;
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                UpdateStudentScheduleResponse response = UpdateStudentScheduleResponse.newBuilder()
                        .setStatus("success")
                        .setMessage("Student schedules updated successfully for [student ID: " + lastRequest.getStudentId() + "] and [Course IDs: " + lastRequest.getCourseIdsList() + "]")
                        .build();

                responseObserver.onNext(response);
                           responseObserver.onCompleted();
        }
    };
}

public static void main(String[] args) {
    // Register the services and start the server
    int port = 50051;
    try {
        Server server = ServerBuilder.forPort(port)
                .addService(new StudentManagementService())
                .build()
                .start();

        // Register service to JmDNS
        try (JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost())) {
            ServiceInfo studentServiceInfo = ServiceInfo.create("_studentManagement._tcp.local.", "Scheduling", port, "Student Management Service");

            System.out.println("Scheduling Services' information ...");
            System.out.println("First service: ");
            System.out.println("\t service_type: _studentManagement._tcp.local.");
            System.out.println("\t service_name: Student Management Service");
            System.out.println("\t service_description: Student Scheduling");
            System.out.println("\t service_port: " + port);
            System.out.println();

            jmdns.registerService(studentServiceInfo);

            System.out.println("Services of Student Management Service were registered");
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
