package com.taykon.webserver.connections;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class readConnection {
    

    public readConnection(){

    }

    public void startServer(){

        try {
        
        
            ServerSocket mServer = new ServerSocket(999);
            Socket accepted = mServer.accept();
            InputStream incoming = accepted.getInputStream();
            DataInputStream listen = new DataInputStream(incoming);
            byte[] buffer = new byte[1024];
            while(true){

                if(!this.notifyState()){
                    break;
                }

                int bytesRead=listen.read(buffer);
                String data = new String(buffer, 0, bytesRead);
                System.out.println(data);

            }

            mServer.close();
        
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean notifyState(){

        serverState status = new serverState();
        Thread activeStatus = new Thread(status);
        activeStatus.start();

        if(status.getState().equalsIgnoreCase("STOP")){
            return false;
        }


        return true;

    }


}
