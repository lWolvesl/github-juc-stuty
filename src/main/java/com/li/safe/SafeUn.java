package com.li.safe;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j(topic = "c.unsafe")
public class SafeUn {
    int count = 0;
    @Test
    public void test01() throws InterruptedException {
        Thread t1 = new Thread(()->{
            for (int i = 0;i<5000;i++){
                count++;
            }
        },"t1");
        Thread t2 = new Thread(()->{
            for (int i = 0;i<5000;i++){
                count--;
            }
        },"t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        log.debug("{}",count);
    }
}
