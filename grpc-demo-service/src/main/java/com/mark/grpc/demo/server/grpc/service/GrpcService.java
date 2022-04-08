package com.mark.grpc.demo.server.grpc.service;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @Author: Mark
 * @Date: 2022/4/8
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface GrpcService {
}
