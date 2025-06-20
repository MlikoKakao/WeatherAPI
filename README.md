# WeatherAPI

A Java console application that fetches and displays current weather conditions for any city using the Open-Meteo API. It uses geolocation to convert city names into coordinates and then retrieves current weather data including temperature, humidity, wind speed, and rainfall.

## 🌍 Features

- Get real-time weather info:
  - 🌡️ Temperature
  - 💧 Relative humidity
  - 🌬️ Wind speed
  - 🌧️ Rain
- Auto-geolocation by city name
- Runs in terminal/console with repeated input support

## 🔧 Technologies Used

- Java (JDK 8+)
- [Open-Meteo API](https://open-meteo.com/)
- `org.json.simple` for JSON parsing
- Java standard networking and I/O

## 📦 Project Structure

- `Main.java` – Entry point; handles user input and interaction
- `WeatherAPIData.java` – Contains all logic for API calls and weather data parsing

## 🚀 How to Run

### 1. Clone the Repository

```bash
git clone https://github.com/MlikoKakao/WeatherAPI.git
cd WeatherAPI
