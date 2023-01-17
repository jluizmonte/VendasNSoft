package utilidades;

import java.io.*;

/**
 *
 * @author Jose Luiz
 */
public class CriarLocalPadrao {

    ObterInfoSistema info = new ObterInfoSistema();
    static String diretorioUsuario;
    static String diretorioPadrao = System.getProperty("user.home");
    String tema;

    public void criarPastaPadrao() throws IOException {

        if (info.getNomeSistema().equals("Windows 7")
                || info.getNomeSistema().equals("Windows 8")
                || info.getNomeSistema().equals("Windows 8.1")
                || info.getNomeSistema().equals("Windows 10")) {
            diretorioUsuario = "C:/Vendas/NSoft";
        } else {
            diretorioUsuario = diretorioPadrao + "/Vendas/NSoft";
        }
        File diretorio = new File(diretorioUsuario);
        diretorio.mkdir();
        if (!diretorio.exists()) {
            diretorio.createNewFile();
        }
    }
}
