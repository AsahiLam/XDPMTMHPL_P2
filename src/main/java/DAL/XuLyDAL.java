/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DAL.Entities.ThanhVien;
import DAL.Entities.XuLy;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author lamquoc
 */
public class XuLyDAL {

    private Session session;

    public XuLyDAL() {

    }

    public XuLy getXuLy(int MaXL) {
        session = HibernateUtils.getSessionFactory().openSession();
        XuLy obj;
        session.beginTransaction();
        obj = session.get(XuLy.class, MaXL);
        session.getTransaction().commit();
        session.close();
        return obj;
    }

    public List<XuLy> getListXuLy() {
        session = HibernateUtils.getSessionFactory().openSession();
        List<XuLy> ls;
        session.beginTransaction();
        ls = session.createQuery("FROM XuLy", XuLy.class).list();
        session.close();
        return ls;
    }

    public List<XuLy> getListThanhVienWithInfo(String info) {
        session = HibernateUtils.getSessionFactory().openSession();
        List<XuLy> ls = null;
        try {
            session.beginTransaction();
            if (info.equalsIgnoreCase("chưa xử lý")) {
                Query<XuLy> query = session.createQuery("SELECT x FROM XuLy x JOIN x.ThanhVien t WHERE CONCAT('', x.MaXL) LIKE :info OR CONCAT('', t.MaTV) LIKE :info OR t.HoTen LIKE :info OR x.HinhThucXL LIKE :info OR x.SoTien LIKE :info OR x.NgayXL LIKE :info OR x.TrangThaiXL = :status", XuLy.class);
                query.setParameter("info", "%" + info + "%");
                query.setParameter("status", 0);
                ls = query.list();
            } else if(info.equalsIgnoreCase("đã xử lý")){
                Query<XuLy> query = session.createQuery("SELECT x FROM XuLy x JOIN x.ThanhVien t WHERE CONCAT('', x.MaXL) LIKE :info OR CONCAT('', t.MaTV) LIKE :info OR t.HoTen LIKE :info OR x.HinhThucXL LIKE :info OR x.SoTien LIKE :info OR x.NgayXL LIKE :info OR x.TrangThaiXL = :status", XuLy.class);
                query.setParameter("info", "%" + info + "%");
                query.setParameter("status", 1);
                ls = query.list();
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
}
