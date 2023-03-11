
package cv.scheduling;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import cv.scheduling.SchedulingServiceGrpc;
import cv.scheduling.SchedulingServiceGrpc.SchedulingServiceBlockingStub;
import cv.scheduling.SchedulingServiceGrpc.SchedulingServiceStub;


import java.util.concurrent.TimeUnit;

public class SchedulingClient {
	private static SchedulingServiceBlockingStub blockingStub;
	private static SchedulingServiceStub asyncStub;
	private static ManagedChannel channel;

	public static void main(String[] args) {
		channel = ManagedChannelBuilder.
								forAddress("localhost", 50051)
								.usePlaintext()
								.build();

		//stubs -- generate from proto
		blockingStub = SchedulingServiceGrpc.newBlockingStub(channel);
		asyncStub = SchedulingServiceGrpc.newStub(channel);
		schedule("1","Michale","pen",10000,20000);
	}
	
	
	//unary rpc
	public static void schedule(String course, String teacher, String equipment, long start_time, long end_time) {
		SchedulingRequest request = SchedulingRequest.newBuilder()
									.setCourseId(course) 
									.setTeacherId(teacher)
									.setEquipment(1,equipment)
									.setStartTime(start_time)
									.setEndTime(end_time)
									.build();

		SchedulingResultResponse response = blockingStub.schedule(request);
		System.out.println("Success or not: " + response.getSuccess() + "; mes: " + response.getMessage());
	}

	
	
	//server streaming rpc
	public void streamResources(String course, String teacher, String equipment) {
		SchedulingRequest request = SchedulingRequest.newBuilder()
									.setCourseId(course)
									.setTeacherId(teacher)
									.setEquipment(1,equipment)
									.build();

		stub.streamResources(request, new StreamObserver<ResourceResponse>() {
				@Override
				public void onNext(ResourceResponse response) {
					System.out.println("Received response: " + response.getRoom() + ", " + response.getTeacher() + ", " + response.getEquipment());
				}
				
				@Override
				public void onError(Throwable t) {
					System.err.println("Encountered error: " + t);
				}
				
				@Override
				public void onCompleted() {
					System.out.println("Request completed");
				}
		});
	}
	
	
	
	public void batchSchedule() {
		StreamObserver<SchedulingRequest> requestObserver = stub.batchSchedule(new StreamObserver<ScheduleResponse>() {
			@Override
			public void onNext(ScheduleResponse response) {
				System.out.println("Received response: " + response.getMessage());
			}
			
			@Override
			public void onError(Throwable t) {
				System.err.println("Encountered error: " + t);
			}

			@Override
			public void onCompleted() {
				System.out.println("Request completed");
			}
		});
		
		requestObserver.onNext(SchedulingRequest.newBuilder()
						.setCourseId("Course 1")
						.setTeacherId("Teacher 1")
						.setEquipment(1,"Equipment 1")
						.build());
		
		requestObserver.onNext(SchedulingRequest.newBuilder()
						.setCourseId("Course 2")
						.setTeacherId("Teacher 2")
						.setEquipment(2,"Equipment 2")
						.build());

		requestObserver.onNext(SchedulingRequest.newBuilder()
						.setCourseId("Course 3")
						.setTeacherId("Teacher 3")
						.setEquipment(3,"Equipment 3")
						.build());

		requestObserver.onCompleted();
	}

	
	
	public void shutdown() throws InterruptedException {
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}
}

