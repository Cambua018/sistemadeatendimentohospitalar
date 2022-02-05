package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import dao.PacienteDao;
import java.net.URL;
import java.text.ParseException;
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
 * @author wanzambi
 */
public class PacienteController implements Initializable {

    @FXML
    private JFXButton btnGuardar;
    @FXML
    private JFXTextField txtNome;
    @FXML
    private JFXTextField txtTelefone;
    @FXML
    private Label lblError;
    @FXML
    private Button btnCancelar;
    @FXML
    private JFXDatePicker dateNascimento;
    @FXML
    private JFXTextField txtEndereco;
    @FXML
    private JFXTextField txtSexo;
    @FXML
    private JFXTextField txtEstadoCivil;

    //
    private final PacienteDao pacieteDao = new PacienteDao();
    //
    @FXML
    private Label lblEvento;

    //METODO CADASTRAR
    private void cadastrar() {
        try {
            if (validateInputs()) {
                Paciente paciente = recebendoDadosFormulario();
                Paciente pacienteSalvo = pacieteDao.merge(paciente);
                if (pacienteSalvo != null) {
                    limparCampos();
                    Notificacao.msgNotificacaoConfimarSalvoPaciente();
                } else {
                    lblError.setText("Erro ao tentar salvar o paciente");
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

        if (txtSexo.getText().equals("")) {
            lblError.setText("* O campo sexo obrigatório!");
            return false;
        }
        if (txtTelefone.getText().equals("")) {
            lblError.setText("* O campo telefone é obrigatório!");
            return false;
        }
        return true;
    }

//Limpar campos
    public void limparCampos() {
        txtNome.clear();
        txtSexo.clear();
        txtTelefone.clear();
        txtEndereco.clear();
        //
        lblError.setText("");
    }

    private Paciente recebendoDadosFormulario() throws ParseException {
        Paciente paciente = new Paciente();

        paciente.setNome(txtNome.getText());
        paciente.setSexo(txtSexo.getText());
        paciente.setEndereco(txtEndereco.getText());
        paciente.setEstadoCivil(txtEstadoCivil.getText());
        paciente.setTelefone(txtTelefone.getText());

        LocalDate dataDoPaciente = dateNascimento.getValue();
        paciente.setDateNascimento(dataDoPaciente);

        return paciente;
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
