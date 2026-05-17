package Classes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProdutoMementoTest {

    @Test
    void produtoDeveIniciarComoDisponivel() {
        Produto p = new Produto();
        assertEquals("Disponivel", p.getEstado().getNomeEstado());
    }

    @Test
    void setEstadoDeveAlterarEstadoAtual() {
        Produto p = new Produto();
        p.setEstado(ProdutoEstadoReservado.getInstance());
        assertEquals("Reservado", p.getEstado().getNomeEstado());
    }

    @Test
    void setEstadoDeveSalvarNoHistorico() {
        Produto p = new Produto();
        p.setEstado(ProdutoEstadoEsgotado.getInstance());
        assertEquals(2, p.getEstados().size());
    }

    @Test
    void historicoDeveRegistrarTodosOsEstados() {
        Produto p = new Produto();
        p.setEstado(ProdutoEstadoReservado.getInstance());
        p.setEstado(ProdutoEstadoEsgotado.getInstance());
        p.setEstado(ProdutoEstadoEmReposicao.getInstance());

        assertEquals(4, p.getEstados().size());
        assertEquals("Disponivel",    p.getEstados().get(0).getNomeEstado());
        assertEquals("Reservado",     p.getEstados().get(1).getNomeEstado());
        assertEquals("Esgotado",      p.getEstados().get(2).getNomeEstado());
        assertEquals("Em Reposicao",  p.getEstados().get(3).getNomeEstado());
    }

    @Test
    void restaurarEstadoDeveVoltarAoIndiceCorreto() {
        Produto p = new Produto();
        p.setEstado(ProdutoEstadoReservado.getInstance());
        p.setEstado(ProdutoEstadoEsgotado.getInstance());

        p.restaurarEstado(0);
        assertEquals("Disponivel", p.getEstado().getNomeEstado());
    }

    @Test
    void restaurarUltimoEstadoSalvoDeveRetornarUltimo() {
        Produto p = new Produto();
        p.setEstado(ProdutoEstadoReservado.getInstance());
        p.setEstado(ProdutoEstadoEsgotado.getInstance());
        p.setEstado(ProdutoEstadoDescontinuado.getInstance());

        p.restaurarEstado(2);
        assertEquals("Esgotado", p.getEstado().getNomeEstado());
    }

    @Test
    void restaurarNaoDeveAlterarHistorico() {
        Produto p = new Produto();
        p.setEstado(ProdutoEstadoReservado.getInstance());
        p.setEstado(ProdutoEstadoEsgotado.getInstance());
        int tamanhoAntes = p.getEstados().size();

        p.restaurarEstado(0);
        assertEquals(tamanhoAntes, p.getEstados().size());
    }

    @Test
    void estadosSaoSingleton() {
        assertSame(ProdutoEstadoDisponivel.getInstance(),    ProdutoEstadoDisponivel.getInstance());
        assertSame(ProdutoEstadoReservado.getInstance(),     ProdutoEstadoReservado.getInstance());
        assertSame(ProdutoEstadoEsgotado.getInstance(),      ProdutoEstadoEsgotado.getInstance());
        assertSame(ProdutoEstadoDescontinuado.getInstance(), ProdutoEstadoDescontinuado.getInstance());
        assertSame(ProdutoEstadoEmReposicao.getInstance(),   ProdutoEstadoEmReposicao.getInstance());
    }
}