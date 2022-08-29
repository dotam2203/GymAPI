package com.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import javax.validation.constraints.Size;
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
    @Column(name = "MaNV", length = 10)
    @Nationalized
    private String maNV;

    @Basic(optional = false)
    @Column(name = "HoTen", length = 50)
    @Nationalized
    private String hoTen;

    @Basic(optional = false)
    @Column(name = "Email", length = 50)
    @Nationalized
    private String email;

    @Basic(optional = false)
    @Column(name = "SDT", length = 15)
    @Nationalized
    private String sdt;

    @Basic(optional = false)
    @Column(name = "Phai", length = 10)
    @Nationalized
    private String phai;

    @Column(name = "DiaChi", length = 100)
    @Nationalized
    private String diaChi;

    @Column(name = "HinhAnh")
    @Nationalized
    private String hinhAnh;


    @OneToOne(cascade = CascadeType.REFRESH, mappedBy = "nhanVien")
    private TaiKhoanEntity taiKhoan;

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "nhanVien")
    private List<GiaGoiTapEntity> giaGoiTaps;

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "nhanVien")
    private List<KhuyenMaiEntity> khuyenMais;

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "nhanVien")
    private List<HoaDonEntity> hoaDons;
}
