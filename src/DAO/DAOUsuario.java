package DAO;

import model.ModelUsuario;
import conexoes.ConexaoMySql;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jose Luiz
 */
public class DAOUsuario extends ConexaoMySql {

    /**
     * grava Usuario
     *
     * @param pModelUsuario return int
     * @return
     */
    public int salvarUsuarioDAO(ModelUsuario pModelUsuario) {
        try {
            this.conectar();
            return this.insertSQL(
                    "'" + "INSERT INTO tbl_usuario ("
                    + "usu_nome,"
                    + "usu_login,"
                    + "usu_senha,"
                    + "usu_nivel"
                    + ") VALUES ("
                    + "'" + pModelUsuario.getUsuNome() + "',"
                    + "'" + pModelUsuario.getUsuLogin() + "',"
                    + "'" + pModelUsuario.getUsuSenha() + ","
                    + "'" + pModelUsuario.getUsuNivel() + "'"
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
     * recupera Usuario
     *
     * @param pIdUsuario return ModelUsuario
     * @return
     */
    public ModelUsuario getUsuarioDAO(int pIdUsuario) {
        ModelUsuario modelUsuario = new ModelUsuario();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_id_usuario,"
                    + "usu_nome,"
                    + "usu_login,"
                    + "usu_senha,"
                    + "usu_nivel"
                    + " FROM"
                    + " tbl_usuario"
                    + " WHERE"
                    + " pk_id_usuario = '" + pIdUsuario + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelUsuario.setIdUsuario(this.getResultSet().getInt(1));
                modelUsuario.setUsuNome(this.getResultSet().getString(2));
                modelUsuario.setUsuLogin(this.getResultSet().getString(3));
                modelUsuario.setUsuSenha(this.getResultSet().getString(4));
                modelUsuario.setUsuNivel(this.getResultSet().getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelUsuario;
    }

    /**
     * recupera Usuario
     *
     * @param pLogin return ModelUsuario
     * @return
     */
    public ModelUsuario getUsuarioDAO(String pLogin) {
        ModelUsuario modelUsuario = new ModelUsuario();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_id_usuario,"
                    + "usu_nome,"
                    + "usu_login,"
                    + "usu_senha,"
                    + "usu_nivel"
                    + " FROM"
                    + " tbl_usuario"
                    + " WHERE"
                    + " usu_login = '" + pLogin + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelUsuario.setIdUsuario(this.getResultSet().getInt(1));
                modelUsuario.setUsuNome(this.getResultSet().getString(2));
                modelUsuario.setUsuLogin(this.getResultSet().getString(3));
                modelUsuario.setUsuSenha(this.getResultSet().getString(4));
                modelUsuario.setUsuNivel(this.getResultSet().getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelUsuario;
    }

    /**
     * recupera uma lista de Usuario return ArrayList
     *
     * @return
     */
    public ArrayList<ModelUsuario> getListaUsuarioDAO() {
        ArrayList<ModelUsuario> listamodelUsuario = new ArrayList();
        ModelUsuario modelUsuario = new ModelUsuario();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_id_usuario,"
                    + "usu_nome,"
                    + "usu_login,"
                    + "usu_senha,"
                    + "usu_nivel"
                    + " FROM"
                    + " tbl_usuario"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelUsuario = new ModelUsuario();
                modelUsuario.setIdUsuario(this.getResultSet().getInt(1));
                modelUsuario.setUsuNome(this.getResultSet().getString(2));
                modelUsuario.setUsuLogin(this.getResultSet().getString(3));
                modelUsuario.setUsuSenha(this.getResultSet().getString(4));
                modelUsuario.setUsuNivel(this.getResultSet().getString(5));
                listamodelUsuario.add(modelUsuario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelUsuario;
    }

    /**
     * atualiza Usuario
     *
     * @param pModelUsuario return boolean
     * @return
     */
    public boolean atualizarUsuarioDAO(ModelUsuario pModelUsuario) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE tbl_usuario SET "
                    + "pk_id_usuario = '" + pModelUsuario.getIdUsuario() + "',"
                    + "usu_nome = '" + pModelUsuario.getUsuNome() + "',"
                    + "usu_login = '" + pModelUsuario.getUsuLogin() + "',"
                    + "usu_senha = '" + pModelUsuario.getUsuSenha() + ","
                    + "usu_nivel = '" + pModelUsuario.getUsuNivel() + "'"
                    + " WHERE "
                    + "pk_id_usuario = '" + pModelUsuario.getIdUsuario() + "'"
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
     * exclui Usuario
     *
     * @param pIdUsuario return boolean
     * @return
     */
    public boolean excluirUsuarioDAO(int pIdUsuario) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM tbl_usuario "
                    + " WHERE "
                    + "pk_id_usuario = '" + pIdUsuario + "'"
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
     * Validar login e senha do usuário
     *
     * @param pModelUsuario
     * @return
     */
    public boolean getValidarUsuarioDAO(ModelUsuario pModelUsuario) {
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_id_usuario,"
                    + "usu_nome,"
                    + "usu_login,"
                    + "usu_senha"
                 /*   + "usu_nivel"*/
                    + " FROM"
                    + " tbl_usuario"
                    + " WHERE"
                    + " usu_login = '" + pModelUsuario.getUsuLogin() + "' AND usu_senha = '" + pModelUsuario.getUsuSenha() + "'"
                    + ";"
            );

            if (getResultSet().next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }
}