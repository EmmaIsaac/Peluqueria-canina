
package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.persistencia.ControladoraPersistencia;
import java.util.List;


public class Controladora {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String nombreMasco, String raza, String color, String observaciones, String alergico, String atenEsp, String nombreDuenio, String celDuenio) {
       
        //creamos duenio y asugnamos valores
        Duenio duenio = new Duenio();
        duenio.setNombre(nombreDuenio);
        duenio.setCelDuenio(celDuenio);
        
        //creamos mascota y asgnamos valores
        Mascota masco = new Mascota();
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservaciones(observaciones);
        masco.setAlergico(alergico);
        masco.setAtencion_especial(atenEsp);
        masco.setUnDienio(duenio);
        
        controlPersis.guardar(duenio, masco);
        
    }

    public List<Mascota> traerMascotas() {        
           
        return controlPersis.traerMascotas();
        
    }

    public void borrarMascota(int num_cliente) {
        controlPersis.borrarMascota(num_cliente);
    }

    public Mascota trearMascota(int num_cliente) {
       return controlPersis.traerMascota(num_cliente);       
    }

    public void modificarMascota(Mascota masco, String nombreMasco, String raza, 
            String color, String observaciones, String alergico, String atenEsp, 
            String nombreDuenio, String celDuenio) {
        
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservaciones(observaciones);
        masco.setAlergico(alergico);
        masco.setAtencion_especial(atenEsp);
        
        //modificar mascota
        controlPersis.modificarMascota(masco);
        
        //seteo valores del dueño
        Duenio duenio = this.buscarDuenio(masco.getUnDienio().getId_duenio());
        duenio.setNombre(nombreDuenio);
        duenio.setCelDuenio(celDuenio);
        
        //modificar dueño
        this.modificarDuenio(duenio);
        
        
        
        
    }

    private Duenio buscarDuenio(int id_duenio) {
        return controlPersis.traerDuenio(id_duenio);
    }

    private void modificarDuenio(Duenio duenio) {
        controlPersis.modificarDuenio(duenio);
    }
    
    
}
