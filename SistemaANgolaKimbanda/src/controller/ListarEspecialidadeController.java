/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import abrirFormulario.CadastrarEspecialidade;
import abrirFormulario.EditarEspecialidade;
import dao.EspecialidadeDao;
import java.net.URL;
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
import model.Especialidade;

/**
 * FXML Controller class
 *
 * @author wanzambi
 */
public class ListarEspecialidadeController implements Initializable {

    @FXML
    private Button btnNovo;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnActualizar;
    @FXML
    private TableColumn<Especialidade, String> tbNome;
    @FXML
    private TextField txtPesquisar;

    private final EspecialidadeDao especialidadeDao = new EspecialidadeDao();
    private Especialidade especialidadeSelecionado;
    private Especialidade especialidade;
    @FXML
    private TableView<Especialidade> tbPaciente;

    //METODO APAGAR
    private void excluir() {
        if (especialidadeSelecionado != null) {
            especialidadeDao.excluir(especialidadeSelecionado);
            Notificacao.msgNotificacaoConfimarExclusaoEspecialidade();
            listartabela();
        } else {
            Alerta.msgErroExcluirNaTabela();
        }
    }

    //Carregar TABELA
    public void carregartabela() {
        tbNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    }

//Listar TABELA
    public void listartabela() {
        ObservableList<Especialidade> especialidades = FXCollections.observableArrayList();
        List<Especialidade> listasespecialidade = especialidadeDao.consultar(txtPesquisar.getText());
        for (Especialidade c : listasespecialidade) {
            especialidades.add(c);
        }
        tbPaciente.setItems(especialidades);
        tbPaciente.getSelectionModel().selectFirst();
    }

    @FXML
    private void filtrarRegistro(KeyEvent event) {
        listartabela();
    }

    public void abrirFormularioEspecialidade() {
        CadastrarEspecialidade pd = new CadastrarEspecialidade();
        try {
            pd.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(ListarEspecialidadeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregartabela();
        listartabela();
        //mostrardetalhes();
        //ABRIR NOVO
        btnNovo.setOnMouseClicked((MouseEvent e) -> {
            abrirFormularioEspecialidade();

        });

        btnNovo.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                abrirFormularioEspecialidade();

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
            if (especialidadeSelecionado != null) {
                EditarEspecialidade ent = new EditarEspecialidade(especialidadeSelecionado);
                try {
                    ent.start(new Stage());
                } catch (Exception ex) {
                    Logger.getLogger(ListarEspecialidadeController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                Alerta.msgComfimarDetalhe();
            }
        });
        //
        tbPaciente.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                especialidadeSelecionado = (Especialidade) newValue;
            }

        });
    }

    public Especialidade getEspecialidadeSelecionado() {
        return especialidadeSelecionado;
    }

    public void setEspecialidadeSelecionado(Especialidade especialidadeSelecionado) {
        this.especialidadeSelecionado = especialidadeSelecionado;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

}
