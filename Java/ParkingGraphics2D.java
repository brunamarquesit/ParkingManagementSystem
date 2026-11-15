
package Java;

import javax.swing.*;
import java.awt.*;

public class ParkingGraphics2D extends JPanel {

    public ParkingGraphics2D() {
        setPreferredSize(new Dimension(650, 350));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setFont(new Font("Arial", Font.BOLD, 18));
        g2.setColor(Color.BLACK);
        g2.drawString("Parking Level 1 - Row 1", 30, 40);

        for (int i = 0; i < 5; i++) {
            int x = 30 + i * 120;

            g2.setColor(i < 2 ? Color.RED : Color.GREEN);
            g2.fillRect(x, 80, 100, 100);

            g2.setColor(Color.BLACK);
            g2.drawRect(x, 80, 100, 100);
            g2.drawString("Space " + (i + 1), x + 15, 135);
        }

        g2.setColor(Color.BLACK);
        g2.drawString("Red = Occupied", 30, 230);
        g2.drawString("Green = Available", 250, 230);

        g2.dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Parking 2D Graphics");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new ParkingGraphics2D());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
