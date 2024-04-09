import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;

public class Scene1Controller {
    @FXML
    TextField nameField;
    @FXML
    PasswordField passField;
    @FXML
    Label errorLabel;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void login(ActionEvent event) throws IOException {
        String username = nameField.getText();
        String password = passField.getText();
        if (username.equals("Aryan") && password.equals("12345")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2.fxml"));
            root = loader.load();
            Scene2Controller scene2controller = loader.getController();
            scene2controller.displayname(username);
            // root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            // String errorMessage = "Incorrect User Credentials";
            errorLabel.setText("Incorrect User Credentials");
        }

    }

}
