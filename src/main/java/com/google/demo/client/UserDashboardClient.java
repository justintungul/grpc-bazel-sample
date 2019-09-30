package com.google.demo.client;

import com.google.demo.proto.user.GetUserRequest;
import com.google.demo.proto.user.GetUserResponse;
import com.google.demo.proto.user.UserServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class UserDashboardClient {
  public static void main(String[] args) {
    int port = 8080;
    System.out.println("Establishing Client for Service at Port "+ port +"");

    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", port)
        .usePlaintext()
        .build();
    UserServiceGrpc.UserServiceBlockingStub userClient = UserServiceGrpc.newBlockingStub(channel);

    String userId = "123";
    System.out.println("Sending Request to server");
    GetUserResponse getUserResponse = userClient.getUser(
        GetUserRequest.newBuilder()
            .setId(userId)
            .build()
    );
    System.out.println("Received Response");
    System.out.println(getUserResponse.toString());
  }
}
