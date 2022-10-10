/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ujian;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class FXML_SoalController implements Initializable {

    @FXML
    private TableView<SoalModel> tbvsoal;
    @FXML
    private TextField txt01;
    @FXML
    private Button btncek1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showdata();
    }    
    
    public void showdata() {
        ObservableList<SoalModel> data = FXMLDocumentController.dtsoal.Load();
        if (data != null) {
            tbvsoal.getColumns().clear();
            tbvsoal.getItems().clear();
            TableColumn col = new TableColumn("IDSoal");
            col.setCellValueFactory(new PropertyValueFactory<SoalModel, String>("IDSoal"));
            tbvsoal.getColumns().addAll(col);
            col = new TableColumn("Soal");
            col.setCellValueFactory(new PropertyValueFactory<SoalModel, String>("Soal"));
            tbvsoal.getColumns().addAll(col);
            tbvsoal.setItems(data);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data is empty", ButtonType.OK);
            a.showAndWait();
            tbvsoal.getScene().getWindow().hide();
        }
    }

    @FXML
    private void cek1klik(ActionEvent event) {
        if(txt01.getText().trim().equalsIgnoreCase("rusia")){
            JOptionPane.showMessageDialog(null, "Correct");
        }else if(txt01.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Fill in the answer");
        }else{
            JOptionPane.showMessageDialog(null, "Wrong");
            txt01.setText("");
        }
    }
    
}
