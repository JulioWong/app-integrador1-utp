package Interfaces;

import Data.Database;

public interface MantenimientoGuardar {
    public Database database = new Database();
    
    public String guardar();
}
