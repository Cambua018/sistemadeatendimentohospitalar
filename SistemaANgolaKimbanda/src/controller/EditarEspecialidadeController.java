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
import java.time.LocalDate;
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
 * @author wanzambi
 */
public class EditarEspecialidadeController implements Initializable {

    @FXML
    private Label lblId;
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

    private final EspecialidadeDao especialidadeDao = new EspecialidadeDao();
    private Especialidade especialidadeSelecionado;
    private Especialidade evto;
    private static Especialidade ev;

    @FXML
    private void fechar(MouseEvent event) {
        btnCancelar.getScene().getWindow().hide();
    }

    //Prence o formulario
    public void initEspecialidade() {
        lblId.setText(ev.getCodigo().toString());
        txtTemperatura.setText(ev.getNome());

    }

    //CADASTRAR EMPRESA
    private void actualizar() {
        try {
            if (validateInputs()) {
                Especialidade especialidade = recebendoDadosFormulario();
                Especialidade especialidadeSalvo = especialidadeDao.merge(especialidade);
                if (especialidadeSalvo != null) {
                    limparCampos();
                    Notificacao.msgNotificacaoConfimarSalvoEspecialidade();
                } else {
                    lblError.setText("Erro ao tentar actualizar o especialidade");
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
//Validacao do DESCRICAO

    //Limpar campos
    public void limparCampos() {
        txtTemperatura.clear();
        //
        lblError.setText("");
    }
//

    private Especialidade recebendoDadosFormulario() {
        Long id = Long.parseLong(lblId.getText());
        String nome = txtTemperatura.getText();

        Especialidade evnt = new Especialidade(id, nome);
        return evnt;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // TODO
//        lblEspecialidade.setText("Editar Especialidade");
        initEspecialidade();
        //
        btnGuardar.setOnMouseClicked((MouseEvent e) -> {
            actualizar();
        });

        btnGuardar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                actualizar();
            }
        });
    }

    public Especialidade getEspecialidadeSelecionado() {
        return especialidadeSelecionado;
    }

    public void setEspecialidadeSelecionado(Especialidade especialidadeSelecionado) {
        this.especialidadeSelecionado = especialidadeSelecionado;
    }

    public Especialidade getEvto() {
        return evto;
    }

    public void setEvto(Especialidade evto) {
        this.evto = evto;
    }

    public static Especialidade getEv() {
        return ev;
    }

    public static void setEv(Especialidade ev) {
        EditarEspecialidadeController.ev = ev;
    }

}
