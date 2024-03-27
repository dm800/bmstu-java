package lab4;

import java.util.Iterator;

public class BoolIterable implements Iterable<Boolean> {
    byte[] sp;

    public BoolIterable(byte[] sp) {
        this.sp = sp;
    }

    public Iterator<Boolean> iterator() {
        return new BoolIterator();
    }

    public void change(int i, byte val) {
        this.sp[i] = val;
    }

    private class BoolIterator implements Iterator<Boolean> {
        private int pos;

        public BoolIterator() {
            pos = 0;
        }

        public boolean hasNext() {
            return pos < sp.length * 8;
        }

        public Boolean next() {
            if (pos % 8 != 0) {
                int num = Math.abs(sp[pos / 8]);
                if (sp[pos / 8] < 0) {
                    num -= 1;
                }
                int cur = num % (int) Math.pow(2, 8 - pos % 8) / (int) Math.pow(2, 8 - 1 - pos % 8);
                if (sp[pos / 8] < 0) {
                    pos++;
                    return cur == 0;
                }
                else {
                    pos++;
                    return cur == 1;
                }
            }
            else {
                return sp[pos++ / 8] < 0;
            }
        }
    }
}
