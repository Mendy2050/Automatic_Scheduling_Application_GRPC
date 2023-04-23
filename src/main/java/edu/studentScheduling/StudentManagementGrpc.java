package edu.studentScheduling;

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
 * Student Management Service
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: student.proto")
public final class StudentManagementGrpc {

  private StudentManagementGrpc() {}

  public static final String SERVICE_NAME = "scheduling.StudentManagement";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<edu.studentScheduling.AddStudentScheduleRequest,
      edu.studentScheduling.AddStudentScheduleResponse> getAddStudentScheduleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddStudentSchedule",
      requestType = edu.studentScheduling.AddStudentScheduleRequest.class,
      responseType = edu.studentScheduling.AddStudentScheduleResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.studentScheduling.AddStudentScheduleRequest,
      edu.studentScheduling.AddStudentScheduleResponse> getAddStudentScheduleMethod() {
    io.grpc.MethodDescriptor<edu.studentScheduling.AddStudentScheduleRequest, edu.studentScheduling.AddStudentScheduleResponse> getAddStudentScheduleMethod;
    if ((getAddStudentScheduleMethod = StudentManagementGrpc.getAddStudentScheduleMethod) == null) {
      synchronized (StudentManagementGrpc.class) {
        if ((getAddStudentScheduleMethod = StudentManagementGrpc.getAddStudentScheduleMethod) == null) {
          StudentManagementGrpc.getAddStudentScheduleMethod = getAddStudentScheduleMethod = 
              io.grpc.MethodDescriptor.<edu.studentScheduling.AddStudentScheduleRequest, edu.studentScheduling.AddStudentScheduleResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "scheduling.StudentManagement", "AddStudentSchedule"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.studentScheduling.AddStudentScheduleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.studentScheduling.AddStudentScheduleResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StudentManagementMethodDescriptorSupplier("AddStudentSchedule"))
                  .build();
          }
        }
     }
     return getAddStudentScheduleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<edu.studentScheduling.GetStudentScheduleByIdRequest,
      edu.studentScheduling.GetStudentScheduleByIdResponse> getGetStudentScheduleByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStudentScheduleById",
      requestType = edu.studentScheduling.GetStudentScheduleByIdRequest.class,
      responseType = edu.studentScheduling.GetStudentScheduleByIdResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.studentScheduling.GetStudentScheduleByIdRequest,
      edu.studentScheduling.GetStudentScheduleByIdResponse> getGetStudentScheduleByIdMethod() {
    io.grpc.MethodDescriptor<edu.studentScheduling.GetStudentScheduleByIdRequest, edu.studentScheduling.GetStudentScheduleByIdResponse> getGetStudentScheduleByIdMethod;
    if ((getGetStudentScheduleByIdMethod = StudentManagementGrpc.getGetStudentScheduleByIdMethod) == null) {
      synchronized (StudentManagementGrpc.class) {
        if ((getGetStudentScheduleByIdMethod = StudentManagementGrpc.getGetStudentScheduleByIdMethod) == null) {
          StudentManagementGrpc.getGetStudentScheduleByIdMethod = getGetStudentScheduleByIdMethod = 
              io.grpc.MethodDescriptor.<edu.studentScheduling.GetStudentScheduleByIdRequest, edu.studentScheduling.GetStudentScheduleByIdResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "scheduling.StudentManagement", "GetStudentScheduleById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.studentScheduling.GetStudentScheduleByIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.studentScheduling.GetStudentScheduleByIdResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StudentManagementMethodDescriptorSupplier("GetStudentScheduleById"))
                  .build();
          }
        }
     }
     return getGetStudentScheduleByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<edu.studentScheduling.UpdateStudentScheduleRequest,
      edu.studentScheduling.UpdateStudentScheduleResponse> getUpdateStudentSchedulesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateStudentSchedules",
      requestType = edu.studentScheduling.UpdateStudentScheduleRequest.class,
      responseType = edu.studentScheduling.UpdateStudentScheduleResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<edu.studentScheduling.UpdateStudentScheduleRequest,
      edu.studentScheduling.UpdateStudentScheduleResponse> getUpdateStudentSchedulesMethod() {
    io.grpc.MethodDescriptor<edu.studentScheduling.UpdateStudentScheduleRequest, edu.studentScheduling.UpdateStudentScheduleResponse> getUpdateStudentSchedulesMethod;
    if ((getUpdateStudentSchedulesMethod = StudentManagementGrpc.getUpdateStudentSchedulesMethod) == null) {
      synchronized (StudentManagementGrpc.class) {
        if ((getUpdateStudentSchedulesMethod = StudentManagementGrpc.getUpdateStudentSchedulesMethod) == null) {
          StudentManagementGrpc.getUpdateStudentSchedulesMethod = getUpdateStudentSchedulesMethod = 
              io.grpc.MethodDescriptor.<edu.studentScheduling.UpdateStudentScheduleRequest, edu.studentScheduling.UpdateStudentScheduleResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "scheduling.StudentManagement", "UpdateStudentSchedules"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.studentScheduling.UpdateStudentScheduleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.studentScheduling.UpdateStudentScheduleResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StudentManagementMethodDescriptorSupplier("UpdateStudentSchedules"))
                  .build();
          }
        }
     }
     return getUpdateStudentSchedulesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StudentManagementStub newStub(io.grpc.Channel channel) {
    return new StudentManagementStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StudentManagementBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new StudentManagementBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StudentManagementFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new StudentManagementFutureStub(channel);
  }

  /**
   * <pre>
   * Student Management Service
   * </pre>
   */
  public static abstract class StudentManagementImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Add a student schedule (Unary RPC)
     * </pre>
     */
    public void addStudentSchedule(edu.studentScheduling.AddStudentScheduleRequest request,
        io.grpc.stub.StreamObserver<edu.studentScheduling.AddStudentScheduleResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAddStudentScheduleMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get a student schedule by student ID (Unary RPC)
     * </pre>
     */
    public void getStudentScheduleById(edu.studentScheduling.GetStudentScheduleByIdRequest request,
        io.grpc.stub.StreamObserver<edu.studentScheduling.GetStudentScheduleByIdResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetStudentScheduleByIdMethod(), responseObserver);
    }

    /**
     * <pre>
     * Update student schedules in bulk (Client Streaming RPC)
     * </pre>
     */
    public io.grpc.stub.StreamObserver<edu.studentScheduling.UpdateStudentScheduleRequest> updateStudentSchedules(
        io.grpc.stub.StreamObserver<edu.studentScheduling.UpdateStudentScheduleResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getUpdateStudentSchedulesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddStudentScheduleMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                edu.studentScheduling.AddStudentScheduleRequest,
                edu.studentScheduling.AddStudentScheduleResponse>(
                  this, METHODID_ADD_STUDENT_SCHEDULE)))
          .addMethod(
            getGetStudentScheduleByIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                edu.studentScheduling.GetStudentScheduleByIdRequest,
                edu.studentScheduling.GetStudentScheduleByIdResponse>(
                  this, METHODID_GET_STUDENT_SCHEDULE_BY_ID)))
          .addMethod(
            getUpdateStudentSchedulesMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                edu.studentScheduling.UpdateStudentScheduleRequest,
                edu.studentScheduling.UpdateStudentScheduleResponse>(
                  this, METHODID_UPDATE_STUDENT_SCHEDULES)))
          .build();
    }
  }

  /**
   * <pre>
   * Student Management Service
   * </pre>
   */
  public static final class StudentManagementStub extends io.grpc.stub.AbstractStub<StudentManagementStub> {
    private StudentManagementStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StudentManagementStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StudentManagementStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StudentManagementStub(channel, callOptions);
    }

    /**
     * <pre>
     * Add a student schedule (Unary RPC)
     * </pre>
     */
    public void addStudentSchedule(edu.studentScheduling.AddStudentScheduleRequest request,
        io.grpc.stub.StreamObserver<edu.studentScheduling.AddStudentScheduleResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddStudentScheduleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get a student schedule by student ID (Unary RPC)
     * </pre>
     */
    public void getStudentScheduleById(edu.studentScheduling.GetStudentScheduleByIdRequest request,
        io.grpc.stub.StreamObserver<edu.studentScheduling.GetStudentScheduleByIdResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetStudentScheduleByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Update student schedules in bulk (Client Streaming RPC)
     * </pre>
     */
    public io.grpc.stub.StreamObserver<edu.studentScheduling.UpdateStudentScheduleRequest> updateStudentSchedules(
        io.grpc.stub.StreamObserver<edu.studentScheduling.UpdateStudentScheduleResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getUpdateStudentSchedulesMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Student Management Service
   * </pre>
   */
  public static final class StudentManagementBlockingStub extends io.grpc.stub.AbstractStub<StudentManagementBlockingStub> {
    private StudentManagementBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StudentManagementBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StudentManagementBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StudentManagementBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Add a student schedule (Unary RPC)
     * </pre>
     */
    public edu.studentScheduling.AddStudentScheduleResponse addStudentSchedule(edu.studentScheduling.AddStudentScheduleRequest request) {
      return blockingUnaryCall(
          getChannel(), getAddStudentScheduleMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get a student schedule by student ID (Unary RPC)
     * </pre>
     */
    public edu.studentScheduling.GetStudentScheduleByIdResponse getStudentScheduleById(edu.studentScheduling.GetStudentScheduleByIdRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetStudentScheduleByIdMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Student Management Service
   * </pre>
   */
  public static final class StudentManagementFutureStub extends io.grpc.stub.AbstractStub<StudentManagementFutureStub> {
    private StudentManagementFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StudentManagementFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StudentManagementFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StudentManagementFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Add a student schedule (Unary RPC)
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.studentScheduling.AddStudentScheduleResponse> addStudentSchedule(
        edu.studentScheduling.AddStudentScheduleRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAddStudentScheduleMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get a student schedule by student ID (Unary RPC)
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.studentScheduling.GetStudentScheduleByIdResponse> getStudentScheduleById(
        edu.studentScheduling.GetStudentScheduleByIdRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetStudentScheduleByIdMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_STUDENT_SCHEDULE = 0;
  private static final int METHODID_GET_STUDENT_SCHEDULE_BY_ID = 1;
  private static final int METHODID_UPDATE_STUDENT_SCHEDULES = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StudentManagementImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StudentManagementImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_STUDENT_SCHEDULE:
          serviceImpl.addStudentSchedule((edu.studentScheduling.AddStudentScheduleRequest) request,
              (io.grpc.stub.StreamObserver<edu.studentScheduling.AddStudentScheduleResponse>) responseObserver);
          break;
        case METHODID_GET_STUDENT_SCHEDULE_BY_ID:
          serviceImpl.getStudentScheduleById((edu.studentScheduling.GetStudentScheduleByIdRequest) request,
              (io.grpc.stub.StreamObserver<edu.studentScheduling.GetStudentScheduleByIdResponse>) responseObserver);
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
        case METHODID_UPDATE_STUDENT_SCHEDULES:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.updateStudentSchedules(
              (io.grpc.stub.StreamObserver<edu.studentScheduling.UpdateStudentScheduleResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class StudentManagementBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StudentManagementBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return edu.studentScheduling.StudentSchedulingServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StudentManagement");
    }
  }

  private static final class StudentManagementFileDescriptorSupplier
      extends StudentManagementBaseDescriptorSupplier {
    StudentManagementFileDescriptorSupplier() {}
  }

  private static final class StudentManagementMethodDescriptorSupplier
      extends StudentManagementBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    StudentManagementMethodDescriptorSupplier(String methodName) {
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
      synchronized (StudentManagementGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StudentManagementFileDescriptorSupplier())
              .addMethod(getAddStudentScheduleMethod())
              .addMethod(getGetStudentScheduleByIdMethod())
              .addMethod(getUpdateStudentSchedulesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
