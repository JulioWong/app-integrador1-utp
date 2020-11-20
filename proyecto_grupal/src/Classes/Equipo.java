/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author GUSTAVO
 */
public abstract class Equipo {

    private String codigoPatrimonial;
    private String modelo;
    private String marca;
    private Boolean estado;
    
    
   
    public void obtenerMovimientos(){
        
    }
    public abstract void obtenerInformacion();
    public abstract void guardarEquipo();
}
