/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;
import java.io.*;
import javax.swing.UIManager;
import jdk.nashorn.internal.codegen.CompilerConstants;
import view.LoginView;

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
