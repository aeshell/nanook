package org.jboss.aesh.nanook;

import javax.ejb.Schedule;
import javax.ejb.Singleton;

@Singleton
public class NanookEJBTimer {
    
    @Schedule(second = "*/10", minute = "*", hour = "*", persistent = false)
    public void printTest() {
        System.out.println("test");
    }

}
