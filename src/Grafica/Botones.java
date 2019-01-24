package Grafica;

import cajeroautomatico2.Cuenta;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Botones extends JButton {
        
         private AreaDeTexto area;
         private JButton botonDamesaldo;
         private JButton botonDepositar;
         private JButton botonExtraer;
         private JButton exit;
         private Cuenta cuenta;
         
         
    public Botones (){
        
       cuenta = new Cuenta(0);     
       Oyentes oyenteBoton = new Oyentes(area);
       setLayout(null);
        
       botonDamesaldo = new JButton("Consultar Saldo");
       botonDamesaldo.setBounds(34, 58,150, 30);
       botonDamesaldo.addActionListener(oyenteBoton);
       
       botonDepositar= new JButton("Depositar");
       botonDepositar.setBounds(200, 58, 120, 30);
       botonDepositar.addActionListener(oyenteBoton);
       
       botonExtraer= new JButton("Extraer");
       botonExtraer.setBounds(330, 58, 120, 30);
       botonExtraer.addActionListener(oyenteBoton);
       
       exit= new JButton("Salir");
       exit.setBounds(370, 320, 80, 30);
       exit.setBackground(Color.red.darker());
       exit.setForeground(Color.white);
       exit.addActionListener(oyenteBoton);
       
       
       }
       
        
    class Oyentes implements ActionListener{
        
        private JTextArea areax;
        private EventoDeRaton click;
        
        public Oyentes(JTextArea a){
            areax = a;
        }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        
       Object BotonPulsado = e.getSource();
       
       if (BotonPulsado == botonDamesaldo){
           areax.setText("Su saldo es de: "+cuenta.preguntarSaldo());
           
       }
       
       
       else if (BotonPulsado == botonDepositar){
           areax.setText("ingrese la cantidad de dinero que deseas Depositar");
           click = new EventoDeRaton();
           areax.addMouseListener(click);    
           areax.addKeyListener(new KeyListener() {
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
                     }
             }  catch (NumberFormatException er) {
                 area.setText("huvo un error");
               }
               }
               @Override
               public void keyReleased(KeyEvent e) {}
           });
           
       }
       
       
       else if (BotonPulsado == botonExtraer){
           areax.setText("ingrese la cantidad de dinero que desea Extraer");
           click = new EventoDeRaton();
           areax.addMouseListener(click);    
           areax.addKeyListener(new KeyListener() {
               @Override
               public void keyTyped(KeyEvent e) {}
               @Override
               public void keyPressed(KeyEvent e) {
                try {
                if (e.getKeyCode() == 10){
                String g = area.getText();
                int i = Integer.parseInt(g);
                cuenta.extraer(i);
                area.setText("Se ha Extraido con exito\n\n");
                area.setText("Tu saldo actual es de: "+cuenta.preguntarSaldo());
            }
             } catch (NumberFormatException er) {
                 area.setText("huvo un error");
            }
               }
               @Override
               public void keyReleased(KeyEvent e) {}
           });
       }
       
       else{
           areax.setText("Has terminado");
           
           
       }
    }
    }
    
    public class EventoDeRaton extends MouseAdapter{

        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {
            area.setText("");
        }
       
    }
       }

