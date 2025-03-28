import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherAPIData {
    private static JSONObject getLocationData(String city){
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
        }
    }
}
