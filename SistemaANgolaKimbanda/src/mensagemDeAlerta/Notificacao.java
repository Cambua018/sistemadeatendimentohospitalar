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
    public static void msgNotificacaoConfimarExclusaoPaciente() {
        Notifications.create()
                .title("Atenção")
                .text("Cliente eliminado!")
                .hideAfter(Duration.seconds(2))
                .position(Pos.TOP_RIGHT)
                .showInformation();
    }

    public static void msgNotificacaoConfimarSalvoPaciente() {
        Notifications.create()
                .title("Confirmação")
                .text("Cliente salvo com sucesso !")
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
    //CLIENTE

    public static void msgNotificacaoConfimarExclusaoEspecialidade() {
        Notifications.create()
                .title("Atenção")
                .text("Especialidade eliminado!")
                .hideAfter(Duration.seconds(2))
                .position(Pos.TOP_RIGHT)
                .showInformation();
    }

    public static void msgNotificacaoConfimarSalvoEspecialidade() {
        Notifications.create()
                .title("Confirmação")
                .text("Especialidade salvo com sucesso !")
                .hideAfter(Duration.seconds(2))
                .position(Pos.TOP_RIGHT)
                .showInformation();
    }
//SERVICO

    public static void msgNotificacaoConfimarExclusaoServico() {
        Notifications.create()
                .title("Atenção")
                .text("Servico eliminado!")
                .hideAfter(Duration.seconds(2))
                .position(Pos.TOP_RIGHT)
                .showInformation();
    }

    public static void msgNotificacaoConfimarSalvoServico() {
        Notifications.create()
                .title("Confirmação")
                .text("Servico salvo com sucesso !")
                .hideAfter(Duration.seconds(2))
                .position(Pos.TOP_RIGHT)
                .showInformation();
    }

    //SERVICO
    public static void msgNotificacaoConfimarExclusaoPrioridade() {
        Notifications.create()
                .title("Atenção")
                .text("Prioridade eliminado!")
                .hideAfter(Duration.seconds(2))
                .position(Pos.TOP_RIGHT)
                .showInformation();
    }

    public static void msgNotificacaoConfimarSalvoPrioridade() {
        Notifications.create()
                .title("Confirmação")
                .text("Prioridade salvo com sucesso !")
                .hideAfter(Duration.seconds(2))
                .position(Pos.TOP_RIGHT)
                .showInformation();
    }

}
