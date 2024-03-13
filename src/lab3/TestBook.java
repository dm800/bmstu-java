package lab3;
import java.util.Arrays ;

public class TestBook {
    public static void main (String[] args) {
        Book[] arr = new Book[] {
                new Book(1993, "Me", "You"),
                new Book(1993, "Me", "Not you"),
                new Book(1993, "Is it me?", "You"),
                new Book(2005, "Me", "You")
        };
        Arrays.sort(arr);
        for (Book book : arr) {
            System.out.println(book);
        }
    }
}
