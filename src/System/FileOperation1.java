package System;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.*;


public class FileOperation1 {
	
	
	 public static void copyFile(String sourcePath, String destinationPath) {
	        Path sourceFile = Path.of(sourcePath);
	        Path destinationFile = Path.of(destinationPath);
	        
	        try {
	            Files.copy(sourceFile, destinationFile, StandardCopyOption.REPLACE_EXISTING);
	            System.out.println("File copied successfully: " + sourcePath + " -> " + destinationPath);
	        } catch (IOException e) {
	            System.out.println("An error occurred while copying the file.");
	            e.printStackTrace();
	        }
	    }
	 
	public static void clearFile(String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(""); // Write an empty string to clear the file
            fileWriter.close();

            System.out.println("File cleared successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while clearing the file.");
            e.printStackTrace();
        }
    }
	public static void showClock(JPanel panel) {
	    // Create a label to display the clock
	    JLabel clockLabel = new JLabel();
	    clockLabel.setFont(new Font("Arial", Font.BOLD, 24));
	    clockLabel.setHorizontalAlignment(SwingConstants.CENTER);

	    // Create a timer to update the clock every second
	    Timer timer = new Timer(1000, new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            // Update the clock label with the current time
	            SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
	            String currentTime = dateFormat.format(new Date());
	            clockLabel.setText(currentTime);
	        }
	    });

	    // Start the timer
	    timer.start();

	    // Add the clock label to the panel
	    panel.add(clockLabel);
	}
}