/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.Entities.XuLy;
import DAL.XuLyDAL;
import java.util.List;

/**
 *
 * @author lamquoc
 */
public class XuLyBLL {
    private XuLyDAL xuLyDAL;
    
    public XuLyBLL(){
        xuLyDAL = new XuLyDAL();
    }
    public XuLy getXuLy(int MaXL){
        return xuLyDAL.getXuLy(MaXL);
    }
    
    public List<XuLy> getListXuLy(){
        return xuLyDAL.getListXuLy();
    }
    
    public List<XuLy> getListXuLyWithInfo(String info){
        return xuLyDAL.getListThanhVienWithInfo(info);
    }
}
