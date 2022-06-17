package inatel.projeto.poo.tipos;

import inatel.projeto.poo.estoque.Estoque;
import inatel.projeto.poo.peça.Peça;

import java.util.Scanner;

public class Camiseta extends Peça implements Estoque {
    public Camiseta(float preco, String cor, String tamanho, String descriçao, String genero) {
        super(preco, cor, tamanho, descriçao, genero);
    }

    public Camiseta(){
        super();
    }

    @Override
    public Peça adicionarPeca() {

        Scanner option = new Scanner(System.in);

        System.out.println("Informe a descrição da camiseta: ");
        String descricao = option.next();

        System.out.println("Informe o tamanho da camiseta: ");
        String tamanho = option.next();

        System.out.println("informe o preço da camiseta: ");
        int preco = option.nextInt();

        System.out.println("Informe a cor da camiseta: ");
        String cor = option.next();

        System.out.println("Informe o gênero da camiseta: ");
        String genero = option.next();

        Camiseta camiseta = new Camiseta(preco,cor,tamanho,descricao, genero);

        return camiseta;
    }

    @Override
    public Peça[] venderPeca(int cont, Peça[] peca, int venda) {
        for(int k = venda--; k<cont;k++) {
            peca[k] = peca[k+1];
        }
        return peca;
    }

    @Override
    public Peça[] retirarEncomenda(int cont, Peça[] camiseta, int venda) {

        for(int k = venda-1; k < cont;k++) {
            camiseta[k] = camiseta[k+1];
            camiseta[k+1] = null;
        }
        return camiseta;
    }


}
