package lesson2;


public class Main {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        String[][] arr  = {{"5","7","3","17"},
                           {"7","0","5","12"},
                           {"8","1","0","8"},
                           {"7","0","1","12"}};

        try {
            int mySum = mySumArr(arr);
            System.out.println(mySum);
        } catch (MyArraySizeException | MyArrayDataException ex){
            System.out.println(ex);
        }
    }
    public static int mySumArr(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if((arr.length != 4) || (arr[0].length != 4)){
            throw new MyArraySizeException();
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException numberFormatException) {
                    throw new MyArrayDataException(i, j, arr[i][j]);
                }
            }
        }
        return sum;
    }
}
