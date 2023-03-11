package cv.scheduling;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Interface exported by the server.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: scheduling.proto")
public final class SchedulingServiceGrpc {

  private SchedulingServiceGrpc() {}

  public static final String SERVICE_NAME = "scheduling.SchedulingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<cv.scheduling.SchedulingRequest,
      cv.scheduling.SchedulingResultResponse> getScheduleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Schedule",
      requestType = cv.scheduling.SchedulingRequest.class,
      responseType = cv.scheduling.SchedulingResultResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cv.scheduling.SchedulingRequest,
      cv.scheduling.SchedulingResultResponse> getScheduleMethod() {
    io.grpc.MethodDescriptor<cv.scheduling.SchedulingRequest, cv.scheduling.SchedulingResultResponse> getScheduleMethod;
    if ((getScheduleMethod = SchedulingServiceGrpc.getScheduleMethod) == null) {
      synchronized (SchedulingServiceGrpc.class) {
        if ((getScheduleMethod = SchedulingServiceGrpc.getScheduleMethod) == null) {
          SchedulingServiceGrpc.getScheduleMethod = getScheduleMethod = 
              io.grpc.MethodDescriptor.<cv.scheduling.SchedulingRequest, cv.scheduling.SchedulingResultResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "scheduling.SchedulingService", "Schedule"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cv.scheduling.SchedulingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cv.scheduling.SchedulingResultResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SchedulingServiceMethodDescriptorSupplier("Schedule"))
                  .build();
          }
        }
     }
     return getScheduleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cv.scheduling.SchedulingRequest,
      cv.scheduling.ResourceAvailabilityResponse> getCheckAvailabilityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckAvailability",
      requestType = cv.scheduling.SchedulingRequest.class,
      responseType = cv.scheduling.ResourceAvailabilityResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<cv.scheduling.SchedulingRequest,
      cv.scheduling.ResourceAvailabilityResponse> getCheckAvailabilityMethod() {
    io.grpc.MethodDescriptor<cv.scheduling.SchedulingRequest, cv.scheduling.ResourceAvailabilityResponse> getCheckAvailabilityMethod;
    if ((getCheckAvailabilityMethod = SchedulingServiceGrpc.getCheckAvailabilityMethod) == null) {
      synchronized (SchedulingServiceGrpc.class) {
        if ((getCheckAvailabilityMethod = SchedulingServiceGrpc.getCheckAvailabilityMethod) == null) {
          SchedulingServiceGrpc.getCheckAvailabilityMethod = getCheckAvailabilityMethod = 
              io.grpc.MethodDescriptor.<cv.scheduling.SchedulingRequest, cv.scheduling.ResourceAvailabilityResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "scheduling.SchedulingService", "CheckAvailability"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cv.scheduling.SchedulingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cv.scheduling.ResourceAvailabilityResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SchedulingServiceMethodDescriptorSupplier("CheckAvailability"))
                  .build();
          }
        }
     }
     return getCheckAvailabilityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cv.scheduling.SchedulingRequest,
      cv.scheduling.SchedulingResultResponse> getBatchScheduleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchSchedule",
      requestType = cv.scheduling.SchedulingRequest.class,
      responseType = cv.scheduling.SchedulingResultResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<cv.scheduling.SchedulingRequest,
      cv.scheduling.SchedulingResultResponse> getBatchScheduleMethod() {
    io.grpc.MethodDescriptor<cv.scheduling.SchedulingRequest, cv.scheduling.SchedulingResultResponse> getBatchScheduleMethod;
    if ((getBatchScheduleMethod = SchedulingServiceGrpc.getBatchScheduleMethod) == null) {
      synchronized (SchedulingServiceGrpc.class) {
        if ((getBatchScheduleMethod = SchedulingServiceGrpc.getBatchScheduleMethod) == null) {
          SchedulingServiceGrpc.getBatchScheduleMethod = getBatchScheduleMethod = 
              io.grpc.MethodDescriptor.<cv.scheduling.SchedulingRequest, cv.scheduling.SchedulingResultResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "scheduling.SchedulingService", "BatchSchedule"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cv.scheduling.SchedulingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cv.scheduling.SchedulingResultResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SchedulingServiceMethodDescriptorSupplier("BatchSchedule"))
                  .build();
          }
        }
     }
     return getBatchScheduleMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SchedulingServiceStub newStub(io.grpc.Channel channel) {
    return new SchedulingServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SchedulingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SchedulingServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SchedulingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SchedulingServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class SchedulingServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Unary RPC
     * </pre>
     */
    public void schedule(cv.scheduling.SchedulingRequest request,
        io.grpc.stub.StreamObserver<cv.scheduling.SchedulingResultResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getScheduleMethod(), responseObserver);
    }

