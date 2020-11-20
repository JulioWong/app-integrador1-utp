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
    
    private String CodigoPatrimonial;
    private String Modelo;
    private String Marca;
    private String Estado;
    public void ObtenerMovimientos(){
        
    }
    public abstract void ObtenerInformacion();
    public abstract void GuardarEquipo();
}
