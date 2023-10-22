/*
Напишите обобщенный метод compareArrays(), который принимает два массива и возвращает true, если они
одинаковые, и false в противном случае. Массивы могут быть любого типа данных, но должны иметь
одинаковую длину и содержать элементы одного типа.
 */
package org.example.generic;

public class CompareArrays {
    public static <T, K> boolean compareArrays(T[] arr1, K[] arr2){
        if (arr1.length == arr2.length && arr1[0].getClass() == arr2[0].getClass()){
            for (int i = 0; i < arr1.length; i++) {
                if (!arr1[i].equals(arr2[i])){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
