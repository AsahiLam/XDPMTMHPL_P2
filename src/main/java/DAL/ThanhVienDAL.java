/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DAL.Entities.ThanhVien;
import java.util.Iterator;
import java.util.List;
import org.hibernate.*;

/**
 *
 * @author lamquoc
 */
public class ThanhVienDAL {

    Session session;

    public ThanhVien getThanhVien(String MaTV) {
        session = HibernateUtils.getSessionFactory().openSession();
        ThanhVien obj = null;
        try {
            try{
                int maTV = Integer.parseInt(MaTV);
                session.beginTransaction();
                obj = session.get(ThanhVien.class, maTV);
            }catch(NumberFormatException e){
                
            }        
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

    public List<ThanhVien> getListThanhVien() {
        session = HibernateUtils.getSessionFactory().openSession();
        List<ThanhVien> ls = null;
        try {
            session.beginTransaction();
            ls = session.createQuery("FROM ThanhVien", ThanhVien.class).list();
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

    public List<ThanhVien> getListThanhVienWithInfo(String info) {
        session = HibernateUtils.getSessionFactory().openSession();
        List<ThanhVien> ls = null;
        try {
            session.beginTransaction();
            Query<ThanhVien> query = session.createQuery("FROM ThanhVien WHERE  CONCAT('', MaTV) LIKE :info OR HoTen LIKE :info OR Khoa LIKE :info OR Nganh LIKE :info OR SDT LIKE :info OR Email LIKE :info", ThanhVien.class);
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
    
    public List<String> getAllKhoa(){
        session = HibernateUtils.getSessionFactory().openSession();
        List<String> ls = null;
        try{
            session.beginTransaction();
            Query<String> query = session.createQuery("SELECT DISTINCT t.Khoa FROM ThanhVien t", String.class);
            ls = query.getResultList();
            session.getTransaction().commit();
        }catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return ls;
    }
    
    public List<String> getAllNganh(){
        session = HibernateUtils.getSessionFactory().openSession();
        List<String> ls = null;
        try{
            session.beginTransaction();
            Query<String> query = session.createQuery("SELECT DISTINCT t.Nganh FROM ThanhVien t", String.class);
            ls = query.getResultList();
            session.getTransaction().commit();
        }catch (HibernateException e) {
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
