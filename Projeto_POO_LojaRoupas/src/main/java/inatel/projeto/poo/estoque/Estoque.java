package inatel.projeto.poo.estoque;

import inatel.projeto.poo.peça.Peça;

public interface Estoque {

    Peça adicionarPeca();

    Peça[] venderPeca(int cont, Peça[] calca, int venda);

    Peça[] retirarEncomenda(int cont, Peça[] calca, int venda);

}
