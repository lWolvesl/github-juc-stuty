package com.li.n3;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.supervisor")
public class SuperVisorThread {
    public static void main(String[] args) {
        new Thread(()->{
            while (true){
                log.debug("running");
            }
        },"t1").start();

        new Thread(()->{
            while (true){
                log.debug("running");
            }
        },"t2").start();
    }

}