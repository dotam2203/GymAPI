package com.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

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
@Table(name = "GOITAP")
public class GoiTapEntity {
    @Id
    @Basic(optional = false)
    @Column(name = "MaGoiTap")
    private String maGoiTap;

    @Basic(optional = false)
    @Column(name = "TenGoiTap")
    @Nationalized
    private String tenGoiTap;

    @Column(name = "MoTa")
    @Nationalized
    private String moTa;

    @Basic(optional = false)
    @Column(name = "TrangThai")
    @Nationalized
    private String trangThai;

    @JoinColumn(name = "MaLoaiGT")
    @ManyToOne
    private LoaiGoiTapEntity maLoaiGT;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "goiTap")
    private List<GiaGoiTapEntity> giaGoiTapList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "goiTap")
    private List<CtTheTapEntity> ctTheTapList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "goiTap")
    private List<CtKhuyenMaiEntity> ctKhuyenMaiList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "goiTap")
    private List<CtBaiTapEntity> ctBaiTapList;
}
