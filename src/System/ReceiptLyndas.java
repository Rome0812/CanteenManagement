package System;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import java.io.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.Color;
import java.awt.Font;


public class ReceiptLyndas extends MyPanel {
	
    private JFrame ReceiptLyndas;
	String filePath = "src/data/data.txt";
    public JLabel totalPrice;
   
    


    /**
     * @wbp.parser.entryPoint
     */
    public void printReceipt(String name, String mobile, String time, String AmPm) {
    	ReceiptLyndas = new JFrame();
    	ReceiptLyndas.setUndecorated(true);
    	ReceiptLyndas.setBounds(100, 100, 355, 727);
    	ReceiptLyndas.setLocationRelativeTo(null);
    	ReceiptLyndas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	ReceiptLyndas.getContentPane().setLayout(null);
                        
        loadDataFromFile("src/data/data.txt");
        setSize(294,374);
        setLocation(30, 274);
        ReceiptLyndas.getContentPane().add(this);
        
        JLabel lblGcashNumber = new JLabel("09*****6895");
        lblGcashNumber.setForeground(new Color(0, 0, 0));
        lblGcashNumber.setFont(new Font("Arial", Font.BOLD, 11));
        lblGcashNumber.setBounds(255, 255, 65, 15);
        ReceiptLyndas.getContentPane().add(lblGcashNumber);
        
        JLabel lblGcashName = new JLabel("             Lyndas ");
        lblGcashName.setForeground(new Color(0, 0, 255));
        lblGcashName.setFont(new Font("Arial", Font.BOLD, 11));
        lblGcashName.setBounds(225, 236, 120, 15);
        ReceiptLyndas.getContentPane().add(lblGcashName);
        
        JLabel lblGcash = new JLabel("");
        lblGcash.setIcon(new ImageIcon(getClass().getResource("/pictures/Prime QRCODE.png")));
        lblGcash.setBounds(225, 135, 120, 100);
        ReceiptLyndas.getContentPane().add(lblGcash);
                       
        JLabel nameLabel = new JLabel("Name: " + name);
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        nameLabel.setBounds(20, 171, 200, 20);
        ReceiptLyndas.getContentPane().add(nameLabel);
        
        JLabel mobileLabel = new JLabel("Mobile: " + mobile);
        mobileLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        mobileLabel.setBounds(20, 202, 200, 20);
        ReceiptLyndas.getContentPane().add(mobileLabel);

        JLabel timeLabel = new JLabel("Time: " + time + " " +  AmPm);
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        timeLabel.setBounds(20, 233, 200, 20);
        ReceiptLyndas.getContentPane().add(timeLabel);
        
        totalPrice = new JLabel();
        totalPrice.setFont(new Font("Arial", Font.BOLD, 16));
        totalPrice.setBounds(255, 655, 100, 20);
        totalPrice.setVisible(true);
     	loadTextFile("src/data/total.txt");
     	ReceiptLyndas.getContentPane().add(totalPrice);
        
        JButton closeButton = new JButton("Close");
        closeButton.setFont(new Font("Arial", Font.BOLD, 11));
        closeButton.setForeground(new Color(255, 196, 42));
        closeButton.setOpaque(true);
        closeButton.setBorderPainted(true);
        closeButton.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)));
        closeButton.setFocusPainted(false);
        closeButton.setBackground(new Color(8, 53, 139));
        closeButton.addMouseListener(new MouseAdapter() {
        	public void mouseEntered(java.awt.event.MouseEvent evt) {
        		closeButton.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
                           ));
               }
               public void mouseExited(java.awt.event.MouseEvent evt) {
            	   closeButton.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
                           ));
               }
            @Override
            public void mouseClicked(MouseEvent e) {
            	
            	ReceiptLyndas.dispose();
                reduceQuantity();
        		FileOperation.clearFile(filePath);
        		FileOperation.clearFile2("src/data/total.txt");
                FileOperation.copyFile("src/data/primeMenu2.txt","src/data/primeMenu1.txt" );
                FileOperation.copyFile("src/data/LyndasMenu2.txt","src/data/LyndasMenu1.txt" );

            }
        });
        closeButton.setBounds(122, 696, 120, 20);
        ReceiptLyndas.getContentPane().add(closeButton);
        
        JLabel lblDesign = new JLabel("");
        lblDesign.setIcon(new ImageIcon(getClass().getResource("/pictures/LyndasReceipt.png")));
        lblDesign.setBounds(0, 0, 355, 727);
        ReceiptLyndas.getContentPane().add(lblDesign);
        ReceiptLyndas.setShape(new RoundRectangle2D.Double(0, 0, ReceiptLyndas.getWidth(), ReceiptLyndas.getHeight(), 100, 100));  
        ReceiptLyndas.setVisible(true);
        
        
        
        
    }
    
    private void reduceQuantity() {
        String quantityFilePath = "src/data/primeMenu1.txt";
        try (BufferedReader quantityReader = new BufferedReader(new FileReader(quantityFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(quantityFilePath + ".tmp"))) {

            String quantityLine;
            while ((quantityLine = quantityReader.readLine()) != null) {
                String[] quantityParts = quantityLine.split(",");
                String quantityFood = quantityParts[0].trim();
                int quantity = Integer.parseInt(quantityParts[1].trim());
                int quantityPrice = Integer.parseInt(quantityParts[2].trim());

                int reducedQuantity = quantity;
                try (BufferedReader dataReader = new BufferedReader(new FileReader(filePath))) {
                    String dataLine;
                    while ((dataLine = dataReader.readLine()) != null) {
                        String[] dataParts = dataLine.split(",");
                        String dataFood = dataParts[0].trim();
                        int dataQuantity = Integer.parseInt(dataParts[1].trim());
                        // Assuming the price is stored in index 2

                        if (dataFood.equals(quantityFood)) {
                            reducedQuantity -= dataQuantity;
                            break;
                        }
                    }
                }

                if (reducedQuantity >= 0) {
                    writer.write(quantityFood + "," + reducedQuantity + "," + quantityPrice);
                } else {
                    writer.write(quantityFood + ",0" + quantityPrice);
                }
                writer.newLine();
            }

            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Rename the temporary file to the original quantity file
        File quantityFile = new File(quantityFilePath);
        File tempFile = new File(quantityFilePath + ".tmp");

        if (quantityFile.exists() && tempFile.exists()) {
            quantityFile.delete();
            tempFile.renameTo(quantityFile);
        }

        System.out.println("Quantity reduced successfully.");
    }

    private void reduceQuantity2() {
        String quantityFilePath = "src/data/LyndasMenu1.txt";
        try (BufferedReader quantityReader = new BufferedReader(new FileReader(quantityFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(quantityFilePath + ".tmp"))) {

            String quantityLine;
            while ((quantityLine = quantityReader.readLine()) != null) {
                String[] quantityParts = quantityLine.split(",");
                String quantityFood = quantityParts[0].trim();
                int quantity = Integer.parseInt(quantityParts[1].trim());
                int quantityPrice = Integer.parseInt(quantityParts[2].trim());

                int reducedQuantity = quantity;
                try (BufferedReader dataReader = new BufferedReader(new FileReader(filePath))) {
                    String dataLine;
                    while ((dataLine = dataReader.readLine()) != null) {
                        String[] dataParts = dataLine.split(",");
                        String dataFood = dataParts[0].trim();
                        int dataQuantity = Integer.parseInt(dataParts[1].trim());
                        // Assuming the price is stored in index 2

                        if (dataFood.equals(quantityFood)) {
                            reducedQuantity -= dataQuantity;
                            break;
                        }
                    }
                }

                if (reducedQuantity >= 0) {
                    writer.write(quantityFood + "," + reducedQuantity + "," + quantityPrice);
                } else {
                    writer.write(quantityFood + ",0" + quantityPrice);
                }
                writer.newLine();
            }

            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Rename the temporary file to the original quantity file
        File quantityFile = new File(quantityFilePath);
        File tempFile = new File(quantityFilePath + ".tmp");

        if (quantityFile.exists() && tempFile.exists()) {
            quantityFile.delete();
            tempFile.renameTo(quantityFile);
        }

        System.out.println("Quantity reduced successfully.");
    }
    private void loadTextFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            if (line != null) {
            	
            	totalPrice.setText("Total: " + line);
            } else {
            	totalPrice.setText("File is empty.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            totalPrice.setText("Error reading file.");
        }
    }
    /**
     * @wbp.parser.entryPoint
     */
    public void setVisible(boolean isVisible) {
    	ReceiptLyndas.setVisible(isVisible);
        
    }
}
