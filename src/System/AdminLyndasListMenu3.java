package System;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.util.Map;
import java.util.HashMap;


public class AdminLyndasListMenu3 {

	public JFrame LyndaListSnacks;
	private int offsetX;
    private int offsetY;
   
	/**
	 * Launch the application.
	 */
    private Map<String, Integer> dishQuantities;
    private Map<String, Integer> dishPrices;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLyndasListMenu3 window = new AdminLyndasListMenu3();
					window.LyndaListSnacks.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminLyndasListMenu3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		LyndaListSnacks = new JFrame();
		LyndaListSnacks.setUndecorated(true);
		LyndaListSnacks.setBounds(100, 100, 1401, 799);
		LyndaListSnacks.setLocationRelativeTo(null);
		LyndaListSnacks.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LyndaListSnacks.getContentPane().setLayout(null);
		
		JButton btnHistory = new JButton("");
		 btnHistory.setIcon(new ImageIcon(getClass().getResource("/Pictures/ORDER HISTORY.png")));
		   btnHistory.setOpaque(true);
		   btnHistory.setBackground(new Color(255, 255, 255));
		   btnHistory.setFocusPainted(false);
		   btnHistory.setBorderPainted(true);
		   btnHistory.setBackground(Color.WHITE);
		   btnHistory.setBounds(1174, 110, 170, 50);
		   LyndaListSnacks.getContentPane().add(btnHistory);
		   btnHistory.addMouseListener(new MouseAdapter() {
	            public void mouseEntered(MouseEvent evt) {
	            	btnHistory.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, null, null, null, null), new EmptyBorder(2, 2, 2, 2)));
	            }

	            public void mouseExited(MouseEvent evt) {
	            	btnHistory.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, null, null, null, null), new EmptyBorder(2, 2, 2, 2)));
	            }
	            public void mouseClicked(MouseEvent e) {
	            	HistoryPanelLyndas reader = new HistoryPanelLyndas();
	                reader.frame.setVisible(true);
	            }
	        });
		
	        JButton btnDish1 = new JButton("");
	        btnDish1.setBackground(Color.WHITE);
	        btnDish1.setIcon(new ImageIcon(getClass().getResource("/Pictures/LyndasAdmin  Sky Flakes.png")));
	        btnDish1.setBounds(337, 275, 170, 180);
	        LyndaListSnacks.getContentPane().add(btnDish1);
	        btnDish1.addMouseListener(new MouseAdapter() {
	        
	        	public void mouseEntered(java.awt.event.MouseEvent evt) {
	        		btnDish1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
		    }
	        	public void mouseExited(java.awt.event.MouseEvent evt) {
	        		btnDish1.setBorder(null); // Reset the border when the mouse exits
		    }
	        	public void mouseClicked(java.awt.event.MouseEvent evt) {
	                showEditDialog("SkyFlakes");
	                FileOperation.copyFile("src/data/LyndasMenu1.txt","src/data/LyndasMenu2.txt" );
	            }
	        });
	        
	        JButton btnDish2 = new JButton("");
	        btnDish2.setBackground(Color.WHITE);
	        btnDish2.setIcon(new ImageIcon(getClass().getResource("/Pictures/LyndasAdmin  Hansel.png")));
	        btnDish2.setBounds(523, 275, 170, 180);
	        LyndaListSnacks.getContentPane().add(btnDish2);
	        btnDish2.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	btnDish2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
			    }
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnDish2.setBorder(null); // Reset the border when the mouse exits
			    }
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
	                showEditDialog("Hansel");
	                FileOperation.copyFile("src/data/LyndasMenu1.txt","src/data/LyndasMenu2.txt" );
	            }
	        });
	        
	        JButton btnDish3 = new JButton("");
	        btnDish3.setBackground(Color.WHITE);
	        btnDish3.setIcon(new ImageIcon(getClass().getResource("/Pictures/LyndasAdmin  Cream-O.png")));
	        btnDish3.setBounds(709, 275, 170, 180);
	        LyndaListSnacks.getContentPane().add(btnDish3);
	        btnDish3.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	btnDish3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
			    }
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnDish3.setBorder(null); // Reset the border when the mouse exits
			    }
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
	                showEditDialog("Cream-O");
	                FileOperation.copyFile("src/data/LyndasMenu1.txt","src/data/LyndasMenu2.txt" );
	            }
	        });
	        
	        JButton btnDish4 = new JButton("");
	        btnDish4.setBackground(Color.WHITE);
	        btnDish4.setIcon(new ImageIcon(getClass().getResource("/Pictures/LyndasAdmin  Choco Mucho.png")));
	        btnDish4.setBounds(894, 275, 170, 180);
	        LyndaListSnacks.getContentPane().add(btnDish4);
	        btnDish4.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	btnDish4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
			    }
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnDish4.setBorder(null); // Reset the border when the mouse exits
			    }
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
	                showEditDialog("ChocoMucho");
	                FileOperation.copyFile("src/data/LyndasMenu1.txt","src/data/LyndasMenu2.txt" );
	            }
	        });
	        
	        JButton btnDish5 = new JButton("");
	        btnDish5.setBackground(Color.WHITE);
	        btnDish5.setIcon(new ImageIcon(getClass().getResource("/Pictures/LyndasAdmin  Fudgee Bar.png")));
	        btnDish5.setBounds(337, 468, 170, 180);
	        LyndaListSnacks.getContentPane().add(btnDish5);
	        btnDish5.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	btnDish5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
			    }
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnDish5.setBorder(null); // Reset the border when the mouse exits
			    }
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
	                showEditDialog("Fudgee_Bar");
	                FileOperation.copyFile("src/data/LyndasMenu1.txt","src/data/LyndasMenu2.txt" );
	            }
	        });
	        
	        JButton btnDish6 = new JButton("");
	        btnDish6.setBackground(Color.WHITE);
	        btnDish6.setIcon(new ImageIcon(getClass().getResource("/Pictures/LyndasAdmin  Rebisco.png")));
	        btnDish6.setBounds(523, 469, 170, 180);
	        LyndaListSnacks.getContentPane().add(btnDish6);
	        btnDish6.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	btnDish6.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
			    }
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnDish6.setBorder(null); // Reset the border when the mouse exits
			    }
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
	                showEditDialog("Rebisco");
	                FileOperation.copyFile("src/data/LyndasMenu1.txt","src/data/LyndasMenu2.txt" );
	            }
	        });
	        
	        JButton btnDish7 = new JButton("");
	        btnDish7.setBackground(Color.WHITE);
	        btnDish7.setIcon(new ImageIcon(getClass().getResource("/Pictures/LyndasAdmin  Magic Flakes.png")));
	        btnDish7.setBounds(709, 468, 170, 180);
	        LyndaListSnacks.getContentPane().add(btnDish7);
	        btnDish7.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	btnDish7.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
			    }
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnDish7.setBorder(null); // Reset the border when the mouse exits
			    }
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
	                showEditDialog("Magic_Flakes");
	                FileOperation.copyFile("src/data/LyndasMenu1.txt","src/data/LyndasMenu2.txt" );
	            }
	        });
		
		
		 
	        JButton btnDish8 = new JButton("");
	        btnDish8.setBackground(Color.WHITE);
	        btnDish8.setIcon(new ImageIcon(getClass().getResource("/Pictures/LyndasAdmin  Sandwich.png")));
	        btnDish8.setBounds(894, 468, 170, 180);
	        LyndaListSnacks.getContentPane().add(btnDish8);
	        btnDish8.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	btnDish8.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
			    }
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnDish8.setBorder(null); // Reset the border when the mouse exits
			    }
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
	                showEditDialog("Sandwich");
	                FileOperation.copyFile("src/data/LyndasMenu1.txt","src/data/LyndasMenu2.txt" );
	            }
	        });
		
		
		
		JPanel clockPanel = new JPanel();
		clockPanel.setOpaque(false);
	 	clockPanel.setBackground(new Color(0, 0, 160));
        clockPanel.setBounds(10, 10, 132, 30);
        LyndaListSnacks.getContentPane().add(clockPanel);

        // Call the showClock() method to display the clock on the panel
        FileOperation.showClock(clockPanel);
		
		//Snacks button
        JButton btnSnacks = new JButton("");
        btnSnacks.setIcon(new ImageIcon(getClass().getResource("/pictures/image 1.png")));
        btnSnacks.setOpaque(true);
        btnSnacks.setFocusPainted(false);
        btnSnacks.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        
        btnSnacks.setBackground(new Color(8, 53, 139));
        btnSnacks.setBounds(200, 160, 71, 89);
        LyndaListSnacks.getContentPane().add(btnSnacks);
        
        
        JButton btnSoda = new JButton("");  
        btnSoda.setIcon(new ImageIcon(getClass().getResource("/pictures/Soda.png")));
        btnSoda.setOpaque(true);
        btnSoda.setBorderPainted(true);
        btnSoda.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)));
        btnSoda.setFocusPainted(false);
        btnSoda.setBackground(new Color(8, 53, 139));
        btnSoda.setBounds(119, 160, 71, 89);
        LyndaListSnacks.getContentPane().add(btnSoda);
        btnSoda.addMouseListener(new MouseAdapter() {
        	
            public void mouseEntered(MouseEvent evt) {
            	btnSoda.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
                ));
            }
            public void mouseExited(MouseEvent evt) {
            	btnSoda.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
                ));
            }
            @Override
        	public void mouseClicked(MouseEvent e) {
            	AdminLyndasListMenu2 window = new AdminLyndasListMenu2();
				window.LyndaListDrinks.setVisible(true);
                LyndaListSnacks.dispose();
        		
        	}
        });

       
        // Ulam Button
        JButton btnUlam = new JButton("");
        btnUlam.setIcon(new ImageIcon(getClass().getResource("/pictures/Chicken.png")));
        btnUlam.setFocusPainted(false);
        btnUlam.setBounds(38, 160, 71, 89);
        btnUlam.setBackground(new Color(8, 53, 139));
        btnUlam.setOpaque(true);
        btnUlam.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2))); 
        LyndaListSnacks.getContentPane().add(btnUlam);
        btnUlam.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
            	btnUlam.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
                ));
            }
            public void mouseExited(MouseEvent evt) {
            	btnUlam.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
                ));
            }
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		AdminLyndasListMenu1 window = new AdminLyndasListMenu1();
				window.LyndaListUlam.setVisible(true);
                LyndaListSnacks.dispose();
        		
        	}
        });

		JButton btnLogOut = new JButton("");
        btnLogOut.setIcon(new ImageIcon(getClass().getResource("/pictures/Log Out (2).png")));
        btnLogOut.setOpaque(true);
        btnLogOut.setBorderPainted(true);
		btnLogOut.setFocusPainted(false);
        btnLogOut.setBackground(new Color(255, 255, 255));
        btnLogOut.setBounds(38, 711, 195, 50);
        LyndaListSnacks.getContentPane().add(btnLogOut);
        btnLogOut.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
            	btnLogOut.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
                ));
            }
            public void mouseExited(MouseEvent evt) {
            	btnLogOut.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
                ));
            }
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		btnLogOut.setBorder(new CompoundBorder(
        	            BorderFactory.createBevelBorder(BevelBorder.LOWERED,new Color(8, 53, 139), new Color(8, 53, 139), new Color(8, 53, 139), new Color(8, 53, 139)),
        	            new EmptyBorder(2, 2, 2, 2)
        	            
        	        ));
        	        // Perform other actions when the button is clickeds
        		
        		AdminLogin window = new AdminLogin();
                window.AdminLogin.setVisible(true);
                LyndaListSnacks.dispose();
        	}
        });
		
		
		JLabel lblDesign = new JLabel("");
		lblDesign.setIcon(new ImageIcon(getClass().getResource("/pictures/home screen (2).png")));
		lblDesign.setBounds(0, 0, 1401, 800);
		LyndaListSnacks.setShape(new RoundRectangle2D.Double(0, 0, LyndaListSnacks.getWidth(), LyndaListSnacks.getHeight(), 100, 100));
		LyndaListSnacks.getContentPane().add(lblDesign);
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
                LyndaListSnacks.setLocation(x, y);
            }
        });
		loadDishQuantities();
	}

	//load existing dish quantities and price

