package com.soap.client;


import org.apache.soap.Constants;
import org.apache.soap.Fault;

import org.apache.soap.rpc.Call;
import org.apache.soap.rpc.Parameter;
import org.apache.soap.rpc.Response;

import java.net.URL;

/**
 * Created by Brian in 21:38 2018/5/13
 */
public class HelloWorldClient {
    public static void main(String[] args) throws Exception {
        String endpoint = "http://localhost:8088/soap/servlet/rpcrouter";

        Call call  = new Call();

        // 远程服务名
        call.setTargetObjectURI("urn:HelloWorldService");
        // 访问方法
        call.setMethodName("getMessage");
        // 设置编码风格
        call.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);


        // SOAP 服务的网址
        URL url = new URL(endpoint);

        // 开始发送RPC请求，并返回server端的响应
        Response res = call.invoke(url,"");

        if(res.generatedFault()){
            Fault fault = res.getFault();
            System.out.print("The following error occured: ");
            System.out.println(" Fault code = "+fault.getFaultCode());
            System.out.print(" Fault String = "+fault.getFaultString());
        }else {
            Parameter result = res.getReturnValue();
            System.out.println(result.getValue());
        }
    }
}
