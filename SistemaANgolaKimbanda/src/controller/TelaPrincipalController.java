/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author wanzambi
 */
public class TelaPrincipalController implements Initializable {

    @FXML
    private ImageView btnClose;
    @FXML
    private BorderPane painelPrincipal;
    @FXML
    private AnchorPane conteudoPrincipal;

    @FXML
    private void home(MouseEvent event) {
    }

    @FXML
    private void btnMaximizar(MouseEvent event) {
    }

    @FXML
    private void recepcionista(MouseEvent event) {
        carregarPaginas("/view/ListaRecepcionistas");
    }

    @FXML
    private void enfermagem(MouseEvent event) {
    }

    @FXML
    private void medicos(MouseEvent event) {
    }

    //
    //
    private void carregarPaginas(String pagina) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(pagina + ".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(TelaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        painelPrincipal.setCenter(root);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
