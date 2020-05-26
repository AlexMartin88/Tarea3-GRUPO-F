/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;
import entidades.*;
import excepciones.ApSException;
import java.util.List;
import java.util.Random;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author aleex
 */
@Stateless
public class BaseDeDatos implements BaseDeDatosLocal{
    
    @PersistenceContext(unitName="GRUPOF")
    private EntityManager em;

    //----Métodos para insertar en la base de datos----//
    @Override
    public void aniadirActividad(Actividad act){
        em.persist(act);
    }
    @Override
    public void aniadirUsuario(Usuario usr){
   
        em.persist(usr);
    }
    @Override
    public void aniadirPDI(PDI pdi){
        em.persist(pdi);
    }
    @Override
    public void aniadirONG(Organizacion org){      
        em.persist(org);
    }
    @Override
    public void aniadirAlumno(Alumno al){
        em.persist(al);
    }
    @Override
    public void aniadirValPub(ValoracionPublica valPub){
        em.persist(valPub);
       
    }
    @Override
    public void aniadirValPriv(ValoracionPrivada valPriv){
        em.persist(valPriv);
    }
    @Override
    public void aniadirParticipante(ParticipacionEnActividad participacion){
        em.persist(participacion);
    }
    @Override
    public void aniadirMensaje(Mensaje m){//ESTE METODO QUIZAS DEBERIA SER ENVIAR MENSAJE Y AÑADIR EN PARAMETROS UN RECEPTOR.
        em.persist(m);
    }
    @Override
    public void aniadirNoticia(Noticia n){
        em.persist(n);
    }
    @Override
    public void aniadirAsignatura(Asignatura asig){
        em.persist(asig);
    }
    @Override
    public void aniadirPAS(PAS pas){
        em.persist(pas);
    }
    
    //----Métodos para modificar en la base de datos----//
    @Override
    public void modificarActividad(Actividad act){
        em.persist(em.merge(act));
    }
    @Override
    public void modificarUsuario(Usuario usr){
        em.persist(em.merge(usr));
    }
    @Override
    public void modificarPDI(PDI pdi){
        
    }
    @Override
    public void modificarONG(Organizacion org){
        em.persist(em.merge(org));
    }
    @Override
    public void modificarAlumno(Alumno al){
        
    }
    @Override
    public void modificarNoticia(Noticia n){
       
          em.persist(em.merge(n));
    }
    @Override
    public void modificarPAS(PAS pas){
        
    }
    
    @Override
    public void eliminarMensaje(Long n){
        Mensaje m = buscarMensaje(n);
       em.remove(m);
    }
    //----Métodos para eliminar en la base de datos----//
    @Override
    public void eliminarActividad(Long n){
        
       Actividad a = buscarActividad(n);
       em.remove(a);
    }
    @Override
    public void eliminarUsuario(Long u){
        Usuario usr = buscarUsuario(u);
        
        em.remove(usr);
    }
    @Override
    public void eliminarPDI(PDI pdi){
        em.remove(pdi);
    }
    @Override
    public void eliminarONG(Long ong){
        Organizacion o =  buscarONG(ong);
        em.remove(o);
    }
    @Override
    public void eliminarAlumno(Alumno al){
        em.remove(al);
    }
    @Override
    public void eliminarNoticia(Long n){
       
       Noticia not = buscarNoticia(n);
       em.remove(not);
      
    }
    @Override
    public void eliminarParticipante(ParticipacionEnActividad participacion){//No recuerdo si pusimos que se podía abandonar una actividad
        em.remove(participacion);
    }
    @Override
    public void eliminarPAS(PAS pas){
        em.remove(pas);
    }
    @Override
    public void eliminarAsignatura(Asignatura asig){
        em.remove(asig);
    }
    //----Métodos de búsqueda en la base de datos----// //NO SE SI SON NECESARIOS ESTOS METODOS, EL DE ACTIVIDAD QUIZAS SI PERO PASANDOLE LOS PARAMETROS DEL MATCHING.
    @Override
    public Actividad buscarActividad(Long codActividad){
        
        Actividad a = em.find(Actividad.class, codActividad);
        
        return a;
    }
    @Override
    public Usuario buscarUsuario(Long id){
        Usuario u = em.find(Usuario.class, id);
        return u;
    }
    @Override
    public void buscarPDI(PDI pdi){
        
    }
    @Override
    public Organizacion buscarONG(Long id){
        Organizacion ong = em.find(Organizacion.class, id);
        return ong;
    }
    @Override
    public void buscarAlumno(Alumno al){
        
    }
    @Override
    public void buscarValPub(ValoracionPublica valPub){
        
    }
    @Override
    public void buscarValPriv(ValoracionPrivada valPriv){
        
    }
    @Override
    public List<ParticipacionEnActividad> buscarPorEstado(String estado,Actividad a){
        Query q = em.createNamedQuery("buscarporEstado").setParameter("estado", estado).setParameter("actividad", a);
        return q.getResultList();
    }
    @Override
    public ParticipacionEnActividad buscarParticipante(Long id){
        
        ParticipacionEnActividad p = em.find(ParticipacionEnActividad.class, id);
        return p;
    }
    @Override
    public Mensaje buscarMensaje(Long n){
          Mensaje m  = em.find(Mensaje.class, n);
        
        return m;
    }
    @Override
    public Noticia buscarNoticia(Long codNoticia){
        
        Noticia n = em.find(Noticia.class, codNoticia);
        
        return n;
    }
    @Override
    public List<Usuario> todosUsuarios(){
        return null;
    }
    @Override
    public List<Actividad> todasActividades(){
        Query q = em.createNamedQuery("findAllActividades").setParameter("estado", "ACEPTADA");
        List<Actividad> actividades = q.getResultList();
        return actividades;
    }
    @Override
    public List<Actividad> todasActividadesONG(Long id){
        //Organizacion o=em.find(Organizacion.class, id);
        Query q = em.createNamedQuery("findAllActividadesONG").setParameter("ong",id);
        List<Actividad> actividades = q.getResultList();
        return actividades;
    }
    @Override
    public List<Alumno> todosAlumnos(){
        return em.createNamedQuery("Alumnos", Alumno.class).getResultList();
    }
    @Override
    public List<Asignatura> todasAsignaturas(){
        return em.createNamedQuery("Asignaturas", Asignatura.class).getResultList();
    }
    @Override
    public List<Mensaje> todosMensajes(Usuario u){
        
         Query q = em.createNamedQuery("findAllMensajes").setParameter("email", u.getEmail());
        List<Mensaje> mensajes = q.getResultList();
      
         return mensajes;
       
    }
   
