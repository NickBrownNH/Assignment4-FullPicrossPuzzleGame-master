module com.example.assignment4picrosspuzzlegame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.assignment4picrosspuzzlegame to javafx.fxml;
    exports com.example.assignment4picrosspuzzlegame;
}