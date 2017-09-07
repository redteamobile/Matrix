package com.redteamobile.matrix.pb;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 * <pre>
 * Gaga service provider
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.5.0)",
    comments = "Source: Demo.proto")
public final class GagaProviderGrpc {

  private GagaProviderGrpc() {}

  public static final String SERVICE_NAME = "GagaProvider";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.redteamobile.matrix.pb.Request2ListBundle,
      com.redteamobile.matrix.pb.Reply2ListBundle> METHOD_LIST_BUNDLE =
      io.grpc.MethodDescriptor.<com.redteamobile.matrix.pb.Request2ListBundle, com.redteamobile.matrix.pb.Reply2ListBundle>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "GagaProvider", "ListBundle"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.redteamobile.matrix.pb.Request2ListBundle.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.redteamobile.matrix.pb.Reply2ListBundle.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GagaProviderStub newStub(io.grpc.Channel channel) {
    return new GagaProviderStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GagaProviderBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new GagaProviderBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GagaProviderFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new GagaProviderFutureStub(channel);
  }

  /**
   * <pre>
   * Gaga service provider
   * </pre>
   */
  public static abstract class GagaProviderImplBase implements io.grpc.BindableService {

    /**
     */
    public void listBundle(com.redteamobile.matrix.pb.Request2ListBundle request,
        io.grpc.stub.StreamObserver<com.redteamobile.matrix.pb.Reply2ListBundle> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LIST_BUNDLE, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_LIST_BUNDLE,
            asyncUnaryCall(
              new MethodHandlers<
                com.redteamobile.matrix.pb.Request2ListBundle,
                com.redteamobile.matrix.pb.Reply2ListBundle>(
                  this, METHODID_LIST_BUNDLE)))
          .build();
    }
  }

  /**
   * <pre>
   * Gaga service provider
   * </pre>
   */
  public static final class GagaProviderStub extends io.grpc.stub.AbstractStub<GagaProviderStub> {
    private GagaProviderStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GagaProviderStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GagaProviderStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GagaProviderStub(channel, callOptions);
    }

    /**
     */
    public void listBundle(com.redteamobile.matrix.pb.Request2ListBundle request,
        io.grpc.stub.StreamObserver<com.redteamobile.matrix.pb.Reply2ListBundle> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LIST_BUNDLE, getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Gaga service provider
   * </pre>
   */
  public static final class GagaProviderBlockingStub extends io.grpc.stub.AbstractStub<GagaProviderBlockingStub> {
    private GagaProviderBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GagaProviderBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GagaProviderBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GagaProviderBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.redteamobile.matrix.pb.Reply2ListBundle listBundle(com.redteamobile.matrix.pb.Request2ListBundle request) {
      return blockingUnaryCall(
          getChannel(), METHOD_LIST_BUNDLE, getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Gaga service provider
   * </pre>
   */
  public static final class GagaProviderFutureStub extends io.grpc.stub.AbstractStub<GagaProviderFutureStub> {
    private GagaProviderFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GagaProviderFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GagaProviderFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GagaProviderFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.redteamobile.matrix.pb.Reply2ListBundle> listBundle(
        com.redteamobile.matrix.pb.Request2ListBundle request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LIST_BUNDLE, getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_BUNDLE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GagaProviderImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GagaProviderImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_BUNDLE:
          serviceImpl.listBundle((com.redteamobile.matrix.pb.Request2ListBundle) request,
              (io.grpc.stub.StreamObserver<com.redteamobile.matrix.pb.Reply2ListBundle>) responseObserver);
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

  private static final class GagaProviderDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.redteamobile.matrix.pb.Demo.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (GagaProviderGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GagaProviderDescriptorSupplier())
              .addMethod(METHOD_LIST_BUNDLE)
              .build();
        }
      }
    }
    return result;
  }
}
