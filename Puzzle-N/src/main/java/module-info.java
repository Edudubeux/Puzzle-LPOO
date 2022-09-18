module com.puzzle.puzzlen {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.puzzle.puzzlen to javafx.fxml;
    exports com.puzzle.puzzlen;
}