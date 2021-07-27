package com.tiket.tix.sample.grpc.client;

import helloworld.GreeterGrpc;
import helloworld.HelloWorld.HelloReply;
import helloworld.HelloWorld.HelloRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {

  public static void main(String[] args) {
    System.out.println("Hello I'm a gRPC client");

    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 60606)
        .usePlaintext().build();

    GreeterGrpc.GreeterBlockingStub client = GreeterGrpc.newBlockingStub(channel);
    var helloRequest = HelloRequest.newBuilder().setName("Tarsidi").build();

    HelloReply helloReply = client.sayHello(helloRequest);

    System.out.println(helloReply.getMessage());

    channel.shutdown();

  }

}
