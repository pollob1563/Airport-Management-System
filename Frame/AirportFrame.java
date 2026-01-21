package Frame;

import Entity.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.*;


//example of inheritance
//example of interface
public class AirportFrame extends JFrame implements ActionListener, MouseListener{

    private JPanel welcomePanel, departurePanel, arrivalPanel, adminPanel, statsPanel;
    private ImageIcon logo;
    private JButton adSave, departureButton, arrivalButton, adminButton, statsButton, backBtn1, backBtn2, backBtn3, backBtn4, ExitBtn1, ExitBtn2, ExitBtn3, ExitBtn4, ExitBtn5, save;

    private JTextField tfJobID, tfTime, tfFlightNo, tfTotalPass; 
    
    private JPasswordField pfPass;

    private JRadioButton rbDeparture, rbArrival;

    private ButtonGroup bg;

    private JComboBox cbAirlines, cbStatus, cbDest, cbGate, cbCheckIn;

    private Color c1, c2, c3, c4, c5, fg1;
    private Font f1,f2, welBtnF;

    private Timer clockTimer;

    private int dpCount = 0, arCount = 0, passengerCount = 0;
    // private String date, time, day, format;

    // this.time = LocalDateTime.now().getHour()+":"+LocalDateTime.now().getMinute();
    // this.date = LocalDateTime.now().getDayOfMonth()+" "+LocalDateTime.now().getMonth()+", "+LocalDateTime.now().getYear();
    // this.day = LocalDateTime.now().getDayOfWeek();
    // this.format = time+"  "+ day+" "+ date;

    private JTextArea taDep, taArr;
    private JScrollPane spDep, spArr;

    private JCheckBox showPass;

    private JLabel l1, l2, welTime, arrTime, depTime, adminTime,statsTime, adJob , l3, addPass, adFlightType, adTime, adFlight, adDest, adGate,adImmigration, adTotalPass, adCheckIn, adStatus, lStatsTitle, lTotalDep, lTotalArr, lTotalPassCount, lDepTitle, lArrTitle;;

    public void StatsPanel() {
    lStatsTitle = new JLabel("<html><u>Airport Statistics Overview</u></html>");
    lStatsTitle.setBounds(10, 0, 1050, 50); 
    lStatsTitle.setForeground(new Color(44, 62, 80));
    lStatsTitle.setFont(new Font("Tahoma", Font.BOLD, 32));
    statsPanel.add(lStatsTitle);

    lTotalDep = new JLabel("Total Departures: " + dpCount);
    lTotalDep.setBounds(100, 150, 500, 40);
    lTotalDep.setFont(new Font("Cambria", Font.BOLD, 25));
    statsPanel.add(lTotalDep);

    lTotalArr = new JLabel("Total Arrivals: " + arCount);
    lTotalArr.setBounds(100, 220, 500, 40);
    lTotalArr.setFont(new Font("Cambria", Font.BOLD, 25));
    statsPanel.add(lTotalArr);

    lTotalPassCount = new JLabel("Total Passengers (Immigration): " + passengerCount);
    lTotalPassCount.setBounds(100, 290, 600, 40);
    lTotalPassCount.setFont(new Font("Cambria", Font.BOLD, 25));
    lTotalPassCount.setForeground(Color.BLUE);
    statsPanel.add(lTotalPassCount);
}
    
