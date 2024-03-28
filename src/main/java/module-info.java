module pi101.creditcalc {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens pi101.creditcalc to javafx.fxml;
    exports pi101.creditcalc;
    exports pi101.creditcalc.controller;
    opens pi101.creditcalc.controller to javafx.fxml;
}