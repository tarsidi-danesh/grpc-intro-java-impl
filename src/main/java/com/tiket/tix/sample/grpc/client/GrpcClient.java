package com.tiket.tix.sample.grpc.client;

import com.github.tarsidi.danesh.grpc.proto.GreeterGrpc;
import com.github.tarsidi.danesh.grpc.proto.HelloWorld.HelloRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {

  public static void main(String[] args) {
    System.out.println("Hello I'm a gRPC client");

    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 60606)
        .usePlaintext().build();

    GreeterGrpc.GreeterBlockingStub client = GreeterGrpc.newBlockingStub(channel);
    var helloRequest = HelloRequest.newBuilder().setName("Tarsidi").build();

    var helloReply = client.sayHello(helloRequest);

    System.out.println(helloReply.getMessage());

    channel.shutdown();

  }

}
