/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Cliente;
import entidade.Fornecedor;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Soares
 */
public class ClienteDAO implements IDAOT<Cliente> {

    @Override
    public String salvar(Cliente c) {
        // exemplo de insercao
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "insert into cliente(nome, email, cpf, telefone) "
                    + "values"
                    + "("
                    + "'" + c.getNome() + "',"
                    + "'" + c.getEmail() + "',"
                    + "'" + c.getCpf() + "',"
                    + "'" + c.getTelefone() + "')";

            System.out.println("SQL: " + sql);

            int retorno = st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao inserir Cliente: " + e);
            return e.toString();
        }
    }

    public String atualizar(Cliente c) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE cliente "
          + "SET nome = '" + c.getNome() + "', "
          + "email = '" + c.getEmail() + "', "
          + "telefone = '" + c.getTelefone() + "', "
          + "cpf = '" + c.getCpf() + "' "
          + "WHERE id =  " + c.getId() ;

            System.out.println("SQL: " + sql);

            int retorno = st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar Cliente: " + e);
            return e.toString();
        }
    }

    public String excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "delete from cliente "
                    + "where id = " + id;

            System.out.println("SQL: " + sql);

            int retorno = st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao excluir Cliente: " + e);
            return e.toString();
        }

    }

    @Override
    public ArrayList<Cliente> consultarTodos() {

        ArrayList<Cliente> clientes = new ArrayList();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "select id, nome, email, cpf , telefone  "
                    + "from cliente"
                    + "order by nome";

            System.out.println("SQL: " + sql);

            ResultSet retorno = st.executeQuery(sql);

            while (retorno.next()) {
                Cliente cliente = new Cliente();

                cliente.setId(retorno.getInt("id"));
                cliente.setNome(retorno.getString("nome"));
                cliente.setEmail(retorno.getString("email"));
                cliente.setCpf(retorno.getString("cpf"));
                cliente.setTelefone(retorno.getString("telefone"));

                clientes.add(cliente);

            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar Clientes: " + e);
        }

        return clientes;
    }

    public void popularTabela(JTable tabela, String criterio) {

        ResultSet resultadoQ;

        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[5];
        cabecalho[0] = "Id";
        cabecalho[1] = "Nome";
        cabecalho[2] = "E-mail";
        cabecalho[3] = "CPF";
        cabecalho[4] = "Telefone";

        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) "
                    + "FROM cliente "
                    + "WHERE "
                    + "nome ILIKE '%" + criterio + "%'");

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][5];

        } catch (Exception e) {
            System.out.println("Erro ao consultar clientes: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * "
                    + "FROM cliente "
                    + "WHERE "
                    + "NOME ILIKE '%" + criterio + "%' "
                    + "ORDER BY nome");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("id");
                dadosTabela[lin][1] = resultadoQ.getString("nome");
                dadosTabela[lin][2] = resultadoQ.getString("email");
                dadosTabela[lin][3] = resultadoQ.getString("cpf");
                dadosTabela[lin][4] = resultadoQ.getString("telefone");

                // caso a coluna precise exibir uma imagem
//                if (resultadoQ.getBoolean("Situacao")) {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_ativo.png"));
//                } else {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_inativo.png"));
//                }
                lin++;
            }
        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }

        // configuracoes adicionais no componente tabela
        tabela.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
            @Override
            // quando retorno for FALSE, a tabela nao é editavel
            public boolean isCellEditable(int row, int column) {
                return false;
                /*  
                 if (column == 3) {  // apenas a coluna 3 sera editavel
                 return true;
                 } else {
                 return false;
                 }
                 */
            }

            // alteracao no metodo que determina a coluna em que o objeto ImageIcon devera aparecer
            @Override
            public Class getColumnClass(int column) {

                if (column == 2) {
//                    return ImageIcon.class;
                }
                return Object.class;
            }
        });

        // permite selecao de apenas uma linha da tabela
        tabela.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < tabela.getColumnCount(); i++) {
            column = tabela.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(17);
                    break;
                case 1:
                    column.setPreferredWidth(140);
                    break;
//                case 2:
//                    column.setPreferredWidth(14);
//                    break;
            }
        }

        // renderizacao das linhas da tabela = mudar a cor
//        jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
//
//            @Override
//            public Component getTableCellRendererComponent(JTable table, Object value,
//                    boolean isSelected, boolean hasFocus, int row, int column) {
//                super.getTableCellRendererComponent(table, value, isSelected,
//                        hasFocus, row, column);
//                if (row % 2 == 0) {
//                    setBackground(Color.GREEN);
//                } else {
//                    setBackground(Color.LIGHT_GRAY);
//                }
//                return this;
//            }
//        });
    }

    public Cliente consultarId(int id) {

        Cliente cliente = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "select * "
                    + "from cliente "
                    + "where id = " + id;

            System.out.println("SQL: " + sql);

            ResultSet retorno = st.executeQuery(sql);

            while (retorno.next()) {
                cliente = new Cliente();

                cliente.setId(retorno.getInt("id"));
                cliente.setNome(retorno.getString("nome"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar Cliente: " + e);
        }

        return cliente;
    }
}
