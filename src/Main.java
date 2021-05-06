
import Controlador.Controlador;
import Vistas.Creditos;
import Vistas.Escalacion;
import Vistas.EscalacionS;
import Vistas.Menu;
import Vistas.PlanoEscalacion;
import Vistas.PlanoRotacion;
import Vistas.PlanoTraslaciones;
import Vistas.Portada;
import Vistas.Rotacion;
import Vistas.RotacionS;
import Vistas.Traslaciones;
import Vistas.TraslacionesR;


public class Main {

    public static void main(String[] args) {
        Portada p = new Portada();
        Menu m = new Menu();
        
        Traslaciones tr = new Traslaciones();
        TraslacionesR tr2 = new TraslacionesR();
        
        PlanoTraslaciones ptr = new PlanoTraslaciones();
        PlanoTraslaciones ptr2 = new PlanoTraslaciones();
        
        Escalacion es = new Escalacion();
        EscalacionS es2 = new EscalacionS();
        PlanoEscalacion pes = new  PlanoEscalacion();
        PlanoEscalacion pes2 = new  PlanoEscalacion();
        Rotacion r = new Rotacion();
        PlanoRotacion pr = new PlanoRotacion();
        RotacionS r2 = new RotacionS();
        PlanoRotacion pr2 = new PlanoRotacion();
        Creditos cr = new Creditos();
        
        Controlador controlador = new Controlador(p,m,tr, ptr, es, pes,r,pr,
                cr,tr2,ptr2, es2,pes2,r2,pr2);
        
        
    }
    
}
