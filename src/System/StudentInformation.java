package System;

import java.awt.EventQueue;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class StudentInformation   {
    private JComboBox <String> amPmComboBox;
    public JFrame studentInfo;
    private JFormattedTextField timeField;
    private JTextField nameField;
    private JTextField mobileField;
    
    private int offsetX;
    private int offsetY;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StudentInformation window = new StudentInformation();
                    window.studentInfo.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public StudentInformation() {
        initialize();
    }

    private void initialize() {
        studentInfo = new JFrame();
        studentInfo.setUndecorated(true);
        studentInfo.setBounds(100, 100, 500, 600);
        studentInfo.setLocationRelativeTo(null);
        studentInfo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        studentInfo.getContentPane().setLayout(null);
        amPmComboBox = new JComboBox<>(new DefaultComboBoxModel<>(new String[]{"AM", "PM"}));
        amPmComboBox.setBorder(new EmptyBorder(0, 0, 0, 0));
        amPmComboBox.setBounds(256, 451, 60, 20);
        studentInfo.getContentPane().add(amPmComboBox);

        try {
            MaskFormatter timeFormatter = new MaskFormatter("##:##");
            timeFormatter.setPlaceholderCharacter('_');
            timeField = new JFormattedTextField(timeFormatter);
            timeField.setFont(new Font("Arial", Font.PLAIN, 13));
            timeField.setBorder(null);
            timeField.setBounds(165, 451, 60, 20);
            studentInfo.getContentPane().add(timeField);
        } catch (Exception e) {
            e.printStackTrace();
        }
        

        nameField = new JTextField();
        nameField.setFont(new Font("Arial", Font.PLAIN, 13));
        nameField.setBorder(null);
        nameField.setForeground(new Color(255, 255, 255));
        nameField.setBackground(new Color(8, 53, 139));
        nameField.setBounds(165, 221, 181, 20);
        nameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isDigit(c)) {
                    e.consume(); // Ignore the non-numeric character
                    return;
                }           
                

            }
        });
        studentInfo.getContentPane().add(nameField);

        mobileField = new JTextField();
        mobileField.setFont(new Font("Arial", Font.PLAIN, 13));
        mobileField.setForeground(new Color(255, 255, 255));
        mobileField.setBackground(new Color(8, 53, 139));
        mobileField.setBorder(null);
        mobileField.setBounds(165, 332, 181, 20);
        studentInfo.getContentPane().add(mobileField);
     // Add a key listener to the mobileField
        mobileField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                // Check if the entered character is a digit
                if (!Character.isDigit(c)) {
                    e.consume(); // Ignore the non-numeric character
                    return;
                }

                // Get the current text in the field
                String currentText = mobileField.getText();

                // Check if the length exceeds 11 digits
                if (currentText.length() >= 11) {
                    e.consume(); // Ignore the key if the limit is reached
                    return;
                }

                // Check if the first character is '0'
                if (currentText.isEmpty() && c != '0') {
                    e.consume(); // Ignore the key if it's not '0' as the first character
                }
            }
        });

        

        
               

        JButton getInfoButton = new JButton("");
        getInfoButton.setOpaque(true);
        getInfoButton.setBorderPainted(true);
        getInfoButton.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, null, null, null, null), new EmptyBorder(2, 2, 2, 2)));
        getInfoButton.setFocusPainted(false);
        getInfoButton.setBounds(139, 515, 228, 60);
        getInfoButton.setIcon(new ImageIcon(getClass().getResource("/pictures/CONFIRM.png")));
        studentInfo.getContentPane().add(getInfoButton);
        getInfoButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                getInfoButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, null, null, null, null));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                getInfoButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, null, null, null, null));
            }
        });

        getInfoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                getInfoButtonClicked();
                writeHistory();
                try {
                    // Open the source file for reading
                    BufferedReader reader = new BufferedReader(new FileReader("src/data/data.txt"));

                    // Open the destination file for appending
                    BufferedWriter writer = new BufferedWriter(new FileWriter("src/data/PrimeHistory.txt", true));

                    String line;
                    while ((line = reader.readLine()) != null) {
                        // Write each line from the source file to the destination file
                        writer.newLine();
                        writer.write(line);
                    }
                    // Close the reader and writer
                    writer.write("\n_\n");
                    reader.close();
                    writer.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        JLabel lblDesign = new JLabel("");
        lblDesign.setIcon(new ImageIcon(getClass().getResource("/pictures/StudentInformation.png")));

        lblDesign.setBounds(0, 0, 500, 600);
        studentInfo.setShape(new RoundRectangle2D.Double(0, 0, studentInfo.getWidth(), studentInfo.getHeight(), 100, 100));
        studentInfo.getContentPane().add(lblDesign);
        lblDesign.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            offsetX = e.getX();
            offsetY = e.getY();
        }
    });
        lblDesign.addMouseMotionListener(new MouseAdapter() {
        @Override
        public void mouseDragged(MouseEvent e) {
            int x = e.getXOnScreen() - offsetX;
            int y = e.getYOnScreen() - offsetY;
            studentInfo.setLocation(x, y); 
            }
        });
        } 
        
    
    private void getInfoButtonClicked() {
    	
        String name = nameField.getText();	
        String mobile = mobileField.getText();
        String time = timeField.getText();
        String amPm = (String) amPmComboBox.getSelectedItem();
        
        if (name.isEmpty()&& mobile.isEmpty()) {
            JOptionPane.showMessageDialog(studentInfo, "Name and Mobile field cannot be empty.", null,
                    JOptionPane.INFORMATION_MESSAGE);
        }
        else if (name.isEmpty()&&!mobile.isEmpty()) {
            JOptionPane.showMessageDialog(studentInfo, "Name field cannot be empty.", null,
                    JOptionPane.INFORMATION_MESSAGE);
            
        }else if (!name.isEmpty()&& mobile.isEmpty()){
                JOptionPane.showMessageDialog(studentInfo, "Mobile field cannot be empty.", null,
                        JOptionPane.INFORMATION_MESSAGE);
            
        }else if ( time.isEmpty()){
           
        }else if (!time.matches("^(0[1-9]|1[0-2]):([0-5][0-9])$")) {
            	JOptionPane.showMessageDialog(studentInfo, "Please choose appropriate time", null,
                        JOptionPane.INFORMATION_MESSAGE);
        }else {
        	Receipt receiptWindow = new Receipt();
        	receiptWindow.printReceipt(name, mobile, time, amPm );
            receiptWindow.setVisible(true);
            studentInfo.dispose();
    }
    }  
        
        
        
    public void writeHistory() {
    String	historyPath = "src/data/PrimeHistory.txt";
    BufferedWriter writer;
    BufferedWriter totalWriter;
    BufferedReader reader;

    String name = nameField.getText();	
    String mobile = mobileField.getText();
    String time = timeField.getText();
    String amPm = (String) amPmComboBox.getSelectedItem();
    String total;
	try {
		writer = new BufferedWriter(new FileWriter(historyPath, true));
		reader = new BufferedReader(new FileReader("src/data/total.txt"));
		totalWriter = new BufferedWriter(new FileWriter(historyPath, true));
		writer.write(name + "," + mobile + "," + time + ":" +  amPm);
        writer.flush();
        while((total = reader.readLine()) != null) {
            totalWriter.write("Total: " + total);
            }
            totalWriter.flush();
            totalWriter.newLine();
        
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
        
    
    }
    
}
