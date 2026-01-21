package Entity;

import Frame.*;
import java.lang.*;
import java.io.*; // for File IO
import javax.swing.*;

public class Airport {
    // Attributes based on AirportFrame AdminPanel inputs
    private String jobID, flightType, time, flightNo, destination, gate, checkIn, status;
    private int totalPass;

    private File dpFile, arrFile;
    private FileWriter fwriterDP, fwriterArr;

    public Airport() { }

    // Constructor to initialize all flight details
    public Airport(String jobID, String flightType, String time, String flightNo, String destination, String gate, String checkIn, String status, int totalPass) {
        this.jobID = jobID;
        this.flightType = flightType;
        this.time = time;
        this.flightNo = flightNo;
        this.destination = destination;
        this.gate = gate;
        this.checkIn = checkIn;
        this.status = status;
        this.totalPass = totalPass;
    }

    public void insertFlightInfo() {
        try {
            // Path where flight data will be stored
            dpFile = new File("./Data/Departure.txt");
            arrFile = new File("./Data/Arrival.txt");

            if (!dpFile.exists()) 
			{
                dpFile.getParentFile().mkdirs();
                dpFile.createNewFile();
            }
            
			if (!arrFile.exists()) 
			{
                arrFile.getParentFile().mkdirs();
                arrFile.createNewFile();
            }

            // 'true' ensures the data is appended rather than overwritten
            fwriterDP = new FileWriter(dpFile, true);
            fwriterArr = new FileWriter(arrFile, true);

            if(flightType.equals("Departure")){
                fwriterDP.write("========================================\n");
                fwriterDP.write("Admin JobID     : " + jobID + "\n");
                fwriterDP.write("Flight Type     : " + flightType + "\n");
                fwriterDP.write("Scheduled Time  : " + time + "\n");
                fwriterDP.write("Flight Number   : " + flightNo + "\n");
                fwriterDP.write("Destination     : " + destination + "\n");
                fwriterDP.write("Gate            : " + gate + "\n");
                fwriterDP.write("Check-in Counter: " + checkIn + "\n");
                fwriterDP.write("Current Status  : " + status + "\n");
                fwriterDP.write("Total Passengers: " + totalPass + "\n");
                fwriterDP.write("========================================\n");

                fwriterDP.flush(); // Ensure data is written to disk
                fwriterDP.close(); // Close the stream
                fwriterArr.close();
            
            JOptionPane.showMessageDialog(null, "Flight Information Saved Successfully! for Departure");
            }
            else if(flightType.equals("Arrival")){
                fwriterArr.write("========================================\n");
                fwriterArr.write("Admin JobID     : " + jobID + "\n");
                fwriterArr.write("Flight Type     : " + flightType + "\n");
                fwriterArr.write("Scheduled Time  : " + time + "\n");
                fwriterArr.write("Flight Number   : " + flightNo + "\n");
                fwriterArr.write("Destination     : " + destination + "\n");
                fwriterArr.write("Gate            : " + gate + "\n");
                fwriterArr.write("Check-in Counter: " + checkIn + "\n");
                fwriterArr.write("Current Status  : " + status + "\n");
                fwriterArr.write("Total Passengers: " + totalPass + "\n");
                fwriterArr.write("========================================\n");

                fwriterArr.flush(); // Ensure data is written to disk
                fwriterArr.close(); // Close the stream
                fwriterDP.close();

                JOptionPane.showMessageDialog(null, "Flight Information Saved Successfully! for Arrival");

            }
            
        } 
        catch (IOException ioe) {
            ioe.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error occurred while saving flight data.");
        }
    }
}