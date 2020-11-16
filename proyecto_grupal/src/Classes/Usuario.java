package Classes;

import Data.Database;
import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;

public class Usuario {
    private final Facultad facultad;
    private final String usuario;
    private final String contrasena;
    private final Database database;

    public Usuario(Facultad facultad, String usuario, String contrasena) {
        this.database = new Database();
        this.facultad = facultad;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }
    
    public Boolean login() {
        Document mydoc = this.database.getMongoCollection("user").find(
                eq("user", this.usuario)).first();
        System.out.println(mydoc);
        return false;
    }
}