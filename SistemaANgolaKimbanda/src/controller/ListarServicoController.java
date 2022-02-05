/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import abrirFormulario.CadastrarServico;
import abrirFormulario.EditarEspecialidade;
import dao.ServicoDao;
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
import model.Servico;
import model.Servico;

/**
 * FXML Controller class
 *
 * @author wanzambi
 */
public class ListarServicoController implements Initializable {

    @FXML
    private Button btnNovo;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnActualizar;
    @FXML
    private TableView<Servico> tbPaciente;
    @FXML
    private TableColumn<Servico, String> tbNome;
    @FXML
    private TextField txtPesquisar;

    private final ServicoDao servicoDao = new ServicoDao();
    private Servico servicoSelecionado;
    private Servico servico;

//METODO APAGAR
    private void excluir() {
        if (servicoSelecionado != null) {
            servicoDao.excluir(servicoSelecionado);
            Notificacao.msgNotificacaoConfimarExclusaoServico();
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
        ObservableList<Servico> servicos = FXCollections.observableArrayList();
        List<Servico> listasservico = servicoDao.consultar(txtPesquisar.getText());
        for (Servico c : listasservico) {
            servicos.add(c);
        }
        tbPaciente.setItems(servicos);
        tbPaciente.getSelectionModel().selectFirst();
    }

    @FXML
    private void filtrarRegistro(KeyEvent event) {
        listartabela();
    }

    public void abrirFormularioServico() {
        CadastrarServico pd = new CadastrarServico();
        try {
            pd.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(ListarServicoController.class.getName()).log(Level.SEVERE, null, ex);
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
            abrirFormularioServico();

        });

        btnNovo.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                abrirFormularioServico();

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
//            if (especialidadeSelecionado != null) {
//                EditarEspecialidade ent = new EditarEspecialidade(especialidadeSelecionado);
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
                servicoSelecionado = (Servico) newValue;
            }

        });
    }

    public Servico getServicoSelecionado() {
        return servicoSelecionado;
    }

    public void setServicoSelecionado(Servico servicoSelecionado) {
        this.servicoSelecionado = servicoSelecionado;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

}
