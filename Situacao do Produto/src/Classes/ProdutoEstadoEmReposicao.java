package Classes;

public class ProdutoEstadoEmReposicao implements ProdutoEstado {
    private static ProdutoEstadoEmReposicao instance;

    private ProdutoEstadoEmReposicao() {}

    public static ProdutoEstadoEmReposicao getInstance() {
        if (instance == null)
            instance = new ProdutoEstadoEmReposicao();
        return instance;
    }

    @Override
    public String getNomeEstado() { return "Em Reposicao"; }
}