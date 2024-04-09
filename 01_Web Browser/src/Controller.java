import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;

public class Controller implements Initializable {

    @FXML
    private WebView webView;

    @FXML
    private TextField textField;

    private WebEngine engine;
    private WebHistory history;
    private String homepage;
    private double webZoom;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        engine = webView.getEngine();
        homepage = "www.google.com";
        textField.setText(homepage);
        webZoom = 1;
        loadPage();
    }

    public void loadPage() {
        engine.load("http://" + textField.getText());
    }

    public void refreshPage() {
        engine.reload();
    }

    public void zoomIn() {
        webZoom += 0.25;
        webView.setZoom(webZoom);
    }

    public void zoomOut() {
        webZoom -= 0.25;
        webView.setZoom(webZoom);
    }

    public void displayHistory() {
        history = engine.getHistory();
        ObservableList<WebHistory.Entry> entries = history.getEntries();
        StringBuilder historyContent = new StringBuilder();
        for (WebHistory.Entry entry : entries) {
            historyContent.append(entry.getUrl()).append("  ").append(entry.getLastVisitedDate()).append("\n");
        }
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("History");
        alert.setHeaderText(null);
        alert.setContentText(historyContent.toString());

        alert.showAndWait();
    }

    public void back() {
        history = engine.getHistory();
        ObservableList<WebHistory.Entry> entries = history.getEntries();
        history.go(-1);
        textField.setText(entries.get(history.getCurrentIndex()).getUrl());
    }

    public void forward() {
        history = engine.getHistory();
        ObservableList<WebHistory.Entry> entries = history.getEntries();
        history.go(1);
        textField.setText(entries.get(history.getCurrentIndex()).getUrl());
    }

    public void returnToHome() {
        history = engine.getHistory();
        engine.load("http://www.google.com");
        textField.setText("www.google.com");
    }

    public void executeJS() {
        engine.executeScript("window.location=\"https://www.youtube.com\";");
    }
}
