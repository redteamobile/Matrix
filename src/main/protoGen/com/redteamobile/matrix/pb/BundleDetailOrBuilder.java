// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Demo.proto

package com.redteamobile.matrix.pb;

public interface BundleDetailOrBuilder extends
    // @@protoc_insertion_point(interface_extends:BundleDetail)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional int32 id = 1;</code>
   */
  int getId();

  /**
   * <code>optional string type = 2;</code>
   */
  java.lang.String getType();
  /**
   * <code>optional string type = 2;</code>
   */
  com.google.protobuf.ByteString
      getTypeBytes();

  /**
   * <code>optional .BundleDetail.BundleStatus status = 3;</code>
   */
  int getStatusValue();
  /**
   * <code>optional .BundleDetail.BundleStatus status = 3;</code>
   */
  com.redteamobile.matrix.pb.BundleDetail.BundleStatus getStatus();

  /**
   * <code>optional string location = 4;</code>
   */
  java.lang.String getLocation();
  /**
   * <code>optional string location = 4;</code>
   */
  com.google.protobuf.ByteString
      getLocationBytes();

  /**
   * <code>optional int32 data_volume = 5;</code>
   */
  int getDataVolume();

  /**
   * <code>optional int32 daily_limit = 6;</code>
   */
  int getDailyLimit();

  /**
   * <code>optional int32 duration = 7;</code>
   */
  int getDuration();

  /**
   * <code>optional int32 get_resource_method = 8;</code>
   */
  int getGetResourceMethod();

  /**
   * <code>optional .BundleDetail.Network network = 9;</code>
   */
  boolean hasNetwork();
  /**
   * <code>optional .BundleDetail.Network network = 9;</code>
   */
  com.redteamobile.matrix.pb.BundleDetail.Network getNetwork();
  /**
   * <code>optional .BundleDetail.Network network = 9;</code>
   */
  com.redteamobile.matrix.pb.BundleDetail.NetworkOrBuilder getNetworkOrBuilder();
}