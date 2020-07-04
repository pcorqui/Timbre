package aplicacion;

import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
import java.util.*;

public class principal extends javax.swing.JFrame implements Runnable{
    
    PanamaHitek_Arduino ino = new PanamaHitek_Arduino();
    String hora, minutos, segundos, ampm;
    Calendar calendario;
    Thread h1;
    boolean encendido = false;
    List<String> puerto = new ArrayList<String>();

    public principal() {
        initComponents();
        h1 = new Thread(this);
        h1.start();
        setTitle("PAGINA PRINCIPAL");
         this.setLocationRelativeTo(null);
        try{
            //inicia la comunicacion en serie
            ino.arduinoTX("COM3",9600);
            puerto = ino.getSerialPorts();
            
        }catch(ArduinoException ex){
            
        }
        mostrardatos("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblhora = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbleditar = new javax.swing.JTable();
        btnencender = new javax.swing.JButton();
        btnagregar = new javax.swing.JButton();
        btnapagar = new javax.swing.JButton();
        btnatras = new javax.swing.JButton();
        sphora = new javax.swing.JSpinner();
        spmin = new javax.swing.JSpinner();
        spseg = new javax.swing.JSpinner();
        txtmin = new javax.swing.JTextField();
        txtseg = new javax.swing.JTextField();
        txthora = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(805, 620));
        setPreferredSize(new java.awt.Dimension(805, 620));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Hora actual:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(225, 90, 140, 22);

        lblhora.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        lblhora.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lblhora);
        lblhora.setBounds(380, 80, 230, 40);

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Horas:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(140, 150, 67, 22);

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Minutos:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(362, 150, 100, 22);

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Segundos:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(560, 150, 107, 22);

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Puerto:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(130, 260, 75, 22);

        jComboBox1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(220, 260, 100, 40);

        tbleditar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "null"
            }
        ));
        jScrollPane2.setViewportView(tbleditar);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(130, 330, 540, 140);

        btnencender.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        btnencender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnencender.png"))); // NOI18N
        btnencender.setContentAreaFilled(false);
        btnencender.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnencender.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnencender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnencenderActionPerformed(evt);
            }
        });
        getContentPane().add(btnencender);
        btnencender.setBounds(430, 520, 150, 50);

        btnagregar.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        btnagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnagregar.png"))); // NOI18N
        btnagregar.setContentAreaFilled(false);
        btnagregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnagregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnagregar);
        btnagregar.setBounds(540, 250, 150, 50);

        btnapagar.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        btnapagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnapagar.png"))); // NOI18N
        btnapagar.setContentAreaFilled(false);
        btnapagar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnapagar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnapagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnapagarActionPerformed(evt);
            }
        });
        getContentPane().add(btnapagar);
        btnapagar.setBounds(610, 520, 150, 50);

        btnatras.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        btnatras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnatras.png"))); // NOI18N
        btnatras.setContentAreaFilled(false);
        btnatras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnatras.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnatras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnatrasActionPerformed(evt);
            }
        });
        getContentPane().add(btnatras);
        btnatras.setBounds(40, 520, 150, 50);

        sphora.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        sphora.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));
        sphora.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sphoraStateChanged(evt);
            }
        });
        getContentPane().add(sphora);
        sphora.setBounds(560, 180, 100, 30);

        spmin.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        spmin.setModel(new javax.swing.SpinnerNumberModel(0, 0, 23, 1));
        spmin.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spminStateChanged(evt);
            }
        });
        getContentPane().add(spmin);
        spmin.setBounds(140, 180, 100, 30);

        spseg.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        spseg.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));
        spseg.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spsegStateChanged(evt);
            }
        });
        getContentPane().add(spseg);
        spseg.setBounds(360, 180, 100, 30);

        txtmin.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        txtmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtminActionPerformed(evt);
            }
        });
        getContentPane().add(txtmin);
        txtmin.setBounds(360, 180, 100, 30);

        txtseg.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        getContentPane().add(txtseg);
        txtseg.setBounds(560, 180, 100, 30);

        txthora.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        txthora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthoraActionPerformed(evt);
            }
        });
        getContentPane().add(txthora);
        txthora.setBounds(140, 180, 100, 30);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/principal.jpg"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, 0, 810, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void txthoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthoraActionPerformed

    private void txtminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtminActionPerformed

    private void btnencenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnencenderActionPerformed
