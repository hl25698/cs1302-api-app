package cs1302.api;

/**
 * Represents a forecast for a specific day, including temperature and wind information.
 */
public class Forecast {
    private int day;
    private String temperature;
    private String wind;

    // Getters and setters

    /**
     * Retrieves the day number for the forecast.
     *
     * @return the day number
     */
    public int getDay() {
        return day;
    }

    /**
     * Sets the day number for the forecast.
     *
     * @param day the day number
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * Retrieves the temperature forecast for the day.
     *
     * @return the temperature forecast
     */
    public String getTemperature() {
        return temperature;
    }

    /**
     * Sets the temperature forecast for the day.
     *
     * @param temperature the temperature forecast
     */
    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    /**
     * Retrieves the wind forecast for the day.
     *
     * @return the wind forecast
     */
    public String getWind() {
        return wind;
    }

    /**
     * Sets the wind forecast for the day.
     *
     * @param wind the wind forecast
     */
    public void setWind(String wind) {
        this.wind = wind;
    }
}
