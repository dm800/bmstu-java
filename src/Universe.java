public class Universe {
    private Molecule[] sp = new Molecule[100];
    private double temperature;
    public Universe(int count, double temperature) {
        for (int i = 0; i < count; i++) {
            Molecule temp = new Molecule();
            this.sp[i] = temp;
        }
        this.temperature = temperature;
    }
    public double getTemperature () {
        return this.temperature;
    }
    public double Energy () {
        double ans = this.getTemperature() * 1.38 * Math.pow(10, -23) * 1.5;
        return ans;
    }

    public Molecule[] getSp() {
        return this.sp;
    }

    public String toString() {
        if (this.getSp().length == 0) {
            return "Пустая вселенная";
        }
        else {
            return "Вселенная из " + this.sp[0].getCount() + " молекул и с температурой " + this.getTemperature() + " K";
        }
    }
}

