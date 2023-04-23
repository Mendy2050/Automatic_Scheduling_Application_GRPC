// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: teacher.proto

package edu.teacherScheduling;

/**
 * Protobuf type {@code UpdateTeacherScheduleResponse}
 */
public  final class UpdateTeacherScheduleResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:UpdateTeacherScheduleResponse)
    UpdateTeacherScheduleResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use UpdateTeacherScheduleResponse.newBuilder() to construct.
  private UpdateTeacherScheduleResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private UpdateTeacherScheduleResponse() {
    teachingItem_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private UpdateTeacherScheduleResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              teachingItem_ = new java.util.ArrayList<edu.teacherScheduling.TeachingItem>();
              mutable_bitField0_ |= 0x00000001;
            }
            teachingItem_.add(
                input.readMessage(edu.teacherScheduling.TeachingItem.parser(), extensionRegistry));
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
        teachingItem_ = java.util.Collections.unmodifiableList(teachingItem_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return edu.teacherScheduling.TeacherSchedulingServiceImpl.internal_static_UpdateTeacherScheduleResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return edu.teacherScheduling.TeacherSchedulingServiceImpl.internal_static_UpdateTeacherScheduleResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            edu.teacherScheduling.UpdateTeacherScheduleResponse.class, edu.teacherScheduling.UpdateTeacherScheduleResponse.Builder.class);
  }

  public static final int TEACHING_ITEM_FIELD_NUMBER = 1;
  private java.util.List<edu.teacherScheduling.TeachingItem> teachingItem_;
  /**
   * <code>repeated .TeachingItem teaching_item = 1;</code>
   */
  public java.util.List<edu.teacherScheduling.TeachingItem> getTeachingItemList() {
    return teachingItem_;
  }
  /**
   * <code>repeated .TeachingItem teaching_item = 1;</code>
   */
  public java.util.List<? extends edu.teacherScheduling.TeachingItemOrBuilder> 
      getTeachingItemOrBuilderList() {
    return teachingItem_;
  }
  /**
   * <code>repeated .TeachingItem teaching_item = 1;</code>
   */
  public int getTeachingItemCount() {
    return teachingItem_.size();
  }
  /**
   * <code>repeated .TeachingItem teaching_item = 1;</code>
   */
  public edu.teacherScheduling.TeachingItem getTeachingItem(int index) {
    return teachingItem_.get(index);
  }
  /**
   * <code>repeated .TeachingItem teaching_item = 1;</code>
   */
  public edu.teacherScheduling.TeachingItemOrBuilder getTeachingItemOrBuilder(
      int index) {
    return teachingItem_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < teachingItem_.size(); i++) {
      output.writeMessage(1, teachingItem_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < teachingItem_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, teachingItem_.get(i));
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof edu.teacherScheduling.UpdateTeacherScheduleResponse)) {
      return super.equals(obj);
    }
    edu.teacherScheduling.UpdateTeacherScheduleResponse other = (edu.teacherScheduling.UpdateTeacherScheduleResponse) obj;

    boolean result = true;
    result = result && getTeachingItemList()
        .equals(other.getTeachingItemList());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getTeachingItemCount() > 0) {
      hash = (37 * hash) + TEACHING_ITEM_FIELD_NUMBER;
      hash = (53 * hash) + getTeachingItemList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static edu.teacherScheduling.UpdateTeacherScheduleResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static edu.teacherScheduling.UpdateTeacherScheduleResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static edu.teacherScheduling.UpdateTeacherScheduleResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static edu.teacherScheduling.UpdateTeacherScheduleResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static edu.teacherScheduling.UpdateTeacherScheduleResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static edu.teacherScheduling.UpdateTeacherScheduleResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static edu.teacherScheduling.UpdateTeacherScheduleResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static edu.teacherScheduling.UpdateTeacherScheduleResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static edu.teacherScheduling.UpdateTeacherScheduleResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static edu.teacherScheduling.UpdateTeacherScheduleResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static edu.teacherScheduling.UpdateTeacherScheduleResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static edu.teacherScheduling.UpdateTeacherScheduleResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(edu.teacherScheduling.UpdateTeacherScheduleResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code UpdateTeacherScheduleResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:UpdateTeacherScheduleResponse)
      edu.teacherScheduling.UpdateTeacherScheduleResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return edu.teacherScheduling.TeacherSchedulingServiceImpl.internal_static_UpdateTeacherScheduleResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return edu.teacherScheduling.TeacherSchedulingServiceImpl.internal_static_UpdateTeacherScheduleResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              edu.teacherScheduling.UpdateTeacherScheduleResponse.class, edu.teacherScheduling.UpdateTeacherScheduleResponse.Builder.class);
    }

    // Construct using edu.teacherScheduling.UpdateTeacherScheduleResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getTeachingItemFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (teachingItemBuilder_ == null) {
        teachingItem_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        teachingItemBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return edu.teacherScheduling.TeacherSchedulingServiceImpl.internal_static_UpdateTeacherScheduleResponse_descriptor;
    }

    @java.lang.Override
    public edu.teacherScheduling.UpdateTeacherScheduleResponse getDefaultInstanceForType() {
      return edu.teacherScheduling.UpdateTeacherScheduleResponse.getDefaultInstance();
    }

    @java.lang.Override
    public edu.teacherScheduling.UpdateTeacherScheduleResponse build() {
      edu.teacherScheduling.UpdateTeacherScheduleResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public edu.teacherScheduling.UpdateTeacherScheduleResponse buildPartial() {
      edu.teacherScheduling.UpdateTeacherScheduleResponse result = new edu.teacherScheduling.UpdateTeacherScheduleResponse(this);
      int from_bitField0_ = bitField0_;
      if (teachingItemBuilder_ == null) {
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
          teachingItem_ = java.util.Collections.unmodifiableList(teachingItem_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.teachingItem_ = teachingItem_;
      } else {
        result.teachingItem_ = teachingItemBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof edu.teacherScheduling.UpdateTeacherScheduleResponse) {
        return mergeFrom((edu.teacherScheduling.UpdateTeacherScheduleResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(edu.teacherScheduling.UpdateTeacherScheduleResponse other) {
      if (other == edu.teacherScheduling.UpdateTeacherScheduleResponse.getDefaultInstance()) return this;
      if (teachingItemBuilder_ == null) {
        if (!other.teachingItem_.isEmpty()) {
          if (teachingItem_.isEmpty()) {
            teachingItem_ = other.teachingItem_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureTeachingItemIsMutable();
            teachingItem_.addAll(other.teachingItem_);
          }
          onChanged();
        }
      } else {
        if (!other.teachingItem_.isEmpty()) {
          if (teachingItemBuilder_.isEmpty()) {
            teachingItemBuilder_.dispose();
            teachingItemBuilder_ = null;
            teachingItem_ = other.teachingItem_;
            bitField0_ = (bitField0_ & ~0x00000001);
            teachingItemBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getTeachingItemFieldBuilder() : null;
          } else {
            teachingItemBuilder_.addAllMessages(other.teachingItem_);
          }
        }
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      edu.teacherScheduling.UpdateTeacherScheduleResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (edu.teacherScheduling.UpdateTeacherScheduleResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<edu.teacherScheduling.TeachingItem> teachingItem_ =
      java.util.Collections.emptyList();
    private void ensureTeachingItemIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        teachingItem_ = new java.util.ArrayList<edu.teacherScheduling.TeachingItem>(teachingItem_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        edu.teacherScheduling.TeachingItem, edu.teacherScheduling.TeachingItem.Builder, edu.teacherScheduling.TeachingItemOrBuilder> teachingItemBuilder_;

    /**
     * <code>repeated .TeachingItem teaching_item = 1;</code>
     */
    public java.util.List<edu.teacherScheduling.TeachingItem> getTeachingItemList() {
      if (teachingItemBuilder_ == null) {
        return java.util.Collections.unmodifiableList(teachingItem_);
      } else {
        return teachingItemBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .TeachingItem teaching_item = 1;</code>
     */
    public int getTeachingItemCount() {
      if (teachingItemBuilder_ == null) {
        return teachingItem_.size();
      } else {
        return teachingItemBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .TeachingItem teaching_item = 1;</code>
     */
    public edu.teacherScheduling.TeachingItem getTeachingItem(int index) {
      if (teachingItemBuilder_ == null) {
        return teachingItem_.get(index);
      } else {
        return teachingItemBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .TeachingItem teaching_item = 1;</code>
     */
    public Builder setTeachingItem(
        int index, edu.teacherScheduling.TeachingItem value) {
      if (teachingItemBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureTeachingItemIsMutable();
        teachingItem_.set(index, value);
        onChanged();
      } else {
        teachingItemBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .TeachingItem teaching_item = 1;</code>
     */
    public Builder setTeachingItem(
        int index, edu.teacherScheduling.TeachingItem.Builder builderForValue) {
      if (teachingItemBuilder_ == null) {
        ensureTeachingItemIsMutable();
        teachingItem_.set(index, builderForValue.build());
        onChanged();
      } else {
        teachingItemBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .TeachingItem teaching_item = 1;</code>
     */
    public Builder addTeachingItem(edu.teacherScheduling.TeachingItem value) {
      if (teachingItemBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureTeachingItemIsMutable();
        teachingItem_.add(value);
        onChanged();
      } else {
        teachingItemBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .TeachingItem teaching_item = 1;</code>
     */
    public Builder addTeachingItem(
        int index, edu.teacherScheduling.TeachingItem value) {
      if (teachingItemBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureTeachingItemIsMutable();
        teachingItem_.add(index, value);
        onChanged();
      } else {
        teachingItemBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .TeachingItem teaching_item = 1;</code>
     */
    public Builder addTeachingItem(
        edu.teacherScheduling.TeachingItem.Builder builderForValue) {
      if (teachingItemBuilder_ == null) {
        ensureTeachingItemIsMutable();
        teachingItem_.add(builderForValue.build());
        onChanged();
      } else {
        teachingItemBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .TeachingItem teaching_item = 1;</code>
     */
    public Builder addTeachingItem(
        int index, edu.teacherScheduling.TeachingItem.Builder builderForValue) {
      if (teachingItemBuilder_ == null) {
        ensureTeachingItemIsMutable();
        teachingItem_.add(index, builderForValue.build());
        onChanged();
      } else {
        teachingItemBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .TeachingItem teaching_item = 1;</code>
     */
    public Builder addAllTeachingItem(
        java.lang.Iterable<? extends edu.teacherScheduling.TeachingItem> values) {
      if (teachingItemBuilder_ == null) {
        ensureTeachingItemIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, teachingItem_);
        onChanged();
      } else {
        teachingItemBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .TeachingItem teaching_item = 1;</code>
     */
    public Builder clearTeachingItem() {
      if (teachingItemBuilder_ == null) {
        teachingItem_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        teachingItemBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .TeachingItem teaching_item = 1;</code>
     */
    public Builder removeTeachingItem(int index) {
      if (teachingItemBuilder_ == null) {
        ensureTeachingItemIsMutable();
        teachingItem_.remove(index);
        onChanged();
      } else {
        teachingItemBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .TeachingItem teaching_item = 1;</code>
     */
    public edu.teacherScheduling.TeachingItem.Builder getTeachingItemBuilder(
        int index) {
      return getTeachingItemFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .TeachingItem teaching_item = 1;</code>
     */
    public edu.teacherScheduling.TeachingItemOrBuilder getTeachingItemOrBuilder(
        int index) {
      if (teachingItemBuilder_ == null) {
        return teachingItem_.get(index);  } else {
        return teachingItemBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .TeachingItem teaching_item = 1;</code>
     */
    public java.util.List<? extends edu.teacherScheduling.TeachingItemOrBuilder> 
         getTeachingItemOrBuilderList() {
      if (teachingItemBuilder_ != null) {
        return teachingItemBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(teachingItem_);
      }
    }
    /**
     * <code>repeated .TeachingItem teaching_item = 1;</code>
     */
    public edu.teacherScheduling.TeachingItem.Builder addTeachingItemBuilder() {
      return getTeachingItemFieldBuilder().addBuilder(
          edu.teacherScheduling.TeachingItem.getDefaultInstance());
    }
    /**
     * <code>repeated .TeachingItem teaching_item = 1;</code>
     */
    public edu.teacherScheduling.TeachingItem.Builder addTeachingItemBuilder(
        int index) {
      return getTeachingItemFieldBuilder().addBuilder(
          index, edu.teacherScheduling.TeachingItem.getDefaultInstance());
    }
    /**
     * <code>repeated .TeachingItem teaching_item = 1;</code>
     */
    public java.util.List<edu.teacherScheduling.TeachingItem.Builder> 
         getTeachingItemBuilderList() {
      return getTeachingItemFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        edu.teacherScheduling.TeachingItem, edu.teacherScheduling.TeachingItem.Builder, edu.teacherScheduling.TeachingItemOrBuilder> 
        getTeachingItemFieldBuilder() {
      if (teachingItemBuilder_ == null) {
        teachingItemBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            edu.teacherScheduling.TeachingItem, edu.teacherScheduling.TeachingItem.Builder, edu.teacherScheduling.TeachingItemOrBuilder>(
                teachingItem_,
                ((bitField0_ & 0x00000001) == 0x00000001),
                getParentForChildren(),
                isClean());
        teachingItem_ = null;
      }
      return teachingItemBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:UpdateTeacherScheduleResponse)
  }

  // @@protoc_insertion_point(class_scope:UpdateTeacherScheduleResponse)
  private static final edu.teacherScheduling.UpdateTeacherScheduleResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new edu.teacherScheduling.UpdateTeacherScheduleResponse();
  }

  public static edu.teacherScheduling.UpdateTeacherScheduleResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<UpdateTeacherScheduleResponse>
      PARSER = new com.google.protobuf.AbstractParser<UpdateTeacherScheduleResponse>() {
    @java.lang.Override
    public UpdateTeacherScheduleResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new UpdateTeacherScheduleResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<UpdateTeacherScheduleResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<UpdateTeacherScheduleResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public edu.teacherScheduling.UpdateTeacherScheduleResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
