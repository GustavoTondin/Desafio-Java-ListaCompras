package Modelos;

import java.util.ArrayList;
import java.util.List;

public class Cartao {
    private double limite;
    private double saldo;
    private List<Compra> listaDeCompras;

    public List<Compra> getListaDeCompras() {
        return listaDeCompras;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cartao(double limite){
        this.limite = limite;
        this.saldo = limite;
        listaDeCompras = new ArrayList<>();
    }

    public void registarCompra(Compra compra){
        if (compra.getValor() <= saldo){
            listaDeCompras.add(compra);
            saldo -= compra.getValor();
            System.out.println("Compra realizada com sucesso!!");
        } else if (saldo == 0){
            System.out.println("Nao foi possivel concluir a compra, " +
                    "voce ja gastou todo seu saldo do cartao de credito");
        }else {
            System.out.println("Nao foi possivel concluir a compra, " +
                    "voce nao possui saldo suficiente, seu saldo atual é de: " + saldo);
        }


    }
}
