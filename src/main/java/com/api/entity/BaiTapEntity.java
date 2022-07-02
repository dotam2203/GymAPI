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
@Table(name = "BAITAP")
public class BaiTapEntity {
    @Id
    @Basic(optional = false)
    @Column(name = "MaBT")
    @Nationalized
    private String maBT;

    @Basic(optional = false)
    @Column(name = "TenBT")
    @Nationalized
    private String tenBT;

    @Basic(optional = false)
    @Column(name = "MoTa")
    @Nationalized
    private String moTa;

    @Column(name = "DuongDan")
    @Nationalized
    private String duongDan;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "baiTap")
    private List<CtBaiTapEntity> ctBaiTapList;
}
