package lab4a;

import java.util.ArrayList;
import java.util.Iterator;

public class Matrix implements Iterable<Matrix> {
    ArrayList<ArrayList<Integer>> sp;
    int m;
    int n;

    public Matrix(ArrayList<ArrayList<Integer>> sp) {
        this.sp = sp;
        this.m = sp.size();
        if (m != 0) {
            this.n = sp.getFirst().size();
        }
        else {
            this.n = 0;
        }
    }

    public void change(int m, int n, int val) {
        if ((m < this.m) && (n < this.n)) {
            sp.get(m).set(n, val);
        }
    }

    public Iterator<Matrix> iterator() {
        return new MatrixIter();
    }

    public String toString() {
        String ans = "";
        for (ArrayList<Integer> row : this.sp) {
            for (Integer val : row) {
                ans += val.toString();
                ans += " ";
            }
            ans += "\n";
        }
        return ans;
    }

    private class MatrixIter implements Iterator<Matrix> {
        private int col;
        private int row;
        public MatrixIter() {
            col = 0;
            row = 0;
        }

        public boolean hasNext() {
            return !((col == 0 && (row - 1 == (int)Math.pow(2, n - 1))));
        }

        public Matrix next() {
            ArrayList<ArrayList<Integer>> inner = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                boolean ignorerow = (row % (Math.pow(2, m - i)) / (Math.pow(2, m - i - 1))) == 1;
                //System.out.println(ignorerow + " row");
                if (!ignorerow) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    for (int k = 0; k < n; k++) {
                        boolean ignorecol = (col % (Math.pow(2, n - k)) / (Math.pow(2, n - k - 1))) == 1;
                        //System.out.println(ignorecol + " col");
                        if (!ignorecol) {
                            temp.add(sp.get(i).get(k));
                        }
                    }
                    inner.add(temp);
                }
            }
            col++;
            if (col + 1 == Math.pow(2, n)) {
                col = 0;
                row++;
            }
            return new Matrix(inner);
        }
    }
}
