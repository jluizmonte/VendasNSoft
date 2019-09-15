package model;
/**
*
* @author Jose Luiz
*/
public class ModelUsuario {

    private int idUsuario;
    private String usuNome;
    private String usuLogin;
    private String usuSenha;
    private String usuNivel;

    /**
    * Construtor
    */
    public ModelUsuario(){}

    /**
    * seta o valor de idUsuario
    * @param pIdUsuario
    */
    public void setIdUsuario(int pIdUsuario){
        this.idUsuario = pIdUsuario;
    }
    /**
    * return pk_idUsuario
     * @return 
    */
    public int getIdUsuario(){
        return this.idUsuario;
    }

    /**
    * seta o valor de usuNome
    * @param pUsuNome
    */
    public void setUsuNome(String pUsuNome){
        this.usuNome = pUsuNome;
    }
    /**
    * return usuNome
     * @return 
    */
    public String getUsuNome(){
        return this.usuNome;
    }

    /**
    * seta o valor de usuLogin
    * @param pUsuLogin
    */
    public void setUsuLogin(String pUsuLogin){
        this.usuLogin = pUsuLogin;
    }
    /**
    * return usuLogin
     * @return 
    */
    public String getUsuLogin(){
        return this.usuLogin;
    }

    /**
    * seta o valor de usuSenha
    * @param pUsuSenha
    */
    public void setUsuSenha(String pUsuSenha){
        this.usuSenha = pUsuSenha;
    }
    /**
    * return usuSenha
     * @return 
    */
    public String getUsuSenha(){
        return this.usuSenha;
    }

    /**
     * @return the usuNivel
     */
    public String getUsuNivel() {
        return usuNivel;
    }

    /**
     * @param usuNivel the usuNivel to set
     */
    public void setUsuNivel(String usuNivel) {
        this.usuNivel = usuNivel;
    }

    @Override
    public String toString(){
        return "ModelUsuario {" + "::idUsuario = " + this.idUsuario + "::usuNome = " + this.usuNome + "::usuLogin = " + this.usuLogin + "::usuSenha = " + this.usuSenha +  "}";
    }
}