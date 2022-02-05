/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UsuarioDao;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Usuario;

/**
 * FXML Controller class
 *
 * @author wanzambi
 */
public class LoginController implements Initializable {

    @FXML
    private TextField txtUserName;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button btnEntrar;
    @FXML
    private Label lblError;
    @FXML
    private ImageView btnClose;
    
    private final UsuarioDao usuarioDao = new UsuarioDao();

    @FXML
    private void acessar(MouseEvent event) {
   try {
            if (!validFields()) {
                lblError.setText("Nome de Usuário e senha não podem estar vazias!");
                return;
            }

            if (!validateLogin()) {
                lblError.setText("Nome Usuário e ou senha incorreto!");
                return;
            }
            Parent root = FXMLLoader.load(getClass().getResource("/view/TelaPrincipal.fxml"));
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.setScene(new Scene(root));

        } catch (Exception e) {
        }
    }

    boolean validFields() {
        return !txtUserName.getText().isEmpty() && !txtPassword.getText().isEmpty();
    }

    private boolean validateLogin() {
        Usuario usuario = usuarioDao.buscaPorUsuários(txtUserName.getText(), txtPassword.getText());
        if (usuario == null) {
            return false;
        }
        return true;
    }

    @FXML
    private void close(MouseEvent event) {
         btnClose.getScene().getWindow().hide();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
