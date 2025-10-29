package System;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MyPanel extends JPanel {
    private DefaultTableModel tableModel;
    private JTable table;

    public MyPanel() {
        setOpaque(true);
        setLayout(null);
        setBounds(817, 154, 294, 374);
        tableModel = new DefaultTableModel(new Object[]{"Dish", "Quantity", "Price"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 0, 294, 374);
        table.setSize(294, 374); // Adjust the width and height as needed
        add(scrollPane);

    }

    public void loadDataFromFile(String filename) {
        tableModel.setRowCount(0); // Clear existing data from the table
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    Object[] rowData = new Object[]{data[0], data[1], data[2]};
                    tableModel.addRow(rowData);
                }
            }
            table.setLayout(null);

            tableModel.fireTableDataChanged();
            table.repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
