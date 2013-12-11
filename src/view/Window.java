package view;

import controller.Controller;
import interfaces.IController;
import java.awt.Canvas;
import java.awt.Graphics;
import parser.RecursiveDescentSyntaticAnalyzerTest;

/**
 *
 * @author
 * Muta
 */
public class Window extends javax.swing.JFrame {
	
	Controller controller;
	Graphics g;
	
	public Window() {
		initComponents();
		controller = new Controller();
	}

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        javax.swing.JButton bt_run = new javax.swing.JButton();
        Canvas = new javax.swing.JPanel();

        jButton1.setText("jButton1");

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bt_run.setText("Run");
        bt_run.setActionCommand("bt_run");
        bt_run.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_runActionPerformed(evt);
            }
        });

        Canvas.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout CanvasLayout = new javax.swing.GroupLayout(Canvas);
        Canvas.setLayout(CanvasLayout);
        CanvasLayout.setHorizontalGroup(
            CanvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        CanvasLayout.setVerticalGroup(
            CanvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 467, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bt_run)
                .addContainerGap(451, Short.MAX_VALUE))
            .addComponent(Canvas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(Canvas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_run)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_runActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_runActionPerformed
		controller.executa();
    }//GEN-LAST:event_bt_runActionPerformed

	public static Graphics getMyGraphics(){
		return Canvas.getGraphics();
	}
	
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Window().setVisible(true);
				RecursiveDescentSyntaticAnalyzerTest rdsat = new RecursiveDescentSyntaticAnalyzerTest();
                rdsat.run("./src/logo/first.logo");
//				Controller.printListaT();
			}
		});
	}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JPanel Canvas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
}