    /**
     * <pre>
     * Server-side Streaming RPC
     * </pre>
     */
    public void checkAvailability(cv.scheduling.SchedulingRequest request,
        io.grpc.stub.StreamObserver<cv.scheduling.ResourceAvailabilityResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCheckAvailabilityMethod(), responseObserver);
    }

    /**
     * <pre>
     * Client-side Streaming RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<cv.scheduling.SchedulingRequest> batchSchedule(
        io.grpc.stub.StreamObserver<cv.scheduling.SchedulingResultResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getBatchScheduleMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getScheduleMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                cv.scheduling.SchedulingRequest,
                cv.scheduling.SchedulingResultResponse>(
                  this, METHODID_SCHEDULE)))
          .addMethod(
            getCheckAvailabilityMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                cv.scheduling.SchedulingRequest,
                cv.scheduling.ResourceAvailabilityResponse>(
                  this, METHODID_CHECK_AVAILABILITY)))
          .addMethod(
            getBatchScheduleMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                cv.scheduling.SchedulingRequest,
                cv.scheduling.SchedulingResultResponse>(
                  this, METHODID_BATCH_SCHEDULE)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class SchedulingServiceStub extends io.grpc.stub.AbstractStub<SchedulingServiceStub> {
    private SchedulingServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SchedulingServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SchedulingServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SchedulingServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC
     * </pre>
     */
    public void schedule(cv.scheduling.SchedulingRequest request,
        io.grpc.stub.StreamObserver<cv.scheduling.SchedulingResultResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getScheduleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Server-side Streaming RPC
     * </pre>
     */
    public void checkAvailability(cv.scheduling.SchedulingRequest request,
        io.grpc.stub.StreamObserver<cv.scheduling.ResourceAvailabilityResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getCheckAvailabilityMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Client-side Streaming RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<cv.scheduling.SchedulingRequest> batchSchedule(
        io.grpc.stub.StreamObserver<cv.scheduling.SchedulingResultResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getBatchScheduleMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class SchedulingServiceBlockingStub extends io.grpc.stub.AbstractStub<SchedulingServiceBlockingStub> {
    private SchedulingServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SchedulingServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SchedulingServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SchedulingServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC
     * </pre>
     */
    public cv.scheduling.SchedulingResultResponse schedule(cv.scheduling.SchedulingRequest request) {
      return blockingUnaryCall(
          getChannel(), getScheduleMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Server-side Streaming RPC
     * </pre>
     */
    public java.util.Iterator<cv.scheduling.ResourceAvailabilityResponse> checkAvailability(
        cv.scheduling.SchedulingRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getCheckAvailabilityMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class SchedulingServiceFutureStub extends io.grpc.stub.AbstractStub<SchedulingServiceFutureStub> {
    private SchedulingServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SchedulingServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SchedulingServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SchedulingServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<cv.scheduling.SchedulingResultResponse> schedule(
        cv.scheduling.SchedulingRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getScheduleMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SCHEDULE = 0;
  private static final int METHODID_CHECK_AVAILABILITY = 1;
  private static final int METHODID_BATCH_SCHEDULE = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SchedulingServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SchedulingServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SCHEDULE:
          serviceImpl.schedule((cv.scheduling.SchedulingRequest) request,
              (io.grpc.stub.StreamObserver<cv.scheduling.SchedulingResultResponse>) responseObserver);
          break;
        case METHODID_CHECK_AVAILABILITY:
          serviceImpl.checkAvailability((cv.scheduling.SchedulingRequest) request,
              (io.grpc.stub.StreamObserver<cv.scheduling.ResourceAvailabilityResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_BATCH_SCHEDULE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.batchSchedule(
              (io.grpc.stub.StreamObserver<cv.scheduling.SchedulingResultResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SchedulingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SchedulingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return cv.scheduling.SchedulingServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SchedulingService");
    }
  }

  private static final class SchedulingServiceFileDescriptorSupplier
      extends SchedulingServiceBaseDescriptorSupplier {
    SchedulingServiceFileDescriptorSupplier() {}
  }

  private static final class SchedulingServiceMethodDescriptorSupplier
      extends SchedulingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SchedulingServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (SchedulingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SchedulingServiceFileDescriptorSupplier())
              .addMethod(getScheduleMethod())
              .addMethod(getCheckAvailabilityMethod())
              .addMethod(getBatchScheduleMethod())
              .build();
        }
      }
    }
    return result;
  }
}
