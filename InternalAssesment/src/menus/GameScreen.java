package menus;

import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;
import tools.Location;
import tools.Constants;
import tools.Mover;

/**
 *
 * @author b.baccari
 */
public class GameScreen extends javax.swing.JFrame {

    Constants con = new Constants();
    public JLabel[] labels = new JLabel[con.TOTAL];
    public Border border = BorderFactory.createLineBorder(Color.DARK_GRAY, 2);
    public Border border2 = BorderFactory.createLineBorder(Color.BLACK, 2);
    Location location = new Location();
    Mover mover = new Mover();
    public int startingX = 13;
    public int startingY = 0;
    int maxY = con.ROWS - 2;

    /**
     * Creates new form GameScreen
     */
    public GameScreen() {
        initComponents();
        setFrame();
        test();
        gridLayout();

    }

    private void setFrame() {
        this.setTitle("Tetris");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(con.WIDTH, con.LENGTH);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(new java.awt.Color(0, 0, 0));
        setSize(new java.awt.Dimension(670, 800));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 486, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        keyPressed(evt);
    }//GEN-LAST:event_formKeyPressed

    /**
     * @param args the command line arguments
     */
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameScreen().setVisible(true);
            }
        });

    }

    private void gridLayout() {
        //makes an amount of labels
        int x = 0;
        int y = 1;
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel();
            labels[i].setOpaque(true);
            labels[i].setSize(con.BLOCK_SIZE, con.BLOCK_SIZE);
            labels[i].setBackground(Color.black);

            this.add(labels[i]);
            // makes the laebels fit in a grid on the frame
            if (x >= con.WIDTH) {
                x = 0;
                y += 20;
            }
            labels[i].setLocation(x, y);
            x += 20;
        }
        setBoard();

    }

    private void setBoard() {
        for (int i = 0; i < con.ROWS; i++) {
            labels[location.getLabelNum(9, i)].setBackground(Color.blue);
            labels[location.getLabelNum(9, i)].setBorder(border);
            labels[location.getLabelNum(19, i)].setBackground(Color.blue);
            labels[location.getLabelNum(19, i)].setBorder(border);
        }
        for (int i = 10; i < 19; i++) {
            labels[location.getLabelNum(i, con.ROWS - 1)].setBackground(Color.blue);
            labels[location.getLabelNum(i, con.ROWS - 1)].setBorder(border);
        }
    }

    /**
     * method to test out features
     */
    private void test() {
        System.out.println(con.ROWS);
        System.out.println(con.COLUMNS);
    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(location.getLabelNum(startingX, startingY) > location.getLabelNum(0, maxY)){
            startingY = 0;
            
            maxY--;
        }
        else if (keyCode == KeyEvent.VK_DOWN) {
            if(location.getLabelNum(startingX, startingY) < location.getLabelNum(startingX,maxY)){
            labels[mover.down(startingX,startingY)].setBackground(Color.red);
            labels[mover.down(startingX,startingY)].setBorder(border);
            labels[location.getLabelNum(startingX, startingY)].setBackground(Color.black);
            labels[location.getLabelNum(startingX, startingY)].setBorder(border2);
            startingY++;
            }
        } else if (keyCode == KeyEvent.VK_LEFT) {
            if (location.getLabelNum(startingX,startingY) > location.getLabelNum(10, startingY)) {
                labels[mover.left(startingX,startingY)].setBackground(Color.red);
                labels[mover.left(startingX,startingY)].setBorder(border);
                labels[location.getLabelNum(startingX, startingY)].setBackground(Color.black);
                labels[location.getLabelNum(startingX, startingY)].setBorder(border2);
                startingX--;
            }
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            if (location.getLabelNum(startingX, startingY) < location.getLabelNum(18, startingY)) {
                labels[mover.right(startingX,startingY)].setBackground(Color.red);
                labels[mover.right(startingX,startingY)].setBorder(border);
                labels[location.getLabelNum(startingX, startingY)].setBackground(Color.black);
                labels[location.getLabelNum(startingX, startingY)].setBorder(border2);
                startingX++;
            }
        }
    }
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

