/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */

/**
 *
 * @author ismelio-cori
 */
public enum Planos {
    PLANO_500(500, "está na ordem de 100% do saldo, pode ser\n"
            + "convertido em moeda ou manter o saldo, se convidar 3\n"
            + "amigos ou mais, terá um bonús de 15%"),
    PLANO_1000(1000, "está na ordem de 100% do saldo, que\n"
            + "pode ser convertido em moeda ou manter o saldo, pode ser\n"
            + "convertido em moeda ou manter o saldo, se convidar 3\n"
            + "amigos ou mais, terá um bonús de 25%"),
    PLANO_2000(2000, "está na ordem de 100% do saldo, que\n"
            + "pode ser convertido em moeda ou manter o saldo, pode ser\n"
            + "convertido em moeda ou manter o saldo, se convidar 3\n"
            + "amigos ou mais, terá um bonús de 50%");

    private final int valor;
    private final String descricao;

    Planos(int valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public int getValor() {
        return this.valor;
    }

    public String getDescricao() {
        return this.descricao;
    }
}
