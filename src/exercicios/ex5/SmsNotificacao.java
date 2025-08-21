package exercicios.ex5;

public class SmsNotificacao implements Notificacao {
    private int telefone;

    public SmsNotificacao(int telefone) {
        this.telefone = telefone;
    }
    public int getTelefone() {
        return telefone;
    }
    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    @Override
    public void enviar(String mensagem) {

    }
}
