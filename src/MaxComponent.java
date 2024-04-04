import java.io.File;
import java.util.*;

public class MaxComponent {
    public static HashMap<Integer, List<Integer>> Graph = new HashMap<>();

    public static List<Integer> answer = new ArrayList<>();

    public static int answer_edges = 0;

    public static List<Integer> cur;

    public static int cur_edges;

    public static List<Boolean> available = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        for (int i = 0; i < n; i++) {
            Graph.put(i, new ArrayList<>());
            available.add(true);
        }
        for (int i = 0; i < m; i++) {
            int u = input.nextInt();
            int v = input.nextInt();
            Graph.get(u).add(v);
            Graph.get(v).add(u);
        }
        for (int i = 0; i < n; i++){
            if (available.get(i)) {
                cur_edges = 0;
                cur = new ArrayList<>();
                parse(i);
                Collections.sort(cur);
                if (compare(answer, answer_edges, cur, cur_edges) < 0) {
                    answer = List.copyOf(cur);
                    answer_edges = cur_edges;
                }
            }
        }
        printer();
    }
    public static void parse(int key) {
        if (available.get(key)) {
            available.set(key, false);
            cur.add(key);
            for (int edge : Graph.get(key)) {
                cur_edges += 1;
                parse(edge);
            }
        }
    }

    public static void printer() {
        System.out.println("graph {");
        for (int key : Graph.keySet()) {
            System.out.print("\t" + key);
            if (answer.contains(key)) {
                System.out.print(" [color=red]");
            }
            System.out.print("\n");
        }
        for (int key : Graph.keySet()) {
            for (int edge : Graph.get(key)) {
                if (edge > key) {
                    System.out.print("\t" + key + "--" + edge);
                    if (answer.contains(key)) {
                        System.out.print(" [color=red]");
                    }
                    System.out.print("\n");
                }
            }
        }
        System.out.print("}");
        System.out.print(Graph.keySet().size());
    }

    public static int compare(List<Integer> arr1, int edges1, List<Integer> arr2, int edges2) {
        if (arr1.size() == arr2.size()) {
            if (edges1 == edges2) {
                return arr2.get(0) - arr1.get(0);
            }
            else {
                return edges1 - edges2;
            }
        }
        else {
            return arr1.size() - arr2.size();
        }
    }
}