/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import apoio.Formatacao;
import apoio.IItemPesquisa;
import dao.CompraDAO;
import dao.CompraItemDAO;
import dao.FornecedorDAO;
import dao.ProdutoDAO;
import entidade.Compra;
import entidade.CompraItem;
import javax.swing.JOptionPane;

/**
 *
 * @author pretto
 */
public class IfrCompra extends javax.swing.JInternalFrame implements IItemPesquisa {

    int idCompra = 0;
    double total = 0.0;

    /**
     * Creates new form IfrOS
     */
    public IfrCompra() {
        initComponents();

        // setup
        tffDataCompra.setText(Formatacao.getDataAtual());

        tfdIdFornecedor.setEditable(false);
        tfdNomeFornecedor.setEditable(false);
        tfdTotal.setEditable(false);

        tfdIdProduto.setEditable(false);
        tfdProduto.setEditable(false);
        tfdValor.setEditable(false);

        btnLocalizarProduto.setEnabled(false);
        btnRemover.setEnabled(false);
        btnInserir.setEnabled(false);
        new CompraItemDAO().popularTabelaSemId(tblCompraItem, "");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tffDataCompra = new javax.swing.JFormattedTextField();
        tfdNomeFornecedor = new javax.swing.JTextField();
        tfdIdFornecedor = new javax.swing.JTextField();
        btnLocalizarFornecedor = new javax.swing.JButton();
        btnCriar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCompraItem = new javax.swing.JTable();
        tfdProduto = new javax.swing.JTextField();
        btnLocalizarProduto = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        tfdValor = new javax.swing.JTextField();
        tfdIdProduto = new javax.swing.JTextField();
        btnInserir = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tfdQtde = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfdTotal = new javax.swing.JTextField();

        setTitle("Compra");

        jLabel1.setText("Data");

        jLabel2.setText("Fornecedor");

        tffDataCompra.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        btnLocalizarFornecedor.setText("Localizar");
        btnLocalizarFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalizarFornecedorActionPerformed(evt);
            }
        });

        btnCriar.setText("Criar");
        btnCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarActionPerformed(evt);
            }
        });

        jLabel3.setText("Produto");

        tblCompraItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblCompraItem);

        btnLocalizarProduto.setText("Localizar");
        btnLocalizarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalizarProdutoActionPerformed(evt);
            }
        });

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        btnInserir.setText("Inserir");
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        jLabel4.setText("Quantidade");

        jLabel5.setText("TOTAL");

        tfdTotal.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        tfdTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCriar)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfdTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnFechar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfdQtde, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                                    .addComponent(tfdIdProduto))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(tfdValor, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnLocalizarProduto))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tffDataCompra)
                            .addComponent(tfdIdFornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
                        .addGap(5, 5, 5)
                        .addComponent(tfdNomeFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLocalizarFornecedor)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(tffDataCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfdNomeFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdIdFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLocalizarFornecedor))
                .addGap(26, 26, 26)
                .addComponent(btnCriar)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLocalizarProduto)
                    .addComponent(tfdValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInserir)
                    .addComponent(btnRemover)
                    .addComponent(jLabel4)
                    .addComponent(tfdQtde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFechar)
                    .addComponent(jLabel5)
                    .addComponent(tfdTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnLocalizarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizarFornecedorActionPerformed
        new DlgLocalizar(null, true, this, "fornecedor").setVisible(true);
    }//GEN-LAST:event_btnLocalizarFornecedorActionPerformed

    private void btnLocalizarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizarProdutoActionPerformed
        new DlgLocalizar(null, true, this, "produto").setVisible(true);
        
    }//GEN-LAST:event_btnLocalizarProdutoActionPerformed

    private void btnCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarActionPerformed

        Compra compra = new Compra();
        
        compra.setData(tffDataCompra.getText());
        compra.setFornecedor_id(Integer.parseInt(tfdIdFornecedor.getText()));

        String retorno = new CompraDAO().salvar(compra);

        System.out.println("Id compra retorno: " + retorno);

        if (!retorno.contains("ERROR")) {
            idCompra = Integer.parseInt(retorno);

            btnCriar.setEnabled(false);
            btnLocalizarProduto.setEnabled(true);
            btnRemover.setEnabled(true);
            btnInserir.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao criar Compra: " + retorno);
        }
    }//GEN-LAST:event_btnCriarActionPerformed

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        CompraItem compraItem = new CompraItem();

        compraItem.setCompraId(idCompra);
        compraItem.setProdutoId(Integer.parseInt(tfdIdProduto.getText()));
        compraItem.setQtde(Double.parseDouble(tfdQtde.getText()));
        compraItem.setValor(Double.parseDouble(tfdValor.getText()));

        if (new CompraItemDAO().salvar(compraItem) == null) {
            JOptionPane.showMessageDialog(null, "Produto inserido.");

            new CompraItemDAO().popularTabela(tblCompraItem, "", idCompra);

            total += (compraItem.getValor() * compraItem.getQtde());

            tfdTotal.setText(String.valueOf(total));

            tfdIdProduto.setText("");
            tfdProduto.setText("");
            tfdValor.setText("");
            tfdQtde.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Erro na inserção.");
        }
    }//GEN-LAST:event_btnInserirActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        if (tblCompraItem.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Selecione um registro.");
        } else {
            int idCompraIt = Integer.parseInt(String.valueOf(tblCompraItem.getValueAt(tblCompraItem.getSelectedRow(), 0)));

            System.out.println("CompraIt: " + idCompraIt);

            String retorno = new CompraItemDAO().excluir(idCompraIt);

            if (retorno == null) {
                JOptionPane.showMessageDialog(null, "Registro remvodio.");

                double qtde = Double.parseDouble(String.valueOf(tblCompraItem.getValueAt(tblCompraItem.getSelectedRow(), 3)));
                double valor = Double.parseDouble(String.valueOf(tblCompraItem.getValueAt(tblCompraItem.getSelectedRow(), 4)));

                total -= (qtde * valor);

                tfdTotal.setText(String.valueOf(total));

                new CompraItemDAO().popularTabela(tblCompraItem, "", idCompra);
            } else {
                JOptionPane.showMessageDialog(null, "Erro: Problemas ao remover registro.\n\n" + retorno);
            }
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    @Override
    public void definirValor(String[] valores, String itemPesquisa) {
        if (itemPesquisa.equalsIgnoreCase("fornecedor")) {
            tfdIdFornecedor.setText(valores[0]);
            tfdNomeFornecedor.setText(valores[1]);
        } else if (itemPesquisa.equalsIgnoreCase("produto")) {
            tfdIdProduto.setText(valores[0]);
            tfdProduto.setText(valores[1]);
            tfdValor.setText(valores[2]);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCriar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnLocalizarFornecedor;
    private javax.swing.JButton btnLocalizarProduto;
    private javax.swing.JButton btnRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCompraItem;
    private javax.swing.JTextField tfdIdFornecedor;
    private javax.swing.JTextField tfdIdProduto;
    private javax.swing.JTextField tfdNomeFornecedor;
    private javax.swing.JTextField tfdProduto;
    private javax.swing.JTextField tfdQtde;
    private javax.swing.JTextField tfdTotal;
    private javax.swing.JTextField tfdValor;
    private javax.swing.JFormattedTextField tffDataCompra;
    // End of variables declaration//GEN-END:variables

}
