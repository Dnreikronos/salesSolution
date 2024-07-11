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
import entidade.Produto;
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
public class ProdutoDAO implements IDAOT<Produto> {

    @Override
    public String salvar(Produto p) {
        // exemplo de insercao
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "insert into produto(descricao, valor_unitario, qtde_estoque) "
                    + "values"
                    + "("
                    + "'" + p.getDescricao()+ "',"
                    + "'" + p.getValorUnitario()+ "',"
                    + "'" + p.getQuantidadeEstoque()+ "')";

            System.out.println("SQL: " + sql);

            int retorno = st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao inserir Produto: " + e);
            return e.toString();
        }
    }

    public String atualizar(Produto p) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE produto "
          + "SET descricao = '" + p.getDescricao()+ "', "
          + "valor_unitario = '" + p.getValorUnitario()+ "', "
          + "qtde_estoque= '" + p.getQuantidadeEstoque()+ "', "
          + "WHERE id =  " + p.getId() ;

            System.out.println("SQL: " + sql);

            int retorno = st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar Produto: " + e);
            return e.toString();
        }
    }

    public String excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "delete from produto "
                    + "where id = " + id;

            System.out.println("SQL: " + sql);

            int retorno = st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao excluir Produto: " + e);
            return e.toString();
        }

    }

    @Override
    public ArrayList<Produto> consultarTodos() {

        ArrayList<Produto> produtos = new ArrayList();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "select id, descricao, valor_unitario, qtde_estoque "
                    + "from produtos"
                    + "order by descricao";

            System.out.println("SQL: " + sql);

            ResultSet retorno = st.executeQuery(sql);

            while (retorno.next()) {
                Produto produto = new Produto();

                produto.setId(retorno.getInt("id"));
                produto.setDescricao(retorno.getString("estoque"));
                produto.setValorUnitario(retorno.getString("valor_unitario"));
                produto.setQuantidadeEstoque(retorno.getString("qtde_estoque"));

                produtos.add(produto);

            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar Produtos: " + e);
        }

        return produtos;
    }

    public void popularTabela(JTable tabela, String criterio) {

        ResultSet resultadoQ;

        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[4];
        cabecalho[0] = "Id";
        cabecalho[1] = "Descrião";
        cabecalho[2] = "Valor Unitário";
        cabecalho[3] = "Qtde Estoque";

        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) "
                    + "FROM produto "
                    + "WHERE "
                    + "descricao ILIKE '%" + criterio + "%'");

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][5];

        } catch (Exception e) {
            System.out.println("Erro ao consultar produtos: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * "
                    + "FROM PRODUTO "
                    + "WHERE "
                    + "DESCRICAO ILIKE '%" + criterio + "%' "
                    + "ORDER BY DESCRICAO");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("id");
                dadosTabela[lin][1] = resultadoQ.getString("descricao");
                dadosTabela[lin][2] = resultadoQ.getString("valor_unitario");
                dadosTabela[lin][3] = resultadoQ.getString("qtde_estoque");

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

    public Produto consultarId(int id) {

        Produto produto = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "select * "
                    + "from produto "
                    + "where id = " + id;

            System.out.println("SQL: " + sql);

            ResultSet retorno = st.executeQuery(sql);

            while (retorno.next()) {
                produto = new Produto();

                produto.setId(retorno.getInt("id"));
                produto.setDescricao(retorno.getString("descricao"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar Produto: " + e);
        }

        return produto;
    }
}
