package controller;

import model.ModelUsuario;
import DAO.DAOUsuario;
import java.util.ArrayList;

/**
 *
 * @author Jose Luiz
 */
public class ControllerUsuario {

    private final DAOUsuario daoUsuario = new DAOUsuario();

    /**
     * grava Usuario
     *
     * @param pModelUsuario return int
     * @return
     */
    public int salvarUsuarioController(ModelUsuario pModelUsuario) {
        return this.daoUsuario.salvarUsuarioDAO(pModelUsuario);
    }

    /**
     * recupera Usuario
     *
     * @param pIdUsuario return ModelUsuario
     * @return
     */
    public ModelUsuario getUsuarioController(int pIdUsuario) {
        return this.daoUsuario.getUsuarioDAO(pIdUsuario);
    }

    /**
     * recupera Usuario
     *
     * @param pLogin return ModelUsuario
     * @return
     */
    public ModelUsuario getUsuarioController(String pLogin) {
        return this.daoUsuario.getUsuarioDAO(pLogin);
    }

    /**
     * recupera uma lista deUsuario
     *
     * @return
     */
    public ArrayList<ModelUsuario> getListaUsuarioController() {
        return this.daoUsuario.getListaUsuarioDAO();
    }

    /**
     * atualiza Usuario
     *
     * @param pModelUsuario return boolean
     * @return
     */
    public boolean atualizarUsuarioController(ModelUsuario pModelUsuario) {
        return this.daoUsuario.atualizarUsuarioDAO(pModelUsuario);
    }

    /**
     * exclui Usuario
     *
     * @param pIdUsuario return boolean
     * @return
     */
    public boolean excluirUsuarioController(int pIdUsuario) {
        return this.daoUsuario.excluirUsuarioDAO(pIdUsuario);
    }

    /**
     * Validar login e senha do usuário
     *
     * @param pModelUsuario
     * @return
     */
    public boolean getValidarUsuarioController(ModelUsuario pModelUsuario) {
        return this.daoUsuario.getValidarUsuarioDAO(pModelUsuario);

    }
}
