# ✈️ Airport-Management-System

**Semester Final Project** for **CSC 1205 (Object Oriented Programming 1)** at **American International University-Bangladesh (AIUB)**. 

This is a comprehensive Java Swing-based desktop application designed for managing airport operations. It provides a user-friendly interface for administrators to handle flight schedules, track timing, and manage passenger data.

---

## 🌟 Key Features

* **Real-time Clock:** A dynamic clock integrated into every panel (Welcome, Departure, Arrival, Admin, Stats) that updates every second using `javax.swing.Timer`.
* **Secure Admin Control:** A dedicated Admin Panel protected by JobID and Password verification using `JPasswordField` with masking.
* **Dynamic Flight Management:** Admins can easily add flight details using dropdown menus (`JComboBox`) for Destinations, Gate Numbers, and Check-in counters to ensure data accuracy.
* **Real-time Input Validation:** Uses `JOptionPane` for instant feedback and `try-catch` blocks to handle empty or invalid numerical inputs (like passenger counts) without crashing.
* **Interactive Navigation:** Smooth panel switching logic (Back/Exit) to ensure a seamless user experience across the application.
* **Password Toggle:** Includes a "Show Password" checkbox that utilizes `setEchoChar((char)0)` to toggle visibility for user convenience.

---

## 📸 Screenshots

### Admin Panel Interface
![Admin Panel](image_a238f6.png)
*Figure 1: The Administrative Control Center where flight details and schedules are managed.*

---

## 🛠️ Tech Stack

* **Programming Language:** Java
* **GUI Toolkit:** Java Swing & AWT
* **Project Type:** Desktop Application
* **Development Environment:** VS Code / Git

---

## 👥 Contributors

* **PROSENJIT DATTA** - *Lead Developer*
* **RABBINA TAHMID ALAM** - *Collaborator*

**Semester:** Fall 2025-26  
**Faculty Name:** NYME AHMED

---

## 🚀 How to Run

1. **Prerequisites:** Ensure you have Java Development Kit (JDK) installed.
2. **Clone the Project:** Download the repository to your local machine.
3. **Compile and Run:** Use the following command in your terminal:

```bash
javac Start.java && java Start
