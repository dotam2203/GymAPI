package com.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

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
    @Column(name = "MaTK", length = 20)
    private String maTK;

    @Basic(optional = false)
    @Column(name = "MatKhau", length = 50)
    private String matKhau;

    @Basic(optional = false)
    @Column(name = "TrangThai", length = 50)
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
