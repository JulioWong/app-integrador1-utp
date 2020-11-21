
package Classes;

import java.util.List;

public class DocumentoTransferencia {

    
    public int transferenciaId;
    public String documentoAutorizacion;
    public Dependencia dependenciaOrigen;
    public Dependencia dependenciaDestino;
    public List<Equipo> equipos;
    public Usuario usuario;
    public String motivo;
    public String fecha;

    public DocumentoTransferencia() {
    }
    
    public void setDocumentoAutorizacion(String documentoAutorizacion) {
        this.documentoAutorizacion = documentoAutorizacion;
    }

    public void setDependenciaOrigen(Dependencia dependenciaOrigen) {
        this.dependenciaOrigen = dependenciaOrigen;
    }

    public void setDependenciaDestino(Dependencia dependenciaDestino) {
        this.dependenciaDestino = dependenciaDestino;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public int getTransferenciaId() {
        return transferenciaId;
    }

    public String getDocumentoAutorizacion() {
        return documentoAutorizacion;
    }

    public Dependencia getDependenciaOrigen() {
        return dependenciaOrigen;
    }

    public Dependencia getDependenciaDestino() {
        return dependenciaDestino;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getFecha() {
        return fecha;
    }
    
    public void obtenerDocumentoTransferencia(){
        
    }
    
    public void agregarEquipo(){
        
    }
    
    public void guardarDocumentoTransferencia(){
        
    }
}
