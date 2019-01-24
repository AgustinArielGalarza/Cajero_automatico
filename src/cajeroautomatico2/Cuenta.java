package cajeroautomatico2;

import javax.swing.JTextArea;

public class Cuenta {
    private int saldo = 0;

    public Cuenta(int s) {
        this.saldo =s;
    }

    public int preguntarSaldo() {
        return saldo;
    }

    public void depositar(int s) {
        saldo = saldo + s;
    }
    public void extraer (int s, JTextArea area){
        if(saldo > 0 && s <= saldo){
        saldo = saldo - s;
        area.setText("Se ha extraído con Éxito "+s);
        }else{
            area.setText("la operacion no puede relizarse, porfavor intente de nuevo.");
        }
    }

    public void extraer(int i) {
    }
}
