package com.example.demo1;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NoteApp extends Application {

    private ListView<String> notesList;
    private TextField noteInput;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("замітки");

        notesList = new ListView<>();
        noteInput = new TextField();
        noteInput.setPromptText("Введіть замітку");

        Button addButton = new Button("Додати");
        addButton.setOnAction(e -> addNote());

        Button deleteButton = new Button("Видалити");
        deleteButton.setOnAction(e -> deleteNote());

        Button editButton = new Button("Редагувати");
        editButton.setOnAction(e -> editNote());

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(notesList, noteInput, addButton,deleteButton,editButton);

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private void addNote() {
        String noteText = noteInput.getText();
        if (!noteText.isEmpty()) {
            notesList.getItems().add(noteText);
            noteInput.clear();
        }
    }
    private void deleteNote() {
        notesList.getItems().remove(notesList.getSelectionModel().getSelectedItem());
    }
    private void editNote() {
    int selectedIndex = notesList.getSelectionModel().getSelectedIndex();
    if (selectedIndex >= 0) {
        String newNoteText = noteInput.getText();
        if (!newNoteText.isEmpty()) {
            notesList.getItems().set(selectedIndex, newNoteText);
            noteInput.clear();
        }
    }
    }
}