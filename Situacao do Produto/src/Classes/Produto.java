package Classes;

import java.util.ArrayList;
import java.util.List;

public class Produto {
    private ProdutoEstado estado;
    private List<ProdutoEstado> memento = new ArrayList<>();

    public Produto() {
        this.estado = ProdutoEstadoDisponivel.getInstance();
        memento.add(this.estado);
    }

    public void setEstado(ProdutoEstado estado) {
        this.estado = estado;
        memento.add(estado);
    }

    public ProdutoEstado getEstado() {
        return estado;
    }

    public void restaurarEstado(int indice) {
        this.estado = memento.get(indice);
    }

    public List<ProdutoEstado> getEstados() {
        return memento;
    }
}