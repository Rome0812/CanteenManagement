package System;

import java.awt.*;

import java.awt.geom.RoundRectangle2D;
import javax.swing.border.*;
import javax.swing.*;
import java.io.*;
import java.nio.file.*;
import java.awt.event.*;
import java.time.LocalTime;


public class Menu1 extends MyPanel{

    public JFrame Menu1;
    private int offsetX;
    private int offsetY;
    public int total;
    public JLabel totalPrice;
    private String filepath = "src/data/primeMenu1.txt";
    private String[] targetDishes = {"Hotdog", "Hungarian_Sausage", "Spam","Maling"};
    private String[] targetDishes2 = {"Fried_Egg", "Pork_Tocino", "Skinless_Longanisa","Chicken_Sausage"};
    private String[] targetDishes3 = {"Sisig", "Fish_Fillet", "Beef_w/Broccoli","Roast_ChickenBBQ"};
    private String[] targetDishes4 = {"Roast_Pork", "Boneless_Bangus", "Chicken_Adobo","Garlic_Chicken"};
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
            	
                try {
                    Menu1 window = new Menu1();
                    window.Menu1.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Menu1() {
    	setSize(294, 307);
    	
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
    	Menu1 = new JFrame();
        Menu1.setUndecorated(true);
        Menu1.setBounds(100, 100, 1401, 799);
        Menu1.setLocationRelativeTo(null);
        Menu1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Menu1.getContentPane().setLayout(null);
 
        loadDataFromFile("src/data/data.txt");
        
        JPanel panel = new JPanel();
        panel.setBounds(1076, 596, 294, 30);
        Menu1.getContentPane().add(panel);
        
        totalPrice = new JLabel();
        panel.add(totalPrice);
        totalPrice.setFont(new Font("Arial", Font.PLAIN, 21));
        totalPrice.setBackground(Color.BLACK);
        totalPrice.setVisible(true);
        // Call the showClock() method to display the clock on the panel 
        JPanel clockPanel = new JPanel();
		clockPanel.setOpaque(false);
	 	clockPanel.setBackground(new Color(0, 0, 160));
        clockPanel.setBounds(10, 10, 132, 30);
        Menu1.getContentPane().add(clockPanel);
        FileOperation.showClock(clockPanel);
   	 	
        loadTextFile("src/data/total.txt");
   	 	setLocation(1076,277);
        Menu1.getContentPane().add(this);
        
        
        JButton btnBack = new JButton("");
        btnBack.setIcon(new ImageIcon(getClass().getResource("/pictures/BACK (1).png")));
        btnBack.setBounds(38, 711, 195, 50); 
        btnBack.setOpaque(true);
        btnBack.setBorderPainted(true);
        btnBack.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(8, 53, 139), new Color(8, 53, 139), new Color(8, 53, 139), new Color(8, 53, 139)), new EmptyBorder(2, 2, 2, 2)));
        btnBack.setFocusPainted(false);
        btnBack.setBackground(new Color(8, 53, 139));
        Menu1.getContentPane().add(btnBack);
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
        		Menu1.dispose();
        		Store window = new Store();
 				window.Store.setVisible(true);
                try {
                    // Copy the contents of primeMenu1.txt to primeMenu2.txt
                	FileOperation.clearFile2("src/data/total.txt");
                    Path sourceFile = Path.of("src/data/primeMenu1.txt");
                    Path destinationFile = Path.of("src/data/primeMenu2.txt");
                    Files.copy(sourceFile, destinationFile, StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Contents of primeMenu1.txt copied to primeMenu2.txt");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        
        	JButton btnProceed = new JButton("");
        	btnProceed.setBounds(1169, 711, 195, 50);
        	Menu1.getContentPane().add(btnProceed);
        	btnProceed.setIcon(new ImageIcon(getClass().getResource("/pictures/PROCEED.png")));
        	btnProceed.setOpaque(true);
        	btnProceed.setBorderPainted(true);
        	btnProceed.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)));
        	btnProceed.setFocusPainted(false);
        	btnProceed.setBackground(new Color(8, 53, 139));
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
                	int result = JOptionPane.showConfirmDialog(null, "Would you like to add a rice order?", "Confirmation", JOptionPane.YES_NO_OPTION);
                	if (result == JOptionPane.NO_OPTION) {
                		
                		StudentInformation window = new StudentInformation();
                		window.studentInfo.setVisible(true);
                		Menu1.dispose();
                 // Perform the desired action for Yes
                	}else{
                		if (availableQuantity == 0) {
                			JOptionPane.showMessageDialog(Menu1, "Item is not available.", "Availability",JOptionPane.INFORMATION_MESSAGE);
                		} else {
                			String quantity = JOptionPane.showInputDialog(Menu1, "Available quantity:" +" "+ availableQuantity);
                			if (quantity.matches("\\d+")) {
                				int chosenQuantity = Integer.parseInt(quantity);
                				if (chosenQuantity > availableQuantity) {
                					JOptionPane.showMessageDialog(Menu1, "Choose a quantity within the available range.","Invalid Quantity", JOptionPane.WARNING_MESSAGE);
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
                					writeTextFile("src/data/total.txt", price);
                					loadTextFile("src/data/total.txt");
                					totalPrice.repaint();
                				}
                					loadDataFromFile("src/data/data.txt");

                					repaint();

                					reduceQuantity(selectedItem, chosenQuantity);                       
                					Menu1.dispose();
                					StudentInformation window = new StudentInformation();
                					window.studentInfo.setVisible(true);	
                	}else { JOptionPane.showMessageDialog(Menu1, "Invalid input");
                     }
                     
                 }
                 
             }
             
         }
     });

	        // Call the showClock() method to display the clock on the panel
	        FileOperation.showClock(clockPanel);
         	JButton btnSoda = new JButton("");
         	btnSoda.setIcon(new ImageIcon(getClass().getResource("/pictures/Soda.png")));
            btnSoda.setOpaque(true);
            btnSoda.setBorderPainted(true);
            btnSoda.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)));
            btnSoda.setFocusPainted(false);
            btnSoda.setBackground(new Color(8, 53, 139));
            btnSoda.setBounds(119, 160, 71, 89);
            Menu1.getContentPane().add(btnSoda);
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
        	 Menu2 window = new Menu2();
        	 window.Menu2.setVisible(true);
        	 Menu1.dispose();
         		}
        	});
  	 	
        	JButton btnSnacks = new JButton("");
        	btnSnacks.setBounds(200, 160, 71, 89);
        	Menu1.getContentPane().add(btnSnacks);
        	btnSnacks.setIcon(new ImageIcon(getClass().getResource("/pictures/image 1.png")));
        	btnSnacks.setOpaque(true);
        	btnSnacks.setFocusPainted(false);
        	btnSnacks.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)));
        	btnSnacks.setBackground(new Color(8, 53, 139));
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
               	 Menu1.dispose();
             }	
        	});
        
        JButton btnUlam = new JButton("");
        btnUlam.setBounds(38, 160, 71, 89);
        btnUlam.setIcon(new ImageIcon(getClass().getResource("/pictures/Chicken.png")));
        btnUlam.setFocusPainted(false);
        btnUlam.setBackground(new Color(8, 53, 139));
        btnUlam.setOpaque(true);
        btnUlam.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        Menu1.getContentPane().add(btnUlam);
   
        		// Bring Am the panel to the front  
                JPanel amPanel = new JPanel();
                amPanel.setVisible(false);
                amPanel.setBounds(0, 0, 1401, 800);
                Menu1.getContentPane().add(amPanel);
                amPanel.setLayout(null); 
                
                int x = 210; // Starting X coordinate
                int y = 377;
                int x2 = 215;
                int y2 = 575;
                for (String targetDish : targetDishes) {
                    displayDishLabel(filepath, targetDish, null, x, y, amPanel);
                   x += 250; // Increase Y coordinate for the next label placement
                }
                for (String targetDish : targetDishes2) {
                    displayDishLabel(filepath, targetDish,null, x2, y2, amPanel);
                   x2 += 250; // Increase Y coordinate for the next label placement
                }
                                   
      //dish button
        JButton btnAmDish1 = new JButton("");
        btnAmDish1.setIcon(new ImageIcon(getClass().getResource("/pictures/ORDER NOW.png")));
        btnAmDish1.setOpaque(true);
        btnAmDish1.setBorderPainted(true);
        btnAmDish1.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)));
        btnAmDish1.setFocusPainted(false);
        btnAmDish1.setBackground(new Color(8, 53, 139));
        btnAmDish1.setBounds(145, 414, 115, 30);
        amPanel.add(btnAmDish1);
        btnAmDish1.addMouseListener(new MouseAdapter() {
           	public void mouseEntered(java.awt.event.MouseEvent evt) {
           		btnAmDish1.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
                           ));
               }
               public void mouseExited(java.awt.event.MouseEvent evt) {
               	btnAmDish1.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
                           ));
               }
            @Override
            public void mouseClicked(MouseEvent e) {
                String selectedItem = "Hotdog"; // Replace with the actual selected dish
                int availableQuantity = getAvailableQuantity(selectedItem);
                

                if (availableQuantity == 0) {
                    JOptionPane.showMessageDialog(Menu1, "Item is not available.", "Availability",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    String quantity = JOptionPane.showInputDialog(Menu1, "Available quantity:" +" "+ availableQuantity);

                    int chosenQuantity = Integer.parseInt(quantity);
                    if (chosenQuantity > availableQuantity) {
                        JOptionPane.showMessageDialog(Menu1, "Choose a quantity within the available range.",
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
        JButton btnAmDish2 = new JButton("");
        btnAmDish2.setIcon(new ImageIcon(getClass().getResource("/pictures/ORDER NOW.png")));
        btnAmDish2.setOpaque(true);
        btnAmDish2.setBorderPainted(true);
        btnAmDish2.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)));
        btnAmDish2.setFocusPainted(false);
        btnAmDish2.setBackground(new Color(8, 53, 139));
        btnAmDish2.setBounds(402, 414, 115, 30);
        amPanel.add(btnAmDish2);
        btnAmDish2.addMouseListener(new MouseAdapter() {
       	 public void mouseEntered(java.awt.event.MouseEvent evt) {
       		btnAmDish2.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
                       ));
           }
           public void mouseExited(java.awt.event.MouseEvent evt) {
           	btnAmDish2.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
                       ));
           }
   		    @Override
   		    public void mouseClicked(MouseEvent e) {
   		        String selectedItem = "Hungarian_Sausage"; // Replace with the actual selected dish
   		        int availableQuantity = getAvailableQuantity(selectedItem);
   		        

   		        if (availableQuantity == 0) {
   		            JOptionPane.showMessageDialog(Menu1, "Item is not available.", "Availability",
   		                    JOptionPane.INFORMATION_MESSAGE);
   		        } else {
   		            String quantity = JOptionPane.showInputDialog(Menu1, "Available quantity:" +" "+ availableQuantity);

   		            int chosenQuantity = Integer.parseInt(quantity);
   		            if (chosenQuantity > availableQuantity) {
   		                JOptionPane.showMessageDialog(Menu1, "Choose a quantity within the available range.",
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
        JButton btnAmDish3 = new JButton("");
        btnAmDish3.setIcon(new ImageIcon(getClass().getResource("/pictures/ORDER NOW.png")));
        btnAmDish3.setOpaque(true);
        btnAmDish3.setBorderPainted(true);
        btnAmDish3.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)));
        btnAmDish3.setFocusPainted(false);
        btnAmDish3.setBackground(new Color(8, 53, 139));
        btnAmDish3.setBounds(659, 414, 115, 30); 
        amPanel.add(btnAmDish3);
        btnAmDish3.addMouseListener(new MouseAdapter() {
        	public void mouseEntered(java.awt.event.MouseEvent evt) {
        		btnAmDish3.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
                        ));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
            	btnAmDish3.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
                        ));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                 String selectedItem = "Spam"; // Replace with the actual selected dish
                 int availableQuantity = getAvailableQuantity(selectedItem);
                    if (availableQuantity == 0) {
                        JOptionPane.showMessageDialog(Menu1, "Item is not available.", "Availability",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        String quantity = JOptionPane.showInputDialog(Menu1, "Available quantity:" +" "+ availableQuantity);

                        int chosenQuantity = Integer.parseInt(quantity);
                        if (chosenQuantity > availableQuantity) {
                            JOptionPane.showMessageDialog(Menu1, "Choose a quantity within the available range.",
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
        
           	JButton btnAmDish4 = new JButton("");
           	btnAmDish4.setIcon(new ImageIcon(getClass().getResource("/pictures/ORDER NOW.png")));
           	btnAmDish4.setOpaque(true);
           	btnAmDish4.setBorderPainted(true);
           	btnAmDish4.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)));
           	btnAmDish4.setFocusPainted(false);
           	btnAmDish4.setBackground(new Color(8, 53, 139));
           	btnAmDish4.setBounds(910, 414, 115, 30);
           	amPanel.add(btnAmDish4);
           	btnAmDish4.addMouseListener(new MouseAdapter() {
           		public void mouseEntered(java.awt.event.MouseEvent evt) {
           		btnAmDish4.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
                           ));
               }
               public void mouseExited(java.awt.event.MouseEvent evt) {
               	btnAmDish4.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
                           ));
               }
                   @Override
                   public void mouseClicked(MouseEvent e) {
                       String selectedItem = "Maling"; // Replace with the actual selected dish
                       int availableQuantity = getAvailableQuantity(selectedItem);
                       if (availableQuantity == 0) {
                           JOptionPane.showMessageDialog(Menu1, "Item is not available.", "Availability",
                                   JOptionPane.INFORMATION_MESSAGE);
                       } else {
                           String quantity = JOptionPane.showInputDialog(Menu1, "Available quantity:" +" "+ availableQuantity);

                           int chosenQuantity = Integer.parseInt(quantity);
                           if (chosenQuantity > availableQuantity) {
                               JOptionPane.showMessageDialog(Menu1, "Choose a quantity within the available range.",
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
           	
           	JButton btnAmDish5 = new JButton("");
           	btnAmDish5.setIcon(new ImageIcon(getClass().getResource("/pictures/ORDER NOW.png")));
           	btnAmDish5.setOpaque(true);
           	btnAmDish5.setBorderPainted(true);
           	btnAmDish5.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)));
           	btnAmDish5.setFocusPainted(false);
           	btnAmDish5.setBackground(new Color(8, 53, 139));
           	btnAmDish5.setBounds(145, 615, 115, 30);
           	amPanel.add(btnAmDish5);
           	btnAmDish5.addMouseListener(new MouseAdapter() {
           			public void mouseEntered(java.awt.event.MouseEvent evt) {
           			btnAmDish5.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
           	                ));
           	    }
           	    public void mouseExited(java.awt.event.MouseEvent evt) {
           	    	btnAmDish5.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
           	                ));
           	    }
           	    @Override
           	    public void mouseClicked(MouseEvent e) {
           	        String selectedItem = "Fried_Egg"; // Replace with the actual selected dish
           	        int availableQuantity = getAvailableQuantity(selectedItem);
           	        

           	        if (availableQuantity == 0) {
           	            JOptionPane.showMessageDialog(Menu1, "Item is not available.", "Availability",
           	                    JOptionPane.INFORMATION_MESSAGE);
           	        } else {
           	            String quantity = JOptionPane.showInputDialog(Menu1, "Available quantity:" +" "+ availableQuantity);

           	            int chosenQuantity = Integer.parseInt(quantity);
           	            if (chosenQuantity > availableQuantity) {
           	                JOptionPane.showMessageDialog(Menu1, "Choose a quantity within the available range.",
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
           	
           	JButton btnAmDish6 = new JButton("");
           	btnAmDish6.setIcon(new ImageIcon(getClass().getResource("/pictures/ORDER NOW.png")));
           	btnAmDish6.setOpaque(true);
           	btnAmDish6.setBorderPainted(true);
           	btnAmDish6.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)));
           	btnAmDish6.setFocusPainted(false);
           	btnAmDish6.setBackground(new Color(8, 53, 139));
           	btnAmDish6.setBounds(402, 615, 115, 30);
           	amPanel.add(btnAmDish6);
           	btnAmDish6.addMouseListener(new MouseAdapter() {
           		public void mouseEntered(java.awt.event.MouseEvent evt) {
           			btnAmDish6.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
           	                ));
           	    }
           	    public void mouseExited(java.awt.event.MouseEvent evt) {
           	    	btnAmDish6.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
           	                ));
           	    }
           	    @Override
           	    public void mouseClicked(MouseEvent e) {
           	        String selectedItem = "Pork_Tocino"; // Replace with the actual selected dish
           	        int availableQuantity = getAvailableQuantity(selectedItem);
           	        

           	        if (availableQuantity == 0) {
           	            JOptionPane.showMessageDialog(Menu1, "Item is not available.", "Availability",
           	                    JOptionPane.INFORMATION_MESSAGE);
           	        } else {
           	            String quantity = JOptionPane.showInputDialog(Menu1, "Available quantity:" +" "+ availableQuantity);

           	            int chosenQuantity = Integer.parseInt(quantity);
           	            if (chosenQuantity > availableQuantity) {
           	                JOptionPane.showMessageDialog(Menu1, "Choose a quantity within the available range.",
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
           	
           	JButton btnAmDish7 = new JButton("");
           	btnAmDish7.setIcon(new ImageIcon(getClass().getResource("/pictures/ORDER NOW.png")));
           	btnAmDish7.setOpaque(true);
           	btnAmDish7.setBorderPainted(true);
           	btnAmDish7.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)));
           	btnAmDish7.setFocusPainted(false);
           	btnAmDish7.setBackground(new Color(8, 53, 139));
           	btnAmDish7.setBounds(659, 615, 115, 30);
           	amPanel.add(btnAmDish7);
           	btnAmDish7.addMouseListener(new MouseAdapter() {
           		public void mouseEntered(java.awt.event.MouseEvent evt) {
           			btnAmDish7.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
           	                ));
           	    }
           	    public void mouseExited(java.awt.event.MouseEvent evt) {
           	    	btnAmDish7.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
           	                ));
           	    }
           	    @Override
           	    public void mouseClicked(MouseEvent e) {
           	        String selectedItem = "Skinless_Longanisa"; // Replace with the actual selected dish
           	        int availableQuantity = getAvailableQuantity(selectedItem);
           	        

           	        if (availableQuantity == 0) {
           	            JOptionPane.showMessageDialog(Menu1, "Item is not available.", "Availability",
           	                    JOptionPane.INFORMATION_MESSAGE);
           	        } else {
           	            String quantity = JOptionPane.showInputDialog(Menu1, "Available quantity:" +" "+ availableQuantity);

           	            int chosenQuantity = Integer.parseInt(quantity);
           	            if (chosenQuantity > availableQuantity) {
           	                JOptionPane.showMessageDialog(Menu1, "Choose a quantity within the available range.",
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
           	
           	JButton btnAmDish8 = new JButton("");
           	btnAmDish8.setIcon(new ImageIcon(getClass().getResource("/pictures/ORDER NOW.png")));
           	btnAmDish8.setOpaque(true);
           	btnAmDish8.setBorderPainted(true);
           	btnAmDish8.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)));
           	btnAmDish8.setFocusPainted(false);
           	btnAmDish8.setBackground(new Color(8, 53, 139));
           	btnAmDish8.setBounds(910, 615, 116, 30);
           	amPanel.add(btnAmDish8);
           	btnAmDish8.addMouseListener(new MouseAdapter() {
           		public void mouseEntered(java.awt.event.MouseEvent evt) {
           			btnAmDish8.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
           	                ));
           	    }
           	    public void mouseExited(java.awt.event.MouseEvent evt) {
           	    	btnAmDish8.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
           	                ));
           	    }
           	    @Override
           	    public void mouseClicked(MouseEvent e) {
           	        String selectedItem = "Chicken_Sausage"; // Replace with the actual selected dish
           	        int availableQuantity = getAvailableQuantity(selectedItem);
           	        

           	        if (availableQuantity == 0) {
           	            JOptionPane.showMessageDialog(Menu1, "Item is not available.", "Availability",
           	                    JOptionPane.INFORMATION_MESSAGE);
           	        } else {
           	            String quantity = JOptionPane.showInputDialog(Menu1, "Available quantity:" +" "+ availableQuantity);

           	            int chosenQuantity = Integer.parseInt(quantity);
           	            if (chosenQuantity > availableQuantity) {
           	                JOptionPane.showMessageDialog(Menu1, "Choose a quantity within the available range.",
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
            JLabel lblHotDogImage = new JLabel("");
            lblHotDogImage.setToolTipText(" A popular sausage made from seasoned ground meat, usually pork, beef, or chicken, often grilled or pan-fried");
            lblHotDogImage.setIcon(new ImageIcon(getClass().getResource("/pictures/HotDog.png")));
            lblHotDogImage.setBounds(38, 300, 233, 150);
            amPanel.add(lblHotDogImage); 
            
            JLabel lblHungariannSuasageImage = new JLabel("");
            lblHungariannSuasageImage.setToolTipText("A flavorful pork sausage seasoned with paprika and other spices, offering a slightly spicy and smoky taste");
           	lblHungariannSuasageImage.setIcon(new ImageIcon(getClass().getResource("/pictures/Hungarian Sausage.png")));
           	lblHungariannSuasageImage.setBounds(296, 300, 233, 150);
           	amPanel.add(lblHungariannSuasageImage);
                    	           	           	
           	JLabel lblSpamImage = new JLabel("");
           	lblSpamImage.setToolTipText("A canned meat product made from chopped pork shoulder, ham, salt, water, sugar, and spices. It is often sliced and pan-fried, providing a versatile and savory addition to meals and sandwiches.");
           	lblSpamImage.setIcon(new ImageIcon(getClass().getResource("/pictures/Spam.png")));
           	lblSpamImage.setBounds(552, 300, 233, 150);
           	amPanel.add(lblSpamImage);
           	
           	JLabel lblMalingImage = new JLabel("");
           	lblMalingImage.setToolTipText("A canned luncheon meat similar to Spam, made from finely ground pork and seasonings.");
           	lblMalingImage.setIcon(new ImageIcon(getClass().getResource("/pictures/Maling.png")));
           	lblMalingImage.setBounds(803, 300, 233, 150);
           	amPanel.add(lblMalingImage);
           	
           	JLabel lblFriedEggImage = new JLabel("");
           	lblFriedEggImage.setToolTipText("An egg cooked in a hot pan with oil or butter until the white is set and the yolk can be runny or cooked to desired doneness.");
           	lblFriedEggImage.setIcon(new ImageIcon(getClass().getResource("/pictures/Fried Egg.png")));
           	lblFriedEggImage.setBounds(38, 500, 233, 150);
           	amPanel.add(lblFriedEggImage);
           	
           	JLabel lblPorkTocinoImage = new JLabel("");
           	lblPorkTocinoImage.setToolTipText("A sweet and savory Filipino-style cured pork, usually marinated with a mixture of sugar, soy sauce, garlic, and other seasonings. ");
           	lblPorkTocinoImage.setIcon(new ImageIcon(getClass().getResource("/pictures/Pork Tocino.png")));
           	lblPorkTocinoImage.setBounds(296, 500, 233, 150);
           	amPanel.add(lblPorkTocinoImage);
           	
           	JLabel lblSkinlessLonganisaImage = new JLabel("");
           	lblSkinlessLonganisaImage.setToolTipText("A type of Filipino sausage made from ground pork and various seasonings, typically without the natural casing.");
           	lblSkinlessLonganisaImage.setIcon(new ImageIcon(getClass().getResource("/pictures/Skinless Longanisa.png")));
           	lblSkinlessLonganisaImage.setBounds(552, 500, 233, 150);
           	amPanel.add(lblSkinlessLonganisaImage);
           	
        	JLabel lblChickenSausageImage = new JLabel("");
        	lblChickenSausageImage.setToolTipText("Sausages made from ground chicken, seasoned with herbs, spices, and other flavorings. They are versatile and can be grilled, pan-fried, or used as an ingredient in various dishes.");
           	lblChickenSausageImage.setIcon(new ImageIcon(getClass().getResource("/pictures/Chicken Sausage.png")));
           	lblChickenSausageImage.setBounds(803, 500, 233, 150);
           	amPanel.add(lblChickenSausageImage);
                                                   			
               
            //Am Design
        	JLabel lbldesign = new JLabel("");
        	lbldesign.setIcon(new ImageIcon(getClass().getResource("/pictures/home screen (1).png")));
        	lbldesign.setBounds(0, 0, 1401, 800);
        	amPanel.add(lbldesign);
        	
        	 //Pm panel
        	JPanel pmPanel = new JPanel();
        	pmPanel.setLayout(null);
        	pmPanel.setBounds(0, 0, 1401, 800);
        	Menu1.getContentPane().add(pmPanel);
        	
        	int x3 = 210; // Starting X coordinate
            int y3 = 388;
            int x4 = 210; // Starting X coordinate
            int y4 = 585;
             
             
             for (String targetDish : targetDishes3) {
                 displayDishLabel(filepath, targetDish,null, x3, y3, pmPanel);
                x3 += 250; // Increase Y coordinate for the next label placement
             }
             for (String targetDish : targetDishes4) {
                 displayDishLabel(filepath, targetDish,null, x4, y4,pmPanel);
                x4 += 250; // Increase Y coordinate for the next label placement
             }
             
               
               //Pm Dish Button
               JButton btnPmDish1 = new JButton("");
               btnPmDish1.setIcon(new ImageIcon(getClass().getResource("/pictures/ORDER NOW.png")));
               btnPmDish1.setOpaque(true);
               btnPmDish1.setBorderPainted(true);
               btnPmDish1.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)));
               btnPmDish1.setFocusPainted(false);
               btnPmDish1.setBackground(new Color(8, 53, 139));
               btnPmDish1.setBounds(145, 414, 115, 30);
               pmPanel.add(btnPmDish1);
               btnPmDish1.addMouseListener(new MouseAdapter() {
               	public void mouseEntered(java.awt.event.MouseEvent evt) {
               		btnPmDish1.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
                               ));
                   }
                   public void mouseExited(java.awt.event.MouseEvent evt) {
                   	btnPmDish1.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
                               ));
                   }
                   @Override
                   public void mouseClicked(MouseEvent e) {
                       String selectedItem = "Sisig"; // Replace with the actual selected dish
                       int availableQuantity = getAvailableQuantity(selectedItem);
                       

                       if (availableQuantity == 0) {
                           JOptionPane.showMessageDialog(Menu1, "Item is not available.", "Availability",
                                   JOptionPane.INFORMATION_MESSAGE);
                       } else {
                           String quantity = JOptionPane.showInputDialog(Menu1, "Available quantity:" +" "+ availableQuantity);

                           int chosenQuantity = Integer.parseInt(quantity);
                           if (chosenQuantity > availableQuantity) {
                               JOptionPane.showMessageDialog(Menu1, "Choose a quantity within the available range.",
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
               JButton btnPmDish2 = new JButton("");
               btnPmDish2.setIcon(new ImageIcon(getClass().getResource("/pictures/ORDER NOW.png")));
               btnPmDish2.setOpaque(true);
               btnPmDish2.setBorderPainted(true);
               btnPmDish2.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)));
               btnPmDish2.setFocusPainted(false);
               btnPmDish2.setBackground(new Color(8, 53, 139));
               btnPmDish2.setBounds(402, 414, 115, 30);
               pmPanel.add(btnPmDish2);
               btnPmDish2.addMouseListener(new MouseAdapter() {
               	public void mouseEntered(java.awt.event.MouseEvent evt) {
               		btnPmDish2.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
                               ));
                   }
                   public void mouseExited(java.awt.event.MouseEvent evt) {
                   	btnPmDish2.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
                               ));
                   }
                   @Override
                   public void mouseClicked(MouseEvent e) {
                       String selectedItem = "Fish_Fillet"; // Replace with the actual selected dish
                       int availableQuantity = getAvailableQuantity(selectedItem);
                       

                       if (availableQuantity == 0) {
                           JOptionPane.showMessageDialog(Menu1, "Item is not available.", "Availability",
                                   JOptionPane.INFORMATION_MESSAGE);
                       } else {
                           String quantity = JOptionPane.showInputDialog(Menu1, "Available quantity:" +" "+ availableQuantity);

                           int chosenQuantity = Integer.parseInt(quantity);
                           if (chosenQuantity > availableQuantity) {
                               JOptionPane.showMessageDialog(Menu1, "Choose a quantity within the available range.",
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
               JButton btnPmDish3 = new JButton("");
               btnPmDish3.setIcon(new ImageIcon(getClass().getResource("/pictures/ORDER NOW.png")));
               btnPmDish3.setOpaque(true);
               btnPmDish3.setBorderPainted(true);
               btnPmDish3.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)));
               btnPmDish3.setFocusPainted(false);
               btnPmDish3.setBackground(new Color(8, 53, 139));
               btnPmDish3.setBounds(659, 414, 115, 30);
               pmPanel.add(btnPmDish3);
               btnPmDish3.addMouseListener(new MouseAdapter() {
               	public void mouseEntered(java.awt.event.MouseEvent evt) {
               		btnPmDish3.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
                               ));
                   }
                   public void mouseExited(java.awt.event.MouseEvent evt) {
                   	btnPmDish3.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
                               ));
                   }
                   @Override
                   public void mouseClicked(MouseEvent e) {
                       String selectedItem = "Beef_w/Broccoli"; // Replace with the actual selected dish
                       int availableQuantity = getAvailableQuantity(selectedItem);
                       

                       if (availableQuantity == 0) {
                           JOptionPane.showMessageDialog(Menu1, "Item is not available.", "Availability",
                                   JOptionPane.INFORMATION_MESSAGE);
                       } else {
                           String quantity = JOptionPane.showInputDialog(Menu1, "Available quantity:" +" "+ availableQuantity);

                           int chosenQuantity = Integer.parseInt(quantity);
                           if (chosenQuantity > availableQuantity) {
                               JOptionPane.showMessageDialog(Menu1, "Choose a quantity within the available range.",
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
               
                              JButton btnPmDish4 = new JButton("");
                              btnPmDish4.setIcon(new ImageIcon(getClass().getResource("/pictures/ORDER NOW.png")));
                              btnPmDish4.setOpaque(true);
                              btnPmDish4.setBorderPainted(true);
                              btnPmDish4.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)));
                              btnPmDish4.setFocusPainted(false);
                              btnPmDish4.setBackground(new Color(8, 53, 139));
                              btnPmDish4.setBounds(910, 414, 115, 30);
                              pmPanel.add(btnPmDish4);
                              btnPmDish4.addMouseListener(new MouseAdapter() {
                              	public void mouseEntered(java.awt.event.MouseEvent evt) {
                              		btnPmDish4.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
                                              ));
                                  }
                                  public void mouseExited(java.awt.event.MouseEvent evt) {
                                  	btnPmDish4.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
                                              ));
                                  }
                                  @Override
                                  public void mouseClicked(MouseEvent e) {
                                      String selectedItem = "Roast_ChickenBBQ"; // Replace with the actual selected dish
                                      int availableQuantity = getAvailableQuantity(selectedItem);
                                      

                                      if (availableQuantity == 0) {
                                          JOptionPane.showMessageDialog(Menu1, "Item is not available.", "Availability",
                                                  JOptionPane.INFORMATION_MESSAGE);
                                      } else {
                                          String quantity = JOptionPane.showInputDialog(Menu1, "Available quantity:" +" "+ availableQuantity);

                                          int chosenQuantity = Integer.parseInt(quantity);
                                          if (chosenQuantity > availableQuantity) {
                                              JOptionPane.showMessageDialog(Menu1, "Choose a quantity within the available range.",
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
                              JButton btnPmDish5 = new JButton("");
                              btnPmDish5.setIcon(new ImageIcon(getClass().getResource("/pictures/ORDER NOW.png")));
                              btnPmDish5.setOpaque(true);
                              btnPmDish5.setBorderPainted(true);
                              btnPmDish5.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)));
                              btnPmDish5.setFocusPainted(false);
                              btnPmDish5.setBackground(new Color(8, 53, 139));
                              btnPmDish5.setBounds(145, 615, 115, 30);
                              pmPanel.add(btnPmDish5);
                              btnPmDish5.addMouseListener(new MouseAdapter() {
                              	public void mouseEntered(java.awt.event.MouseEvent evt) {
                              		btnPmDish5.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
                                              ));
                                  }
                                  public void mouseExited(java.awt.event.MouseEvent evt) {
                                  	btnPmDish5.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
                                              ));
                                  }
                                  @Override
                                  public void mouseClicked(MouseEvent e) {
                                      String selectedItem = "Roast_Pork"; // Replace with the actual selected dish
                                      int availableQuantity = getAvailableQuantity(selectedItem);
                                      

                                      if (availableQuantity == 0) {
                                          JOptionPane.showMessageDialog(Menu1, "Item is not available.", "Availability",
                                                  JOptionPane.INFORMATION_MESSAGE);
                                      } else {
                                          String quantity = JOptionPane.showInputDialog(Menu1, "Available quantity:" +" "+ availableQuantity);

                                          int chosenQuantity = Integer.parseInt(quantity);
                                          if (chosenQuantity > availableQuantity) {
                                              JOptionPane.showMessageDialog(Menu1, "Choose a quantity within the available range.",
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
                              JButton btnPmDish6 = new JButton("");
                              btnPmDish6.setIcon(new ImageIcon(getClass().getResource("/pictures/ORDER NOW.png")));
                              btnPmDish6.setOpaque(true);
                              btnPmDish6.setBorderPainted(true);
                              btnPmDish6.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)));
                              btnPmDish6.setFocusPainted(false);
                              btnPmDish6.setBackground(new Color(8, 53, 139));
                              btnPmDish6.setBounds(402, 615, 115, 30);
                              pmPanel.add(btnPmDish6);
                              btnPmDish6.addMouseListener(new MouseAdapter() {
                              	public void mouseEntered(java.awt.event.MouseEvent evt) {
                              		btnPmDish6.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
                                              ));
                                  }
                                  public void mouseExited(java.awt.event.MouseEvent evt) {
                                  	btnPmDish6.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
                                              ));
                                  }
                                  @Override
                                  public void mouseClicked(MouseEvent e) {
                                      String selectedItem = "Boneless_Bangus"; // Replace with the actual selected dish
                                      int availableQuantity = getAvailableQuantity(selectedItem);
                                      

                                      if (availableQuantity == 0) {
                                          JOptionPane.showMessageDialog(Menu1, "Item is not available.", "Availability",
                                                  JOptionPane.INFORMATION_MESSAGE);
                                      } else {
                                          String quantity = JOptionPane.showInputDialog(Menu1, "Available quantity:" +" "+ availableQuantity);

                                          int chosenQuantity = Integer.parseInt(quantity);
                                          if (chosenQuantity > availableQuantity) {
                                              JOptionPane.showMessageDialog(Menu1, "Choose a quantity within the available range.",
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
                              JButton btnPmDish7 = new JButton("");
                              btnPmDish7.setIcon(new ImageIcon(getClass().getResource("/pictures/ORDER NOW.png")));
                              btnPmDish7.setOpaque(true);
                              btnPmDish7.setBorderPainted(true);
                              btnPmDish7.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)));
                              btnPmDish7.setFocusPainted(false);
                              btnPmDish7.setBackground(new Color(8, 53, 139));
                              btnPmDish7.setBounds(659, 615, 115, 30);
                              pmPanel.add(btnPmDish7);
                              btnPmDish7.addMouseListener(new MouseAdapter() {
                              	public void mouseEntered(java.awt.event.MouseEvent evt) {
                              		btnPmDish7.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
                                              ));
                                  }
                                  public void mouseExited(java.awt.event.MouseEvent evt) {
                                  	btnPmDish7.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
                                              ));
                                  }
                                  @Override
                                  public void mouseClicked(MouseEvent e) {
                                      String selectedItem = "Chicken_Adobo"; // Replace with the actual selected dish
                                      int availableQuantity = getAvailableQuantity(selectedItem);
                                      

                                      if (availableQuantity == 0) {
                                          JOptionPane.showMessageDialog(Menu1, "Item is not available.", "Availability",
                                                  JOptionPane.INFORMATION_MESSAGE);
                                      } else {
                                          String quantity = JOptionPane.showInputDialog(Menu1, "Available quantity:" +" "+ availableQuantity);

                                          int chosenQuantity = Integer.parseInt(quantity);
                                          if (chosenQuantity > availableQuantity) {
                                              JOptionPane.showMessageDialog(Menu1, "Choose a quantity within the available range.",
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
                              JButton btnPmDish8 = new JButton("");
                              btnPmDish8.setIcon(new ImageIcon(getClass().getResource("/pictures/ORDER NOW.png")));
                              btnPmDish8.setOpaque(true);
                              btnPmDish8.setBorderPainted(true);
                              btnPmDish8.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)));
                              btnPmDish8.setFocusPainted(false);
                              btnPmDish8.setBackground(new Color(8, 53, 139));
                              btnPmDish8.setBounds(910, 615, 116, 30);
                              pmPanel.add(btnPmDish8);
                              btnPmDish8.addMouseListener(new MouseAdapter() {
                              	public void mouseEntered(java.awt.event.MouseEvent evt) {
                              		btnPmDish8.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
                                              ));
                                  }
                                  public void mouseExited(java.awt.event.MouseEvent evt) {
                                  	btnPmDish8.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)
                                              ));
                                  }
                                  @Override
                                  public void mouseClicked(MouseEvent e) {
                                      String selectedItem = "Garlic_Chicken"; // Replace with the actual selected dish
                                      int availableQuantity = getAvailableQuantity(selectedItem);
                                      

                                      if (availableQuantity == 0) {
                                          JOptionPane.showMessageDialog(Menu1, "Item is not available.", "Availability",
                                                  JOptionPane.INFORMATION_MESSAGE);
                                      } else {
                                          String quantity = JOptionPane.showInputDialog(Menu1, "Available quantity:" +" "+ availableQuantity);

                                          int chosenQuantity = Integer.parseInt(quantity);
                                          if (chosenQuantity > availableQuantity) {
                                              JOptionPane.showMessageDialog(Menu1, "Choose a quantity within the available range.",
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
                              JLabel lblSisigImage = new JLabel("");
                              lblSisigImage.setToolTipText("A flavorful dish made from chopped and seasoned parts of a pig's head or belly, often served sizzling hot with onions, chili peppers, and calamansi juice.");
                              lblSisigImage.setIcon(new ImageIcon(getClass().getResource("/pictures/Sisig.png")));
                              lblSisigImage.setBounds(38, 300, 233, 150);
                              pmPanel.add(lblSisigImage);                                    
                              
                              JLabel lblFishFilletImage = new JLabel("");
                              lblFishFilletImage.setToolTipText("Boneless and skinless pieces of fish, breaded or battered, then deep-fried until crispy and golden. It is commonly served with a dipping sauce or lemon wedges.");
                              lblFishFilletImage.setIcon(new ImageIcon(getClass().getResource("/pictures/Fish Fillet.png")));
                              lblFishFilletImage.setBounds(296, 300, 233, 150);
                              pmPanel.add(lblFishFilletImage);
                              
                              JLabel lblBeefBrocolliImage = new JLabel("");
                              lblBeefBrocolliImage.setToolTipText("A classic stir-fry dish featuring tender slices of beef and fresh broccoli florets cooked in a savory sauce");
                              lblBeefBrocolliImage.setIcon(new ImageIcon(getClass().getResource("/pictures/Beef Brocolli.png")));
                              lblBeefBrocolliImage.setBounds(552, 300, 233, 150);
                              pmPanel.add(lblBeefBrocolliImage);
                              
                              JLabel lblRostedChickenBBQImage = new JLabel("");
                              lblRostedChickenBBQImage.setToolTipText("Succulent chicken marinated with barbecue sauce and roasted until tender and flavorful, providing a smoky and tangy taste.");
                              lblRostedChickenBBQImage.setIcon(new ImageIcon(getClass().getResource("/pictures/Roast ChickenBBQ.png")));
                              lblRostedChickenBBQImage.setBounds(803, 300, 233, 150);
                              pmPanel.add(lblRostedChickenBBQImage);
                              
                              JLabel lblRoastPorkImage = new JLabel("");
                              lblRoastPorkImage.setToolTipText("Also known as lechon or lechon kawali, roast pork is a beloved Filipino dish made by roasting a whole pig or pork belly until the skin becomes crispy, resulting in a juicy and indulgent treat.");
                              lblRoastPorkImage.setIcon(new ImageIcon(getClass().getResource("/pictures/Roast Pork.png")));
                              lblRoastPorkImage.setBounds(38, 500, 233, 150);
                              pmPanel.add(lblRoastPorkImage);
                              
                              JLabel lblBonelessBangusImage = new JLabel("");
                              lblBonelessBangusImage.setToolTipText("Milkfish fillets that have been deboned, making them easy to eat. They are typically marinated and then either pan-fried or grilled, offering a delicate and flavorful seafood option");
                              lblBonelessBangusImage.setIcon(new ImageIcon(getClass().getResource("/pictures/Boneless Bangus.png")));
                              lblBonelessBangusImage.setBounds(296, 500, 233, 150);
                              pmPanel.add(lblBonelessBangusImage);
                              
                              JLabel lblChickenAdoboImage = new JLabel("");
                              lblChickenAdoboImage.setToolTipText("A quintessential Filipino dish made by simmering chicken pieces in a mixture of vinegar, soy sauce, garlic, and spices, resulting in a savory and tangy flavor profile");
                              lblChickenAdoboImage.setIcon(new ImageIcon(getClass().getResource("/pictures/Chicken Adobo.png")));
                              lblChickenAdoboImage.setBounds(552, 500, 233, 150);
                              pmPanel.add(lblChickenAdoboImage);
                              
                              JLabel lblGarlicChickenImage = new JLabel("");
                              lblGarlicChickenImage.setToolTipText("Tender chicken pieces marinated with garlic, herbs, and spices, then cooked until infused with aromatic flavors, providing a satisfying and fragrant dish");
                              lblGarlicChickenImage.setIcon(new ImageIcon(getClass().getResource("/pictures/Garlic Chicken.png")));
                              lblGarlicChickenImage.setBounds(803, 500, 233, 150);
                              pmPanel.add(lblGarlicChickenImage);
                              
                              //Design Copy for Pm
           	JLabel lbldesignPm = new JLabel();
           	lbldesignPm.setIcon(new ImageIcon(getClass().getResource("/pictures/home screen (1).png")));
           	lbldesignPm.setBounds(0, 0, 1401, 800);
           	lbldesignPm.addMouseListener(new MouseAdapter() {
           	    @Override
           	    public void mousePressed(MouseEvent e) {
           	        offsetX = e.getX();
           	        offsetY = e.getY();
           	    }
           	});
           	lbldesignPm.addMouseMotionListener(new MouseAdapter() {
           	    @Override
           	    public void mouseDragged(MouseEvent e) {
           	        int x = e.getXOnScreen() - offsetX;
           	        int y = e.getYOnScreen() - offsetY;
           	        Menu1.setLocation(x, y);
           	    }
           	});
           	pmPanel.add(lbldesignPm);                                
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
        	        Menu1.setLocation(x, y);
        	    }
        	});
                LocalTime time = LocalTime.now();
                if (time.isAfter(LocalTime.NOON) && time.isBefore(LocalTime.of(18, 0))) {
                    pmPanel.setVisible(true);
                    amPanel.setVisible(false);
                }
                else {
                    amPanel.setVisible(true);
                    pmPanel.setVisible(false);
                }
                Menu1.setShape(new RoundRectangle2D.Double(0, 0, Menu1.getWidth(), Menu1.getHeight(), 100, 100));                
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
        int updatedTotal = currentTotal + value;
        	BufferedWriter writer = new BufferedWriter(new FileWriter(filePath)); 
        	
            writer.write(String.valueOf(updatedTotal));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void displayDishLabel(String filePath, String targetDish, JFrame frame, int x, int y, JPanel panel) {
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

                        panel.add(label);
                        break; // Exit the loop after finding the desired dish
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    protected int checkQuantity(String selectedItem) {
        // TODO: Implement the logic to check the quantity of the selected item
        return 0;
    }	
 }
