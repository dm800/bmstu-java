package lab3;
public class Book implements Comparable<Book > {
    private int year;
    private String Author;
    private String Name;

    public Book(int year, String Author, String Name) {
        this.year = year;
        this.Author = Author;
        this.Name = Name;
    }
    public int compareTo(Book obj) {
        if (this.year == obj.year) {
            if (this.Author.equals(obj.Author)) {
                if (this.Name.equals(obj.Name)) {
                    return 0;
                }
                else {
                    int i = 0;
                    while (this.Name.charAt(i) - obj.Name.charAt(i) == 0) {
                        i++;
                    }
                    return this.Name.charAt(i) - obj.Name.charAt(i);
                }
            }
            else {
                int i = 0;
                while (this.Author.charAt(i) - obj.Author.charAt(i) == 0) {
                    i++;
                }
                return this.Author.charAt(i) - obj.Author.charAt(i);
            }
        }
        return this.year - obj.year;
    }
    public String toString() {
        return this.Name + " written by " + this.Author + " in " + this.year;
    }
}
