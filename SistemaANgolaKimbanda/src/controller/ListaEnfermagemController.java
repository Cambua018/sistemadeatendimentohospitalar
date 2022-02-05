/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import abrirFormulario.ListarEspecialidade;
import abrirFormulario.ListarMedico;
import abrirFormulario.ListarPaciente;
import abrirFormulario.ListarPrioridade;
import abrirFormulario.ListarRecepcao;
import abrirFormulario.ListarServico;
import abrirFormulario.ListarTriagem;
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
public class ListaEnfermagemController implements Initializable {

    @FXML
    private Label lblPedidos;

    //ABRIR FORMUALRIO
    public void abrirFormularioListarPrioridade() {
        ListarPrioridade lp = new ListarPrioridade();
        try {
            lp.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(ListaEnfermagemController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //ABRIR FORMUALRIO
    public void abrirFormularioListarEspecialidade() {
        ListarEspecialidade lp = new ListarEspecialidade();
        try {
            lp.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(ListaEnfermagemController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //ABRIR FORMUALRIO
    public void abrirFormularioListarServico() {
        ListarServico lp = new ListarServico();
        try {
            lp.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(ListaEnfermagemController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //ABRIR FORMUALRIO
    public void abrirFormularioListarTriagem() {
        ListarTriagem lp = new ListarTriagem();
        try {
            lp.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(ListaEnfermagemController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //ABRIR FORMUALRIO
    public void abrirFormularioListarMedico() {
        ListarMedico lp = new ListarMedico();
        try {
            lp.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(ListaEnfermagemController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void listarPrioridade(MouseEvent event) {
        abrirFormularioListarPrioridade();
    }

    @FXML
    private void listarEspecialidade(MouseEvent event) {
        abrirFormularioListarEspecialidade();
    }

    @FXML
    private void listarServico(MouseEvent event) {
        abrirFormularioListarServico();
    }

    @FXML
    private void listarTriagem(MouseEvent event) {
        abrirFormularioListarTriagem();
    }

    @FXML
    private void listarMedico(MouseEvent event) {
        abrirFormularioListarMedico();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
