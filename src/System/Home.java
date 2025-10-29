package System;

import java.awt.Color;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Home {

    public JFrame Home;
    private int offsetX;
    private int offsetY;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Home window = new Home();
                    window.Home.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace(); 
                }
            }
        });
    }

    public Home() {
        initialize();
    }

    private void initialize() {
        Home = new JFrame();
        Home.setUndecorated(true);
        Home.setBounds(0, 0, 1401, 800);
        Home.setLocationRelativeTo(null);
        Home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Home.getContentPane().setLayout(null);
        Border emptyBorder = BorderFactory.createEmptyBorder();
        
        //Calling the clock 
        JPanel clockPanel = new JPanel();
		clockPanel.setOpaque(false);
	 	clockPanel.setBackground(new Color(0, 0, 160));
        clockPanel.setBounds(635, 0, 132, 30);
        Home.getContentPane().add(clockPanel);

        // Call the showClock() method to display the clock on the panel
        FileOperation.showClock(clockPanel);
        
        //label text for admin
        JLabel lblAdmintxt = new JLabel("");
        lblAdmintxt.setIcon(new ImageIcon(getClass().getResource("/pictures/Admin.png")));
        lblAdmintxt.setBounds(666, 580, 69, 32);
        Home.getContentPane().add(lblAdmintxt);

        JButton btnAdmin = new JButton("");
        btnAdmin.setIcon(new ImageIcon(getClass().getResource("/pictures/Rectangle 20.png")));
        btnAdmin.setBackground(Color.WHITE);
        btnAdmin.setBounds(564, 567, 268, 60);
        btnAdmin.setContentAreaFilled(false);
        btnAdmin.setFocusPainted(false);// Disable highlighting effect
        btnAdmin.setBorder(emptyBorder); // Set the button's border to empty
        Home.getContentPane().add(btnAdmin);
        
        btnAdmin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AdminLogin window = new AdminLogin();
                window.AdminLogin.setVisible(true);
                Home.dispose();
            }

            
        });
        
        JButton btnClose = new JButton("");
        btnClose.setIcon(new ImageIcon(getClass().getResource("/pictures/CLOSE X (1).png")));
        btnClose.setOpaque(true);
        btnClose.setBorderPainted(true);
        btnClose.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(8, 53, 139), new Color(8, 53, 139), new Color(8, 53, 139), new Color(8, 53, 139)), new EmptyBorder(2, 2, 2, 2)));
        btnClose.setFocusPainted(false);
        btnClose.setBackground(new Color(255, 196, 42));
        btnClose.setBounds(22, 23, 135, 25);
        Home.getContentPane().add(btnClose);
        btnClose.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
            	btnClose.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
                ));
            }
            public void mouseExited(MouseEvent evt) {
            	btnClose.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
                ));
            }
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		btnClose.setBorder(new CompoundBorder(
        	            BorderFactory.createBevelBorder(BevelBorder.LOWERED,new Color(8, 53, 139), new Color(8, 53, 139), new Color(8, 53, 139), new Color(8, 53, 139)),
        	            new EmptyBorder(2, 2, 2, 2)
        	            
        	        ));
        	        // Perform other actions when the button is clickeds
				Home.dispose();
        	}
        });
        //text for student 
        JLabel lblStudenttxt = new JLabel("");
        lblStudenttxt.setIcon(new ImageIcon(getClass().getResource("/pictures/Student.png")));
        lblStudenttxt.setBounds(658, 655, 77, 32);
        Home.getContentPane().add(lblStudenttxt);
        
        
        JButton btnStudent = new JButton("");
        btnStudent.setIcon(new ImageIcon(getClass().getResource("/pictures/Rectangle 20.png")));
        btnStudent.setFocusPainted(false);
        btnStudent.setContentAreaFilled(false);
        btnStudent.setBorder(emptyBorder); 
        btnStudent.setBounds(564, 638, 268, 60);
        Home.getContentPane().add(btnStudent); 
        btnStudent.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		Store window = new Store();
				window.Store.setVisible(true);
				Home.dispose();
				}
        });
        
        
        JLabel lblDesign = new JLabel("");
        lblDesign.setIcon(new ImageIcon(getClass().getResource("/pictures/home screen (8).png")));
        lblDesign.setBounds(0, 0, 1401, 800);
        Home.setShape(new RoundRectangle2D.Double(0, 0, Home.getWidth(), Home.getHeight(), 100, 100));
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
                Home.setLocation(x, y);
            }
        });
        Home.getContentPane().add(lblDesign);
    }
}
