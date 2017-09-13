package com.redteamobile.matrix.service;

import com.google.common.util.concurrent.ListenableFuture;
import com.redteamobile.matrix.pb.GagaProviderGrpc;
import com.redteamobile.matrix.pb.Reply2ListBundle;
import com.redteamobile.matrix.pb.Request2ListBundle;
import com.redteamobile.matrix.pool.ChannelPool;
import io.grpc.ManagedChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yoruichi on 17/9/7.
 */
@Service
public class GagaProviderClient {
    @Autowired
    private ChannelPool channelPool;

    public Reply2ListBundle listBundle(String merchantCode) throws Exception {
        ManagedChannel channel = null;
        try {
            channel = channelPool.borrowObject();
            System.out.println(channel.hashCode());
            if (channel == null) throw new RuntimeException("No valid channel.");
            final GagaProviderGrpc.GagaProviderBlockingStub stub =
                    GagaProviderGrpc.newBlockingStub(channel);
            //TODO check network exception
            Reply2ListBundle reply = stub.listBundle(
                    Request2ListBundle.newBuilder().setMerchantCode(merchantCode).build());
            return reply;
        } finally {
            if (channel != null)
                channelPool.returnObject(channel);
        }
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
        ManagedChannel channel = null;
        try {
            channel = channelPool.borrowObject();
            System.out.println(channel.hashCode());
            if (channel == null) throw new RuntimeException("No valid channel.");
            final GagaProviderGrpc.GagaProviderFutureStub stub =
                    GagaProviderGrpc.newFutureStub(channel);
            return stub
                    .listBundle(
                            Request2ListBundle.newBuilder().setMerchantCode(merchantCode).build());
        } finally {
            if (channel != null)
                channelPool.returnObject(channel);
        }
    }

}
