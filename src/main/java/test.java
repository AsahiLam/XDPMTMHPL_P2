
import BLL.ThanhVienBLL;
import DAL.Entities.ThanhVien;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lamquoc
 */
public class test {
    private ThanhVienBLL thanhVienBLL = new ThanhVienBLL();
    
    public void thanhVien(){
        System.out.println(thanhVienBLL.getThanhVien().toString());
    }
    public static void main(String args[]){
        
    }
}
