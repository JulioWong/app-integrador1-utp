package Classes;

import Interfaces.MantenimientoObtener;
import Interfaces.MantenimientoGuardar;
import java.util.List;
public abstract class Equipo implements MantenimientoGuardar,MantenimientoObtener{

    private int equipoId;
    private String codigoPatrimonial;
    private String modelo;
    private String marca;
    private Boolean fechaRegistro;
    private Boolean observaciones;
    private Boolean estado;
    private List<DocumentoTransferencia> transferencias;

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

    public Boolean getFechaRegistro() {
        return fechaRegistro;
    }

    public Boolean getObservaciones() {
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

    public void setObservaciones(Boolean observaciones) {
        this.observaciones = observaciones;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
}
