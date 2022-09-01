package com.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
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
@Table(name = "HOADON")
public class HoaDonEntity {
    @Id
    @Basic(optional = false)
    @Column(name = "MaHD", length = 20)
    @Nationalized
    private String maHD;

    @Basic(optional = false)
    @Column(name = "NgayLap")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date ngayLap;

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "hoaDon")
    private List<CtTheTapEntity> ctTheTaps;

    @JoinColumn(name = "MaNV")
    @ManyToOne
    @Basic(optional = false)
    private NhanVienEntity nhanVien;

    @JoinColumn(name = "MaThe")
    @ManyToOne
    @Basic(optional = false)
    private TheTapEntity theTap;
}
