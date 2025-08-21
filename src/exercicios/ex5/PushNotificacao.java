package exercicios.ex5;

public class PushNotificacao implements Notificacao{
    private String token;

    public PushNotificacao(String token) {
        this.token = token;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public void enviar(String mensagem) {

    }
}
