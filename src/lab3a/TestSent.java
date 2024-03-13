package lab3a;

import java.util.Arrays ;

public class TestSent {
    public static void main (String[] args) {
        Sentence[] arr = new Sentence[] {
                new Sentence("Must be 2nd"),
                new Sentence("Must be\tthird"),
                new Sentence("M u s t b e 1 s t"),
                new Sentence("Mustbefourth"),
        };
        Arrays.sort(arr);
        for (Sentence sent : arr) {
            System.out.println(sent);
        }
    }
}
