/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Compra;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author pretto
 */
public class CompraDAO implements IDAOT<Compra> {

    @Override
    public String salvar(Compra o) {

        String retornoConsulta = "";

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "insert into compra "
                    + "values"
                    + "(default, "
                    + "'" + o.getData() + "', "
                    + "" + o.getFornecedor_id() + ") returning id";

            System.out.println("SQL: " + sql);

            ResultSet retorno = st.executeQuery(sql);

            if (retorno.next()) 
                retornoConsulta = retorno.getString(1);
 
        } catch (Exception e) {
            System.out.println("Erro ao inserir Compra: " + e);
            retornoConsulta = "ERROR:" + e.toString();
        }
        return retornoConsulta;
    }

    public String atualizar(Compra o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Compra> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Compra> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Compra consultarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
