package lab5a;

import java.util.*;
import java.util.stream.*;

public class StreamString {
    StringBuilder str;

    public StreamString(String st) {
        str = new StringBuilder();
        str.append(st);
    }

    public String toString() {
        return this.str.toString();
    }

    private List<Character> vowels() {
        List<Character> vowels = new ArrayList<>();
        vowels.add('a');
        vowels.add('o');
        vowels.add('i');
        vowels.add('e');
        vowels.add('u');
        vowels.add('A');
        vowels.add('O');
        vowels.add('I');
        vowels.add('E');
        vowels.add('U');
        return vowels;
    }

    public Stream<Character> nameStream() {
        List<Character> ans = new ArrayList<>();
        List<Character> vowelslist = vowels();
        this.str.toString().chars().filter(x -> vowelslist.contains(x)).forEach(x -> ans.add((char)x));
        return ans.stream();
    }

    private List<Character> delete() {
        List<Character> ans = new ArrayList<>();
        this.str.toString().chars().forEach(x -> checkadd((char)x, ans));
        return ans;
    }

    private List<String> split(List<Character> vowels) {
        List<String> ans = new ArrayList<>();
        StreamString cur = new StreamString("");
        vowels.add(' ');
        vowels.stream().forEach(x -> stringadd(cur, ans, x));
        return ans;
    }

    private void stringadd(StreamString str, List<String> arr, char x) {
        if (x == ' ') {
            arr.add(str.toString());
            str.setStr("");
        }
        else {
            str.addChar(x);
        }
    }

    private void checkadd(char x, List<Character> arr) {
        List<Character> vowellist = vowels();
        if (vowellist.contains(x)) {
            arr.add(x);
        }
        else {
            if ((!arr.isEmpty()) && ((arr.getLast()) != ' ')) {
                arr.add(' ');
            }
        }
    }

    public Optional<String> getVowels() {
        List<Character> tmp1 = delete();
        List<String> tmp2 = split(tmp1);
        Optional<String> t = tmp2.stream().max(Comparator.comparingInt(String::length));
        return t;
    }

    public char charAt(int i) {
        return this.str.charAt(i);
    }

    public void setCharAt(int i, char letter) {
        this.str.setCharAt(i, letter);
    }

    public void addChar(char letter) {
        this.str.append(letter);
    }

    public void setStr(String str) {
        this.str = new StringBuilder(str);
    }
}
