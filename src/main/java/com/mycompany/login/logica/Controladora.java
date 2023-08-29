package com.mycompany.login.logica;

import com.mycompany.login.persistencia.ControladoraPersistencia;
import java.util.ArrayList;
import java.util.List;


public class Controladora {
    
    ControladoraPersistencia controladoraPersis = new ControladoraPersistencia();

   

    public Usuario validarUsuario(String usuario, String contrasenia) {
        List<Usuario> listaUsuarios;
        listaUsuarios = controladoraPersis.buscarUsuarios();
        Usuario user = null;
        for(Usuario usu : listaUsuarios){
            if(usu.getUsuario().equals(usuario)){
                if(usu.getContrasenia().equals(contrasenia)){
                user = usu;
                return user;
                }else{
                    user = null;
                return user;
                }
            }else{
                user = null;
            }
        }
        return user;
    }

    public List<Usuario> traerUsuariosUser() {
        List<Usuario> listaUsuarios;
        listaUsuarios = controladoraPersis.buscarUsuarios();
        ArrayList<Usuario> users = new ArrayList<>();
        for(Usuario usu : listaUsuarios){
            if(usu.getRol().getNombreRol().equals("user")){
               users.add(usu);
            }
        }
        return users;
    }

    public List<Usuario> traerUsuarios() {
        return controladoraPersis.buscarUsuarios();
    }

    public void crearUser(String usuario, String contrasenia, String rol) {
        Usuario user = new Usuario();
        user.setUsuario(usuario);
        user.setContrasenia(contrasenia);
        Rol rolEncontrado = new Rol(); 
        rolEncontrado = this.traerRol(rol);
        if(rolEncontrado != null){
            user.setRol(rolEncontrado);
        }
        controladoraPersis.crearUser(user);
    }

    public Rol traerRol(String rol){
        List<Rol> listaRoles = controladoraPersis.traerRols();
        if(listaRoles != null){
            for(Rol rol2 : listaRoles){
                if(rol2.getNombreRol().equals(rol)){
                    return rol2;
                }   
            }
        }
        return null;
    }

    public List<Rol> traerRols() {
        return controladoraPersis.traerRols();
    }

    public void eliminarUser(int id) {
       controladoraPersis.eliminarUser(id); 
    }

    public Usuario encontrarUser(int id) {
       return controladoraPersis.encontrarUser(id);
    }

    public void editarUsuario(Usuario user, String usuario, String contrasenia, String rol) {
       user.setUsuario(usuario);
        user.setContrasenia(contrasenia);
        Rol rolEncontrado = this.traerRol(rol);
        if(rolEncontrado !=null){
            user.setRol(rolEncontrado);
        }
        controladoraPersis.editarUser(user);
    }

    

   

    

    
    
}
