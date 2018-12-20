package comm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;


public class Comm {

    private static String urlLink = "";
    private static Scanner input;
    private static String city = "";

    public Comm()
            throws IOException{
        input = new Scanner(System.in);
        System.out.println("Enter the city you would like to check the weather for");
        city = input.next();
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
        weatherDataPrinter(response.toString());
    }

    public static void weatherDataPrinter(String data){
        int dataLength = data.length();
        for(int i = 0; i < data.length(); i++){
            if(data.charAt(i) == '{' );
            else if(data.charAt(i) == '}' );
            else if(data.charAt(i) == ','){
                System.out.print(data.charAt(i));
                System.out.println();
            }
            else{
                System.out.print(data.charAt(i));
            }

        }System.out.println();
    }
}
