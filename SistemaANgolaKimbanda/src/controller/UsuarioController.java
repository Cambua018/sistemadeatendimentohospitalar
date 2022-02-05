/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UsuarioDao;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mensagemDeAlerta.Notificacao;
import model.Usuario;

/**
 * FXML Controller class
 *
 * @author wanzambi
 */
public class UsuarioController implements Initializable {

    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button btnCadastrar;
    @FXML
    private Label lblLogar;
    @FXML
    private ImageView btnClose;
    @FXML
    private Label lblError;

    private final UsuarioDao usuarioDao = new UsuarioDao();

    @FXML
    private void logar(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    private void close(MouseEvent event) {
        btnClose.getScene().getWindow().hide();
    }
//METODO SALVAR

    public void cadastrar() {
        try {
            if (validateInputs()) {
                Usuario empresa = recebendoDadosFormulario();
                Usuario empresaSalvo = usuarioDao.merge(empresa);
                if (empresaSalvo != null) {
                    limparCampos();
                    Notificacao.msgNotificacaoConfimarSalvoUsuario();
                } else {
                    lblError.setText("Erro ao tentar salvo o registo");
                }
                //delayWindowClose(event);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//CAMPO OBRIGATORIO

    private boolean validateInputs() {
        if (txtUsuario.getText().equals("")) {
            lblError.setText("* O campo nome é obrigatório!");
            return false;
        }

        if (txtPassword.getText().equals("")) {
            lblError.setText("* O campo senha é obrigatório!");
            return false;
        }

        return true;
    }

    private Usuario recebendoDadosFormulario() {
        Usuario usuario = new Usuario();
        usuario.setNomeUsuario(txtUsuario.getText());
        usuario.setSenha(txtPassword.getText());
        return usuario;
    }
    //Limpar campos

    public void limparCampos() {
        txtUsuario.clear();
        txtPassword.clear();
        txtUsuario.requestFocus();
        //
        lblError.setText("");
    }

    boolean validFields() {
        return !txtUsuario.getText().isEmpty() && !txtPassword.getText().isEmpty();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //SALVAR
        btnCadastrar.setOnMouseClicked((MouseEvent e) -> {
            cadastrar();
        });
        btnCadastrar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                cadastrar();
            }
        });
    }

}
