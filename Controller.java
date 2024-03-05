package com.example.keytyper.Controllers;

import com.example.keytyper.Modules.Graphic.GraphicModule;
import com.example.keytyper.Modules.Graphic.PointModule;
import com.example.keytyper.Modules.Timer.TimerModule;
import com.example.keytyper.Modules.Typer.TypeModule;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.Optional;
import java.util.Timer;

public class Controller {

    @FXML
    private TextFlow textFlow;

    @FXML
    private TextArea inputTextArea;
    @FXML
    private Label secs;
    private Scene scene;
    private final TypeModule typeModule = new TypeModule();
    private final GraphicModule graphicModule = new GraphicModule();
    private boolean firstType = true;

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void setupUI() {
        scene.setOnKeyPressed(this::onKeyTyped);
    }
    private  TimerModule timerModule;
    private final Timer timer = new Timer();


    public void startTimer() {
        if (timerModule != null) {
            timer.schedule(timerModule, 0, 1000);
        }
    }
    public Controller() {
        this.timerModule = new TimerModule(this);
    }

    public void startTyping() {
        String text = inputTextArea.getText();
        setText(text);
        inputTextArea.requestFocus();
        setupUI();
        inputTextArea.setEditable(false);
        timerModule = new TimerModule(this);

        startTimer();
    }

    private void setText(String text) {
        textFlow.getChildren().clear();
        for (char c : text.toCharArray()) {
            Text newText = new Text(String.valueOf(c));
            textFlow.getChildren().add(newText);
        }
    }
    public void showTextDialog() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Введення тексту");
        dialog.setHeaderText("Введіть текст для письма:");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(text -> {
            inputTextArea.setText(text);
            startTyping();
            inputTextArea.setVisible(false);

            inputTextArea.setEditable(false);

        });
    }

    public void updateSeconds(int seconds) {
        secs.setText(String.valueOf(seconds));
    }
    public void onKeyTyped(KeyEvent keyEvent) {
        typeModule.onKeyTyped(keyEvent, textFlow);
        if (firstType) {
            firstType = false;
            timerModule = new TimerModule(this);
            timer.schedule(timerModule, 0, 1000);
        }
    }

    public void updateTimer(int seconds) {
        graphicModule.addPointToList(new PointModule(seconds, typeModule.getMistakes()));
    }

    public void onTimesUp() {
        scene.setOnKeyPressed(null);
        graphicModule.createGraphic();
    }
}