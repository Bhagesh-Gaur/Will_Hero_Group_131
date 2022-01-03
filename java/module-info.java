module com.example.will_hero {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.datatransfer;

    opens com.example.will_hero to javafx.fxml;
    exports com.example.will_hero;
    exports com.example.will_hero.Elements;
    opens com.example.will_hero.Elements to javafx.fxml;
    exports com.example.will_hero.Elements.Controller;
    opens com.example.will_hero.Elements.Controller to javafx.fxml;
    exports com.example.will_hero.Game_Commiter;
    opens com.example.will_hero.Game_Commiter to javafx.fxml;
}