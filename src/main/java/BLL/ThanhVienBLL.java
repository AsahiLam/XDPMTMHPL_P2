/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.Entities.ThanhVien;
import DAL.ThanhVienDAL;
import java.util.List;

/**
 *
 * @author lamquoc
 */
public class ThanhVienBLL {
    private final ThanhVienDAL thanhVienDAL;
    public ThanhVienBLL(){
        thanhVienDAL = new ThanhVienDAL();
    }
    public ThanhVien getThanhVien(){
        return thanhVienDAL.getThanhVien(1120150184);
    }
    
    public List<ThanhVien> getListThanhVien(){
        return thanhVienDAL.getListThanhVien();
    }
    
    public List<ThanhVien> getListThanhVienWithInfo(String info){
        return thanhVienDAL.getListThanhVienWithInfo(info);
    }
    
}
