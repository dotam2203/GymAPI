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
    @Column(name = "MaThe")
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
    @Column(name = "TrangThai")
    @Nationalized
    private String trangThai;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "theTap")
    private List<CtTheTapEntity> ctTheTaps;

    @JoinColumn(name = "MaKH")
    @ManyToOne
    @Basic(optional = false)
    private KhachHangEntity khachHang;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "theTap")
    private List<HoaDonEntity> hoaDons;
}
