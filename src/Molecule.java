public class Molecule {
    static private int count;
    public Molecule () {
        Molecule.count += 1;
    }
    public int getCount () {
        return Molecule.count;
    }

    public String toString() {
        return "Молекула";
    }
}
