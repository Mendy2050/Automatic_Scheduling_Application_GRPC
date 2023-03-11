// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: scheduling.proto

package cv.scheduling;

public interface SchedulingRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:scheduling.SchedulingRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string course_id = 1;</code>
   */
  java.lang.String getCourseId();
  /**
   * <code>string course_id = 1;</code>
   */
  com.google.protobuf.ByteString
      getCourseIdBytes();

  /**
   * <code>string teacher_id = 2;</code>
   */
  java.lang.String getTeacherId();
  /**
   * <code>string teacher_id = 2;</code>
   */
  com.google.protobuf.ByteString
      getTeacherIdBytes();

  /**
   * <code>repeated string equipment = 3;</code>
   */
  java.util.List<java.lang.String>
      getEquipmentList();
  /**
   * <code>repeated string equipment = 3;</code>
   */
  int getEquipmentCount();
  /**
   * <code>repeated string equipment = 3;</code>
   */
  java.lang.String getEquipment(int index);
  /**
   * <code>repeated string equipment = 3;</code>
   */
  com.google.protobuf.ByteString
      getEquipmentBytes(int index);

  /**
   * <code>int32 num_students = 4;</code>
   */
  int getNumStudents();

  /**
   * <code>int64 start_time = 5;</code>
   */
  long getStartTime();

  /**
   * <code>int64 end_time = 6;</code>
   */
  long getEndTime();
}