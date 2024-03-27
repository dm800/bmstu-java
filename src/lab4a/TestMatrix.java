package lab4a;

import java.util.ArrayList;

public class TestMatrix {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> vals = new ArrayList<>();
        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(2);
        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(3);
        row2.add(4);
        vals.add(row1);
        vals.add(row2);
        Matrix a = new Matrix(vals);
        a.change(1, 1, 8);
        for (Matrix mat : a) {
            System.out.println(mat);
        }
    }
}
