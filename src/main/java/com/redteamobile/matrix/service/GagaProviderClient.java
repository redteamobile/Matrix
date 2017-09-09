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
import java.util.concurrent.Executor;

/**
 * Created by yoruichi on 17/9/7.
 */
@Service
public class GagaProviderClient {
    @Autowired
    private CustomResource customResource;

    public Reply2ListBundle listBundle(String merchantCode) throws Exception {
        // 按照官方介绍，channel应该做成长连接，而不是每次使用时build一个，但官方没有提供连接池。
        final ManagedChannel channel =
                ManagedChannelBuilder.forAddress("localhost", customResource.getGrpcPort())
                        .usePlaintext(true).build();
        final GagaProviderGrpc.GagaProviderBlockingStub stub =
                GagaProviderGrpc.newBlockingStub(channel);
        //TODO check network exception
        Reply2ListBundle reply = stub.listBundle(
                Request2ListBundle.newBuilder().setMerchantCode(merchantCode).build());
        return reply;
//        final GagaProviderGrpc.GagaProviderFutureStub stub = GagaProviderGrpc.newFutureStub(channel);
//        ListenableFuture<Reply2ListBundle>
//                reply = stub.listBundle(Request2ListBundle.newBuilder().setMerchantCode(merchantCode).build());
//
//        //这种实现相当于是blocking stub
//        while (true)
//            if (reply.isDone()) {
//                return reply.get();
//            }
    }

    public ListenableFuture<Reply2ListBundle> listBundleAsnyc(String merchantCode)
            throws Exception {
        // 按照官方介绍，channel应该做成长连接，而不是每次使用时build一个，但官方没有提供连接池。
        final ManagedChannel channel =
                ManagedChannelBuilder.forAddress("localhost", customResource.getGrpcPort())
                        .usePlaintext(true).build();
        final GagaProviderGrpc.GagaProviderFutureStub stub =
                GagaProviderGrpc.newFutureStub(channel);
        return stub
                .listBundle(Request2ListBundle.newBuilder().setMerchantCode(merchantCode).build());
    }

}
