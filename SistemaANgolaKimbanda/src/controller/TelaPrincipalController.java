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
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
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

      //
    static ButtonType btnSim = new ButtonType("Sim");
    static ButtonType btnNao = new ButtonType("Não");
    static boolean resposta;
    
    @FXML
    private void home(MouseEvent event) {
        painelPrincipal.setCenter(conteudoPrincipal);
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
        carregarPaginas("/view/ListaEnfermagem");
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
    //
    public static boolean confirmClose() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Sair do Sistema");
        alert.setContentText("Deseja sair no Sistema ?");
        alert.getButtonTypes().setAll(btnSim, btnNao);
        alert.showAndWait().ifPresent(b -> {
            if (b == btnSim) {
                Platform.exit();
                System.exit(0);
                resposta = true;
            } else {
                resposta = false;
            }
        });
        return resposta;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
