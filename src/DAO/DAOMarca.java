package DAO;

import model.ModelMarca;
import conexoes.ConexaoMySql;
import java.util.ArrayList;

/**
 *
 * @author Jose Luiz
 */
public class DAOMarca extends ConexaoMySql {

    /**
     * grava Marca
     *
     * @param pModelMarca return int
     */
    public int salvarMarcaDAO(ModelMarca pModelMarca) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO tbl_marca ("
                    + "pk_id_marca,"
                    + "marca"
                    + ") VALUES ("
                    + "'" + pModelMarca.getIdMarca() + "',"
                    + "'" + pModelMarca.getMarca() + "'"
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
     * recupera Marca
     *
     * @param pIdMarca return ModelMarca
     */
    public ModelMarca getMarcaDAO(int pIdMarca) {
        ModelMarca modelMarca = new ModelMarca();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_id_marca,"
                    + "marca"
                    + " FROM"
                    + " tbl_marca"
                    + " WHERE"
                    + " pk_id_marca = '" + pIdMarca + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelMarca.setIdMarca(this.getResultSet().getInt(1));
                modelMarca.setMarca(this.getResultSet().getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelMarca;
    }

    /**
     * recupera uma lista de Marca return ArrayList
     */
    public ArrayList<ModelMarca> getListaMarcaDAO() {
        ArrayList<ModelMarca> listamodelMarca = new ArrayList();
        ModelMarca modelMarca = new ModelMarca();
        try {
            this.conectar();
            this.executarSQL(
                    /* "SELECT "
                    + "pk_id_marca,"
                    + "marca"
                    + " FROM"
                    + " tbl_marca"
                    + "ORDER BY marca ASC"
                    + ";"*/
                    "SELECT * FROM `tbl_marca` ORDER BY marca ASC;"
            );

            while (this.getResultSet().next()) {
                modelMarca = new ModelMarca();
                modelMarca.setIdMarca(this.getResultSet().getInt(1));
                modelMarca.setMarca(this.getResultSet().getString(2));
                listamodelMarca.add(modelMarca);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelMarca;
    }

    /**
     * atualiza Marca
     *
     * @param pModelMarca return boolean
     */
    public boolean atualizarMarcaDAO(ModelMarca pModelMarca) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE tbl_marca SET "
                    + "pk_id_marca = '" + pModelMarca.getIdMarca() + "',"
                    + "marca = '" + pModelMarca.getMarca() + "'"
                    + " WHERE "
                    + "pk_id_marca = '" + pModelMarca.getIdMarca() + "'"
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
     * exclui Marca
     *
     * @param pIdMarca return boolean
     */
    public boolean excluirMarcaDAO(int pIdMarca) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM tbl_marca "
                    + " WHERE "
                    + "pk_id_marca = '" + pIdMarca + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }
}
