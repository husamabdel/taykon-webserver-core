package com.taykon.webserver.connections;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class readConnection {
    

    public readConnection(){

    }

    public void startServer(){

        try {
        
            System.out.println("Starting server....");
            @SuppressWarnings("resource")
            ServerSocket mServer = new ServerSocket(8993);
            System.out.println("Started Server on port: 8993\nListening to connections...");
            
            while(true){
                
                Socket accepted = mServer.accept();
                Thread connection=new Thread(() -> this.handleClient(accepted));
                connection.start();

            }

            
        
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean notifyState(){

        serverState status = new serverState();
        Thread activeStatus = new Thread(status);
        activeStatus.start();

        if(status.getState().equalsIgnoreCase("STOP")){
            System.out.println("Server state is STOP, turning off listening....");
            return true;
        } else{
            return false;
        }

    }

    public void handleClient(Socket ClientSocket){

        try {

            InputStream in;
            in = ClientSocket.getInputStream();
            DataInputStream dataIN = new DataInputStream(in);
            OutputStream out = ClientSocket.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            while(!ClientSocket.isClosed()){

                System.out.println("Connection started with client: "+ClientSocket.getRemoteSocketAddress().toString());

                byte []buffer = new byte[2048];
                int bytesRead = dataIN.read(buffer);
                String data = new String(buffer, 0, bytesRead);

                System.out.println("Request Data: \n"+data);

                RequestParser parser = new RequestParser(data);
                parser.sampleWriterResponse(writer);
                

            }
            ClientSocket.close();
            in.close();
            dataIN.close();
            out.flush();
            out.close();
            writer.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

    }

}