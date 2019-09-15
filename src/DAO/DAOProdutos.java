package DAO;

import model.ModelProdutos;
import conexoes.ConexaoMySql;
import java.util.ArrayList;

/**
 *
 * @author Jose Luiz
 */
public class DAOProdutos extends ConexaoMySql {

    /**
     * grava Produto
     *
     * @param pModelProduto return int
     * @return 
     */
    public int salvarProdutoDAO(ModelProdutos pModelProduto) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO tbl_produto ("
                    + "pk_id_produto,"
                    + "pro_nome,"
                    + "pro_descricao,"
                    + "pro_marca,"
                    + "pro_estoque,"
                    + "pro_valor,"
                    + "pro_valor_venda,"
                    + "pro_valor_unitario"
                    + ") VALUES ("
                    + "'" + pModelProduto.getIdProduto() + "',"
                    + "'" + pModelProduto.getProNome() + "',"
                    + "'" + pModelProduto.getProDescricao() + "',"
                    + "'" + pModelProduto.getProMarca() + "',"
                    + "'" + pModelProduto.getProEstoque() + "',"
                    + "'" + pModelProduto.getProValor() + "',"
                    + "'" + pModelProduto.getProValorVenda() + "',"
                    + "'" + pModelProduto.getProValorUnitario() + "'"
                    + ");"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * recupera Produto
     *
     * @param pIdProduto return ModelProduto
     * @return 
     */
    public ModelProdutos getProdutoDAO(int pIdProduto) {
        ModelProdutos modelProduto = new ModelProdutos();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_id_produto,"
                    + "pro_nome,"
                    + "pro_descricao,"
                    + "pro_marca,"
                    + "pro_estoque,"
                    + "pro_valor,"
                    + "pro_valor_venda,"
                    + "pro_valor_unitario"
                    + " FROM"
                    + " tbl_produto"
                    + " WHERE"
                    + " pk_id_produto = '" + pIdProduto + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelProduto.setIdProduto(this.getResultSet().getInt(1));
                modelProduto.setProNome(this.getResultSet().getString(2));
                modelProduto.setProDescricao(this.getResultSet().getString(3));
                modelProduto.setProMarca(this.getResultSet().getString(4));
                modelProduto.setProEstoque(this.getResultSet().getInt(5));
                modelProduto.setProValor(this.getResultSet().getDouble(6));
                modelProduto.setProValorVenda(this.getResultSet().getDouble(7));
                modelProduto.setProValorUnitario(this.getResultSet().getDouble(8));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelProduto;
    }

    /**
     * recupera uma lista de Produto return ArrayList
     * @return 
     */
    public ArrayList<ModelProdutos> getListaProdutoDAO() {
        ArrayList<ModelProdutos> listamodelProduto = new ArrayList();
        ModelProdutos modelProduto = new ModelProdutos();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_id_produto,"
                    + "pro_nome,"
                    + "pro_descricao,"
                    + "pro_marca,"
                    + "pro_estoque,"
                    + "pro_valor,"
                    + "pro_valor_venda,"
                    + "pro_valor_unitario"
                    + " FROM"
                    + " tbl_produto"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelProduto = new ModelProdutos();
                modelProduto.setIdProduto(this.getResultSet().getInt(1));
                modelProduto.setProNome(this.getResultSet().getString(2));
                modelProduto.setProDescricao(this.getResultSet().getString(3));
                modelProduto.setProMarca(this.getResultSet().getString(4));
                modelProduto.setProEstoque(this.getResultSet().getInt(5));
                modelProduto.setProValor(this.getResultSet().getDouble(6));
                modelProduto.setProValorVenda(this.getResultSet().getDouble(7));
                modelProduto.setProValorUnitario(this.getResultSet().getDouble(8));
                listamodelProduto.add(modelProduto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelProduto;
    }

    /**
     * atualiza Produto
     *
     * @param pModelProduto return boolean
     * @return 
     */
    public boolean atualizarProdutoDAO(ModelProdutos pModelProduto) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE tbl_produto SET "
                    + "pk_id_produto = '" + pModelProduto.getIdProduto() + "',"
                    + "pro_nome = '" + pModelProduto.getProNome() + "',"
                    + "pro_descricao = '" + pModelProduto.getProDescricao() + "',"
                    + "pro_marca = '" + pModelProduto.getProMarca() + "',"
                    + "pro_estoque = '" + pModelProduto.getProEstoque() + "',"
                    + "pro_valor = '" + pModelProduto.getProValor() + "',"
                    + "pro_valor_venda = '" + pModelProduto.getProValorVenda() + "',"
                    + "pro_valor_unitario = '" + pModelProduto.getProValorUnitario() + "'"
                    + " WHERE "
                    + "pk_id_produto = '" + pModelProduto.getIdProduto() + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * exclui Produto
     *
     * @param pIdProduto return boolean
     * @return 
     */
    public boolean excluirProdutoDAO(int pIdProduto) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM tbl_produto "
                    + " WHERE "
                    + "pk_id_produto = '" + pIdProduto + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * Alterar estoque de produtos no banco
     *
     * @param pListaModelProdutos
     * @return
     */
    public boolean alterarEstoqueProdutosDAO(ArrayList<ModelProdutos> pListaModelProdutos) {
        try {
            this.conectar();
            for (int i = 0; i < pListaModelProdutos.size(); i++) {
                this.executarUpdateDeleteSQL(
                        "UPDATE tbl_produto SET "
                        + "pro_estoque = '" + pListaModelProdutos.get(i).getProEstoque() + "'"
                        + " WHERE pk_id_produto = '" + pListaModelProdutos.get(i).getIdProduto() + "'"
                );
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * retornar um produto pelo nome
     *
     * @param pNomeProduto
     * @return modelproduto
     */
    public ModelProdutos retornarProdutoDAO(String pNomeProduto) {
        ModelProdutos modelProdutos = new ModelProdutos();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "pk_id_produto,"
                    + "pro_nome,"
                    + "pro_descricao,"
                    + "pro_marca,"
                    + "pro_estoque,"
                    + "pro_valor,"
                    + "pro_valor_venda,"
                    + "pro_valor_unitario"
                    + " FROM"
                    + " tbl_produto"
                    + " WHERE"
                    + " pro_nome = '" + pNomeProduto + "'"
                    + ";");
            while (this.getResultSet().next()) {
                modelProdutos = new ModelProdutos();
                modelProdutos.setIdProduto(this.getResultSet().getInt(1));
                modelProdutos.setProNome(this.getResultSet().getString(2));
                modelProdutos.setProDescricao(this.getResultSet().getString(3));
                modelProdutos.setProMarca(this.getResultSet().getString(4));
                modelProdutos.setProEstoque(this.getResultSet().getInt(5));
                modelProdutos.setProValor(this.getResultSet().getDouble(6));
                modelProdutos.setProValorVenda(this.getResultSet().getDouble(7));
                modelProdutos.setProValorUnitario(this.getResultSet().getDouble(8));
                //  listamodelProdutos.add(modelProduto);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelProdutos;
    }

    /**
     * Filtra produtos pela quantidade em estoque
     *
     * @param pEstoqueProduto
     * @return
     */
    public ModelProdutos filtrarEstoqueProdutosDAO(String pEstoqueProduto) {
        ModelProdutos modelProdutos = new ModelProdutos();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "pk_id_produto, "
                    + "pro_nome,"
                    + "pro_descricao,"
                    + "pro_marca,"
                    + "pro_estoque,"
                    + "pro_valor,"
                    + "pro_valor_venda,"
                    + "pro_valor_unitario"
                    + "FROM tbl_produto WHERE pro_estoque = '" + pEstoqueProduto + "';");
            while (this.getResultSet().next()) {
                modelProdutos = new ModelProdutos();
                modelProdutos.setIdProduto(this.getResultSet().getInt(1));
                modelProdutos.setProNome(this.getResultSet().getString(2));
                modelProdutos.setProDescricao(this.getResultSet().getString(3));
                modelProdutos.setProMarca(this.getResultSet().getString(4));
                modelProdutos.setProEstoque(this.getResultSet().getInt(5));
                modelProdutos.setProValor(this.getResultSet().getDouble(6));
                modelProdutos.setProValorVenda(this.getResultSet().getDouble(7));
                modelProdutos.setProValorUnitario(this.getResultSet().getDouble(8));
                //  listamodelProdutos.add(modelProduto);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelProdutos;
    }
}
