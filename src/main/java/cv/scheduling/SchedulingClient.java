package cv.scheduling;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import cv.scheduling.SchedulingServiceGrpc;
import cv.scheduling.SchedulingServiceGrpc.SchedulingServiceBlockingStub;
import cv.scheduling.SchedulingServiceGrpc.SchedulingServiceStub;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class SchedulingClient {
	private static SchedulingServiceBlockingStub blockingStub;
	private static SchedulingServiceStub asyncStub;
	private static ManagedChannel channel;

	public static void main(String[] args) {
		try {
			channel = ManagedChannelBuilder.
									forAddress("localhost", 50051)
									.usePlaintext()
									.build();

			//stubs -- generate from proto
			blockingStub = SchedulingServiceGrpc.newBlockingStub(channel);
			asyncStub = SchedulingServiceGrpc.newStub(channel);
			schedule("1","Michale","pen",10000,20000);
			
			checkAvailabilityBlocking();
			checkAvailabilityAsync();
			
			
			batchSchedule();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
	}
	
	
	//unary rpc
	public static void schedule(String course, String teacher, String equipment, long start_time, long end_time) {
	    SchedulingRequest request = SchedulingRequest.newBuilder()
	            .setCourseId(course)
	            .setTeacherId(teacher)
	            .addEquipment(equipment)
	            .setStartTime(start_time)
	            .setEndTime(end_time)
	            .build();

	    try {
	        SchedulingResultResponse response = blockingStub.schedule(request);
	        System.out.println("Success or not: " + response.getSuccess() + "; mes: " + response.getMessage());
	    } catch (StatusRuntimeException e) {
	        System.err.println("RPC failed: " + e.getStatus());
	    }
	}


	
	

	
	
	// blocking server-streaming
	public static void checkAvailabilityBlocking() {
	    SchedulingRequest request = SchedulingRequest.newBuilder()
	            .setCourseId("course1")
	            .setTeacherId("teacher1")
	            .addEquipment("equipment1")
	            .setNumStudents(30)
	            .setStartTime(1647025200L)
	            .setEndTime(1647032400L)
	            .build();

	    Iterator<ResourceAvailabilityResponse> responses = null;

	    try {
	        responses = blockingStub.checkAvailability(request);
	    } catch (StatusRuntimeException e) {
	        e.printStackTrace();
	        return;
	    }

	    while (responses.hasNext()) {
	        ResourceAvailabilityResponse temp = responses.next();
	        System.out.println("resource_id: " + temp.getResourceId() + " available_times: " + temp.getAvailableTimesList());
	    }
	}

	
	


	// asynchronous server-streaming
	public static void checkAvailabilityAsync() {

	    SchedulingRequest request = SchedulingRequest.newBuilder()
	        .setCourseId("course2")
	        .setTeacherId("teacher2")
	        .addEquipment("equipment2")
	        .setNumStudents(20)
	        .setStartTime(1647025200L)
	        .setEndTime(1647032400L)
	        .build();

	    StreamObserver<ResourceAvailabilityResponse> responseObserver = new StreamObserver<ResourceAvailabilityResponse>() {

	        @Override
	        public void onNext(ResourceAvailabilityResponse value) {
	            System.out.println("received resource_id: " + value.getResourceId() + " available_times: " + value.getAvailableTimesList());
	        }

	        @Override
	        public void onError(Throwable t) {
	            t.printStackTrace();

	        }

	        @Override
	        public void onCompleted() {
	            System.out.println("stream is completed ...");
	        }

	    };

	    try {
	        asyncStub.checkAvailability(request, responseObserver);
	        Thread.sleep(15000);
	      
	        
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    } catch (StatusRuntimeException e) {
	        e.printStackTrace();
	    } 
	    
	    
	}

	
	
	
	
	
	// client-streaming
	public static void batchSchedule() {
	    StreamObserver<SchedulingResultResponse> responseObserver = new StreamObserver<SchedulingResultResponse>() {

	        @Override
	        public void onNext(SchedulingResultResponse msg) {
	            System.out.println("Batch scheduling result received: " + msg.getMessage());
	        }

	        @Override
	        public void onError(Throwable t) {
	            t.printStackTrace();
	        }

	        @Override
	        public void onCompleted() {
	            System.out.println("Batch scheduling completed.");
	        }

	    };

	    StreamObserver<SchedulingRequest> requestObserver = asyncStub.batchSchedule(responseObserver);
	    try {
	        requestObserver.onNext(SchedulingRequest.newBuilder()
	            .setCourseId("course1")
	            .setTeacherId("teacher1")
	            .addEquipment("projector")
	            .addEquipment("whiteboard")
	            .setNumStudents(30)
	            .setStartTime(1647026400000L)
	            .setEndTime(1647030000000L)
	            .build());
	        Thread.sleep(500);

	        requestObserver.onNext(SchedulingRequest.newBuilder()
	            .setCourseId("course2")
	            .setTeacherId("teacher2")
	            .addEquipment("computer")
	            .setNumStudents(25)
	            .setStartTime(1647040800000L)
	            .setEndTime(1647044400000L)
	            .build());
	        Thread.sleep(500);

	        requestObserver.onNext(SchedulingRequest.newBuilder()
	            .setCourseId("course3")
	            .setTeacherId("teacher3")
	            .addEquipment("projector")
	            .addEquipment("whiteboard")
	            .addEquipment("microphone")
	            .setNumStudents(40)
	            .setStartTime(1647055200000L)
	            .setEndTime(1647058800000L)
	            .build());
	        Thread.sleep(500);

	        // Mark the end of requests
	        requestObserver.onCompleted();

	        Thread.sleep(10000);

	    } catch (RuntimeException e) {
	        e.printStackTrace();
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}

	
	

	
	
//	public void shutdown() throws InterruptedException {
//		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
//	}
}

