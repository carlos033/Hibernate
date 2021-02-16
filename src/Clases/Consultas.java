/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Configuracion.NewHibernateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author ck
 */
public class Consultas {

    public static List CiudadesDeUnPais(Country pais) {
        String nombreCiudad;
        List<String> nCiudades = new ArrayList();
        Session sesion = NewHibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tr = sesion.beginTransaction();
        Query consulta;
        consulta = sesion.createNativeQuery("SELECT city FROM City where country_id =:pais").setParameter("pais", pais);
        nCiudades = consulta.getResultList();
        tr.commit();
        sesion.close();
        return nCiudades;
    }

    public static List PaisesQueEmpiezan(String letra) {
        String letraC = letra + "%";
        String nombrePais;
        List<String> nPaises = new ArrayList();
        Session sesion = NewHibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tr = sesion.beginTransaction();
        Query consulta;
        consulta = sesion.createNativeQuery("SELECT country FROM Country where country like :letraC ").setParameter("letraC", letraC);
        nPaises = consulta.getResultList();
        tr.commit();
        sesion.close();
        return nPaises;
    }

    public static void InsertarCiudad(Country pais, String nombre) {
        Date fecha = new Date();
        City ncity = new City(pais, nombre, fecha);
        Session sesion = NewHibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tr = sesion.beginTransaction();
        sesion.save(ncity);
        tr.commit();
        sesion.close();
        String mensaje = "Ciudad insertada correctamente";
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public static void EliminarCiudad(String nombre) {
        Session sesion = NewHibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tr = sesion.beginTransaction();
        Query consulta;
        consulta = sesion.createNativeQuery("SELECT country_id FROM Country where country like :nombre ").setParameter("nombre", nombre);
        Short id = (Short) consulta.getSingleResult();
        Country city = sesion.get(Country.class,id);
      /*  Query consulta = sesion.createNativeQuery("Delete FROM City where city like :nombre ").setParameter("nombre", nombre);
        consulta.executeUpdate();*/
       if(city!=null){
            sesion.remove(city);
        tr.commit();
        sesion.close();
        String mensaje = "Ciudad eliminada correctamente";
        JOptionPane.showMessageDialog(null, mensaje);
    }
    }
}
