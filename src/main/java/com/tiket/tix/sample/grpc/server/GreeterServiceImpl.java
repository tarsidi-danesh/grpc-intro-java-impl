package com.tiket.tix.sample.grpc.server;

import helloworld.GreeterGrpc.GreeterImplBase;
import helloworld.HelloWorld.HelloReply;
import helloworld.HelloWorld.HelloRequest;
import io.grpc.stub.StreamObserver;

public class GreeterServiceImpl extends GreeterImplBase {

  @Override
  public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
    String requestName = request.getName();
    HelloReply response = HelloReply.newBuilder().setMessage("Hello " + requestName).build();
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
}
