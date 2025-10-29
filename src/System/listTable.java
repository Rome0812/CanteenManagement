package System;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

public class listTable extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					listTable frame = new listTable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public listTable() {
		
		
		try {
            // Read the file using BufferedReader
            BufferedReader reader = new BufferedReader(new FileReader("src/data/primeMenu1.txt"));
            String line;

            // Create the column names
            String[] columnNames = {"Dish", "Quantity", "Prices"};

            // Create the table model
            DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

            while ((line = reader.readLine()) != null) {
                // Split the line into values separated by commas
                String[] values = line.split(",");

                // Add a new row to the table model with the values
                tableModel.addRow(values);
            }
            
            // Create the JTable using the table model
            JTable table = new JTable(tableModel);
            
            table.setPreferredScrollableViewportSize(new Dimension(294, 374)); // Adjust the width and height as needed

            // Create a JScrollPane and add the table to it
            JScrollPane scrollPane = new JScrollPane(table);

            // Create a JFrame and add the scroll pane to it
            JFrame frame = new JFrame("JTable Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

            // Set the size and visibility of the frame
            frame.setSize(511, 300);
            frame.setVisible(true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

