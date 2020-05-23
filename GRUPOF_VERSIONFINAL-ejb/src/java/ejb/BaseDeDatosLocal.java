/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Local;
import entidades.*;
import excepciones.ApSException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author aleex
 */
@Local
public interface BaseDeDatosLocal {
      //----Métodos para consultar todas las entidades----//
    List<Usuario> todosUsuarios();
    List<Actividad> todasActividades();
    List<Alumno> todosAlumnos();
    List<Asignatura> todasAsignaturas();
    List<Mensaje> todosMensajes(Usuario u);
    List<Noticia> todasNoticias();
    List<Organizacion> todasOrganizaciones();
    List<PAS> todosPAS();
    List<PDI> todosPDI();
    List<ParticipacionEnActividad> todasParticipaciones();
    List<ValoracionPublica> todasValPublicas();
    List<ValoracionPrivada> todasValPrivadas();
    List<Actividad> todasGestionesSolicitudes();
    List<Actividad> actividadesRechazadas(Long id);
    
    //----Métodos para insertar en la base de datos----//
    public void aniadirActividad(Actividad act);
    public void aniadirUsuario(Usuario usr);
    public void aniadirPDI(PDI pdi);
    public void aniadirONG(Organizacion org);
    public void aniadirAlumno(Alumno al);
    public void aniadirValPub(ValoracionPublica valPub);
    public void aniadirValPriv(ValoracionPrivada valPriv);
    public void aniadirParticipante(ParticipacionEnActividad participacion);
    public void aniadirMensaje(Mensaje m); //ESTE METODO QUIZAS DEBERIA SER ENVIAR MENSAJE Y AÑADIR EN PARAMETROS UN RECEPTOR
    public void aniadirNoticia(Noticia n);
    public void aniadirAsignatura(Asignatura asig);
    public void aniadirPAS(PAS pas);
    public void aniadirOrganizacion(Organizacion org);//yo

    //----Métodos para modificar en la base de datos----//
    public void modificarActividad(Actividad act);
    public void modificarUsuario(Usuario usr);
    public void modificarPDI(PDI pdi);
    public void modificarONG(Organizacion org);
    public void modificarAlumno(Alumno al);
    public void modificarNoticia(Noticia n);
    public void modificarPAS(PAS pas);
    
    //----Métodos para eliminar en la base de datos----//
    public void eliminarActividad(Long n);
    public void eliminarUsuario(Long usr);
    public void eliminarPDI(PDI pdi);
    public void eliminarONG(Long org);
    public void eliminarAlumno(Alumno al);
    public void eliminarNoticia(Long n);
    public void eliminarParticipante(ParticipacionEnActividad participacion); //No recuerdo si pusimos que se podía abandonar una actividad
    public void eliminarPAS(PAS pas);
    public void eliminarAsignatura(Asignatura asig);
    public void eliminarMensaje(Long n);
    //----Métodos de búsqueda en la base de datos----// //NO SE SI SON NECESARIOS ESTOS METODOS, EL DE ACTIVIDAD QUIZAS SI PERO PASANDOLE LOS PARAMETROS DEL MATCHING.
    public Actividad buscarActividad(Long n);
    public Usuario buscarUsuario(Long usr);
    public void buscarPDI(PDI pdi);
    public  Organizacion buscarONG(Long org);
    public void buscarAlumno(Alumno al);
    public void buscarValPub(ValoracionPublica valPub);
    public void buscarValPriv(ValoracionPrivada valPriv);
    public void buscarParticipante(ParticipacionEnActividad participacion);
    public Mensaje buscarMensaje(Long m);
    public Noticia buscarNoticia(Long codNoticia);
    public void compruebaLogin(Usuario u) throws ApSException;
    public Usuario refrescarUsuario(Usuario u) throws ApSException;
    public List<Actividad> todasActividadesONG(Long id);
  
  
    
}




/*

//AÑADIR ESTO ENCIMA DE LAS CORRESPONDIENTES ENTIDADES.
@NamedQuery(name = "Alumnos", query = "select al from Alumno al")
@NamedQuery(name = "Actividades", query = "select act from Actividad act")
@NamedQuery(name = "Asignaturas", query = "select asig from Asignatura asig")
@NamedQuery(name = "Mensajes", query = "select msg from Mensaje msg")
@NamedQuery(name = "Noticias", query = "select ntc from Noticia ntc")
@NamedQuery(name = "Organizaciones", query = "select org from Organizacion org")
@NamedQuery(name = "PAS", query = "select p from PAS p")
@NamedQuery(name = "PDI", query = "select p from PDI p")
@NamedQuery(name = "Participaciones", query = "select part from ParticipacionEnActividad part")
@NamedQuery(name = "Usuarios", query = "select usr from Usuario usr")
@NamedQuery(name = "ValoracionesPublicas", query = "select val from ValoracionPublica val")
@NamedQuery(name = "ValoracionesPrivadas", query = "select val from ValoracionPrivada val")

//HAY ENTIDADES EN LAS QUE DICE QUE HACE FALTA EL CONSTRUCTOR SIN ARGUMENTOS

*/
