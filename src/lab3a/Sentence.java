package lab3a;

public class Sentence implements Comparable<Sentence > {
    private String sent;

    public Sentence(String sent) {
        this.sent = sent;
    }

    public int compareTo(Sentence obj) {
        return this.count() - obj.count();
    }

    public int count() {
        int globals = 0;
        int s = 0;
        int c = 1;
        for (int i = 0; i < sent.length(); i++) {
            if ((((int) this.sent.charAt(i) == 32) || ((int) this.sent.charAt(i) == (int)'\t') ) && (s != 0)) {
                c += 1;
                globals += s;
                s = 0;
            } else if ((int) this.sent.charAt(i) != 32) {
                s += 1;
            }
        }
        globals += s;
        return globals / c;
    }

    public String toString() {
        return this.sent;
    }
}
