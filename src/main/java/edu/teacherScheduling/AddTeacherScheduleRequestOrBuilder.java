// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: teacher.proto

package edu.teacherScheduling;

public interface AddTeacherScheduleRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:AddTeacherScheduleRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string teacher_id = 1;</code>
   */
  java.lang.String getTeacherId();
  /**
   * <code>string teacher_id = 1;</code>
   */
  com.google.protobuf.ByteString
      getTeacherIdBytes();

  /**
   * <code>repeated string course_ids = 2;</code>
   */
  java.util.List<java.lang.String>
      getCourseIdsList();
  /**
   * <code>repeated string course_ids = 2;</code>
   */
  int getCourseIdsCount();
  /**
   * <code>repeated string course_ids = 2;</code>
   */
  java.lang.String getCourseIds(int index);
  /**
   * <code>repeated string course_ids = 2;</code>
   */
  com.google.protobuf.ByteString
      getCourseIdsBytes(int index);
}
