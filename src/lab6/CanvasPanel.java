import javax.swing.*;
import java.awt.*;

public class CanvasPanel extends JPanel {
    private double ph = 20.0;
    private int angle = 0;
    public void setP(double p) {
        ph = p;
        repaint();
    }

    public void setAngle(int an) {
        angle = (90 - an) % 360;
        repaint();
    }

    private int[] rotate(int x, int y) {
        double newangle = (angle * Math.PI / 180);
        int newx = (int)(x * Math.cos(newangle) - y * Math.sin(newangle));
        int newy = (int)(x * Math.sin(newangle) + y * Math.cos(newangle));
        int[] ans = {newx, newy};
        return ans;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawLine(350, 0, 350, 700);
        g.drawLine(0, 350, 700, 350);
        g.setColor(Color.RED);
        for (int y = -349; y < 350; y++) {
            int prevx = (int)((y - 1) * (y - 1) / (2 * ph));
            int x = (int)(y * y / (2 * ph));
            int prevy = y - 1;
            int[] ans = rotate(x, y);
            int[] ans2 = rotate(prevx, prevy);
            x = ans[0];
            int y1 = ans[1];
            prevx = ans2[0];
            prevy = ans2[1];
            g.drawLine(x + 350,  y1 + 349, prevx + 350, prevy + 349);
        }
    }
}