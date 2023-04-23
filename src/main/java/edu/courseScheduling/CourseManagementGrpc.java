package edu.courseScheduling;

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
 * Course Management Service
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: course.proto")
public final class CourseManagementGrpc {

  private CourseManagementGrpc() {}

  public static final String SERVICE_NAME = "CourseManagement";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<edu.courseScheduling.AddCourseScheduleRequest,
      edu.courseScheduling.AddCourseScheduleResponse> getAddCourseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddCourse",
      requestType = edu.courseScheduling.AddCourseScheduleRequest.class,
      responseType = edu.courseScheduling.AddCourseScheduleResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.courseScheduling.AddCourseScheduleRequest,
      edu.courseScheduling.AddCourseScheduleResponse> getAddCourseMethod() {
    io.grpc.MethodDescriptor<edu.courseScheduling.AddCourseScheduleRequest, edu.courseScheduling.AddCourseScheduleResponse> getAddCourseMethod;
    if ((getAddCourseMethod = CourseManagementGrpc.getAddCourseMethod) == null) {
      synchronized (CourseManagementGrpc.class) {
        if ((getAddCourseMethod = CourseManagementGrpc.getAddCourseMethod) == null) {
          CourseManagementGrpc.getAddCourseMethod = getAddCourseMethod = 
              io.grpc.MethodDescriptor.<edu.courseScheduling.AddCourseScheduleRequest, edu.courseScheduling.AddCourseScheduleResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CourseManagement", "AddCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.courseScheduling.AddCourseScheduleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.courseScheduling.AddCourseScheduleResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CourseManagementMethodDescriptorSupplier("AddCourse"))
                  .build();
          }
        }
     }
     return getAddCourseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<edu.courseScheduling.GetCourseScheduleByIdRequest,
      edu.courseScheduling.GetCourseScheduleByIdResponse> getGetCourseByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCourseById",
      requestType = edu.courseScheduling.GetCourseScheduleByIdRequest.class,
      responseType = edu.courseScheduling.GetCourseScheduleByIdResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.courseScheduling.GetCourseScheduleByIdRequest,
      edu.courseScheduling.GetCourseScheduleByIdResponse> getGetCourseByIdMethod() {
    io.grpc.MethodDescriptor<edu.courseScheduling.GetCourseScheduleByIdRequest, edu.courseScheduling.GetCourseScheduleByIdResponse> getGetCourseByIdMethod;
    if ((getGetCourseByIdMethod = CourseManagementGrpc.getGetCourseByIdMethod) == null) {
      synchronized (CourseManagementGrpc.class) {
        if ((getGetCourseByIdMethod = CourseManagementGrpc.getGetCourseByIdMethod) == null) {
          CourseManagementGrpc.getGetCourseByIdMethod = getGetCourseByIdMethod = 
              io.grpc.MethodDescriptor.<edu.courseScheduling.GetCourseScheduleByIdRequest, edu.courseScheduling.GetCourseScheduleByIdResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CourseManagement", "GetCourseById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.courseScheduling.GetCourseScheduleByIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.courseScheduling.GetCourseScheduleByIdResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CourseManagementMethodDescriptorSupplier("GetCourseById"))
                  .build();
          }
        }
     }
     return getGetCourseByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<edu.courseScheduling.GetAllCoursesScheduleRequest,
      edu.courseScheduling.GetAllCoursesScheduleResponse> getGetAllCoursesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllCourses",
      requestType = edu.courseScheduling.GetAllCoursesScheduleRequest.class,
      responseType = edu.courseScheduling.GetAllCoursesScheduleResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<edu.courseScheduling.GetAllCoursesScheduleRequest,
      edu.courseScheduling.GetAllCoursesScheduleResponse> getGetAllCoursesMethod() {
    io.grpc.MethodDescriptor<edu.courseScheduling.GetAllCoursesScheduleRequest, edu.courseScheduling.GetAllCoursesScheduleResponse> getGetAllCoursesMethod;
    if ((getGetAllCoursesMethod = CourseManagementGrpc.getGetAllCoursesMethod) == null) {
      synchronized (CourseManagementGrpc.class) {
        if ((getGetAllCoursesMethod = CourseManagementGrpc.getGetAllCoursesMethod) == null) {
          CourseManagementGrpc.getGetAllCoursesMethod = getGetAllCoursesMethod = 
              io.grpc.MethodDescriptor.<edu.courseScheduling.GetAllCoursesScheduleRequest, edu.courseScheduling.GetAllCoursesScheduleResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "CourseManagement", "GetAllCourses"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.courseScheduling.GetAllCoursesScheduleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.courseScheduling.GetAllCoursesScheduleResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CourseManagementMethodDescriptorSupplier("GetAllCourses"))
                  .build();
          }
        }
     }
     return getGetAllCoursesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CourseManagementStub newStub(io.grpc.Channel channel) {
    return new CourseManagementStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CourseManagementBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CourseManagementBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CourseManagementFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CourseManagementFutureStub(channel);
  }

