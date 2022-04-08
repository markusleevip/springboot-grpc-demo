package com.mark.grpc.demo.web.config;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Mark
 * @Date: 2022/4/8
 */
@Component
public class GrpcClientManager {

    @Value("${grpc.client.host:localhost}")
    private String host;
    @Value("${grpc.client.port:9091}")
    private Integer port;

    public ManagedChannel getChannel() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .disableRetry()
                .idleTimeout(4, TimeUnit.SECONDS)
                .build();
        return channel;
    }
}
