package System;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Store {

	public JFrame Store;
	private int offsetX;
    private int offsetY;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Store window = new Store();
					window.Store.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Store() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Store = new JFrame();
		Store.setUndecorated(true);
		Store.setBounds(100, 100, 1401, 800);
		Store.setLocationRelativeTo(null);
		
		Store.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Store.getContentPane().setLayout(null);
		
		JButton btnBack = new JButton("");
        btnBack.setIcon(new ImageIcon(getClass().getResource("/pictures/BACK (1).png")));
        btnBack.setOpaque(true);
        btnBack.setBorderPainted(true);
        btnBack.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)));
        btnBack.setFocusPainted(false);
        btnBack.setBackground(new Color(8, 53, 139));
        btnBack.setBounds(38, 711, 195, 50);
        Store.getContentPane().add(btnBack);
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
                Store.dispose();

        	}
        });
        
       
		
		JButton btnPrimePlate = new JButton("");
		btnPrimePlate.setIcon(new ImageIcon(getClass().getResource("/pictures/L2.png")));
		
		btnPrimePlate.setFocusPainted(false);
		btnPrimePlate.setBounds(476, 427, 433, 187);
		Store.getContentPane().add(btnPrimePlate);
		btnPrimePlate.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btnPrimePlate.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btnPrimePlate.setBorder(null); // Reset the border when the mouse exits
		    }
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	Menu1 window = new Menu1();
                window.Menu1.setVisible(true);
		    	Store.dispose();
		    }
		});

		
		
		JButton btnLynda = new JButton("");
		btnLynda.setBackground(new Color(0, 0, 0));
		btnLynda.setIcon(new ImageIcon(getClass().getResource("/pictures/L.jpg")));
		btnLynda.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnLynda.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnLynda.setBorder(null); // Reset the border when the mouse exits
		    }
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	LyndasMenu1 window = new LyndasMenu1();
				window.LyndasMenu1.setVisible(true);
		    	Store.dispose();
		    }
		});
		btnLynda.setBounds(476, 196, 433, 209);
		Store.getContentPane().add(btnLynda);
		
		JButton btnClose = new JButton("");
        btnClose.setIcon(new ImageIcon(getClass().getResource("/pictures/CLOSE X (1).png")));
        btnClose.setOpaque(true);
        btnClose.setBorderPainted(true);
        btnClose.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(8, 53, 139), new Color(8, 53, 139), new Color(8, 53, 139), new Color(8, 53, 139)), new EmptyBorder(2, 2, 2, 2)));
        btnClose.setFocusPainted(false);
        btnClose.setBackground(new Color(255, 196, 42));
        btnClose.setBounds(22, 23, 135, 25);
        Store.getContentPane().add(btnClose);
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
        		Store.dispose();
        	}
        });
		
		JLabel lblDesign = new JLabel("");
		lblDesign.setForeground(Color.WHITE);
		lblDesign.setBackground(new Color(255, 255, 255));
		lblDesign.setIcon(new ImageIcon(getClass().getResource("/pictures/home screen (13).png")));
		lblDesign.setBounds(0, 0, 1401, 800);	
		
		Store.getContentPane().add(lblDesign);
		Store.setShape(new RoundRectangle2D.Double(0, 0, Store.getWidth(), Store.getHeight(), 100, 100));
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
                Store.setLocation(x, y);
            }
        });
	}
}
