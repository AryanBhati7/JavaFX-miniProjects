import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private Button myButton;
    @FXML
    private TextField myTextField;
    @FXML
    private Label myLabel;

    int age;

    public void submit(ActionEvent event) {
        try {
            age = Integer.parseInt(myTextField.getText());
            if (age >= 18 && age < 110) {
                myLabel.setText("You are ADULT");
            } else if (age < 18 && age > 0) {
                myLabel.setText("You are not ADULT");
            } else {
                myLabel.setText("Stop kidding and Enter your age");
            }
        } catch (NumberFormatException e) {
            myLabel.setText("Enter only numbers");
            System.out.println("Enter only number");
        } catch (Exception e) {
            myLabel.setText("ERROR");
            System.out.println(e);
        }
    }
}