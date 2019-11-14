/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

/**
 *
 * @author 277882
 */
public class Produtos {
    
    private int cod_prod;
    private String nome_prod;
    private int quant_prod;
    private double preco_prod;
    private double preco_compra;
    private double preco_venda;
    private double preco_total;

    public int getCod_prod() {
        return cod_prod;
    }

    public void setCod_prod(int cod_prod) {
        this.cod_prod = cod_prod;
    }

    public String getNome_prod() {
        return nome_prod;
    }

    public void setNome_prod(String nome_prod) {
        this.nome_prod = nome_prod;
    }

    public int getQuant_prod() {
        return quant_prod;
    }

    public void setQuant_prod(int quant_prod) {
        this.quant_prod = quant_prod;
    }

    public double getPreco_prod() {
        return preco_prod;
    }

    public void setPreco_prod(double preco_prod) {
        this.preco_prod = preco_prod;
    }

    public double getPreco_compra() {
        return preco_compra;
    }

    public void setPreco_compra(double preco_compra) {
        this.preco_compra = preco_compra;
    }

    public double getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(double preco_venda) {
        this.preco_venda = preco_venda;
    }

    public double getPreco_total() {
        return preco_total;
    }

    public void setPreco_total(double preco_total) {
        this.preco_total = preco_total;
    }
    
}
