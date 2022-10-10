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
    @FXML
    private TextField txt02;
    @FXML
    private TextField txt03;
    @FXML
    private TextField txt04;
    @FXML
    private TextField txt05;
    @FXML
    private TextField txt10;
    @FXML
    private TextField txt09;
    @FXML
    private TextField txt08;
    @FXML
    private TextField txt07;
    @FXML
    private TextField txt06;
    @FXML
    private Button btncek2;
    @FXML
    private Button btncek3;
    @FXML
    private Button btncek4;
    @FXML
    private Button btncek5;
    @FXML
    private Button btncek6;
    @FXML
    private Button btncek7;
    @FXML
    private Button btncek8;
    @FXML
    private Button btncek9;
    @FXML
    private Button btncek10;

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

    @FXML
    private void cek2klik(ActionEvent event) {
        if(txt02.getText().trim().equalsIgnoreCase("pasifik")){
            JOptionPane.showMessageDialog(null, "Correct");
        }else if(txt02.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Fill in the answer");
        }else{
            JOptionPane.showMessageDialog(null, "Wrong");
            txt02.setText("");
        }
    }

    @FXML
    private void cek3klik(ActionEvent event) {
        if(txt03.getText().trim().equalsIgnoreCase("sungai")){
            JOptionPane.showMessageDialog(null, "Correct");
        }else if(txt03.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Fill in the answer");
        }else{
            JOptionPane.showMessageDialog(null, "Wrong");
            txt03.setText("");
        }
    }

    @FXML
    private void cek4klik(ActionEvent event) {
        if(txt04.getText().trim().equalsIgnoreCase("oseanografi")){
            JOptionPane.showMessageDialog(null, "Correct");
        }else if(txt04.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Fill in the answer");
        }else{
            JOptionPane.showMessageDialog(null, "Wrong");
            txt04.setText("");
        }
    }

    @FXML
    private void cek5klik(ActionEvent event) {
        if(txt05.getText().trim().equalsIgnoreCase("vulkanik")){
            JOptionPane.showMessageDialog(null, "Correct");
        }else if(txt05.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Fill in the answer");
        }else{
            JOptionPane.showMessageDialog(null, "Wrong");
            txt05.setText("");
        }
    }

    @FXML
    private void cek6klik(ActionEvent event) {
        if(txt06.getText().trim().equalsIgnoreCase("tektonik")){
            JOptionPane.showMessageDialog(null, "Correct");
        }else if(txt06.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Fill in the answer");
        }else{
            JOptionPane.showMessageDialog(null, "Wrong");
            txt06.setText("");
        }
    }

    @FXML
    private void cek7klik(ActionEvent event) {
    }

    @FXML
    private void cek8klik(ActionEvent event) {
    }

    @FXML
    private void cek9klik(ActionEvent event) {
    }

    @FXML
    private void cek10klik(ActionEvent event) {
    }
    
}
