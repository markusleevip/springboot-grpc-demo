package com.mark.grpc.demo.server;

import com.mark.grpc.demo.server.grpc.config.GrpcLauncher;
import com.mark.grpc.demo.server.grpc.service.GrpcService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Map;

/**
 * @Author: Mark
 * @Date: 2022/4/8
 */
@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(ServerApplication.class,args);

        Map<String, Object> grpcServiceBeanMap =  configurableApplicationContext.getBeansWithAnnotation(GrpcService.class);
        GrpcLauncher grpcLauncher = configurableApplicationContext.getBean("grpcLauncher",GrpcLauncher.class);
        grpcLauncher.grpcStart(grpcServiceBeanMap);

    }
}