    public void AdminPanel(){

        showPass = new JCheckBox("Show");
        showPass.setBounds(370, 110, 70, 25); 
        showPass.setBackground(new Color(189, 195, 199)); 
        showPass.addActionListener(this); 
        adminPanel.add(showPass);

        l3 = new JLabel("<html><u>Welcome To "+ getTitle()+" (Admin)</u></html>");
        l3.setBounds(10, 0, 1050, 50); 
        l3.setForeground(Color.ORANGE);
        l3.setFont(new Font("Tahoma", Font.BOLD, 32));
        adminPanel.add(l3);

        
        adJob = new JLabel("JobID: "); 
        adJob.setBounds(10, 70, 135, 25); 
        adJob.setOpaque(true);
        adJob.setFont(f2);
        adJob.setBackground(Color.RED);
        adminPanel.add(adJob);

        
        addPass = new JLabel("Password: "); 
        addPass.setBounds(10, 110, 135, 25); 
        addPass.setOpaque(true);
        addPass.setFont(f2);
        addPass.setBackground(Color.RED);
        adminPanel.add(addPass); 

        
        adFlightType = new JLabel("Flight Type: "); 
        adFlightType.setBounds(10, 150, 135, 25); 
        //adFlightType.setOpaque(true);
        adFlightType.setFont(f2);
        adminPanel.add(adFlightType);

        adTime = new JLabel("Time: "); 
        adTime.setBounds(10, 190, 135, 25); 
       // adTime.setOpaque(true);
        adTime.setFont(f2);
        adminPanel.add(adTime);

       
        adFlight = new JLabel("Flight No: "); 
        adFlight.setBounds(10, 230, 135, 25); 
        //adFlight.setOpaque(true);
        adFlight.setFont(f2);
        adminPanel.add(adFlight);

       
        adDest = new JLabel("Destination: "); 
        adDest.setBounds(10, 270, 135, 25); 
        //adDest.setOpaque(true);
        adDest.setFont(f2);
        adminPanel.add(adDest);

    
        adGate = new JLabel("Gate Number: "); 
        adGate.setBounds(10, 310, 135, 25); 
        //adGate.setOpaque(true);
        adGate.setFont(f2);
        adminPanel.add(adGate);

        //Check-in
        adCheckIn = new JLabel("Check-in: "); 
        adCheckIn.setBounds(10, 350, 135, 25); 
        //adCheckIn.setOpaque(true);
        adCheckIn.setFont(f2);
        adminPanel.add(adCheckIn);

        //Status
        adStatus = new JLabel("Status: "); 
        adStatus.setBounds(10, 390, 135, 25); 
        //adStatus.setOpaque(true);
        adStatus.setFont(f2);
        adminPanel.add(adStatus);


        lDepTitle = new JLabel("Departure Records:");
        lDepTitle.setBounds(450, 40, 200, 25);
        lDepTitle.setFont(f2);
        adminPanel.add(lDepTitle);

        taDep = new JTextArea();
        taDep.setEditable(false);
        taDep.setFont(new Font("Monospaced", Font.PLAIN, 13));
        spDep = new JScrollPane(taDep);
        spDep.setBounds(450, 70, 400, 500); 
        adminPanel.add(spDep);

        lArrTitle = new JLabel("Arrival Records:");
        lArrTitle.setBounds(870, 40, 200, 25);
        lArrTitle.setFont(f2);
        adminPanel.add(lArrTitle);

        taArr = new JTextArea();
        taArr.setEditable(false);
        taArr.setFont(new Font("Monospaced", Font.PLAIN, 13));
        spArr = new JScrollPane(taArr);
        spArr.setBounds(870, 70, 400, 500); 
        adminPanel.add(spArr);

        //Immigration Data
        adImmigration = new JLabel("<html><u>Immigration Data</u></html>"); 
        adImmigration.setBounds(10, 450, 320, 35); 
        adImmigration.setOpaque(true);
        adImmigration.setForeground(Color.RED);
        adImmigration.setBackground(Color.PINK);
        adImmigration.setFont(new Font("Tahoma", Font.BOLD, 35));
        adminPanel.add(adImmigration);

        adTotalPass = new JLabel("Total Passenger: "); 
        adTotalPass.setBounds(10, 510, 250, 25); 
        //adTotalPass.setOpaque(true);
        adTotalPass.setFont(f2); 
        adminPanel.add(adTotalPass);

        //INPUT Properties 

        // JobID
        tfJobID = new JTextField();
        tfJobID.setBounds(160, 70, 200, 25);
        adminPanel.add(tfJobID);

        // Password Input 
        pfPass = new JPasswordField();
        pfPass.setBounds(160, 110, 200, 25);
        pfPass.setEchoChar('*');
        pfPass.addActionListener(this);
        adminPanel.add(pfPass);

        // Flight Type (Departure or Arrival)
        rbDeparture = new JRadioButton("Departure");
        rbDeparture.setBounds(160, 150, 110, 25);
        adminPanel.add(rbDeparture);

        rbArrival = new JRadioButton("Arrival");
        rbArrival.setBounds(275, 150, 100, 25);
        adminPanel.add(rbArrival);

        bg = new ButtonGroup();
        bg.add(rbDeparture);
        bg.add(rbArrival);

        tfTime = new JTextField();
        tfTime.setBounds(160, 190, 100, 25); 
        adminPanel.add(tfTime);

        // Flight Company Dropdown 
        String airlines[] = {"","BG", "QR", "6E", "EK", "AI", "TK"};
        cbAirlines = new JComboBox(airlines);
        cbAirlines.setBounds(160, 230, 60, 25);
        adminPanel.add(cbAirlines);

        //Flight No Input
        tfFlightNo = new JTextField();
        tfFlightNo.setBounds(230, 230, 130, 25);
        adminPanel.add(tfFlightNo);

        // Destination Input
        String destinations[] = {"","DAC", "BOM", "DXB", "LHR", "ZYL", "YYZ", "JFK"};
        cbDest = new JComboBox(destinations);
        cbDest.setBounds(160, 270, 200, 25);
        adminPanel.add(cbDest);

        // Gate Number Input
        String gates[] = {"","1", "2", "3", "4", "5"};
        cbGate = new JComboBox(gates);
        cbGate.setBounds(160, 310, 200, 25);
        adminPanel.add(cbGate);

        // Check-in Input
        String counters[] = {"","A1", "A2", "B1", "B2", "C1", "C2"};
        cbCheckIn = new JComboBox(counters);
        cbCheckIn.setBounds(160, 350, 200, 25);
        adminPanel.add(cbCheckIn);

        // Status Dropdown
        String statuses[] = {"","On Time", "Delayed"};
        cbStatus = new JComboBox(statuses);
        cbStatus.setBounds(160, 390, 200, 25);
        adminPanel.add(cbStatus);

        // Total Passenger Input
        tfTotalPass = new JTextField();
        tfTotalPass.setBounds(220, 510, 140, 25);
        adminPanel.add(tfTotalPass);

        //Save Admin
        adSave = new JButton("Save"); 
        adSave.setBounds(1000, 610, 130, 40);
        adSave.setBackground(Color.GREEN); 
        adSave.setForeground(Color.WHITE); 
        adSave.setFont(welBtnF); 
        adSave.addActionListener(this); 
        adminPanel.add(adSave);

        //Mouse Listener
        l3.addMouseListener(this);
        adFlight.addMouseListener(this);
        adSave.addMouseListener(this);

    }


