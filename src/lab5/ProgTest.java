package lab5;

public class ProgTest {
    public static void main(String[] args) {
        System.out.println("Test 1:");
        ProgressionList testgr1 = new ProgressionList();
        Progression elem1 = new Progression(5, 1);
        Progression elem2 = new Progression(1, 2);
        Progression elem3 = new Progression(2, 3);
        testgr1.add(elem1);
        testgr1.add(elem2);
        testgr1.add(elem3);
        testgr1.nameStream(10, 13).forEach(System.out::println);
        System.out.println("Test 2:");
        ProgressionList testgr2 = new ProgressionList();
        Progression elem4 = new Progression(10, 3);
        Progression elem5 = new Progression(15, 10);
        Progression elem6 = new Progression(20, 4);
        testgr2.add(elem4);
        testgr2.add(elem5);
        testgr2.add(elem6);
        testgr2.nameStream(10, 22).forEach(System.out::println);
        System.out.println("Test 3:");
        ProgressionList testgr3 = new ProgressionList();
        Progression elem7 = new Progression(100, 150);
        Progression elem8 = new Progression(200, 4);
        Progression elem9 = new Progression(500, 100);
        testgr3.add(elem7);
        testgr3.add(elem8);
        testgr3.add(elem9);
        testgr3.nameStream(10, 700).forEach(System.out::println);
        System.out.println("Test 4:");
        ProgressionList testgr4 = new ProgressionList();
        Progression elem10 = new Progression(3, 2);
        Progression elem11 = new Progression(5, 6);
        Progression elem12 = new Progression(2, 1);
        testgr4.add(elem10);
        testgr4.add(elem11);
        testgr4.add(elem12);
        System.out.println(testgr4.getProgression(1).get());
        ProgressionList testgr5 = new ProgressionList();
        testgr5.add(elem1);
        testgr5.add(elem4);
        testgr5.add(elem7);
    }
}
