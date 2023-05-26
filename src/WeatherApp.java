import com.weatherreport.gui.WeatherAPI;
import com.weatherreport.gui.WeatherData;

import javax.swing.*;
import java.awt.*;

public class WeatherApp extends JFrame {

    private final JTextField cityNameField;
    private final JLabel temperatureLabel;
    private final JLabel humidityLabel;
    private final JLabel pressureLabel;

    public WeatherApp() {
        super("Weather App");

        // Set up the GUI
        setSize(400, 300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add the GUI components
        JLabel cityNameLabel = new JLabel("City name:");
        add(cityNameLabel);

        cityNameField = new JTextField(20);
        add(cityNameField);

        JButton submitButton = new JButton("Submit");
        add(submitButton);

        temperatureLabel = new JLabel("Temperature:");
        add(temperatureLabel);

        humidityLabel = new JLabel("Humidity:");
        add(humidityLabel);

        pressureLabel = new JLabel("Pressure:");
        add(pressureLabel);

        // Add an ActionListener to the submit button
        submitButton.addActionListener(e -> {
            String cityName = cityNameField.getText();
            WeatherData weatherData = WeatherAPI.getWeatherData(cityName);

            if (weatherData != null) {
                temperatureLabel.setText("Temperature: " + weatherData.getTemperature() + " °F");
                humidityLabel.setText("Humidity: " + weatherData.getHumidity() + " %");
                pressureLabel.setText("Pressure: " + weatherData.getPressure() + " hPa");
            } else {
                temperatureLabel.setText("Temperature:");
                humidityLabel.setText("Humidity:");
                pressureLabel.setText("Pressure:");
                JOptionPane.showMessageDialog(null, "Error retrieving weather data.");
            }
        });

        // Show the GUI
        setVisible(true);
    }

    public static void main(String[] args) {
        new WeatherApp();
    }
}


