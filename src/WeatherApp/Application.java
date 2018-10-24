package WeatherApp;

import WeatherApp.GUI.Board;
import WeatherApp.Json.Json;
import javax.swing.*;
import java.awt.*;

public class Application extends JFrame
{
    public static String path = "http://api.openweathermap.org/data/2.5/weather?q=lodz,pl&units=metric&APPID=a2867cfb9fa289221ab1aa57675f4e38";
    public static String pathForecast = "http://api.openweathermap.org/data/2.5/forecast?q=lodz,pl&units=metric&APPID=a2867cfb9fa289221ab1aa57675f4e38";

    public static int WIDTH = 700;
    public static int HEIGHT = 480;

    public Application() {

        initUI();
    }

    private void initUI() {

        add(new Board());
        pack();
        setSize(WIDTH, HEIGHT);
        setTitle("Weather Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        dispose();
        setUndecorated(true);
        setVisible(true);
    }
    public static void main(String[] args) {
        Json json = new Json();

        EventQueue.invokeLater(() -> {
            Application ex = new Application();
            ex.setVisible(true);
        });
    }
}
