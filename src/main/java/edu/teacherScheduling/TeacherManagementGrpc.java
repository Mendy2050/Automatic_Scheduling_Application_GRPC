package edu.teacherScheduling;

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
 * Teacher Management Service
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: teacher.proto")
public final class TeacherManagementGrpc {

  private TeacherManagementGrpc() {}

  public static final String SERVICE_NAME = "TeacherManagement";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<edu.teacherScheduling.AddTeacherScheduleRequest,
      edu.teacherScheduling.AddTeacherScheduleResponse> getAddTeacherScheduleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddTeacherSchedule",
      requestType = edu.teacherScheduling.AddTeacherScheduleRequest.class,
      responseType = edu.teacherScheduling.AddTeacherScheduleResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.teacherScheduling.AddTeacherScheduleRequest,
      edu.teacherScheduling.AddTeacherScheduleResponse> getAddTeacherScheduleMethod() {
    io.grpc.MethodDescriptor<edu.teacherScheduling.AddTeacherScheduleRequest, edu.teacherScheduling.AddTeacherScheduleResponse> getAddTeacherScheduleMethod;
    if ((getAddTeacherScheduleMethod = TeacherManagementGrpc.getAddTeacherScheduleMethod) == null) {
      synchronized (TeacherManagementGrpc.class) {
        if ((getAddTeacherScheduleMethod = TeacherManagementGrpc.getAddTeacherScheduleMethod) == null) {
          TeacherManagementGrpc.getAddTeacherScheduleMethod = getAddTeacherScheduleMethod = 
              io.grpc.MethodDescriptor.<edu.teacherScheduling.AddTeacherScheduleRequest, edu.teacherScheduling.AddTeacherScheduleResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "TeacherManagement", "AddTeacherSchedule"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.teacherScheduling.AddTeacherScheduleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.teacherScheduling.AddTeacherScheduleResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TeacherManagementMethodDescriptorSupplier("AddTeacherSchedule"))
                  .build();
          }
        }
     }
     return getAddTeacherScheduleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<edu.teacherScheduling.GetTeacherScheduleByIdRequest,
      edu.teacherScheduling.GetTeacherScheduleByIdResponse> getGetTeacherScheduleByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTeacherScheduleById",
      requestType = edu.teacherScheduling.GetTeacherScheduleByIdRequest.class,
      responseType = edu.teacherScheduling.GetTeacherScheduleByIdResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.teacherScheduling.GetTeacherScheduleByIdRequest,
      edu.teacherScheduling.GetTeacherScheduleByIdResponse> getGetTeacherScheduleByIdMethod() {
    io.grpc.MethodDescriptor<edu.teacherScheduling.GetTeacherScheduleByIdRequest, edu.teacherScheduling.GetTeacherScheduleByIdResponse> getGetTeacherScheduleByIdMethod;
    if ((getGetTeacherScheduleByIdMethod = TeacherManagementGrpc.getGetTeacherScheduleByIdMethod) == null) {
      synchronized (TeacherManagementGrpc.class) {
        if ((getGetTeacherScheduleByIdMethod = TeacherManagementGrpc.getGetTeacherScheduleByIdMethod) == null) {
          TeacherManagementGrpc.getGetTeacherScheduleByIdMethod = getGetTeacherScheduleByIdMethod = 
              io.grpc.MethodDescriptor.<edu.teacherScheduling.GetTeacherScheduleByIdRequest, edu.teacherScheduling.GetTeacherScheduleByIdResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "TeacherManagement", "GetTeacherScheduleById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.teacherScheduling.GetTeacherScheduleByIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.teacherScheduling.GetTeacherScheduleByIdResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TeacherManagementMethodDescriptorSupplier("GetTeacherScheduleById"))
                  .build();
          }
        }
     }
     return getGetTeacherScheduleByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<edu.teacherScheduling.UpdateTeacherScheduleRequest,
      edu.teacherScheduling.UpdateTeacherScheduleResponse> getUpdateTeacherSchedulesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTeacherSchedules",
      requestType = edu.teacherScheduling.UpdateTeacherScheduleRequest.class,
      responseType = edu.teacherScheduling.UpdateTeacherScheduleResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<edu.teacherScheduling.UpdateTeacherScheduleRequest,
      edu.teacherScheduling.UpdateTeacherScheduleResponse> getUpdateTeacherSchedulesMethod() {
    io.grpc.MethodDescriptor<edu.teacherScheduling.UpdateTeacherScheduleRequest, edu.teacherScheduling.UpdateTeacherScheduleResponse> getUpdateTeacherSchedulesMethod;
    if ((getUpdateTeacherSchedulesMethod = TeacherManagementGrpc.getUpdateTeacherSchedulesMethod) == null) {
      synchronized (TeacherManagementGrpc.class) {
        if ((getUpdateTeacherSchedulesMethod = TeacherManagementGrpc.getUpdateTeacherSchedulesMethod) == null) {
          TeacherManagementGrpc.getUpdateTeacherSchedulesMethod = getUpdateTeacherSchedulesMethod = 
              io.grpc.MethodDescriptor.<edu.teacherScheduling.UpdateTeacherScheduleRequest, edu.teacherScheduling.UpdateTeacherScheduleResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "TeacherManagement", "UpdateTeacherSchedules"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.teacherScheduling.UpdateTeacherScheduleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.teacherScheduling.UpdateTeacherScheduleResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TeacherManagementMethodDescriptorSupplier("UpdateTeacherSchedules"))
                  .build();
          }
        }
     }
     return getUpdateTeacherSchedulesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TeacherManagementStub newStub(io.grpc.Channel channel) {
    return new TeacherManagementStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TeacherManagementBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TeacherManagementBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TeacherManagementFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TeacherManagementFutureStub(channel);
  }

  /**
   * <pre>
   * Teacher Management Service
   * </pre>
   */
  public static abstract class TeacherManagementImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Add a teacher schedule (Unary RPC)
     * </pre>
     */
    public void addTeacherSchedule(edu.teacherScheduling.AddTeacherScheduleRequest request,
        io.grpc.stub.StreamObserver<edu.teacherScheduling.AddTeacherScheduleResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAddTeacherScheduleMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get a teacher schedule by teacher ID (Unary RPC)
     * </pre>
     */
    public void getTeacherScheduleById(edu.teacherScheduling.GetTeacherScheduleByIdRequest request,
        io.grpc.stub.StreamObserver<edu.teacherScheduling.GetTeacherScheduleByIdResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTeacherScheduleByIdMethod(), responseObserver);
    }

    /**
     * <pre>
     * Update teacher schedules in real-time (Bidirectional Streaming RPC)
     * </pre>
     */
    public io.grpc.stub.StreamObserver<edu.teacherScheduling.UpdateTeacherScheduleRequest> updateTeacherSchedules(
        io.grpc.stub.StreamObserver<edu.teacherScheduling.UpdateTeacherScheduleResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getUpdateTeacherSchedulesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddTeacherScheduleMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                edu.teacherScheduling.AddTeacherScheduleRequest,
                edu.teacherScheduling.AddTeacherScheduleResponse>(
                  this, METHODID_ADD_TEACHER_SCHEDULE)))
          .addMethod(
            getGetTeacherScheduleByIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                edu.teacherScheduling.GetTeacherScheduleByIdRequest,
                edu.teacherScheduling.GetTeacherScheduleByIdResponse>(
                  this, METHODID_GET_TEACHER_SCHEDULE_BY_ID)))
          .addMethod(
            getUpdateTeacherSchedulesMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                edu.teacherScheduling.UpdateTeacherScheduleRequest,
                edu.teacherScheduling.UpdateTeacherScheduleResponse>(
                  this, METHODID_UPDATE_TEACHER_SCHEDULES)))
          .build();
    }
  }

  /**
   * <pre>
   * Teacher Management Service
   * </pre>
   */
  public static final class TeacherManagementStub extends io.grpc.stub.AbstractStub<TeacherManagementStub> {
    private TeacherManagementStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TeacherManagementStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TeacherManagementStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TeacherManagementStub(channel, callOptions);
    }

    /**
     * <pre>
     * Add a teacher schedule (Unary RPC)
     * </pre>
     */
    public void addTeacherSchedule(edu.teacherScheduling.AddTeacherScheduleRequest request,
        io.grpc.stub.StreamObserver<edu.teacherScheduling.AddTeacherScheduleResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddTeacherScheduleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get a teacher schedule by teacher ID (Unary RPC)
     * </pre>
     */
    public void getTeacherScheduleById(edu.teacherScheduling.GetTeacherScheduleByIdRequest request,
        io.grpc.stub.StreamObserver<edu.teacherScheduling.GetTeacherScheduleByIdResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTeacherScheduleByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Update teacher schedules in real-time (Bidirectional Streaming RPC)
     * </pre>
     */
    public io.grpc.stub.StreamObserver<edu.teacherScheduling.UpdateTeacherScheduleRequest> updateTeacherSchedules(
        io.grpc.stub.StreamObserver<edu.teacherScheduling.UpdateTeacherScheduleResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getUpdateTeacherSchedulesMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Teacher Management Service
   * </pre>
   */
  public static final class TeacherManagementBlockingStub extends io.grpc.stub.AbstractStub<TeacherManagementBlockingStub> {
    private TeacherManagementBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TeacherManagementBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TeacherManagementBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TeacherManagementBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Add a teacher schedule (Unary RPC)
     * </pre>
     */
    public edu.teacherScheduling.AddTeacherScheduleResponse addTeacherSchedule(edu.teacherScheduling.AddTeacherScheduleRequest request) {
      return blockingUnaryCall(
          getChannel(), getAddTeacherScheduleMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get a teacher schedule by teacher ID (Unary RPC)
     * </pre>
     */
    public edu.teacherScheduling.GetTeacherScheduleByIdResponse getTeacherScheduleById(edu.teacherScheduling.GetTeacherScheduleByIdRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetTeacherScheduleByIdMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Teacher Management Service
   * </pre>
   */
  public static final class TeacherManagementFutureStub extends io.grpc.stub.AbstractStub<TeacherManagementFutureStub> {
    private TeacherManagementFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TeacherManagementFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TeacherManagementFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TeacherManagementFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Add a teacher schedule (Unary RPC)
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.teacherScheduling.AddTeacherScheduleResponse> addTeacherSchedule(
        edu.teacherScheduling.AddTeacherScheduleRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAddTeacherScheduleMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get a teacher schedule by teacher ID (Unary RPC)
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.teacherScheduling.GetTeacherScheduleByIdResponse> getTeacherScheduleById(
        edu.teacherScheduling.GetTeacherScheduleByIdRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTeacherScheduleByIdMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_TEACHER_SCHEDULE = 0;
  private static final int METHODID_GET_TEACHER_SCHEDULE_BY_ID = 1;
  private static final int METHODID_UPDATE_TEACHER_SCHEDULES = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TeacherManagementImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TeacherManagementImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_TEACHER_SCHEDULE:
          serviceImpl.addTeacherSchedule((edu.teacherScheduling.AddTeacherScheduleRequest) request,
              (io.grpc.stub.StreamObserver<edu.teacherScheduling.AddTeacherScheduleResponse>) responseObserver);
          break;
        case METHODID_GET_TEACHER_SCHEDULE_BY_ID:
          serviceImpl.getTeacherScheduleById((edu.teacherScheduling.GetTeacherScheduleByIdRequest) request,
              (io.grpc.stub.StreamObserver<edu.teacherScheduling.GetTeacherScheduleByIdResponse>) responseObserver);
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
        case METHODID_UPDATE_TEACHER_SCHEDULES:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.updateTeacherSchedules(
              (io.grpc.stub.StreamObserver<edu.teacherScheduling.UpdateTeacherScheduleResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TeacherManagementBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TeacherManagementBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return edu.teacherScheduling.TeacherSchedulingServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TeacherManagement");
    }
  }

  private static final class TeacherManagementFileDescriptorSupplier
      extends TeacherManagementBaseDescriptorSupplier {
    TeacherManagementFileDescriptorSupplier() {}
  }

  private static final class TeacherManagementMethodDescriptorSupplier
      extends TeacherManagementBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TeacherManagementMethodDescriptorSupplier(String methodName) {
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
      synchronized (TeacherManagementGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TeacherManagementFileDescriptorSupplier())
              .addMethod(getAddTeacherScheduleMethod())
              .addMethod(getGetTeacherScheduleByIdMethod())
              .addMethod(getUpdateTeacherSchedulesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
