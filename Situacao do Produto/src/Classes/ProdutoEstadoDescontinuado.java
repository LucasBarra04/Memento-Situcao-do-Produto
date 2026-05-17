package Classes;

public class ProdutoEstadoDescontinuado implements ProdutoEstado {
    private static ProdutoEstadoDescontinuado instance;

    private ProdutoEstadoDescontinuado() {}

    public static ProdutoEstadoDescontinuado getInstance() {
        if (instance == null)
            instance = new ProdutoEstadoDescontinuado();
        return instance;
    }

    @Override
    public String getNomeEstado() { return "Descontinuado"; }
}