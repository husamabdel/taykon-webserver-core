package com.taykon.webserver;

import com.taykon.webserver.connections.readConnection;

/**
 * Hello world!
 *
 */
public class App 
{

    static{
        testLogger();
    }

    public static void main( String[] args )
    {
        System.out.println( "Starting server:" );
    }

    public static void testLogger(){

        readConnection con = new readConnection();
        con.startServer();

    }
}
