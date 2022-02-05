/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import abrirFormulario.CadastrarPaciente;
import abrirFormulario.EditarPaciente;
import dao.PacienteDao;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mensagemDeAlerta.Alerta;
import mensagemDeAlerta.Notificacao;
import model.Paciente;

/**
 * FXML Controller class
 *
 * @author tecnobase
 */
public class ListaPacienteController implements Initializable {

    @FXML
    private Button btnNovo;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnActualizar;
    @FXML
    private TableView<Paciente> tbPaciente;
    @FXML
    private TableColumn<Paciente, String> tbNome;
    @FXML
    private TableColumn<Paciente, LocalDate> tbdataNascimento;
    @FXML
    private TableColumn<Paciente, String> tbEstadoCivil;
    @FXML
    private TableColumn<Paciente, String> tbSexo;
    @FXML
    private TableColumn<Paciente, String> tbEndereco;
    @FXML
    private TableColumn<Paciente, String> tbTelefone;
    @FXML
    private TextField txtPesquisar;

    private final PacienteDao pacienteDao = new PacienteDao();
    private Paciente pacienteSelecionado;
    private Paciente paciente;

    //METODO APAGAR
    private void excluir() {
        if (pacienteSelecionado != null) {
            pacienteDao.excluir(pacienteSelecionado);
            Notificacao.msgNotificacaoConfimarExclusaoPaciente();
            listartabela();
        } else {
            Alerta.msgErroExcluirNaTabela();
        }
    }

    //Carregar TABELA
    public void carregartabela() {
        tbNome.setCellValueFactory(new PropertyValueFactory<>("localizacao"));
        tbdataNascimento.setCellValueFactory(new PropertyValueFactory<>("dateNascimento"));
        tbEstadoCivil.setCellValueFactory(new PropertyValueFactory<>("estadoCivil"));
        tbSexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));
        tbEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        tbTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
    }

//Listar TABELA
    public void listartabela() {
        ObservableList<Paciente> pacientes = FXCollections.observableArrayList();
        List<Paciente> listaspaciente = pacienteDao.consultar(txtPesquisar.getText());
        for (Paciente c : listaspaciente) {
            pacientes.add(c);
        }
        tbPaciente.setItems(pacientes);
        tbPaciente.getSelectionModel().selectFirst();
    }

    @FXML
    private void filtrarRegistro(KeyEvent event) {
        listartabela();
    }

    public void abrirFormularioPaciente() {
        CadastrarPaciente pd = new CadastrarPaciente();
        try {
            pd.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(ListaPacienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // TODO
        carregartabela();
        listartabela();
        //mostrardetalhes();
        //ABRIR NOVO
        btnNovo.setOnMouseClicked((MouseEvent e) -> {
            abrirFormularioPaciente();

        });

        btnNovo.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                abrirFormularioPaciente();

            }
        });

        //ELIMINAR
        btnEliminar.setOnMouseClicked((MouseEvent e) -> {
            excluir();

        });

        btnEliminar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                excluir();

            }
        });
        //ABRIR DetalhesPedido
        btnActualizar.setOnMouseClicked((MouseEvent e) -> {
            if (pacienteSelecionado != null) {
                EditarPaciente ent = new EditarPaciente(pacienteSelecionado);
                try {
                    ent.start(new Stage());
                } catch (Exception ex) {
                    Logger.getLogger(ListaPacienteController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                Alerta.msgComfimarDetalhe();
            }
        });
        //
        tbPaciente.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                pacienteSelecionado = (Paciente) newValue;
            }

        });

    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Paciente getPacienteSelecionado() {
        return pacienteSelecionado;
    }

    public void setPacienteSelecionado(Paciente pacienteSelecionado) {
        this.pacienteSelecionado = pacienteSelecionado;
    }

}
