package System;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.border.*;
import javax.swing.*;
import java.io.*;
import java.nio.file.*;
import java.awt.event.*;
import java.time.LocalTime;

public class LyndasMenu1 extends MyPanel{

    public JFrame LyndasMenu1;
    private int offsetX;
    private int offsetY;
    public int total;
    public JLabel totalPrice;
    private String filepath = "src/data/LyndasMenu1.txt";
    private String[] targetDishes = {"Embutido", "Tapa", "Tocino","Tuyo"};
    private String[] targetDishes2 = {"Sopas", "Champorado", "Lugaw","Tortang_Talong"};
    private String[] targetDishes3 = {"Sinigang_na_Baboy", "Menudo", "Pork_Steak","Ginataang_Manok"};
    private String[] targetDishes4 = {"Adobong_Pusit", "Kare-kare", "Caldereta","Sisig"};


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
            	
                try {
                    LyndasMenu1 window = new LyndasMenu1();
                    window.LyndasMenu1.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public LyndasMenu1() {
    	setSize(294, 307);
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
    	LyndasMenu1 = new JFrame();
        LyndasMenu1.setUndecorated(true);
        LyndasMenu1.setBounds(100, 100, 1401, 799);
        LyndasMenu1.setLocationRelativeTo(null);
        LyndasMenu1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LyndasMenu1.getContentPane().setLayout(null);
                
    	// Call the showClock() method to display the clock on the panel
        JPanel clockPanel = new JPanel();
		clockPanel.setOpaque(false);
	 	clockPanel.setBackground(new Color(0, 0, 160));
        clockPanel.setBounds(10, 10, 132, 30);
        LyndasMenu1.getContentPane().add(clockPanel);
        FileOperation.showClock(clockPanel);
        
        loadDataFromFile("src/data/data.txt");
        
        JPanel panel = new JPanel();
   	 	panel.setBounds(1076, 596, 294, 30);
   	 	LyndasMenu1.getContentPane().add(panel);

   	 	totalPrice = new JLabel();
   	 	panel.add(totalPrice);
   	 	totalPrice.setFont(new Font("Arial", Font.PLAIN, 21));
   	 	totalPrice.setBackground(Color.BLACK);
   	 	totalPrice.setVisible(true);
        
        loadTextFile("src/data/total.txt");
        
        setLocation(1076,277);
        LyndasMenu1.getContentPane().add(this);
        
        JButton btnBack = new JButton("");
        btnBack.setIcon(new ImageIcon(getClass().getResource("/pictures/BACK (1).png")));
        btnBack.setBounds(38, 711, 195, 50);        
        btnBack.setOpaque(true);
        btnBack.setBorderPainted(true);
        btnBack.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(8, 53, 139), new Color(8, 53, 139), new Color(8, 53, 139), new Color(8, 53, 139)), new EmptyBorder(2, 2, 2, 2)));
        btnBack.setFocusPainted(false);
        LyndasMenu1.getContentPane().add(btnBack);
        btnBack.setBackground(new Color(8, 53, 139));
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
        		LyndasMenu1.dispose();
        		Store window = new Store();
 				window.Store.setVisible(true);
 				FileOperation.clearFile(filePath);
                try {
                    // Copy the contents of LyndasMenu1.txt to LyndasMenu2.txt
            		FileOperation.clearFile2("src/data/total.txt");
                    Path sourceFile = Path.of("src/data/LyndasMenu1.txt");
                    Path destinationFile = Path.of("src/data/LyndasMenu2.txt");
                    Files.copy(sourceFile, destinationFile, StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Contents of LyndasMenu1.txt copied to LyndasMenu2.txt");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        
        JButton btnProceed = new JButton("");
    	btnProceed.setBounds(1169, 711, 195, 50);
    	LyndasMenu1.getContentPane().add(btnProceed);
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
             
             int result = JOptionPane.showConfirmDialog(null, "Please select rice order amount", "Confirmation", JOptionPane.YES_NO_OPTION);
             if (result == JOptionPane.NO_OPTION) {
            	LyndasMenu1.dispose();
              	StudentInfoLyndas window = new StudentInfoLyndas();
              	window.studentInfo.setVisible(true);                    
                 
                 // Perform the desired action for Yes
             }else{
            	 if (availableQuantity == 0) {
                     JOptionPane.showMessageDialog(LyndasMenu1, "Item is not available.", "Availability",
                             JOptionPane.INFORMATION_MESSAGE);
                 } else {
                     String quantity = JOptionPane.showInputDialog(LyndasMenu1, "Available quantity:" +" "+ availableQuantity);
                     if (quantity.matches("\\d+")) {
                     int chosenQuantity = Integer.parseInt(quantity);
                     if (chosenQuantity > availableQuantity) {
                         JOptionPane.showMessageDialog(LyndasMenu1, "Choose a quantity within the available range.",
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
                         
                         writeTextFile("src/data/total.txt", price);
                     	loadTextFile("src/data/total.txt");
                     	totalPrice.repaint();
                     }
                        loadDataFromFile("src/data/data.txt");
                        repaint();
                        reduceQuantity(selectedItem, chosenQuantity);                         
                        LyndasMenu1.dispose();
                     	StudentInfoLyndas window = new StudentInfoLyndas();
                     	window.studentInfo.setVisible(true);                    	
                     	System.out.println(total); 	
                     }else { JOptionPane.showMessageDialog(LyndasMenu1, "Invalid input");
                     }
                     
                 }
                 
             }
             
         }
     });

        JButton btnSoda = new JButton("");
     	btnSoda.setIcon(new ImageIcon(getClass().getResource("/pictures/Soda.png")));
        btnSoda.setOpaque(true);
        btnSoda.setBorderPainted(true);
        btnSoda.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)));
        btnSoda.setFocusPainted(false);
        btnSoda.setBackground(new Color(8, 53, 139));
        btnSoda.setBounds(119, 160, 71, 89);
        LyndasMenu1.getContentPane().add(btnSoda);
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
    	    	LyndasMenu2 window = new LyndasMenu2();
    	    	window.LyndasMenu2.setVisible(true);
    	    	LyndasMenu1.dispose();
    	    }
    	});
 	 	
    	
        
        	JButton btnSnacks = new JButton("");
            btnSnacks.setBounds(200, 160, 71, 89);
        	LyndasMenu1.getContentPane().add(btnSnacks);
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
        	    	LyndasMenu3 window = new LyndasMenu3();
        	    	window.LyndasMenu3.setVisible(true);
        	    	LyndasMenu1.dispose();
        	    }
        	});
        	
        
        JButton btnUlam = new JButton("");
        btnUlam.setBounds(38, 160, 71, 89);
        btnUlam.setIcon(new ImageIcon(getClass().getResource("/pictures/Chicken.png")));
        btnUlam.setFocusPainted(false);
        btnUlam.setBackground(new Color(8, 53, 139));
        btnUlam.setOpaque(true);
        btnUlam.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        LyndasMenu1.getContentPane().add(btnUlam); 
        
        int x = 210; // Starting X coordinate
        int y = 377;
        int x2 = 215;
        int y2 = 575;
        // Bring the panel to the front 
            JPanel amPanel = new JPanel();
            amPanel.setVisible(false);	
            amPanel.setBounds(0, 0, 1401, 800);
            LyndasMenu1.getContentPane().add(amPanel);
            amPanel.setLayout(null);
            for (String targetDish : targetDishes) {
                displayDishLabel(filepath, targetDish, null, x, y, amPanel);
               x += 250; // Increase Y coordinate for the next label placement
               
            }
            for (String targetDish : targetDishes2) {
                displayDishLabel(filepath, targetDish, null, x2, y2, amPanel);
               x2 += 250; // Increase Y coordinate for the next label placement
            }
             
    	 
             
             
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
                     String selectedItem = "Embutido"; // Replace with the actual selected dish
                     int availableQuantity = getAvailableQuantity(selectedItem);                
                     if (availableQuantity == 0) {
                         JOptionPane.showMessageDialog(LyndasMenu1, "Item is not available.", "Availability",
                                 JOptionPane.INFORMATION_MESSAGE);
                     } else {
                         String quantity = JOptionPane.showInputDialog(LyndasMenu1, "Available quantity:" +" "+ availableQuantity);

                         int chosenQuantity = Integer.parseInt(quantity);
                         if (chosenQuantity > availableQuantity) {
                             JOptionPane.showMessageDialog(LyndasMenu1, "Choose a quantity within the available range.",
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
                String selectedItem = "Tapa"; // Replace with the actual selected dish
                int availableQuantity = getAvailableQuantity(selectedItem);                
                if (availableQuantity == 0) {
                    JOptionPane.showMessageDialog(LyndasMenu1, "Item is not available.", "Availability",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    String quantity = JOptionPane.showInputDialog(LyndasMenu1, "Available quantity:" +" "+ availableQuantity);
                    int chosenQuantity = Integer.parseInt(quantity);
                    if (chosenQuantity > availableQuantity) {
                        JOptionPane.showMessageDialog(LyndasMenu1, "Choose a quantity within the available range.",
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
                String selectedItem = "Tocino"; // Replace with the actual selected dish
                int availableQuantity = getAvailableQuantity(selectedItem);                
                if (availableQuantity == 0) {
                    JOptionPane.showMessageDialog(LyndasMenu1, "Item is not available.", "Availability",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    String quantity = JOptionPane.showInputDialog(LyndasMenu1, "Available quantity:" +" "+ availableQuantity);

                    int chosenQuantity = Integer.parseInt(quantity);
                    if (chosenQuantity > availableQuantity) {
                        JOptionPane.showMessageDialog(LyndasMenu1, "Choose a quantity within the available range.",
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
                String selectedItem = "Tuyo"; // Replace with the actual selected dish
                int availableQuantity = getAvailableQuantity(selectedItem);                
                if (availableQuantity == 0) {
                    JOptionPane.showMessageDialog(LyndasMenu1, "Item is not available.", "Availability",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    String quantity = JOptionPane.showInputDialog(LyndasMenu1, "Available quantity:" +" "+ availableQuantity);

                    int chosenQuantity = Integer.parseInt(quantity);
                    if (chosenQuantity > availableQuantity) {
                        JOptionPane.showMessageDialog(LyndasMenu1, "Choose a quantity within the available range.",
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
                String selectedItem = "Sopas"; // Replace with the actual selected dish
                int availableQuantity = getAvailableQuantity(selectedItem);
                

                if (availableQuantity == 0) {
                    JOptionPane.showMessageDialog(LyndasMenu1, "Item is not available.", "Availability",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    String quantity = JOptionPane.showInputDialog(LyndasMenu1, "Available quantity:" +" "+ availableQuantity);

                    int chosenQuantity = Integer.parseInt(quantity);
                    if (chosenQuantity > availableQuantity) {
                        JOptionPane.showMessageDialog(LyndasMenu1, "Choose a quantity within the available range.",
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
                String selectedItem = "Champorado"; // Replace with the actual selected dish
                int availableQuantity = getAvailableQuantity(selectedItem);
                

                if (availableQuantity == 0) {
                    JOptionPane.showMessageDialog(LyndasMenu1, "Item is not available.", "Availability",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    String quantity = JOptionPane.showInputDialog(LyndasMenu1, "Available quantity:" +" "+ availableQuantity);

                    int chosenQuantity = Integer.parseInt(quantity);
                    if (chosenQuantity > availableQuantity) {
                        JOptionPane.showMessageDialog(LyndasMenu1, "Choose a quantity within the available range.",
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
                String selectedItem = "Lugaw"; // Replace with the actual selected dish
                int availableQuantity = getAvailableQuantity(selectedItem);                
                if (availableQuantity == 0) {
                    JOptionPane.showMessageDialog(LyndasMenu1, "Item is not available.", "Availability",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    String quantity = JOptionPane.showInputDialog(LyndasMenu1, "Available quantity:" +" "+ availableQuantity);
                    int chosenQuantity = Integer.parseInt(quantity);
                    if (chosenQuantity > availableQuantity) {
                        JOptionPane.showMessageDialog(LyndasMenu1, "Choose a quantity within the available range.",
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
                String selectedItem = "Tortang_Talong"; // Replace with the actual selected dish
                int availableQuantity = getAvailableQuantity(selectedItem);                
                if (availableQuantity == 0) {
                    JOptionPane.showMessageDialog(LyndasMenu1, "Item is not available.", "Availability",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    String quantity = JOptionPane.showInputDialog(LyndasMenu1, "Available quantity:" +" "+ availableQuantity);

                    int chosenQuantity = Integer.parseInt(quantity);
                    if (chosenQuantity > availableQuantity) {
                        JOptionPane.showMessageDialog(LyndasMenu1, "Choose a quantity within the available range.",
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
                     JLabel lblEmbutidoImage = new JLabel("");
                     lblEmbutidoImage.setToolTipText("Filipino-style meatloaf with ground meat, eggs, and raisins.");
                     lblEmbutidoImage.setIcon(new ImageIcon(getClass().getResource("/pictures/Embutido.png")));
                     lblEmbutidoImage.setBounds(38, 300, 233, 150);
                     amPanel.add(lblEmbutidoImage);
                     btnAmDish8.setBounds(910, 615, 111, 30);
                     
                     JLabel lblTapaImage = new JLabel("");
                     lblTapaImage.setToolTipText("Thinly sliced marinated beef, often fried or grilled.");
                     lblTapaImage.setIcon(new ImageIcon(getClass().getResource("/pictures/Tapa.png")));
                     lblTapaImage.setBounds(296, 300, 233, 150);
                     amPanel.add(lblTapaImage);
                     
                     JLabel lblTocinoImage = new JLabel("");
                     lblTocinoImage.setToolTipText("Sweet and savory cured pork, commonly pan-fried.");
                     lblTocinoImage.setIcon(new ImageIcon(getClass().getResource("/pictures/Tocino.png")));
                     lblTocinoImage.setBounds(552, 300, 233, 150);
                     amPanel.add(lblTocinoImage);
                     
                     JLabel lblTuyoImage = new JLabel("");
                     lblTuyoImage.setToolTipText("Sun-dried and salted small fish, usually fried.");
                     lblTuyoImage.setIcon(new ImageIcon(getClass().getResource("/pictures/Tuyo.png")));
                     lblTuyoImage.setBounds(803, 300, 233, 150);
                     amPanel.add(lblTuyoImage);
                     
                     JLabel lblSopasImage = new JLabel("");
                     lblSopasImage.setToolTipText("Creamy chicken and macaroni soup.");
                     lblSopasImage.setIcon(new ImageIcon(getClass().getResource("/pictures/Sopas.png")));
                     lblSopasImage.setBounds(38, 500, 233, 150);
                     amPanel.add(lblSopasImage);
                     
                     JLabel lblChamporadoImage = new JLabel("");
                     lblChamporadoImage.setToolTipText("Sweet chocolate rice porridge.");
                     lblChamporadoImage.setIcon(new ImageIcon(getClass().getResource("/pictures/Champorado.png")));
                     lblChamporadoImage.setBounds(296, 500, 233, 150);
                     amPanel.add(lblChamporadoImage);
                     
		JLabel lblLugawImage = new JLabel("");
		lblLugawImage.setToolTipText("Thick and creamy rice porridge.");
		lblLugawImage.setIcon(new ImageIcon(getClass().getResource("/pictures/Lugaw.png")));
		lblLugawImage.setBounds(552, 500, 233, 150);
		amPanel.add(lblLugawImage);
		
		JLabel lblTortangTalongImage = new JLabel("");
		lblTortangTalongImage.setToolTipText("Grilled eggplant omelet.");
		lblTortangTalongImage.setIcon(new ImageIcon(getClass().getResource("/pictures/Tortang Talong.png")));
		lblTortangTalongImage.setBounds(803, 500, 233, 150);
		amPanel.add(lblTortangTalongImage);
		
        	JLabel lbldesign = new JLabel("");
        	lbldesign.setIcon(new ImageIcon(getClass().getResource("/pictures/home screen (2).png")));
        	lbldesign.setBounds(0, 0, 1401, 800);
        	amPanel.add(lbldesign);
  	 
        	 //PM Panel
        	JPanel pmPanel = new JPanel();
        	pmPanel.setLayout(null);
        	pmPanel.setBounds(0, 0, 1401, 800);
        	
        	int x3 = 210; // Starting X coordinate
            int y3 = 377;
            int x4 = 210; // Starting X coordinate
            int y4 = 575;
        	
        	for (String targetDish : targetDishes3) {
                displayDishLabel(filepath, targetDish, null, x3, y3, pmPanel);
               x3 += 250; // Increase Y coordinate for the next label placement
               
            }
            for (String targetDish : targetDishes4) {
                displayDishLabel(filepath, targetDish, null, x4, y4, pmPanel);
               x4 += 250; // Increase Y coordinate for the next label placement
               
            }
        	
    
        LyndasMenu1.getContentPane().add(pmPanel);
        
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
                String selectedItem = "Sinigang_na_Baboy"; // Replace with the actual selected dish
                int availableQuantity = getAvailableQuantity(selectedItem);
                

                if (availableQuantity == 0) {
                    JOptionPane.showMessageDialog(LyndasMenu1, "Item is not available.", "Availability",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    String quantity = JOptionPane.showInputDialog(LyndasMenu1, "Available quantity:" +" "+ availableQuantity);

                    int chosenQuantity = Integer.parseInt(quantity);
                    if (chosenQuantity > availableQuantity) {
                        JOptionPane.showMessageDialog(LyndasMenu1, "Choose a quantity within the available range.",
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
                String selectedItem = "Menudo"; // Replace with the actual selected dish
                int availableQuantity = getAvailableQuantity(selectedItem);
                

                if (availableQuantity == 0) {
                    JOptionPane.showMessageDialog(LyndasMenu1, "Item is not available.", "Availability",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    String quantity = JOptionPane.showInputDialog(LyndasMenu1, "Available quantity:" +" "+ availableQuantity);

                    int chosenQuantity = Integer.parseInt(quantity);
                    if (chosenQuantity > availableQuantity) {
                        JOptionPane.showMessageDialog(LyndasMenu1, "Choose a quantity within the available range.",
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
                String selectedItem = "Pork_Steak"; // Replace with the actual selected dish
                int availableQuantity = getAvailableQuantity(selectedItem);
                

                if (availableQuantity == 0) {
                    JOptionPane.showMessageDialog(LyndasMenu1, "Item is not available.", "Availability",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    String quantity = JOptionPane.showInputDialog(LyndasMenu1, "Available quantity:" +" "+ availableQuantity);

                    int chosenQuantity = Integer.parseInt(quantity);
                    if (chosenQuantity > availableQuantity) {
                        JOptionPane.showMessageDialog(LyndasMenu1, "Choose a quantity within the available range.",
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
                String selectedItem = "Ginataang_Manok"; // Replace with the actual selected dish
                int availableQuantity = getAvailableQuantity(selectedItem);
                

                if (availableQuantity == 0) {
                    JOptionPane.showMessageDialog(LyndasMenu1, "Item is not available.", "Availability",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    String quantity = JOptionPane.showInputDialog(LyndasMenu1, "Available quantity:" +" "+ availableQuantity);

                    int chosenQuantity = Integer.parseInt(quantity);
                    if (chosenQuantity > availableQuantity) {
                        JOptionPane.showMessageDialog(LyndasMenu1, "Choose a quantity within the available range.",
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
                String selectedItem = "Adobong_Pusit"; // Replace with the actual selected dish
                int availableQuantity = getAvailableQuantity(selectedItem);
                

                if (availableQuantity == 0) {
                    JOptionPane.showMessageDialog(LyndasMenu1, "Item is not available.", "Availability",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    String quantity = JOptionPane.showInputDialog(LyndasMenu1, "Available quantity:" +" "+ availableQuantity);

                    int chosenQuantity = Integer.parseInt(quantity);
                    if (chosenQuantity > availableQuantity) {
                        JOptionPane.showMessageDialog(LyndasMenu1, "Choose a quantity within the available range.",
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
                String selectedItem = "Kare-kare"; // Replace with the actual selected dish
                int availableQuantity = getAvailableQuantity(selectedItem);
                

                if (availableQuantity == 0) {
                    JOptionPane.showMessageDialog(LyndasMenu1, "Item is not available.", "Availability",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    String quantity = JOptionPane.showInputDialog(LyndasMenu1, "Available quantity:" +" "+ availableQuantity);

                    int chosenQuantity = Integer.parseInt(quantity);
                    if (chosenQuantity > availableQuantity) {
                        JOptionPane.showMessageDialog(LyndasMenu1, "Choose a quantity within the available range.",
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
                String selectedItem = "Caldereta"; // Replace with the actual selected dish
                int availableQuantity = getAvailableQuantity(selectedItem);
                

                if (availableQuantity == 0) {
                    JOptionPane.showMessageDialog(LyndasMenu1, "Item is not available.", "Availability",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    String quantity = JOptionPane.showInputDialog(LyndasMenu1, "Available quantity:" +" "+ availableQuantity);

                    int chosenQuantity = Integer.parseInt(quantity);
                    if (chosenQuantity > availableQuantity) {
                        JOptionPane.showMessageDialog(LyndasMenu1, "Choose a quantity within the available range.",
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
                String selectedItem = "Sisig"; // Replace with the actual selected dish
                int availableQuantity = getAvailableQuantity(selectedItem);
                

                if (availableQuantity == 0) {
                    JOptionPane.showMessageDialog(LyndasMenu1, "Item is not available.", "Availability",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    String quantity = JOptionPane.showInputDialog(LyndasMenu1, "Available quantity:" +" "+ availableQuantity);

                    int chosenQuantity = Integer.parseInt(quantity);
                    if (chosenQuantity > availableQuantity) {
                        JOptionPane.showMessageDialog(LyndasMenu1, "Choose a quantity within the available range.",
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
        JLabel lblSinigangNaBaboyImage = new JLabel("");
        lblSinigangNaBaboyImage.setToolTipText("Sour pork soup with vegetables in tamarind broth.");
        lblSinigangNaBaboyImage.setIcon(new ImageIcon(getClass().getResource("/pictures/Sinigang na Baboy.png")));
        lblSinigangNaBaboyImage.setBounds(38, 300, 233, 150);
        pmPanel.add(lblSinigangNaBaboyImage);                                    
        
        JLabel lblMenudoImage = new JLabel("");
        lblMenudoImage.setToolTipText("Pork stew with vegetables in a tomato-based sauce.");
        lblMenudoImage.setIcon(new ImageIcon(getClass().getResource("/pictures/Menudo.png")));
        lblMenudoImage.setBounds(296, 300, 233, 150);
        pmPanel.add(lblMenudoImage);
        
        JLabel lblPorkSteakImage = new JLabel("");
        lblPorkSteakImage.setToolTipText("Grilled or pan-fried marinated pork slices.");
        lblPorkSteakImage.setIcon(new ImageIcon(getClass().getResource("/pictures/Pork Steak.png")));
        lblPorkSteakImage.setBounds(552, 300, 233, 150);
        pmPanel.add(lblPorkSteakImage);
        
        JLabel lblGinataangManokImage = new JLabel("");
        lblGinataangManokImage.setToolTipText("Chicken cooked in coconut milk with spices.");
        lblGinataangManokImage.setIcon(new ImageIcon(getClass().getResource("/pictures/Ginataang Manok.png")));
        lblGinataangManokImage.setBounds(803, 300, 233, 150);
        pmPanel.add(lblGinataangManokImage);
        
        JLabel lblAdobongPusitImage = new JLabel("");
        lblAdobongPusitImage.setToolTipText("Tangy and savory squid dish cooked in vinegar and soy sauce.");
        lblAdobongPusitImage.setIcon(new ImageIcon(getClass().getResource("/pictures/Adobong Pusit.png")));
        lblAdobongPusitImage.setBounds(38, 500, 233, 150);
        pmPanel.add(lblAdobongPusitImage);
        
        JLabel lblKareKareImage = new JLabel("");
        lblKareKareImage.setToolTipText("Oxtail or meat stew in thick peanut sauce with vegetables.");
        lblKareKareImage.setIcon(new ImageIcon(getClass().getResource("/pictures/Kare Kare.png")));
        lblKareKareImage.setBounds(296, 500, 233, 150);
        pmPanel.add(lblKareKareImage);
        
        JLabel lblCalderetaImage = new JLabel("");
        lblCalderetaImage.setToolTipText("Flavorful meat stew with potatoes, carrots, and bell peppers.");
        lblCalderetaImage.setIcon(new ImageIcon(getClass().getResource("/pictures/Caldereta.png")));
        lblCalderetaImage.setBounds(552, 500, 233, 150);
        pmPanel.add(lblCalderetaImage);
        
        JLabel lblSisigImage = new JLabel("");
        lblSisigImage.setToolTipText("Best seller of store, Chopped and seasoned parts of a pig's head or belly, served sizzling hot.");
        lblSisigImage.setIcon(new ImageIcon(getClass().getResource("/pictures/Sisig Pork.png")));
        lblSisigImage.setBounds(803, 500, 233, 150);
        pmPanel.add(lblSisigImage);
        
        
           	JLabel lblPmDesign = new JLabel();
           	lblPmDesign.setIcon(new ImageIcon(getClass().getResource("/pictures/home screen (2).png")));
           	lblPmDesign.setBounds(0, 0, 1401, 800);
           	pmPanel.add(lblPmDesign);
           	lblPmDesign.addMouseListener(new MouseAdapter() {
           	    @Override
           	    public void mousePressed(MouseEvent e) {
           	        offsetX = e.getX();
           	        offsetY = e.getY();
           	    }
           	});
           	lblPmDesign.addMouseMotionListener(new MouseAdapter() {
           	    @Override
           	    public void mouseDragged(MouseEvent e) {
           	        int x = e.getXOnScreen() - offsetX;
           	        int y = e.getYOnScreen() - offsetY;
           	        LyndasMenu1.setLocation(x, y);
           	    }
           	});
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
        	        LyndasMenu1.setLocation(x, y);
        	    }
        	});
               
                
                

                LocalTime time = LocalTime.now();
                if (time.isAfter(LocalTime.NOON) && time.isBefore(LocalTime.of(18, 0))) {
                    pmPanel.setVisible(true);
                    amPanel.setVisible(false);
                } else {
                    amPanel.setVisible(true);
                    pmPanel.setVisible(false);
                }
                LyndasMenu1.setShape(new RoundRectangle2D.Double(0, 0, LyndasMenu1.getWidth(), LyndasMenu1.getHeight(), 100, 100));
                
            }
    
   
    
    private int getAvailableQuantity(String item) {
        String filePath = "src/data/LyndasMenu2.txt";
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
        String LyndasMenu2Path = "src/data/LyndasMenu2.txt";
        String tempLyndasMenu2Path = "src/data/LyndasMenu2_tmp.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(LyndasMenu2Path));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempLyndasMenu2Path))) {
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
        File LyndasMenu2File = new File(LyndasMenu2Path);
        File tempFile = new File(tempLyndasMenu2Path);
        if (LyndasMenu2File.delete() && tempFile.renameTo(LyndasMenu2File)) {
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
    private int getPrice(String item) {
        String filePath = "src/data/LyndasMenu2.txt";
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
		// TODO Auto-generated method stub
		return 0;
	}
   
    }
