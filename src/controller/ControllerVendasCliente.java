/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.ModelVendasCliente;
import DAO.DAOVendasCliente;

/**
 *
 * @author Jose Luiz
 */
public class ControllerVendasCliente {

    private DAOVendasCliente daoVendasClientes = new DAOVendasCliente();

    public ArrayList<ModelVendasCliente> getListaVendasClienteController() {
        return this.daoVendasClientes.getListaVendasClienteDAO();
    }

}