private void loadDishQuantities() {
    dishQuantities = new HashMap<>();
    dishPrices = new HashMap<>();
    try (BufferedReader reader = new BufferedReader(new FileReader("src/data/LyndasMenu1.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 3) {
                String dish = parts[0].trim();
                int quantity = Integer.parseInt(parts[1].trim());
                int price = Integer.parseInt(parts[2].trim());
                dishQuantities.put(dish, quantity);
                dishPrices.put(dish, price);

            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
// edit price and quantity of dish 

private void showEditDialog(String dishName) {
    Integer currentQuantity = dishQuantities.get(dishName);
    if (currentQuantity != null) {
        int currentPrice = dishPrices.get(dishName);
        String message = "Enter quantity and price (Qty,Price)\n" + dishName + " (Current Price: " + currentPrice + "):";
        String newQuantityStr = JOptionPane.showInputDialog(LyndaListSnacks, message, currentQuantity + "," + currentPrice);
        if (newQuantityStr != null) {
            try {
                String[] parts = newQuantityStr.split(",");
                if (parts.length == 2) {
                    int newQuantity = Integer.parseInt(parts[0].trim());
                    int newPrice = Integer.parseInt(parts[1].trim());
                    dishQuantities.put(dishName, newQuantity);
                    dishPrices.put(dishName, newPrice);
                    saveDishQuantities();
                    JOptionPane.showMessageDialog(LyndaListSnacks, "Quantity and price updated successfully!");
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(LyndaListSnacks, "Invalid input format! Please enter quantity and price separated by a comma (e.g., 10,5.99).");
            }
        }
    } else {
        JOptionPane.showMessageDialog(LyndaListSnacks, "Dish not found!");
    }
}
// save edited price and quantity of dish

private void saveDishQuantities() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/data/LyndasMenu1.txt"))) {
        for (Map.Entry<String, Integer> entry : dishQuantities.entrySet()) {
            String dish = entry.getKey();
            int quantity = entry.getValue();
            int price = dishPrices.get(dish);
            writer.write(dish + "," + quantity + "," + price);
            writer.newLine();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
