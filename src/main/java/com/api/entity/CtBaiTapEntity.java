package com.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

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

    @JoinColumn(name = "IDBT")
    @ManyToOne
    @Basic(optional = false)
    private BaiTapEntity baiTap;

    @JoinColumn(name = "MaGT")
    @ManyToOne
    @Basic(optional = false)
    private GoiTapEntity goiTap;
}
