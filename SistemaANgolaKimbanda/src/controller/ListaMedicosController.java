/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
public class ListaMedicosController implements Initializable {

    @FXML
    private Label lblPedidos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void listarPedidoMedicacao(MouseEvent event) {
    }

    @FXML
    private void listarAtendimentoPaciente(MouseEvent event) {
    }

    @FXML
    private void listaReceitas(MouseEvent event) {
    }
    
}
