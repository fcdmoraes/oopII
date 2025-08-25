package exercicios.ex08;

import java.util.List;

public abstract class RepositorioMemoria<T> implements Repositorio<T> {
    List<T> lista = new java.util.ArrayList<>();

    @Override
    public void salvar(T obj) {
        lista.add(obj);
    }

    @Override
    public T buscarPorId(int id) {
        for (T obj : lista) {
            if (getId(obj) == id) {
                return obj;
            }
        }
        return null;
    }

    @Override
    public List<T> listarTodos() {
        return lista;
    }

    protected abstract int getId(T obj);
}
