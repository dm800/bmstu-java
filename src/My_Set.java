public class My_Set {
    private int[] sp;
    public My_Set (int [] sp) {
        this.sp = sp;
    }

    public int[] get_val() {
        return this.sp;
    }

    public My_Set Find_Intersect (My_Set other) {
        int[] other_sp = other.get_val();
        int[] temp = new int[this.sp.length];
        int count = 0;
        for (int i = 0; i < this.sp.length; i++) {
            for (int k = 0; k < other_sp.length; k++) {
                if (this.sp[i] == other_sp[k]) {
                    temp[count] = this.sp[i];
                    count += 1;
                    break;
                }
            }
        }
        int[] ans = new int[count];
        for (int i = 0; i < count; i++) {
            ans[i] = temp[i];
        }
        return new My_Set(ans);
    }

    public String toString() {
        String s = "{";
        int[] values = this.get_val();
        for (int i = 0; i < values.length - 1; i++) {
            s += values[i] + ", ";
        }
        s += values[values.length - 1] + "}";
        return s;
    }
}

