package System;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;

public class Menu2 extends MyPanel {

	public  JFrame Menu2;
	private int offsetX;
    private int offsetY;
    public int total;
    public JLabel totalPrice;
    private String filepath = "src/data/primeMenu1.txt";
    private String[] targetDishes = {"Coke", "Sprite", "Royal","SmartC"};
    private String[] targetDishes2 = {"Sola", "C2", "Water","Coffee"};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu2 window = new Menu2();
					window.Menu2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu2() {
		setSize(294, 307);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Menu2 = new JFrame();
		Menu2.setUndecorated(true);
		Menu2.setBounds(100, 100, 1401, 799);
		Menu2.setLocationRelativeTo(null);
		Menu2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Menu2.getContentPane().setLayout(null);
		
		int x = 210; // Starting X coordinate
        int y = 377;
        int x2 = 215;
        int y2 = 575;

        for (String targetDish : targetDishes) {
            displayDishLabel(filepath, targetDish, Menu2, x, y);
           x += 250; // Increase Y coordinate for the next label placement
        }
        for (String targetDish : targetDishes2) {
            displayDishLabel(filepath, targetDish, Menu2, x2, y2);
           x2 += 250; // Increase Y coordinate for the next label placement
        }
        JPanel clockPanel = new JPanel();
		clockPanel.setOpaque(false);
	 	clockPanel.setBackground(new Color(0, 0, 160));
        clockPanel.setBounds(10, 10, 132, 30);
        Menu2.getContentPane().add(clockPanel);

        // Call the showClock() method to display the clock on the panel
        FileOperation.showClock(clockPanel);
		
        loadDataFromFile("src/data/data.txt");
        
        JPanel panel = new JPanel();
   	 	panel.setBounds(1076, 596, 294, 30);
   	 	Menu2.getContentPane().add(panel);

   	 	totalPrice = new JLabel();
   	 	panel.add(totalPrice);
   	 	totalPrice.setFont(new Font("Arial", Font.PLAIN, 21));
   	 	totalPrice.setBackground(Color.BLACK);
   	 	totalPrice.setVisible(true);
        
        loadTextFile("src/data/total.txt");

   	 	setLocation(1076,277);
		Menu2.getContentPane().add(this);
		
		
		
		
        JButton btnUlam = new JButton("");
		btnUlam.setIcon(new ImageIcon(getClass().getResource("/pictures/Chicken.png")));
        btnUlam.setFocusPainted(false);
        btnUlam.setBackground(new Color(8, 53, 139));
        btnUlam.setOpaque(true);
        btnUlam.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)));
        btnUlam.setBounds(38, 160, 71, 89);
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
				Menu1 window = new Menu1();
				window.Menu1.setVisible(true);
				Menu2.dispose();
			}
		});
		Menu2.getContentPane().add(btnUlam);
		
		JButton btnSnacks = new JButton("");
    	btnSnacks.setIcon(new ImageIcon(getClass().getResource("/pictures/image 1.png")));
        btnSnacks.setOpaque(true);
        btnSnacks.setFocusPainted(false);
        btnSnacks.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)));
        btnSnacks.setBackground(new Color(8, 53, 139));
        btnSnacks.setBounds(200, 160, 71, 89);
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
				Menu3 window = new Menu3();
				window.Menu3.setVisible(true);
				Menu2.dispose();
			}
		});
		Menu2.getContentPane().add(btnSnacks);
		
		JButton btnSoda = new JButton("");  
		btnSoda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
     	btnSoda.setIcon(new ImageIcon(getClass().getResource("/pictures/Soda.png")));
        btnSoda.setOpaque(true);
        btnSoda.setBorderPainted(true);
        btnSoda.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        btnSoda.setFocusPainted(false);
        btnSoda.setBackground(new Color(8, 53, 139));
        btnSoda.setBounds(119, 160, 71, 89);
        Menu2.getContentPane().add(btnSoda);
		
        JButton btnBack = new JButton("");
        Menu2.getContentPane().add(btnBack);
        btnBack.setIcon(new ImageIcon(getClass().getResource("/pictures/BACK (1).png")));
        btnBack.setOpaque(true);
        btnBack.setBorderPainted(true);
        btnBack.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(8, 53, 139), new Color(8, 53, 139), new Color(8, 53, 139), new Color(8, 53, 139)), new EmptyBorder(2, 2, 2, 2)));
        btnBack.setFocusPainted(false);
        btnBack.setBackground(new Color(8, 53, 139));
        btnBack.setBounds(38, 711, 195, 50);
        Menu2.getContentPane().add(btnBack);
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
        		btnBack.setBorder(new CompoundBorder(
        	            BorderFactory.createBevelBorder(BevelBorder.LOWERED,new Color(8, 53, 139), new Color(8, 53, 139), new Color(8, 53, 139), new Color(8, 53, 139)),
        	            new EmptyBorder(2, 2, 2, 2)
        	    ));
        		String filePath = "src/data/data.txt";
        		FileOperation.clearFile(filePath);
        		Menu2.dispose();
        		Store window = new Store();
 				window.Store.setVisible(true);
                try {
                    // Copy the contents of primeMenu1.txt to primeMenu2.txt
                	FileOperation.clearFile2("src/data/total.txt");
                    Path sourceFile = Path.of("src/data/primeMenu1.txt");
                    Path destinationFile = Path.of("src/data/rimeMenu2.txt");
                    Files.copy(sourceFile, destinationFile, StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Contents of primeMenu1.txt copied to primeMenu2.txt");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }); 
        JButton btnProceed = new JButton("");
    	btnProceed.setIcon(new ImageIcon(getClass().getResource("/pictures/PROCEED.png")));
        btnProceed.setOpaque(true);
        btnProceed.setBorderPainted(true);
        btnProceed.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)));
        btnProceed.setFocusPainted(false);
        btnProceed.setBackground(new Color(8, 53, 139));
        btnProceed.setBounds(1169, 711, 195, 50);
        Menu2.getContentPane().add(btnProceed);
    	btnProceed.addMouseListener(new MouseAdapter() {
    		public void mouseEntered(MouseEvent evt) {
            	btnProceed.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
                ));
            }
            public void mouseExited(MouseEvent evt) {
            	btnProceed.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
                ));
            }
    		
     @Override
     public void mouseClicked(MouseEvent e) {
    	 
    	 String selectedItem = "rice"; // Replace with the actual selected dish
         int availableQuantity = getAvailableQuantity(selectedItem);
         
         int result = JOptionPane.showConfirmDialog(null, "Please select rice order amount", "Confirmation", JOptionPane.YES_NO_OPTION);
         if (result == JOptionPane.NO_OPTION) {
        	 StudentInformation window = new StudentInformation();
     		window.studentInfo.setVisible(true);
     		Menu2.dispose();
             // Perform the desired action for Yes
         }else{
        	 if (availableQuantity == 0) {
                 JOptionPane.showMessageDialog(Menu2, "Item is not available.", "Availability",
                         JOptionPane.INFORMATION_MESSAGE);
             } else {
                 String quantity = JOptionPane.showInputDialog(Menu2, "Available quantity:" +" "+ availableQuantity);
                 if (quantity.matches("\\d+")) {
                 int chosenQuantity = Integer.parseInt(quantity);
                 if (chosenQuantity > availableQuantity) {
                     JOptionPane.showMessageDialog(Menu2, "Choose a quantity within the available range.",
                             "Invalid Quantity", JOptionPane.WARNING_MESSAGE);
                 } else {
                 	int price = getPrice(selectedItem) * chosenQuantity;
                 	total += price;
                     try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/data/data.txt", true))) {
                         writer.write(selectedItem + "," + quantity + "," + price);
                         writer.newLine();
                         writer.flush();
                     } catch (IOException e1) {
                         e1.printStackTrace();
                     }
                    
                 	loadTextFile("src/data/total.txt");
                 	totalPrice.repaint();
                     
                 }
                     loadDataFromFile("src/data/data.txt");

                    repaint();
                    reduceQuantity(selectedItem, chosenQuantity);                     
                	Menu2.dispose();                	 
                    StudentInformation window = new StudentInformation();
                    window.studentInfo.setVisible(true);
                 	System.out.println(total);
                 	
                 	
                 	
                 	
                 }else { JOptionPane.showMessageDialog(Menu2, "Invalid input");
                 }
                 
             }
             
         }
         
     }
 });

        
		
		
		
		
		        
		        
	        
		        JButton btnDish1 = new JButton("");
		        btnDish1.setIcon(new ImageIcon(getClass().getResource("/pictures/ORDER NOW.png")));
		        btnDish1.setOpaque(true);
		        btnDish1.setBorderPainted(true);
		        btnDish1.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)));
		        btnDish1.setFocusPainted(false);
		        btnDish1.setBackground(new Color(8, 53, 139));
		        btnDish1.setBounds(138, 414, 115, 30);		        
		        Menu2.getContentPane().add(btnDish1);		        
		        btnDish1.addMouseListener(new MouseAdapter() {
		        	public void mouseEntered(java.awt.event.MouseEvent evt) {
		        		btnDish1.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
		                        ));
		            }
		            public void mouseExited(java.awt.event.MouseEvent evt) {
		            	btnDish1.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
		                        ));
		            }
		            @Override
		            public void mouseClicked(MouseEvent e) {
		                String selectedItem = "Coke"; // Replace with the actual selected dish
		                int availableQuantity = getAvailableQuantity(selectedItem);
		                

		                if (availableQuantity == 0) {
		                    JOptionPane.showMessageDialog(Menu2, "Item is not available.", "Availability",
		                            JOptionPane.INFORMATION_MESSAGE);
		                } else {
		                    String quantity = JOptionPane.showInputDialog(Menu2, "Available quantity:" +" "+ availableQuantity);

		                    int chosenQuantity = Integer.parseInt(quantity);
		                    if (chosenQuantity > availableQuantity) {
		                        JOptionPane.showMessageDialog(Menu2, "Choose a quantity within the available range.",
		                                "Invalid Quantity", JOptionPane.WARNING_MESSAGE);
		                    } else {
		                    	int price = getPrice(selectedItem) * chosenQuantity;
		                    	total+=price;
		                        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/data/data.txt", true))) {
		                            writer.write(selectedItem + "," + quantity + "," + price);
		                            writer.newLine();
		                            writer.flush();
		                        } catch (IOException e1) {
		                            e1.printStackTrace();
		                        }
		                        loadDataFromFile("src/data/data.txt");
		                        repaint();

		                        reduceQuantity(selectedItem, chosenQuantity);
		                    	System.out.println(total + "total");
		                    	
		                    	writeTextFile("src/data/total.txt", price);
		                    	loadTextFile("src/data/total.txt");
		                    	totalPrice.repaint();
		                    	

		                    }
		                }
		            }
		        });
		        JButton btnDish2 = new JButton("");
				btnDish2.setIcon(new ImageIcon(getClass().getResource("/pictures/ORDER NOW.png")));
				btnDish2.setOpaque(true);
				btnDish2.setBorderPainted(true);
				btnDish2.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)));
				btnDish2.setFocusPainted(false);			
				btnDish2.setBounds(394, 414, 115, 30);		
		        Menu2.getContentPane().add(btnDish2);
				btnDish2.setBackground(new Color(8, 53, 139));
				btnDish2.addMouseListener(new MouseAdapter() {
					public void mouseEntered(java.awt.event.MouseEvent evt) {
						btnDish2.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
				                ));
				    }
				    public void mouseExited(java.awt.event.MouseEvent evt) {
				    	btnDish2.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
				                ));
				    }
				    @Override
				    public void mouseClicked(MouseEvent e) {
				        String selectedItem = "Sprite"; // Replace with the actual selected dish
				        int availableQuantity = getAvailableQuantity(selectedItem);
				        

				        if (availableQuantity == 0) {
				            JOptionPane.showMessageDialog(Menu2, "Item is not available.", "Availability",
				                    JOptionPane.INFORMATION_MESSAGE);
				        } else {
				            String quantity = JOptionPane.showInputDialog(Menu2, "Available quantity:" +" "+ availableQuantity);

				            int chosenQuantity = Integer.parseInt(quantity);
				            if (chosenQuantity > availableQuantity) {
				                JOptionPane.showMessageDialog(Menu2, "Choose a quantity within the available range.",
				                        "Invalid Quantity", JOptionPane.WARNING_MESSAGE);
				            } else {
				            	int price = getPrice(selectedItem) * chosenQuantity;
				            	total+=price;
				                try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/data/data.txt", true))) {
				                    writer.write(selectedItem + "," + quantity + "," + price);
				                    writer.newLine();
				                    writer.flush();
				                } catch (IOException e1) {
				                    e1.printStackTrace();
				                }
				                loadDataFromFile("src/data/data.txt");
				                repaint();

				                reduceQuantity(selectedItem, chosenQuantity);
				            	System.out.println(total + "total");
				            	
				            	writeTextFile("src/data/total.txt", price);
				            	loadTextFile("src/data/total.txt");
				            	totalPrice.repaint();
				            	

				            }
				        }
				    }
				});
				
				JButton btnDish3 = new JButton("");
				btnDish3.setIcon(new ImageIcon(getClass().getResource("/pictures/ORDER NOW.png")));
				btnDish3.setOpaque(true);
				btnDish3.setBorderPainted(true);
				btnDish3.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)));
				btnDish3.setFocusPainted(false);
				btnDish3.setBounds(652, 414, 115, 30);				
				Menu2.getContentPane().add(btnDish3);				
				btnDish3.setBackground(new Color(8, 53, 139));
				btnDish3.addMouseListener(new MouseAdapter() {
					public void mouseEntered(java.awt.event.MouseEvent evt) {
						btnDish3.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
				                ));
				    }
				    public void mouseExited(java.awt.event.MouseEvent evt) {
				    	btnDish3.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
				                ));
				    }
				    @Override
				    public void mouseClicked(MouseEvent e) {
				        String selectedItem = "Royal"; // Replace with the actual selected dish
				        int availableQuantity = getAvailableQuantity(selectedItem);
				        

				        if (availableQuantity == 0) {
				            JOptionPane.showMessageDialog(Menu2, "Item is not available.", "Availability",
				                    JOptionPane.INFORMATION_MESSAGE);
				        } else {
				            String quantity = JOptionPane.showInputDialog(Menu2, "Available quantity:" +" "+ availableQuantity);

				            int chosenQuantity = Integer.parseInt(quantity);
				            if (chosenQuantity > availableQuantity) {
				                JOptionPane.showMessageDialog(Menu2, "Choose a quantity within the available range.",
				                        "Invalid Quantity", JOptionPane.WARNING_MESSAGE);
				            } else {
				            	int price = getPrice(selectedItem) * chosenQuantity;
				            	total+=price;
				                try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/data/data.txt", true))) {
				                    writer.write(selectedItem + "," + quantity + "," + price);
				                    writer.newLine();
				                    writer.flush();
				                } catch (IOException e1) {
				                    e1.printStackTrace();
				                }
				                loadDataFromFile("src/data/data.txt");
				                repaint();

				                reduceQuantity(selectedItem, chosenQuantity);
				            	System.out.println(total + "total");
				            	
				            	writeTextFile("src/data/total.txt", price);
				            	loadTextFile("src/data/total.txt");
				            	totalPrice.repaint();
				            	

				            }
				        }
				    }
				});
				
				JButton btnDish4 = new JButton("");
				btnDish4.setIcon(new ImageIcon(getClass().getResource("/pictures/ORDER NOW.png")));
				btnDish4.setOpaque(true);
				btnDish4.setBorderPainted(true);
				btnDish4.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)));
				btnDish4.setFocusPainted(false);
				btnDish4.setBackground(new Color(8, 53, 139));				
				Menu2.getContentPane().add(btnDish4);
				btnDish4.setBounds(905, 414, 115, 30);				
				btnDish4.addMouseListener(new MouseAdapter() {
					public void mouseEntered(java.awt.event.MouseEvent evt) {
						btnDish4.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
				                ));
				    }
				    public void mouseExited(java.awt.event.MouseEvent evt) {
				    	btnDish4.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
				                ));
				    }
				    @Override
				    public void mouseClicked(MouseEvent e) {
				        String selectedItem = "SmartC"; // Replace with the actual selected dish
				        int availableQuantity = getAvailableQuantity(selectedItem);
				        

				        if (availableQuantity == 0) {
				            JOptionPane.showMessageDialog(Menu2, "Item is not available.", "Availability",
				                    JOptionPane.INFORMATION_MESSAGE);
				        } else {
				            String quantity = JOptionPane.showInputDialog(Menu2, "Available quantity:" +" "+ availableQuantity);

				            int chosenQuantity = Integer.parseInt(quantity);
				            if (chosenQuantity > availableQuantity) {
				                JOptionPane.showMessageDialog(Menu2, "Choose a quantity within the available range.",
				                        "Invalid Quantity", JOptionPane.WARNING_MESSAGE);
				            } else {
				            	int price = getPrice(selectedItem) * chosenQuantity;
				            	total+=price;
				                try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/data/data.txt", true))) {
				                    writer.write(selectedItem + "," + quantity + "," + price);
				                    writer.newLine();
				                    writer.flush();
				                } catch (IOException e1) {
				                    e1.printStackTrace();
				                }
				                loadDataFromFile("src/data/data.txt");
				                repaint();

				                reduceQuantity(selectedItem, chosenQuantity);
				            	System.out.println(total + "total");
				            	
				            	writeTextFile("src/data/total.txt", price);
				            	loadTextFile("src/data/total.txt");
				            	totalPrice.repaint();
				            	

				            }
				        }
				    }
				});
				
				JButton btnDish5 = new JButton("");
				btnDish5.setIcon(new ImageIcon(getClass().getResource("/pictures/ORDER NOW.png")));
				btnDish5.setOpaque(true);
				btnDish5.setBorderPainted(true);
				btnDish5.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)));
				btnDish5.setFocusPainted(false);
				btnDish5.setBackground(new Color(8, 53, 139));			
				Menu2.getContentPane().add(btnDish5);
				btnDish5.setBounds(138, 615, 115, 30);								
				btnDish5.addMouseListener(new MouseAdapter() {
					public void mouseEntered(java.awt.event.MouseEvent evt) {
						btnDish5.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
								
				                ));
				    }
				    public void mouseExited(java.awt.event.MouseEvent evt) {
				    	btnDish5.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
				                ));
				    }
				    @Override
				    public void mouseClicked(MouseEvent e) {
				        String selectedItem = "Sola"; // Replace with the actual selected dish
				        int availableQuantity = getAvailableQuantity(selectedItem);
				        

				        if (availableQuantity == 0) {
				            JOptionPane.showMessageDialog(Menu2, "Item is not available.", "Availability",
				                    JOptionPane.INFORMATION_MESSAGE);
				        } else {
				            String quantity = JOptionPane.showInputDialog(Menu2, "Available quantity:" +" "+ availableQuantity);

				            int chosenQuantity = Integer.parseInt(quantity);
				            if (chosenQuantity > availableQuantity) {
				                JOptionPane.showMessageDialog(Menu2, "Choose a quantity within the available range.",
				                        "Invalid Quantity", JOptionPane.WARNING_MESSAGE);
				            } else {
				            	int price = getPrice(selectedItem) * chosenQuantity;
				            	total+=price;
				                try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/data/data.txt", true))) {
				                    writer.write(selectedItem + "," + quantity + "," + price);
				                    writer.newLine();
				                    writer.flush();
				                } catch (IOException e1) {
				                    e1.printStackTrace();
				                }
				                loadDataFromFile("src/data/data.txt");
				                repaint();

				                reduceQuantity(selectedItem, chosenQuantity);
				            	System.out.println(total + "total");
				            	
				            	writeTextFile("src/data/total.txt", price);
				            	loadTextFile("src/data/total.txt");
				            	totalPrice.repaint();
				            	

				            }
				        }
				    }
				});
				
				JButton btnDish6 = new JButton("");
				btnDish6.setIcon(new ImageIcon(getClass().getResource("/pictures/ORDER NOW.png")));
				btnDish6.setOpaque(true);
				btnDish6.setBorderPainted(true);
				btnDish6.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)));
				btnDish6.setFocusPainted(false);
				btnDish6.setBackground(new Color(8, 53, 139));			
				btnDish6.setBounds(394, 615, 115, 30);				
				Menu2.getContentPane().add(btnDish6);				
				btnDish6.addMouseListener(new MouseAdapter() {
					public void mouseEntered(java.awt.event.MouseEvent evt) {
						btnDish6.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
								
				                ));
				    }
				    public void mouseExited(java.awt.event.MouseEvent evt) {
				    	btnDish6.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
				                ));
				    }
				    @Override
				    public void mouseClicked(MouseEvent e) {
				        String selectedItem = "C2"; // Replace with the actual selected dish
				        int availableQuantity = getAvailableQuantity(selectedItem);
				        

				        if (availableQuantity == 0) {
				            JOptionPane.showMessageDialog(Menu2, "Item is not available.", "Availability",
				                    JOptionPane.INFORMATION_MESSAGE);
				        } else {
				            String quantity = JOptionPane.showInputDialog(Menu2, "Available quantity:" +" "+ availableQuantity);

				            int chosenQuantity = Integer.parseInt(quantity);
				            if (chosenQuantity > availableQuantity) {
				                JOptionPane.showMessageDialog(Menu2, "Choose a quantity within the available range.",
				                        "Invalid Quantity", JOptionPane.WARNING_MESSAGE);
				            } else {
				            	int price = getPrice(selectedItem) * chosenQuantity;
				            	total+=price;
				                try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/data/data.txt", true))) {
				                    writer.write(selectedItem + "," + quantity + "," + price);
				                    writer.newLine();
				                    writer.flush();
				                } catch (IOException e1) {
				                    e1.printStackTrace();
				                }
				                loadDataFromFile("src/data/data.txt");
				                repaint();

				                reduceQuantity(selectedItem, chosenQuantity);
				            	System.out.println(total + "total");
				            	
				            	writeTextFile("src/data/total.txt", price);
				            	loadTextFile("src/data/total.txt");
				            	totalPrice.repaint();
				            	

				            }
				        }
				    }
				});
				
				JButton btnDish7 = new JButton("");
				btnDish7.setIcon(new ImageIcon(getClass().getResource("/pictures/ORDER NOW.png")));
				btnDish7.setOpaque(true);
				btnDish7.setBorderPainted(true);
				btnDish7.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)));
				btnDish7.setFocusPainted(false);
				btnDish7.setBackground(new Color(8, 53, 139));				
				btnDish7.setBounds(652, 615, 115, 30);				
				Menu2.getContentPane().add(btnDish7);				
				btnDish7.addMouseListener(new MouseAdapter() {
					public void mouseEntered(java.awt.event.MouseEvent evt) {
						btnDish7.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
								
				                ));
				    }
				    public void mouseExited(java.awt.event.MouseEvent evt) {
				    	btnDish7.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
				                ));
				    }
				    @Override
				    public void mouseClicked(MouseEvent e) {
				        String selectedItem = "Water"; // Replace with the actual selected dish
				        int availableQuantity = getAvailableQuantity(selectedItem);
				        

				        if (availableQuantity == 0) {
				            JOptionPane.showMessageDialog(Menu2, "Item is not available.", "Availability",
				                    JOptionPane.INFORMATION_MESSAGE);
				        } else {
				            String quantity = JOptionPane.showInputDialog(Menu2, "Available quantity:" +" "+ availableQuantity);

				            int chosenQuantity = Integer.parseInt(quantity);
				            if (chosenQuantity > availableQuantity) {
				                JOptionPane.showMessageDialog(Menu2, "Choose a quantity within the available range.",
				                        "Invalid Quantity", JOptionPane.WARNING_MESSAGE);
				            } else {
				            	int price = getPrice(selectedItem) * chosenQuantity;
				            	total+=price;
				                try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/data/data.txt", true))) {
				                    writer.write(selectedItem + "," + quantity + "," + price);
				                    writer.newLine();
				                    writer.flush();
				                } catch (IOException e1) {
				                    e1.printStackTrace();
				                }
				                loadDataFromFile("src/data/data.txt");
				                repaint();

				                reduceQuantity(selectedItem, chosenQuantity);
				            	System.out.println(total + "total");
				            	
				            	writeTextFile("src/data/total.txt", price);
				            	loadTextFile("src/data/total.txt");
				            	totalPrice.repaint();
				            	

				            }
				        }
				    }
				});
				
				        JButton btnDish8 = new JButton("");
				        btnDish8.setIcon(new ImageIcon(getClass().getResource("/pictures/ORDER NOW.png")));
				        btnDish8.setOpaque(true);
				        btnDish8.setBorderPainted(true);
				        btnDish8.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)));
				        btnDish8.setFocusPainted(false);
				        btnDish8.setBackground(new Color(8, 53, 139));
				        Menu2.getContentPane().add(btnDish8);
				        btnDish8.setBounds(905, 615, 115, 30);						
				        btnDish8.addMouseListener(new MouseAdapter() {
							public void mouseEntered(java.awt.event.MouseEvent evt) {
								btnDish8.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
										
						                ));
						    }
						    public void mouseExited(java.awt.event.MouseEvent evt) {
						    	btnDish8.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
						                ));
						    }
				            @Override
				            public void mouseClicked(MouseEvent e) {
				                String selectedItem = "Coffee"; // Replace with the actual selected dish
				                int availableQuantity = getAvailableQuantity(selectedItem);
				                

				                if (availableQuantity == 0) {
				                    JOptionPane.showMessageDialog(Menu2, "Item is not available.", "Availability",
				                            JOptionPane.INFORMATION_MESSAGE);
				                } else {
				                    String quantity = JOptionPane.showInputDialog(Menu2, "Available quantity:" +" "+ availableQuantity);

				                    int chosenQuantity = Integer.parseInt(quantity);
				                    if (chosenQuantity > availableQuantity) {
				                        JOptionPane.showMessageDialog(Menu2, "Choose a quantity within the available range.",
				                                "Invalid Quantity", JOptionPane.WARNING_MESSAGE);
				                    } else {
				                    	int price = getPrice(selectedItem) * chosenQuantity;
				                    	total+=price;
				                        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/data/data.txt", true))) {
				                            writer.write(selectedItem + "," + quantity + "," + price);
				                            writer.newLine();
				                            writer.flush();
				                        } catch (IOException e1) {
				                            e1.printStackTrace();
				                        }
				                        loadDataFromFile("src/data/data.txt");
				                        repaint();

				                        reduceQuantity(selectedItem, chosenQuantity);
				                    	System.out.println(total + "total");
				                    	
				                    	writeTextFile("src/data/total.txt", price);
				                    	loadTextFile("src/data/total.txt");
				                    	totalPrice.repaint();
				                    	

				                    }
				                }
				            }
				        });
		       
		       
		        
		
        
        JLabel lblCokeImage = new JLabel("");
        lblCokeImage.setToolTipText("COKE MISMO (290ml)");
        lblCokeImage.setIcon(new ImageIcon(getClass().getResource("/pictures/Coke.png")));        
        lblCokeImage.setBounds(38, 300, 233, 150);
        Menu2.getContentPane().add(lblCokeImage);
        
		JLabel lblSpriteImage = new JLabel("");
		lblSpriteImage.setToolTipText("SPRITE MISMO (290ml)");
		lblSpriteImage.setIcon(new ImageIcon(getClass().getResource("/pictures/Sprite.png")));
		lblSpriteImage.setBounds(296, 300, 233, 150);
		Menu2.getContentPane().add(lblSpriteImage);
		
		JLabel lblSmartCImage = new JLabel("");
		lblSmartCImage.setToolTipText("SMART C LEMON (350ml)");
		lblSmartCImage.setIcon(new ImageIcon(getClass().getResource("/pictures/Smart C.png")));
		lblSmartCImage.setBounds(803, 300, 233, 150);
		Menu2.getContentPane().add(lblSmartCImage);
		
		JLabel lblImageCoffee = new JLabel("");
		lblImageCoffee.setToolTipText("KOPIKO, NESCAFE, GREAT TASTE");
		lblImageCoffee.setIcon(new ImageIcon(getClass().getResource("/pictures/Coffee.png")));
		lblImageCoffee.setBounds(803, 500, 233, 150);
		Menu2.getContentPane().add(lblImageCoffee);
		
		JLabel lblWaterImage = new JLabel("");
		lblWaterImage.setToolTipText("WATER BOTTLE (330ml)");
		lblWaterImage.setIcon(new ImageIcon(getClass().getResource("/pictures/Water.png")));
		lblWaterImage.setBounds(552, 500, 233, 150);
		Menu2.getContentPane().add(lblWaterImage);
		
		JLabel lblRoyalImage = new JLabel("");
		lblRoyalImage.setToolTipText("ROYAL MISMO (290ml)");
		lblRoyalImage.setIcon(new ImageIcon(getClass().getResource("/pictures/Royal.png")));
		lblRoyalImage.setBounds(552, 300, 233, 150);
		Menu2.getContentPane().add(lblRoyalImage);
		
		JLabel lblC2Image = new JLabel("");
		lblC2Image.setToolTipText("C2 APPLE GREEN TEA (355ml)");
		lblC2Image.setIcon(new ImageIcon(getClass().getResource("/pictures/C2.png")));
		lblC2Image.setBounds(296, 500, 233, 150);
		Menu2.getContentPane().add(lblC2Image);
		
		JLabel lblSolaImage = new JLabel("");
		lblSolaImage.setToolTipText("SOLA PEACH ICE TEA (473ml)");
		lblSolaImage.setIcon(new ImageIcon(getClass().getResource("/pictures/Sola.png")));
		lblSolaImage.setBounds(38, 500, 233, 150);
		Menu2.getContentPane().add(lblSolaImage);
		
		
        
        JLabel lbldesign = new JLabel("");
    	lbldesign.setIcon(new ImageIcon(getClass().getResource("/pictures/home screen (1).png")));
    	lbldesign.setBounds(0, 0, 1401, 800);
		Menu2.setShape(new RoundRectangle2D.Double(0, 0, Menu2.getWidth(), Menu2.getHeight(), 100, 100));
    	lbldesign.addMouseListener(new MouseAdapter() {
    	    @Override
    	    public void mousePressed(MouseEvent e) {
    	        offsetX = e.getX();
    	        offsetY = e.getY();
    	    }
    	});
    	lbldesign.addMouseMotionListener(new MouseAdapter() {
    	    @Override
    	    public void mouseDragged(MouseEvent e) {
    	        int x = e.getXOnScreen() - offsetX;
    	        int y = e.getYOnScreen() - offsetY;
    	        Menu2.setLocation(x, y);
    	    }
    	});
    	Menu2.getContentPane().add(lbldesign);
	}

	 private int getPrice(String item) {
	        String filePath = "src/data/primeMenu2.txt";
	        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                String[] parts = line.split(",");
	                String itemName = parts[0].trim();
	                if (itemName.equalsIgnoreCase(item)) {
	                    return Integer.parseInt(parts[2].trim());
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return 0; 
	    }
	private int getAvailableQuantity(String item) {
        String filePath = "src/data/primeMenu2.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String itemName = parts[0].trim();
                if (itemName.equalsIgnoreCase(item)) {
                    return Integer.parseInt(parts[1].trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0; 
    }
    private void reduceQuantity(String selectedItem, int chosenQuantity) {
        String primeMenu2Path = "src/data/primeMenu2.txt";
        String tempprimeMenu2Path = "src/data/primeMenu2_tmp.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(primeMenu2Path));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempprimeMenu2Path))) {
            String line;
            boolean foundItem = false;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String itemName = parts[0].trim();
                int itemQuantity = 0;
                int itemPrice = 0;

                if (parts.length >= 3) {
                    try {
                        itemQuantity = Integer.parseInt(parts[1].trim());
                        itemPrice = Integer.parseInt(parts[2].trim());
                    } catch (NumberFormatException e) {
                        // Handle the case where the quantity or price is not a valid number
                    }
                }

                if (itemName.equalsIgnoreCase(selectedItem)) {
                    itemQuantity -= chosenQuantity;
                    if (itemQuantity < 0) {
                        itemQuantity = 0; // Ensure quantity doesn't go below zero
                    }
                    System.out.println("Price: " + itemPrice);

                    // Write the modified item to the temporary file
                    writer.write(itemName + "," + itemQuantity + "," + itemPrice);
                    writer.newLine();

                    foundItem = true;
                } else {
                    // Write the original item to the temporary file
                    writer.write(line);
                    writer.newLine();
                }
            }

            // Write the remaining items from the original file
            if (!foundItem) {
                System.out.println("Selected item not found.");
            } else {
                while ((line = reader.readLine()) != null) {
                    writer.write(line);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Delete the original file and rename the temporary file
        File primeMenu2File = new File(primeMenu2Path);
        File tempFile = new File(tempprimeMenu2Path);
        if (primeMenu2File.delete() && tempFile.renameTo(primeMenu2File)) {
            System.out.println("Quantity updated successfully.");
        } else {
            System.out.println("Failed to update quantity.");
        }
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
    private void writeTextFile(String filePath, int value) {
    	try {
            File file = new File(filePath);
            
            // Read the current total from the file
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            int currentTotal = Integer.parseInt(line);
            reader.close();
            
            // Add the new value to the current total
            int updatedTotal = currentTotal + value;
            
            // Write the updated total back to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(String.valueOf(updatedTotal));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    	
    	
    }
    private static void displayDishLabel(String filePath, String targetDish, JFrame frame, int x, int y) {
        int labelHeight = 20; // Height of the label

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String dishName = parts[0];
                    //int quantity = Integer.parseInt(parts[1]);
                    int price = Integer.parseInt(parts[2]);

                    if (dishName.equalsIgnoreCase(targetDish)) {
                        JLabel label = new JLabel( String.valueOf("₱"+price));
                        label.setFont(new Font("Arial", Font.BOLD, 16));
                        label.setForeground(Color.BLACK);
                        label.setBounds(x, y, 300, labelHeight); // Set the bounds (x, y, width, height) for the label

                        frame.getContentPane().add(label);
                        break; // Exit the loop after finding the desired dish
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    


protected int checkQuantity(String selectedItem) {
	// TODO Auto-generated method stub
	return 0;
}
}
