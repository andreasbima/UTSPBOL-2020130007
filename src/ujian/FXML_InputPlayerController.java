/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ujian;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class FXML_InputPlayerController implements Initializable {

    boolean editdata = false;

    public void execute(PlayerModel d) {
        if (!d.getPlayerID().isEmpty()) {
            editdata = true;
            txtid.setText(d.getPlayerID());
            txtname.setText(d.getName());
            txtid.setEditable(false);
            txtname.requestFocus();
        }
    }

    @FXML
    private TextField txtid;
    @FXML
    private TextField txtname;
    @FXML
    private Button btnsave;
    @FXML
    private Button btncancel;
    @FXML
    private Button btnexit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void savekik(ActionEvent event) {
        PlayerModel s = new PlayerModel();
        s.setPlayerID(txtid.getText());
        s.setName(txtname.getText());
        FXMLDocumentController.dtplayer.setPlayerModel(s);
        if (editdata) {
            if (FXMLDocumentController.dtplayer.update()) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Data updated successfully", ButtonType.OK);
                a.showAndWait();
                txtid.setEditable(true);
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Data failed to update", ButtonType.OK);
                a.showAndWait();
            }
        } else if (FXMLDocumentController.dtplayer.validasi(s.getPlayerID()) <= 0) {
            if (FXMLDocumentController.dtplayer.insert()) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Data saved successfully", ButtonType.OK);
                a.showAndWait();
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Data failed to save", ButtonType.OK);
                a.showAndWait();
            }
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data already exists", ButtonType.OK);
            a.showAndWait();
            txtid.requestFocus();
        }
    }

    @FXML
    private void cancelklik(ActionEvent event) {
        txtid.setText("");
        txtname.setText("");
        txtid.requestFocus();
    }

    @FXML
    private void exitklik(ActionEvent event) {
        btnexit.getScene().getWindow().hide();

    }

}
