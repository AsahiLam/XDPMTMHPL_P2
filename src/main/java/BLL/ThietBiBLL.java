/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.Entities.ThietBi;
import DAL.ThietBiDAL;
import java.util.List;

/**
 *
 * @author lamquoc
 */
public class ThietBiBLL {
    private ThietBiDAL thietBiDAL;
    
    public ThietBiBLL(){
        thietBiDAL = new ThietBiDAL();
    }
    public ThietBi getThietBi(int id){
        return thietBiDAL.getThietBi(id);
    }
    public List<ThietBi> getListThietBi(){
        return thietBiDAL.getListThietBi();
    }
    public List<ThietBi> getListThietBiWithInfo(String info){
        return thietBiDAL.getListThietBiWithInfo(info);
    }
}
