// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: course.proto

package edu.courseScheduling;

public interface AddCourseScheduleRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:AddCourseScheduleRequest)
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
   * <code>repeated string course_day_of_week = 2;</code>
   */
  java.util.List<java.lang.String>
      getCourseDayOfWeekList();
  /**
   * <code>repeated string course_day_of_week = 2;</code>
   */
  int getCourseDayOfWeekCount();
  /**
   * <code>repeated string course_day_of_week = 2;</code>
   */
  java.lang.String getCourseDayOfWeek(int index);
  /**
   * <code>repeated string course_day_of_week = 2;</code>
   */
  com.google.protobuf.ByteString
      getCourseDayOfWeekBytes(int index);
}
