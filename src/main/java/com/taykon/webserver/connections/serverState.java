package com.taykon.webserver.connections;

import java.util.Scanner;

public class serverState implements Runnable{

    private volatile String State;

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    @Override
    public void run() {
        

        System.out.println("State:");
        Scanner input = new Scanner(System.in);

        State = input.nextLine();

        input.close();


        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }
    
    

}
