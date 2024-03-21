import java.util.*;

public class Dividers {
    private static HashMap<Long, List<Long>> graph = new HashMap<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long num = input.nextLong();
        List<String> answer = formatout(num);
        System.out.println("graph {");
        for (String string : answer) {
            System.out.println("\t" + string);
        }
        System.out.println("}");
    }
    public static List<String> formatout(long num) {
        work(num);
        graph.put((long)1, new ArrayList<>());
        List<String> ans = new ArrayList<>();
        ArrayList<Long> arr = new ArrayList<>(graph.keySet());
        Collections.sort(arr);
        Collections.reverse(arr);
        for (long node : arr) {
            ans.add(Long.toString(node));
        }
        for (long node : arr) {
            for (long endpoint : graph.get(node)) {
                ans.add(node + "--" + endpoint);
            }
        }
        return ans;
    }

    public static boolean check(long num, long del) {
        boolean is_viable = true;
        for (long elem : graph.get(num)) {
            if (elem % del == 0) {
                is_viable = false;
                break;
            }
        }
        return is_viable;
    }

    public static void work(long num) {
        if (!graph.containsKey(num)) {
            graph.put(num, new ArrayList<>());
            if (num == 1) {
                return;
            }
            for (long n = 2; n < Math.sqrt(num) + 1; n++) {
                long checkv1 = (long) (Math.sqrt(num) + 2 - n);
                long checkv2 = num / n;
                if (num % checkv2 == 0) {
                    boolean is_viable2 = check(num, checkv2);
                    if (is_viable2) {
                        graph.get(num).add(checkv2);
                        work(checkv2);
                    }
                }
            }
            for (long n = (long)Math.sqrt(num) + 1; n > 1; n--) {
                long checkv1 = (long) (Math.sqrt(num) + 2 - n);
                long checkv2 = num / n;
                if ((num % checkv1 == 0) && (checkv1 != checkv2)) {
                    boolean is_viable1 = check(num, checkv1);
                    if (is_viable1) {
                        graph.get(num).add(checkv1);
                        work(checkv1);
                    }
                }
            }
            if (graph.get(num).isEmpty()) {
                graph.get(num).add((long)1);
            }
        }
    }
}
