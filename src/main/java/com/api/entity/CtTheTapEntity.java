package com.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

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
@Table(name = "CT_THETAP")
public class CtTheTapEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdCTThe")
    private Integer idCTThe;

    @Basic(optional = false)
    @Column(name = "DonGia")
    @Nationalized
    private String donGia;

    @JoinColumn(name = "MaGoiTap")
    @ManyToOne
    private GoiTapEntity goiTap;

    @JoinColumn(name = "MaHD")
    @ManyToOne
    private HoaDonEntity hoaDon;

    @JoinColumn(name = "MaThe")
    @ManyToOne
    private TheTapEntity theTap;
}
