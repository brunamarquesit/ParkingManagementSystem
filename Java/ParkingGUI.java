
package Java;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;

public class ParkingGUI extends JFrame {

    public ParkingGUI() {
        setTitle("Parking Management System");
        setSize(750, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));

        JLabel title = new JLabel(
            "Vehicle Parking Management System",
            SwingConstants.CENTER
        );
        title.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel vehiclePanel = new JPanel(new FlowLayout());

        for (String type : new String[]{"Motorcycle", "Car", "Bus"}) {
            JLabel vehicle = new JLabel(type);
            vehicle.setOpaque(true);
            vehicle.setBackground(Color.LIGHT_GRAY);
            vehicle.setBorder(
                BorderFactory.createLineBorder(Color.GRAY, 2)
            );
            vehicle.setPreferredSize(new Dimension(110, 40));
            vehicle.setHorizontalAlignment(SwingConstants.CENTER);

            vehicle.setTransferHandler(new TransferHandler() {
                @Override
                protected Transferable createTransferable(JComponent c) {
                    return new StringSelection(
                        ((JLabel) c).getText()
                    );
                }

                @Override
                public int getSourceActions(JComponent c) {
                    return COPY;
                }
            });

            vehicle.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    JComponent component =
                        (JComponent) e.getSource();

                    component.getTransferHandler().exportAsDrag(
                        component, e, TransferHandler.COPY
                    );
                }
            });

            vehiclePanel.add(vehicle);
        }

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(title, BorderLayout.NORTH);
        topPanel.add(vehiclePanel, BorderLayout.SOUTH);
        mainPanel.add(topPanel, BorderLayout.NORTH);

        JPanel parkingPanel = new JPanel(
            new GridLayout(2, 5, 10, 10)
        );
        parkingPanel.setBorder(
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        );

        for (int i = 1; i <= 10; i++) {
            final int spaceNumber = i;

            JLabel space = new JLabel(
                "Space " + i, SwingConstants.CENTER
            );

            space.setOpaque(true);
            space.setBackground(Color.GREEN);
            space.setBorder(
                BorderFactory.createLineBorder(Color.DARK_GRAY)
            );

            space.setTransferHandler(new TransferHandler() {
                @Override
                public boolean canImport(TransferSupport support) {
                    return support.isDrop()
                        && support.isDataFlavorSupported(
                            DataFlavor.stringFlavor
                        );
                }

                @Override
                public boolean importData(TransferSupport support) {
                    if (!canImport(support)) {
                        return false;
                    }

                    if (Boolean.TRUE.equals(
                            space.getClientProperty("occupied"))) {
                        return false;
                    }

                    try {
                        String type = (String) support
                            .getTransferable()
                            .getTransferData(DataFlavor.stringFlavor);

                        space.setText(type + " - " + spaceNumber);
                        space.setBackground(Color.RED);
                        space.putClientProperty("occupied", true);

                        return true;

                    } catch (Exception ex) {
                        return false;
                    }
                }
            });

            parkingPanel.add(space);
        }

        mainPanel.add(parkingPanel, BorderLayout.CENTER);

        JButton helpButton = new JButton("Help");

        helpButton.addActionListener(e ->
            JOptionPane.showMessageDialog(
                this,
                "Drag a vehicle to an available space.\n" +
                "Green = Available\n" +
                "Red = Occupied",
                "Help",
                JOptionPane.INFORMATION_MESSAGE
            )
        );

        mainPanel.add(helpButton, BorderLayout.SOUTH);

        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
            new ParkingGUI().setVisible(true)
        );
    }
}
