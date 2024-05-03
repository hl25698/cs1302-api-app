package cs1302.api;

import java.util.List;

public class WeatherResponse {
    private String temperature;
    private String wind;
    private String description;
    private List<Forecast> forecast;

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Forecast> getForecast() {
        return forecast;
    }

    public void setForecast(List<Forecast> forecast) {
        this.forecast = forecast;
    }

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
        }
        return "weather"; // Default keyword
    }
}
