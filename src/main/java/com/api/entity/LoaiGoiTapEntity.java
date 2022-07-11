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
@Table(name = "LOAIGOITAP")
public class LoaiGoiTapEntity {
    @Id
    @Basic(optional = false)
    @Column(name = "IDLoaiGT")
    private Integer idLoaiGT;

    @Basic(optional = false)
    @Column(name = "TenLoaiGT")
    @Nationalized
    private String tenLoaiGT;

    @Basic(optional = false)
    @Column(name = "TrangThai")
    @Nationalized
    private String trangThai;

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "loaiGT")
    private List<GoiTapEntity> goiTaps;
}
