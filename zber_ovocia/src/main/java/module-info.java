module com.example.zber_ovocia {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.zber_ovocia to javafx.fxml;
    exports com.example.zber_ovocia;
}