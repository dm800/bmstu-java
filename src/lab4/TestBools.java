package lab4;

public class TestBools {
    public static void main(String[] args) {
        byte[] vals = {-127, -1};
        BoolIterable sp = new BoolIterable(vals);
        for (Boolean s : sp) {
            System.out.println(s);
        }
        System.out.println("\n");
        sp.change(1, (byte)0);
        for (Boolean s : sp) {
            System.out.println(s);
        }
    }
}
