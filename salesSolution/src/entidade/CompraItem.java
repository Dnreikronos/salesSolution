/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

/**
 *
 * @author pretto
 */
public class CompraItem {

    private int id;
    private double qtde;
    private double valor;
    private int compra_id;
    private int produto_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getQtde() {
        return qtde;
    }

    public void setQtde(double qtde) {
        this.qtde = qtde;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getCompraId() {
        return compra_id;
    }

    public void setCompraId(int compra_id) {
        this.compra_id = compra_id;
    }

    public int getProdutoId() {
        return produto_id;
    }

    public void setProdutoId(int produto_id) {
        this.produto_id = produto_id;
    }
}
