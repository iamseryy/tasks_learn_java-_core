package ru.task2;

import java.util.Arrays;

public class App
{
    public static void main( String[] args )
    {
        // 1. Написать метод, возвращающий количество чётных элементов массива.
        // Пример: countEvens([2, 1, 2, 3, 4]) → 3 countEvens([2, 2, 0]) → 3 countEvens([1, 3, 5]) → 0
        //var numbers = IntStream.generate(() -> new Random().nextInt(100)).limit(20).toArray();
        var numbers = new int[]{1,3,44,5,1,0,44,55};
        System.out.println("1. countEvens(" + Arrays.toString(numbers) + ") -> " + countEvens(numbers));

        //2. Написать функцию, возвращающую разницу между самым большим и самым маленьким элементами переданного не пустого массива.
        System.out.println((numbers.length > 0 ? "\n2. Max and min array item difference: " + minMaxArrayDifference(numbers) : "\n2. Empty array"));

        //3. Написать функцию, возвращающую истину, если в переданном массиве есть два соседних элемента, с нулевым значением.
        System.out.println(numbers.length > 0 ? "\n3. Exists neighboring items in zero: " + existsNeighboringItemsInZero(numbers) : "\n3. Empty array");
    }

    private static int countEvens(int[] numbers){
        return (int) Arrays.stream(numbers).filter(num -> num % 2 == 0).count();
    }

    private static int minMaxArrayDifference(int[] numbers){
        return Arrays.stream(numbers).max().orElse(0) - Arrays.stream(numbers).min().orElse(0);
    }

    private static boolean existsNeighboringItemsInZero(int[] numbers){
        for(int i = 1; i < numbers.length; i++){
            if (numbers[i - 1] - numbers[i] == 0) return true;
        }
        return false;
    }
}
