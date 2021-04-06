
import Controlador.Controlador;
import Vistas.Creditos;
import Vistas.Escalacion;
import Vistas.Menu;
import Vistas.PlanoEscalacion;
import Vistas.PlanoRotacion;
import Vistas.PlanoTraslaciones;
import Vistas.Portada;
import Vistas.Rotacion;
import Vistas.Traslaciones;


public class Main {

    public static void main(String[] args) {
        Portada p = new Portada();
        Menu m = new Menu();
        Traslaciones tr = new Traslaciones();
        PlanoTraslaciones ptr = new PlanoTraslaciones();
        Escalacion es = new Escalacion();
        PlanoEscalacion pes = new  PlanoEscalacion();
        Rotacion r = new Rotacion();
        PlanoRotacion pr = new PlanoRotacion();
        Creditos cr = new Creditos();
        
        Controlador controlador = new Controlador(p,m,tr, ptr, es, pes,r,pr,
                cr);
        
        
    }
    
}
