package org.example;
import org.json.JSONException;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.json.JSONObject;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.*;

public class TgBot extends TelegramLongPollingBot {

    private final String botUsername = "https://t.me/YouWillSufferingBot";
    private final String botToken = "6806678693:AAGzeR3qhb2lc7WQawO_fQOfQ71rrc66a_0";
    private final String apiKey = "89bb100d056a438d883135347240302";
    private final String dbUrl = "jdbc:postgresql://ep-aged-darkness-a2wtlbkh.eu-central-1.aws.neon.tech/neondb?user=iklo34&password=wOYki92QxFGM&sslmode=require";
    private final String dbUser = "iklo34";
    private final String dbPassword = "tr54#@WEQQ!!";

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }
    private void insertDataToNeonTechDatabase(String information) throws SQLException {
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword)) {
            String sqlQuery = "INSERT INTO weather_info (information) VALUES (?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                preparedStatement.setString(1, information);
                preparedStatement.executeUpdate();
            }
        }
    }
    private String getDataFromNeonTechDatabase() throws SQLException {
        StringBuilder data = new StringBuilder();

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword)) {
            String sqlQuery = "SELECT * FROM weather_info";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sqlQuery)) {

                while (resultSet.next()) {
                    String weatherInfo = resultSet.getString("information");
                    data.append(weatherInfo).append("\n");
                }
            }
        }

        return data.toString();
    }

    private String getWeather(String city) throws IOException, JSONException {
        String apiUrl = "https://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + city;
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");
        conn.connect();

        InputStream inputStream = conn.getInputStream();
        StringBuilder result = new StringBuilder();
        int data = inputStream.read();
        while (data != -1) {
            result.append((char) data);
            data = inputStream.read();
        }

        conn.disconnect();

        JSONObject jsonObject = new JSONObject(result.toString());
        JSONObject current = jsonObject.getJSONObject("current");
        double tempC = current.getDouble("temp_c");
        double humidity = current.getDouble("humidity");
        int cloud = current.getInt("cloud");
        double pressure_mb = current.getDouble("pressure_mb");

        return "Температура: " + tempC + "°C\n" +
                "Вологість: " + humidity + "%\n" +
                "Хмарність: " + cloud + "%\n" +
                "Тиск: " + pressure_mb + " мб";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            if (messageText.equals("/getdata")) {
                try {
                    String dataFromDatabase = getDataFromNeonTechDatabase();
                    sendMessage(chatId, dataFromDatabase);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else if (messageText.startsWith("/weather")) {
                String city = messageText.substring(9);

                try {
                    String weatherInfo = getWeather(city);
                    insertDataToNeonTechDatabase(weatherInfo); // Збереження даних в базу даних
                    sendMessage(chatId, weatherInfo); // Відправлення інформації про погоду користувачеві
                } catch (IOException | JSONException | SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void sendMessage(long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(text);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new TgBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}

