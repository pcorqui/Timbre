
package reloj;
import java.util.*;

public class Reloj extends javax.swing.JFrame implements Runnable{
    String hora, minutos, segundos, ampm;
    Calendar calendario;
    Thread h1;
    
    public Reloj() {
        initComponents();
        h1 = new Thread(this);
        h1.start();
        
        setLocationRelativeTo(null);
        setTitle("Reloj");
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblReloj = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblReloj.setFont(new java.awt.Font("Trebuchet MS", 1, 48)); // NOI18N
        lblReloj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReloj.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblReloj, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblReloj, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblReloj;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        Thread ct= Thread.currentThread();
        
        while(ct==h1){
            calcula();
            lblReloj.setText(hora+":"+minutos+":"+segundos+" "+ampm);
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){}
        }
    }

    private void calcula() {
        Calendar calendario = new GregorianCalendar();
        Date fechaHoraActual = new Date();
        
        calendario.setTime(fechaHoraActual);
        ampm= calendario.get(Calendar.AM_PM)==Calendar.AM?"AM":"PM";
        
        if(ampm.equals("PM")){
            int h=calendario.get(Calendar.HOUR_OF_DAY)-12;
            hora = h>9?""+h:"0"+h;
        }else{
            hora= calendario.get(Calendar.HOUR_OF_DAY)>9?""+calendario.get(Calendar.HOUR_OF_DAY):"0"+calendario.get(Calendar.HOUR_OF_DAY); 
        }
        minutos = calendario.get(Calendar.MINUTE)>9?""+calendario.get(Calendar.MINUTE):"0"+calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND)>9?""+calendario.get(Calendar.SECOND):"0"+calendario.get(Calendar.SECOND);
    }
}