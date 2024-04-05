/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

/**
 *
 * @author lamquoc
 */
import DAL.Entities.ThanhVien;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author caothanh
 */
public class HibernateUtils {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    static Scanner sc = new Scanner(System.in);

    private static SessionFactory buildSessionFactory() {

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder() //
                .configure() // Load hibernate.cfg.xml from resource folder by default
                .build();
        Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
        return metadata.getSessionFactoryBuilder().build();

    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void close() {
        getSessionFactory().close();
    }

    public static void main(String[] args) {
        // TODO code application logic here
        try (Session session = HibernateUtils.getSessionFactory().openSession();) {
            // Begin a unit of work
//            session.beginTransaction();
//            List<ThanhVien> thanhvien = session.createQuery("FROM ThanhVien", ThanhVien.class).list();
//            //xem danh sách
//            thanhvien.forEach(System.out::println);
//
//            //thêm mới
//            ThanhVien newThanhVien = new ThanhVien();
//
//            System.out.println("Nhập mã thành viên: ");
//            newThanhVien.setMaTV(Integer.parseInt(sc.next()));
//            System.out.println("- Họ và tên: ");
//            newThanhVien.setHoTen(sc.next());
//            System.out.println("- Khoa: ");
//            newThanhVien.setKhoa(sc.next());
//            System.out.println("- Ngành");
//            newThanhVien.setNganh(sc.next());
//            System.out.println("- SĐT: ");
//            newThanhVien.setSDT(sc.next());
//            System.out.println("- Password: ");
//            newThanhVien.setPassword(sc.next());
//            System.out.println("- Email: ");
//            newThanhVien.setEmail(sc.next());
//            session.save(newThanhVien);
//            session.getTransaction().commit();
//
//            //sửa
//            session.beginTransaction();
//            boolean exist = false;
//            System.out.println("Nhập mã thành viên: ");
//            while (!exist) {
//                ThanhVien findThanhVien = session.createQuery("FROM ThanhVien WHERE MaTV = :id", ThanhVien.class).setParameter("id", Integer.parseInt(sc.next())).uniqueResult();
//                if (findThanhVien != null) {
//                    System.out.println("- Họ và tên: ");
//                    findThanhVien.setHoTen(sc.next());
//                    System.out.println("- Khoa: ");
//                    findThanhVien.setKhoa(sc.next());
//                    System.out.println("- Ngành");
//                    findThanhVien.setNganh(sc.next());
//                    System.out.println("- SĐT: ");
//                    findThanhVien.setSDT(sc.next());
//                    System.out.println("- Password: ");
//                    findThanhVien.setPassword(sc.next());
//                    System.out.println("- Email: ");
//                    findThanhVien.setEmail(sc.next());
//                    session.update(findThanhVien);
//                    session.getTransaction().commit();
//                    exist = true;
//                } else {
//                    System.out.println("Nhập lại mã thành viên: ");
//                }
//            };
//
//            //xoá
//            session.beginTransaction();
//            exist = false;
//            System.out.println("Nhập mã thành viên: ");
//            while (!exist) {
//                ThanhVien findThanhVien = session.createQuery("FROM ThanhVien WHERE MaTV = :id", ThanhVien.class).setParameter("id", Integer.parseInt(sc.next())).uniqueResult();
//                if (findThanhVien != null) {
//                    session.delete(findThanhVien);
//                    session.getTransaction().commit();
//                    exist = true;
//                } else {
//                    System.out.println("Nhập lại mã thành viên: ");
//                }
//            };
        }
    }
}
