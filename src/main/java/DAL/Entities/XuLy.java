/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL.Entities;

import java.util.Date;
import javax.persistence.*;

import lombok.Data;


/**
 *
 * @author lamquoc
 */
@Data
@Entity
@Table
public class XuLy {
    @Id
    private int MaXL;
    
    @ManyToOne
    @JoinColumn(name = "MaTV")
    private ThanhVien ThanhVien;
    
    @Column
    private String HinhThucXL;
    
    @Column
    private Double SoTien;
            
    @Column
    private Date NgayXL;
    
    @Column
    private int TrangThaiXL;       
           
}
