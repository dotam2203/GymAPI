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
@Table(name = "PHANQUYEN")
public class PhanQuyenEntity {
    @Id
    @Basic(optional = false)
    @Column(name = "MaQuyen")
    @Nationalized
    private String maQuyen;

    @Basic(optional = false)
    @Column(name = "TenQuyen")
    @Nationalized
    private String tenQuyen;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "phanQuyen")
    private List<TaiKhoanEntity> taiKhoanList;
}