  /**
   * <pre>
   * Course Management Service
   * </pre>
   */
  public static abstract class CourseManagementImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Add a course (Unary RPC)
     * </pre>
     */
    public void addCourse(edu.courseScheduling.AddCourseScheduleRequest request,
        io.grpc.stub.StreamObserver<edu.courseScheduling.AddCourseScheduleResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAddCourseMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get a course by course ID (Unary RPC)
     * </pre>
     */
    public void getCourseById(edu.courseScheduling.GetCourseScheduleByIdRequest request,
        io.grpc.stub.StreamObserver<edu.courseScheduling.GetCourseScheduleByIdResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCourseByIdMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get all courses (Server Streaming RPC)
     * </pre>
     */
    public void getAllCourses(edu.courseScheduling.GetAllCoursesScheduleRequest request,
        io.grpc.stub.StreamObserver<edu.courseScheduling.GetAllCoursesScheduleResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllCoursesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddCourseMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                edu.courseScheduling.AddCourseScheduleRequest,
                edu.courseScheduling.AddCourseScheduleResponse>(
                  this, METHODID_ADD_COURSE)))
          .addMethod(
            getGetCourseByIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                edu.courseScheduling.GetCourseScheduleByIdRequest,
                edu.courseScheduling.GetCourseScheduleByIdResponse>(
                  this, METHODID_GET_COURSE_BY_ID)))
          .addMethod(
            getGetAllCoursesMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                edu.courseScheduling.GetAllCoursesScheduleRequest,
                edu.courseScheduling.GetAllCoursesScheduleResponse>(
                  this, METHODID_GET_ALL_COURSES)))
          .build();
    }
  }

  /**
   * <pre>
   * Course Management Service
   * </pre>
   */
  public static final class CourseManagementStub extends io.grpc.stub.AbstractStub<CourseManagementStub> {
    private CourseManagementStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CourseManagementStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CourseManagementStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CourseManagementStub(channel, callOptions);
    }

    /**
     * <pre>
     * Add a course (Unary RPC)
     * </pre>
     */
    public void addCourse(edu.courseScheduling.AddCourseScheduleRequest request,
        io.grpc.stub.StreamObserver<edu.courseScheduling.AddCourseScheduleResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddCourseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get a course by course ID (Unary RPC)
     * </pre>
     */
    public void getCourseById(edu.courseScheduling.GetCourseScheduleByIdRequest request,
        io.grpc.stub.StreamObserver<edu.courseScheduling.GetCourseScheduleByIdResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCourseByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get all courses (Server Streaming RPC)
     * </pre>
     */
    public void getAllCourses(edu.courseScheduling.GetAllCoursesScheduleRequest request,
        io.grpc.stub.StreamObserver<edu.courseScheduling.GetAllCoursesScheduleResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetAllCoursesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Course Management Service
   * </pre>
   */
  public static final class CourseManagementBlockingStub extends io.grpc.stub.AbstractStub<CourseManagementBlockingStub> {
    private CourseManagementBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CourseManagementBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CourseManagementBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CourseManagementBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Add a course (Unary RPC)
     * </pre>
     */
    public edu.courseScheduling.AddCourseScheduleResponse addCourse(edu.courseScheduling.AddCourseScheduleRequest request) {
      return blockingUnaryCall(
          getChannel(), getAddCourseMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get a course by course ID (Unary RPC)
     * </pre>
     */
    public edu.courseScheduling.GetCourseScheduleByIdResponse getCourseById(edu.courseScheduling.GetCourseScheduleByIdRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetCourseByIdMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get all courses (Server Streaming RPC)
     * </pre>
     */
    public java.util.Iterator<edu.courseScheduling.GetAllCoursesScheduleResponse> getAllCourses(
        edu.courseScheduling.GetAllCoursesScheduleRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetAllCoursesMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Course Management Service
   * </pre>
   */
  public static final class CourseManagementFutureStub extends io.grpc.stub.AbstractStub<CourseManagementFutureStub> {
    private CourseManagementFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CourseManagementFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CourseManagementFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CourseManagementFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Add a course (Unary RPC)
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.courseScheduling.AddCourseScheduleResponse> addCourse(
        edu.courseScheduling.AddCourseScheduleRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAddCourseMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get a course by course ID (Unary RPC)
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.courseScheduling.GetCourseScheduleByIdResponse> getCourseById(
        edu.courseScheduling.GetCourseScheduleByIdRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCourseByIdMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_COURSE = 0;
  private static final int METHODID_GET_COURSE_BY_ID = 1;
  private static final int METHODID_GET_ALL_COURSES = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CourseManagementImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CourseManagementImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_COURSE:
          serviceImpl.addCourse((edu.courseScheduling.AddCourseScheduleRequest) request,
              (io.grpc.stub.StreamObserver<edu.courseScheduling.AddCourseScheduleResponse>) responseObserver);
          break;
        case METHODID_GET_COURSE_BY_ID:
          serviceImpl.getCourseById((edu.courseScheduling.GetCourseScheduleByIdRequest) request,
              (io.grpc.stub.StreamObserver<edu.courseScheduling.GetCourseScheduleByIdResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_COURSES:
          serviceImpl.getAllCourses((edu.courseScheduling.GetAllCoursesScheduleRequest) request,
              (io.grpc.stub.StreamObserver<edu.courseScheduling.GetAllCoursesScheduleResponse>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CourseManagementBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CourseManagementBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return edu.courseScheduling.CourseSchedulingServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CourseManagement");
    }
  }

  private static final class CourseManagementFileDescriptorSupplier
      extends CourseManagementBaseDescriptorSupplier {
    CourseManagementFileDescriptorSupplier() {}
  }

  private static final class CourseManagementMethodDescriptorSupplier
      extends CourseManagementBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CourseManagementMethodDescriptorSupplier(String methodName) {
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
      synchronized (CourseManagementGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CourseManagementFileDescriptorSupplier())
              .addMethod(getAddCourseMethod())
              .addMethod(getGetCourseByIdMethod())
              .addMethod(getGetAllCoursesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
