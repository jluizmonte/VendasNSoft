package model;
/**
*
* @author Jose Luiz
*/
public class ModelMarca {

    private int idMarca;
    private String marca;

    /**
    * Construtor
    */
    public ModelMarca(){}

    /**
    * seta o valor de idMarca
    * @param pIdMarca
    */
    public void setIdMarca(int pIdMarca){
        this.idMarca = pIdMarca;
    }
    /**
    * return pk_idMarca
    */
    public int getIdMarca(){
        return this.idMarca;
    }

    /**
    * seta o valor de marca
    * @param pMarca
    */
    public void setMarca(String pMarca){
        this.marca = pMarca;
    }
    /**
    * return marca
    */
    public String getMarca(){
        return this.marca;
    }

    @Override
    public String toString(){
        return "ModelMarca {" + "::idMarca = " + this.idMarca + "::marca = " + this.marca +  "}";
    }
}