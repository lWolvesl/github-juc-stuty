package com.li.n3.twoStages;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.inter")
public class inter {
    public static void main(String[] args) throws InterruptedException {
        TwoPhaseTermination two = new TwoPhaseTermination();
        two.start();

        TimeUnit.SECONDS.sleep(5);
        two.stop();
    }
}


@Slf4j(topic = "c.two")
class TwoPhaseTermination{
    private Thread monitor;

    /**
     * 启动监控线程
     */
    public void start(){
        monitor = new Thread(()->{
            while (true){
                Thread current = Thread.currentThread();
                if (current.isInterrupted()){
                    log.debug("料理后事");
                    break;
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                    log.debug("监控记录");
                } catch (InterruptedException e) {
                    e.printStackTrace();

                    //sleep会重置打断标记
                    current.interrupt();
                }
            }
        });
        monitor.start();
    }
    /**
     * 终止监控线程
     */
    public void stop(){
        monitor.interrupt();
    }
}
