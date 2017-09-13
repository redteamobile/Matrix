package com.redteamobile.matrix.pool;

import com.redteamobile.matrix.config.resource.CustomResource;
import io.grpc.ManagedChannel;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yoruichi on 17/9/13.
 */
@Configuration
public class ManagedChannelPoolConfig {
    @Autowired
    private CustomResource customResource;

    @Bean
    public ChannelPool pool() {
        ChannelPoolFactory factory =
                new ChannelPoolFactory(customResource.getGrpcHost(), customResource.getGrpcPort());
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setTestOnBorrow(true);
        config.setTestOnCreate(true);
        config.setTestOnReturn(true);
        config.setLifo(true);
        config.setJmxEnabled(false);

        return new ChannelPool(factory, config);
    }
}
