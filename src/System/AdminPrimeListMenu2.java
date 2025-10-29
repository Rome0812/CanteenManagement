package System;


import java.awt.Color;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
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

public class AdminPrimeListMenu2 {

	public JFrame AdminListDrinks;
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
					AdminPrimeListMenu2 window = new AdminPrimeListMenu2();
					window.AdminListDrinks.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminPrimeListMenu2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		AdminListDrinks = new JFrame();
		AdminListDrinks.setUndecorated(true);
		AdminListDrinks.setBounds(100, 100, 1401, 799);
		AdminListDrinks.setLocationRelativeTo(null);
		AdminListDrinks.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AdminListDrinks.getContentPane().setLayout(null);
		
		JButton btnHistory = new JButton("");
		 btnHistory.setIcon(new ImageIcon(getClass().getResource("/Pictures/ORDER HISTORY.png")));
		   btnHistory.setOpaque(true);
		   btnHistory.setBackground(new Color(255, 255, 255));
		   btnHistory.setFocusPainted(false);
		   btnHistory.setBorderPainted(true);
		   btnHistory.setBackground(Color.WHITE);
		   btnHistory.setBounds(1174, 110, 170, 50);
		   AdminListDrinks.getContentPane().add(btnHistory);
		   btnHistory.addMouseListener(new MouseAdapter() {
	            public void mouseEntered(MouseEvent evt) {
	            	btnHistory.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, null, null, null, null), new EmptyBorder(2, 2, 2, 2)));
	            }

	            public void mouseExited(MouseEvent evt) {
	            	btnHistory.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, null, null, null, null), new EmptyBorder(2, 2, 2, 2)));
	            }
	            public void mouseClicked(MouseEvent e) {
	            	HistoryPanelPrime reader = new HistoryPanelPrime();
	               

	            }
	        });
	        
	        JButton btnDish1 = new JButton("");
	        btnDish1.setBackground(Color.WHITE);
	        btnDish1.setIcon(new ImageIcon(getClass().getResource("/Pictures/PrimeAdmin Water.png")));
	        btnDish1.setBounds(337, 275, 170, 180);
	        AdminListDrinks.getContentPane().add(btnDish1);
	        btnDish1.addMouseListener(new MouseAdapter() {
	        
	        	public void mouseEntered(java.awt.event.MouseEvent evt) {
	        		btnDish1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
		    }
	        	public void mouseExited(java.awt.event.MouseEvent evt) {
	        		btnDish1.setBorder(null); // Reset the border when the mouse exits
		    }
	        	public void mouseClicked(java.awt.event.MouseEvent evt) {
	                showEditDialog("Water");
	                FileOperation.copyFile("src/data/primeMenu1.txt","src/data/primeMenu2.txt" );

	            }
	        });
	        
	        JButton btnDish2 = new JButton("");
	        btnDish2.setBackground(Color.WHITE);
	        btnDish2.setIcon(new ImageIcon(getClass().getResource("/Pictures/PrimeAdmin Coffee.png")));
	        btnDish2.setBounds(523, 275, 170, 180);
	        AdminListDrinks.getContentPane().add(btnDish2);
	        btnDish2.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	btnDish2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
			    }
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnDish2.setBorder(null); // Reset the border when the mouse exits
			    }
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
	                showEditDialog("Coffee");
	                FileOperation.copyFile("src/data/primeMenu1.txt","src/data/primeMenu2.txt" );

	            }
	        });
	        
	        JButton btnDish3 = new JButton("");
	        btnDish3.setBackground(Color.WHITE);
	        btnDish3.setIcon(new ImageIcon(getClass().getResource("/Pictures/PrimeAdmin Sola.png")));
	        btnDish3.setBounds(709, 275, 170, 180);
	        AdminListDrinks.getContentPane().add(btnDish3);
	        btnDish3.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	btnDish3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
			    }
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnDish3.setBorder(null); // Reset the border when the mouse exits
			    }
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
	                showEditDialog("Sola");
	                FileOperation.copyFile("src/data/primeMenu1.txt","src/data/primeMenu2.txt" );

	            }
	        });
	        
	        JButton btnDish4 = new JButton("");
	        btnDish4.setBackground(Color.WHITE);
	        btnDish4.setIcon(new ImageIcon(getClass().getResource("/Pictures/PrimeAdmin C2.png")));
	        btnDish4.setBounds(894, 275, 170, 180);
	        AdminListDrinks.getContentPane().add(btnDish4);
	        btnDish4.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	btnDish4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
			    }
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnDish4.setBorder(null); // Reset the border when the mouse exits
			    }
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
	                showEditDialog("C2");
	                FileOperation.copyFile("src/data/primeMenu1.txt","src/data/primeMenu2.txt" );

	            }
	        });
	        
	        JButton btnDish5 = new JButton("");
	        btnDish5.setBackground(Color.WHITE);
	        btnDish5.setIcon(new ImageIcon(getClass().getResource("/Pictures/PrimeAdmin Royal.png")));
	        btnDish5.setBounds(337, 468, 170, 180);
	        AdminListDrinks.getContentPane().add(btnDish5);
	        btnDish5.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	btnDish5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
			    }
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnDish5.setBorder(null); // Reset the border when the mouse exits
			    }
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
	                showEditDialog("Royal");
	            }
	        });
	        
	        JButton btnDish6 = new JButton("");
	        btnDish6.setBackground(Color.WHITE);
	        btnDish6.setIcon(new ImageIcon(getClass().getResource("/Pictures/PrimeAdmin Smart C.png")));
	        btnDish6.setBounds(523, 469, 170, 180);
	        AdminListDrinks.getContentPane().add(btnDish6);
	        btnDish6.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	btnDish6.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
			    }
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnDish6.setBorder(null); // Reset the border when the mouse exits
			    }
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
	                showEditDialog("SmartC");
	                FileOperation.copyFile("src/data/primeMenu1.txt","src/data/primeMenu2.txt" );

	            }
	        });
	        
	        JButton btnDish7 = new JButton("");
	        btnDish7.setBackground(Color.WHITE);
	        btnDish7.setIcon(new ImageIcon(getClass().getResource("/Pictures/PrimeAdmin Coke.png")));
	        btnDish7.setBounds(709, 468, 170, 180);
	        AdminListDrinks.getContentPane().add(btnDish7);
	        btnDish7.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	btnDish7.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
			    }
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnDish7.setBorder(null); // Reset the border when the mouse exits
			    }
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
	                showEditDialog("Coke");
	                FileOperation.copyFile("src/data/primeMenu1.txt","src/data/primeMenu2.txt" );

	            }
	        });
		
		 
	        JButton btnDish8 = new JButton("");
	        btnDish8.setBackground(Color.WHITE);
	        btnDish8.setIcon(new ImageIcon(getClass().getResource("/Pictures/PrimeAdmin Sprite.png")));
	        btnDish8.setBounds(894, 468, 170, 180);
	        AdminListDrinks.getContentPane().add(btnDish8);
	        btnDish8.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	btnDish8.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
			    }
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnDish8.setBorder(null); // Reset the border when the mouse exits
			    }
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
	                showEditDialog("Sprite");
	                FileOperation.copyFile("src/data/primeMenu1.txt","src/data/primeMenu2.txt" );

	            }
	        });
		
		JPanel clockPanel = new JPanel();
		clockPanel.setOpaque(false);
	 	clockPanel.setBackground(new Color(0, 0, 160));
        clockPanel.setBounds(10, 10, 132, 30);
        AdminListDrinks.getContentPane().add(clockPanel);

        // Call the showClock() method to display the clock on the panel
        FileOperation.showClock(clockPanel);
        
		//Snacks button
        JButton btnSnacks = new JButton("");
        btnSnacks.setIcon(new ImageIcon(getClass().getResource("/pictures/image 1.png")));
        btnSnacks.setOpaque(true);
        btnSnacks.setFocusPainted(false);
        btnSnacks.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)));
        btnSnacks.setBackground(new Color(8, 53, 139));
        btnSnacks.setBounds(200, 160, 71, 89);
        AdminListDrinks.getContentPane().add(btnSnacks);
        btnSnacks.addMouseListener(new MouseAdapter() {
        	
                public void mouseEntered(MouseEvent evt) {
                	btnSnacks.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
                    ));
                }
                public void mouseExited(MouseEvent evt) {
                	btnSnacks.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
                    ));
                }
                @Override
            	public void mouseClicked(MouseEvent e) {
                	AdminPrimeListMenu3 window = new AdminPrimeListMenu3();
					window.AdminListSnacks.setVisible(true);
                    AdminListDrinks.dispose();
            		
            	}
            });
        
        JButton btnSoda = new JButton("");  
        btnSoda.setIcon(new ImageIcon(getClass().getResource("/pictures/Soda.png")));
        btnSoda.setOpaque(true);
        btnSoda.setBorderPainted(true);
        btnSoda.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        btnSoda.setFocusPainted(false);
        btnSoda.setBackground(new Color(8, 53, 139));
        btnSoda.setBounds(119, 160, 71, 89);
        AdminListDrinks.getContentPane().add(btnSoda);

       
        // Ulam Button
        JButton btnUlam = new JButton("");
        btnUlam.setIcon(new ImageIcon(getClass().getResource("/pictures/Chicken.png")));
        btnUlam.setFocusPainted(false);
        btnUlam.setBounds(38, 160, 71, 89);
        btnUlam.setBackground(new Color(8, 53, 139));
        btnUlam.setOpaque(true);
        btnUlam.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)));
        
        AdminListDrinks.getContentPane().add(btnUlam);
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
        		AdminPrimeListMenu1 window = new AdminPrimeListMenu1();
				window.AdminListUlam.setVisible(true);
                AdminListDrinks.dispose();
        		
        	}
        });
		
		JButton btnLogOut = new JButton("");
        btnLogOut.setIcon(new ImageIcon(getClass().getResource("/pictures/Log Out (2).png")));
        btnLogOut.setOpaque(true);
        btnLogOut.setBorderPainted(true);
		btnLogOut.setFocusPainted(false);
        btnLogOut.setBackground(new Color(255, 255, 255));
        btnLogOut.setBounds(38, 711, 195, 50);
        AdminListDrinks.getContentPane().add(btnLogOut);
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
                AdminListDrinks.dispose();
        	}
        });
        
		
		JLabel lblDesign = new JLabel("");
		lblDesign.setIcon(new ImageIcon(getClass().getResource("/pictures/home screen (1).png")));
		lblDesign.setBounds(0, 0, 1401, 800);
		AdminListDrinks.setShape(new RoundRectangle2D.Double(0, 0, AdminListDrinks.getWidth(), AdminListDrinks.getHeight(), 100, 100));
		AdminListDrinks.getContentPane().add(lblDesign);
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
                AdminListDrinks.setLocation(x, y);
            }
        });
		loadDishQuantities();
	 }   
	//load existing dish quantities and price

	private void loadDishQuantities() {
        dishQuantities = new HashMap<>();
        dishPrices = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/data/primeMenu1.txt"))) {
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
	        String newQuantityStr = JOptionPane.showInputDialog(AdminListDrinks, message, currentQuantity + "," + currentPrice);
	        if (newQuantityStr != null) {
	            try {
	                String[] parts = newQuantityStr.split(",");
	                if (parts.length == 2) {
	                    int newQuantity = Integer.parseInt(parts[0].trim());
	                    int newPrice = Integer.parseInt(parts[1].trim());
	                    dishQuantities.put(dishName, newQuantity);
	                    dishPrices.put(dishName, newPrice);
	                    saveDishQuantities();
	                    JOptionPane.showMessageDialog(AdminListDrinks, "Quantity and price updated successfully!");
	                } else {
	                    throw new NumberFormatException();
	                }
	            } catch (NumberFormatException e) {
	                JOptionPane.showMessageDialog(AdminListDrinks, "Invalid input format! Please enter quantity and price separated by a comma (e.g., 10,5.99).");
	            }
	        }
	    } else {
	        JOptionPane.showMessageDialog(AdminListDrinks, "Dish not found!");
	    }
	}
	// save edited price and quantity of dish

	private void saveDishQuantities() {
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/data/primeMenu1.txt"))) {
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