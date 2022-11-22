package SumServer;

import io.grpc.stub.StreamObserver;
import com.proto.sum.*;

public class SumServiceImpl extends SumServiceGrpc.SumServiceImplBase{
    @Override
    public void sum(SumRequest request, StreamObserver<SumResponse> responseObserver){
        Sum suming = request.getSum();
        int num1 = suming.getNum1();
        int num2 = suming.getNum2();

        String result = (num1+num2) + "";
        SumResponse response = SumResponse.newBuilder()
                .setResult(result)
                .build();

        String output = "Server Output : " + num1 + " + " + num2 + " = " + (num1+num2);
        System.out.println(output);
        responseObserver.onNext(response);

        responseObserver.onCompleted();

    }
}
