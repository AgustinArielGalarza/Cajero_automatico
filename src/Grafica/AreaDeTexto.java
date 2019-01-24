package Grafica;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;

     public class AreaDeTexto extends JTextArea{
        
       private JScrollBar barra;
       
    public AreaDeTexto(){
           
       setLineWrap(true);
       barra = new JScrollBar();
       add(barra);
       setBounds(40, 120, 400, 150);
       setBackground(Color.gray.darker());
       setBorder(BorderFactory.createBevelBorder(0));
       setForeground(Color.white);
       
        }
    }
      
