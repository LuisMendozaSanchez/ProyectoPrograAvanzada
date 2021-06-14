/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import config.Login;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Menu extends JFrame implements ActionListener{

	private Juego jue;
        
  private Login ve;
  private JTextField textfield1;
  private JLabel label1, label2, label3, label4;
  private JButton boton1, boton2;
  public static String texto = "";

  public Menu(){
    setLayout(null);
    setTitle("Bienvenido");
    getContentPane().setBackground(new Color(255,200,0));
         setBounds(0,0,350,450);
     setVisible(true);
     setResizable(false);
     setLocationRelativeTo(null);
     setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    //setIconImage(new ImageIcon(getClass().getResource("multimedia/1.png")).getImage());
    

    label2 = new JLabel("Bienvenido a nuestro videojuego");
    label2.setBounds(35,135,300,30);
    label2.setFont(new Font("Andale Mono", 3, 18));
    label2.setForeground(new Color(255,255,255));
    add(label2);

    label3 = new JLabel("Ingrese su nombre");
    label3.setBounds(45,212,200,30);
    label3.setFont(new Font("Andale Mono", 1, 12));
    label3.setForeground(new Color(255,255,255));
    add(label3);

    label4 = new JLabel("2021 Programacion avanzada");
    label4.setBounds(85,375,300,30);
    label4.setFont(new Font("Andale Mono", 1, 12));
    label4.setForeground(new Color(255,255,255));
    add(label4);

    textfield1 = new JTextField ();
    textfield1.setBounds(40,240,255,25);
    textfield1.setBackground(new Color(224,224,224));
    textfield1.setFont(new Font("Andale Mono", 1, 14));
    textfield1.setForeground(new Color(255,0,0));
    add(textfield1);

    boton1 = new JButton("Inicio");
    boton1.setBounds(35,280,120,30);
    boton1.setBackground(new Color(255,255,255));
    boton1.setFont(new Font("Andale Mono", 1, 14));
    boton1.setForeground(new Color(0,0,0));
    boton1.addActionListener(this);
    add(boton1);

    boton2 = new JButton("Administrador");
    boton2.setBounds(180,280,120,30);
    boton2.setBackground(new Color(255,255,255));
    boton2.setFont(new Font("Andale Mono", 1, 14));
    boton2.setForeground(new Color(0,0,0));
    boton2.addActionListener(this);
    add(boton2);
  };

   public void actionPerformed(ActionEvent e){
     if(e.getSource() == boton1){
       texto = textfield1.getText().trim();
       if(texto.equals("")){
         JOptionPane.showMessageDialog(null, "Debes ingresar tu nombre.");
       } else {
         Juego Jue = new Juego();
         this.dispose();
       }
     }else{
        Login ve = new Login();
        this.dispose();
     }
   }
   
   public static void main(String args[]){
     Menu ventanabienvenida = new Menu();

   }
}