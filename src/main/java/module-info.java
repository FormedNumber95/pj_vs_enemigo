module es.aketzagonzalez {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    opens es.aketzagonzalez.pj_vs_enemigo to javafx.fxml;
    exports es.aketzagonzalez.pj_vs_enemigo;
}