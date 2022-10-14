package com.br.app.entidades;

public class IngressoComDesconto extends Ingresso implements AdicionarDesconto {
    final int DESCONTO_MIN = 0;
    final int DESCONTO_MAX = 100;

    @Override
    public boolean adicionarDesconto(double desconto) {
        if (desconto > DESCONTO_MIN && desconto <= DESCONTO_MAX) {
            double preco = this.getPreco();
            preco *= desconto/100;

            this.setPreco(preco);

            return true;
        } else {
            return false;
        }
    }
}
