package com.li.sleep;

import java.util.concurrent.TimeUnit;

/**
 * @author li
 */
public class Sleep {
    public static void sleep(int time){
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