    public AirportFrame(){

        // departurePanel.setVisible(false);
        // arrivalPanel.setVisible(false);
        // adminPanel.setVisible(false);
        // statslPanel.setVisible(false);

        super("Airport Management System - DAC");
        super.setBounds(120, 75, 1300, 700); //(Screen x pop up ,Screen y Axis Pop up, FrameWidth, FrameWeight)
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);

        f1 = new Font("Tahoma", Font.BOLD, 35);
        f2 = new Font("Cambria", Font.BOLD, 20); //new Font("Cambria", Font.BOLD, 20);
        welBtnF = new Font("Red Hat Display", Font.BOLD, 40);

        
        welcomePanel = new JPanel();
        welcomePanel.setBounds(0, 0, 1300, 700); // there are multiple panel. so, we need to set value due application preferneces 
        welcomePanel.setLayout(null); // i can manage all particle with my choice
        c1 = new Color(25, 42, 86) ; // r , g, b (navy blue)
        welcomePanel.setBackground(c1);

        //Departure Panel all panel will be hide due to welcome panel running on the 1st stage

        departurePanel = new JPanel();
        departurePanel.setBounds(0, 0, 1300, 700);
        departurePanel.setLayout(null);
        c2  =new  Color(44, 62, 80);   // r, g, b (Deep Slate) 
        departurePanel.setBackground(c2);
        //departurePanel.setVisible(false);

        //Arrival Panel 
        arrivalPanel = new JPanel();
        arrivalPanel.setBounds(0, 0, 1300, 700);
        arrivalPanel.setLayout(null);
        c3 = new Color(22, 160, 133);  // r, g, b
        arrivalPanel.setBackground(c3);
        //arrivalPanel.setVisible(false);

