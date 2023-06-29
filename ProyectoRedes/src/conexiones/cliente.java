package conexiones;

import java.awt.event.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Adrian Quinn
 */
class InfoPacket implements Serializable {

    private String Nombre, nick, direccion, texto;
    HashMap<String, String> usuarios;
    

    public InfoPacket() {
    }

    public InfoPacket(String Nombre, String nick, String direccion, String texto) {
        this.Nombre = Nombre;
        this.nick = nick;
        this.direccion = direccion;
        this.texto = texto;
    }

    

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public HashMap<String, String> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(HashMap<String, String> usuarios) {
        this.usuarios = usuarios;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
    
}

public class cliente extends javax.swing.JFrame {

    String nombre, nick,direccion;
    Socket conversacion = null;
    ObjectOutputStream envioInformacion = null;
    Escucha hilos = null;

    public cliente() {
        initComponents();
        iconosCliente();
        datos();
        enviarConexion();
        hilos = new Escucha();
        hilos.correr();
        cerrarCliente();
    }

    public cliente(String name, String nick,String servidor) {
        this.nombre = name;
        this.nick = nick;
        this.direccion=servidor;
        initComponents();
        this.labelUsuario.setText(nick);
        iconosCliente();
        enviarConexion();
        hilos = new Escucha();
        hilos.correr();
        cerrarCliente();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        botonEnviar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        usuariosOnlineText = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        labelUsuario = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textMensajes = new javax.swing.JTextArea();
        mensajeSalida = new javax.swing.JTextField();
        botonSend = new javax.swing.JButton();
        usuario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("GARAZI CLIENT ROOM");

        botonEnviar.setBackground(new java.awt.Color(0, 0, 0));
        botonEnviar.setBorder(null);
        botonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEnviarActionPerformed(evt);
            }
        });

        usuariosOnlineText.setEditable(false);
        usuariosOnlineText.setBackground(new java.awt.Color(0, 0, 0));
        usuariosOnlineText.setColumns(20);
        usuariosOnlineText.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        usuariosOnlineText.setForeground(new java.awt.Color(255, 255, 255));
        usuariosOnlineText.setRows(5);
        usuariosOnlineText.setTabSize(5);
        usuariosOnlineText.setText("Un chat destinado al buen ambiente\ny el anonimato, buscamos gente\nque sea responsable y guste\nde conocer gente nueva.\n\nEnviar mensaje\n-Simplemente ingresa tu mensaje\nen la cajita de abajo y haz click \nen el boton con el icono de enviar\n\nSalir del chat\n-Simplemente cierra esta ventana\ny saldras del chat");
        usuariosOnlineText.setBorder(null);
        jScrollPane2.setViewportView(usuariosOnlineText);

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1093, 1093, 1093)
                        .addComponent(botonEnviar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonEnviar)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43))
        );

        jPanel2.setBackground(new java.awt.Color(84, 4, 163));

        labelUsuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        labelUsuario.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 204, 204));
        jLabel4.setText("ONLINE");

        textMensajes.setEditable(false);
        textMensajes.setBackground(new java.awt.Color(51, 51, 51));
        textMensajes.setColumns(20);
        textMensajes.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        textMensajes.setForeground(new java.awt.Color(255, 255, 255));
        textMensajes.setRows(5);
        textMensajes.setDragEnabled(true);
        jScrollPane1.setViewportView(textMensajes);

        mensajeSalida.setBackground(new java.awt.Color(51, 51, 51));
        mensajeSalida.setForeground(new java.awt.Color(255, 255, 255));
        mensajeSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mensajeSalidaActionPerformed(evt);
            }
        });

        botonSend.setBackground(new java.awt.Color(84, 4, 163));
        botonSend.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        botonSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(mensajeSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonSend, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel2)
                                .addGap(179, 179, 179)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(labelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mensajeSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonSend, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mensajeSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mensajeSalidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mensajeSalidaActionPerformed

    private void botonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEnviarActionPerformed
        try {
            //Servidor 192.168.0.10
            //El destino es el chat grupal
            //Generar este conexion entre cliente y servidor
            conversacion = new Socket(this.direccion, 898);//Se inclue la ip local y ademas un puerto que este disponible
            InfoPacket info = new InfoPacket(this.nombre,this.nick,this.direccion, mensajeSalida.getText()); //Se construye el paquet con la informacion necesaria
            ObjectOutputStream envioInformacion = new ObjectOutputStream(conversacion.getOutputStream());
            envioInformacion.writeObject(info);
            conversacion.close(); //Es importante siempre cerrar el socket
            this.mensajeSalida.setText("");
            this.mensajeSalida.requestFocus();
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_botonEnviarActionPerformed

    private void botonSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSendActionPerformed
        try {
            //Servidor 192.168.0.10
            //El destino es el chat grupal
            //Generar este conexion entre cliente y servidor
            conversacion = new Socket(this.direccion, 898);//Se inclue la ip local y ademas un puerto que este disponible
            InfoPacket info = new InfoPacket(this.nombre,this.nick,this.direccion, mensajeSalida.getText()); //Se construye el paquet con la informacion necesaria
            ObjectOutputStream envioInformacion = new ObjectOutputStream(conversacion.getOutputStream());
            envioInformacion.writeObject(info);
            conversacion.close(); //Es importante siempre cerrar el socket
            this.mensajeSalida.setText("");
            this.mensajeSalida.requestFocus();
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_botonSendActionPerformed
    public void cerrarCliente() {
        try {
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    cerrarConexiones();
                }
            });
        } catch (Exception ex) {

        }
    }

    public void cerrarConexiones() {
        hilos.cerrarTodo();
        try {
            Socket cerrarUsuario = new Socket(this.direccion, 898);
            InfoPacket conPack = new InfoPacket();
            conPack.setTexto("Leave");
            conPack.setNombre(this.nombre);
            conPack.setNick(this.nick);
            ObjectOutputStream packDatos = new ObjectOutputStream(cerrarUsuario.getOutputStream());
            packDatos.writeObject(conPack);
            cerrarUsuario.close(); //Es importante siempre cerrar el socket
            System.exit(0);
        } catch (IOException ex) {
            System.out.println("Error close: " + ex.getMessage());
        }
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cliente().setVisible(true);
            }
        });
    }

    public void datos() {
        this.nombre = JOptionPane.showInputDialog("Cual es tu nombre: ");
        labelUsuario.setText(this.nombre);
    }

    public void enviarConexion() {
        try {
            Socket conUsuario = new Socket(this.direccion, 898);
            InfoPacket conPack = new InfoPacket();
            conPack.setTexto("Join");
            conPack.setNombre(this.nombre);
            conPack.setNick(this.nick);
            ObjectOutputStream packDatos = new ObjectOutputStream(conUsuario.getOutputStream());
            packDatos.writeObject(conPack);
            conUsuario.close();
            packDatos.close();
        } catch (IOException ex) {
            System.out.println("Error Conexion: " + ex.getMessage());
        }
    }

    public class Escucha implements Runnable {
        ArrayList<String> usuariosOnline=new ArrayList<>();
        ObjectInputStream recepcionDatos = null;
        ServerSocket clienteServidor = null;
        Thread escucha = null;
        boolean infinito = true;

        public void setInfinito(boolean infinito) {
            this.infinito = infinito;
        }

        public void correr() {
            escucha = new Thread(this);
            escucha.start();
        }

        @Override
        public void run() {
            String auxiliar;
            //INCLUIR UN HASH MAP QUE SE ACTUALIZA CON LAS CONEXIONES Y DESCO
            try {
                clienteServidor = new ServerSocket(2123);
                Socket usuario;
                InfoPacket packRecep;
                do {
                    usuario = clienteServidor.accept();
                    recepcionDatos = new ObjectInputStream(usuario.getInputStream());
                    packRecep = (InfoPacket) recepcionDatos.readObject();
                    if (packRecep.getTexto().equals("Leave")) {
                        textMensajes.append("Se ha desconectado: " + packRecep.getNick()+ "\n");
                    } else if (!packRecep.getTexto().equals("Join")) {
                        textMensajes.append(packRecep.getNick()+ ": " + packRecep.getTexto() + "\n\n");
                    } else {
                        auxiliar = packRecep.getNick();
                        if (auxiliar != null) {
                            textMensajes.append("\nSe ha conectado: " + auxiliar + "\n\n");
                        }
                    }
                } while (infinito != false);
            } catch (IOException ex) {
                System.out.println("Error: " + ex.getMessage());
            } catch (ClassNotFoundException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }

        public void cerrarTodo() {
            try {//TELA DE DUDA
                infinito = false;
                recepcionDatos.close();
                clienteServidor.close();
            } catch (IOException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }

    }
    //conversacion.close(); //Es importante siempre cerrar el socket 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonEnviar;
    private javax.swing.JButton botonSend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JTextField mensajeSalida;
    private javax.swing.JTextArea textMensajes;
    private javax.swing.JLabel usuario;
    private javax.swing.JTextArea usuariosOnlineText;
    // End of variables declaration//GEN-END:variables
    public void iconosCliente() {
        ImageIcon iconoSend;
        ImageIcon usuario;
        iconoSend = new ImageIcon(getClass().getClassLoader().getResource("imagenes/send.png"));
        usuario=new ImageIcon(getClass().getClassLoader().getResource("imagenes/usuario.png"));
        this.botonSend.setIcon(iconoSend);
        this.usuario.setIcon(usuario);
    }

}
