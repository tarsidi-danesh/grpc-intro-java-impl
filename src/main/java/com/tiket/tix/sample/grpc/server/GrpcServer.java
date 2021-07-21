package com.tiket.tix.sample.grpc.server;

import io.grpc.ServerBuilder;
import java.io.IOException;

public class GrpcServer {

  public static void main(String[] args) throws IOException, InterruptedException {
    System.out.println("Grpc Server is running");
    var server = ServerBuilder.forPort(60707)
        .addService(new GreeterServiceImpl())
        .build();
    server.start();

    Runtime.getRuntime().addShutdownHook(
        new Thread(() -> {
          System.out.println("Received Shutdown Request");
          server.shutdown();
          System.out.println("Successfully stopped the server");
        })
    );
    server.awaitTermination();

  }

}
