package lab5;

import java.util.ArrayList;
import java.util.*;
import java.util.function.IntSupplier;
import java.util.stream.*;

class Progression {
    public int a;
    public int d;
    public Progression(int a, int d) {
        this.a = a;
        this.d = d;
    }

    public boolean contains(int num, int k) {
        return ((k - this.a) % this.d == 0) && ((k - this.a) / this.d < num);
    }

    public Integer sumprog(int n) {
        return (this.a + this.a + this.d * n) * n / 2;
    }

    private static boolean ispower(int n) {
        return ((n - 1) & n) == 0;
    }

    private class supp implements IntSupplier {

        int i = 0;

        public int getAsInt() {
            return i++;
        }
    }

    public boolean containspower(int k) {
        List<Integer> arr = new ArrayList<>();
        IntStream myStream = IntStream.generate(new supp());
        myStream.limit(k).forEach(x -> arr.add(a + x * d));
        Optional<Integer> ans = arr.stream().filter(x -> Progression.ispower(a + x * d)).findFirst();
        return ans.isPresent();
    }

    public String toString() {
        String k = "a0: " + this.a + ", delta: " + this.d;
        return k;
    }
}

public class ProgressionList {
    public List<Progression> progs;


    public ProgressionList() {
        this.progs = new ArrayList<>();
    }

    public void add(Progression elem) {
        this.progs.add(elem);
    }

    public Stream<Integer> nameStream(int num, int k) {
        Stream <Progression> filtered = this.progs.stream().filter(x -> x.contains(num, k));
        List<Integer> answer = new ArrayList<>();
        filtered.forEach(x -> answer.add(x.sumprog(num)));
        return answer.stream();
    }

    public Optional<Progression> getProgression(int num) {
        Optional<Progression> answer = progs.stream().filter(x -> x.containspower(num)).findFirst();
        return answer;
    }
}
