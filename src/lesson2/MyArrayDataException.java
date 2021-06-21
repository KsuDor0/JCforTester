package lesson2;

public class MyArrayDataException extends Throwable{

    int indexOfCellX;
    int indexOfCellY;
    String wrongValueOfCell;

    public MyArrayDataException(int i, int j, String s) {
        indexOfCellX = i;
        indexOfCellY = j;
        wrongValueOfCell = s;
    }

    @Override
    public String toString() {
        return "MyArrayDataException in array[" + indexOfCellX + "]" + "[" + indexOfCellY + "] wrong value = " + wrongValueOfCell;
    }
}
