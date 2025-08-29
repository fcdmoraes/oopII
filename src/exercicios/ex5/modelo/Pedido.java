package exercicios.ex5.modelo;

public class Pedido {
    private Integer id;
    private java.util.Date data;
    private java.util.List<ItemPedido> itens;

    public Pedido(Integer id, java.util.Date data) {
        this.id = id;
        this.data = data;
        this.itens = new java.util.ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public java.util.Date getData() {
        return data;
    }

    public void setData(java.util.Date data) {
        this.data = data;
    }

    public java.util.List<ItemPedido> getItens() {
        return itens;
    }

    public void adicionarItem(Produto produto, int quantidade) {
        this.itens.add(new ItemPedido(produto, quantidade));
    }

    public java.math.BigDecimal calcularTotal() {
        return itens.stream()
                .map(ItemPedido::getPrecoTotal)
                .reduce(java.math.BigDecimal.ZERO, java.math.BigDecimal::add);
    }
}