        //  Admin Panel 
        adminPanel = new JPanel();
        adminPanel.setBounds(0, 0, 1300, 700);
        adminPanel.setLayout(null);
        c4 = new Color(189, 195, 199); // r, g, b (Light Gray 
        adminPanel.setBackground(c4);
        //adminPanel.setVisible(false);

        //  stats Panel 
        statsPanel = new JPanel();
        statsPanel.setBounds(0, 0, 1300, 700);
        statsPanel.setLayout(null);
        c5 = new  Color(245, 246, 250); // r, g, b
        statsPanel.setBackground(c5);
        //statsPanel.setVisible(false);

        hideAllPanel(); // hideall panel on intial stages

        logo = new ImageIcon("Picture\\logo.png");
        l2 = new JLabel(logo);
        //l2.setOpaque(true);
        l2.setBounds(525,10,300,150);
        welcomePanel.add(l2);


        l1 = new JLabel("<html><u>Welcome To "+ getTitle()+"</html></u>");
        l1.setBounds(225,190,980,45);
        l1.setForeground(Color.YELLOW);
        //l1.setOpaque(true);
        l1.setFont(f1);
        welcomePanel.add(l1);

        clockTimer = new Timer (1000, this ); //delay, actionListener
        clockTimer.start(); //clock timer init


        welTime =  new JLabel ();
        welTime.setBounds(975, 10,300,30);
        welTime.setForeground(Color.RED);
        //welTime.setOpaque(true);
        welTime.setFont(new Font("Monospaced", Font.BOLD, 15));
        welcomePanel.add(welTime);

        //Dep

        depTime = new JLabel();
        depTime.setBounds(975, 10, 300, 30);
        depTime.setForeground((Color.RED));
        depTime.setFont(new Font("Monospaced", Font.BOLD, 15));
        departurePanel.add(depTime);

        //Arrival Panel Time
        arrTime = new JLabel();
        arrTime.setBounds(975, 10, 300, 30);
        arrTime.setForeground(Color.RED);
        arrTime.setFont(new Font("Monospaced", Font.BOLD, 15));
        arrivalPanel.add(arrTime);

        //Admin Panel Time
        adminTime = new JLabel();
        adminTime.setBounds(975, 10, 300, 30);
        adminTime.setForeground(Color.RED);
        adminTime.setFont(new Font("Monospaced", Font.BOLD, 15));
        adminPanel.add(adminTime);

        //Stats Panel Time
        statsTime = new JLabel();
        statsTime.setBounds(975, 10, 300, 30);
        statsTime.setForeground(Color.RED);
        statsTime.setFont(new Font("Monospaced", Font.BOLD, 15));
        statsPanel.add(statsTime);

        //departureButton, arrivalButton, adminButton, statsButton

        departureButton = new JButton("Departure");
        departureButton.setBounds(100,270, 300,100);
        //departureButton.setOpaque(true);
        departureButton.setBackground(new Color(25, 118, 210));
        departureButton.setForeground(Color.RED);
        departureButton.setFont(welBtnF);
        departureButton.addActionListener(this);
        welcomePanel.add(departureButton);

        arrivalButton = new JButton("Arrival");
        arrivalButton.setBounds(500,270, 300,100);
        //arrivalButton.setOpaque(true);
        arrivalButton.setBackground(new Color(39, 174, 96));
        arrivalButton.setForeground(Color.RED);
        arrivalButton.setFont(welBtnF);
        arrivalButton.addActionListener(this);
        welcomePanel.add(arrivalButton);

        adminButton = new JButton("Admin");
        adminButton.setBounds(900,270, 300,100);
        //adminButton.setOpaque(true);
        adminButton.setBackground(new Color(69, 90, 100));
        adminButton.setForeground(Color.RED);
        adminButton.setFont(welBtnF);
        adminButton.addActionListener(this);
        welcomePanel.add(adminButton);

        statsButton = new JButton("Statistics");
        statsButton.setBounds(500,420, 300,100);
        //statsButton.setOpaque(true);
        statsButton.setBackground(new Color(38, 38, 38));
        statsButton.setForeground(Color.RED);
        statsButton.setFont(welBtnF);
        statsButton.addActionListener(this);
        welcomePanel.add(statsButton);


