package conexiones;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adrian Quinn
 */
public class servidor extends javax.swing.JFrame {
    
    public servidor() {
        initComponents();
        Proceso hilos = new Proceso();
        hilos.correr();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoMensajes = new javax.swing.JTextArea();
        labelNombreServer = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        labelHistorial = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        infoUsuarios = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        textoMensajes.setEditable(false);
        textoMensajes.setBackground(new java.awt.Color(0, 0, 0));
        textoMensajes.setColumns(20);
        textoMensajes.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        textoMensajes.setForeground(new java.awt.Color(255, 255, 255));
        textoMensajes.setRows(5);
        textoMensajes.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane1.setViewportView(textoMensajes);

        labelNombreServer.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 24)); // NOI18N
        labelNombreServer.setForeground(new java.awt.Color(255, 255, 255));
        labelNombreServer.setText("GARZI SERVER");

        jPanel2.setBackground(new java.awt.Color(102, 0, 153));

        labelHistorial.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        labelHistorial.setForeground(new java.awt.Color(255, 255, 255));
        labelHistorial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelHistorial.setText("Historial de mensajes");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(labelHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelHistorial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        infoUsuarios.setEditable(false);
        infoUsuarios.setBackground(new java.awt.Color(51, 51, 51));
        infoUsuarios.setColumns(20);
        infoUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        infoUsuarios.setRows(5);
        jScrollPane2.setViewportView(infoUsuarios);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuarios en el chat");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(labelNombreServer))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jLabel1)))
                .addContainerGap(31, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelNombreServer)
                .addGap(1, 1, 1)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new servidor().setVisible(true);
            }
        });
        
    }
    
    public class Proceso implements Runnable {
        
        public void correr() {
            Thread informacion = new Thread(this);
            informacion.start();
        }
        
        @Override
        public void run() {
            HashMap<String, String> usuariosConectados=new HashMap<>();
            try {
                //Estamos a la espera de abrir el puerto y tener todo lo que venga
                ServerSocket server = new ServerSocket(898);
                String nombre, direccion, texto, apodo;
                InfoPacket paqueteObtenido;
                do {
                    Socket recepcionSocket = server.accept();
                    
                    ObjectInputStream obtencionDatos = new ObjectInputStream(recepcionSocket.getInputStream());
                    paqueteObtenido = (InfoPacket) obtencionDatos.readObject();
                    
                    nombre = paqueteObtenido.getNombre();
                    direccion = paqueteObtenido.getDireccion();
                    texto = paqueteObtenido.getTexto();
                    apodo = paqueteObtenido.getNick();
                    
                    if (!texto.equals("Join") && !texto.equals("Leave")) {
                        textoMensajes.append("De: " + nombre + "\nMensaje: " + texto + "\n\n");
                        for (String i : usuariosConectados.keySet()) {
                            String auxDir=usuariosConectados.get(i);
                            Socket reenviarDestino = new Socket(auxDir, 2123);
                            ObjectOutputStream PacDestino = new ObjectOutputStream(reenviarDestino.getOutputStream());
                            PacDestino.writeObject(paqueteObtenido);
                            PacDestino.close();
                            reenviarDestino.close();
                            recepcionSocket.close();
                        }
                    } else if(!texto.equals("Leave")){ //Se obtiene la informacion del nuevo usuario conectado
                        //Obtencion de las direccion de los clientes conectados a nuestro srvidor
                        infoUsuarios.setText("");
                        InetAddress usuarioDir = recepcionSocket.getInetAddress();//Obtenemos la direccio
                        String ipObtenida=usuarioDir.getHostAddress();
                        usuariosConectados.put(nombre,ipObtenida);
                        textoMensajes.append("Conectado\nNombre: " + nombre + " Usando Nick: "+apodo+"\nDireccion: " + ipObtenida+"\n");
                        paqueteObtenido.setUsuarios(usuariosConectados);
                        for (String i : usuariosConectados.keySet()) {
                            String auxDir=usuariosConectados.get(i);
                            infoUsuarios.append("Nombre: " + i + " Direccion: " + auxDir+"\n");
                            Socket reenviarDestino = new Socket(auxDir, 2123);
                            ObjectOutputStream PacDestino = new ObjectOutputStream(reenviarDestino.getOutputStream());
                            PacDestino.writeObject(paqueteObtenido);
                            PacDestino.close();
                            reenviarDestino.close();
                            recepcionSocket.close();
                         }
                        
                        //Guardando la informacion de las diversas personas que se estan conectando al servidor
                    }else{
                        usuariosConectados.remove(nombre);
                        infoUsuarios.setText("");
                        textoMensajes.append("Se ha desconectado: " + apodo+"\n");
                        for (String i : usuariosConectados.keySet()) {
                            String auxDir=usuariosConectados.get(i);
                            infoUsuarios.append("Nombre: " + i + " Direccion: " + auxDir+"\n");
                        }
                        
                        for (String i : usuariosConectados.keySet()) {
                            String auxDir=usuariosConectados.get(i);
                            Socket reenviarDestino = new Socket(auxDir, 2123);
                            ObjectOutputStream PacDestino = new ObjectOutputStream(reenviarDestino.getOutputStream());
                            PacDestino.writeObject(paqueteObtenido);
                            PacDestino.close();
                            reenviarDestino.close();
                            recepcionSocket.close();
                        }
                    }
                } while (true!=false);
            } catch (IOException ex) {
                System.out.println("Error: " + ex.getMessage());
            } catch (ClassNotFoundException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea infoUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelHistorial;
    private javax.swing.JLabel labelNombreServer;
    private javax.swing.JTextArea textoMensajes;
    // End of variables declaration//GEN-END:variables
}
