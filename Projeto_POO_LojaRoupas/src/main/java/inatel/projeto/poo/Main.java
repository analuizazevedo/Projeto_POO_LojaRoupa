package inatel.projeto.poo;

import inatel.projeto.poo.peça.Peça;
import inatel.projeto.poo.tipos.Camiseta;
import inatel.projeto.poo.tipos.Blusa;
import inatel.projeto.poo.tipos.Vestido;
import inatel.projeto.poo.tipos.Saia;
import inatel.projeto.poo.tipos.Calça;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Calça[] calca = new Calça[100];
        Blusa[] blusas = new Blusa[100];
        Vestido[] vestido = new Vestido[100];
        Saia[] saia = new Saia[100];
        Camiseta[] camiseta = new Camiseta[100];

        Calça calcaNova = new Calça();
        Blusa blusaNova = new Blusa();
        Vestido vestidoNovo = new Vestido();
        Saia saiaNova = new Saia();
        Camiseta camisetaNova = new Camiseta();

        Calça[] calcaAux = new Calça[100];
        Blusa[] blusaAux = new Blusa[100];
        Vestido[] vestidoAux = new Vestido[100];
        Saia[] saiaAux = new Saia[100];
        Camiseta[] camisetaAux = new Camiseta[100];

        Calça[] calcaEncomenda = new Calça[100];
        Blusa[] blusaEncomenda = new Blusa[100];
        Vestido[] vestidoEncomenda = new Vestido[100];
        Saia[] saiaEncomenda = new Saia[100];
        Camiseta[] camisetaEncomenda = new Camiseta[100];

        int cont1 = 0;
        int cont2 = 0;
        int cont3 = 0;
        int cont4 = 0;
        int cont5 = 0;

        int contEnc1 = 0;
        int contEnc2 = 0;
        int contEnc3 = 0;
        int contEnc4 = 0;
        int contEnc5 = 0;

        int time = 1;
        int x;
        Scanner opcao = new Scanner(System.in);


        while (time == 1) {

            System.out.println("Selecione a operação que deseja realizar: \n");
            System.out.println("[1] Adicionar peça(s) ao estoque");
            System.out.println("[2] Vender peça(s) do estoque");
            System.out.println("[3] Realizar encomenda");
            System.out.println("[4] Cancelar encomenda");
            System.out.println("[5] Mostrar estoque \n");

            try {

                switch (x = opcao.nextInt()) {

                    case 1:
                        int continua = 1;
                        while (continua == 1) {
                            System.out.println("Qual peça deseja adicionar?");
                            System.out.println("[1] Calça [2] Blusa [3] Saia [4] Vestido [5] Camiseta [6] Cancelar");
                            int tipo = opcao.nextInt();

                            try {
                                switch (tipo) {

                                    case 1:
                                        calca[cont1] = (Calça) calcaNova.adicionarPeca();
                                        cont1++;
                                        break;

                                    case 2:
                                        blusas[cont2] = (Blusa) blusaNova.adicionarPeca();
                                        cont2++;
                                        break;

                                    case 3:
                                        saia[cont3] = (Saia) saiaNova.adicionarPeca();
                                        cont3++;
                                        break;

                                    case 4:
                                        vestido[cont4] = (Vestido) vestidoNovo.adicionarPeca();
                                        cont4++;
                                        break;

                                    case 5:
                                        camiseta[cont5] = (Camiseta) camisetaNova.adicionarPeca();
                                        cont5++;
                                        break;
                                    case 6:
                                        System.out.println("Ação cancelada \n");
                                        break;
                                    default:
                                        System.out.println("Opção inválida. Tente novamente \n");
                                        break;

                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Apenas números. Tente novamente");
                            }

                            System.out.println("Deseja acrescentar mais uma peça?");
                            System.out.println("[1] Sim  [0] Não");

                            if (opcao.nextInt() == 0) {
                                continua = 0;
                            }

                        }
                        break;

                    case 2:
                        int continua2 = 1;
                        while (continua2 == 1) {
                            System.out.println("Qual das peças abaixo você deseja vender: ");
                            System.out.println("[1] Calça [2] Blusa [3] Saia [4] Vestido [5] Camiseta [6] Cancelar");
                            int tipo2 = opcao.nextInt();

                            try {
                                switch (tipo2) {

                                    case 1:
                                        if (cont1 > 0) {

                                            try {
                                                System.out.println("Selecione qual das calças abaixo deseja vender: ");
                                                int posicao1 = 0;
                                                for (int i = 0; i < cont1; i++) {
                                                    posicao1++;
                                                    System.out.println(posicao1 + " - " + calca[i].getDescricao() +
                                                            " - Gênero: " + calca[i].getGenero() +
                                                            " - Cor: " + calca[i].getCor() +
                                                            " - Preço: " + calca[i].getPreco());

                                                }
                                                System.out.println("\nSelecione [0] caso deseje cancelar a ação: ");
                                                Scanner option = new Scanner(System.in);
                                                int venda1 = option.nextInt();

                                                if (venda1 != 0) {
                                                    calcaAux = (Calça[]) calca[cont1 - 1].venderPeca(cont1, calca, venda1);

                                                    cont1--;

                                                    for (int j = 0; j < cont1; j++) {
                                                        calca[j] = (Calça) calcaAux[j];
                                                    }
                                                }else {
                                                    System.out.println("Ação cancelada");
                                                }
                                            } catch (NullPointerException e) {
                                                System.out.println("Não existem peças para vender");
                                            } catch (ArrayIndexOutOfBoundsException a) {
                                                System.out.println("Não existem peças para vender");
                                            }

                                        } else {
                                            System.out.println("Não existem calças para vender");
                                        }

                                        break;

                                    case 2:

                                        if (cont2 > 0) {

                                            try {
                                                System.out.println("Selecione qual das blusas abaixo deseja vender: ");
                                                int posicao2 = 0;
                                                for (int i = 0; i < cont2; i++) {
                                                    posicao2++;
                                                    System.out.println(posicao2 + " - " + blusas[i].getDescricao() +
                                                            " - Gênero: " + blusas[i].getGenero() +
                                                            " - Cor: " + blusas[i].getCor() +
                                                            " - Preço: " + blusas[i].getPreco());
                                                }

                                                System.out.println("\nSelecione [0] caso deseje cancelar a ação: ");
                                                Scanner option2 = new Scanner(System.in);
                                                int venda2 = option2.nextInt();

                                                if (venda2 != 0) {
                                                    blusaAux = (Blusa[]) blusas[cont2 - 1].venderPeca(cont2, blusas, venda2);

                                                    cont2--;

                                                    for (int j = 0; j < cont2; j++) {
                                                        blusas[j] = (Blusa) blusaAux[j];
                                                    }
                                                }else {
                                                    System.out.println("Ação cancelada");
                                                }
                                            } catch (NullPointerException e) {
                                                System.out.println("Não existem peças para vender");
                                            } catch (ArrayIndexOutOfBoundsException a) {
                                                System.out.println("Não existem peças para vender");
                                            }

                                        } else {
                                            System.out.println("Não existem blusas para vender.");
                                        }

                                        break;

                                    case 3:

                                        if (cont3 > 0) {
                                            try {
                                                System.out.println("Selecione qual das saias abaixo deseja vender: ");
                                                int posicao3 = 0;
                                                for (int i = 0; i < cont3; i++) {
                                                    posicao3++;
                                                    System.out.println(posicao3 + " - " + saia[i].getDescricao() +
                                                            " - Gênero: " + saia[i].getGenero() +
                                                            " - Cor: " + saia[i].getCor() +
                                                            " - Preço: " + saia[i].getPreco());
                                                }

                                                System.out.println("\n Selecione [0] caso deseje cancelar a ação: ");

                                                Scanner option3 = new Scanner(System.in);
                                                int venda3 = option3.nextInt();
                                                if (venda3 != 0) {
                                                    saiaAux = (Saia[]) saia[cont3 - 1].venderPeca(cont3, saia, venda3);

                                                    cont3--;

                                                    for (int j = 0; j < cont3; j++) {
                                                        saia[j] = (Saia) saiaAux[j];
                                                    }
                                                }else {
                                                    System.out.println("Ação cancela");
                                                }
                                            } catch (NullPointerException e) {
                                                System.out.println("Não existem peças para vender");
                                            } catch (ArrayIndexOutOfBoundsException a) {
                                                System.out.println("Não existem peças para vender");
                                            }

                                        } else {
                                            System.out.println("Não existem saias para vender.");
                                        }
                                        break;

                                    case 4:

                                        if (cont4 > 0) {

                                            try {
                                                System.out.println("Selecione qual dos vestidos abaixo deseja vender: ");
                                                int posicao4 = 0;
                                                for (int i = 0; i < cont4; i++) {
                                                    posicao4++;
                                                    System.out.println(posicao4 + " - " + vestido[i].getDescricao() +
                                                            " - Gênero: " + vestido[i].getGenero() +
                                                            " - Cor: " + vestido[i].getCor() +
                                                            " - Preço: " + vestido[i].getPreco());
                                                }
                                                System.out.println("\nSelecione [0] caso deseje cancelar a ação: ");
                                                Scanner option4 = new Scanner(System.in);
                                                int venda4 = option4.nextInt();

                                                if (venda4 !=0) {
                                                    vestidoAux = (Vestido[]) vestido[cont4 - 1].venderPeca(cont4, vestido, venda4);

                                                    cont4--;

                                                    for (int j = 0; j < cont4; j++) {
                                                        vestido[j] = (Vestido) vestidoAux[j];
                                                    }
                                                }else {
                                                    System.out.println("Ação cancelada");
                                                }
                                            } catch (NullPointerException e) {
                                                System.out.println("Não existem peças para vender");
                                            } catch (ArrayIndexOutOfBoundsException a) {
                                                System.out.println("Não existem peças para vender");
                                            }

                                        } else {
                                            System.out.println("Não existem vestidos para vender");
                                        }

                                        break;

                                    case 5:

                                        if (cont5 > 0) {

                                            try {
                                                System.out.println("Selecione qual dos camisetas abaixo deseja vender: ");
                                                int posicao5 = 0;
                                                for (int i = 0; i < cont5; i++) {
                                                    posicao5++;
                                                    System.out.println(posicao5 + " - " + camiseta[i].getDescricao() +
                                                            " - Gênero: " + camiseta[i].getGenero() +
                                                            " - Cor: " + camiseta[i].getCor() +
                                                            " - Preço: " + camiseta[i].getPreco());
                                                }

                                                System.out.println("\nSelecione [0] caso deseje cancelar a ação: ");

                                                Scanner option5 = new Scanner(System.in);
                                                int venda5 = option5.nextInt();

                                                if (venda5 !=0) {
                                                    camisetaAux = (Camiseta[]) camiseta[cont5 - 1].venderPeca(cont5, camiseta, venda5);

                                                    cont5--;

                                                    for (int j = 0; j < cont5; j++) {
                                                        camiseta[j] = (Camiseta) camisetaAux[j];
                                                    }
                                                }else {
                                                    System.out.println("Ação cancelada");
                                                }
                                            } catch (NullPointerException e) {
                                                System.out.println("Não existem peças para vender");
                                            } catch (ArrayIndexOutOfBoundsException a) {
                                                System.out.println("Não existem peças para vender");
                                            }

                                        } else {
                                            System.out.println("Não existem camisetas para vender");
                                        }
                                        break;
                                    case 6:
                                        System.out.println("Ação cancelada \n");
                                        break;

                                    default:
                                        System.out.println("Opção inválida. Tente novamente \n");
                                        break;

                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Apenas números. Tente novamente");
                            }

                            System.out.println("Deseja vender mais uma peça?");
                            System.out.println("[1] Sim  [0] Não");

                            if (opcao.nextInt() == 0) {
                                continua2 = 0;
                            }
                        }
                        break;

                    case 3:
                        int continua3 = 1;
                        while (continua3 == 1) {
                            System.out.println("Qual das peças abaixo você deseja encomendar: ");
                            System.out.println("[1] Calça [2] Blusa [3] Saia [4] Vestido [5] Camiseta [6] Cancelar");
                            int tipo3 = opcao.nextInt();

                            try {
                                switch (tipo3) {

                                    case 1:
                                        try {
                                            calcaEncomenda[contEnc1] = (Calça) calcaNova.adicionarPeca();
                                            contEnc1++;
                                        } catch (NullPointerException e) {
                                            System.out.println("Não foi possível adicionar peça a lista de encomendas");
                                        } catch (ArrayIndexOutOfBoundsException a) {
                                            System.out.println("Não foi possível adicionar peça a lista de encomendas");
                                        }
                                        break;

                                    case 2:

                                        try {
                                            blusaEncomenda[contEnc2] = (Blusa) blusaNova.adicionarPeca();
                                            contEnc2++;
                                        } catch (NullPointerException e) {
                                            System.out.println("Não foi possível adicionar peça a lista de encomendas");
                                        } catch (ArrayIndexOutOfBoundsException a) {
                                            System.out.println("Não foi possível adicionar peça a lista de encomendas");
                                        }

                                        break;

                                    case 3:

                                        try {
                                            saiaEncomenda[contEnc3] = (Saia) saiaNova.adicionarPeca();
                                            contEnc3++;
                                        } catch (NullPointerException e) {
                                            System.out.println("Não foi possível adicionar peça a lista de encomendas");
                                        } catch (ArrayIndexOutOfBoundsException a) {
                                            System.out.println("Não foi possível adicionar peça a lista de encomendas");
                                        }

                                        break;

                                    case 4:

                                        try {
                                            vestidoEncomenda[contEnc4] = (Vestido) vestidoNovo.adicionarPeca();
                                            contEnc4++;
                                        } catch (NullPointerException e) {
                                            System.out.println("Não foi possível adicionar peça a lista de encomendas");
                                        } catch (ArrayIndexOutOfBoundsException a) {
                                            System.out.println("Não foi possível adicionar peça a lista de encomendas");
                                        }

                                        break;

                                    case 5:

                                        try {
                                            camisetaEncomenda[contEnc5] = (Camiseta) camisetaNova.adicionarPeca();
                                            contEnc5++;
                                        } catch (NullPointerException e) {
                                            System.out.println("Não foi possível adicionar peça a lista de encomendas");
                                        } catch (ArrayIndexOutOfBoundsException a) {
                                            System.out.println("Não foi possível adicionar peça a lista de encomendas");
                                        }

                                        break;

                                    case 6:

                                        System.out.println("Ação cancelada \n");
                                        break;

                                    default:
                                        System.out.println("Opção inválida. Tente novamente \n");
                                        break;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Apenas números. Tente novamente");
                            }

                            System.out.println("Deseja acrescentar mais uma peça?");
                            System.out.println("[1] Sim  [0] Não");

                            if (opcao.nextInt() == 0) {
                                continua3 = 0;
                            }
                        }

                        break;

                    case 4:
                        int continua4 = 1;
                        while (continua4 == 1) {
                            System.out.println("Qual das peças abaixo você deseja cancelar a encomenda: ");
                            System.out.println("[1] Calça [2] Blusa [3] Saia [4] Vestido [5] Camiseta [6] Cancelar");
                            int tipo4 = opcao.nextInt();

                            try {
                                switch (tipo4) {

                                    case 1:

                                        if (contEnc1 > 0) {
                                            int posicao1 = 0;
                                            try {

                                                System.out.println("Selecione qual das calças abaixo deseja cancelar: ");
                                                for (int i = 0; i < contEnc1; i++) {
                                                    posicao1++;
                                                    System.out.println(posicao1 + " - " + calcaEncomenda[i].getDescricao() +
                                                            " - Gênero: " + calcaEncomenda[i].getGenero() +
                                                            " - Cor: " + calcaEncomenda[i].getCor() +
                                                            " - Preço: " + calcaEncomenda[i].getPreco());

                                                }

                                                System.out.println("\nSelecione [0] caso deseje cancelar a ação: ");

                                                Scanner option = new Scanner(System.in);
                                                int cancela1 = option.nextInt();

                                                if (cancela1 != 0) {
                                                    calcaAux = (Calça[]) calcaEncomenda[contEnc1 - 1].retirarEncomenda(contEnc1, calca, cancela1);

                                                    contEnc1--;

                                                    for (int j = 0; j < contEnc1; j++) {
                                                        blusaEncomenda[j] = (Blusa) blusaAux[j];
                                                    }
                                                }else {
                                                    System.out.println("Ação cancelada");
                                                }
                                            } catch (NullPointerException e) {
                                                System.out.println("Peças não encontradas");
                                            } catch (ArrayIndexOutOfBoundsException a) {
                                                System.out.println("Peças não encontradas");
                                            }

                                        } else {
                                            System.out.println("Não existem pedidos para cancelar");
                                        }
                                        break;

                                    case 2:

                                        if (contEnc2 > 0) {
                                            int posicao2 =0;
                                            try {

                                                System.out.println("Selecione qual das blusas abaixo deseja cancelar: ");
                                                for (int i = 0; i < contEnc2; i++) {
                                                    posicao2++;
                                                    System.out.println(posicao2 + " - " + blusaEncomenda[i].getDescricao() +
                                                            " - Gênero: " + blusaEncomenda[i].getGenero() +
                                                            " - Cor: " + blusaEncomenda[i].getCor() +
                                                            " - Preço: " + blusaEncomenda[i].getPreco());
                                                }
                                                System.out.println("\nSelecione [0] caso deseje cancelar a ação: ");
                                                Scanner option2 = new Scanner(System.in);
                                                int cancela2 = option2.nextInt();

                                                if (cancela2 !=0) {
                                                    blusaAux = (Blusa[]) blusaEncomenda[contEnc2 - 1].retirarEncomenda(contEnc2, blusas, cancela2);

                                                    contEnc2--;

                                                    for (int j = 0; j < contEnc2; j++) {
                                                        blusaEncomenda[j] = (Blusa) blusaAux[j];
                                                    }
                                                }else {
                                                    System.out.println("Ação cancelada");
                                                }
                                            } catch (NullPointerException e) {
                                                System.out.println("Não há peças disponíveis para cancelamento");
                                            } catch (ArrayIndexOutOfBoundsException a) {
                                                System.out.println("Não há peças disponíveis para cancelamento");
                                            }

                                        } else {
                                            System.out.println("Não existem pedidos para cancelar");
                                        }
                                        break;

                                    case 3:

                                        if (contEnc3 > 0) {
                                            int posicao3 = 0;
                                            try {

                                                System.out.println("Selecione qual das saias abaixo deseja cancelar: ");
                                                for (int i = 0; i < contEnc3; i++) {
                                                    posicao3++;
                                                    System.out.println(posicao3 + " - " + saiaEncomenda[i].getDescricao() +
                                                            " - Gênero: " + saiaEncomenda[i].getGenero() +
                                                            " - Cor: " + saiaEncomenda[i].getCor() +
                                                            " - Preço: " + saiaEncomenda[i].getPreco());
                                                }

                                                System.out.println("\nSelecione [0] caso deseje cancelar a ação: ");
                                                Scanner option3 = new Scanner(System.in);
                                                int cancela3 = option3.nextInt();


                                                if (cancela3 !=0) {
                                                    saiaAux = (Saia[]) saiaEncomenda[contEnc3 - 1].retirarEncomenda(contEnc3, saia, cancela3);

                                                    contEnc3--;

                                                    for (int j = 0; j < contEnc3; j++) {
                                                        saiaEncomenda[j] = (Saia) saiaAux[j];
                                                    }
                                                }else {
                                                    System.out.println("Ação cancelada");
                                                }
                                            } catch (NullPointerException e) {
                                                System.out.println("Não há peças disponíveis para cancelamento");
                                            } catch (ArrayIndexOutOfBoundsException a) {
                                                System.out.println("Não há peças disponíveis para cancelamento");
                                            }


                                        } else {
                                            System.out.println("Não existem pedidos para cencelar");
                                        }
                                        break;

                                    case 4:

                                        if (contEnc4 > 0) {
                                            int posicao4 = 0;
                                            try {

                                                System.out.println("Selecione qual dos vestidos abaixo deseja cancelar: ");
                                                for (int i = 0; i < contEnc4; i++) {
                                                    posicao4++;
                                                    System.out.println(posicao4 + " - " + vestidoEncomenda[i].getDescricao() +
                                                            " - Gênero: " + vestidoEncomenda[i].getGenero() +
                                                            " - Cor: " + vestidoEncomenda[i].getCor() +
                                                            " - Preço: " + vestidoEncomenda[i].getPreco());
                                                }

                                                System.out.println("\nSelecione [0] caso deseje cancelar a ação: ");

                                                Scanner option4 = new Scanner(System.in);
                                                int cancela4 = option4.nextInt();


                                                if (cancela4 !=0) {
                                                    vestidoAux = (Vestido[]) vestidoEncomenda[contEnc4 - 1].retirarEncomenda(contEnc4, vestido, cancela4);

                                                    contEnc4--;

                                                    for (int j = 0; j < contEnc4; j++) {
                                                        vestidoEncomenda[j] = (Vestido) vestidoAux[j];
                                                    }
                                                }else {
                                                    System.out.println("Ação cancelada");
                                                }
                                            } catch (NullPointerException e) {
                                                System.out.println("Não há peças disponíveis para cancelamento");
                                            } catch (ArrayIndexOutOfBoundsException a) {
                                                System.out.println("Não há peças disponíveis para cancelamento");
                                            }


                                        } else {
                                            System.out.println("Não existem pedidos para cancelar");
                                        }
                                        break;

                                    case 5:

                                        if (contEnc5 > 0) {
                                            int posicao5 = 0;
                                            try {
                                                System.out.println("Selecione qual dos camisetas abaixo deseja cancelar: ");
                                                for (int i = 0; i < contEnc5; i++) {
                                                    posicao5++;
                                                    System.out.println(posicao5 + " - " + camisetaEncomenda[i].getDescricao() +
                                                            " - Gênero: " + camisetaEncomenda[i].getGenero() +
                                                            " - Cor: " + camisetaEncomenda[i].getCor() +
                                                            " - Preço: " + camisetaEncomenda[i].getPreco());
                                                }

                                                System.out.println("\n Selecione [0] caso deseje cancelar a ação: ");
                                                Scanner option5 = new Scanner(System.in);
                                                int cancela5 = option5.nextInt();



                                                if (cancela5 != 0) {
                                                    camisetaAux = (Camiseta[]) camisetaEncomenda[cont5 - 1].retirarEncomenda(contEnc5, camiseta, cancela5);

                                                    contEnc5--;

                                                    for (int j = 0; j < contEnc5; j++) {
                                                        camisetaEncomenda[j] = (Camiseta) camisetaAux[j];
                                                    }
                                                }else {
                                                    System.out.println("Ação cancelada");
                                                }
                                            } catch (NullPointerException e) {
                                                System.out.println("Não há peças disponíveis para cancelamento");
                                            } catch (ArrayIndexOutOfBoundsException a) {
                                                System.out.println("Não há peças disponíveis para cancelamento");
                                            }

                                        } else {
                                            System.out.println("Não existem pedidos para cancelar");
                                        }
                                        break;

                                    case 6:
                                        System.out.println("Ação cancelada \n");
                                        break;
                                    default:
                                        System.out.println("Opção inválida. Tente novamente \n");
                                        break;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Apenas números. Tente novamente");
                            }

                            System.out.println("Deseja cancelar mais uma peça?");
                            System.out.println("[1] Sim  [0] Não");

                            if (opcao.nextInt() == 0) {
                                continua4 = 0;
                            }


                        }
                        break;
                    case 5:
                        int continua5 = 1;
                        while (continua5 == 1) {
                            System.out.println("Como deseja mostrar o estoque?");
                            System.out.println("[1] Por peça [2] Estoque completo [3] Cancelar");
                            int tipo5 = opcao.nextInt();

                            try {
                                switch (tipo5) {

                                    case 1:
                                        System.out.println("Selecione a peça que deseja ver o estoque:");
                                        System.out.println("[1] Calça [2] Blusa [3] Saia [4] Vestido [5] Camiseta [6] Cancelar");
                                        int estoque = opcao.nextInt();
                                        try {
                                            switch (estoque) {

                                                case 1:
                                                    if (cont1-1 >=0) {
                                                        int posicao1 = 0;
                                                        System.out.println("Estoque de calças: \n");
                                                        try {
                                                            for (int j = 0; j < cont1; j++) {
                                                                posicao1++;
                                                                System.out.println(posicao1 + " - Gênero: " + calca[j].getGenero() +
                                                                        "\nDescrição: " + calca[j].getDescricao() +
                                                                        "\nCor: " + calca[j].getCor() +
                                                                        "\nTamanho: " + calca[j].getTamanho() +
                                                                        "\nPreço: R$" + calca[j].getPreco() + "\n");
                                                            }
                                                        } catch (NullPointerException e) {
                                                            System.out.println("Não existem peças no estoque");
                                                        } catch (ArrayIndexOutOfBoundsException a) {
                                                            System.out.println("Não existem peças no estoque");
                                                        }
                                                    }else {
                                                        System.out.println("Sem estoque de calças \n");
                                                    }
                                                    break;

                                                case 2:
                                                    if (cont2-1 >=0) {
                                                        System.out.println("Estoque de blusas: \n");
                                                        int posicao2 = 0;
                                                        try {
                                                            for (int k = 0; k < cont2; k++) {
                                                                posicao2++;
                                                                System.out.println(posicao2 + " - Gênero: " + blusas[k].getGenero() +
                                                                        "\nDescrição: " + blusas[k].getDescricao() +
                                                                        "\nCor: " + blusas[k].getCor() +
                                                                        "\nTamanho: " + blusas[k].getTamanho() +
                                                                        "\nPreço: R$" + blusas[k].getPreco() + "\n");
                                                            }
                                                        } catch (NullPointerException e) {
                                                            System.out.println("Não existem peças no estoque");
                                                        } catch (ArrayIndexOutOfBoundsException a) {
                                                            System.out.println("Não existem peças no estoque");
                                                        }
                                                    }else {
                                                        System.out.println("Sem estoque de blusas \n");
                                                    }
                                                    break;

                                                case 3:
                                                    if (cont3-1 >=0) {
                                                        System.out.println("Estoque de saias: \n");
                                                        int posicao3 = 0;
                                                        try {
                                                            for (int i = 0; i < cont3; i++) {
                                                                posicao3++;
                                                                System.out.println(posicao3 + " - Gênero: " + saia[i].getGenero() +
                                                                        "\nDesscrição " + saia[i].getDescricao() + "\nCor: " + saia[i].getCor() +
                                                                        "\nTamanho: " + saia[i].getTamanho() +
                                                                        "\nPreço: R$" + saia[i].getPreco() + "\n");
                                                            }
                                                        } catch (NullPointerException e) {
                                                            System.out.println("Não existem peças no estoque");
                                                        } catch (ArrayIndexOutOfBoundsException a) {
                                                            System.out.println("Não existem peças no estoque");
                                                        }
                                                    }else {
                                                        System.out.println("Sem estoque de saias \n");
                                                    }
                                                    break;

                                                case 4:
                                                    if (cont4-1 >=0) {
                                                        System.out.println("Estoque de vestidos: \n");
                                                        int posicao4 = 0;
                                                        try {
                                                            for (int i = 0; i < cont4; i++) {
                                                                posicao4++;
                                                                System.out.println(posicao4 + " - Gênero: " + vestido[i].getGenero() +
                                                                        "\nDescrição: " + vestido[i].getDescricao() +
                                                                        "\nCor: " + vestido[i].getCor() +
                                                                        "\nTamanho: " + vestido[i].getTamanho() +
                                                                        "\nPreço: R$" + vestido[i].getPreco() + "\n");
                                                            }
                                                        } catch (NullPointerException e) {
                                                            System.out.println("Não existem peças no estoque");
                                                        } catch (ArrayIndexOutOfBoundsException a) {
                                                            System.out.println("Não existem peças no estoque");
                                                        }
                                                    }else {
                                                        System.out.println("Sem estoque de vestidos \n");
                                                    }
                                                    break;

                                                case 5:
                                                    if (cont5-1 >= 0) {
                                                        System.out.println("Estoque de camisetas: \n");
                                                        int posicao5 = 0;
                                                        try {
                                                            for (int i = 0; i < cont5; i++) {
                                                                posicao5++;
                                                                System.out.println(posicao5 + " - Gênero: " + camiseta[i].getGenero() +
                                                                        "\nDescrição: " + camiseta[i].getDescricao() +
                                                                        "\nCor: " + camiseta[i].getCor() +
                                                                        "\nTamanho: " + camiseta[i].getTamanho() +
                                                                        "\nPreço: R$" + camiseta[i].getPreco() + "\n");
                                                            }
                                                        } catch (NullPointerException e) {
                                                            System.out.println("Não existem peças no estoque");
                                                        } catch (ArrayIndexOutOfBoundsException a) {
                                                            System.out.println("Não existem peças no estoque");
                                                        }
                                                    }else {
                                                        System.out.println("Sem estoque de camisetas \n");
                                                    }
                                                    break;

                                                case 6:
                                                    System.out.println("Ação cancelada \n");
                                                    break;
                                                default:
                                                    System.out.println("Opção inválida. Tente novamente");
                                                    break;
                                            }
                                        } catch (InputMismatchException e) {
                                            System.out.println("Apenas números. Tente novamente");
                                        }

                                        break;

                                    case 2:

                                        try {
                                            System.out.println("Estoque completo: \n ");

                                            if (cont1-1 >= 0) {
                                                System.out.println("Estoque de calças: \n");
                                                int posicao1 = 0;
                                                for (int i = 0; i < cont1; i++) {
                                                    posicao1++;
                                                    System.out.println(posicao1 + " - Gênero: " + calca[i].getGenero() +
                                                            "\nDescrição: " + calca[i].getDescricao() +
                                                            "\nCor: " + calca[i].getCor() +
                                                            "\nTamanho: " + calca[i].getTamanho() +
                                                            "\nPreço: R$" + calca[i].getPreco() + "\n");

                                                }
                                            }else {
                                                System.out.println("Sem calças no estoque \n");
                                            }

                                            if (cont2-1 >=0) {
                                                System.out.println("Estoque de blusas: \n");
                                                int posicao2 =0;
                                                for (int i = 0; i < cont2; i++) {
                                                    posicao2++;
                                                    System.out.println(posicao2 + " - Gênero: " + blusas[i].getGenero() +
                                                            "\nDescrição: " + blusas[i].getDescricao() +
                                                            "\nCor: " + blusas[i].getCor() +
                                                            "\nTamanho: " + blusas[i].getTamanho() +
                                                            "\nPreço: R$" + blusas[i].getPreco() + "\n");

                                                }
                                            }else{
                                                System.out.println("Sem blusas no estoque \n");
                                            }

                                            if (cont3-1 >=0) {
                                                System.out.println("Estoque de saias: \n");
                                                int posicao3 = 0;
                                                for (int i = 0; i < cont3; i++) {
                                                    posicao3++;
                                                    System.out.println(posicao3 + " - Gênero: " + saia[i].getGenero() +
                                                            "\nDescrição: " + saia[i].getDescricao() +
                                                            "\nCor: " + saia[i].getCor() +
                                                            "\nTamanho: " + saia[i].getTamanho() +
                                                            "\nPreço: R$" + saia[i].getPreco() + "\n");
                                                }
                                            }else {
                                                System.out.println("Sem saias no estoque \n");
                                            }

                                            if (cont4-1 >=0) {
                                                System.out.println("Estoque de vestidos: \n");
                                                int posicao4 = 0;
                                                for (int i = 0; i < cont4; i++) {
                                                    posicao4++;
                                                    System.out.println(posicao4 + " - Gênero: " + vestido[i].getGenero() +
                                                            "\nDescrição: " + vestido[i].getDescricao() +
                                                            "\nCor: " + vestido[i].getCor() +
                                                            "\nTamanho: " + vestido[i].getTamanho() +
                                                            "\nPreço: R$" + vestido[i].getPreco() + "\n");

                                                }
                                            }else {
                                                System.out.println("Sem vestidos no estoque \n");
                                            }

                                            if (cont5-1 >=0) {
                                                System.out.println("Estoque de camisetas: \n");
                                                int posicao5 =0;
                                                for (int i = 0; i < cont5; i++) {
                                                    posicao5++;
                                                    System.out.println(posicao5 + " - Gênero: " + camiseta[i].getGenero() +
                                                            "\nDescrição: " + camiseta[i].getDescricao() +
                                                            "\nCor: " + camiseta[i].getCor() +
                                                            "\nTamanho: " + camiseta[i].getTamanho() +
                                                            "\nPreço: R$" + camiseta[i].getPreco() + "\n");

                                                }
                                            }else {
                                                System.out.println("Sem camisetas no estoque");
                                            }

                                        } catch (NullPointerException e) {
                                            System.out.println("Não existem peças no estoque");
                                        } catch (ArrayIndexOutOfBoundsException a) {
                                            System.out.println("Não existem peças no estoque");
                                        }
                                        break;

                                    case 3:
                                        System.out.println("Ação cancelada \n");
                                        break;
                                    default:
                                        System.out.println("Opção inválida. Tente novamente \n");
                                        break;

                                }
                                System.out.println("Deseja exibir o estoque novamente?");
                                System.out.println("[1] Sim [0] Não");

                                if (opcao.nextInt() == 0) {
                                    continua5 = 0;
                                }

                            }catch (InputMismatchException e){
                                System.out.println("Apenas números. Tente novamente");
                            }
                        }

                    default:
                        System.out.println("Opção inválida. Tente novamente \n");
                        break;
            }

        }catch (InputMismatchException e){
                System.out.println("Apenas números. Tente novamente");
            }
        }
    }
}



