package edu.courseScheduling;

import edu.courseScheduling.CourseManagementGrpc.CourseManagementImplBase;
import edu.courseScheduling.AddCourseScheduleRequest;
import edu.courseScheduling.AddCourseScheduleResponse;
import edu.courseScheduling.GetCourseScheduleByIdRequest;
import edu.courseScheduling.GetCourseScheduleByIdResponse;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

public class CourseManagementService extends CourseManagementImplBase {
    private Map<String, List<String>> CourseSchedules;

    public CourseManagementService(Map<String, List<String>> CourseSchedules) {
        this.CourseSchedules = CourseSchedules;
    }

    public CourseManagementService() {
        this.CourseSchedules = new HashMap<>();
    }

    @Override
    public void addCourse(AddCourseScheduleRequest request,
                                   StreamObserver<AddCourseScheduleResponse> responseObserver) {
        CourseSchedules.put(request.getCourseId(), request.getCourseDayOfWeekList());

        AddCourseScheduleResponse response = AddCourseScheduleResponse.newBuilder()
        		.setStatus("success")
                .setMessage("Course schedule of (Course ID: " + request.getCourseId() + ") and (Course - Day(s) of Week: " + request.getCourseDayOfWeekList() + ") is(are) added successfully")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getCourseById(GetCourseScheduleByIdRequest request,
                                       StreamObserver<GetCourseScheduleByIdResponse> responseObserver) {
        List<String> courseIds = CourseSchedules.getOrDefault(request.getCourseId(), new ArrayList<>());

        GetCourseScheduleByIdResponse response = GetCourseScheduleByIdResponse.newBuilder()
                .setCourseId(request.getCourseId())
                .addAllCourseDayOfWeek(courseIds)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getAllCourses(edu.courseScheduling.GetAllCoursesScheduleRequest request,
            io.grpc.stub.StreamObserver<edu.courseScheduling.GetAllCoursesScheduleResponse> responseObserver) {

        // emulate data 
        Map<String, List<String>> mockCourseSchedules = new HashMap<>();
        mockCourseSchedules.put("COURSE_1", Arrays.asList("Monday", "Wednesday", "Friday"));
        mockCourseSchedules.put("COURSE_2", Arrays.asList("Tuesday", "Thursday"));
        mockCourseSchedules.put("COURSE_3", Arrays.asList("Monday", "Wednesday"));

        // traverse the emulate data 
        for (Map.Entry<String, List<String>> entry : mockCourseSchedules.entrySet()) {
            // create a new CourseItem list
            List<CourseItem> courseItems = new ArrayList<>();

            for (String courseDayOfWeek : entry.getValue()) {
                // create a new CourseItem for each days_of_week
                CourseItem courseItem = CourseItem.newBuilder()
                        .setCourseId(entry.getKey())
                        .setCourseDayOfWeek(courseDayOfWeek)
                        .build();
                courseItems.add(courseItem);
            }

            // create a response object and send out
            GetAllCoursesScheduleResponse response = GetAllCoursesScheduleResponse.newBuilder()
                    .addAllCourseItem(courseItems)
                    .build();

            responseObserver.onNext(response);
        }

        responseObserver.onCompleted();
}

public static void main(String[] args) {
    // Register the services and start the server
    int port = 50052;
    try {
        Server server = ServerBuilder.forPort(port)
                .addService(new CourseManagementService())
                .build()
                .start();

        // Register service to JmDNS
        try (JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost())) {
            ServiceInfo CourseServiceInfo = ServiceInfo.create("_CourseManagement._tcp.local.", "Scheduling", port, "Course Management Service");

            System.out.println("Scheduling Services' information ...");
            System.out.println("Second service: ");
            System.out.println("\t service_type: _CourseManagement._tcp.local.");
            System.out.println("\t service_name: Course Management Service");
            System.out.println("\t service_description: Course Scheduling");
            System.out.println("\t service_port: " + port);
            System.out.println();

            jmdns.registerService(CourseServiceInfo);

            System.out.println("Services of Course Management Service were registered");
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
