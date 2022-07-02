package com.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  03/07/2022
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "GIAGOITAP")
public class GiaGoiTapEntity {
    @Id
    @Column(name = "IDGiaGT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGia;

    @Column(name = "NgayApDung")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date ngayApDung;

    @Column(name = "Gia")
    @Nationalized
    private String gia;

    @JoinColumn(name = "MaGoiTap")
    @ManyToOne
    private GoiTapEntity goiTap;

    @JoinColumn(name = "MaNV")
    @ManyToOne
    private NhanVienEntity nhanVien;
}
