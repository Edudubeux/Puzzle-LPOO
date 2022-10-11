module com.puzzle.puzzle {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.internal.le;


    opens com.puzzle.puzzle to javafx.fxml;
    exports com.puzzle.puzzle;
    exports com.puzzle.puzzle.controller;
    opens com.puzzle.puzzle.controller to javafx.fxml;
}