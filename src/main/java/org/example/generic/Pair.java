/*
Напишите обобщенный класс Pair, который представляет собой пару значений разного типа. Класс должен
иметь методы getFirst(), getSecond() для получения значений каждого из составляющих пары, а также
переопределение метода toString(), возвращающее строковое представление пары.
 */
package org.example.generic;

public class Pair <K,V>{
    private K first;

    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }

    private V second;

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    public K getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }
}
