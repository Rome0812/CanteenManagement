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

import javax.swing.border.Border;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import java.util.Map;
import java.util.HashMap;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminLyndasListMenu1 {

	public JFrame LyndaListUlam;
	
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
					AdminLyndasListMenu1 window = new AdminLyndasListMenu1();
					window.LyndaListUlam.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public AdminLyndasListMenu1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		LyndaListUlam = new JFrame();
		LyndaListUlam.setUndecorated(true);
		LyndaListUlam.setBounds(100, 100, 1401, 799);
		LyndaListUlam.setLocationRelativeTo(null);
		LyndaListUlam.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LyndaListUlam.getContentPane().setLayout(null);
		   
		   JButton btnHistory = new JButton("");
		   btnHistory.setIcon(new ImageIcon(getClass().getResource("/Pictures/ORDER HISTORY.png")));
		   btnHistory.setOpaque(true);
		   btnHistory.setBackground(new Color(255, 255, 255));
		   btnHistory.setFocusPainted(false);
		   btnHistory.setBorderPainted(true);
		   btnHistory.setBackground(Color.WHITE);
		   btnHistory.setBounds(1174, 110, 170, 50);
		   LyndaListUlam.getContentPane().add(btnHistory);
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
		   
		   
		   
		   	           
		   JButton btnLogOut = new JButton("");
		   btnLogOut.setIcon(new ImageIcon(getClass().getResource("/pictures/Log Out (2).png")));
		   btnLogOut.setOpaque(true);
		   btnLogOut.setBorderPainted(true);
		   btnLogOut.setFocusPainted(false);
		   btnLogOut.setBackground(new Color(255, 255, 255));
		   btnLogOut.setBounds(20, 710, 195, 50);
		   LyndaListUlam.getContentPane().add(btnLogOut);
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
					LyndaListUlam.dispose();
		   	}
		   });
	        // Ulam Button
	           JButton btnUlam = new JButton("");
	           btnUlam.setIcon(new ImageIcon(getClass().getResource("/Pictures/Chicken.png")));
	           btnUlam.setFocusPainted(false);
	           btnUlam.setBounds(38, 85, 71, 89);
	           btnUlam.setBackground(new Color(8, 53, 139));
	           btnUlam.setOpaque(true);
	           btnUlam.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null)); // Set initial line border
	           LyndaListUlam.getContentPane().add(btnUlam);
	           
	        //Drinks Button
	        JButton btnSoda = new JButton("");  
	        btnSoda.setIcon(new ImageIcon(getClass().getResource("/Pictures/Soda.png")));
	        btnSoda.setOpaque(true);
	        btnSoda.setBorderPainted(true);
	        btnSoda.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)));
	        btnSoda.setFocusPainted(false);
	        btnSoda.setBackground(new Color(8, 53, 139));
	        btnSoda.setBounds(119, 85, 71, 89);
	        LyndaListUlam.getContentPane().add(btnSoda);
	        
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
	        				LyndaListUlam.dispose();
	                		
	                	}
	                });
	                //Snacks button
	                JButton btnSnacks = new JButton("");
	                btnSnacks.setIcon(new ImageIcon(getClass().getResource("/Pictures/image 1.png")));
	                btnSnacks.setOpaque(true);
	                btnSnacks.setFocusPainted(false);
	                btnSnacks.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,  null, null, null, null),new EmptyBorder(2, 2, 2, 2)));
	                btnSnacks.setBackground(new Color(8, 53, 139));
	                btnSnacks.setBounds(200, 85, 71, 89);
	                LyndaListUlam.getContentPane().add(btnSnacks);
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
	                        	AdminLyndasListMenu3 window = new AdminLyndasListMenu3();
	        					window.LyndaListSnacks.setVisible(true);
	            				LyndaListUlam.dispose();
	                    		
	                    	}
	                    });
	        // Call the showClock() method to display the clock on the panel
	        JPanel clockPanel = new JPanel();
	        clockPanel.setOpaque(false);
	        clockPanel.setBackground(new Color(0, 0, 160));
	        clockPanel.setBounds(10, 10, 132, 30);
	        LyndaListUlam.getContentPane().add(clockPanel);
	        FileOperation.showClock(clockPanel);
	        
	        JButton btnDish0 = new JButton("");
	        btnDish0.setBackground(Color.WHITE);
	        btnDish0.setBounds(802, 604, 170, 180);
	        btnDish0.setIcon(new ImageIcon(getClass().getResource("/Pictures/LyndasAdmin Rice.png")));
	        LyndaListUlam.getContentPane().add(btnDish0);
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
	        btnDish1.setIcon(new ImageIcon(getClass().getResource("/Pictures/LyndasAdmin Tapa.png")));
	        btnDish1.setBounds(58, 205, 170, 180);
	        LyndaListUlam.getContentPane().add(btnDish1);
	        btnDish1.addMouseListener(new MouseAdapter() {
	        
	        	public void mouseEntered(java.awt.event.MouseEvent evt) {
	        		btnDish1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
		    }
	        	public void mouseExited(java.awt.event.MouseEvent evt) {
	        		btnDish1.setBorder(null); // Reset the border when the mouse exits
		    }
	        	public void mouseClicked(java.awt.event.MouseEvent evt) {
	                showEditDialog("Tapa");
	            }
	        });
	        
	        JButton btnDish2 = new JButton("");
	        btnDish2.setBackground(Color.WHITE);
	        btnDish2.setBounds(244, 205, 170, 180);
	        btnDish2.setIcon(new ImageIcon(getClass().getResource("/Pictures/LyndasAdmin Tuyo.png")));
	        LyndaListUlam.getContentPane().add(btnDish2);
	        btnDish2.addMouseListener(new MouseAdapter() {		        
	        	public void mouseEntered(java.awt.event.MouseEvent evt) {
	        		btnDish2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
		    }
	        	public void mouseExited(java.awt.event.MouseEvent evt) {
	        		btnDish2.setBorder(null); // Reset the border when the mouse exits
		    }
	        	public void mouseClicked(java.awt.event.MouseEvent evt) {
	                showEditDialog("Tuyo");
	            }
	        });
	        
	        JButton btnDish3 = new JButton("");
	        btnDish3.setBackground(Color.WHITE);
	        btnDish3.setBounds(430, 205, 170, 180);
	        btnDish3.setIcon(new ImageIcon(getClass().getResource("/Pictures/LyndasAdmin Champorado.png")));
	        LyndaListUlam.getContentPane().add(btnDish3);
	        btnDish3.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	btnDish3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
			    }
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnDish3.setBorder(null); // Reset the border when the mouse exits
			    }
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
	                showEditDialog("Champorado");
	            }
	        });
	        
	        JButton btnDish4 = new JButton("");
	        btnDish4.setBackground(Color.WHITE);
	        btnDish4.setBounds(616, 205, 170, 180);
	        btnDish4.setIcon(new ImageIcon(getClass().getResource("/Pictures/LyndasAdmin Lugaw.png")));
	        LyndaListUlam.getContentPane().add(btnDish4);
	        btnDish4.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	btnDish4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
			    }
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnDish4.setBorder(null); // Reset the border when the mouse exits
			    }
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
	                showEditDialog("Lugaw");
	                FileOperation.copyFile("src/data/LyndasMenu1.txt","src/data/LyndasMenu2.txt" );
	            }
	        });
	        
	        JButton btnDish5 = new JButton("");
	        btnDish5.setBackground(Color.WHITE);
	        btnDish5.setBounds(802, 205, 170, 180);
	        btnDish5.setIcon(new ImageIcon(getClass().getResource("/Pictures/LyndasAdmin Tocino.png")));
	        LyndaListUlam.getContentPane().add(btnDish5);
	        btnDish5.addMouseListener(new MouseAdapter() {		        
	        	public void mouseEntered(java.awt.event.MouseEvent evt) {
	        		btnDish5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
		    }
	        	public void mouseExited(java.awt.event.MouseEvent evt) {
	        		btnDish5.setBorder(null); // Reset the border when the mouse exits
		    }
	        	public void mouseClicked(java.awt.event.MouseEvent evt) {
	                showEditDialog("Tocino");
	            }
	        });
	        
	        JButton btnDish6 = new JButton("");
	        btnDish6.setBackground(Color.WHITE);
	        btnDish6.setBounds(988, 205, 170, 180);
	        btnDish6.setIcon(new ImageIcon(getClass().getResource("/Pictures/LyndasAdmin Sopas.png")));
	        LyndaListUlam.getContentPane().add(btnDish6);
	        btnDish6.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	btnDish6.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
			    }
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnDish6.setBorder(null); // Reset the border when the mouse exits
			    }
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
	                showEditDialog("Sopas");
	            }
	        });
	        
	        JButton btnDish7 = new JButton("");
	        btnDish7.setBackground(Color.WHITE);
	        btnDish7.setBounds(1174, 205, 170, 180);
	        btnDish7.setIcon(new ImageIcon(getClass().getResource("/Pictures/LyndasAdmin Embutido.png")));
	        LyndaListUlam.getContentPane().add(btnDish7);
	        btnDish7.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	btnDish7.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
			    }
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnDish7.setBorder(null); // Reset the border when the mouse exits
			    }
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
	                showEditDialog("Embutido");
	            }
	        });
		
		 
	        JButton btnDish8 = new JButton("");
	        btnDish8.setBackground(Color.WHITE);
	        btnDish8.setBounds(58, 413, 170, 180);
	        btnDish8.setIcon(new ImageIcon(getClass().getResource("/Pictures/LyndasAdmin Tortang Talong.png")));
	        LyndaListUlam.getContentPane().add(btnDish8);
	        btnDish8.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	btnDish8.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
			    }
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	btnDish8.setBorder(null); // Reset the border when the mouse exits
			    }
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
	                showEditDialog("Tortang_Talong");
	                FileOperation.copyFile("src/data/LyndasMenu1.txt","src/data/LyndasMenu2.txt" );
	            }
	        });
		
		JButton btnDish9 = new JButton("");
		btnDish9.setBackground(Color.WHITE);
		btnDish9.setBounds(430, 413, 170, 180);
		btnDish9.setIcon(new ImageIcon(getClass().getResource("/Pictures/LyndasAdmin Sisig.png")));
		LyndaListUlam.getContentPane().add(btnDish9);
		btnDish9.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnDish9.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnDish9.setBorder(null); // Reset the border when the mouse exits
		    }
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        showEditDialog("Sisig");
		        FileOperation.copyFile("src/data/LyndasMenu1.txt","src/data/LyndasMenu2.txt" );
		    }
		});
		
		JButton btnDish10 = new JButton("");
		btnDish10.setBackground(Color.WHITE);
		btnDish10.setBounds(244, 413, 170, 180);
		btnDish10.setIcon(new ImageIcon(getClass().getResource("/Pictures/LyndasAdmin Sinigang na Baboy.png")));
		LyndaListUlam.getContentPane().add(btnDish10);
		btnDish10.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnDish10.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnDish10.setBorder(null); // Reset the border when the mouse exits
		    }
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        showEditDialog("Sinigang_na_Baboy");
		        FileOperation.copyFile("src/data/LyndasMenu1.txt","src/data/LyndasMenu2.txt" );
		    }
		});
		
		JButton btnDish11 = new JButton("");
		btnDish11.setBackground(Color.WHITE);
		btnDish11.setBounds(616, 413, 170, 180);
		btnDish11.setIcon(new ImageIcon(getClass().getResource("/Pictures/LyndasAdmin Menudo.png")));
		LyndaListUlam.getContentPane().add(btnDish11);
		btnDish11.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnDish11.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnDish11.setBorder(null); // Reset the border when the mouse exits
		    }
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        showEditDialog("Menudo");
		        FileOperation.copyFile("src/data/LyndasMenu1.txt","src/data/LyndasMenu2.txt" );
		    }
		});
		
		
		JButton btnDish12 = new JButton("");
		btnDish12.setBackground(Color.WHITE);
		btnDish12.setBounds(802, 413, 170, 180);
		btnDish12.setIcon(new ImageIcon(getClass().getResource("/Pictures/LyndasAdmin Ginataang Manok.png")));
		LyndaListUlam.getContentPane().add(btnDish12);
		btnDish12.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnDish12.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnDish12.setBorder(null); // Reset the border when the mouse exits
		    }
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        showEditDialog("Ginataang_Manok");
		        FileOperation.copyFile("src/data/LyndasMenu1.txt","src/data/LyndasMenu2.txt" );
		    }
		});
		
		JButton btnDish13 = new JButton("");
		btnDish13.setBackground(Color.WHITE);
		btnDish13.setBounds(988, 413, 170, 180);
		btnDish13.setIcon(new ImageIcon(getClass().getResource("/Pictures/LyndasAdmin Pork Steak.png")));
		LyndaListUlam.getContentPane().add(btnDish13);
		btnDish13.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnDish13.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnDish13.setBorder(null); // Reset the border when the mouse exits
		    }
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        showEditDialog("Pork_Steak");
		        FileOperation.copyFile("src/data/LyndasMenu1.txt","src/data/LyndasMenu2.txt" );
		    }
		});
		
		JButton btnDish14 = new JButton("");
		btnDish14.setBackground(Color.WHITE);
		btnDish14.setBounds(1174, 413, 170, 180);
		btnDish14.setIcon(new ImageIcon(getClass().getResource("/Pictures/LyndasAdmin Caldereta.png")));
		LyndaListUlam.getContentPane().add(btnDish14);
		btnDish14.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnDish14.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnDish14.setBorder(null); // Reset the border when the mouse exits
		    }
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        showEditDialog("Caldereta");
		        FileOperation.copyFile("src/data/LyndasMenu1.txt","src/data/LyndasMenu2.txt" );
		    }
		});
		
		JButton btnDish15 = new JButton("");
		btnDish15.setBackground(Color.WHITE);
		btnDish15.setBounds(1174, 604, 170, 180);
		btnDish15.setIcon(new ImageIcon(getClass().getResource("/Pictures/LyndasAdmin Adobong Pusit.png")));
		LyndaListUlam.getContentPane().add(btnDish15);
		btnDish15.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnDish15.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnDish15.setBorder(null); // Reset the border when the mouse exits
		    }
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        showEditDialog("Adobong_Pusit");
		        FileOperation.copyFile("src/data/LyndasMenu1.txt","src/data/LyndasMenu2.txt" );
		    }
		});
		
		JButton btnDish16 = new JButton("");
		btnDish16.setBackground(Color.WHITE);
		btnDish16.setBounds(988, 604, 170, 180);
		btnDish16.setIcon(new ImageIcon(getClass().getResource("/Pictures/LyndasAdmin Kare Kare.png")));
		LyndaListUlam.getContentPane().add(btnDish16);
		btnDish16.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnDish16.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Set the border when the mouse enters
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnDish16.setBorder(null); // Reset the border when the mouse exits
		    }
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        showEditDialog("Kare-kare");
		        FileOperation.copyFile("src/data/LyndasMenu1.txt","src/data/LyndasMenu2.txt" );
		    }
		});
		JLabel lblDesign = new JLabel("");
		lblDesign.setIcon(new ImageIcon(getClass().getResource("/pictures/home screen (2).png")));
		lblDesign.setBounds(0, 0, 1401, 800);
		LyndaListUlam.setShape(new RoundRectangle2D.Double(0, 0, LyndaListUlam.getWidth(), LyndaListUlam.getHeight(), 100, 100));
		LyndaListUlam.getContentPane().add(lblDesign);
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
                LyndaListUlam.setLocation(x, y);
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
	        String newQuantityStr = JOptionPane.showInputDialog(LyndaListUlam, message, currentQuantity + "," + currentPrice);
	        if (newQuantityStr != null) {
	            try {
	                String[] parts = newQuantityStr.split(",");
	                if (parts.length == 2) {
	                    int newQuantity = Integer.parseInt(parts[0].trim());
	                    int newPrice = Integer.parseInt(parts[1].trim());
	                    dishQuantities.put(dishName, newQuantity);
	                    dishPrices.put(dishName, newPrice);
	                    saveDishQuantities();
	                    JOptionPane.showMessageDialog(LyndaListUlam, "Quantity and price updated successfully!");
	                } else {
	                    throw new NumberFormatException();
	                }
	            } catch (NumberFormatException e) {
	                JOptionPane.showMessageDialog(LyndaListUlam, "Invalid input format! Please enter quantity and price separated by a comma (e.g., 10,5.99).");
	            }
	        }
	    } else {
	        JOptionPane.showMessageDialog(LyndaListUlam, "Dish not found!");
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
