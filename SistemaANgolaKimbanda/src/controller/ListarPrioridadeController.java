/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import abrirFormulario.CadastrarPrioridade;
import abrirFormulario.EditarEspecialidade;
import dao.PrioridadeDao;
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
import model.Prioridade;

/**
 * FXML Controller class
 *
 * @author wanzambi
 */
public class ListarPrioridadeController implements Initializable {

    @FXML
    private Button btnNovo;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnActualizar;
    @FXML
    private TableView<Prioridade> tbPaciente;
    @FXML
    private TableColumn<Prioridade, String> tbNome;
    @FXML
    private TextField txtPesquisar;

    private final PrioridadeDao prioridadeDao = new PrioridadeDao();
    private Prioridade prioridadeSelecionado;
    private Prioridade prioridade;

    //METODO APAGAR
    private void excluir() {
        if (prioridadeSelecionado != null) {
            prioridadeDao.excluir(prioridadeSelecionado);
            Notificacao.msgNotificacaoConfimarExclusaoPrioridade();
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
        ObservableList<Prioridade> prioridades = FXCollections.observableArrayList();
        List<Prioridade> listasprioridade = prioridadeDao.consultar(txtPesquisar.getText());
        for (Prioridade c : listasprioridade) {
            prioridades.add(c);
        }
        tbPaciente.setItems(prioridades);
        tbPaciente.getSelectionModel().selectFirst();
    }

    @FXML
    private void filtrarRegistro(KeyEvent event) {
        listartabela();
    }

    public void abrirFormularioPrioridade() {
        CadastrarPrioridade pd = new CadastrarPrioridade();
        try {
            pd.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(ListarPrioridadeController.class.getName()).log(Level.SEVERE, null, ex);
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
            abrirFormularioPrioridade();

        });

        btnNovo.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                abrirFormularioPrioridade();

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
//        btnActualizar.setOnMouseClicked((MouseEvent e) -> {
//            if (prioridadeSelecionado != null) {
//                EditarEspecialidade ent = new EditarEspecialidade(prioridadeSelecionado);
//                try {
//                    ent.start(new Stage());
//                } catch (Exception ex) {
//                    Logger.getLogger(ListarEspecialidadeController.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            } else {
//                Alerta.msgComfimarDetalhe();
//            }
//        });
        //
        tbPaciente.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                prioridadeSelecionado = (Prioridade) newValue;
            }

        });
    }

    public Prioridade getPrioridadeSelecionado() {
        return prioridadeSelecionado;
    }

    public void setPrioridadeSelecionado(Prioridade prioridadeSelecionado) {
        this.prioridadeSelecionado = prioridadeSelecionado;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

}
