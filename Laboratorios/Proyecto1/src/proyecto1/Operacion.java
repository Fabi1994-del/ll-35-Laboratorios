/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

/**
 *
 * @author LENOVO
 */
public class Operacion {

    private int valor;
    private TipoOperacion tipo;

    public Operacion(int valor, TipoOperacion tipo) {
        this.valor = valor;
        this.tipo = tipo;
    }

    public int getValor() {
        return valor;
    }

    public TipoOperacion getTipo() {
        return tipo;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setTipo(TipoOperacion tipo) {
        this.tipo = tipo;
    }

    public Operacion inversa() {
        TipoOperacion invertido = (tipo == TipoOperacion.SUMA) ? TipoOperacion.RESTA : TipoOperacion.SUMA;
        return new Operacion(valor, invertido);
    }
    
    

}
