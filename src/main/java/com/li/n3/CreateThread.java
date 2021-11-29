package com.li.n3;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@Slf4j(topic = "c.creat")
public class CreateThread {

    /**
     *     通过匿名内部类创建
     */
    @Test
    public void method_01(){
        Thread create = new Thread(){
            @Override
            public void run(){
                log.debug("通过匿名内部类创建的线程");
            }
        };
        log.debug("主线程");
        create.start();
    }

    /**
     * 使用Runnable配合Thread
     */
    @Test
    public void method_02(){
        Runnable runnable = () -> log.debug("使用Runnable创建的线程");
        Thread create = new Thread(runnable);
        create.start();
        log.debug("主线程");
    }


    /**
     * 通过重写Runnable接口创建线程
     */
    @Test
    public void method_03(){
        class createThread implements Runnable {
            @Override
            public void run() {
                log.debug("通过重写Runnable接口创建的线程");
            }
        }

        Thread create = new Thread(new createThread());
        create.start();
        log.debug("主线程");
    }

    @Test
    public void method_04() throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            log.debug("通过futureTask创建的线程");
            Thread.sleep(1000);
            return 100;
        });

        Thread create = new Thread(futureTask,"task");
        create.start();
        log.debug("主线程");
        log.debug("{}",futureTask.get());
    }
}
