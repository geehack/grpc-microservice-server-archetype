package com.geehack.grpcdemo.api;

import com.geehack.grpc.helloworld.GreeterGrpc;
import com.geehack.grpc.helloworld.HelloWorldProto;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;


@GRpcService
public class HelloworldService extends GreeterGrpc.GreeterImplBase {

    @Override
    public void sayHello(HelloWorldProto.HelloRequest request,
                         StreamObserver<HelloWorldProto.HelloReply> responseObserver){

        String msg = "Helloo:" + request.getName();

        final HelloWorldProto.HelloReply.Builder replyBuilder = HelloWorldProto.HelloReply.newBuilder().setMessage(msg);

        responseObserver.onNext(replyBuilder.build());
        responseObserver.onCompleted();

        System.out.println("Returning " +msg);
    }
}
