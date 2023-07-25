package main;

import main.currencyConverters.pesoToCurrency;

import javax.swing.*;
import java.util.Objects;

public class Main {
    public static void setIsRunning(boolean isRunning) {
        Main.isRunning = isRunning;
    }
    public static boolean isRunning = true;
    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) {

    String[] possibleConverter = { "Currency converter", "Temperature converter" };
    String[] possibleCurrencies = {
            "From Peso to Dollar",
            "From Peso to Euro",
            "From peso to Pounds",
            "From Peso to Yen",
            "From Peso to Korean Won",
            "From Dollar to Peso",
            "From Euro to Peso",
            "From Pounds to Peso"
    };

    String[] possibleScales = {
            "From Kelvin to Celsius",
            "From Kelvin to Fahrenheit",
            "From Celsius to Kelvin",
            "From Celsius to Fahrenheit",
            "From Fahrenheit to Kelvin",
            "From Fahrenheit to Celsius"
    };
    ImageIcon image = new ImageIcon("logo.png");

    pesoToCurrency pesoAmoneda = new pesoToCurrency();

    while(isRunning) {
    String selectedConverter = JOptionPane.showInputDialog(null, "Seleccione una opción de conversión", "conversor de moneda", JOptionPane.INFORMATION_MESSAGE, image, possibleConverter, possibleConverter[0]).toString();
        switch (selectedConverter) {
            case "Currency converter":
                String inputValue = JOptionPane.showInputDialog("Please input a value of the currency you want to convert");
                String selectedCurrency = JOptionPane.showInputDialog(null, "Select a currency you want to convert", "conversor de moneda", JOptionPane.INFORMATION_MESSAGE, image, possibleCurrencies, possibleCurrencies[0]).toString();
                switch (selectedCurrency) {
                    case "From Peso to Dollar" -> pesoAmoneda.pesoToDollar(inputValue, isRunning);
                    case "From Peso to Euro" -> pesoAmoneda.pesoToEuro(inputValue, isRunning);
                    case "From Peso to Pounds" -> pesoAmoneda.pesoToPounds(inputValue,isRunning);
                    case "From Peso to Yen" -> pesoAmoneda.pesoToYen(inputValue,isRunning);
                    case "From Peso to Korean Won" -> pesoAmoneda.pesoToWon(inputValue,isRunning);
                }
                break;
            case "Temperature converter":
                inputValue = JOptionPane.showInputDialog("Please input a value of the temperature");
                Object selectedTemperature = JOptionPane.showInputDialog(null, "Select a temperature scale you want to convert", "Temperature converter", JOptionPane.INFORMATION_MESSAGE, image, possibleScales, possibleScales[0]);

                if(selectedTemperature == possibleScales[0]) {
                    float kelvin = -273.15F;
                    float value = Float.parseFloat(inputValue);
                    float convertedTemperature = value + kelvin;
                    JOptionPane.showMessageDialog(null, "The converted temperature to celsius is: " + convertedTemperature + " ° Celsius");
                    int convertAgain =  JOptionPane.showConfirmDialog(null, "Do you want to make another conversion?", "Converter", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, image);
                    if (convertAgain == 0 ){
                        System.out.println("Converting again");
                    } else {
                        JOptionPane.showMessageDialog(null, "Program terminated");
                        isRunning = false;
                    }
                }
                break;
        }

        }
    }

}
