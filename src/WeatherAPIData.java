import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class WeatherAPIData {
    public static JSONObject getLocationData(String city){
        city = city.replaceAll(" ", "+");
        String urlString = "https://geocoding-api.open-meteo.com/v1/search?name=" +
                city + "&count=1&language=en&format=json";
        try{
            HttpURLConnection apiConnection = fetchApiResponse(urlString);

            if(apiConnection.getResponseCode()!= 200){
                System.out.println("Error: Could not connect to API");
                return null;
            }
            String jsonResponse = readApiResponse(apiConnection);

            JSONParser parser = new JSONParser();
            JSONObject resultsJsonObj = (JSONObject) parser.parse(jsonResponse);

            JSONArray locationData = (JSONArray) resultsJsonObj.get("results");
            return (JSONObject) locationData.get(0);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static HttpURLConnection fetchApiResponse(String urlString){
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            return conn;
        } catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
    public static String readApiResponse(HttpURLConnection apiConnection){
        try{
            StringBuilder resultJson = new StringBuilder();

            Scanner scanner = new Scanner(apiConnection.getInputStream());

            while(scanner.hasNext()) {
                resultJson.append(scanner.nextLine());
            }
            scanner.close();

            return resultJson.toString();
        } catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
    public static void displayWeatherData(double latitude, double longitude){
        try{
            String url = "https://api.open-meteo.com/v1/forecast?latitude=" + latitude +"&longitude="+
                    longitude+
                    "&current=temperature_2m,relative_humidity_2m,weather_code";
            HttpURLConnection apiConnection = fetchApiResponse(url);
            if(apiConnection.getResponseCode()!=200){
                System.out.println("Error: Could not reach API");
                return;
            }
            String jsonResponse = readApiResponse(apiConnection);

            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(jsonResponse);
            JSONObject currentWeatherJson = (JSONObject) jsonObject.get("current");

            String time = (String) currentWeatherJson.get("time");
            System.out.println("Current time: "+ time);

            double temperature = (double) currentWeatherJson.get("temperature_2m");
            System.out.println("Current temperature(C): "+temperature);

            long relativeHumidity = (long) currentWeatherJson.get("relative_humidity_2m");
            System.out.println("Relative humidity: "+relativeHumidity);

            long weatherCode = (long) currentWeatherJson.get("weather_code");
            System.out.println("Weather code: "+weatherCode);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }






}
