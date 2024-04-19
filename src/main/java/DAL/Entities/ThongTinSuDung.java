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
@Table(name = "thongtinsd")
public class ThongTinSuDung {

    @Id
    @Column(name = "MaTT")
    private int maTT;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MaTV",nullable = true)
    private ThanhVien thanhVien;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MaTB",nullable = true)
    private ThietBi thietBi;

    @Column(name = "TGVao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tgVao;

    @Column(name = "TGMuon", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date tgMuon;

    @Column(name = "TGTra", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date tgTra;

    @Column(name = "TGDatCho", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date tgDatCho;

}
