/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Jose Luiz
 */
public class ModelProdutosVendasProdutos {

    private ModelProdutos modelProdutos;
    private ModelVendasProdutos modelVendasProdutos;
    private ArrayList<ModelProdutosVendasProdutos> listaModelProdutosVendasProdutoses = new ArrayList<>();

    /**
     * @return the modelProdutos
     */
    public ModelProdutos getModelProdutos() {
        return modelProdutos;
    }

    /**
     * @param modelProdutos the modelProdutos to set
     */
    public void setModelProdutos(ModelProdutos modelProdutos) {
        this.modelProdutos = modelProdutos;
    }

    /**
     * @return the modelVendasProdutos
     */
    public ModelVendasProdutos getModelVendasProdutos() {
        return modelVendasProdutos;
    }

    /**
     * @param modelVendasProdutos the modelVendasProdutos to set
     */
    public void setModelVendasProdutos(ModelVendasProdutos modelVendasProdutos) {
        this.modelVendasProdutos = modelVendasProdutos;
    }

    /**
     * @return the listaModelProdutosVendasProdutoses
     */
    public ArrayList<ModelProdutosVendasProdutos> getListaModelProdutosVendasProdutoses() {
        return listaModelProdutosVendasProdutoses;
    }

    /**
     * @param listaModelProdutosVendasProdutoses the
     * listaModelProdutosVendasProdutoses to set
     */
    public void setListaModelProdutosVendasProdutoses(ArrayList<ModelProdutosVendasProdutos> listaModelProdutosVendasProdutoses) {
        this.listaModelProdutosVendasProdutoses = listaModelProdutosVendasProdutoses;
    }
}
