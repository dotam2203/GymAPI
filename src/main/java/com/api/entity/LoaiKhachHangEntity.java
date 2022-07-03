package com.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@Table(name = "LOAIKHACHHANG")
public class LoaiKhachHangEntity {
    @Id
    @Basic(optional = false)
    @Column(name = "MaLoaiKH")
    private String maLoaiKH;

    @Basic(optional = false)
    @Column(name = "TenLoaiKH")
    private String tenLoaiKH;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loaiKH")
    private List<KhachHangEntity> khachHangs;
}
