/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DAOProdutos;
import java.util.ArrayList;
import model.ModelProdutos;

/**
 *
 * @author Jose Luiz
 */
public class ControllerProduto {

    private DAOProdutos daoProdutos = new DAOProdutos();

    /**
     * Salvar produtos controller
     *
     * @param pModelProdutos
     * @return
     */
    public int salvarProdutoController(ModelProdutos pModelProdutos) {
        return this.daoProdutos.salvarProdutoDAO(pModelProdutos);
    }

    /**
     * Excluir um produto pelo código
     *
     * @param pCodigo
     * @return
     */
    public boolean excluirProdutoController(int pCodigo) {
        return this.daoProdutos.excluirProdutoDAO(pCodigo);
    }

    /**
     * Alterar um produto
     *
     * @param pModeloProdutos
     * @return
     */
    public boolean alterarProdutosController(ModelProdutos pModelProdutos) {
        return this.daoProdutos.atualizarProdutoDAO(pModelProdutos);
    }

    /**
     * Retornar produto pelo código
     *
     * @param pCodigo
     * @return model produto
     */
    public ModelProdutos retornarProdutoController(int pCodigo) {
        return this.daoProdutos.getProdutoDAO(pCodigo);
    }

    /**
     * Retornar produto pelo código
     *
     * @param pNomeProduto
     * @return model produto
     */
    public ModelProdutos retornarProdutoController(String pNomeProduto) {
        return this.daoProdutos.retornarProdutoDAO(pNomeProduto);
    }

    /**
     * Retornar uma lista de produtos
     *
     * @return lista Model produtos
     */
    public ArrayList<ModelProdutos> retornarListaProdutoController() {
        return this.daoProdutos.getListaProdutoDAO();
    }

    /**
     * Alterar lista de produtos no banco
     *
     * @param pListaModelProdutos
     * @return
     */
    public boolean alterarEstoqueProdutosController(ArrayList<ModelProdutos> pListaModelProdutos) {

        return this.daoProdutos.alterarEstoqueProdutosDAO(pListaModelProdutos);
    }

     /**
     * Filtra produtos pela quantidade em estoque
     *
     * @param pEstoqueProduto
     * @return model produto
     */
    public ModelProdutos filtrarEstoqueProduto(String pEstoqueProduto) {
        return this.daoProdutos.filtrarEstoqueProdutosDAO(pEstoqueProduto);
    }

}
