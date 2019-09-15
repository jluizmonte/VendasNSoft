package controller;

import model.ModelMarca;
import DAO.DAOMarca;
import java.util.ArrayList;

/**
*
* @author Jose Luiz
*/
public class ControllerMarca {

    private DAOMarca daoMarca = new DAOMarca();

    /**
    * grava Marca
    * @param pModelMarca
    * return int
    */
    public int salvarMarcaController(ModelMarca pModelMarca){
        return this.daoMarca.salvarMarcaDAO(pModelMarca);
    }

    /**
    * recupera Marca
    * @param pIdMarca
    * return ModelMarca
    */
    public ModelMarca getMarcaController(int pIdMarca){
        return this.daoMarca.getMarcaDAO(pIdMarca);
    }

    /**
    * recupera uma lista deMarca
    * @param pIdMarca
    * return ArrayList
    */
    public ArrayList<ModelMarca> getListaMarcaController(){
        return this.daoMarca.getListaMarcaDAO();
    }

    /**
    * atualiza Marca
    * @param pModelMarca
    * return boolean
    */
    public boolean atualizarMarcaController(ModelMarca pModelMarca){
        return this.daoMarca.atualizarMarcaDAO(pModelMarca);
    }

    /**
    * exclui Marca
    * @param pIdMarca
    * return boolean
    */
    public boolean excluirMarcaController(int pIdMarca){
        return this.daoMarca.excluirMarcaDAO(pIdMarca);
    }
}