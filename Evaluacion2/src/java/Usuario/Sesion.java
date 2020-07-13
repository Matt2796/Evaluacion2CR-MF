package Usuario;

public class Sesion {
    public static Usuario us = null;
    
    public static void SetUsuario(Usuario us){
       Sesion.us = us;
    }
    
    public static Usuario getUsuario(){
        return us;
    }
}
