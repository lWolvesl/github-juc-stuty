package com.li.n3;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.join")
public class TestJoin {
    static int r = 0;
    public static void main(String[] args) throws InterruptedException {
        log.debug("开始");
        Thread t1 = new Thread(()->{
            log.debug("开始");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            r = 10;
            log.debug("结束");
        },"t1");
        t1.start();
        t1.join();
        log.debug("结果为{}",r);
        log.debug("结束");
    }
}
