package com.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import javax.validation.constraints.Size;
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
    @Column(name = "MaGT", length = 10)
    private String maGT;

    @Basic(optional = false)
    @Column(name = "TenGT", length = 50)
    @Nationalized
    private String tenGT;

    @Column(name = "MoTa")
    @Nationalized
    private String moTa;

    @Basic(optional = false)
    @Column(name = "TrangThai", length = 50)
    @Nationalized
    private String trangThai;

    @JoinColumn(name = "IdLoaiGT")
    @ManyToOne
    @Basic(optional = false)
    private LoaiGoiTapEntity loaiGT;

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "goiTap")
    private List<GiaGoiTapEntity> giaGoiTaps;

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "goiTap")
    private List<CtTheTapEntity> ctTheTaps;

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "goiTap")
    private List<CtKhuyenMaiEntity> ctKhuyenMais;

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "goiTap")
    private List<CtBaiTapEntity> ctBaiTaps;
}