    @Override
    public List<Noticia> todasNoticias(){
        Query q = em.createNamedQuery("findAllNoticias");
        List<Noticia> not = q.getResultList();
      
         return not;
    }
    @Override
    public List<Organizacion> todasOrganizaciones(){
        return em.createNamedQuery("Organizaciones", Organizacion.class).getResultList();
    }
    @Override
    public List<PAS> todosPAS(){
        return em.createNamedQuery("PAS", PAS.class).getResultList();
    }
    @Override
    public List<PDI> todosPDI(){
        return em.createNamedQuery("PDI", PDI.class).getResultList();
    }
    @Override
    public List<ParticipacionEnActividad> todasParticipaciones(){
       return em.createNamedQuery("Participaciones", ParticipacionEnActividad.class).getResultList();
    }
    @Override
    public List<ValoracionPublica> todasValPublicas(Long cod){
       Query q = em.createNamedQuery("valoraciones").setParameter("id", cod);
       List<ValoracionPublica> valoraciones = q.getResultList();
       return valoraciones;
    }
    @Override
    public List<ValoracionPrivada> todasValPrivadas(){
        return em.createNamedQuery("ValoracionesPrivadas", ValoracionPrivada.class).getResultList();
    }
    
    @Override
    public List<Actividad> todasGestionesSolicitudes() {
        
        Query q = em.createNamedQuery("solicitudes").setParameter("solicitud","PENDIENTE");
        List<Actividad> socilitudes = q.getResultList();
        return socilitudes;
    }
 @Override
    public List<Actividad> actividadesRechazadas(Long id) {
     //  Organizacion o=em.find(Organizacion.class, id);
      
        Query q = em.createNamedQuery("actRechazadas").setParameter("solicitud","DENEGADA").setParameter("ong",id);
        List<Actividad> socilitudes = q.getResultList();
        return socilitudes;
    }
    @Override
    public void aniadirOrganizacion(Organizacion org){//YO
    
        em.persist(org);
    }

    @Override
    public void compruebaLogin(Usuario u) throws ApSException {
        
        Query q = em.createNamedQuery("buscarUsuarioContra").setParameter("email", u.getEmail());
        List<Usuario> l = q.getResultList();
        System.out.println(l.get(0).toString());
        
        if (l.get(0)== null) {
            throw new ApSException("La cuenta no existe.");
        }

        if (!l.get(0).getPassword().equals(u.getPassword())) {
            throw new ApSException("Contraseña incorrecta.");
        }
    }

    @Override
    public Usuario refrescarUsuario(Usuario u) throws ApSException {
        compruebaLogin(u);
        Query q = em.createNamedQuery("buscarUsuarioContra").setParameter("email", u.getEmail());
        List<Usuario> l = q.getResultList();
        
  
        em.refresh(l.get(0));
        return l.get(0);   
    }

    @Override
    public void modificarValPub(ValoracionPublica v) {
        em.persist(em.merge(v));
    }

    @Override
    public void modificarParticipacion(ParticipacionEnActividad p) {
      em.persist(em.merge(p));
    }

   

    
   
    }
