# ✈️ Airport Management System - DAC

**Semester Final Project** for **CSC 1205 (Object Oriented Programming 1)** at **American International University-Bangladesh (AIUB)**.

This application is a robust Java Swing-based desktop solution designed for managing airport operations, providing a secure environment for flight scheduling, real-time statistics, and immigration data tracking.

---

## 🌟 Key Features

* **Secure Admin Control:** Access is restricted via JobID (e.g., `25-62997-2`) and Password verification to ensure only authorized personnel can manage data.
* **Persistent Storage (File I/O):** Automatically creates and updates `Departure.txt` and `Arrival.txt` to store flight records permanently.
* **Real-time Clock & Stats:** Features a dynamic clock updated every second via `javax.swing.Timer` and a dashboard to track total arrivals, departures, and passenger counts.
* **Input Validation:** Integrated `try-catch` blocks and `JOptionPane` alerts to handle empty fields or invalid numerical inputs.
* **Interactive UI:** Includes custom hover effects using `MouseListener` and a password visibility toggle.

---

## 🏗️ OOP Concepts Applied

This project strictly follows the four pillars of Object-Oriented Programming:



* **Encapsulation:** Private attributes in the `Airport` class (like `jobID`, `flightType`, `time`) are managed through constructors to protect data integrity.
* **Inheritance:** The `AirportFrame` class extends `JFrame`, inheriting all properties and methods of the Java Swing Frame.
* **Abstraction:** Complex backend logic, such as file management and input/output streams in `insertFlightInfo()`, is hidden from the user, providing a simple functional interface.
* **Polymorphism:** Implements `ActionListener` and `MouseListener` to override methods like `actionPerformed` and `mouseClicked`, allowing different components to respond uniquely to user events.

---

## 📸 Screenshots

### Welcome Portal
![Welcome Portal](https://github.com/user-attachments/assets/eb8efffc-6d37-4c5a-baa9-fb7e831dd44a)

### Admin Dashboard
![Admin Panel](https://github.com/user-attachments/assets/7baccdbe-6d97-4aa3-8696-ee27b1e7fe9d)

---

## 🛠️ Tech Stack
* **Language:** Java
* **GUI Framework:** Java Swing & AWT
* **Storage:** Local File System (.txt)
* **Tools:** VS Code / Git

---

## 👥 Contributors
* **PROSENJIT DATTA** - *Lead Developer*
* **RABBINA TAHMID ALAM** - *Collaborator*

**Faculty:** NYME AHMED

**Semester:** Fall 2025-26

---

## 🚀 How to Run
1. Ensure you have **JDK** installed on your system.
2. Clone this repository.
3. Open your terminal in the project directory and run:
```bash
javac Start.java && java Start
