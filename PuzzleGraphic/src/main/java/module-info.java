module com.puzzle.puzzle {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.puzzle.puzzle to javafx.fxml;
    exports com.puzzle.puzzle;
}