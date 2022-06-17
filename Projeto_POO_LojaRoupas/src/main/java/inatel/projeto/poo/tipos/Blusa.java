package inatel.projeto.poo.tipos;

import inatel.projeto.poo.estoque.Estoque;
import inatel.projeto.poo.peça.Peça;

import java.util.Scanner;

public class Blusa extends Peça implements Estoque {
    public Blusa(float preco, String cor, String tamanho, String descriçao, String genero) {
        super(preco, cor, tamanho, descriçao, genero);
    }

    public Blusa(){
        super();
    }

    @Override
    public Peça adicionarPeca() {
        Scanner option = new Scanner(System.in);

        System.out.println("Informe a descrição da blusa: ");
        String descricao = option.next();

        System.out.println("Informe o tamanho da blusa: ");
        String tamanho = option.next();

        System.out.println("informe o preço da blusa: ");
        int preco = option.nextInt();

        System.out.println("Informe a cor da blusa: ");
        String cor = option.next();

        System.out.println("Informe o gênero da blusa: ");
        String genero = option.next();


        Blusa blusa = new Blusa(preco,cor,tamanho,descricao, genero);

        return blusa;
    }

    @Override
    public Peça[] venderPeca(int cont, Peça[] peca, int venda) {
        for(int k = venda--; k<cont;k++) {
            peca[k] = peca[k+1];
        }
        return peca;
    }

    @Override
    public Peça[] retirarEncomenda(int cont, Peça[] blusa, int venda) {

        for(int k = venda-1; k < cont;k++) {
            blusa[k] = blusa[k+1];
            blusa[k+1] = null;

        }
        return blusa;
    }


}
