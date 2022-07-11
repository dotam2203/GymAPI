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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDLoaiKH")
    private Integer idLoaiKH;

    @Basic(optional = false)
    @Column(name = "TenLoaiKH")
    private String tenLoaiKH;

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "loaiKH")
    private List<KhachHangEntity> khachHangs;
}
