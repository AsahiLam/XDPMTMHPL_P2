/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.Entities.ThanhVien;
import DAL.Entities.ThietBi;
import DAL.Entities.ThongTinSuDung;
import DAL.Entities.XuLy;
import DAL.ThongTinSuDungDAL;
import java.awt.Choice;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 *
 * @author lamquoc
 */
public class ThongTinSuDungBLL {

    private ThongTinSuDungDAL thongTinSuDungDAL;

    public ThongTinSuDungBLL() {
        thongTinSuDungDAL = new ThongTinSuDungDAL();
    }

    public List<ThongTinSuDung> getListThongTinSuDung() {
        return thongTinSuDungDAL.getListThongTinSuDung();
    }
    
    public ThongTinSuDung getThongTinSuDung(int MaTT){
        return thongTinSuDungDAL.getThongTinSuDung(MaTT);
    }
    
    public List<ThongTinSuDung> getThongTinSuDungByTGMuon(Date TGMuon){
        return thongTinSuDungDAL.getThongTinSuDungByTGMuon(TGMuon);
    }

    public void vaoKhuHocTap(ThanhVien tv, Date tgVao) {
        XuLyBLL xlBL = new XuLyBLL();
        boolean canEnter = true;
        for (XuLy xl : xlBL.getListXuLy()) {
            if (xl.getThanhVien().equals(tv) && xl.getTrangThaiXL() != 1) {
                canEnter = false;
                JOptionPane.showMessageDialog(null, "Bạn đang bị xử phạt vi phạm " + xl.getHinhThucXL());
                break;
            }
        }
        if (canEnter) {
            thongTinSuDungDAL.VaoKhuHocTap(tv, tgVao);
            JOptionPane.showMessageDialog(null, "Vào thành công");
        }
    }

    public void muonThietBi(ThanhVien tv, ThietBi tb, Date TGMuon) {
        XuLyBLL xlBL = new XuLyBLL();
        boolean canEnter = true;
        for (XuLy xl : xlBL.getListXuLy()) {
            if (xl.getThanhVien().equals(tv) && xl.getTrangThaiXL() != 1) {
                canEnter = false;
                JOptionPane.showMessageDialog(null, "Bạn đang bị xử phạt vi phạm " + xl.getHinhThucXL());
                break;
            }
        }
        if (canEnter) {
            int choice = JOptionPane.showConfirmDialog(null, "Bạn xác nhận mượn thiết bị?", "Xác nhận mượn thiết bị", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                thongTinSuDungDAL.MuonThietBi(tv, tb, TGMuon);
            } else {
                return;
            }
        }
    }

    public void traThietBi(int maTT, Date TGTra) {
        thongTinSuDungDAL.TraThietBi(maTT, TGTra);
    }

}
