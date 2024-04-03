import java.util.*;

public class Mars {
    public static HashMap<Integer, List<Integer>> Hates = new HashMap<>();
    public static List<Integer> group1 = new ArrayList<>();
    public static List<Integer> group2 = new ArrayList<>();

    public static List<List<List<Integer>>> variants = new ArrayList<>();

    public static boolean is_error = false;
    public static List<Integer> keys;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        for (int k = 0; k < n; k++) {
            String t = input.nextLine();
            Hates.put(k + 1, new ArrayList<>());
            for (int i = 0; i < n; i++) {
                if (t.charAt(i * 2) == (byte)('+')) {
                    Hates.get(k + 1).add(i + 1);
                }
            }
        }
        keys = new ArrayList<>(Hates.keySet());
        for (Integer key : Hates.keySet()) {
            if (keys.contains(key)) {
                group1.clear();
                group2.clear();
                check(key, 1);
            }
            else {
                continue;
            }
            if (is_error) {
                System.out.println("No solution");
                break;
            }
            List<List<Integer>> temp = new ArrayList<>();
            temp.add(List.copyOf(group1));
            temp.add(List.copyOf(group2));
            variants.add(temp);
        }
        if (!is_error) {
            List<Integer> answer1 = null;
            List<Integer> answer2 = null;
            for (int i = 0; i < Math.pow(2, variants.size()); i++) {
                group1.clear();
                group2.clear();
                for (int k = 0; k < variants.size(); k++) {
                    int cur = (i / (int)Math.pow(2, k)) % 2;
                    if (cur == 1) {
                        group1.addAll(variants.get(k).get(0));
                        group2.addAll(variants.get(k).get(1));
                    }
                    else {
                        group2.addAll(variants.get(k).get(0));
                        group1.addAll(variants.get(k).get(1));
                    }
                }
                if (answer1 == null) {
                    Collections.sort(group1);
                    Collections.sort(group2);
                    if (group1.size() <= group2.size()) {
                        answer1 = List.copyOf(group1);
                        answer2 = List.copyOf(group2);
                    }
                    else {
                        answer1 = List.copyOf(group2);
                        answer2 = List.copyOf(group1);
                    }
                }
                else {
                    if (Math.abs((answer1.size() - answer2.size())) > Math.abs(group1.size() - group2.size())) {
                        Collections.sort(group1);
                        Collections.sort(group2);
                        if (group1.size() <= group2.size()) {
                            answer1 = List.copyOf(group1);
                            answer2 = List.copyOf(group2);
                        }
                        else {
                            answer1 = List.copyOf(group2);
                            answer2 = List.copyOf(group1);
                        }
                    }
                    else if (Math.abs((answer1.size() - answer2.size())) == Math.abs(group1.size() - group2.size())) {
                        if (group1.size() > group2.size()) {
                            List<Integer> temp = group1;
                            group1 = group2;
                            group2 = temp;
                        }
                        if (compare(answer1, group1) > 0) {
                            Collections.sort(group1);
                            Collections.sort(group2);
                            answer1 = List.copyOf(group1);
                            answer2 = List.copyOf(group2);
                        }
                    }
                }
            }
            List<Integer> answer;
            if (answer1.size() <= answer2.size()) {
                answer = answer1;
            }
            else {
                answer = answer2;
            }
            for (int val : answer) {
                System.out.print(val + " ");
            }
        }
    }

    public static int compare(List<Integer> gr1, List<Integer> gr2) {
        for (int i = 0; i < Math.min(gr1.size(), gr2.size()); i++) {
            if (gr1.get(i) < gr2.get(i)) {
                return -1;
            }
            else if (gr1.get(i) > gr2.get(i)) {
                return 1;
            }
        }
        return -1;
    }

    public static void check(int key, int cur) {
        keys.remove((Integer) key);
        if (cur == 1) {
            if (group2.contains(key)) {
                is_error = true;
            }
            else {
                group1.add(key);
                for (Integer check_key : Hates.get(key)) {
                    if (group2.contains(check_key)) continue;
                    check(check_key, 2);
                }
            }
        }
        else {
            if (group1.contains(key)) {
                is_error = true;
            }
            else {
                group2.add(key);
                for (Integer check_key : Hates.get(key)) {
                    if (group1.contains(check_key)) continue;
                    check(check_key, 1);
                }
            }
        }
    }
}