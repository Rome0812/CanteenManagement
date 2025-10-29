package System;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class LyndasMenu3 extends MyPanel {

	public JFrame LyndasMenu3;
    private int offsetX;
    private int offsetY;
    public int total;
    public JLabel totalPrice;
    private String filepath = "src/data/LyndasMenu1.txt";
    private String[] targetDishes = {"SkyFlakes","Hansel","Cream-O","ChocoMucho"};
    private String[] targetDishes2 = {"Fudgee_Bar","Rebisco","Magic_Flakes","Sandwich"};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LyndasMenu3 window = new LyndasMenu3();
					window.LyndasMenu3.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LyndasMenu3() {
		setSize(294, 307);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		LyndasMenu3 = new JFrame();
		LyndasMenu3.setBounds(100, 100, 1401, 799);
        LyndasMenu3.setUndecorated(true);
        LyndasMenu3.setLocationRelativeTo(null);
		LyndasMenu3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LyndasMenu3.getContentPane().setLayout(null);
		
		
		int x = 210; // Starting X coordinate
        int y = 377;
        int x2 = 215;
        int y2 = 575;

        for (String targetDish : targetDishes) {
            displayDishLabel(filepath, targetDish, LyndasMenu3, x, y);
           x += 250; // Increase Y coordinate for the next label placement
        }
        for (String targetDish : targetDishes2) {
            displayDishLabel(filepath, targetDish, LyndasMenu3, x2, y2);
           x2 += 250; // Increase Y coordinate for the next label placement
        }
        JPanel clockPanel = new JPanel();
		clockPanel.setOpaque(false);
	 	clockPanel.setBackground(new Color(0, 0, 160));
        clockPanel.setBounds(10, 10, 132, 30);
        LyndasMenu3.getContentPane().add(clockPanel);
        
        // Call the showClock() method to display the clock on the panel
        loadDataFromFile("src/data/data.txt");
		FileOperation.showClock(clockPanel);
		
        JPanel panel = new JPanel();
   	 	panel.setBounds(1076, 596, 294, 30);
   	 	LyndasMenu3.getContentPane().add(panel);

   	 	totalPrice = new JLabel();
   	 	panel.add(totalPrice);
   	 	totalPrice.setFont(new Font("Arial", Font.PLAIN, 21));
   	 	totalPrice.setBackground(Color.BLACK);
   	 	totalPrice.setVisible(true);
        
        loadTextFile("src/data/total.txt");
		setLocation(1076,277);
		LyndasMenu3.getContentPane().add(this);
        
        JButton btnSoda = new JButton("");
     	btnSoda.setIcon(new ImageIcon(getClass().getResource("/pictures/Soda.png")));
        btnSoda.setOpaque(true);
        btnSoda.setBorderPainted(true);
        btnSoda.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)));
        btnSoda.setFocusPainted(false);
        btnSoda.setBackground(new Color(8, 53, 139));
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
				LyndasMenu3.dispose();
			}
		});
        btnSoda.setBounds(119, 160, 71, 89);
		LyndasMenu3.getContentPane().add(btnSoda);
		
		JButton btnUlam = new JButton("");
		btnUlam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
        btnUlam.setIcon(new ImageIcon(getClass().getResource("/pictures/Chicken.png")));
        btnUlam.setFocusPainted(false);
        btnUlam.setBounds(38, 160, 71, 89);
        btnUlam.setBackground(new Color(8, 53, 139));
        btnUlam.setOpaque(true);
        btnUlam.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2))); 
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
				LyndasMenu1 window = new LyndasMenu1();
				window.LyndasMenu1.setVisible(true);
				LyndasMenu3.dispose();
			}
		});
		LyndasMenu3.getContentPane().add(btnUlam);
		
		
		JButton btnSnacks = new JButton("");
    	btnSnacks.setIcon(new ImageIcon(getClass().getResource("/pictures/image 1.png")));
        btnSnacks.setOpaque(true);
        btnSnacks.setFocusPainted(false);
        btnSnacks.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        
        btnSnacks.setBackground(new Color(8, 53, 139));
        btnSnacks.setBounds(200, 160, 71, 89);
        LyndasMenu3.getContentPane().add(btnSnacks);
        
        
        JButton btnBack = new JButton("");
        btnBack.setBounds(38, 711, 195, 50);
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnBack.setIcon(new ImageIcon(getClass().getResource("/pictures/BACK (1).png")));
        btnBack.setOpaque(true);
        btnBack.setFocusPainted(false);
        btnBack.setBackground(new Color(8, 53, 139));
        btnBack.setBorderPainted(true);
        btnBack.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(8, 53, 139), new Color(8, 53, 139), new Color(8, 53, 139), new Color(8, 53, 139)), new EmptyBorder(2, 2, 2, 2)));
        btnBack.setFocusPainted(false);
        btnBack.setBackground(new Color(8, 53, 139));
        LyndasMenu3.getContentPane().add(btnBack);
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
        		LyndasMenu3.dispose();
        		Store window = new Store();
 				window.Store.setVisible(true);
                try {
                    // Copy the contents of LyndasLyndasMenu1.txt to LyndasMenu2.txt
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
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
        JButton btnProceed = new JButton("");
    	btnProceed.setIcon(new ImageIcon(getClass().getResource("/pictures/PROCEED.png")));
        btnProceed.setOpaque(true);
        btnProceed.setBorderPainted(true);
        btnProceed.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)));
        btnProceed.setFocusPainted(false);
        btnProceed.setBackground(new Color(8, 53, 139));
        btnProceed.setBounds(1169, 711, 195, 50);
        LyndasMenu3.getContentPane().add(btnProceed);
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
        	 LyndasMenu3.dispose();
        	 StudentInfoLyndas window = new StudentInfoLyndas();
           	window.studentInfo.setVisible(true);
             // Perform the desired action for Yes
         }else{
        	 if (availableQuantity == 0) {
                 JOptionPane.showMessageDialog(LyndasMenu3, "Item is not available.", "Availability",
                         JOptionPane.INFORMATION_MESSAGE);
             } else {
                 String quantity = JOptionPane.showInputDialog(LyndasMenu3, "Available quantity:" +" "+ availableQuantity);
                 if (quantity.matches("\\d+")) {
                 int chosenQuantity = Integer.parseInt(quantity);
                 if (chosenQuantity > availableQuantity) {
                     JOptionPane.showMessageDialog(LyndasMenu3, "Choose a quantity within the available range.",
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
                    LyndasMenu3.dispose();
                    StudentInfoLyndas window = new StudentInfoLyndas();
                  	window.studentInfo.setVisible(true);
                 	System.out.println(total);                 	                 	                 	                 	
                 }else { JOptionPane.showMessageDialog(LyndasMenu3, "Invalid input");
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
		btnDish1.setBounds(145, 414, 115, 30);
		LyndasMenu3.getContentPane().add(btnDish1);
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
		                String selectedItem = "SkyFlakes"; // Replace with the actual selected dish
		                int availableQuantity = getAvailableQuantity(selectedItem);
		                
		
		                if (availableQuantity == 0) {
		                    JOptionPane.showMessageDialog(LyndasMenu3, "Item is not available.", "Availability",
		                            JOptionPane.INFORMATION_MESSAGE);
		                } else {
		                    String quantity = JOptionPane.showInputDialog(LyndasMenu3, "Available quantity:" +" "+ availableQuantity);
		
		                    int chosenQuantity = Integer.parseInt(quantity);
		                    if (chosenQuantity > availableQuantity) {
		                        JOptionPane.showMessageDialog(LyndasMenu3, "Choose a quantity within the available range.",
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
        btnDish2.setBackground(new Color(8, 53, 139));
        btnDish2.setBounds(406, 414, 115, 30);
        LyndasMenu3.getContentPane().add(btnDish2);
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
		    	
		        String selectedItem = "Hansel"; // Replace with the actual selected dish
		        int availableQuantity = getAvailableQuantity(selectedItem);
		        

		        if (availableQuantity == 0) {
		            JOptionPane.showMessageDialog(LyndasMenu3, "Item is not available.", "Availability",
		                    JOptionPane.INFORMATION_MESSAGE);
		        } else {
		            String quantity = JOptionPane.showInputDialog(LyndasMenu3, "Available quantity:" +" "+ availableQuantity);

		            int chosenQuantity = Integer.parseInt(quantity);
		            if (chosenQuantity > availableQuantity) {
		                JOptionPane.showMessageDialog(LyndasMenu3, "Choose a quantity within the available range.",
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
        btnDish3.setBackground(new Color(8, 53, 139));
        btnDish3.setBounds(654, 414, 115, 30);
        LyndasMenu3.getContentPane().add(btnDish3);
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
                String selectedItem = "Cream-O"; // Replace with the actual selected dish
                int availableQuantity = getAvailableQuantity(selectedItem);
                

                if (availableQuantity == 0) {
                    JOptionPane.showMessageDialog(LyndasMenu3, "Item is not available.", "Availability",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    String quantity = JOptionPane.showInputDialog(LyndasMenu3, "Available quantity:" +" "+ availableQuantity);

                    int chosenQuantity = Integer.parseInt(quantity);
                    if (chosenQuantity > availableQuantity) {
                        JOptionPane.showMessageDialog(LyndasMenu3, "Choose a quantity within the available range.",
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
        btnDish4.setBounds(910, 414, 115, 30);
        LyndasMenu3.getContentPane().add(btnDish4);
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
                String selectedItem = "ChocoMucho"; // Replace with the actual selected dish
                int availableQuantity = getAvailableQuantity(selectedItem);
                

                if (availableQuantity == 0) {
                    JOptionPane.showMessageDialog(LyndasMenu3, "Item is not available.", "Availability",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    String quantity = JOptionPane.showInputDialog(LyndasMenu3, "Available quantity:" +" "+ availableQuantity);

                    int chosenQuantity = Integer.parseInt(quantity);
                    if (chosenQuantity > availableQuantity) {
                        JOptionPane.showMessageDialog(LyndasMenu3, "Choose a quantity within the available range.",
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
        btnDish5.setBounds(145, 615, 115, 30);
        LyndasMenu3.getContentPane().add(btnDish5);
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
                String selectedItem = "Fudgee_Bar"; // Replace with the actual selected dish
                int availableQuantity = getAvailableQuantity(selectedItem);
                

                if (availableQuantity == 0) {
                    JOptionPane.showMessageDialog(LyndasMenu3, "Item is not available.", "Availability",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    String quantity = JOptionPane.showInputDialog(LyndasMenu3, "Available quantity:" +" "+ availableQuantity);

                    int chosenQuantity = Integer.parseInt(quantity);
                    if (chosenQuantity > availableQuantity) {
                        JOptionPane.showMessageDialog(LyndasMenu3, "Choose a quantity within the available range.",
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
        btnDish6.setBounds(402, 615, 115, 30);
        LyndasMenu3.getContentPane().add(btnDish6);
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
                String selectedItem = "Rebisco"; // Replace with the actual selected dish
                int availableQuantity = getAvailableQuantity(selectedItem);
                

                if (availableQuantity == 0) {
                    JOptionPane.showMessageDialog(LyndasMenu3, "Item is not available.", "Availability",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    String quantity = JOptionPane.showInputDialog(LyndasMenu3, "Available quantity:" +" "+ availableQuantity);

                    int chosenQuantity = Integer.parseInt(quantity);
                    if (chosenQuantity > availableQuantity) {
                        JOptionPane.showMessageDialog(LyndasMenu3, "Choose a quantity within the available range.",
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
        btnDish7.setBounds(659, 615, 115, 30);
        LyndasMenu3.getContentPane().add(btnDish7);
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
                String selectedItem = "Magic_Flakes"; // Replace with the actual selected dish
                int availableQuantity = getAvailableQuantity(selectedItem);

                if (availableQuantity == 0) {
                    JOptionPane.showMessageDialog(LyndasMenu3, "Item is not available.", "Availability",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    String quantity = JOptionPane.showInputDialog(LyndasMenu3, "Available quantity:" +" "+ availableQuantity);

                    int chosenQuantity = Integer.parseInt(quantity);
                    if (chosenQuantity > availableQuantity) {
                        JOptionPane.showMessageDialog(LyndasMenu3, "Choose a quantity within the available range.",
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
                btnDish8.setBounds(910, 615, 116, 30);
                LyndasMenu3.getContentPane().add(btnDish8);
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
                        String selectedItem = "Sandwich"; // Replace with the actual selected dish
                        int availableQuantity = getAvailableQuantity(selectedItem);
                        

                        if (availableQuantity == 0) {
                            JOptionPane.showMessageDialog(LyndasMenu3, "Item is not available.", "Availability",
                                    JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            String quantity = JOptionPane.showInputDialog(LyndasMenu3, "Available quantity:" +" "+ availableQuantity);

                            int chosenQuantity = Integer.parseInt(quantity);
                            if (chosenQuantity > availableQuantity) {
                                JOptionPane.showMessageDialog(LyndasMenu3, "Choose a quantity within the available range.",
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
		
		
		JLabel lblSkyFlakesImage = new JLabel("");
		lblSkyFlakesImage.setToolTipText("1 piece sky flakes crakers ");
		lblSkyFlakesImage.setIcon(new ImageIcon(getClass().getResource("/pictures/Sky Flakes.png")));
		lblSkyFlakesImage.setBounds(38, 300, 233, 150);
		LyndasMenu3.getContentPane().add(lblSkyFlakesImage); 
		
		JLabel lblHanselImage = new JLabel("");
        lblHanselImage.setToolTipText("1 piece of hansel biscuit with many times flavor of chocolate, milk, butter, mocha");
        lblHanselImage.setIcon(new ImageIcon(getClass().getResource("/pictures/Hansel.png")));
        lblHanselImage.setBounds(296, 300, 233, 150);
        LyndasMenu3.getContentPane().add(lblHanselImage);
        
        JLabel lblCreamOImage = new JLabel("");
        lblCreamOImage.setToolTipText("1 piece of cream-o with many flavors of chocolate, vanilla, delux,choco berries,cookies'n cream");
        lblCreamOImage.setIcon(new ImageIcon(getClass().getResource("/pictures/Cream-O.png")));
        lblCreamOImage.setBounds(552, 300, 233, 150);
        LyndasMenu3.getContentPane().add(lblCreamOImage);
		
               
        JLabel lblChocoMuchoImage = new JLabel("");
        lblChocoMuchoImage.setToolTipText("1 piece choco mucho with flavor of chocolate , vanilla ");
        lblChocoMuchoImage.setIcon(new ImageIcon(getClass().getResource("/pictures/Choco Mucho.png")));
        lblChocoMuchoImage.setBounds(803, 300, 233, 150);
        LyndasMenu3.getContentPane().add(lblChocoMuchoImage);
        
        JLabel lblFudgeeBarImage = new JLabel("");
        lblFudgeeBarImage.setToolTipText("1 piece fudgee bar with flavour of chocolate, milk, vanilla, mocha, and macapuno");
        lblFudgeeBarImage.setIcon(new ImageIcon(getClass().getResource("/pictures/Fudgee Bar.png")));
        lblFudgeeBarImage.setBounds(38, 500, 233, 150);
        LyndasMenu3.getContentPane().add(lblFudgeeBarImage);
        
        JLabel lblRebiscoImage = new JLabel("");
        lblRebiscoImage.setToolTipText("1 piece of rebisco with flavor of Choco, Strawberry, Cream, Butter");
        lblRebiscoImage.setIcon(new ImageIcon(getClass().getResource("/pictures/Rebisco.png")));
        lblRebiscoImage.setBounds(296, 500, 233, 150);
        LyndasMenu3.getContentPane().add(lblRebiscoImage);      
        
        JLabel lblMagicFlakesImage = new JLabel("");
        lblMagicFlakesImage.setToolTipText("1 piece of magic flakes crakers");
        lblMagicFlakesImage.setIcon(new ImageIcon(getClass().getResource("/pictures/Magic Flakes.png")));
        lblMagicFlakesImage.setBounds(552, 500, 233, 150);
        LyndasMenu3.getContentPane().add(lblMagicFlakesImage);
        
        JLabel lblSandwichImage = new JLabel("");
        lblSandwichImage.setToolTipText("This sandwich best seller of Store, 1 piece of sandwich made of ham, cheese, egg, mayonnaise and also vegtable ");
        lblSandwichImage.setIcon(new ImageIcon(getClass().getResource("/pictures/Sandwich.png")));
        lblSandwichImage.setBounds(803, 500, 233, 150);
        LyndasMenu3.getContentPane().add(lblSandwichImage);
            
        
		
		JLabel lbldesign = new JLabel("");
    	lbldesign.setIcon(new ImageIcon(getClass().getResource("/pictures/home screen (2).png")));
    	lbldesign.setBounds(0, 0, 1401, 800);
		LyndasMenu3.setShape(new RoundRectangle2D.Double(0, 0, LyndasMenu3.getWidth(), LyndasMenu3.getHeight(), 100, 100));
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
    	        LyndasMenu3.setLocation(x, y);
    	    }
    	});
    	LyndasMenu3.getContentPane().add(lbldesign);
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
        return 0; // Default to 0 if item not found or error occurs
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


	protected int checkQuantity(String selectedItem) {
		// TODO Auto-generated method stub
		return 0;
	}
   
    }

