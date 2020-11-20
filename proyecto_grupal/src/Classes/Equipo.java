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

    public String getCodigoPatrimonial() {
        return CodigoPatrimonial;
    }

    public void setCodigoPatrimonial(String CodigoPatrimonial) {
        this.CodigoPatrimonial = CodigoPatrimonial;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    private String CodigoPatrimonial;
    private String Modelo;
    private String Marca;
    private String Estado;
    public void ObtenerMovimientos(){
        
    }
    public abstract void ObtenerInformacion();
    public abstract void GuardarEquipo();
}
