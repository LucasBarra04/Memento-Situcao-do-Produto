package Classes;

public class ProdutoEstadoDisponivel implements ProdutoEstado {
    private static ProdutoEstadoDisponivel instance;

    private ProdutoEstadoDisponivel() {}

    public static ProdutoEstadoDisponivel getInstance() {
        if (instance == null)
            instance = new ProdutoEstadoDisponivel();
        return instance;
    }

    @Override
    public String getNomeEstado() { return "Disponivel"; }
}