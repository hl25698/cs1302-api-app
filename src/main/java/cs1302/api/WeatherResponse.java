package cs1302.api;

import java.util.List;

/**
 * Represents a response containing weather information from an external Weather API.
 */
public class WeatherResponse {
    private String temperature;
    private String wind;
    private String description;
    private List<Forecast> forecast;

    /**
     * Retrieves the temperature.
     *
     * @return the temperature
     */
    public String getTemperature() {
        return temperature;
    }

    /**
     * Sets the temperature.
     *
     * @param temperature the temperature
     */
    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    /**
     * Retrieves the wind speed.
     *
     * @return the wind speed
     */
    public String getWind() {
        return wind;
    }

    /**
     * Sets the wind speed.
     *
     * @param wind the wind speed
     */
    public void setWind(String wind) {
        this.wind = wind;
    }

    /**
     * Retrieves the weather description.
     *
     * @return the weather description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the weather description.
     *
     * @param description the weather description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retrieves the forecast for upcoming days.
     *
     * @return the list of forecasts
     */
    public List<Forecast> getForecast() {
        return forecast;
    }

    /**
     * Sets the forecast for upcoming days.
     *
     * @param forecast the list of forecasts
     */
    public void setForecast(List<Forecast> forecast) {
        this.forecast = forecast;
    }

    /**
     * Extracts a keyword based on the weather description.
     *
     * @return a keyword representing the weather condition
     */
    public String extractKeyword() {
        String descriptionLower = this.description.toLowerCase();
        if (descriptionLower.contains("sunny")) {
            return "sun";
        } else if (descriptionLower.contains("rain")) {
            return "rain";
        } else if (descriptionLower.contains("cloud")) {
            return "cloud";
        } else if (descriptionLower.contains("snow")) {
            return "snow";
        } else if (descriptionLower.contains("clear")) {
            return "clear";
        }
        return "weather"; // Default keyword
    }
}
