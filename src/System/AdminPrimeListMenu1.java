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

public class AdminPrimeListMenu1 {

	public JFrame AdminListUlam;
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
					AdminPrimeListMenu1 window = new AdminPrimeListMenu1();
					window.AdminListUlam.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminPrimeListMenu1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		AdminListUlam = new JFrame();
		AdminListUlam.setUndecorated(true);
		AdminListUlam.setBounds(100, 100, 1401, 799);
		AdminListUlam.setLocationRelativeTo(null);
		AdminListUlam.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AdminListUlam.getContentPane().setLayout(null);
		
		
		JButton btnHistory = new JButton("");
		 btnHistory.setIcon(new ImageIcon(getClass().getResource("/Pictures/ORDER HISTORY.png")));
		   btnHistory.setOpaque(true);
		   btnHistory.setBackground(new Color(255, 255, 255));
		   btnHistory.setFocusPainted(false);
		   btnHistory.setBorderPainted(true);
		   btnHistory.setBackground(Color.WHITE);
		   btnHistory.setBounds(1174, 110, 170, 50);
		   AdminListUlam.getContentPane().add(btnHistory);
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
		
		JPanel clockPanel = new JPanel();
		clockPanel.setOpaque(false);
	 	clockPanel.setBackground(new Color(0, 0, 160));
        clockPanel.setBounds(10, 10, 132, 30);
        AdminListUlam.getContentPane().add(clockPanel);

