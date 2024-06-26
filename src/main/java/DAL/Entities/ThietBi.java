/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author lamquoc
 */
@Data
@Entity
@Table
public class ThietBi {
    @Id
    private int MaTB;
    @Column
    private String TenTB;
    @Column 
    private String MoTaTB;
}
