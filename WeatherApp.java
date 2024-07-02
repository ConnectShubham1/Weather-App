import javax.swing.*;

public class WeatherApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Weather App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        WeatherPanel weatherPanel = new WeatherPanel();
        frame.getContentPane().add(weatherPanel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
