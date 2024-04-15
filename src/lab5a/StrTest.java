package lab5a;

import java.util.stream.Stream;

public class StrTest {
    public static void main(String[] args) {
        StreamString test = new StreamString("aaooffaoa");
        System.out.println(test.getVowels().get());
    }
}
