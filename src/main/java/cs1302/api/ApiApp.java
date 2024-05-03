package cs1302.api;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.io.IOException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import java.nio.charset.StandardCharsets;
import java.net.URLEncoder;
import java.util.Optional;
import java.net.http.HttpHeaders;
import java.util.Random;

import com.google.gson.JsonSyntaxException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * This app integrates real-time weather from cities with quotes that are related to the city's
 * weather. THe user can enter the name of any city. When they press the 'Get Weather' button, the
 * app will display the current weather conditions including temperature, wind speed, and a
 * description. Based on the weather, the app will display a quote that matches the weather.
 */
public class ApiApp extends Application {

    /** HTTP client. */
    public static final HttpClient HTTP_CLIENT = HttpClient.newBuilder()
        .version(HttpClient.Version.HTTP_2)
        .followRedirects(HttpClient.Redirect.NORMAL)
        .build();

    /** Google {@code Gson} object for parsing JSON-formatted strings. */
    public static Gson GSON = new GsonBuilder()
        .setPrettyPrinting()
        .create();

    Stage stage;
    Scene scene;
    VBox root;
    TextField queryTermField;
    TextArea weatherInfo;
    TextArea quoteInfo;
    HBox searchBar;

    /**
     * Constructs an {@code ApiApp} object. This default (i.e., no argument)
     * constructor is executed in Step 2 of the JavaFX Application Life-Cycle.
     */
    public ApiApp() {
        root = new VBox();
        queryTermField = new TextField();
        searchBar = new HBox();
    } // ApiApp

    /** {@inheritDoc} */
    @Override
    public void start(Stage stage) {

        this.stage = stage;

        // demonstrate how to load local asset using "file:resources/"
/**        Image bannerImage = new Image("file:resources/readme-banner.png");
        ImageView banner = new ImageView(bannerImage);
        banner.setPreserveRatio(true);
        banner.setfitwidth(640);

        // some labels to display information
        Label notice = new Label("Modify the starter code to suit your needs.");

        // setup scene
        root.getChildren().addAll(searchBar, banner, notice);
*/
        this.scene = new Scene(root, 1280, 500);
        setUp(this.scene);

        // setup stage
        stage.setTitle("ApiApp!");
        stage.setScene(scene);
        stage.setOnCloseRequest(event -> Platform.exit());
        stage.sizeToScene();
        stage.show();

    } // start

    /**
     * Sets up the UI for the app.
     *
     * @param scene Where the UI will be displayed
     */
    public void setUp(Scene scene) {
        searchBar.getChildren().addAll(
            new Label("Enter your city:"),
            queryTermField
        );
        Button getWeatherButton = new Button("Get Weather");
        getWeatherButton.setOnAction(e -> getWeather(queryTermField.getText()));
        weatherInfo = new TextArea();
        weatherInfo.setEditable(false);
        quoteInfo = new TextArea();
        quoteInfo.setEditable(false);
        Label title = new Label("Weather Wit");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        root = new VBox(10);
        root.getChildren().addAll(title, searchBar, getWeatherButton, weatherInfo, quoteInfo);
        root.setAlignment(Pos.TOP_CENTER);
        scene.setRoot(root);
    }

    /**
     * Gets weather information for the inputted city. Displays the information in the UI after
     * user presses the get weather button.
     *
     * @param city The name of the city in order to get the weather
     */
    public void getWeather(String city) {
        new Thread(() -> {
//            String encodedCity = URLEncoder.encode(city, StandardCharsets.UTF_8);
            String encodedCity = city.replace(" ", "-");
            String url = "https://goweather.herokuapp.com/weather/" + encodedCity;
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
            try {
                HttpResponse<String> response = HTTP_CLIENT.send(
                    request, HttpResponse.BodyHandlers.ofString());
                if (response.statusCode() == 503) {
                    Platform.runLater(() -> {
                        showAlert("Service is temporarily unavailable. Please try again later.");
                    });
                    return;
                }

                if (response.statusCode() == 200 &&
                    response.headers().firstValue("Content-Type")
                    .orElse("").contains("application/json")) {
                    Gson gson = new Gson();
                    WeatherResponse weather = gson.fromJson(response.body(), WeatherResponse.class);
                    String weatherText = formatWeatherData(weather);
                    Platform.runLater(() -> {
                        weatherInfo.setText(weatherText);
                        getQuote(weather.extractKeyword());
                    });
                } else {
                    Platform.runLater(() -> showAlert("Failed to get weather data for: " + city));
                }
            } catch (IOException | InterruptedException ie) {
                Platform.runLater(() -> showAlert("HTTP request failed for URL: " + url, ie));
            } catch (JsonSyntaxException jsonEx) {
                Platform.runLater(() -> showAlert("Parsing error: " + jsonEx.getMessage()));
            }
        }).start();
    }

