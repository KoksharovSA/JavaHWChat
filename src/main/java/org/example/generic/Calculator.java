/*
Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы: sum(),
multiply(), divide(), subtract(). Параметры этих методов – два числа разного типа (но необязательно
разного между собой), над которыми должна быть произведена операция.
 */
package org.example.generic;

public class Calculator {
    public static <T extends Number, K extends Number> double sum(T item1, K item2) {
        return item1.doubleValue() + item2.doubleValue();
    }

    public static <T extends Number, K extends Number> double subtract(T item1, K item2) {
        return item1.doubleValue() - item2.doubleValue();
    }

    public static <T extends Number, K extends Number> double divide(T item1, K item2) {
        if (item2.doubleValue() != 0.0) {
            return item1.doubleValue() / item2.doubleValue();
        } else {
            throw new ArithmeticException("На ноль делить нельзя");
        }
    }

    public static <T extends Number, K extends Number> double multiply(T item1, K item2) {
        return item1.doubleValue() * item2.doubleValue();
    }
}
