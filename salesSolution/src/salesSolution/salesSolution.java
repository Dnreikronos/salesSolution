/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesSolution;

import apoio.ConexaoBD;
import java.sql.*;
import javax.swing.JOptionPane;
import tela.FrmPrincipal;
import tela.Login;

/**
 *
 * @author Soares
 */
public class salesSolution {

    static Connection conexao = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //new FrmPrincipal().setVisible(true);
//
//        if (abrirConexao()) {
//            new FrmPrincipal().setVisible(true);
//        } else {
//            JOptionPane.showMessageDialog(null, "Erro ao conectar no Banco de Dados!");
//        }

        // com classe ConexaoBD.java
//        if (ConexaoBD.getInstance().getConnection() != null) {
//            new FrmPrincipal().setVisible(true);
//        } else {
//            JOptionPane.showMessageDialog(null, "Erro ao conectar no Banco de Dados!");
//        }
        new Login(null, true).setVisible(true);
    }

//    private static boolean abrirConexao() {
//        try {
//            String dbdriver = "org.postgresql.Driver";
//            String dburl = "jdbc:postgresql://localhost:5432/oficina";
//            String dbuser = "postgres";
//            String dbsenha = "postgres";
//
//            // Carrega Driver do Banco de Dados
//            Class.forName(dbdriver);
//
//            if (dbuser.length() != 0) // conexão COM usuário e senha
//            {
//                conexao = DriverManager.getConnection(dburl, dbuser, dbsenha);
//            } else // conexão SEM usuário e senha
//            {
//                conexao = DriverManager.getConnection(dburl);
//            }
//
//            return true;
//
//        } catch (Exception e) {
//            System.err.println("Erro ao tentar conectar: " + e);
//            return false;
//        }
//    }
}
