package com.google.demo.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class UserDashboard {
  public static void main(String[] args) throws IOException, InterruptedException {
    System.out.println("---- Java Server using Grpc ----");
    // Create the server.
    int port = 8080;
    Server server = ServerBuilder.forPort(port)
        .addService(new UserDashboardImpl())
        .build();
    // Starting the server.
    System.out.println("listening at port: " + port);
    server.start();
    // Stopping the server.
    Runtime.getRuntime().addShutdownHook(new Thread( () -> {
      System.out.println("Received Shutdown Request");
      server.shutdown();
      System.out.println("Successfully Stopped the Server");
    } ));
    // in gRPC this server needs to be blocking to the main thread
    server.awaitTermination();
  }
}
