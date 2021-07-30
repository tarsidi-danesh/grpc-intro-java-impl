package com.tiket.tix.sample.grpc.server;


import com.github.tarsidi.danesh.grpc.proto.GreeterGrpc.GreeterImplBase;
import com.github.tarsidi.danesh.grpc.proto.HelloWorld.HelloReply;
import com.github.tarsidi.danesh.grpc.proto.HelloWorld.HelloRequest;
import io.grpc.stub.StreamObserver;

public class GreeterServiceImpl extends GreeterImplBase {

  @Override
  public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
    System.out.println("receiving request: " + request.getName() + ":" + request.getAddress());
    String responseMessage = "Hello " + request.getName() + " from " + request.getAddress();
    HelloReply response = HelloReply.newBuilder().setMessage(responseMessage).build();
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
}
