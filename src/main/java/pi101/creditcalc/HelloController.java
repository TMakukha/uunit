package pi101.creditcalc;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private TextField amountTextField;
    @FXML
    private Slider amountSlider;

    @FXML
    private TextField rateTextField;
    @FXML
    private Slider rateSlider;

    @FXML
    private TextField termTextField;
    @FXML
    private Slider termSlider;

    @FXML
    private Button calculateButton;

    @FXML
    private Label monthlyPaymentLabel;

    @FXML
    protected void initialize() {

    // Сумма кредита
        // текстовое поле
        amountTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                String cleanedValue = newValue.replaceAll("[^\\d]", "");

                double value = Double.parseDouble(cleanedValue);

                DecimalFormat format = new DecimalFormat("#,###");
                String formattedValue = format.format(value);

                // Передача форматированного значения в текстовое поле
                amountTextField.setText(formattedValue);

                // Передача форматированного значения в слайдер
                amountSlider.setValue(value);
            } catch (NumberFormatException e) {

            }
        });

        // ползунок
        amountSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            DecimalFormat format = new DecimalFormat("#,###");
            amountTextField.setText(format.format(newValue.intValue()));
        });

    // Процентная ставка
        // текстовое поле
        rateTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                double value = Double.parseDouble(newValue);
                value = Math.round(value * 2) / 2.0;
                rateSlider.setValue(value);
            } catch (NumberFormatException e) {
            }
        });

        // ползунок
        rateSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            newValue = Math.round(newValue.doubleValue() * 2) / 2.0;
            rateTextField.setText(String.valueOf(newValue));
        });

    // Срок кредита
        // Поле ввода текста
        termTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                int value = Integer.parseInt(newValue);
                termSlider.setValue(value);
            } catch (NumberFormatException e) {
            }
        });

        // Ползунок
        termSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            termTextField.setText(String.valueOf(newValue.intValue()));
        });

        // Отключение кнопки пока не введены данные
        calculateButton.disableProperty().bind(
                amountTextField.textProperty().isEmpty()
                        .or(rateTextField.textProperty().isEmpty())
                        .or(termTextField.textProperty().isEmpty())
        );
    }

    @FXML
    protected void onCalculateButtonClick() {
        Number amount = amountSlider.getValue();
        Number rate = rateSlider.getValue();
        int term = (int) termSlider.getValue();

        // Расчет кредита
        double calculatedResult = calculateCredit(amount.doubleValue(), rate.doubleValue(), term);

        // Форматирование данных
        DecimalFormat format = new DecimalFormat("#,###.## ₽");
        monthlyPaymentLabel.setText("Ежемесячный платеж: " + format.format(calculatedResult));
    }


    // Метод для расчета кредита
    private double calculateCredit(double amount, double rate, int term) {

        double monthlyRate = rate / 12 / 100;
        int numberOfPayments = term;

        return (monthlyRate * amount) / (1 - Math.pow(1 + monthlyRate, -numberOfPayments));
    }
}
