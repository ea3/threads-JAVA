package com.dev.ea3;

import java.sql.SQLOutput;

import static com.dev.ea3.ThreadColor.ANSI_RED;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(ANSI_RED + "Hello from my Myrunnable's implementation of run()");
    }
}
