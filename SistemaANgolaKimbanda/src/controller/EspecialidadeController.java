/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dao.EspecialidadeDao;
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
import model.Especialidade;

/**
 * FXML Controller class
 *
 * @author tecnobase
 */
public class EspecialidadeController implements Initializable {

    @FXML
    private Button btnCancelar;
    @FXML
    private Label lblError;
    @FXML
    private Label lblTriagem;
    @FXML
    private JFXTextField txtTemperatura;
    @FXML
    private JFXButton btnGuardar;

    private final EspecialidadeDao pacieteDao = new EspecialidadeDao();

    //METODO CADASTRAR
    private void cadastrar() {
        try {
            if (validateInputs()) {
                Especialidade especialidade = recebendoDadosFormulario();
                Especialidade especialidadeSalvo = pacieteDao.merge(especialidade);
                if (especialidadeSalvo != null) {
                    limparCampos();
                    Notificacao.msgNotificacaoConfimarSalvoEspecialidade();
                } else {
                    lblError.setText("Erro ao tentar salvar o especialidade");
                }
                //delayWindowClose(event);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//CAMPO OBRIGATORIO
    private boolean validateInputs() {
        if (txtTemperatura.getText().equals("")) {
            lblError.setText("* O campo nome é obrigatório!");
            return false;
        }
        return true;
    }

//Limpar campos
    public void limparCampos() {
        txtTemperatura.clear();
        //
        lblError.setText("");
    }

    private Especialidade recebendoDadosFormulario() throws ParseException {
        Especialidade especialidade = new Especialidade();

        especialidade.setNome(txtTemperatura.getText());

        return especialidade;
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
        // TODO
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
