package com.heiha.sinfonia.example.examples.schedule;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * <br>
 * <b>Project:</b> example<br>
 * <b>Date:</b> 2017/8/22 11:51<br>
 * <b>Author:</b> heiha<br>
 */
public class ScheduleExample {
    public static void timer() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName().concat(": [Timer-1]"));
            }
        }, 10 * 1000, 5 * 1000);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName().concat(": [Timer-2]"));
            }
        }, 10 * 1000, 5 * 1000);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName().concat(": [Timer-3]"));
            }
        }, 10 * 1000, 5 * 1000);
    }

    public static void executor() {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
        service.scheduleAtFixedRate(() -> {
            System.out.println(Thread.currentThread().getName().concat(": [ScheduledExecutorService-1]"));
        }, 10, 5, TimeUnit.SECONDS);
        service.scheduleAtFixedRate(() -> {
            System.out.println(Thread.currentThread().getName().concat(": [ScheduledExecutorService-2]"));
        }, 10, 5, TimeUnit.SECONDS);
        service.scheduleAtFixedRate(() -> {
            System.out.println(Thread.currentThread().getName().concat(": [ScheduledExecutorService-3]"));
        }, 10, 5, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        ScheduleExample.timer();
        ScheduleExample.executor();
    }
}