        // Call the showClock() method to display the clock on the panel
        FileOperation.showClock(clockPanel);
		
		
		//Snacks button
        JButton btnSnacks = new JButton("");
        btnSnacks.setIcon(new ImageIcon(getClass().getResource("/pictures/image 1.png")));
        btnSnacks.setOpaque(true);
        btnSnacks.setFocusPainted(false);
        btnSnacks.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)));
        btnSnacks.setBackground(new Color(8, 53, 139));
        btnSnacks.setBounds(200, 85, 71, 89);
        AdminListUlam.getContentPane().add(btnSnacks);
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
					AdminListUlam.dispose();
            		
            	}
            });
        //Drinks Button
        JButton btnSoda = new JButton("");  
        btnSoda.setIcon(new ImageIcon(getClass().getResource("/Pictures/Soda.png")));
        btnSoda.setOpaque(true);
        btnSoda.setBorderPainted(true);
        btnSoda.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)));
        btnSoda.setFocusPainted(false);
        btnSoda.setBackground(new Color(8, 53, 139));
        btnSoda.setBounds(119, 85, 71, 89);
        AdminListUlam.getContentPane().add(btnSoda);

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
        		AdminPrimeListMenu2 window = new AdminPrimeListMenu2();
				window.AdminListDrinks.setVisible(true);
				AdminListUlam.dispose();
        		
        	}
        });
        
     // Ulam Button
        JButton btnUlam = new JButton("");
        btnUlam.setIcon(new ImageIcon(getClass().getResource("/pictures/Chicken.png")));
        btnUlam.setFocusPainted(false);
        btnUlam.setBounds(38, 85, 71, 89);
        btnUlam.setBackground(new Color(8, 53, 139));
        btnUlam.setOpaque(true);
        btnUlam.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null)); // Set initial line border
        AdminListUlam.getContentPane().add(btnUlam);
		
		JButton btnLogOut = new JButton("");
        btnLogOut.setIcon(new ImageIcon(getClass().getResource("/pictures/Log Out (2).png")));
        btnLogOut.setOpaque(true);
        btnLogOut.setBorderPainted(true);
		btnLogOut.setFocusPainted(false);
        btnLogOut.setBackground(new Color(255, 255, 255));
        btnLogOut.setBounds(20, 710, 195, 50);
        AdminListUlam.getContentPane().add(btnLogOut);
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
	            FileOperation.copyFile("src/data/primeMenu1.txt","src/data/primeMenu2.txt");
        		AdminLogin window = new AdminLogin();
                window.AdminLogin.setVisible(true);
                AdminListUlam.dispose();
        	}
        });
        
	        JButton btnDish0 = new JButton("");
	        btnDish0.setBackground(Color.WHITE);
	        btnDish0.setIcon(new ImageIcon(getClass().getResource("/pictures/PrimeAdmin Rice.png")));
	        btnDish0.setBounds(802, 607, 170, 180);
	       
	        AdminListUlam.getContentPane().add(btnDish0);
	        btnDish0.addMouseListener(new MouseAdapter() {
	        
	        	public void mouseEntered(java.awt.event.MouseEvent evt) {
	        		btnDish0.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
		    }
	        	public void mouseExited(java.awt.event.MouseEvent evt) {
	        		btnDish0.setBorder(null); // Reset the border when the mouse exits
		    }
	        	public void mouseClicked(java.awt.event.MouseEvent evt) {
	                showEditDialog("rice");
	            }
	        });	 
	        JButton btnDish1 = new JButton("");
	        btnDish1.setBackground(Color.WHITE);
	        btnDish1.setIcon(new ImageIcon(getClass().getResource("/pictures/PrimeAdmin HotDog.png")));
	       
	        btnDish1.setBounds(58, 205, 170, 180);
	        AdminListUlam.getContentPane().add(btnDish1);
	        btnDish1.addMouseListener(new MouseAdapter() {	        
	        	public void mouseEntered(java.awt.event.MouseEvent evt) {
	        		btnDish1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
		    }
	        	public void mouseExited(java.awt.event.MouseEvent evt) {
	        		btnDish1.setBorder(null); // Reset the border when the mouse exits
		    }
	        	public void mouseClicked(java.awt.event.MouseEvent evt) {
	                showEditDialog("Hotdog");
	                FileOperation.copyFile("src/data/primeMenu1.txt","src/data/primeMenu2.txt" );

	            }
	        });
	        
	        JButton btnDish2 = new JButton("");
	        btnDish2.setBackground(Color.WHITE);
	        btnDish2.setIcon (new ImageIcon(getClass().getResource("/pictures/PrimeAdmin Spam.png")));
	        btnDish2.setBounds(244, 205, 170, 180);
	       
	        AdminListUlam.getContentPane().add(btnDish2);
	        btnDish2.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	btnDish2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
			    }
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnDish2.setBorder(null); // Reset the border when the mouse exits
			    }
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
	                showEditDialog("Spam");
	                FileOperation.copyFile("src/data/primeMenu1.txt","src/data/primeMenu2.txt" );

	            }
	        });
	        
	        JButton btnDish3 = new JButton("");
	        btnDish3.setBackground(Color.WHITE);
	        btnDish3.setIcon(new ImageIcon(getClass().getResource("/pictures/PrimeAdmin Fried Egg.png")));
	        btnDish3.setBounds(430, 205, 170, 180);
	        AdminListUlam.getContentPane().add(btnDish3);
	        btnDish3.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	btnDish3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
			    }
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnDish3.setBorder(null); // Reset the border when the mouse exits
			    }
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
	                showEditDialog("Fried_Egg");
	                FileOperation.copyFile("src/data/primeMenu1.txt","src/data/primeMenu2.txt" );

	            }
	        });
	        
	        JButton btnDish4 = new JButton("");
	        btnDish4.setBackground(Color.WHITE);
	        btnDish4.setIcon(new ImageIcon(getClass().getResource("/pictures/PrimeAdmin Skinless Longanisa.png")));
	        btnDish4.setBounds(616, 205, 170, 180);
	        AdminListUlam.getContentPane().add(btnDish4);
	        btnDish4.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	btnDish4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
			    }
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnDish4.setBorder(null); // Reset the border when the mouse exits
			    }
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
	                showEditDialog("Skinless_Longanisa");
	                FileOperation.copyFile("src/data/primeMenu1.txt","src/data/primeMenu2.txt" );

	            }
	        });
	        
	        JButton btnDish5 = new JButton("");
	        btnDish5.setBackground(Color.WHITE);
	        btnDish5.setIcon(new ImageIcon(getClass().getResource("/pictures/PrimeAdmin Hungarian Sausage.png")));
	        btnDish5.setBounds(802, 205, 170, 180);
	        AdminListUlam.getContentPane().add(btnDish5);
	        btnDish5.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	btnDish5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
			    }
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnDish5.setBorder(null); // Reset the border when the mouse exits
			    }
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
	                showEditDialog("Hungarian_Sausage");
	                FileOperation.copyFile("src/data/primeMenu1.txt","src/data/primeMenu2.txt" );

	            }
	        });
	        
	        JButton btnDish6 = new JButton("");
	        btnDish6.setBackground(Color.WHITE);
	        btnDish6.setIcon(new ImageIcon(getClass().getResource("/pictures/PrimeAdmin Maling.png")));
	        btnDish6.setBounds(988, 205, 170, 180);
	        AdminListUlam.getContentPane().add(btnDish6);
	        btnDish6.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	btnDish6.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
			    }
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnDish6.setBorder(null); // Reset the border when the mouse exits
			    }
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
	                showEditDialog("Maling");
	                FileOperation.copyFile("src/data/primeMenu1.txt","src/data/primeMenu2.txt" );

	            }
	        });
	        
	        JButton btnDish7 = new JButton("");
	        btnDish7.setBackground(Color.WHITE);
	        btnDish7.setIcon(new ImageIcon(getClass().getResource("/pictures/PrimeAdmin Pork Tocino.png")));
	        btnDish7.setBounds(1174, 205, 170, 180);
	        AdminListUlam.getContentPane().add(btnDish7);
	        btnDish7.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	btnDish7.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
			    }
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnDish7.setBorder(null); // Reset the border when the mouse exits
			    }
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
	                showEditDialog("Pork_Tocino");
	                FileOperation.copyFile("src/data/primeMenu1.txt","src/data/primeMenu2.txt" );

	            }
	        });
		
		 
	        JButton btnDish8 = new JButton("");
	        btnDish8.setBackground(Color.WHITE);
	        btnDish8.setIcon(new ImageIcon(getClass().getResource("/pictures/PrimeAdmin Chicken Sausage.png")));
	        btnDish8.setBounds(58, 413, 170, 180);
	        AdminListUlam.getContentPane().add(btnDish8);
	        btnDish8.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	btnDish8.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
			    }
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnDish8.setBorder(null); // Reset the border when the mouse exits
			    }
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
	                showEditDialog("Chicken_Sausage");
	                FileOperation.copyFile("src/data/primeMenu1.txt","src/data/primeMenu2.txt" );

	            }
	        });
		
		JButton btnDish9 = new JButton("");
		btnDish9.setBackground(Color.WHITE);
		btnDish9.setIcon(new ImageIcon(getClass().getResource("/pictures/PrimeAdmin Sisig.png")));
		btnDish9.setBounds(1174, 413, 170, 180);
		AdminListUlam.getContentPane().add(btnDish9);
		btnDish9.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnDish9.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnDish9.setBorder(null); // Reset the border when the mouse exits
		    }
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        showEditDialog("Sisig");
		        FileOperation.copyFile("src/data/primeMenu1.txt","src/data/primeMenu2.txt" );

		    }
		});
		
		JButton btnDish10 = new JButton("");
		btnDish10.setBackground(Color.WHITE);
		btnDish10.setIcon(new ImageIcon(getClass().getResource("/pictures/PrimeAdmin Fish Fillet.png")));
		btnDish10.setBounds(244, 413, 170, 180);
		AdminListUlam.getContentPane().add(btnDish10);
		btnDish10.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnDish10.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnDish10.setBorder(null); // Reset the border when the mouse exits
		    }
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        showEditDialog("Fish_Fillet");
		        FileOperation.copyFile("src/data/primeMenu1.txt","src/data/primeMenu2.txt" );

		    }
		});
		
		JButton btnDish11 = new JButton("");
		btnDish11.setBackground(Color.WHITE);
		btnDish11.setIcon(new ImageIcon(getClass().getResource("/pictures/PrimeAdmin Beef Brocolli.png")));
		btnDish11.setBounds(430, 413, 170, 180);
		AdminListUlam.getContentPane().add(btnDish11);
		btnDish11.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnDish11.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnDish11.setBorder(null); // Reset the border when the mouse exits
		    }
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        showEditDialog("Beef_w/Broccoli");
		        FileOperation.copyFile("src/data/primeMenu1.txt","src/data/primeMenu2.txt" );

		    }
		});
		
		
		JButton btnDish12 = new JButton("");
		btnDish12.setBackground(Color.WHITE);
		btnDish12.setIcon(new ImageIcon(getClass().getResource("/pictures/PrimeAdmin Roast ChickenBBQ.png")));
		btnDish12.setBounds(616, 413, 170, 180);
		AdminListUlam.getContentPane().add(btnDish12);
		btnDish12.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnDish12.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnDish12.setBorder(null); // Reset the border when the mouse exits
		    }
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        showEditDialog("Roast_ChickenBBQ");
		        FileOperation.copyFile("src/data/primeMenu1.txt","src/data/primeMenu2.txt" );

		    }
		});
		
		JButton btnDish13 = new JButton("");
		btnDish13.setBackground(Color.WHITE);
		btnDish13.setIcon(new ImageIcon(getClass().getResource("/pictures/PrimeAdmin Roast Pork.png")));
		btnDish13.setBounds(802, 413, 170, 180);
		AdminListUlam.getContentPane().add(btnDish13);
		btnDish13.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnDish13.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnDish13.setBorder(null); // Reset the border when the mouse exits
		    }
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        showEditDialog("Roast_Pork");
		        FileOperation.copyFile("src/data/primeMenu1.txt","src/data/primeMenu2.txt" );

		    }
		});
		
		JButton btnDish14 = new JButton("");
		btnDish14.setBackground(Color.WHITE);
		btnDish14.setIcon(new ImageIcon(getClass().getResource("/pictures/PrimeAdmin Boneless Bangus.png")));
		btnDish14.setBounds(988, 413, 170, 180);
		AdminListUlam.getContentPane().add(btnDish14);
		btnDish14.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnDish14.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnDish14.setBorder(null); // Reset the border when the mouse exits
		    }
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        showEditDialog("Boneless_Bangus");
		        FileOperation.copyFile("src/data/primeMenu1.txt","src/data/primeMenu2.txt" );

		    }
		});	
		JButton btnDish15 = new JButton("");
		btnDish15.setBackground(new Color(255, 255, 255));
		btnDish15.setIcon(new ImageIcon(getClass().getResource("/pictures/PrimeAdmin Chicken Adobo.png")));
		btnDish15.setBounds(1174, 607, 170, 180);
		AdminListUlam.getContentPane().add(btnDish15);
		btnDish15.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnDish15.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnDish15.setBorder(null); // Reset the border when the mouse exits
		    }
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        showEditDialog("Chicken_Adobo");
		        FileOperation.copyFile("src/data/primeMenu1.txt","src/data/primeMenu2.txt" );

		    }
		});
		JButton btnDish16 = new JButton("");
		btnDish16.setBackground(Color.WHITE);
		btnDish16.setIcon(new ImageIcon(getClass().getResource("/pictures/PrimeAdmin Garlic Chicken.png")));
		btnDish16.setBounds(988, 607, 170, 180);
		AdminListUlam.getContentPane().add(btnDish16);
		btnDish16.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnDish16.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnDish16.setBorder(null); // Reset the border when the mouse exits
		    }
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        showEditDialog("Garlic_Chicken");
		        FileOperation.copyFile("src/data/primeMenu1.txt","src/data/primeMenu2.txt" );

		    }
		});
		
		
		
		
		JLabel lblDesign = new JLabel("");
		lblDesign.setIcon(new ImageIcon(getClass().getResource("/pictures/home screen (1).png")));
		lblDesign.setBounds(0, 0, 1401, 800);
		AdminListUlam.setShape(new RoundRectangle2D.Double(0, 0, AdminListUlam.getWidth(), AdminListUlam.getHeight(), 100, 100));
		AdminListUlam.getContentPane().add(lblDesign);
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
                AdminListUlam.setLocation(x, y);
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
	        String newQuantityStr = JOptionPane.showInputDialog(AdminListUlam, message, currentQuantity + "," + currentPrice);
	        if (newQuantityStr != null) {
	            try {
	                String[] parts = newQuantityStr.split(",");
	                if (parts.length == 2) {
	                    int newQuantity = Integer.parseInt(parts[0].trim());
	                    int newPrice = Integer.parseInt(parts[1].trim());
	                    dishQuantities.put(dishName, newQuantity);
	                    dishPrices.put(dishName, newPrice);
	                    saveDishQuantities();
	                    JOptionPane.showMessageDialog(AdminListUlam, "Quantity and price updated successfully!");
	                } else {
	                    throw new NumberFormatException();
	                }
	            } catch (NumberFormatException e) {
	                JOptionPane.showMessageDialog(AdminListUlam, "Invalid input format! Please enter quantity and price separated by a comma (e.g., 10,5.99).");
	            }
	        }
	    } else {
	        JOptionPane.showMessageDialog(AdminListUlam, "Dish not found!");
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

