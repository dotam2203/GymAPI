package com.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.util.List;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  03/07/2022
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "KHACHHANG")
public class KhachHangEntity {
    @Id
    @Basic(optional = false)
    @Column(name = "MaKH")
    @Nationalized
    private String maKH;

    @Basic(optional = false)
    @Column(name = "HoTen")
    @Nationalized
    private String hoTen;

    @Basic(optional = false)
    @Column(name = "Email")
    @Nationalized
    private String email;

    @Basic(optional = false)
    @Column(name = "SDT")
    @Nationalized
    private String sdt;

    @Basic(optional = false)
    @Column(name = "Phai")
    @Nationalized
    private String phai;

    @Column(name = "DiaChi")
    @Nationalized
    private String diaChi;

    @Nationalized
    @Column(name = "HinhAnh")
    private String hinhAnh;

    @JoinColumn(name = "MaLoaiKH")
    @ManyToOne
    @Basic(optional = false)
    private LoaiKhachHangEntity loaiKH;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "khachHang")
    private List<TheTapEntity> theTaps;
}
