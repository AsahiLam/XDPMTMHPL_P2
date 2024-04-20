/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.Entities.ThongTinSuDung;
import DAL.ThongTinSuDungDAL;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lamquoc
 */
public class ThongTinSuDungBLL {
    private ThongTinSuDungDAL thongTinSuDungDAL;
    
    public ThongTinSuDungBLL(){
        this.thongTinSuDungDAL = new ThongTinSuDungDAL();
    }
    public List<ThongTinSuDung> getStatisticInfo(Date fromDate, Date toDate){
        return thongTinSuDungDAL.getThongTinSuDungByInfos(fromDate, toDate);      
    }
    public List<ThongTinSuDung> getStatisticInfo(String type, String info){
        return thongTinSuDungDAL.getThongTinSuDungByInfos(type, info);      
    }
    public List<ThongTinSuDung> getStatisticInfo(Date fromDate, Date toDate, String type){
        return thongTinSuDungDAL.getThongTinSuDungByInfos(fromDate, toDate,type);      
    }
    public List<ThongTinSuDung> getStatisticInfo(Date date){
        return thongTinSuDungDAL.getThongTinSuDungByInfos(date);      
    }
    public List<ThongTinSuDung> getStatisticInfo(String tenTB){
        return thongTinSuDungDAL.getThongTinSuDungByInfos(tenTB);
    }
}
