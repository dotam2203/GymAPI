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
@Table(name = "BAITAP")
public class BaiTapEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDBT")
    private Integer idBT;

    @Basic(optional = false)
    @Column(name = "TenBT", length = 50)
    @Nationalized
    private String tenBT;

    @Column(name = "MoTa")
    @Nationalized
    private String moTa;

    @Column(name = "DuongDan")
    @Nationalized
    private String duongDan;

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "baiTap")
    private List<CtBaiTapEntity> ctBaiTaps;
}
