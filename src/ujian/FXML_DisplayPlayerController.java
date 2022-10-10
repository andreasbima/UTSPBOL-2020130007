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
public class FXML_DisplayPlayerController implements Initializable {

    @FXML
    private TableView<PlayerModel> tbvplayer;
    @FXML
    private Button btnadd;
    @FXML
    private Button btndelete;
    @FXML
    private Button btnupdate;
    @FXML
    private Button btnexit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showdata();
    }

    public void showdata() {
        ObservableList<PlayerModel> data = FXMLDocumentController.dtplayer.Load();
        if (data != null) {
            tbvplayer.getColumns().clear();
            tbvplayer.getItems().clear();
            TableColumn col = new TableColumn("PlayerID");
            col.setCellValueFactory(new PropertyValueFactory<PlayerModel, String>("PlayerID"));
            tbvplayer.getColumns().addAll(col);
            col = new TableColumn("Name");
            col.setCellValueFactory(new PropertyValueFactory<PlayerModel, String>("Name"));
            tbvplayer.getColumns().addAll(col);
            tbvplayer.setItems(data);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data is empty", ButtonType.OK);
            a.showAndWait();
            tbvplayer.getScene().getWindow().hide();
        }
    }

    @FXML
    private void addklik(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_InputPlayer.fxml"));
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
        PlayerModel s = new PlayerModel();
        s = tbvplayer.getSelectionModel().getSelectedItem();
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Delete this?", ButtonType.YES, ButtonType.NO);
        a.showAndWait();
        if (a.getResult() == ButtonType.YES) {
            if (FXMLDocumentController.dtplayer.delete(s.getPlayerID())) {
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
        PlayerModel s = new PlayerModel();
        s = tbvplayer.getSelectionModel().getSelectedItem();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_InputPlayer.fxml"));
            Parent root = (Parent) loader.load();
            FXML_InputPlayerController isidt = (FXML_InputPlayerController) loader.getController();
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
