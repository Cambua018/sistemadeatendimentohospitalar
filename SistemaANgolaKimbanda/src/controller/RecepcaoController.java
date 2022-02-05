/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import dao.RecepcaoDao;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author wanzambi
 */
public class RecepcaoController implements Initializable {

    @FXML
    private Label Servico;
    @FXML
    private Button btnCancelar;
    @FXML
    private Label lblError;
    @FXML
    private Label lblPrioridade;
    @FXML
    private JFXButton btnGuardar;
    @FXML
    private JFXComboBox<?> cboPaciente;
    @FXML
    private JFXComboBox<?> cboPriodidade;
    @FXML
    private JFXCheckBox checEstado;

    //
    private final RecepcaoDao recepcaoDao = new RecepcaoDao();


    //Relecao PedidoDetalhe
//    private List<PedidoDetalhe> listaPedidoDetalhe;
//    private final PedidoDetalheDao pedidoDetalheDao = new PedidoDetalheDao();
//    private PedidoDetalhe pedidoDetalhe = new PedidoDetalhe();
//    //
//    private ObservableList<PedidoDetalhe> observableListPedidoDetalhe;

    @FXML
    private void fechar(MouseEvent event) {
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
