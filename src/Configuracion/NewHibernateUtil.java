/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuracion;

import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author ck
 */
public class NewHibernateUtil {

    private static SessionFactory sessionFactory;
    private static StandardServiceRegistry registry;

    public static SessionFactory crearSesion() {
        try {
            registry = new StandardServiceRegistryBuilder().configure("/Configuracion/hibernate.cfg.xml").build();
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();           
        } catch (HibernateException exception) {
            System.out.println("Hibernate Configuration problem : " + exception);
        }
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void cerrarsesion() {
        sessionFactory.close();
        String mensaje = "La conexion a la  base de datos ha terminado";
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
