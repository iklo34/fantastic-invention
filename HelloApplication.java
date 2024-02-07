package com.example.fxbro;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;

public class HelloApplication extends Application {

    private static final String API_KEY = "89bb100d056a438d883135347240302";
    private static final String API_URL = "https://api.weatherapi.com/v1/current.json?key=";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Weather App");

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(10);

        TextField locationInput = new TextField();
        locationInput.setPromptText("Enter location");
        Label weatherInfoLabel = new Label();

        Button getWeatherButton = new Button("Get Weather");
        getWeatherButton.setOnAction(event -> {
            String location = locationInput.getText();
            if (!location.isEmpty()) {
                String apiUrl = API_URL + API_KEY + "&q=" + location;
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url(apiUrl)
                            .build();
                    Response response = client.newCall(request).execute();
                    String jsonData = response.body().string();
                    JSONObject jsonObject = new JSONObject(jsonData);
                    JSONObject current = jsonObject.getJSONObject("current");
                    String temperature = current.getString("temp_c");
                    String condition = current.getJSONObject("condition").getString("text");

                    String weatherInfo = "Temperature: " + temperature + "°C, Condition: " + condition;
                    weatherInfoLabel.setText(weatherInfo);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (org.json.JSONException e) {
                    e.printStackTrace();
                }
            } else {
                weatherInfoLabel.setText("Please enter a location.");
            }
        });

        vbox.getChildren().addAll(locationInput, getWeatherButton, weatherInfoLabel);

        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}