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
@Table(name = "NHANVIEN")
public class NhanVienEntity {
    @Id
    @Basic(optional = false)
    @Column(name = "MaNV")
    @Nationalized
    private String maNV;

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

    @Column(name = "HinhAnh")
    @Nationalized
    private String hinhAnh;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nhanVien")
    private List<GiaGoiTapEntity> giaGoiTaps;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nhanVien")
    private List<KhuyenMaiEntity> khuyenMais;

    @JoinColumn(name = "MaTK", unique = true)
    @OneToOne
    @Basic(optional = false)
    private TaiKhoanEntity taiKhoan;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nhanVien")
    private List<HoaDonEntity> hoaDons;
}
