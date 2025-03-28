import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Main {
    public static void main(String [] args){
        try {
            Scanner scanner = new Scanner(System.in);
            String city;
            do {
                System.out.println("=============================");
                System.out.println("Enter city(Write No to quit): ");
                city = scanner.nextLine();

                if (city.equalsIgnoreCase("No")) break;

                JSONObject cityLocationData = getLocationData(city);
                double latitude = (double) cityLocationData.get("latitude");
                double longitude = (double) cityLocationData.get("longitude");

                displayWeatherData(latitude, longitude);
            } while (!city.equalsIgnoreCase("No"));
        } catch (Exception e) {
            e.printStackTrace();
        }
            }
        }


