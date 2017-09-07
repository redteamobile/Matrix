package com.redteamobile.matrix.service;

import com.redteamobile.matrix.pb.GagaProviderGrpc;
import com.redteamobile.matrix.pb.Reply2ListBundle;
import com.redteamobile.matrix.pb.Request2ListBundle;
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
        final Reply2ListBundle.Builder replyBuilder =
                Reply2ListBundle.newBuilder().setSuccess(true);
        responseObserver.onNext(replyBuilder.build());
        responseObserver.onCompleted();
    }
}
