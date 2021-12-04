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
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;

public class RegistrationFormApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Registration Form JavaFX Application JDK 11.0.2");


        GridPane GridPaneLayout = createRegistrationFormPane();
        addUIControls(GridPaneLayout);
        Scene scene = new Scene(GridPaneLayout, 750, 500);
        GridPaneLayout.setStyle("-fx-background-color: GREY;");
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

        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPaneLayout.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPaneLayout;
    }

    private void addUIControls(GridPane gridPane) {
        Label headerLabel = new Label("Registration Form");
        headerLabel.setFont(Font.font("Courier New ", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));


        // Todo emailTest:
        Label emailLabel = new Label("Email ID : ");
        gridPane.add(emailLabel, 0, 2);
        emailLabel.setFont(Font.font("Courier New ", 18));


        // Add Email Text Field
        TextField emailField = new TextField();
        emailField.setPrefHeight(50);
        gridPane.add(emailField, 1, 2);

        // Todo passwordTest:
        // Password Label
        Label passwordLabel = new Label("Password : ");
        gridPane.add(passwordLabel, 0, 3);
        passwordLabel.setFont(Font.font("Courier New ", 18));

        // Password Field
        PasswordField passwordField = new PasswordField();
        passwordField.setPrefHeight(50);
        gridPane.add(passwordField, 1, 3);

        // Sign Up Button
        Button submitButton = new Button("Sign Up");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        gridPane.add(submitButton, 0, 4, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if(emailField.getText().isEmpty()) {
                    showAlertMessage(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Error! Please re-enter your email ID");
                    return;
                }
                if(passwordField.getText().isEmpty()) {
                    showAlertMessage(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Error! Please re-enter a password");
                    return;
                }

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



    public static void main(String[] args) {
        launch(args);
    }


}