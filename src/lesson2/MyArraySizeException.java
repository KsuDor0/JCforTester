package lesson2;

public class MyArraySizeException extends Throwable{
    @Override
    public String toString() {
        return "MyArraySizeException{Size array is wrong. Must be 4x4}";
    }
}
