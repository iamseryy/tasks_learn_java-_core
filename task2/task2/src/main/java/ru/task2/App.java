package ru.task2;


import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class App
{
    public static void main( String[] args )
    {
        // 1. Написать метод, возвращающий количество чётных элементов массива.
        // Пример: countEvens([2, 1, 2, 3, 4]) → 3 countEvens([2, 2, 0]) → 3 countEvens([1, 3, 5]) → 0
        var numbers = IntStream.generate(() -> new Random().nextInt(100)).limit(20).toArray();
        System.out.println("countEvens(" + Arrays.toString(numbers) + ") -> " + countEvens(numbers));


        //2. Написать функцию, возвращающую разницу между самым большим и самым ма- леньким элементами переданного не пустого массива.


        //3. Написать функцию, возвращающую истину, если в переданном массиве есть два соседних элемента, с нулевым значением.
    }

    private static int countEvens(int[] numbers){
        return (int) Arrays.stream(numbers).filter(num -> num % 2 == 0).count();
    }
}
