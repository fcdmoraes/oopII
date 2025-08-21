package exercicios.ex5;

import java.util.List;

public class GerenciadorDeNotificacoes {
    private List<Notificacao> notificadores;

    public GerenciadorDeNotificacoes(){}

    public GerenciadorDeNotificacoes(List<Notificacao> notificadores) {
        this.notificadores = notificadores;
    }

    public List<Notificacao> getNotificadores() {
        return notificadores;
    }
    public void setNotificadores(List<Notificacao> notificadores) {
        this.notificadores = notificadores;
    }

    public void notificarTodos(String mensagem) {
        for (Notificacao n : notificadores) {
            n.enviar(mensagem);
        }
    }
}
