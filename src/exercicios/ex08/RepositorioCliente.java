package exercicios.ex08;

public class RepositorioCliente extends RepositorioMemoria<Cliente> {
    @Override
    protected int getId(Cliente cliente){
        return cliente.getId();
    }
}
