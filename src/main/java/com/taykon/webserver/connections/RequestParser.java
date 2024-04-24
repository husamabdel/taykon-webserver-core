package com.taykon.webserver.connections;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Date;

import org.json.JSONObject;

public class RequestParser {

    private String Request;
    private String Response;
    private JSONObject RequestFetched;

    public RequestParser(String Request){
        this.Request=Request;
    }
    
    public byte[] InitResponseGzip(){
        return null; // Null as a placeholder only.
    }

    public String sampleResponse(){

        Date date = new Date();

        String SampleResp="HTTP/1.1 200 OK\nDate: "+date.toString()+"\nServer: Taykon\nContent-Type: text/html";
        String htmlSample="<!DOCTYPE html> <html><body><h1>Hello World!</h1></body></html>";

        return SampleResp+"\n\n"+htmlSample;
    }

    public void sampleWriterResponse(BufferedWriter writer){

        try {
            JSONObject responseJson = new JSONObject();
            String[] respArray = new String[]{"HTTP/1.1 200 OK\r\n",
                                            "Content-Type: text/plain; charset=utf-8\r\n",
                                            "Connection: close\r\n",
                                            "\n",
                                            "Hello World!\n"};
            System.out.println("Starting response...\n");
            for(String item : respArray){
                System.out.print(item);
                writer.write(item);
                writer.flush();
            }
            System.out.println("\nResponse concluded.");

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

}
