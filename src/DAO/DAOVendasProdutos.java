package DAO;

import model.ModelVendasProdutos;
import conexoes.ConexaoMySql;
import java.util.ArrayList;

/**
 *
 * @author Jose Luiz
 */
public class DAOVendasProdutos extends ConexaoMySql {

    /**
     * grava VendasProdutos
     *
     * @param pModelVendasProdutos return int
     */
    public int salvarVendasProdutosDAO(ModelVendasProdutos pModelVendasProdutos) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO tbl_vendas_produtos ("
                    + "fk_produto,"
                    + "fk_vendas,"
                    + "vendas_pro_valor,"
                    + "ven_pro_quantidade"
                    + ") VALUES ("
                    + "'" + pModelVendasProdutos.getProduto() + "',"
                    + "'" + pModelVendasProdutos.getVendas() + "',"
                    + "'" + pModelVendasProdutos.getVendasProValor() + "',"
                    + "'" + pModelVendasProdutos.getVenProQuantidade() + "'"
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
     * recupera VendasProdutos
     *
     * @param pIdVendaProduto return ModelVendasProdutos
     */
    public ModelVendasProdutos getVendasProdutosDAO(int pIdVendaProduto) {
        ModelVendasProdutos modelVendasProdutos = new ModelVendasProdutos();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_id_venda_produto,"
                    + "fk_produto,"
                    + "fk_vendas,"
                    + "vendas_pro_valor,"
                    + "ven_pro_quantidade"
                    + " FROM"
                    + " tbl_vendas_produtos"
                    + " WHERE"
                    + " pk_id_venda_produto = '" + pIdVendaProduto + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelVendasProdutos.setIdVendaProduto(this.getResultSet().getInt(1));
                modelVendasProdutos.setProduto(this.getResultSet().getInt(2));
                modelVendasProdutos.setVendas(this.getResultSet().getInt(3));
                modelVendasProdutos.setVendasProValor(this.getResultSet().getDouble(4));
                modelVendasProdutos.setVenProQuantidade(this.getResultSet().getInt(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelVendasProdutos;
    }

    /**
     * recupera uma lista de VendasProdutos return ArrayList
     */
    public ArrayList<ModelVendasProdutos> getListaVendasProdutosDAO() {
        ArrayList<ModelVendasProdutos> listamodelVendasProdutos = new ArrayList();
        ModelVendasProdutos modelVendasProdutos = new ModelVendasProdutos();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_id_venda_produto,"
                    + "fk_produto,"
                    + "fk_vendas,"
                    + "vendas_pro_valor,"
                    + "ven_pro_quantidade"
                    + " FROM"
                    + " tbl_vendas_produtos"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelVendasProdutos = new ModelVendasProdutos();
                modelVendasProdutos.setIdVendaProduto(this.getResultSet().getInt(1));
                modelVendasProdutos.setProduto(this.getResultSet().getInt(2));
                modelVendasProdutos.setVendas(this.getResultSet().getInt(3));
                modelVendasProdutos.setVendasProValor(this.getResultSet().getDouble(4));
                modelVendasProdutos.setVenProQuantidade(this.getResultSet().getInt(5));
                listamodelVendasProdutos.add(modelVendasProdutos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelVendasProdutos;
    }

    /**
     * atualiza VendasProdutos
     *
     * @param pModelVendasProdutos return boolean
     */
    public boolean atualizarVendasProdutosDAO(ModelVendasProdutos pModelVendasProdutos) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE tbl_vendas_produtos SET "
                    + "pk_id_venda_produto = '" + pModelVendasProdutos.getIdVendaProduto() + "',"
                    + "fk_produto = '" + pModelVendasProdutos.getProduto() + "',"
                    + "fk_vendas = '" + pModelVendasProdutos.getVendas() + "',"
                    + "vendas_pro_valor = '" + pModelVendasProdutos.getVendasProValor() + "',"
                    + "ven_pro_quantidade = '" + pModelVendasProdutos.getVenProQuantidade() + "'"
                    + " WHERE "
                    + "pk_id_venda_produto = '" + pModelVendasProdutos.getIdVendaProduto() + "'"
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
     * exclui VendasProdutos
     *
     * @param pIdVendaProduto return boolean
     */
    public boolean excluirVendasProdutosDAO(int pIdVendaProduto) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM tbl_vendas_produtos "
                    + " WHERE "
                    + "fk_vendas = '" + pIdVendaProduto + "'"
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
     * Salva uma lista de produtos da venda
     *
     * @param plistaModelVendasProdutos
     * @return
     */
    public boolean salvarVendasProdutosDAO(ArrayList<ModelVendasProdutos> plistaModelVendasProdutos) {
        try {
            this.conectar();
            int cont = plistaModelVendasProdutos.size();
            for (int i = 0; i < cont; i++) {
                this.insertSQL(
                        "INSERT INTO tbl_vendas_produtos ("
                        + "fk_vendas,"
                        + "fk_produto,"
                        + "ven_pro_valor,"
                        + "ven_pro_quantidade"
                        + ") VALUES ("
                        + "'" + plistaModelVendasProdutos.get(i).getVendas() + "',"
                        + "'" + plistaModelVendasProdutos.get(i).getProduto() + "',"
                        + "'" + plistaModelVendasProdutos.get(i).getVendasProValor() + "',"
                        + "'" + plistaModelVendasProdutos.get(i).getVenProQuantidade() + "'"
                        + ");"
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
}
