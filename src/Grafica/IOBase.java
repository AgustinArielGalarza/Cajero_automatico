package Grafica;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import Grafica.Botones;
import cajeroautomatico2.Cuenta;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;

public class IOBase extends JFrame {
    
    public IOBase (){
            setTitle("Proyecto precentacion: Cajero automatico. Por Agustin Galarza");
            setBounds(500, 200, 500, 400);
            getContentPane().setBackground(Color.GRAY);
            Lamina milam = new Lamina();
            add(milam);
            pack();
        }
    }


    class Lamina extends JPanel{
        
    private JLabel titulo;
    private Cuenta cuenta;
    private JTextArea area;
    private JButton botonDamesaldo,botonDepositar,botonExtraer,exit;
    
        public Lamina(){
            
            setLayout(new BorderLayout(50,90));
            setBackground(Color.GRAY);
            
            //creo titulo principal
            titulo = new JLabel("         Cajero automático");
            Font mifuente = new Font("Arial", Font.BOLD, 24);
            titulo.setFont(mifuente);
            titulo.setForeground(Color.ORANGE);
            add(titulo,BorderLayout.NORTH);
            //area de texto
            area = new JTextArea();
            area.setBackground(Color.GRAY.brighter());
            area.setBorder(BorderFactory.createBevelBorder(20));
            
            add(area);
            
            cuenta = new Cuenta(0);
            
            //segundo panel
            JPanel lamina2 = new JPanel(new GridLayout(2, 4));
            lamina2.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
            lamina2.setBackground(Color.GRAY);
            add(lamina2,BorderLayout.SOUTH);
            
            botonDamesaldo = new JButton("Consultar Saldo");
            botonDepositar= new JButton("Depositar");
            botonExtraer= new JButton("Extraer");
            
            exit= new JButton("Salir");
            exit.setBackground(Color.red.darker());
            exit.setForeground(Color.white);
            
            lamina2.add(botonDamesaldo);
            lamina2.add(botonDepositar);
            lamina2.add(botonExtraer);
            lamina2.add(exit);
            
            EventosBoton();
        }
        
        private EventoDeRaton click;
        
        
        private void EventosBoton () {
            
             botonDamesaldo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Object BotonPulsado = e.getSource();
       
                if (BotonPulsado == botonDamesaldo){
                     area.setText("Su saldo es de: "+cuenta.preguntarSaldo());
                     EventosBoton();
           
       }
           }
       });
             botonDepositar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Object BotonPulsado = e.getSource();
           
                if (BotonPulsado == botonDepositar){
                    area.setText("ingrese la cantidad de dinero que deseas Depositar");
                    click = new EventoDeRaton();
                    area.addMouseListener(click);    
                    area.addKeyListener(new KeyListener() {
               @Override
               public void keyTyped(KeyEvent e) {}
               @Override
               public void keyPressed(KeyEvent e) {
                try {
                  if (e.getKeyCode() == 10){
                    String g = area.getText();
                    int i = Integer.parseInt(g);
                    cuenta.depositar(i);
                    area.setText("Se ha depositado con exito");
                    EventosBoton();
                     }
                }catch (NumberFormatException er) {
                 area.setText("se ha depositado con exito");
               }
               }
               @Override
               public void keyReleased(KeyEvent e) {
               }
       });
                }
                }
             });
            botonExtraer.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   Object BotonPulsado = e.getSource();
                   if (BotonPulsado == botonExtraer){
                    area.setText("ingrese la cantidad de dinero que desea Extraer");
                    click = new EventoDeRaton();
                    area.addMouseListener(click);    
                    area.addKeyListener(new KeyListener() {
               @Override
               public void keyTyped(KeyEvent e) {}
               @Override
               public void keyPressed(KeyEvent e) {
                 try {
                 if (e.getKeyCode() == 10){
                    String g = area.getText();
                    int i = Integer.parseInt(g);
                    cuenta.extraer( i,area);
                    EventosBoton();
            }
             } catch (NumberFormatException er) {
                 area.setText("Se ha Extraido con exito \n\n");
            }
               }
               @Override
               public void keyReleased(KeyEvent e) {}
           });
       }
       
       
           
       }
    });
    }
    
    private class EventoDeRaton extends MouseAdapter{

        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {
            area.setText("");
        }
       
    }
       }


    
    


    


