/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensagemDeAlerta;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 *
 * @author tecnobase
 */
public class Alerta {

    static ButtonType btnConfirmar = new ButtonType("Confirmar");
    static ButtonType btnCancelar = new ButtonType("Cancelar");
    static ButtonType btnOk = new ButtonType("Ok");
    static ButtonType btnYES = new ButtonType("Sim");
    static ButtonType btnNO = new ButtonType("Não");
    static boolean resposta;

    public static void msgInformacao(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Informacao sobre cadastro");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    //ESTE PEGA O NOME DO REGISTRO QUE SERA ELIMINADO
    public static boolean msgConfirmacaoExcluisao(String msgExclusao) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Excluisao de registro");
        alert.setContentText("Deseja excluir o registro: " + msgExclusao + "?");
        alert.getButtonTypes().setAll(btnConfirmar, btnCancelar);
        alert.showAndWait().ifPresent(b -> {
            if (b == btnConfirmar) {
                resposta = true;
            } else {
                resposta = false;
            }
        });
        return resposta;
    }

//CONFIRMACAO DE ALTERAR
    public static boolean msgComfimarAlterar() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Atenção");
        alert.setHeaderText("Nenhum registro selecionado !");
        alert.setContentText("Selecione um registro que deseja editar.");
        alert.getButtonTypes().setAll(btnOk);
        alert.showAndWait().ifPresent(b -> {
            if (b == btnOk) {
                resposta = true;
            }
        });
        return resposta;
    }
//VER DETALHES

    public static boolean msgComfimarDetalhe() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Atenção");
        alert.setHeaderText("Nenhum registro selecionado !");
        alert.setContentText("Selecione um registro que deseja ver.");
        alert.getButtonTypes().setAll(btnOk);
        alert.showAndWait().ifPresent(b -> {
            if (b == btnOk) {
                resposta = true;
            }
        });
        return resposta;
    }

//CONFIRMACAO DE DELETAR
    public static boolean msgErroExcluirNaTabela() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Atenção");
        alert.setHeaderText("Deseja apagar o registro ?");
        alert.setContentText("Selecione um registro que deseja excluir.");
        alert.getButtonTypes().setAll(btnOk);
        alert.showAndWait().ifPresent(b -> {
            if (b == btnOk) {
                resposta = true;
            }
        });
        return resposta;
    }

    //ERRO AO LOGAR
    public static boolean msgErroAoLogar() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Erro Ao Entrar No Sistema");
        alert.setContentText("Senha ou Usuário Inválido!");
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        alert.getButtonTypes().setAll(btnOk);
        alert.showAndWait().ifPresent(b -> {
            if (b == btnOk) {
                resposta = true;
            }
        });
        return resposta;
    }

    //PODE PODE APAGAR ENQUANTO NAO FOR PAGO
    public static boolean msgErroPagar() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Erro Ao Entrar No Sistema");
        alert.setContentText("Pedido ja foi pago e nao pdode ser excluido!");
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        alert.getButtonTypes().setAll(btnOk);
        alert.showAndWait().ifPresent(b -> {
            if (b == btnOk) {
                resposta = true;
            }
        });
        return resposta;
    }

    //IMPRIMIR TODOS
    public static boolean msgComfimarImprimirTodos() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Imprimir todos os pedidos");
        alert.setContentText("Confirma a impressão!");
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        alert.getButtonTypes().setAll(btnOk);
        alert.showAndWait().ifPresent(b -> {
            if (b == btnOk) {
                resposta = true;
            }
        });
        return resposta;
    }
    
//CONFIRMACAO DE POR CODIGO
    public static boolean msgComfimarImprimirPorCodigo() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Atenção");
        alert.setHeaderText("Deseja imprimir o registro ?");
        alert.setContentText("Selecione um registro que deseja imprimir.");
        alert.getButtonTypes().setAll(btnOk);
        alert.showAndWait().ifPresent(b -> {
            if (b == btnOk) {
                resposta = true;
            }
        });
        return resposta;
    }
}
