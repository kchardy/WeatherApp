package WeatherApp.GUI;

import WeatherApp.Application;
import WeatherApp.Json.Json;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.SortedSet;
import java.util.TreeSet;

import static WeatherApp.Json.Json.getIcon;
import static WeatherApp.Json.Json.mapCityId;


public class Board extends JPanel implements ActionListener {

    private Image bgImage = Toolkit.getDefaultToolkit().createImage("res/background2.jpg");

    private String degree = "\u00b0";
    private String pathMainLabel = "res/"+ Json.icon +".png";
    private String choosenCity;

    private JLabel lDescription;
    private JLabel lWind;
    private JLabel lHum;
    private JLabel lPre;
    private JLabel lTodayDate;
    private JLabel lTemp;
    private JLabel lCity;
    private JLabel mainLabel;
    private JLabel icon2;
    private JLabel icon3;
    private JLabel icon4;
    private JLabel icon5;
    private JLabel icon6;
    private JLabel date2;
    private JLabel date3;
    private JLabel date4;
    private JLabel date5;
    private JLabel date6;
    private JLabel temp2;
    private JLabel temp3;
    private JLabel temp4;
    private JLabel temp5;
    private JLabel temp6;

    private JButton bSave;
    private JButton bExit;
    private JButton bGet;

    public static JComboBox listOfCities;

