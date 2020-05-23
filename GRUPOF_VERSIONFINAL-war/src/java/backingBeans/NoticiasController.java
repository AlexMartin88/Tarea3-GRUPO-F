/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingBeans;

import ejb.BaseDeDatosLocal;
import entidades.*;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import javax.inject.Named;

/**
 *
 * SII
 * 3ºA Ingeniería Informática 
 * @author GRUPOF
 */

@Named(value ="ListaNoticias")
@RequestScoped
public class NoticiasController implements Serializable{
    @Inject 
    private BaseDeDatosLocal bbdd;
    
    private Noticia noticia;
    private Long codigo;

    public NoticiasController() {
        noticia = new Noticia();
    }

    public Noticia getNoticia() {
        return noticia;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    
    public List<Noticia> Noticias(){
       return bbdd.todasNoticias();
    }

    public String borrarNoticia(Long cod){
        bbdd.eliminarNoticia(cod);
        return "noticias.xhtml";
    }
    public void setNoticia(Noticia noticia) {
        this.noticia = noticia;
    }
    
    public String createNoticia(){
        return "crearNoticia.xhtml";
    }
    
    public String create(){
        
        bbdd.aniadirNoticia(noticia);
        return "noticias.xhtml";
    }
   
    public String verNoticia(){
        return "verNoticia.xhtml";
    }
    
    public String modificarNoticia(Long cod){
        codigo = cod;
        noticia = bbdd.buscarNoticia(codigo);
        return "modificarNoticia.xhtml";
    }
    
    public String modificar(){
        bbdd.modificarNoticia(noticia);
        return "noticias.xhtml";
    }
}

