package inatel.projeto.poo.tipos;

import inatel.projeto.poo.estoque.Estoque;
import inatel.projeto.poo.peça.Peça;

import java.util.Scanner;

public class Vestido extends Peça implements Estoque{
    public Vestido(float preco, String cor, String tamanho, String descriçao, String genero) {
        super(preco, cor, tamanho, descriçao, genero);
    }

    public Vestido(){
        super();
    }

    @Override
    public Peça adicionarPeca() {
        Scanner option = new Scanner(System.in);

        System.out.println("Informe a descrição do vestido: ");
        String descricao = option.next();

        System.out.println("Informe o tamanho da vestido: ");
        String tamanho = option.next();

        System.out.println("informe o preço da vestido: ");
        int preco = option.nextInt();

        System.out.println("Informe a cor da vestido: ");
        String cor = option.next();

        System.out.println("Informe o gênero do vestido: ");
        String genero = option.next();

        Vestido vestido = new Vestido(preco,cor,tamanho,descricao, genero);

        return vestido;
    }

    @Override
    public Peça[] venderPeca(int cont, Peça[] peca, int venda) {
        for(int k = venda--; k<cont;k++) {
            peca[k] = peca[k+1];
        }
        return peca;
    }

    @Override
    public Peça[] retirarEncomenda(int cont, Peça[] vestido, int venda) {

        for(int k = venda-1; k < cont;k++) {
            vestido[k] = vestido[k+1];
            vestido[k+1] = null;

        }
        return vestido;
    }


}
