package inatel.projeto.poo.tipos;

import inatel.projeto.poo.estoque.Estoque;
import inatel.projeto.poo.peça.Peça;

import java.util.Scanner;

public class Calça extends Peça implements Estoque {


    public Calça(float preco, String cor, String tamanho, String descriçao, String genero) {
        super(preco, cor, tamanho, descriçao, genero);
    }

    public Calça(){
        super();

    }

    @Override
    public Peça adicionarPeca() {

        Scanner option = new Scanner(System.in);

        System.out.println("Informe a descrição da calça: ");
        String descricao = option.next();

        System.out.println("Informe o tamanho da calça: ");
        String tamanho = option.next();

        System.out.println("informe o preço da calça: ");
        int preco = option.nextInt();

        System.out.println("Informe a cor da calça: ");
        String cor = option.next();

        System.out.println("Informe o gênero da calça: ");
        String genero = option.next();

        Calça calca = new Calça(preco,cor,tamanho,descricao, genero);

        return calca;

    }

    @Override
    public Peça[] venderPeca(int cont, Peça[] peca, int venda) {

        for(int k = venda-1; k < cont;k++) {
            peca[k] = peca[k+1];
            peca[k+1] = null;

        }
        return peca;

    }

    @Override
    public Peça[] retirarEncomenda(int cont, Peça[] calca, int venda) {

        for(int k = venda-1; k < cont;k++) {
            calca[k] = calca[k+1];
            calca[k+1] = null;

        }
        return calca;
    }



}
