package com.redteamobile.matrix.service;

import com.google.common.util.concurrent.ListenableFuture;
import com.redteamobile.matrix.config.resource.CustomResource;
import com.redteamobile.matrix.pb.BundleDetail;
import com.redteamobile.matrix.pb.GagaProviderGrpc;
import com.redteamobile.matrix.pb.Reply2ListBundle;
import com.redteamobile.matrix.pb.Request2ListBundle;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yoruichi on 17/9/7.
 */
@Service
public class GagaProviderClient {
    @Autowired
    private CustomResource customResource;

    public Reply2ListBundle listBundle(String merchantCode) throws Exception {
        final ManagedChannel channel =
                ManagedChannelBuilder.forAddress("localhost", customResource.getGrpcPort())
                        .usePlaintext(true).build();
        final GagaProviderGrpc.GagaProviderFutureStub stub = GagaProviderGrpc.newFutureStub(channel);
        ListenableFuture<Reply2ListBundle>
                reply = stub.listBundle(Request2ListBundle.newBuilder().setMerchantCode(merchantCode).build());

        while (true)
            if (reply.isDone()) {
                return reply.get();
            }
    }
}
