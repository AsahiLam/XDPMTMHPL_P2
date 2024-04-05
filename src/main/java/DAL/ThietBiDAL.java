/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DAL.Entities.ThietBi;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author lamquoc
 */
public class ThietBiDAL {

    Session session;

    public ThietBiDAL() {

    }

    public ThietBi getThietBi(int MaTB) {
        session = HibernateUtils.getSessionFactory().openSession();
        ThietBi obj = null;
        try {
            session.beginTransaction();
            obj = session.get(ThietBi.class, MaTB);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return obj;
    }

    public List<ThietBi> getListThietBi() {
        session = HibernateUtils.getSessionFactory().openSession();
        List<ThietBi> ls = null;
        try {
            session.beginTransaction();
            ls = session.createQuery("FROM ThietBi", ThietBi.class).list();
        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return ls;
    }

    public List<ThietBi> getListThietBiWithInfo(String info) {
        session = HibernateUtils.getSessionFactory().openSession();
        List<ThietBi> ls = null;
        try {
            session.beginTransaction();
            Query<ThietBi> query = session.createQuery("FROM ThietBi WHERE  CONCAT('', MaTB) LIKE :info OR TenTB LIKE :info OR MoTaTB LIKE :info", ThietBi.class);
            query.setParameter("info", "%" + info + "%");
            ls = query.list();

        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return ls;
    }

}