    /**
     * Formats the weather response into readable format.
     *
     * @param weather The weather response containing the weather info
     * @return a formatted string with the weather data
     */
    private String formatWeatherData(WeatherResponse weather) {
        StringBuilder sb = new StringBuilder();
        sb.append("Current Weather: ").append(weather.getTemperature())
            .append(", ").append(weather.getWind())
            .append(", ").append(weather.getDescription()).append("\n");
        sb.append("Forecast:\n");
        for (Forecast f : weather.getForecast()) {
            sb.append("Day ").append(f.getDay()).append(": ")
                .append(f.getTemperature()).append(", ")
                .append(f.getWind()).append("\n");
        }
        return sb.toString();
    }

    /**
     * Gets a random quote related to the given keyword. Displays the quote in the UI
     * after user presses get weather button.
     *
     * @param keyword The keyword used to find a quote
     */
    public void getQuote(String keyword) {
        String baseUrl = "https://api.quotable.io/search/quotes";
        String query = "?query=" + URLEncoder.encode(keyword, StandardCharsets.UTF_8);
        String url = baseUrl + query;

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build();
        try {
            HttpResponse<String> response = HTTP_CLIENT.send(
                request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 429) {
                handleRateLimit(response);
            } else if (response.statusCode() == 200) {
                Gson gson = new Gson();
                QuoteResponse quoteResponse = gson.fromJson(response.body(), QuoteResponse.class);

                if (quoteResponse != null && quoteResponse.results != null &&
                    !quoteResponse.results.isEmpty()) {
                    Random random = new Random();
                    int randomIndex = random.nextInt(quoteResponse.results.size());
                    Quote result = quoteResponse.results.get(randomIndex);

                    String quoteText = "\"" + result.content + "\" - " + result.author;
                    Platform.runLater(() -> quoteInfo.setText(quoteText));
                } else {
                    Platform.runLater(() -> quoteInfo.setText("No quote found for: " + keyword));
                }
            } else {
                Platform.runLater(() -> showAlert("Failed to get quote for: " + keyword));
            }
        } catch (IOException | InterruptedException ex) {
            Platform.runLater(() -> showAlert("HTTP request failed: " + ex.getMessage()));
        }
    }

    /**
     * Method to handle the rate limit for the APIs. Waits before retrying the request.
     *
     * @param response The response containing the rate limit information
     */
    private void handleRateLimit(HttpResponse<String> response) {
        Optional<String> retryAfter = response.headers().firstValue("retry-after");
        if (retryAfter.isPresent()) {
            try {
                int wait = Integer.parseInt(retryAfter.get());
                System.out.println("Rate limit exceeded. Waiting for " + wait + " seconds.");
                Thread.sleep(wait * 1000);
            } catch (NumberFormatException | InterruptedException e) {
                showAlert("Failed to handle 429 status code.");
            }
        }
    }

        /**
     * Shows an alert box with a specific message.
     *
     * @param message the message displayed in the alert box
     */
    private void showAlert(String message) {
        TextArea text = new TextArea(message);
        text.setEditable(false);
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error");
        alert.getDialogPane().setContent(text);
        alert.setResizable(true);
        alert.showAndWait();
    }

    /**
     * Shows an alert box with specific messages regarding the exception.
     *
     * @param url the url that caused the exception. Includes the search term and media type.
     * @param t the throwable that was caught, causing the alert
     */
    private void showAlert(String url, Throwable t) {
        String errorMessage = null;
        if (t != null) {
            errorMessage = String.format("URI: %s\n\nException: %s",
                 url, t.toString());
        }
        TextArea text = new TextArea(errorMessage);
        text.setEditable(false);
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error");
        alert.getDialogPane().setContent(text);
        alert.setResizable(true);
        alert.showAndWait();
    }

} // ApiApp
