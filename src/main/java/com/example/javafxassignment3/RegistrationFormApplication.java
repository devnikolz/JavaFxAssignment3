package com.example.javafxassignment3;
// import libraries for the form
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.util.Objects;

public class RegistrationFormApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Registration Form JavaFX Application JDK 11.0.2");

        String image = String.valueOf(RegistrationFormApplication.class.getResource("/Users/projectbuild/Desktop/aws.png"));
        GridPane GridPaneLayout = createRegistrationFormPane();
        addUIControls(GridPaneLayout);
        Scene scene = new Scene(GridPaneLayout, 750, 500);
        GridPaneLayout.setStyle("-fx-background-image: url('" + image + "'); " +
                "-fx-background-position: center center; " +
                "-fx-background-repeat: stretch;");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private GridPane createRegistrationFormPane() {
        GridPane gridPaneLayout = new GridPane();
        gridPaneLayout.setAlignment(Pos.CENTER);
        gridPaneLayout.setPadding(new Insets(40, 40, 40, 40));
        gridPaneLayout.setHgap(20);
        gridPaneLayout.setVgap(20);

        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200, 200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPaneLayout.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPaneLayout;
    }

    private void addUIControls(GridPane gridPane) {
        Label headerLabel = new Label("Registration Form");
        headerLabel.setFont(Font.font("Courier New ", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0, 0, 2, 1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 0));


        // Todo emailTest:
        Label emailLabel = new Label("Email ID : ");
        gridPane.add(emailLabel, 1, 2);
        emailLabel.setFont(Font.font("Courier New ", 12));


        // Add Email Text Field
        TextField emailField = new TextField();
        emailField.setPrefHeight(30);
        gridPane.add(emailField, 1, 3);

        // Todo passwordTest:
        // Password Label
        Label passwordLabel = new Label("Password : ");
        gridPane.add(passwordLabel, 1, 4);
        passwordLabel.setFont(Font.font("Courier New ", 12));


        // Password Field
        PasswordField passwordField = new PasswordField();
        passwordField.setPrefHeight(30);
        gridPane.add(passwordField, 1, 5);


        Label passwordLabel2 = new Label("Confirm Password : ");
        gridPane.add(passwordLabel2, 1, 6);
        passwordLabel2.setFont(Font.font("Courier New ", 12));

        PasswordField passwordField2 = new PasswordField();
        passwordField2.setPrefHeight(30);
        gridPane.add(passwordField2, 1, 7);

        // Sign Up Button
        Button submitButton = new Button("Sign Up");
        submitButton.setPrefHeight(30);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        gridPane.add(submitButton, 0, 8, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0, 20, 0));


        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (emailField.getText().isEmpty()) {
                    showAlertMessage(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Error! Please re-enter your email ID");
                    return;
                }

                if (!emailField.getText().matches("^[a-zA-Z0-9][a-zA-Z0-9\\._-]{2,20}(@)(gmail.com|yahoo.com|icloud.com|hotmail.com|aol.com|msn.com)$")) {
                    showAlertMessage(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "We no longer support this email domain. Sorry for the inconvenience.");
                    return;
                }

                if (passwordField.getText().length() <= 7) {
                    showAlertMessage(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "The length of the password to be at least 7 characters in length.");
                    return;
                }

                if (passwordField.getText().matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()???[{}]:;',?/*~$^+=<>]).{8,20}$")) {
                  //  showAlertMessage(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "This password is not strong enough. Please make a better password.");

                    // checks if passwords are the same
                    if (Objects.equals(passwordField.getText(), passwordField2.getText())) {
                        showAlertMessage2(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "No Match!", "This passwords match.");
                    }

                    else{ showAlertMessage2(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "NO Match!", "This passwords do not match.");
                    }
                    return;


                }

//                if (passwordField2.getText().length() <= 7) {
//                    showAlertMessage(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "The length of the password to be at least 7 characters in length.");
//                    return;
//                }
//
//                if (!passwordField2.getText().matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()???[{}]:;',?/*~$^+=<>]).{8,20}$")) {
//                    showAlertMessage(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "This password is not strong enough. Please make a better password.");






                showAlertMessage(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Registration Complete!", "Welcome!!!");//nameField.getText());
            }


        });
    }

    private void showAlertMessage(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    private void showAlertMessage2(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