        //Exit Button
        ExitBtn1 = new JButton("Exit");
        ExitBtn1.setBounds(580, 610, 130, 40);
        //welcomeExitBtn.setOpaque(true);
        ExitBtn1.setBackground(Color.RED);
        ExitBtn1.setForeground(Color.WHITE);
        ExitBtn1.setFont(welBtnF);
        ExitBtn1.addActionListener(this);
        welcomePanel.add(ExitBtn1);

       

        ExitBtn2 = new JButton("Exit"); 
        ExitBtn2.setBounds(580, 610, 130, 40);
        ExitBtn2.setBackground(Color.RED); 
        ExitBtn2.setForeground(Color.WHITE); 
        ExitBtn2.setFont(welBtnF); 
        ExitBtn2.addActionListener(this); 
        departurePanel.add(ExitBtn2);

        ExitBtn3 = new JButton("Exit"); 
        ExitBtn3.setBounds(580, 610, 130, 40);
        ExitBtn3.setBackground(Color.RED); 
        ExitBtn3.setForeground(Color.WHITE); 
        ExitBtn3.setFont(welBtnF); 
        ExitBtn3.addActionListener(this); 
        arrivalPanel.add(ExitBtn3);

        ExitBtn4 = new JButton("Exit"); 
        ExitBtn4.setBounds(580, 610, 130, 40);
        ExitBtn4.setBackground(Color.RED); 
        ExitBtn4.setForeground(Color.WHITE); 
        ExitBtn4.setFont(welBtnF); 
        ExitBtn4.addActionListener(this); 
        adminPanel.add(ExitBtn4);

        ExitBtn5 = new JButton("Exit"); 
        ExitBtn5.setBounds(580, 610, 130, 40);
        ExitBtn5.setBackground(Color.RED); 
        ExitBtn5.setForeground(Color.WHITE); 
        ExitBtn5.setFont(welBtnF); 
        ExitBtn5.addActionListener(this); 
        statsPanel.add(ExitBtn5);

        //BACK BUTTON
        backBtn1 = new JButton("Back To Portal");
        backBtn1.setBounds(60, 610, 350, 40);
        backBtn1.setBackground(new Color(52, 73, 94)); 
        backBtn1.setForeground(Color.GREEN);
        backBtn1.setFont( welBtnF); // new Font("Red Hat Display", Font.BOLD, 40)
        backBtn1.addActionListener(this);
        departurePanel.add(backBtn1); 
        
        backBtn2 = new JButton("Back To Portal");
        backBtn2.setBounds(60, 610, 350, 40);
        backBtn2.setBackground(new Color(52, 73, 94)); 
        backBtn2.setForeground(Color.GREEN);
        backBtn2.setFont(welBtnF);
        backBtn2.addActionListener(this);
        arrivalPanel.add(backBtn2); 

        backBtn3 = new JButton("Back To Portal");
        backBtn3.setBounds(60, 610, 350, 40);
        backBtn3.setBackground(new Color(52, 73, 94)); 
        backBtn3.setForeground(Color.GREEN);
        backBtn3.setFont(welBtnF);
        backBtn3.addActionListener(this);
        adminPanel.add(backBtn3); 

        backBtn4 = new JButton("Back To Portal");
        backBtn4.setBounds(60, 610, 350, 40);
        backBtn4.setBackground(new Color(52, 73, 94)); 
        backBtn4.setForeground(Color.GREEN);
        backBtn4.setFont(welBtnF);
        backBtn4.addActionListener(this);
        statsPanel.add(backBtn4); 

        

