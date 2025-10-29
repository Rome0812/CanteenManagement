# Canteen Management System

A Java Swing application for managing a school/college canteen using Object-Oriented Programming principles. The system features file reading/writing operations for data persistence and separate interfaces for administrators and students.

## Prerequisites

Before running the application, make sure you have:
- Java Development Kit (JDK) installed on your computer
- The complete source code downloaded

## How to Run the Application

1. Open a terminal/command prompt
2. Navigate to the project's source directory:
   ```
   cd path\to\CanteenManagement-main\src
   ```
3. Compile all Java files:
   ```
   javac System/*.java
   ```
4. Run the application:
   ```
   java System.Home
   ```

## Using the Application

Once the application starts, you'll see two main options:

### Student Access
- Click on the "Student" button to directly access the store interface
- Browse available menu items
- Place orders
- View receipts

### Administrator Access
- Click on the "Admin" button
- Login with administrator credentials
- Manage menus
- View history
- Access administrative functions

## Project Structure
```
src/
  └── System/
      ├── Admin.java            - Administrator functionality
      ├── AdminAccount.java     - Admin account management
      ├── AdminLogin.java       - Admin authentication
      ├── Home.java            - Main application entry point
      └── ... (other system files)

data/
  ├── history.txt              - Order history
  ├── LyndasMenu1.txt         - Menu data files
  ├── LyndasMenu2.txt
  ├── primeMenu1.txt
  └── primeMenu2.txt
```

## Features

- User-friendly graphical interface with drag-and-drop window movement
- Separate access levels for students and administrators
- Menu management system
- Order processing
- History tracking
- Receipt generation
- File-based data storage
- Real-time clock display

## Note

Make sure all image resources are present in the `/pictures` directory and all data files are properly set up in the `/data` directory before running the application.
