module com.example.javafxassignment3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxassignment3 to javafx.fxml;
    exports com.example.javafxassignment3;
}