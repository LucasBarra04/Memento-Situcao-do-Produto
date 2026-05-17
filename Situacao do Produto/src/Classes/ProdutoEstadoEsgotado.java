package Classes;

public class ProdutoEstadoEsgotado implements ProdutoEstado {
    private static ProdutoEstadoEsgotado instance;

    private ProdutoEstadoEsgotado() {}

    public static ProdutoEstadoEsgotado getInstance() {
        if (instance == null)
            instance = new ProdutoEstadoEsgotado();
        return instance;
    }

    @Override
    public String getNomeEstado() { return "Esgotado"; }
}