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
@Table(name = "PHANQUYEN")
public class PhanQuyenEntity {
    @Id
    @Basic(optional = false)
    @Column(name = "MaQuyen", length = 10)
    @Nationalized
    private String maQuyen;

    @Basic(optional = false)
    @Column(name = "TenQuyen", length = 50)
    @Nationalized
    private String tenQuyen;

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "phanQuyen")
    private List<TaiKhoanEntity> taiKhoans;
}

