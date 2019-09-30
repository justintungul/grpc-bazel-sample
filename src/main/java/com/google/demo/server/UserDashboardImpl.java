package com.google.demo.server;

import com.google.demo.proto.user.UserPB;
import com.google.demo.proto.user.UserServiceGrpc.UserServiceImplBase;
import com.google.demo.proto.user.GetUserResponse;
import com.google.demo.proto.user.GetUserRequest;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

public class UserDashboardImpl extends UserServiceImplBase {

  @Override
  public void getUser(GetUserRequest request, StreamObserver<GetUserResponse> responseObserver) {
    System.out.println("Recevied get user request");
    String userId = request.getId();
    UserPB.Builder user = UserPB.newBuilder()
        .setId("123")
        .setFirstName("Justin")
        .setLastName("Tungul")
        .setEmail("justin.tungul@gmail.com")
        .setAuthorization(UserPB.Authorization.newBuilder()
            .setPassword("qweqwe")
            .build());
    if (userId.equals(user.getId())) {
      System.out.println("User found generating response");
      responseObserver.onNext(GetUserResponse.newBuilder().setUser(user).build());
      responseObserver.onCompleted();
    } else {
      System.out.println("ID does not exist");
      responseObserver.onError(Status.NOT_FOUND
      .withDescription("User with ID " + userId + " does not exist")
      .asRuntimeException());
    }
  }
}
