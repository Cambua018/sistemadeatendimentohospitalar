/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import abrirFormulario.ListarPaciente;
import abrirFormulario.ListarRecepcao;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author wanzambi
 */
public class ListaRecepcionistasController implements Initializable {

    @FXML
    private Label lblPedidos;

    //ABRIR FORMUALRIO
    public void abrirFormularioListarPaciente() {
        ListarPaciente lp = new ListarPaciente();
        try {
            lp.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(ListaRecepcionistasController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //ABRIR FORMUALRIO
    public void abrirFormularioListarAtendimento() {
        ListarRecepcao lp = new ListarRecepcao();
        try {
            lp.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(ListaRecepcionistasController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void listarPacientes(MouseEvent event) {
        abrirFormularioListarPaciente();
    }

    @FXML
    private void listarAtendimeno(MouseEvent event) {
        abrirFormularioListarAtendimento();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