    public Board(){
        setLayout(null);
        setPreferredSize(new Dimension(700, 500));

        lDescription = new JLabel();
        lDescription.setForeground(Color.WHITE);
        lDescription.setBounds(90,100,200,30);
        lDescription.setText(Json.description.toUpperCase());
        add(lDescription);
        lDescription.setFont(new Font("Georgia", Font.PLAIN,20));

        lWind = new JLabel();
        lWind.setForeground(Color.WHITE);
        lWind.setBounds(50,350,150,30);
        lWind.setText("Wind: "+Json.wind);
        add(lWind);
        lWind.setFont(new Font("Georgia", Font.PLAIN,15));

        lHum = new JLabel();
        lHum.setForeground(Color.WHITE);
        lHum.setBounds(180,350,150,30);
        lHum.setText("Humidity: "+Json.humidity);
        add(lHum);
        lHum.setFont(new Font("Georgia", Font.PLAIN,15));

        lPre = new JLabel();
        lPre.setForeground(Color.WHITE);
        lPre.setBounds(100,400,150,30);
        lPre.setText("Pressure: "+Json.pressure);
        add(lPre);
        lPre.setFont(new Font("Georgia", Font.PLAIN,15));

        lTemp = new JLabel();
        lTemp.setForeground(Color.WHITE);
        lTemp.setBounds(100,300,150,30);
        lTemp.setText(Json.temperature+degree+"C");
        add(lTemp);
        lTemp.setFont(new Font("Georgia", Font.BOLD,20));

        lCity = new JLabel();
        lCity.setForeground(Color.WHITE);
        lCity.setBounds(280, 50, 150, 30);
        lCity.setText(Json.CityName);
        add(lCity);
        lCity.setFont(new Font("Georgia", Font.PLAIN, 20));

        lTodayDate = new JLabel();
        lTodayDate.setForeground(Color.WHITE);
        lTodayDate.setBounds(10,5,150,20);
        lTodayDate.setText(String.valueOf(new Date()));
        add(lTodayDate);
        lTodayDate.setFont(new Font("Georgia", Font.ITALIC,10));

        bSave = new JButton("SAVE");
        bSave.setBounds(600,440,80, 20);
        bSave.addActionListener(this);
        bSave.setForeground(Color.WHITE);
        bSave.setBackground(new Color(0,100,200));
        add(bSave);

        SortedSet<String> keys = new TreeSet<>(mapCityId.keySet());
        String[] petStrings = keys.toArray(new String[0]);

        listOfCities = new JComboBox(petStrings);
        listOfCities.setBounds(300,10,120, 20);
        listOfCities.setBackground(new Color(100,150,200));
        listOfCities.setForeground(Color.WHITE);
        add(listOfCities);
        listOfCities.addActionListener(this);
        listOfCities.setEditable(true);
        AutoCompleteDecorator.decorate(listOfCities);

        bGet = new JButton("Get weather");
        bGet.setBounds(400,10,150, 20);
        bGet.addActionListener(this);
        bGet.setForeground(Color.WHITE);
        bGet.setBackground(new Color(0,100,200));
        add(bGet);

        bExit = new JButton(new ImageIcon("res/exit.jpg"));
        bExit.setBounds(650,10,40, 20);
        bExit.addActionListener(this);
        add(bExit);

        mainLabel = new JLabel((new ImageIcon(pathMainLabel)));
        mainLabel.setBounds(80,150, 150, 150);
        mainLabel.setIcon(new ImageIcon(new ImageIcon(pathMainLabel).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));
        add(mainLabel);

        icon2 = new JLabel((new ImageIcon("res/"+getIcon+".png")));
        icon2.setBounds(350,150, 50, 50);
        add(icon2);

        date2 = new JLabel();
        date2.setText(Json.getDate);
        date2.setForeground(Color.WHITE);
        date2.setBounds(320, 130,100,20);
        date2.setFont(new Font("Georgia", Font.PLAIN, 10));
        add(date2);

        temp2 = new JLabel();
        temp2.setText(Json.getTemp+degree+"C");
        temp2.setForeground(Color.WHITE);
        temp2.setBounds(360, 200,100,20);
        temp2.setFont(new Font("Georgia", Font.PLAIN, 16));
        add(temp2);

        icon3 = new JLabel((new ImageIcon("res/"+ Json.getIcon2 +".png")));
        icon3.setBounds(480,150, 50, 50);
        add(icon3);

        date3 = new JLabel();
        date3.setText(Json.getDate2);
        date3.setForeground(Color.WHITE);
        date3.setBounds(450, 130,100,20);
        date3.setFont(new Font("Georgia", Font.PLAIN, 10));
        add(date3);

        temp3 = new JLabel();
        temp3.setText(Json.getTemp2+degree+"C");
        temp3.setForeground(Color.WHITE);
        temp3.setBounds(490, 200,100,20);
        temp3.setFont(new Font("Georgia", Font.PLAIN, 16));
        add(temp3);

        icon4 = new JLabel((new ImageIcon("res/"+ Json.getIcon3 +".png")));
        icon4.setBounds(600,150, 50, 50);
        add(icon4);

        date4 = new JLabel();
        date4.setText(Json.getDate3);
        date4.setForeground(Color.WHITE);
        date4.setBounds(580, 130,100,20);
        date4.setFont(new Font("Georgia", Font.PLAIN, 10));
        add(date4);

        temp4 = new JLabel();
        temp4.setText(Json.getTemp3+degree+"C");
        temp4.setForeground(Color.WHITE);
        temp4.setBounds(610, 200,100,20);
        temp4.setFont(new Font("Georgia", Font.PLAIN, 16));
        add(temp4);

        icon5 = new JLabel((new ImageIcon("res/"+ Json.getIcon4 +".png")));
        icon5.setBounds(350,300, 50, 50);
        add(icon5);

        date5 = new JLabel();
        date5.setText(Json.getDate4);
        date5.setForeground(Color.WHITE);
        date5.setBounds(320, 280,100,20);
        date5.setFont(new Font("Georgia", Font.PLAIN, 10));
        add(date5);

        temp5 = new JLabel();
        temp5.setText(Json.getTemp4+degree+"C");
        temp5.setForeground(Color.WHITE);
        temp5.setBounds(360, 350,100,20);
        temp5.setFont(new Font("Georgia", Font.PLAIN, 16));
        add(temp5);

        icon6 = new JLabel((new ImageIcon("res/"+ Json.getIcon5 +".png")));
        icon6.setBounds(500,300, 50, 50);
        add(icon6);

        date6 = new JLabel();
        date6.setText(Json.getDate5);
        date6.setForeground(Color.WHITE);
        date6.setBounds(480, 280,100,20);
        date6.setFont(new Font("Georgia", Font.PLAIN, 10));
        add(date6);

        temp6 = new JLabel();
        temp6.setText(Json.getTemp5+degree+"C");
        temp6.setForeground(Color.WHITE);
        temp6.setBounds(510, 350,100,20);
        temp6.setFont(new Font("Georgia", Font.PLAIN, 16));
        add(temp6);


    }
    public void reloadFields(){

        lDescription.setText(Json.description.toUpperCase());
        lWind.setText("Wind: "+Json.wind);
        lHum.setText("Humidity: "+Json.humidity);
        lPre.setText("Pressure: "+Json.pressure);
        lTemp.setText(Json.temperature + degree+"C");
        lCity.setText(Json.CityName);
        lTodayDate.setText(String.valueOf(new Date()));

        ImageIcon icon = new ImageIcon("res/"+ Json.icon +".png");
        icon.getImage().flush();
        mainLabel.setIcon( icon );
        mainLabel.setIcon(new ImageIcon(new ImageIcon
                ("res/"+ Json.icon +".png").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));

        date2.setText(Json.getDate);
        date3.setText(Json.getDate2);
        date4.setText(Json.getDate3);
        date5.setText(Json.getDate4);
        date6.setText(Json.getDate5);

        temp2.setText(Json.getTemp+degree+"C");
        temp3.setText(Json.getTemp2+degree+"C");
        temp4.setText(Json.getTemp3+degree+"C");
        temp5.setText(Json.getTemp4+degree+"C");
        temp6.setText(Json.getTemp5+degree+"C");

        ImageIcon i2 = new ImageIcon("res/"+ Json.getIcon +".png");
        i2.getImage().flush();
        icon2.setIcon( i2);

        ImageIcon i3 = new ImageIcon("res/"+ Json.getIcon2 +".png");
        i3.getImage().flush();
        icon3.setIcon( i3 );

        ImageIcon i4 = new ImageIcon("res/"+ Json.getIcon3+".png");
        i4.getImage().flush();
        icon4.setIcon( i4 );

        ImageIcon i5 = new ImageIcon("res/"+ Json.getIcon4 +".png");
        i5.getImage().flush();
        icon5.setIcon( i5 );

        ImageIcon i6 = new ImageIcon("res/"+ Json.getIcon5 +".png");
        i6.getImage().flush();
        icon6.setIcon( i6 );
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.drawImage(bgImage, 0, 0, null);

        g.setColor(Color.WHITE);
        //g.drawLine(300,100,300,400);

        g.drawImage(bgImage, 0, 0, this);
        g.drawLine(300,100,300,400);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object src = e.getSource();

        if(src == bSave)
            new SaveWindow().setVisible(true);
        else if(src == bExit){
            System.exit(0);
        }
        else if(src == listOfCities)
        {
            JComboBox cb = (JComboBox)e.getSource();
            choosenCity = (String)cb.getSelectedItem();
        }
        else if(src == bGet)
        {
            System.out.println(mapCityId.get(choosenCity));

            Application.path = "http://api.openweathermap.org/data/2.5/weather?id=" + mapCityId.get(choosenCity) + "&units=metric&APPID=c462c76ba9d12b71cee3513112f4f5c7";
            Application.pathForecast = "http://api.openweathermap.org/data/2.5/forecast?id=" + mapCityId.get(choosenCity) + "&units=metric&APPID=c462c76ba9d12b71cee3513112f4f5c7";
            Json json = new Json();
            reloadFields();
        }
    }
}
