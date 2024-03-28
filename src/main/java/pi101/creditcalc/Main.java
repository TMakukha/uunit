package pi101.creditcalc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * Главный класс приложения, запускающий приложение расчета кредита
 */
public class Main extends Application {

    /**
     * Метод запуска приложения
     * @param stage объект графического интерфейса
     * @throws IOException при ошибках загрузки fxml
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("credit-calculator.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1024, 768);
        stage.setTitle("Расчет потребительского кредита");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Метод запуска javaFx (визуального) приложения
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }
}