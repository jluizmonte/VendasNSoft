/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Jose Luiz
 */
public class ModelProdutos {


    private int idProduto;
    private String proNome;
    private Double proValor;
    private int proEstoque;
    private String proUnidade;
    private Double proValorVenda;
    private Double proValorUnitario;
    private String proDescricao;
    private String proMarca;
    private String proFiltro;

    /**
     * @return the idProduto
     */
    public int getIdProduto() {
        return idProduto;
    }

    /**
     * @param idProduto the idProduto to set
     */
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    /**
     * @return the proNome
     */
    public String getProNome() {
        return proNome;
    }

    /**
     * @param proNome the proNome to set
     */
    public void setProNome(String proNome) {
        this.proNome = proNome;
    }

    /**
     * @return the proValor
     */
    public Double getProValor() {
        return proValor;
    }

    /**
     * @param proValor the proValor to set
     */
    public void setProValor(Double proValor) {
        this.proValor = proValor;
    }

    /**
     * @return the proEstoque
     */
    public int getProEstoque() {
        return proEstoque;
    }

    /**
     * @param proEstoque the proEstoque to set
     */
    public void setProEstoque(int proEstoque) {
        this.proEstoque = proEstoque;
    }

    /**
     * @return the proUnidade
     */
    public String getProUnidade() {
        return proUnidade;
    }

    /**
     * @param proUnidade the proUnidade to set
     */
    public void setProUnidade(String proUnidade) {
        this.proUnidade = proUnidade;
    }

    /**
     * @return the proValorVenda
     */
    public Double getProValorVenda() {
        return proValorVenda;
    }

    /**
     * @param proValorVenda the proValorVenda to set
     */
    public void setProValorVenda(Double proValorVenda) {
        this.proValorVenda = proValorVenda;
    }

    /**
     * @return the proValorUnitario
     */
    public Double getProValorUnitario() {
        return proValorUnitario;
    }

    /**
     * @param proValorUnitario the proValorUnitario to set
     */
    public void setProValorUnitario(Double proValorUnitario) {
        this.proValorUnitario = proValorUnitario;
    }

    /**
     * @return the proDescricao
     */
    public String getProDescricao() {
        return proDescricao;
    }

    /**
     * @param proDescricao the proDescricao to set
     */
    public void setProDescricao(String proDescricao) {
        this.proDescricao = proDescricao;
    }

    /**
     * @return the proMarca
     */
    public String getProMarca() {
        return proMarca;
    }

    /**
     * @param proMarca the proMarca to set
     */
    public void setProMarca(String proMarca) {
        this.proMarca = proMarca;
    }

    /**
     * @return the proFiltro
     */
    public String getProFiltro() {
        return proFiltro;
    }

    /**
     * @param proFiltro the proFiltro to set
     */
    public void setProFiltro(String proFiltro) {
        this.proFiltro = proFiltro;
    }

}