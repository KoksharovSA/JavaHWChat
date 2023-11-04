package org.example.multithreading;

import java.util.Random;

public class Philosophers extends Thread{
    private final int CNT_FINAL = 3;
    private int cnt;
    private boolean isEats;
    private final String name;
    private final Random random;
    private Fork leftFork;
    private Fork rightFork;

    public Philosophers(String name, Fork leftFork, Fork rightFork) {
        random = new Random();
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.cnt = 0;
    }

    public int getCnt() {
        return cnt;
    }

    @Override
    public void run() {
        while (cnt < CNT_FINAL){
            if (isEats){
                try {
                    think();
                    isEats = false;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                synchronized (leftFork){
                    synchronized (rightFork){
                        try {
                            cnt++;
                            eat();
                            isEats = true;
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }

    public String getNamePhilosophers() {
        return name;
    }

    public void eat() throws InterruptedException {
        System.out.println("Филосов " + name + " начал есть " + cnt + " раз.");
        Thread.sleep(random.nextInt(2,5)*100L);
        System.out.println("Филосов " + name + " закончил есть.");
    }
    public void think() throws InterruptedException {
        System.out.println("Филосов " + name + " начал думать.");
        Thread.sleep(random.nextInt(2,5)*100L);
        System.out.println("Филосов " + name + " закончил думать.");
    }
}
