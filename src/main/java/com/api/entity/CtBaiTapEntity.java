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
@Table(name = "CT_BAITAP")
public class CtBaiTapEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdCTBT")
    private Integer idCTBT;

    @JoinColumn(name = "MaBaiTap")
    @ManyToOne
    @Basic(optional = false)
    private BaiTapEntity baiTap;

    @JoinColumn(name = "MaGoiTap")
    @ManyToOne
    @Basic(optional = false)
    private GoiTapEntity goiTap;
}
