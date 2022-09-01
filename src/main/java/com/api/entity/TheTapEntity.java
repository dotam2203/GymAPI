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
@Table(name = "THETAP")
public class TheTapEntity {
    @Id
    @Basic(optional = false)
    @Column(name = "MaThe", length = 10)
    @Nationalized
    private String maThe;

    @Basic(optional = false)
    @Column(name = "NgayDK")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date ngayDK;

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

    @Basic(optional = false)
    @Column(name = "TrangThai", length = 50)
    @Nationalized
    private String trangThai;

    @JoinColumn(name = "MaKH")
    @ManyToOne
    @Basic(optional = false)
    private KhachHangEntity khachHang;

    @OneToOne(cascade = CascadeType.REFRESH, mappedBy = "theTap")
    private CtTheTapEntity ctTheTap;

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "theTap")
    private List<HoaDonEntity> hoaDons;
}
