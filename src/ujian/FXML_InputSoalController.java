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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class FXML_InputSoalController implements Initializable {

    boolean editdata = false;

    public void execute(SoalModel d) {
        if (!d.getIDSoal().isEmpty()) {
            editdata = true;
            txtid.setText(d.getIDSoal());
            txasoal.setText(d.getSoal());
            txtid.setEditable(false);
            txasoal.requestFocus();
        }
    }

    @FXML
    private TextField txtid;
    @FXML
    private TextArea txasoal;
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
        SoalModel s = new SoalModel();
        s.setIDSoal(txtid.getText());
        s.setSoal(txasoal.getText());
        FXMLDocumentController.dtsoal.setSoalModel(s);
        if (editdata) {
            if (FXMLDocumentController.dtsoal.update()) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Data updated successfully", ButtonType.OK);
                a.showAndWait();
                txtid.setEditable(true);
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Data failed to update", ButtonType.OK);
                a.showAndWait();
            }
        } else if (FXMLDocumentController.dtsoal.validasi(s.getIDSoal()) <= 0) {
            if (FXMLDocumentController.dtsoal.insert()) {
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
        txasoal.setText("");
        txtid.requestFocus();
    }

    @FXML
    private void exitklik(ActionEvent event) {
        btnexit.getScene().getWindow().hide();
    }

}