        AdminPanel();
        StatsPanel();


// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        welcomePanel.setVisible(true);
        super.add(welcomePanel);

        
        super.add(departurePanel);
        super.add(arrivalPanel);
        super.add(adminPanel);
        super.add(statsPanel);

    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == showPass) {
            if (showPass.isSelected()) {
                pfPass.setEchoChar((char) 0); 
            } 
        else {
            pfPass.setEchoChar('*'); 
        }
    }
        if(ae.getSource() == ExitBtn1 || ae.getSource() == ExitBtn2 || ae.getSource() == ExitBtn3 || ae.getSource() == ExitBtn4 || ae.getSource() == ExitBtn5){
            System.exit(0);
        }
        else if (ae.getSource()==clockTimer){
            String format = LocalDateTime.now().getDayOfMonth()+" "+LocalDateTime.now().getMonth()+", "+LocalDateTime.now().getYear()+"  "+ LocalDateTime.now().getDayOfWeek() + " "+LocalDateTime.now().getHour()+":"+LocalDateTime.now().getMinute()+":"+LocalDateTime.now().getSecond();
            welTime.setText(format);
            depTime.setText(format);
            arrTime.setText(format);
            adminTime.setText(format);
            statsTime.setText(format);
        }
        else if (ae.getSource()==departureButton){
            //welcomePanel.setVisible(false);
            hideAllPanel();  
            showInfo("Departure");
            departurePanel.setVisible(true);
        }
        else if (ae.getSource()==arrivalButton){
            //welcomePanel.setVisible(false);
            showInfo("Arrival");
            hideAllPanel();  
            arrivalPanel.setVisible(true);
        }
        else if (ae.getSource()==adminButton){
            //welcomePanel.setVisible(false);
            hideAllPanel();  
            adminPanel.setVisible(true);
        }
        else if (ae.getSource()==statsButton){
            //welcomePanel.setVisible(false);
            hideAllPanel();  

            lTotalDep.setText("Total Departures: " + dpCount);
            lTotalArr.setText("Total Arrivals: " + arCount);
            lTotalPassCount.setText("Total Passengers (Immigration): " + passengerCount);

            statsPanel.setVisible(true);
        }
        else if (ae.getSource() == backBtn1 || ae.getSource() == backBtn2 || ae.getSource() == backBtn3 || ae.getSource() == backBtn4) {
            hideAllPanel();            
            welcomePanel.setVisible(true); 
        }

        else if (ae.getSource()==adSave){
            String s1, s2, s3, s4, s5, s6, s7, s8, s9;
            int flightPassenger;
            try{
                flightPassenger = Integer.parseInt(tfTotalPass.getText());
            }
            catch (NumberFormatException e){
                JOptionPane.showMessageDialog(this, "Please enter valid integer number for Immigration data");
                flightPassenger = -1; 
            }
            
            //passengerCount = passengerCount + flightPassenger;

            s1= tfJobID.getText();
            s2 = pfPass.getText();

            s4 = tfTime.getText();
            s5 = cbAirlines.getSelectedItem().toString()+" "+ tfFlightNo.getText();
            s6 = cbDest.getSelectedItem().toString();
            s7 = cbGate.getSelectedItem().toString();
            s8 = cbCheckIn.getSelectedItem().toString();
            s9 = cbStatus.getSelectedItem().toString();

            if(rbDeparture.isSelected()){
                s3 = rbDeparture.getText();
            }
            else if(rbArrival.isSelected()){
                s3 = rbArrival.getText();
            }
            else{
                s3 = "";
            }
            // System.out.println(s1);
            // System.out.println(s2);

            if (s1.isEmpty() || s2.isEmpty() || s3.isEmpty() || s4.isEmpty() || s5.isEmpty() || s6.isEmpty() || s7.isEmpty() || s8.isEmpty() || s9.isEmpty() || flightPassenger==-1 ){
                JOptionPane.showMessageDialog(this, "Please fill up all the information");
            }
            else if((s1.equals("25-62997-2") && s2.equals("prosenjitdatta")) || (s1.equals("25-62146-2") && s2.equals("tahmidalam")) || (s1.equals("2209-2173-2") && s2.equals("nymeahmed" ))){
                if(rbDeparture.isSelected()){
                    dpCount++;
                }

                else if(rbArrival.isSelected()){
                    arCount++;
                }
                passengerCount = passengerCount + flightPassenger;

                //Init your Code for FILE IO and Show Method
                Airport obj1 = new Airport(s1, s3, s4, s5, s6 , s7,s8,s9, flightPassenger);
                obj1.insertFlightInfo();

                JOptionPane.showMessageDialog(this,"Thanks for fill up the information");
                showInfo("Departure");
                showInfo("Arrival");

            }

            else{
                JOptionPane.showMessageDialog(this, "Are you intruder? \nIf not, please check your credentials");
            }

        }
        
    }
    
    public void mouseClicked(MouseEvent me) 
	{
		if(me.getSource() == l3)
		{
			l3.setText("Admin Panel");
		}
	}
	public void mousePressed(MouseEvent me)
	{
		if(me.getSource() == adFlight)
		{
			adFlight.setText("(Ex. BG 135)");
		}
	}
	public void mouseReleased(MouseEvent me)
	{
		if(me.getSource() == adFlight)
		{
			adFlight.setText("Flight No: ");
		}
	}
	public void mouseEntered(MouseEvent me)
	{
		if(me.getSource() == adSave)
		{
			adSave.setBackground(Color.BLUE);
			adSave.setForeground(Color.WHITE);
		}
	}
	public void mouseExited(MouseEvent me)
	{
		if(me.getSource() == adSave)
		{
			adSave.setBackground(Color.GREEN);
			adSave.setForeground(Color.WHITE);
		}
	}

    public void hideAllPanel(){
        welcomePanel.setVisible(false);
        departurePanel.setVisible(false);
        arrivalPanel.setVisible(false);
        statsPanel.setVisible(false);
        adminPanel.setVisible(false);
    }

    public void showInfo(String typeFilter) {
        try {
            
            String fileName = typeFilter.equalsIgnoreCase("Arrival") ? "./Data/Arrival.txt" : "./Data/Departure.txt";
            File file = new File(fileName);
            
            JTextArea targetArea = typeFilter.equalsIgnoreCase("Arrival") ? taArr : taDep;
            targetArea.setText(""); 

            if (!file.exists()) return;

            String line;
            int separatorCount = 0;

            // ---------- PASS 1 : COUNT RECORDS & UPDATE TEXT AREA ----------
            BufferedReader countReader = new BufferedReader(new FileReader(file));
            while ((line = countReader.readLine()) != null) {
                targetArea.append(line + "\n"); 
                if (line.startsWith("========================================")) {
                    separatorCount++;
                }
            }
            countReader.close();
            
            
            int rowCount = separatorCount / 2; 

            Object[][] data = new Object[rowCount][5];
            String[] columnNames = {"Flight No", "Destination", "Time", "Gate", "Status"};

            // ---------- PASS 2 : LOAD DATA FOR TABLE ----------
            BufferedReader dataReader = new BufferedReader(new FileReader(file));
            int currentRow = 0;
            String fNo = "", fTime = "", fDest = "", fGate = "", fStatus = "";

            while ((line = dataReader.readLine()) != null) {
                if (line.contains("Scheduled Time")) fTime = line.split(":")[1].trim();
                else if (line.contains("Flight Number")) fNo = line.split(":")[1].trim();
                else if (line.contains("Destination")) fDest = line.split(":")[1].trim();
                else if (line.contains("Gate")) fGate = line.split(":")[1].trim();
                else if (line.contains("Current Status")) fStatus = line.split(":")[1].trim();
                
                else if (line.startsWith("========================================") && !fNo.equals("")) {
                    if (currentRow < rowCount) {
                        data[currentRow][0] = fNo;
                        data[currentRow][1] = fDest;
                        data[currentRow][2] = fTime;
                        data[currentRow][3] = fGate;
                        data[currentRow][4] = fStatus;
                        currentRow++;
                        
                        fNo = ""; fTime = ""; fDest = ""; fGate = ""; fStatus = "";
                    }
                }
            }
            dataReader.close();

            JTable table = new JTable(data, columnNames);
            table.setRowHeight(28);
            table.setEnabled(false); 

            JPanel targetPanel = typeFilter.equalsIgnoreCase("Arrival") ? arrivalPanel : departurePanel;
            renderTableOnPanel(targetPanel, table, typeFilter);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to load flight data.");
        }
    }

    public void renderTableOnPanel(JPanel panel, JTable table, String type) {
        panel.removeAll(); 

        if(type.equalsIgnoreCase("Arrival")) {
            panel.add(backBtn2); 
            panel.add(ExitBtn3); 
            panel.add(arrTime);
        } else {
            panel.add(backBtn1); 
            panel.add(ExitBtn2); 
            panel.add(depTime);
        }

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(50, 80, 1200, 450);
        panel.add(sp);

        panel.revalidate();
        panel.repaint();
    }

}
