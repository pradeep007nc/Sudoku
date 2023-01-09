package sudokuGame;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Sudoku {

    public static boolean checkLines(char[][] arr){
        Set<Character> set = new HashSet<>();
        int row = 0;
        for (int i=0;i < arr.length; i++){
            for (int j=0;j < arr.length;j++){
                if (arr[i][j] == '.') continue;
                if(!set.contains(arr[i][j])) set.add(arr[i][j]);
                else return false;
            }
            set.clear();
        }
        set.clear();
        int col = 0;
        for (int i=0;i < arr.length; i++){
            for (int j=0;j < arr.length;j++){
                if (arr[j][i] == '.') continue;
                if(!set.contains(arr[j][i])) set.add(arr[j][i]);
                else return false;
            }
            set.clear();
        }
        return true;
    }

    public static boolean checkBoxes(char[][] arr, int row, int col){
        Set<Character> set = new HashSet<>();
        int row1 = row+3;
        int col1 = col+3;
        for (int i = row; i<row1; i++){
            for (int j = col; j<col1; j++){
                if (arr[i][j] == '.') continue;
                if(!set.contains(arr[i][j])) set.add(arr[i][j]);
                else return false;
            }
        }
        set.clear();
        return true;
    }

    public static boolean isValidSudoku(char[][] arr){
        for(int i=0;i<arr.length;i=i+3){
            for(int j=0;j<arr.length;j=j+3){
                if(!checkBoxes(arr, i, j)) return false;
            }
        }
        if(!checkLines(arr)) return false;
        return true;
    }
}