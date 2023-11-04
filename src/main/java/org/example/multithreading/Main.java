/*
Пять безмолвных философов сидят вокруг круглого стола, перед каждым философом стоит тарелка спагетти.
Вилки лежат на столе между каждой парой ближайших философов.
Каждый философ может либо есть, либо размышлять.
Философ может есть только тогда, когда держит две вилки — взятую справа и слева.
Философ не может есть два раза подряд, не прервавшись на размышления (можно не учитывать)
Философ может взять только две вилки сразу, то есть обе вилки должны быть свободны
Описать в виде кода такую ситуацию. Каждый философ должен поесть три раза
*/

package org.example.multithreading;


public class Main {

    public static void main(String[] args) {
        Fork fork1 = new Fork(1);
        Fork fork2 = new Fork(2);
        Fork fork3 = new Fork(3);
        Fork fork4 = new Fork(4);
        Fork fork5 = new Fork(5);

        Philosophers ph1 = new Philosophers("1 филосов", fork1, fork2);
        ph1.start();
        Philosophers ph2 = new Philosophers("2 филосов", fork2, fork3);
        ph2.start();
        Philosophers ph3 = new Philosophers("3 филосов", fork3, fork4);
        ph3.start();
        Philosophers ph4 = new Philosophers("4 филосов", fork4, fork5);
        ph4.start();
        Philosophers ph5 = new Philosophers("5 филосов", fork5, fork1);
        ph5.start();

        new Thread(()->{
            while (true){
                if (!ph1.isAlive() && !ph2.isAlive() && !ph3.isAlive() && !ph4.isAlive() && !ph5.isAlive()){
                    System.out.println(ph1.getNamePhilosophers() + " поел " + ph1.getCnt() + " раз.");
                    System.out.println(ph2.getNamePhilosophers() + " поел " + ph2.getCnt() + " раз.");
                    System.out.println(ph3.getNamePhilosophers() + " поел " + ph3.getCnt() + " раз.");
                    System.out.println(ph4.getNamePhilosophers() + " поел " + ph4.getCnt() + " раз.");
                    System.out.println(ph5.getNamePhilosophers() + " поел " + ph5.getCnt() + " раз.");
                    return;
                }
            }
        }).start();
    }
}
