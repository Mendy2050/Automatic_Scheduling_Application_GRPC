package cv.scheduling;


import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.logging.Logger;

public class SchedulingServer {
    private static final Logger logger = Logger.getLogger(SchedulingServer.class.getName());

    private final int port;
    private final Server server;

    public SchedulingServer(int port) throws IOException {
        this(ServerBuilder.forPort(port), port);
    }

    public SchedulingServer(ServerBuilder<?> serverBuilder, int port) {
        this.port = port;
        server = serverBuilder.addService(new SchedulingServiceImpl())
                .build();
    }

    public void start() throws IOException {
        server.start();
        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // Use stderr here since the logger may have been reset by its JVM shutdown hook.
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            SchedulingServer.this.stop();
            System.err.println("*** server shut down");
        }));
    }

    public void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 50051;
        final SchedulingServer server = new SchedulingServer(port);
        server.start();
        server.blockUntilShutdown();
    }

    static class SchedulingServiceImpl extends SchedulingServiceGrpc.SchedulingServiceImplBase {
        @Override
        public void schedule(SchedulingRequest request, StreamObserver<SchedulingResultResponse> responseObserver) {
            // TODO: Implement scheduling logic based on the request data
            SchedulingResultResponse response = SchedulingResultResponse.newBuilder()
                    .setSuccess(true)
                    .setMessage("Scheduling request processed successfully")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        @Override
        public void checkAvailability(SchedulingRequest request, StreamObserver<ResourceAvailabilityResponse> responseObserver) {
            // TODO: Implement availability check logic based on the request data
            ResourceAvailabilityResponse response = ResourceAvailabilityResponse.newBuilder()
                    .setResourceId("example_resource")
                    .addAvailableTimes(1234567890L)
                    .addAvailableTimes(1234567900L)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        @Override
        public StreamObserver<SchedulingRequest> batchSchedule(StreamObserver<SchedulingResultResponse> responseObserver) {
            // TODO: Implement batch scheduling logic based on the request data received as a stream
            return new StreamObserver<SchedulingRequest>() {
                @Override
                public void onNext(SchedulingRequest request) {
                    // TODO: Process the received request
                }

                @Override
                public void onError(Throwable t) {
                    // TODO: Handle error in the request stream
                }

                @Override
                public void onCompleted() {
                    SchedulingResultResponse response = SchedulingResultResponse.newBuilder()
                            .setSuccess(true)
                            .setMessage("Batch scheduling request processed successfully")
                            .build();
                    responseObserver.onNext(response);
                    responseObserver.onCompleted();
                }
            };
        }
    }
}
