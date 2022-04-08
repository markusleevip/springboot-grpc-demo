package com.mark.grpc.demo.web.controller;

import com.mark.grpc.demo.provider.user.UserRequest;
import com.mark.grpc.demo.provider.user.UserResponse;
import com.mark.grpc.demo.provider.user.UserServiceGrpc;
import com.mark.grpc.demo.web.config.GrpcClientManager;
import io.grpc.ManagedChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Mark
 * @Date: 2022/4/8
 */
@RestController
@RequestMapping(value = "/user")

public class UserController {

    @Autowired
    private GrpcClientManager grpcClientManager;

    @GetMapping("/getUser")
    public String getUser(@RequestParam("userName") String userName){
        ManagedChannel channel = grpcClientManager.getChannel();
        UserRequest request = UserRequest.newBuilder().setUserName(userName).build();
        UserServiceGrpc.UserServiceBlockingStub stub = UserServiceGrpc.newBlockingStub(channel);
        UserResponse response = stub.getUser(request);
        return response.getUserId()+""+response.getUserName();

    }
}
