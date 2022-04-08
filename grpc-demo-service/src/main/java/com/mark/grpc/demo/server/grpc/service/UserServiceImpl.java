package com.mark.grpc.demo.server.grpc.service;

import com.mark.grpc.demo.provider.user.UserRequest;
import com.mark.grpc.demo.provider.user.UserResponse;
import com.mark.grpc.demo.provider.user.UserServiceGrpc;
import io.grpc.stub.StreamObserver;

/**
 * @Author: Mark
 * @Date: 2022/4/8
 */
@GrpcService
public class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase {
    @Override
    public void getUser(UserRequest request, StreamObserver<UserResponse> responseObserver) {
        System.out.println("Received parameter："+request.getUserName());
        UserResponse response = UserResponse.newBuilder().setUserId(1001).setUserName(request.getUserName()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
