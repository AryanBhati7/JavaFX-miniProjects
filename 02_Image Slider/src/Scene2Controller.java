import java.util.Arrays;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Scene2Controller {
    @FXML
    Label nameLabel;
    @FXML
    private Button logoutButton;
    @FXML
    private AnchorPane scenePane;
    @FXML
    ImageView myImgView;
    Button nextBtn;

    public void displayname(String username) {
        nameLabel.setText("Hello : " + username);
    }

    private int currentImageIndex = 0;
    private List<Image> images = Arrays.asList(
            new Image(getClass().getResourceAsStream("img/img-1.jpg")),
            new Image(getClass().getResourceAsStream("img/img-2.jpg")),
            new Image(getClass().getResourceAsStream("img/img-3.jpg")),
            new Image(getClass().getResourceAsStream("img/img-4.jpg")));

    public void displayImg() {
        myImgView.setImage(images.get(currentImageIndex));
    }

    public void nextImage() {
        currentImageIndex = (currentImageIndex + 1) % images.size();
        displayImg();
    }

    public void previousImage() {
        currentImageIndex = (currentImageIndex - 1 + images.size()) % images.size();
        displayImg();
    }

    Stage stage;

    public void logout(ActionEvent event) {

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to Logout !!");
        alert.setContentText("Do you want to save before exiting? : ");

        if (alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) scenePane.getScene().getWindow();
            System.out.println("You successfully Logged Out");
            stage.close();
        }

    }
}
