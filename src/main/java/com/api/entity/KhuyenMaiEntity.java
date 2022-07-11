package com.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
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
@Table(name = "KHUYENMAI")
public class KhuyenMaiEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDKM")
    private Integer idKM;

    @Basic(optional = false)
    @Column(name = "MoTa")
    private String moTa;

    @Basic(optional = false)
    @Column(name = "NgayBD")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date ngayBD;

    @Basic(optional = false)
    @Column(name = "NgayKT")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date ngayKT;

    @JoinColumn(name = "MaNV")
    @ManyToOne
    @Basic(optional = false)
    private NhanVienEntity nhanVien;

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "khuyenMai")
    private List<CtKhuyenMaiEntity> ctKhuyenMais;
}
