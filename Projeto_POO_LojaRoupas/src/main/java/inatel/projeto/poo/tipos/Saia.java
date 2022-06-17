package inatel.projeto.poo.tipos;

import inatel.projeto.poo.estoque.Estoque;
import inatel.projeto.poo.peça.Peça;

import java.util.Scanner;

public class Saia extends Peça implements Estoque {
    public Saia(float preco, String cor, String tamanho, String descriçao, String genero) {
        super(preco, cor, tamanho, descriçao, genero);
    }

    public Saia(){
        super();
    }

    @Override
    public Peça adicionarPeca() {

        Scanner option = new Scanner(System.in);

        System.out.println("Informe a descrição da saia: ");
        String descricao = option.next();

        System.out.println("Informe o tamanho da saia: ");
        String tamanho = option.next();

        System.out.println("informe o preço da saia: ");
        int preco = option.nextInt();

        System.out.println("Informe a cor da saia: ");
        String cor = option.next();

        System.out.println("Informe o gênero da saia: ");
        String genero = option.next();

        Saia saia = new Saia(preco,cor,tamanho,descricao, genero);

        return saia;
    }

    @Override
    public Peça[] venderPeca(int cont, Peça[] peca, int venda) {
        for(int k = venda--; k<cont;k++) {
            peca[k] = peca[k+1];
        }
        return peca;
    }

    @Override
    public Peça[] retirarEncomenda(int cont, Peça[] saia, int venda) {

        for(int k = venda-1; k < cont;k++) {
            saia[k] = saia[k+1];
            saia[k+1] = null;

        }
        return saia;
    }


}
