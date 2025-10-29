package System;

import java.awt.EventQueue;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;



public class AdminLogin {

    public JFrame AdminLogin;
    private JTextField textFieldUsername;
    private JPasswordField passwordField;
    private JButton btnLogin;
    private int offsetX;
    private int offsetY;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminLogin window = new AdminLogin();
                    window.AdminLogin.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AdminLogin() {
        initialize();
    }

    private void initialize() {
        AdminLogin = new JFrame();
        AdminLogin.getContentPane().setBackground(new Color(0, 0, 0, 0));
        AdminLogin.setBounds(0, 0, 1401, 800);
        AdminLogin.setLocationRelativeTo(null);
        AdminLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AdminLogin.setUndecorated(true);
        AdminLogin.getContentPane().setLayout(null);
        
        JLabel lblLogo = new JLabel("");
        lblLogo.setIcon(new ImageIcon(getClass().getResource("/pictures/Login Page Design.gif")));
        lblLogo.setBounds(720, 108, 681, 511);
        AdminLogin.getContentPane().add(lblLogo);
        
        JLabel lblTextDesign = new JLabel("");
        lblTextDesign.setIcon(new ImageIcon(getClass().getResource("/pictures/Text Login.png")));
        lblTextDesign.setBounds(121, 165, 477, 118);
        AdminLogin.getContentPane().add(lblTextDesign);
        
        JPanel clockPanel = new JPanel();
		clockPanel.setOpaque(false);
	 	clockPanel.setBackground(new Color(0, 0, 160));
        clockPanel.setBounds(990, 18, 132, 30);
        AdminLogin.getContentPane().add(clockPanel);

        // Call the showClock() method to display the clock on the panel
        FileOperation.showClock(clockPanel);
       
        btnLogin = new JButton("");
        btnLogin.setIcon(new ImageIcon(getClass().getResource("/pictures/LOGIN.png")));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setBounds(133, 570, 453, 64);
        btnLogin.setBorderPainted(true); // Remove button border
        btnLogin.setFocusPainted(false);
        btnLogin.setBackground(new Color(255,	196,	42));
        btnLogin.setBorder(new LineBorder(new Color(0, 0, 0))); 
        AdminLogin.getContentPane().add(btnLogin);
        btnLogin.addMouseListener(new MouseAdapter() {       	
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		 String username = textFieldUsername.getText();
                 String password = new String(passwordField.getPassword());
                 
                 AdminAccount Lyndas = new AdminAccount("Lyndas", "Admin123");
                 AdminAccount Prime = new AdminAccount("Prime", "Admin456");
                 
                 if (username.equals(Lyndas.getUsername()) && password.equals(Lyndas.getPassword())) {
                	 JOptionPane.showMessageDialog(null, "SUCCESSFULLY LOGIN");
                	 AdminLyndasListMenu1 window = new AdminLyndasListMenu1();
 					window.LyndaListUlam.setVisible(true);
                	    AdminLogin.dispose();
                	} else if (username.equals(Prime.getUsername()) && password.equals(Prime.getPassword())) {
                	    JOptionPane.showMessageDialog(null, "SUCCESSFULLY LOGIN");
                	   
    					AdminPrimeListMenu1 window = new AdminPrimeListMenu1();
     					window.AdminListUlam.setVisible(true);
                	    AdminLogin.dispose();
                	} else if (username.equals("") || password.equals("")) {
                	    JOptionPane.showMessageDialog(null, "Please enter both username and password.", "Missing Information",
                	            JOptionPane.ERROR_MESSAGE);
                	} else if (username.startsWith("Admin")) {
                	    JOptionPane.showMessageDialog(null, "Incorrect password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                	} else if (password.startsWith("Admin")) {
                	    JOptionPane.showMessageDialog(null, "Incorrect Username.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                	} else {
                	    JOptionPane.showMessageDialog(null, "Incorrect username and password.", "Login Failed",
                	            JOptionPane.ERROR_MESSAGE);
                	}
        	}
                 @Override
                 public void mouseEntered(MouseEvent e) {
                	 
                     btnLogin.setBackground(Color.WHITE);
                     
                 }

                 @Override
                 public void mouseExited(MouseEvent e) {
                     btnLogin.setBackground(new Color(255,	196,	42));
                     
                 }
        	
             });
    	
       
        
        

        textFieldUsername = new JTextField();
        textFieldUsername.setFont(new Font("Arial", Font.PLAIN, 30));
        textFieldUsername.setBorder(new LineBorder(new Color(0, 0, 0)));
        textFieldUsername.setForeground(Color.BLACK);
        textFieldUsername.setBackground(new Color(255, 255, 255));
        textFieldUsername.setBounds(133, 313, 453, 64);
        AdminLogin.getContentPane().add(textFieldUsername);
        textFieldUsername.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 30));
        passwordField.setForeground(Color.BLACK);
        passwordField.setDisabledTextColor(new Color(255, 255, 255));
        passwordField.setBackground(new Color(255, 255, 255));
        passwordField.setBorder(new LineBorder(new Color(0, 0, 0)));
        passwordField.setBounds(133, 401, 453, 64);
        AdminLogin.getContentPane().add(passwordField);
        
        JButton btnClose = new JButton("");
        btnClose.setIcon(new ImageIcon(getClass().getResource("/pictures/CLOSE X (1).png")));
        btnClose.setOpaque(true);
        btnClose.setBorderPainted(true);
        btnClose.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(225, 225, 225), new Color(225, 225, 225), new Color(225, 225, 225), new Color(225, 225, 225)), new EmptyBorder(2, 2, 2, 2)));
        btnClose.setFocusPainted(false);
        btnClose.setBackground(new Color(255, 196, 42));
        btnClose.setBounds(23, 18, 135, 25);
        AdminLogin.getContentPane().add(btnClose);
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
        		AdminLogin.dispose();
        	}
        });
        
        AdminLogin.getContentPane().add(btnClose);
        JButton btnBack = new JButton("");
        btnBack.setIcon(new ImageIcon(getClass().getResource("/pictures/BACK (1).png")));
        btnBack.setOpaque(true);
        btnBack.setBorderPainted(true);
        btnBack.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)));
        btnBack.setFocusPainted(false);
        btnBack.setBackground(new Color(8, 53, 139));
        btnBack.setBounds(23, 739, 195, 50);
        AdminLogin.getContentPane().add(btnBack);
        btnBack.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
            	btnBack.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
                ));
            }
            public void mouseExited(MouseEvent evt) {
            	btnBack.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
                ));
            }
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		Home window = new Home();
                window.Home.setVisible(true);
                AdminLogin.dispose();

        	}
        });
        

        
        JLabel lblDesign = new JLabel("");
        
        lblDesign.setIcon(new ImageIcon(getClass().getResource("/pictures/login Admin.png")));
        lblDesign.setBounds(0, 0, 1401, 800);
        AdminLogin.setShape(new RoundRectangle2D.Double(0, 0, AdminLogin.getWidth(), AdminLogin.getHeight(), 100, 100));
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
                AdminLogin.setLocation(x, y);
            }
        });
        AdminLogin.getContentPane().add(lblDesign);
    }
}
