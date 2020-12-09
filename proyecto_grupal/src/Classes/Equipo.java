package Classes;

import Interfaces.MantenimientoObtener;
import Interfaces.MantenimientoGuardar;
import java.util.List;
public abstract class Equipo implements MantenimientoGuardar,MantenimientoObtener{

    private int equipoId;
    private String claseEquipo;
    private String codigoPatrimonial;
    private String modelo;
    private String marca;
    private String fechaRegistro;
    private String observaciones;
    private String ubicacionActual;
    private Boolean estado;
    private List<DocumentoTransferencia> transferencias;

    public Equipo() {
    }

    public String getUbicacionActual() {
        return ubicacionActual;
    }

    public String getClaseEquipo() {
        return claseEquipo;
    }

    public void setClaseEquipo(String claseEquipo) {
        this.claseEquipo = claseEquipo;
    }
    
    public int getEquipoId() {
        return equipoId;
    }

    public String getCodigoPatrimonial() {
        return codigoPatrimonial;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public Boolean getEstado() {
        return estado;
    }

    public List<DocumentoTransferencia> getTransferencias() {
        return transferencias;
    }

    public void setCodigoPatrimonial(String codigoPatrimonial) {
        this.codigoPatrimonial = codigoPatrimonial;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setUbicacionActual(String ubicacionActual) {
        this.ubicacionActual = ubicacionActual;
    }
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    public String validar(){
        if(this.codigoPatrimonial.isEmpty()){
            return "Ingrese codigo patrimonial";
        }
        if(this.marca.isEmpty()){
            return "Ingrese Marca";
        }
        if(this.modelo.isEmpty()){
            return "Ingrese Modelo";
        }
        if(this.ubicacionActual.isEmpty()){
            return "Seleccione ubicación actual.";
        }
        return null;
    }
    
}
