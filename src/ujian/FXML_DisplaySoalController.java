/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ujian;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class FXML_DisplaySoalController implements Initializable {

    @FXML
    private Button btnadd;
    @FXML
    private Button btndelete;
    @FXML
    private Button btnupdate;
    @FXML
    private Button btnexit;
    @FXML
    private TableView<SoalModel> tbvsoal;

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
    private void addklik(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_InputSoal.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
        showdata();
    }

    @FXML
    private void deleteklik(ActionEvent event) {
        SoalModel s = new SoalModel();
        s = tbvsoal.getSelectionModel().getSelectedItem();
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Delete this?", ButtonType.YES, ButtonType.NO);
        a.showAndWait();
        if (a.getResult() == ButtonType.YES) {
            if (FXMLDocumentController.dtsoal.delete(s.getIDSoal())) {
                Alert b = new Alert(Alert.AlertType.INFORMATION, "Data deleted successfully", ButtonType.OK);
                b.showAndWait();
            } else {
                Alert b = new Alert(Alert.AlertType.ERROR, "Data failed to delete", ButtonType.OK);
                b.showAndWait();
            }
            showdata();
        }
    }

    @FXML
    private void updateklik(ActionEvent event) {
        SoalModel s = new SoalModel();
        s = tbvsoal.getSelectionModel().getSelectedItem();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_InputSoal.fxml"));
            Parent root = (Parent) loader.load();
            FXML_InputSoalController isidt = (FXML_InputSoalController) loader.getController();
            isidt.execute(s);
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
        showdata();
    }

    @FXML
    private void exitklik(ActionEvent event) {
        btnexit.getScene().getWindow().hide();
    }

}
