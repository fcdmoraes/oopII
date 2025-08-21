package exercicios.ex5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private static final Scanner scanner = new Scanner(System.in);
    private static List<Notificacao> notificadores;
    private static String mensagem;

    public static void executar() {
        GerenciadorDeNotificacoes gerenciador = new GerenciadorDeNotificacoes();
        notificadores = new ArrayList<>();
        mensagem = "";

        while (true) {
            menu();
            int opcao = lerOpcao();
            switch (opcao) {
                case 1:
                    criaNotificador();
                    break;
                case 2:
                    criaMensagem();
                    break;
                case 3:
                    gerenciador.setNotificadores(notificadores);
                    gerenciador.notificarTodos(mensagem);
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    public static int lerOpcao(){
        int opcao;
        while(true){
            try{
                opcao = Integer.parseInt(scanner.nextLine());
                break;
            }
            catch (NumberFormatException e){
                System.out.println("opção inválida");
            }
        }
        return opcao;
    }

    public static void criaNotificador(){
        while(true){
            menuNotificador();
            int opcao = lerOpcao();
            switch (opcao) {
                case 1:
                    System.out.println("Digite o email: ");
                    String email = scanner.nextLine();
                    notificadores.add(new EmailNotificacao(email));
                    return;
                case 2:
                    System.out.println("Digite o telefone: ");
                    int telefone = Integer.parseInt(scanner.nextLine());
                    notificadores.add(new SmsNotificacao(telefone));
                    return;
                case 3:
                    System.out.println("Digite o token: ");
                    String token = scanner.nextLine();
                    notificadores.add(new PushNotificacao(token));
                    return;
                default:
                    System.out.println("opção inválida");
            }
        }
    }

    public static void criaMensagem(){
        System.out.println("Digite a mensagem: ");
        mensagem = scanner.nextLine();
    }

    public static void menu(){
        System.out.println("Selecione uma opção");
        System.out.println("1 - Cria notificador");
        System.out.println("2 - Cria mensagem");
        System.out.println("3 - Envia notificação");
        System.out.println("0 - Exit");
    }

    public static void menuNotificador(){
        System.out.println("Escolha o canal de notificação:");
        System.out.println("1 - Email");
        System.out.println("2 - SMS");
        System.out.println("3 - Push");
    }
}