encontrarPuertos();
       // ModificarHora();
    }//GEN-LAST:event_btnencenderActionPerformed

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        ArchivoTimbre at = new ArchivoTimbre();
        String horaAgregada = spmin.getValue()+":"+spseg.getValue()+":"+sphora.getValue();//debemos agregarle el amPM
        at.abrirArchivo();
        at.agregarHorarios(horaAgregada);
        at.cerrarArchivo();
    }//GEN-LAST:event_btnagregarActionPerformed

    private void btnapagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnapagarActionPerformed
        // TODO add your handling code here:
       try{
       ino.sendData("0");
       }catch(ArduinoException | SerialPortException ex){
       
   }
    }//GEN-LAST:event_btnapagarActionPerformed

    private void btnatrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnatrasActionPerformed
        // TODO add your handling code here:
        inicio obj = new inicio();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnatrasActionPerformed

    private void sphoraStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sphoraStateChanged
        // TODO add your handling code here:
        txthora.setText(""+sphora.getValue().toString());
    }//GEN-LAST:event_sphoraStateChanged

    private void spminStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spminStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_spminStateChanged

    private void spsegStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spsegStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_spsegStateChanged

    
        
    /**************************************************************************************
     * imprime el hilo actual
     */
    
    public void run(){
            Thread ct= Thread.currentThread();
        
        while(ct==h1){
           calcula();
            lblhora.setText(hora+":"+minutos+":"+segundos);
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){}
        }
    }

    /*************************************************************************************
     * calcula la hora actual
     */
   private void calcula() {
        Calendar calendario = new GregorianCalendar();
        Date fechaHoraActual = new Date();
        
       calendario.setTime(fechaHoraActual);
        hora= calendario.get(Calendar.HOUR_OF_DAY)>9?""+calendario.get(Calendar.HOUR_OF_DAY):"0"+calendario.get(Calendar.HOUR_OF_DAY); 
        
        minutos = calendario.get(Calendar.MINUTE)>9?""+calendario.get(Calendar.MINUTE):"0"+calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND)>9?""+calendario.get(Calendar.SECOND):"0"+calendario.get(Calendar.SECOND);
    }
    
   
    //extraer los puertos disponibles y enviarlos a un selector.***************************puertos
    public void encontrarPuertos(){ 
        String p;
        String []puertosDisponibles = new String[puerto.size()]; 
        for(int i = 0;i<puerto.size();i++){
            p = puerto.get(i);
            System.out.println(p);
            puertosDisponibles[i] = puerto.get(i);
            jComboBox1.addItem(p);
        }
        
    }
    //*****************************************************************************************
    
    /**************************************************************************************Tabla*/
    void mostrardatos(String valor){
       DefaultTableModel modelo= new DefaultTableModel();
       modelo.addColumn("Horario");
       modelo.addColumn("Estado");
       //modelo.addColumn("la otra");
       tbleditar.setModel(modelo);
       //tbleliminar.setModel(modelo);
       String sql="";
    if(valor.equals(""))
    {
        sql="SELECT * FROM Horario";
    }
    else{
        sql="SELECT * FROM medico WHERE codigo='"+valor+"'";
    }
       String []datos = new String[3];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                //datos[2]=rs.getString(3);
                modelo.addRow(datos);
            }
            tbleditar.setModel(modelo);
            //tbleliminar.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        /************************************************************************************** Tabla*/
        
}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        //Hora del dia
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
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principal().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btnapagar;
    private javax.swing.JButton btnatras;
    private javax.swing.JButton btnencender;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblhora;
    private javax.swing.JSpinner sphora;
    private javax.swing.JSpinner spmin;
    private javax.swing.JSpinner spseg;
    private javax.swing.JTable tbleditar;
    private javax.swing.JTextField txthora;
    private javax.swing.JTextField txtmin;
    private javax.swing.JTextField txtseg;
    // End of variables declaration//GEN-END:variables
    conectar cc= new conectar();
    Connection cn= cc.conexion();

   
}
