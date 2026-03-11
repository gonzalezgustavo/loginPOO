
package LOGICA;

import PERSISTENCIA.ControladorPersistencia;
import java.util.List;

public class Controladora {
    
    ControladorPersistencia controlPersis= new ControladorPersistencia();

    public Usuario validarUsuario(String usuario, String contrasenia) {
   
      //  String mensaje="";
      Usuario usr= null;
        List<Usuario> listaUsuarios= controlPersis.traerUsuarios();
    
       for (Usuario usu : listaUsuarios ){
           
           if(usu.getNombreUsuario().equals(usuario)){
               if(usu.getContrasenia().equals(contrasenia)){
              //     mensaje="Usuario y Contraseña correctos";
               usr=usu;
              return usr;
               
               }
               else {
                   //mensaje="Contraseña incorrecta "  ;
                  usr=null;
                  return usr;
               }
           }else {
               //mensaje="Usuario no encontrado " ;
               usr=null;
           }
       
       }
       
return usr;
    }

    public List<Usuario> traerUsuarios() {
        
      
       return controlPersis.traerUsuarios();
    }

    public List<Rol> traerRoles() {
        
        return controlPersis.traerRoles();
   
    
    }

    public void crearUsuario(String usuario, String contra, String rolRecibido) {
    
        Usuario usu= new Usuario();
    
        usu.setNombreUsuario(usuario);
        usu.setContrasenia(contra);
        
        Rol rolEncontrado=new Rol();
        rolEncontrado= this.traerRol(rolRecibido);
        
        if (rolEncontrado!=null){
        usu.setUnRol(rolEncontrado);
        }
        
        int id= this.buscarUltimaIdUsuarios();
        
        controlPersis.crearUsuario(usu);
        
        
    
    }

    private Rol traerRol(String rolRecibido) {
    
         List <Rol> listaRoles = controlPersis.traerRoles();
    
         for (Rol rol: listaRoles){
             if (rol.getNombreRol().equals(rolRecibido))
             {
                 return rol;
             }
         }
         
         return null;
    
    }

    private int buscarUltimaIdUsuarios() {
            
        List<Usuario> listaUsuarios = this.traerUsuarios();
         
         return listaUsuarios.stream()
                .mapToInt(Usuario::getId)
                .max()
                .orElse(0);
    }
    
    

}

