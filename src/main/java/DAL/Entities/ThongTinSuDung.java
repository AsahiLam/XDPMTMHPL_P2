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
public class ThongTinSuDung {
    @Id
    private int MaTT;
    
    @ManyToOne 
    @JoinColumn(name = "MaTV")
    private ThanhVien ThanhVien;
    
    @ManyToOne
    @JoinColumn(name = "MaT")
    private ThietBi ThietBi;
    
    @Column
    private Date TGVao;
    
    @Column
    private Date TGMuon;
    
    @Column
    private Date TGTra;
    
    
    
}
