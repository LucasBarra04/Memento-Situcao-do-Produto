package Classes;

public class ProdutoEstadoReservado implements ProdutoEstado {
    private static ProdutoEstadoReservado instance;

    private ProdutoEstadoReservado() {}

    public static ProdutoEstadoReservado getInstance() {
        if (instance == null)
            instance = new ProdutoEstadoReservado();
        return instance;
    }

    @Override
    public String getNomeEstado() { return "Reservado"; }
}