/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexoes.ConexaoMySql;
import java.util.ArrayList;
import model.ModelProdutos;
import model.ModelProdutosVendasProdutos;
import model.ModelVendasProdutos;

/**
 *
 * @author Jose Luiz
 */
public class DAOProdutosVendasProdutos extends ConexaoMySql {

    public ArrayList<ModelProdutosVendasProdutos> getListaProdutosVendasProdutosDAO(int pCodigoVenda) {
        ArrayList<ModelProdutosVendasProdutos> listaModelProdutosVendasProdutos = new ArrayList<>();
        ModelProdutosVendasProdutos modelProdutosVendasProdutos = new ModelProdutosVendasProdutos();
        ModelProdutos modelProdutos = new ModelProdutos();
        ModelVendasProdutos modelVendasProdutos = new ModelVendasProdutos();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + " tbl_produto.pk_id_produto,"
                    + " tbl_produto.pro_estoque,"
                    + " tbl_produto.pro_nome,"
                    + " tbl_produto.pro_descricao,"
                    + " tbl_produto.pro_valor,"
                    + " tbl_produto.pro_valor_venda,"
                    + " tbl_produto.pro_valor_unitario,"
                    + " tbl_produto.pro_marca,"
                    + " tbl_vendas_produtos.fk_produto,"
                    + " tbl_vendas_produtos.fk_vendas,"
                    + " tbl_vendas_produtos.pk_id_venda_produto,"
                    + " tbl_vendas_produtos.ven_pro_quantidade,"
                    + " tbl_vendas_produtos.ven_pro_valor "
                    + " FROM tbl_vendas_produtos "
                    + " INNER JOIN tbl_produto ON tbl_produto.pk_id_produto = "
                    + " tbl_vendas_produtos.fk_produto "
                    + " WHERE tbl_vendas_produtos.fk_vendas = '" + pCodigoVenda + "';");

            while (this.getResultSet().next()) {
                modelProdutosVendasProdutos = new ModelProdutosVendasProdutos();
                modelProdutos = new ModelProdutos();
                modelVendasProdutos = new ModelVendasProdutos();

                modelProdutos.setIdProduto(this.getResultSet().getInt(1));
                modelProdutos.setProEstoque(this.getResultSet().getInt(2));
                modelProdutos.setProNome(this.getResultSet().getString(3));
                modelProdutos.setProDescricao(this.getResultSet().getString(4));
                modelProdutos.setProValor(this.getResultSet().getDouble(5));
                modelProdutos.setProValorVenda(this.getResultSet().getDouble(6));
                modelProdutos.setProValorUnitario(this.getResultSet().getDouble(7));
                modelProdutos.setProMarca(this.getResultSet().getString(8));

                modelVendasProdutos.setProduto(this.getResultSet().getInt(9));
                modelVendasProdutos.setVendas(this.getResultSet().getInt(10));
                modelVendasProdutos.setIdVendaProduto(this.getResultSet().getInt(11));
                modelVendasProdutos.setVenProQuantidade(this.getResultSet().getInt(12));
                modelVendasProdutos.setVendasProValor(this.getResultSet().getDouble(13));

                modelProdutosVendasProdutos.setModelProdutos(modelProdutos);
                
                modelProdutosVendasProdutos.setModelVendasProdutos(modelVendasProdutos);

                listaModelProdutosVendasProdutos.add(modelProdutosVendasProdutos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaModelProdutosVendasProdutos;
    }
}
