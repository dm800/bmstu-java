import java.util.*;

public class BridgeNum {
    public static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
    public static Queue<Integer> k = new LinkedList<>();

    public static ArrayList<Boolean> visited1 = new ArrayList<>();

    public static Hashtable<Integer, Integer> parents = new Hashtable<>();
    public static Hashtable<Integer, Integer> components = new Hashtable<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
            visited1.add(false);
            parents.put(i, -1);
            components.put(i, -1);
        }
        int m = input.nextInt();
        for (int k = 0; k < m; k++) {
            int u = input.nextInt();
            int v = input.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int comp = 0;
        for (int i = 0; i < n; i++) {
            if (!visited1.get(i)) {
                dfs1(i);
                comp += 1;
            }
        }
        int comp2 = 0;
        while (!k.isEmpty()) {
            int t = k.remove();
            if (components.get(t) == -1) {
                dfs2(t, comp2);
                comp2++;
            }
        }
        System.out.println(comp2 - comp);
    }

    public static void dfs1(int node) {
        k.add(node);
        visited1.set(node, true);
        for (int key : graph.get(node)) {
            if (!visited1.get(key)) {
                parents.put(key, node);
                dfs1(key);
            }
        }
    }

    public static void dfs2(int node, int comp) {
        components.put(node, comp);
        for (int key : graph.get(node)) {
            if ((components.get(key) == -1) && (parents.get(key) != node)) {
                dfs2(key, comp);
            }
        }
    }
}