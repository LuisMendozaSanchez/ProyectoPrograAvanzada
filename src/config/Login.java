/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import form.Juego;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import config.Conexion;
import form.Principal;
import java.sql.PreparedStatement;

public class Login extends JFrame implements ActionListener{
       
        Conexion cc = new Conexion();
        Connection con =cc.getConnection();
        
        private Menu me;
	private JTextField txtf, txtf1;
	private JLabel label1,label2, label3;
	private JButton boton1, boton2;

	public Login(){
		setLayout(null);
		setTitle("Ingreso al sistema");
		getContentPane().setBackground(new Color(255,200,0));

		label1 = new JLabel("Ingresa tus datos para acceder");
	    label1.setBounds(40,135,200,30);
	    label1.setFont(new Font("Andale Mono", 3, 18));
	    label1.setForeground(new Color(255,255,255));
	    add(label1);

	    label2 = new JLabel("Ingresar correo: ");
    	label2.setBounds(40,150,200,30);
    	label2.setFont(new Font("Andale Mono", 1, 12));
    	label2.setForeground(new Color(255,255,255));
    	add(label2);

    	txtf = new JTextField ();
   		txtf.setBounds(40,180,255,30);
    	txtf.setBackground(new Color(224,224,224));
    	txtf.setFont(new Font("Andale Mono", 1, 14));
    	txtf.setForeground(new Color(255,0,0));
    	add(txtf);

    	label3 = new JLabel("Ingresar contrasena: ");
    	label3.setBounds(40,210,200,30);
    	label3.setFont(new Font("Andale Mono", 1, 12));
    	label3.setForeground(new Color(255,255,255));
    	add(label3);

    	txtf1 = new JTextField ();
   		txtf1.setBounds(40,240,255,30);
    	txtf1.setBackground(new Color(224,224,224));
    	txtf1.setFont(new Font("Andale Mono", 1, 14));
    	txtf1.setForeground(new Color(255,0,0));
    	add(txtf1);

    /*	boton1 = new JButton("Regresar");
	    boton1.setBounds(40,280,250,30);
	    boton1.setBackground(new Color(255,255,255));
	    boton1.setFont(new Font("Andale Mono", 1, 14));
	    boton1.setForeground(new Color(0,0,0));
	    boton1.addActionListener(this);
	    add(boton1);*/

    	boton2 = new JButton("Aceptar");
	    boton2.setBounds(100,280,250,30);
	    boton2.setBackground(new Color(255,255,255));
	    boton2.setFont(new Font("Andale Mono", 1, 14));
	    boton2.setForeground(new Color(0,0,0));
	    boton2.addActionListener(this);
	    add(boton2);

	    setVisible(true);
	    setBounds(0,0,350,450);
    //vetana.setVisible(true);
     setResizable(false);
     setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
        
     public void actionPerformed(ActionEvent e){
     if(e.getSource() == boton2){

         validarLogin();
        }
   }
        
   
   public void validarLogin(){
        int resultado=0;
        
        
        try{
            String correo = txtf.getText();
        String pass = txtf1.getText();
        String SQL="select * from admins where correo= '"+correo+"' and password = '"+pass+"'";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(SQL);
        if(rs.next()){
            resultado=1;
            if(resultado==1){
                System.out.println("Correcto");
                Principal pr = new Principal();
                pr.setVisible(true);
                this.dispose();
            }
        }else{
            System.out.println("Usuario incorrecto");
        }
        }catch(Exception e){
            System.out.println("Error"+e);
        }
   
   }


	public static void main(String[] args) {
        Login vetana = new Login();

   }

}