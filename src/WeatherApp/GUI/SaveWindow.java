package WeatherApp.GUI;

import WeatherApp.Json.Json;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SaveWindow extends JFrame implements ActionListener {

    JButton cancel;
    JButton btxt;

    public SaveWindow()
    {
        init();
    }

    public void init()
    {
        setLayout(null);
        setSize(200, 200);
        setLocation(500, 300);

        setBackground(new Color(50,150,200));

        setTitle("Save As");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        UI();
    }
    public void UI()
    {
        btxt = new JButton("TXT");
        btxt.setBounds(10,10,80,20);
        add(btxt);
        btxt.addActionListener(this);


        cancel = new JButton("Cancel");
        cancel.setBounds(100,130,80,20);
        add(cancel);
        cancel.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if(src == btxt)
            try {
                saveTxt();
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        else if(src == cancel){
            System.out.println("Exit");
            System.exit(0);
        }
    }

    public void saveTxt() throws FileNotFoundException {
        PrintWriter  record = new PrintWriter("name.txt");
        record.println(Json.date+", " + Json.CityName + "\n"+
                        "Temperature: " + Json.temperature+"\n"+
                        "Wind: " + Json.wind + "\n" +
                        "Description: " + Json.description);
        record.close();
    }
}
