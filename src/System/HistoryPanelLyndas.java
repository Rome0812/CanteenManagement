package System;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

public class HistoryPanelLyndas {

    public JFrame frame;
    private JPanel panelControl;
    private JTextArea textArea;
    private String filepath = "src/data/LyndasHistory.txt";
    
    public HistoryPanelLyndas() {
        createAndShowGUI();
        readFileContents();
    }
    
    private void createAndShowGUI() {
        frame = new JFrame("Lyndas History");
        
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(354, 758);
        frame.setLocationRelativeTo(null);

        panelControl = new JPanel();
        panelControl.setBackground(Color.BLACK);
        panelControl.setLayout(null);
        textArea = new JTextArea();
        textArea.setBounds(10, 185, 317, 473);
        panelControl.add(textArea);
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 185, 317, 473);
        panelControl.add(scrollPane);

        JPanel panelDesign = new JPanel();
        panelDesign.setBounds(0, 0, 345, 719);
        panelControl.add(panelDesign);
        panelDesign.setLayout(null);
        
        
        
        JButton btnClearHistory = new JButton("Clear History");
        btnClearHistory.setBackground(new Color(255, 196, 42));
        btnClearHistory.setFont(new Font("Arial", Font.BOLD, 11));
        btnClearHistory.setForeground(new Color(8, 53, 139));
        btnClearHistory.setOpaque(true);
        btnClearHistory.setBorderPainted(true);
        btnClearHistory.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)));
        btnClearHistory.setFocusPainted(false);
        btnClearHistory.setBounds(10, 688, 100, 20);
        panelDesign.add(btnClearHistory);
        btnClearHistory.addMouseListener(new MouseAdapter() {       	
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		FileOperation.clearFile("src/data/LyndasHistory.txt");
        		readFileContents();
        		textArea.repaint();
        	}
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		btnClearHistory.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
                        ));
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		btnClearHistory.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
                        ));
        	}
        });

        JButton btnClose = new JButton("Close");
        btnClose.setFont(new Font("Arial", Font.BOLD, 11));
        btnClose.setForeground(new Color(255, 196, 42));
        btnClose.setOpaque(true);
        btnClose.setBorderPainted(true);
        btnClose.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)));
        btnClose.setFocusPainted(false);
        btnClose.setBounds(227, 688, 100, 20);
        panelDesign.add(btnClose);
        btnClose.setBackground(new Color(8, 53, 139));
        btnClose.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                btnClose.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnClose.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)));
            }
        });
        btnClose.setBackground(new Color(8, 53, 139));

        JLabel lblDesign = new JLabel("");
        lblDesign.setBounds(0, 0, 335, 727);
        
        lblDesign.setIcon(new ImageIcon(getClass().getResource("/Pictures/Lyndas History.png")));
        panelDesign.add(lblDesign);

        frame.getContentPane().add(panelControl);
        frame.setVisible(true);
    }

    private void readFileContents() {
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        textArea.setText(content.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HistoryPanelLyndas reader = new HistoryPanelLyndas();
                reader.frame.setVisible(true);
            }
        });
    }
}
