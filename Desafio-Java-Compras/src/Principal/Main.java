package Principal;

import Modelos.Cartao;
import Modelos.Compra;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opc = 1;

        System.out.println("Informe o Limite do Cartao de credito: ");
        double limite = scanner.nextDouble();
        scanner.nextLine();
        Cartao cartao = new Cartao(limite);

        while (opc == 1){
            System.out.println("Informe a descricao da compra: ");
            String descricao = scanner.nextLine();

            System.out.println("Informe o valor da compra: ");
            double valor = scanner.nextDouble();
            scanner.nextLine();

            Compra compra = new Compra(descricao,valor);
            cartao.registarCompra(compra);

            System.out.println("Deseja realizar outra compra? " +
                    "Digite 1 para Sim e 0 pra nao: ");
            opc = scanner.nextInt();
            scanner.nextLine();

        }

        System.out.println("***********************");
        System.out.println("COMPRAS REALIZADAS:\n");
        cartao.getListaDeCompras().sort(Comparator.comparing(Compra::getValor));
        for (Compra list : cartao.getListaDeCompras()){
            System.out.println(list.getDescricao() + " - " +list.getValor());
        }
        System.out.println("***********************");

        System.out.println("\nSaldo restante do cartão: " +cartao.getSaldo());



    }
}