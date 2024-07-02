# Weather-App
An application that fetches and displays weather information for a given location using an API.
# Weather App

## Description

An application that fetches and displays weather information for a given location using the OpenWeatherMap API.

## How to Run

1. **Replace API Key**:
    Replace `"your_api_key_here"` in `WeatherPanel.java` with your OpenWeatherMap API key.

2. **Compile the Java files**:
    ```
    javac src/WeatherApp.java src/WeatherPanel.java src/WeatherData.java
    ```

3. **Run the WeatherApp**:
    ```
    java -cp src WeatherApp
    ```

4. **Follow the prompts**:
    - Enter a city name and click on the "Search" button.
    - The application will display current weather information for the entered city.

## Example Code

### WeatherPanel.java

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WeatherPanel extends JPanel {
    private final JTextField cityField;
    private final JTextArea resultArea;

    private static final String API_KEY = "your_api_key_here"; // Replace with your OpenWeatherMap API key

    public WeatherPanel() {
        // Panel initialization code as shown previously
    }

    private class SearchButtonListener implements ActionListener {
        // ActionListener implementation as shown previously
    }

    private WeatherData fetchWeather(String city) {
        // Method to fetch weather data using WeatherAPI as shown previously
    }

    private void displayWeather(WeatherData weatherData) {
        // Method to display weather data as shown previously
    }
}
