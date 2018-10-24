package WeatherApp.Json;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import WeatherApp.Application;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import static WeatherApp.Application.pathForecast;

public class Json {
    public static Map<String, String> mapCityId;

    private String output;
    private StringBuffer sb;

    public static String wind;
    public static String temperature;
    public static String CityName;
    public static String mainWeather;
    public static String icon;
    public static String forecastIcon;
    public static String description;
    public static String date;
    public static String getDate;
    public static String getTemp;
    public static String getIcon;
    public static String getDate2;
    public static String getTemp2;
    public static String getIcon2;
    public static String getDate3;
    public static String getTemp3;
    public static String getIcon3;
    public static String getDate4;
    public static String getTemp4;
    public static String getIcon4;
    public static String getDate5;
    public static String getTemp5;
    public static String getIcon5;
    public static String humidity;
    public static String pressure;

    public Json() {
        getJson();
        try {
            parse();

        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            forecast();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            citylist();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void getJson()
    {

        try {

            URL url = new URL(Application.path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            sb = new StringBuffer();
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                sb.append(output);
            }
            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parse() throws ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(sb.toString());
        JSONArray msg = (JSONArray) jsonObject.get("weather");
        CityName = (String) jsonObject.get("name");

        JSONObject obj2 = (JSONObject) msg.get(0);
        description = (String) obj2.get("description");
        icon = (String) obj2.get("icon");

        JSONObject mainObj = (JSONObject) jsonObject.get("main");
        temperature = mainObj.get("temp").toString();
        humidity = mainObj.get("humidity").toString();
        pressure = mainObj.get("pressure").toString();

        JSONObject windObj = (JSONObject) jsonObject.get("wind");
        wind = windObj.get("speed").toString();
    }

    private static void citylist() throws IOException, ParseException {

        mapCityId = new HashMap<>();

        final String filePath = "res/city.list.json";

        FileReader reader = new FileReader(filePath);
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(reader);

        for (Object obj : jsonArray) {
            JSONObject jsonLineItem = (JSONObject) obj;
            String cityName = (String) jsonLineItem.get("name");
            String cityId = jsonLineItem.get("id").toString();

            mapCityId.put(cityName.toString(),cityId.toString());
        }
    }

    private static void forecast() throws IOException, ParseException {

        URL url = null;
        try {
            url = new URL(pathForecast);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            conn.setRequestMethod("GET");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
        conn.setRequestProperty("Accept","application/json");

        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

        String output = "";
        StringBuilder sb = new StringBuilder();
        System.out.println("Forecast .... \n");
        while ((output = br.readLine()) != null) {
            sb.append(output);
        }

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(sb.toString());
        JSONArray list = (JSONArray) jsonObject.get("list");
        JSONObject obj2 = (JSONObject) list.get(0);

        int i = 1;
        boolean read = false;
        for (Object o : list) {
            JSONObject jsonLineItem = (JSONObject) o;
            String key = (String) jsonLineItem.get("dt_txt");
            if(!read){
                date = key;
                read = true;
            }
            JSONObject mainObj = (JSONObject) jsonLineItem.get("main");
            String temp = mainObj.get("temp").toString();
            JSONArray weatherArray = (JSONArray) jsonLineItem.get("weather");

            JSONObject weatherObj = (JSONObject) weatherArray.get(0);
            String description = (String) weatherObj.get("description");
            forecastIcon = (String) weatherObj.get("icon");

            if(i == 5)
            {
                getIcon = (String) weatherObj.get("icon");
                getTemp = mainObj.get("temp").toString();
                getDate = (String) jsonLineItem.get("dt_txt");
            }

            else if(i == 13)
            {
                getIcon2 = (String) weatherObj.get("icon");
                getTemp2 = mainObj.get("temp").toString();
                getDate2 = (String) jsonLineItem.get("dt_txt");
            }
            else if(i == 21)
            {
                getIcon3 = (String) weatherObj.get("icon");
                getTemp3 = mainObj.get("temp").toString();
                getDate3 = (String) jsonLineItem.get("dt_txt");
            }
            else if(i == 29)
            {
                getIcon4 = (String) weatherObj.get("icon");
                getTemp4 = mainObj.get("temp").toString();
                getDate4 = (String) jsonLineItem.get("dt_txt");
            }
            else if(i == 37)
            {
                getIcon5 = (String) weatherObj.get("icon");
                getTemp5 = mainObj.get("temp").toString();
                getDate5 = (String) jsonLineItem.get("dt_txt");
            }
            i++;
        }
    }
}
