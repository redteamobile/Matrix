package com.redteamobile.matrix.pool;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;

/**
 * Created by yoruichi on 17/9/13.
 */
public class ChannelPoolFactory implements PooledObjectFactory<ManagedChannel> {

    private String host;
    private int port;

    public ChannelPoolFactory(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override public PooledObject<ManagedChannel> makeObject() throws Exception {
        final ManagedChannel channel = ManagedChannelBuilder
                .forAddress(host, port)
                .usePlaintext(true)
                .build();
        return new DefaultPooledObject<>(channel);
    }

    @Override public void destroyObject(PooledObject<ManagedChannel> p) throws Exception {
        ManagedChannel channel = p.getObject();
        channel.shutdownNow();
        while (channel.isShutdown()) channel = null;
    }

    @Override public boolean validateObject(PooledObject<ManagedChannel> p) {
        return !(p.getObject().isTerminated() || p.getObject().isShutdown());
    }

    @Override public void activateObject(PooledObject<ManagedChannel> p) throws Exception {

    }

    @Override public void passivateObject(PooledObject<ManagedChannel> p) throws Exception {

    }
}
