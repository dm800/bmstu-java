public class SetTest {
    public static void main (String [] args) {
        int[] val1 = {1, 2, 3, 4, 6, 8, 10, 11};
        int[] val2 = {3, 4, 5, 6, 2, 11};
        My_Set set1 = new My_Set(val1);
        My_Set set2 = new My_Set(val2);
        My_Set intersected = set1.Find_Intersect(set2);
        System.out.println(intersected);
    }
}