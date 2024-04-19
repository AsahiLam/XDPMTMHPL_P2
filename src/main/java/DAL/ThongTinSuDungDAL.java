/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DAL.Entities.ThanhVien;
import DAL.Entities.ThietBi;
import DAL.Entities.ThongTinSuDung;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author lamquoc
 */
public class ThongTinSuDungDAL {

    Session session;

    public List<ThongTinSuDung> getListThongTinSuDung() {
        session = HibernateUtils.getSessionFactory().openSession();
        List<ThongTinSuDung> list = null;
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            list = session.createQuery("FROM ThongTinSuDung", ThongTinSuDung.class).list();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

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

    public List<ThongTinSuDung> getThongTinSuDungByTGMuon(Date TGMuon) {
        session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        List<ThongTinSuDung> list = null;
        try {
            transaction = session.beginTransaction();
            Query<ThongTinSuDung> query = session.createQuery("FROM ThongTinSuDung WHERE CONCAT('',TGMuon) LIKE :TGMuon", ThongTinSuDung.class);
            query.setParameter("TGMuon", TGMuon);
            list = query.list();
        } catch (Exception e) {
            if(transaction!=null && transaction.isActive()){
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return list;
    }

    public void VaoKhuHocTap(ThanhVien tv, Date TGVao) {
        session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            ThongTinSuDung ttsd = new ThongTinSuDung();
            ttsd.setThanhVien(tv);
            ttsd.setTgVao(TGVao);
            session.save(ttsd);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    public void MuonThietBi(ThanhVien tv, ThietBi tb, Date TGMuon) {
        session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            ThongTinSuDung ttsd = new ThongTinSuDung();
            ttsd.setThanhVien(tv);
            ttsd.setThietBi(tb);
            ttsd.setTgMuon(TGMuon);
            session.save(ttsd);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    public void TraThietBi(int maTT, Date TGTra) {
        session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            ThongTinSuDung ttsd = session.get(ThongTinSuDung.class, maTT);
            ttsd.setTgTra(TGTra);
            session.update(ttsd);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
