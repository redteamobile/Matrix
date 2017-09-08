package com.redteamobile.matrix.service;

import com.redteamobile.matrix.pb.*;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

/**
 * Created by yoruichi on 17/9/7.
 */
@GRpcService
public class GagaProviderService extends GagaProviderGrpc.GagaProviderImplBase {
    @Override
    public void listBundle(Request2ListBundle request,
            StreamObserver<Reply2ListBundle> responseObserver) {
        BundleDetail.Network network =
                BundleDetail.Network.newBuilder().addMcc("460").addPlmn("460001").build();
        BundleDetail bundle = BundleDetail.newBuilder().setNetwork(network).build();
        final Reply2ListBundle.Builder replyBuilder =
                Reply2ListBundle.newBuilder().setSuccess(true).addBundles(bundle);
        responseObserver.onNext(replyBuilder.build());
        responseObserver.onCompleted();
    }
}
