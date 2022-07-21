package com.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  03/07/2022
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TAIKHOAN")
public class TaiKhoanEntity{
    @Id
    @Basic(optional = false)
    @Column(name = "MaTK")
    private String maTK;

    @Basic(optional = false)
    @Column(name = "MatKhau")
    private String matKhau;

    @Basic(optional = false)
    @Column(name = "TrangThai")
    private String trangThai;

    @JoinColumn(name = "MaQuyen")
    @ManyToOne
    @Basic(optional = false)
    private PhanQuyenEntity phanQuyen;

    @JoinColumn(name = "MaNV", unique = true)
    @OneToOne
    @Basic(optional = false)
    private NhanVienEntity nhanVien;
}
