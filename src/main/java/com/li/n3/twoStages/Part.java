package com.li.n3.twoStages;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

@Slf4j(topic = "c.part")
public class Part {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            log.debug("part.....");
            LockSupport.park();
            log.debug("unpart");
            log.debug("打断状态：{}",Thread.currentThread().isInterrupted());
        });
        t1.start();

        TimeUnit.SECONDS.sleep(1);
        t1.interrupt();
    }
}
