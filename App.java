package com.example.keytyper;

import com.example.keytyper.Controllers.Controller;
import com.example.keytyper.Modules.Timer.TimerModule;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Timer;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("hello-view.fxml"));
        VBox root = fxmlLoader.load();

        Controller controller = fxmlLoader.getController();
        Scene scene = new Scene(root, 320, 240);
        controller.setScene(scene);

        stage.setTitle("Key Typer");
        stage.setScene(scene);
        stage.show();

        controller.showTextDialog();

        Timer timer = new Timer();
        timer.schedule(new TimerModule(controller), 0, 1000);
    }

    public static void main(String[] args) {
        launch();
    }
}
