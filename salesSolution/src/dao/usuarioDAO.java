                                                          /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Usuario;
import entidade.Usuario;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author hique
 */
public class usuarioDAO implements IDAOT <Usuario>{

    @Override
    public String salvar(Usuario o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String atualizar(Usuario o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Usuario> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<Usuario> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Usuario consultarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean Autenticar(Usuario u) {
        try {
             String sql
                    = "SELECT email, senha "
                    + "FROM usuario "
                    + "WHERE "
                    + "email = '" + u.getEmail() + "' and "
                    + "senha = md5 ('" + u.getSenha() + "') and "
                    + "situacao = 'a'";
            
            System.out.println("SQL:" + sql);
            ResultSet resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            if (resultadoQ.next()) {
                return true;
            } else {
                return false;
            }
                    
        }
        catch(Exception e){
            System.out.println("Erro ao autenticar usuario: " + e);
            return false;
        }
    }
}
