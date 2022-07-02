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
@Table(name = "CT_KHUYENMAI")
public class CtKhuyenMaiEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdCTKM")
    private Integer idCTKM;

    @Basic(optional = false)
    @Column(name = "PhanTramGiamGia")
    private Integer phanTramGiam;

    @JoinColumn(name = "MaKM")
    @ManyToOne
    private KhuyenMaiEntity khuyenMai;

    @JoinColumn(name = "MaGoiTap")
    @ManyToOne
    private GoiTapEntity goiTap;

}
