package com.taykon.webserver;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.taykon.webserver.connections.readConnection;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void startServer(){
        new readConnection().startServer();
    }
}
