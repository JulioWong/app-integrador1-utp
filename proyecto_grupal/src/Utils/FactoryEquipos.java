package Utils;

import Classes.Equipo;
import Classes.Impresora;
import Classes.Monitor;
import Classes.PC;
import Classes.Proyector;
import Classes.Teclado;

public final class FactoryEquipos {
    public static Equipo getInstancia(String nombreEquipo) {
        Equipo oEquipo = null;
        switch (nombreEquipo) {
            case "PC":
                oEquipo = new PC();
                break;
            case "MONITOR":
                oEquipo = new Monitor();
                break;
            case "IMPRESORA":
                oEquipo = new Impresora();
                break;
            case "PROYECTOR":
                oEquipo = new Proyector();
                break;
            case "TECLADO":
                oEquipo = new Teclado();
                break;
        }
        return oEquipo;
    }
}
