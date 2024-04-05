/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DAL.Entities.ThongTinSuDung;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author lamquoc
 */
public class ThongTinSuDungDAL {

    Session session;

    public ThongTinSuDung getThongTinSuDung(int MaTT) {
        session = HibernateUtils.getSessionFactory().openSession();
        ThongTinSuDung obj = null;
        try {
            session.beginTransaction();
            obj = session.get(ThongTinSuDung.class, MaTT);
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

    public List<ThongTinSuDung> getThongTinSuDungByThanhVien(int MaTV) {
        session = HibernateUtils.getSessionFactory().openSession();
        List<ThongTinSuDung> ls = null;
        try {
            session.beginTransaction();
            Query<ThongTinSuDung> query = session.createQuery("FROM ThietBi WHERE CONCAT('',MaTV) LIKE :MaTV", ThongTinSuDung.class);
            query.setParameter("MaTV", MaTV);
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
    
    public List<ThongTinSuDung> getThongTinSuDungByThietBi(int MaTB) {
        session = HibernateUtils.getSessionFactory().openSession();
        List<ThongTinSuDung> ls = null;
        try {
            session.beginTransaction();
            Query<ThongTinSuDung> query = session.createQuery("FROM ThietBi WHERE CONCAT('',MaTB) LIKE :MaTB", ThongTinSuDung.class);
            query.setParameter("MaTB", MaTB);
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
