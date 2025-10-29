package System;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;

public class Admin extends JFrame {
    private JPanel contentPane;
    private JLabel adoboLabel;
    private JLabel friedChickenLabel;
    private JLabel maniLabel;

    // Data
    private Map<String, Integer> dishQuantities;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Admin window = new Admin();
                    window.setExtendedState(window.MAXIMIZED_BOTH);
                    window.setVisible(true);
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Admin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setTitle("Admin");

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        adoboLabel = new JLabel("snack1");
        adoboLabel.setBounds(36, 64, 46, 14);
        adoboLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showEditDialog("snack1");
            }
        });
        contentPane.add(adoboLabel);

        friedChickenLabel = new JLabel("FriedChicken");
        friedChickenLabel.setBounds(137, 64, 88, 14);
        friedChickenLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showEditDialog("FriedChicken");
                
            }
        });
        contentPane.add(friedChickenLabel);

        maniLabel = new JLabel("Mani");
        maniLabel.setBounds(293, 64, 46, 14);
        maniLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showEditDialog("Mani");
            }
        });
        contentPane.add(maniLabel);
        
        JLabel dish4Label = new JLabel("Mani");
        dish4Label.setBounds(293, 64, 46, 14);
        dish4Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showEditDialog("dish4");
            }
        });
        contentPane.add(maniLabel);

        loadDishQuantities();
    }

    private void loadDishQuantities() {
        dishQuantities = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\temp\\data2.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String dish = parts[0].trim();
                    int quantity = Integer.parseInt(parts[1].trim());
                    dishQuantities.put(dish, quantity);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditDialog(String dishName) {
        Integer currentQuantity = dishQuantities.get(dishName);
        if (currentQuantity != null) {
            String newQuantityStr = JOptionPane.showInputDialog(this, "Enter the new quantity for " + dishName + ":", currentQuantity);
            if (newQuantityStr != null) {
                try {
                    int newQuantity = Integer.parseInt(newQuantityStr);
                    dishQuantities.put(dishName, newQuantity);
                    saveDishQuantities();
                    JOptionPane.showMessageDialog(this, "Quantity updated successfully!");
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid quantity! Please enter a valid number.");
                }
                try {
                    // Copy the contents of data2.txt to data4.txt
                    Path sourceFile = Path.of("C:\\temp\\data2.txt");
                    Path destinationFile = Path.of("C:\\temp\\data4.txt");
                    Files.copy(sourceFile, destinationFile, StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Contents of data2.txt copied to data4.txt");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Dish not found!");
        }
    }

    private void saveDishQuantities() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\temp\\data2.txt"))) {
            for (Map.Entry<String, Integer> entry : dishQuantities.entrySet()) {
                String dish = entry.getKey();
                int quantity = entry.getValue();
                writer.write(dish + "," + quantity);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}