/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author wanzambi
 */
public class PacienteController implements Initializable {

    @FXML
    private JFXButton btnGuardar;
    @FXML
    private JFXTextField txtNome;
    @FXML
    private JFXTextField txtSobreNome;
    @FXML
    private JFXTextField txtEmail;
    @FXML
    private JFXTextField txtBI;
    @FXML
    private JFXTextField txtTelefone;
    @FXML
    private Label lblCliente;
    @FXML
    private Label lblError;
    @FXML
    private JFXButton btnCancelar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void fechar(MouseEvent event) {
    }
    
}
