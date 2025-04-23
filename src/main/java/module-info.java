module co.edu.uniquindio.billeteravirtual.appbilleteravirtual {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens co.edu.uniquindio.billeteravirtual.appbilleteravirtual to javafx.fxml;
    exports co.edu.uniquindio.billeteravirtual.appbilleteravirtual;
    opens co.edu.uniquindio.billeteravirtual.appbilleteravirtual.viewController;
    exports co.edu.uniquindio.billeteravirtual.appbilleteravirtual.viewController;
    opens co.edu.uniquindio.billeteravirtual.appbilleteravirtual.model to javafx.base;

}