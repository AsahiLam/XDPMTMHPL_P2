/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL.Entities;


import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author lamquoc
 */
@Data
@Entity
@Table
public class ThanhVien {
    @Id
    private int MaTV;
    @Column
    private String HoTen;
    @Column
    private String Khoa;
    @Column
    private String Nganh;
    @Column
    private String SDT;
    @Column
    private String Password;
    @Column
    private String Email;  
}
