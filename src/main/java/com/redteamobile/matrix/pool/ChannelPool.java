package com.redteamobile.matrix.pool;

import io.grpc.ManagedChannel;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/**
 * Created by yoruichi on 17/9/13.
 */
public class ChannelPool extends GenericObjectPool<ManagedChannel> {
    public ChannelPool(PooledObjectFactory<ManagedChannel> factory,
            GenericObjectPoolConfig config) {
        super(factory, config);
    }
}
