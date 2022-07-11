module com.example.javafx_for_dummies {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafx_for_dummies to javafx.fxml;
    exports com.example.javafx_for_dummies;
}