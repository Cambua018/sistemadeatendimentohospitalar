package mensagemDeAlerta;

import javafx.geometry.Pos;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 *
 * @author tecnobase
 */
public class Notificacao {

    public static void msgNotificacao() {
        Notifications.create()
                .title("Erro Ao Entrar No Sistema")
                .text("Senha ou Usuário Inválido!")
                .hideAfter(Duration.seconds(2))
                .position(Pos.TOP_RIGHT)
                .showInformation();
    }

//CLIENTE
    public static void msgNotificacaoConfimarExclusaoCliente() {
        Notifications.create()
                .title("Atenção")
                .text("Cliente eliminado!")
                .hideAfter(Duration.seconds(2))
                .position(Pos.TOP_RIGHT)
                .showInformation();
    }

    public static void msgNotificacaoConfimarSalvoCliente() {
        Notifications.create()
                .title("Confirmação")
                .text("Cliente salvo com sucesso !")
                .hideAfter(Duration.seconds(2))
                .position(Pos.TOP_RIGHT)
                .showInformation();
    }

//EMPRESA
    public static void msgNotificacaoConfimarExclusaoEmpresa() {
        Notifications.create()
                .title("Atenção")
                .text("Empresa eliminado!")
                .hideAfter(Duration.seconds(2))
                .position(Pos.TOP_RIGHT)
                .showInformation();
    }

    public static void msgNotificacaoConfimarSalvoEmpresa() {
        Notifications.create()
                .title("Confirmação")
                .text("Empresa salvo com sucesso !")
                .hideAfter(Duration.seconds(2))
                .position(Pos.TOP_RIGHT)
                .showInformation();
    }
//EVENTO

    public static void msgNotificacaoConfimarExclusaoEvento() {
        Notifications.create()
                .title("Atenção")
                .text("Evento eliminado!")
                .hideAfter(Duration.seconds(2))
                .position(Pos.TOP_RIGHT)
                .showInformation();
    }

    public static void msgNotificacaoConfimarSalvoEvento() {
        Notifications.create()
                .title("Confirmação")
                .text("Evento salvo com sucesso !")
                .hideAfter(Duration.seconds(2))
                .position(Pos.TOP_RIGHT)
                .showInformation();
    }
//UNIDADE

    public static void msgNotificacaoConfimarExclusaoUnidade() {
        Notifications.create()
                .title("Atenção")
                .text("Unidade eliminado!")
                .hideAfter(Duration.seconds(2))
                .position(Pos.TOP_RIGHT)
                .showInformation();
    }

    public static void msgNotificacaoConfimarSalvoUnidade() {
        Notifications.create()
                .title("Confirmação")
                .text("Unidade salvo com sucesso !")
                .hideAfter(Duration.seconds(2))
                .position(Pos.TOP_RIGHT)
                .showInformation();
    }

//INGREDIENTE
    public static void msgNotificacaoConfimarExclusaoIngrediente() {
        Notifications.create()
                .title("Atenção")
                .text("Ingrediente eliminado!")
                .hideAfter(Duration.seconds(2))
                .position(Pos.TOP_RIGHT)
                .showInformation();
    }

    public static void msgNotificacaoConfimarSalvoIngrediente() {
        Notifications.create()
                .title("Confirmação")
                .text("Ingrediente salvo com sucesso !")
                .hideAfter(Duration.seconds(2))
                .position(Pos.TOP_RIGHT)
                .showInformation();
    }

    //USUARIO
    public static void msgNotificacaoConfimarExclusaoUsuario() {
        Notifications.create()
                .title("Atenção")
                .text("Usuário eliminado!")
                .hideAfter(Duration.seconds(2))
                .position(Pos.TOP_RIGHT)
                .showInformation();
    }

    public static void msgNotificacaoConfimarSalvoUsuario() {
        Notifications.create()
                .title("Confirmação")
                .text("Usuário salvo com sucesso !")
                .hideAfter(Duration.seconds(2))
                .position(Pos.TOP_RIGHT)
                .showInformation();
    }

    //PEDIDO 
    public static void msgNotificacaoConfimarExclusaoPedido() {
        Notifications.create()
                .title("Atenção")
                .text("Pedido eliminado!")
                .hideAfter(Duration.seconds(2))
                .position(Pos.TOP_RIGHT)
                .showInformation();
    }

    public static void msgNotificacaoConfimarSalvoPedido() {
        Notifications.create()
                .title("Confirmação")
                .text("Pedido salvo com sucesso !")
                .hideAfter(Duration.seconds(2))
                .position(Pos.TOP_RIGHT)
                .showInformation();
    }

    //PEDIDO 
    public static void msgNotificacaoConfimarExclusaoPedidoDetalhe() {
        Notifications.create()
                .title("Atenção")
                .text("Detalhes pedido eliminado!")
                .hideAfter(Duration.seconds(2))
                .position(Pos.TOP_RIGHT)
                .showInformation();
    }

    public static void msgNotificacaoConfimarSalvoPedidoDetalhe() {
        Notifications.create()
                .title("Confirmação")
                .text("Detalhes pedido salvo com sucesso !")
                .hideAfter(Duration.seconds(2))
                .position(Pos.TOP_RIGHT)
                .showInformation();
    }

    //MATERIAL CATEGORIA
    public static void msgNotificacaoConfimarExclusaoMaterialCategoria() {
        Notifications.create()
                .title("Atenção")
                .text("Material Categoria eliminado!")
                .hideAfter(Duration.seconds(2))
                .position(Pos.TOP_RIGHT)
                .showInformation();
    }

    public static void msgNotificacaoConfimarSalvoMaterialCategoria() {
        Notifications.create()
                .title("Confirmação")
                .text("Material Categoria salvo com sucesso !")
                .hideAfter(Duration.seconds(2))
                .position(Pos.TOP_RIGHT)
                .showInformation();
    }

    //LUCRO 
    public static void msgNotificacaoConfimarExclusaoLucro() {
        Notifications.create()
                .title("Atenção")
                .text("Lucro eliminado!")
                .hideAfter(Duration.seconds(2))
                .position(Pos.TOP_RIGHT)
                .showInformation();
    }

    public static void msgNotificacaoConfimarSalvoLucro() {
        Notifications.create()
                .title("Confirmação")
                .text("Lucro salvo com sucesso !")
                .hideAfter(Duration.seconds(2))
                .position(Pos.TOP_RIGHT)
                .showInformation();
    }

//
    
    
}
