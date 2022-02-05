/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import dao.PacienteDao;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import mensagemDeAlerta.Notificacao;
import model.Paciente;

/**
 * FXML Controller class
 *
 * @author tecnobase
 */
public class EditarPacienteController implements Initializable {

    @FXML
    private Button btnCancelar;
    @FXML
    private Label lblError;
    private Label lblPaciente;
    @FXML
    private JFXDatePicker dateNascimento;
    @FXML
    private JFXTextField txtEndereco;
    @FXML
    private JFXTextField txtTelefone;
    @FXML
    private JFXTextField txtSexo;
    @FXML
    private JFXTextField txtNome;
    @FXML
    private JFXButton btnGuardar;
    @FXML
    private JFXTextField txtEstadoCivil;

    //
    private final PacienteDao pacienteDao = new PacienteDao();
    private Paciente pacienteSelecionado;
    private Paciente evto;
    private static Paciente ev;
    @FXML
    private Label lblPciente;
    @FXML
    private Label lblId;

    @FXML
    private void fechar(MouseEvent event) {
        btnCancelar.getScene().getWindow().hide();
    }

    //Prence o formulario
    public void initPaciente() {
        lblId.setText(ev.getCodigo().toString());
        txtNome.setText(ev.getNome());
        txtSexo.setText(ev.getSexo());
        txtEstadoCivil.setText(ev.getEstadoCivil());
        txtEndereco.setText(ev.getEndereco());
        txtTelefone.setText(ev.getTelefone());

    }

//CADASTRAR EMPRESA
    private void actualizar() {
        try {
            if (validateInputs()) {
                Paciente paciente = recebendoDadosFormulario();
                Paciente pacienteSalvo = pacienteDao.merge(paciente);
                if (pacienteSalvo != null) {
                    limparCampos();
                    Notificacao.msgNotificacaoConfimarSalvoPaciente();
                } else {
                    lblError.setText("Erro ao tentar actualizar o paciente");
                }
                //delayWindowClose(event);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //CAMPO OBRIGATORIO
    private boolean validateInputs() {
        if (txtNome.getText().equals("")) {
            lblError.setText("* O campo nome é obrigatório!");
            return false;
        }
        return true;
    }
//Validacao do DESCRICAO

    //Limpar campos
    public void limparCampos() {
        txtNome.clear();
        //
        lblError.setText("");
    }
//

    private Paciente recebendoDadosFormulario() {
        Long id = Long.parseLong(lblId.getText());
        String nome = txtNome.getText();
        LocalDate dataDoPaciente = dateNascimento.getValue();
        ev.setDateNascimento(dataDoPaciente);
        String estadoCivil = txtEstadoCivil.getText();
        String sexo = txtSexo.getText();
        String endereco = txtEndereco.getText();
        String telefone = txtTelefone.getText();
//        Paciente evnt = new Paciente(id, nome, dataDoPaciente, estadoCivil, sexo, endereco, telefone);
        Paciente evnt = new Paciente(id, nome, dataDoPaciente, estadoCivil, sexo, endereco, telefone);
        return evnt;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        lblPaciente.setText("Editar Paciente");
        initPaciente();
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

    public Paciente getPacienteSelecionado() {
        return pacienteSelecionado;
    }

    public void setPacienteSelecionado(Paciente pacienteSelecionado) {
        this.pacienteSelecionado = pacienteSelecionado;
    }

    public Paciente getEvto() {
        return evto;
    }

    public void setEvto(Paciente evto) {
        this.evto = evto;
    }

    public static Paciente getEv() {
        return ev;
    }

    public static void setEv(Paciente ev) {
        EditarPacienteController.ev = ev;
    }

}
