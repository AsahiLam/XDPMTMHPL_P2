/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DAL.Entities.ThongTinSuDung;
import java.util.Date;
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
            Query<ThongTinSuDung> query = session.createQuery("FROM Thongtinsd WHERE CONCAT('',MaTV) LIKE :MaTV", ThongTinSuDung.class);
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
            Query<ThongTinSuDung> query = session.createQuery("FROM Thongtinsd WHERE CONCAT('',MaTB) LIKE :MaTB", ThongTinSuDung.class);
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

    public List<ThongTinSuDung> getThongTinSuDungByInfos(Date fromDate, Date toDate) {
        session = HibernateUtils.getSessionFactory().openSession();
        List<ThongTinSuDung> ls = null;
        try {
            session.beginTransaction();
            Query<ThongTinSuDung> query = session.createQuery("SELECT t FROM ThongTinSuDung t WHERE t.TGVao BETWEEN :fromDate AND :toDate", ThongTinSuDung.class);
            query.setParameter("fromDate", fromDate);
            query.setParameter("toDate", toDate);

            ls = query.getResultList();

            session.getTransaction().commit();
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

    public List<ThongTinSuDung> getThongTinSuDungByInfos(String type, String info) {
        session = HibernateUtils.getSessionFactory().openSession();
        List<ThongTinSuDung> ls = null;
        try {
            session.beginTransaction();
            if (type.equals("khoa")) {
                Query<ThongTinSuDung> query = session.createQuery("SELECT t FROM ThongTinSuDung t WHERE t.ThanhVien.Khoa LIKE :info AND t.TGVao IS NOT NULL ", ThongTinSuDung.class);
                query.setParameter("info", info);
                ls = query.getResultList();
                session.getTransaction().commit();
            } else {
                Query<ThongTinSuDung> query = session.createQuery("SELECT t FROM ThongTinSuDung t WHERE t.ThanhVien.Nganh LIKE :info AND t.TGVao IS NOT NULL", ThongTinSuDung.class);
                query.setParameter("info", info);
                ls = query.getResultList();
                session.getTransaction().commit();
            }
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

    public List<ThongTinSuDung> getThongTinSuDungByInfos(Date fromDate, Date toDate, String type1) {
        List<ThongTinSuDung> result = null;
        session = HibernateUtils.getSessionFactory().openSession();
        try {
            session.beginTransaction();

            String hql = "SELECT t FROM ThongTinSuDung t WHERE t.TGMuon BETWEEN :fromDate AND :toDate";
            Query<ThongTinSuDung> query = session.createQuery(hql, ThongTinSuDung.class);
            query.setParameter("fromDate", fromDate);
            query.setParameter("toDate", toDate);

            result = query.getResultList();

            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session.getTransaction() != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

    public List<ThongTinSuDung> getThongTinSuDungByInfos(Date date) {
        session = HibernateUtils.getSessionFactory().openSession();
        List<ThongTinSuDung> ls = null;
        try {
            session.beginTransaction();
            Query<ThongTinSuDung> query = session.createQuery("SELECT t FROM ThongTinSuDung t WHERE t.TGVao IS NULL AND :date BETWEEN t.TGMuon AND t.TGTra", ThongTinSuDung.class);
            query.setParameter("date", date);

            ls = query.getResultList();

            session.getTransaction().commit();
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

    public List<ThongTinSuDung> getThongTinSuDungByInfos(String tenTB) {
        session = HibernateUtils.getSessionFactory().openSession();
        List<ThongTinSuDung> ls = null;
        try {
            session.beginTransaction();
            Query<ThongTinSuDung> query = session.createQuery("SELECT t FROM ThongTinSuDung t WHERE t.TGVao IS NULL AND t.ThietBi.TenTB LIKE :tenTB", ThongTinSuDung.class);
            query.setParameter("tenTB", tenTB);

            ls = query.getResultList();

            session.getTransaction().commit();
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
