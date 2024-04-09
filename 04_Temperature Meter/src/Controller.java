import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class Controller implements Initializable {
    @FXML
    private DatePicker myDatePicker;
    @FXML
    private Label myDate;
    @FXML
    private Label myTemp;
    @FXML
    private Slider mySlider;
    @FXML
    private AnchorPane myPane;

    public void getDate(ActionEvent event) {
        LocalDate myDateVal = myDatePicker.getValue();
        String myFormattedDate = myDateVal.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        myDate.setText(myFormattedDate);
    }

    int myTemperature;

    String TempHead = "Temperature : ";

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        mySlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                myTemperature = (int) mySlider.getValue();
                myTemp.setText(TempHead + Integer.toString(myTemperature) + "°C");
                changeColor();
            }
        });
    }

    public void changeColor() {
        if (myTemperature == 50) {
            Color myColor = Color.rgb(255, 255, 255);
            myPane.setBackground(new Background(new BackgroundFill(myColor, null, null)));
        }
        if (myTemperature < 50) {
            int blueIntensity = (50 - myTemperature) * 5;
            Color myColor = Color.rgb(0, 0, blueIntensity);
            myPane.setBackground(new Background(new BackgroundFill(myColor, null, null)));
        } else {
            int redIntensity = (myTemperature - 50) * 5;
            Color myColor = Color.rgb(redIntensity, 0, 0);
            myPane.setBackground(new Background(new BackgroundFill(myColor, null, null)));
        }
    }

}
