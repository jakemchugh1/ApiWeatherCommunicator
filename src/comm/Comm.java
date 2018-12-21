package comm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;


public class Comm{

    private static String urlLink = "";
    private static Scanner input;
    private static String city = "";
    private static String[] weatherData;

    public Comm(String inputCity)
            throws IOException{
        weatherData = new String[28];
        city = inputCity;
        urlLink = "https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=d07e9d02bba6e034e06a15cd0c50a7f4";
        System.out.println(urlLink);
        URL url = new URL(urlLink);
        HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
        BufferedReader in = new BufferedReader( new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null){
            response.append(inputLine);
        }
        in.close();
        weatherDataStorage(response.toString());
    }

    private static void weatherDataStorage(String data){
        int dataIndex = 0;
        for(int i = 0; i < data.length(); i++){
            if(data.charAt(i) == '{' );
            else if(data.charAt(i) == '}' );
            else if(data.charAt(i) == ',') {
                System.out.println();
                dataIndex++;
            }
            else{
                System.out.print(data.charAt(i));
                weatherData[dataIndex] = weatherData[dataIndex] + data.charAt(i);
            }

        }System.out.println();
    }
    private static void cleaner(){
        int dataLength;

    }
    public String[] accessData(){
        return weatherData;
    }
}
