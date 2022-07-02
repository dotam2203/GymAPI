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
    @Basic(optional = false)
    @Column(name = "MaKM")
    @Nationalized
    private String maKM;

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
    private NhanVienEntity nhanVien;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "khuyenMai")
    private List<CtKhuyenMaiEntity> ctKhuyenMaiList;
}
