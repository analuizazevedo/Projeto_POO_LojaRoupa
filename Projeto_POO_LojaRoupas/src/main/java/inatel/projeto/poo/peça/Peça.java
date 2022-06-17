package inatel.projeto.poo.peça;

public abstract class Peça{

    private float preco;
    private String cor;
    private String tamanho;
    private String descricao;
    private String genero;


    public Peça(float preco, String cor, String tamanho, String descriçao, String genero){
        this.preco = preco;
        this.cor = cor;
        this.tamanho = tamanho;
        this.descricao = descriçao;
        this.genero = genero;
    }

    public Peça() {

    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getGenero() {
        return genero;
    }
}
