/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dao.ServicoDao;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import mensagemDeAlerta.Notificacao;
import model.Servico;

/**
 * FXML Controller class
 *
 * @author wanzambi
 */
public class ServicoController implements Initializable {

    @FXML
    private Button btnCancelar;
    @FXML
    private Label lblError;
    @FXML
    private Label lblPrioridade;
    @FXML
    private JFXTextField txtDescricao;
    @FXML
    private JFXButton btnGuardar;

    private final ServicoDao pacieteDao = new ServicoDao();

    //METODO CADASTRAR
    private void cadastrar() {
        try {
            if (validateInputs()) {
                Servico servico = recebendoDadosFormulario();
                Servico servicoSalvo = pacieteDao.merge(servico);
                if (servicoSalvo != null) {
                    limparCampos();
                    Notificacao.msgNotificacaoConfimarSalvoServico();
                } else {
                    lblError.setText("Erro ao tentar salvar o servico");
                }
                //delayWindowClose(event);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//CAMPO OBRIGATORIO
    private boolean validateInputs() {
        if (txtDescricao.getText().equals("")) {
            lblError.setText("* O campo nome é obrigatório!");
            return false;
        }
        return true;
    }

//Limpar campos
    public void limparCampos() {
        txtDescricao.clear();
        //
        lblError.setText("");
    }

    private Servico recebendoDadosFormulario() throws ParseException {
        Servico servico = new Servico();

        servico.setNome(txtDescricao.getText());

        return servico;
    }

    @FXML
    private void fechar(MouseEvent event) {
        btnCancelar.getScene().getWindow().hide();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //
        btnGuardar.setOnMouseClicked((MouseEvent e) -> {
            cadastrar();
        });

        btnGuardar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                cadastrar();
            }
        });
    }

}
