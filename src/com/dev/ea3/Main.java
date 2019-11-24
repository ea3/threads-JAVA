package com.dev.ea3;

import static com.dev.ea3.ThreadColor.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Hello from the main thread");
        Thread anotherThread = new AnotherThread();
        anotherThread.start();


        new Thread(){
            public void run(){
                System.out.println(ANSI_GREEN + "Hello from the anonymous class");
            }
        }.start();
//        anotherThread.start();// Throws an exception.

        Thread myRunnableThread = new Thread(new MyRunnable(){
            @Override
            public void run() {
                System.out.println(ANSI_RED + "Hello from the anonymous class implementation of run()");
                try{
                    anotherThread.join(2000);
                    System.out.println(ANSI_RED + "Another thread terminated or timed out. I'm running again.");
                }catch(InterruptedException e){
                    System.out.println(ANSI_RED + "I could not wait after all. I was interrupted");
                }
            }
        });
        myRunnableThread.start();
//        anotherThread.interrupt();
        System.out.println(ANSI_PURPLE + "Hello again from the main thread");




    }
}
