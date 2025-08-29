package exercicios.ex5.pagamento;

public class PagamentoPix implements Pagamento {
    private final String qrCode;

    public PagamentoPix() {
        this.qrCode = "00";

    }

    @Override
    public boolean pagar(java.math.BigDecimal valor) {
        return true;
    }

}
