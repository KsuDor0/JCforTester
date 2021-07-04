package lesson5;

public class AppData {
    private String[] header;
    private int[][] data;
    private int numberOfRows;

    public AppData() {
        data = new int[16][16];
    }

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public void setData(int row, int col, int data) {
        numberOfRows = row;
        int currentRow = getData().length;
        int currentCol = getData()[0].length;

        if (row > currentRow) {
            int[][] tempArr = new int[currentRow * 2][currentCol];
            int[][] currentArr = getData();
            for (int i = 0; i < currentArr.length; i++) {
                for (int j = 0; j < currentArr[0].length; j++) {
                    tempArr[i][j] = currentArr[i][j];
                }
            }
            setData(tempArr);
        }
        if (col > currentCol) {
            int[][] tempArr = new int[currentRow][currentCol * 2];
            int[][] currentArr = getData();
            for (int i = 0; i < currentArr.length; i++) {
                for (int j = 0; j < currentArr[0].length; j++) {
                    tempArr[i][j] = currentArr[i][j];
                }
            }
            setData(tempArr);
        }

        this.data[row][col] = data;
    }

    public void displayInfo(){
        String[] header = getHeader();
        int[][] data = getData();
        for (int i = 0; i < header.length; i++) {
            System.out.print(header[i] + " ");
        }
        System.out.println();
        for (int i = 0; i <= getNumberOfRows(); i++) {
            for (int j = 0; j < header.length; j++) {
                System.out.print(data[i][j] + "     ");
            }
            System.out.println();
        }

    }

}
