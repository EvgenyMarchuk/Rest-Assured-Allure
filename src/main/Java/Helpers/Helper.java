package Helpers;

public class Helper {

    public static <T> T getLast(T[] array){
        return array[array.length - 1];
    }

    public static <T> T getFirst(T[] array){
        return array[0];
    }

    public static <T> T getElementByPosition(T[] array, int position){
        return array[position - 1];
    }
}
