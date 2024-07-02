import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WeatherPanel extends JPanel {
    private final JTextField cityField;
    private final JTextArea resultArea;

    private static final String API_KEY = "your_api_key_here"; // Replace with your OpenWeatherMap API key

    public WeatherPanel() {
        setPreferredSize(new Dimension(400, 300));
        setBackground(Color.white);
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Weather App", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(titleLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new FlowLayout());
        JLabel cityLabel = new JLabel("Enter City: ");
        cityField = new JTextField(20);
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new SearchButtonListener());
        inputPanel.add(cityLabel);
        inputPanel.add(cityField);
        inputPanel.add(searchButton);
        add(inputPanel, BorderLayout.CENTER);

        resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        add(scrollPane, BorderLayout.SOUTH);
    }

    private class SearchButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String city = cityField.getText().trim();
            if (!city.isEmpty()) {
                WeatherData weatherData = fetchWeather(city);
                if (weatherData != null) {
                    displayWeather(weatherData);
                } else {
                    resultArea.setText("Error fetching weather data.");
                }
            } else {
                resultArea.setText("Please enter a city name.");
            }
        }
    }

    private WeatherData fetchWeather(String city) {
        // Make API call to fetch weather data
        WeatherData weatherData = WeatherAPI.fetchWeather(city, API_KEY);
        return weatherData;
    }

    private void displayWeather(WeatherData weatherData) {
        resultArea.setText("City: " + weatherData.getCity() + "\n");
        resultArea.append("Temperature: " + weatherData.getTemperature() + "°C\n");
        resultArea.append("Description: " + weatherData.getDescription() + "\n");
        resultArea.append("Humidity: " + weatherData.getHumidity() + "%\n");
        resultArea.append("Wind Speed: " + weatherData.getWindSpeed() + " m/s\n");
    }
}
