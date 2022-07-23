package com.api.dto;

import com.api.entity.GiaGoiTapEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  03/07/2022
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GiaGoiTapDTO {
    private Integer idGia;
    private Date ngayApDung;
    private String gia;
    private String maGT;
    private String maNV;

    public GiaGoiTapDTO(GiaGoiTapEntity giaGoiTap) {
        this.idGia = giaGoiTap.getIdGia();
        this.ngayApDung = giaGoiTap.getNgayApDung();
        this.gia = giaGoiTap.getGia();
        this.maGT = giaGoiTap.getGoiTap().getMaGT();
        this.maNV = giaGoiTap.getNhanVien().getMaNV();
    }

    public GiaGoiTapEntity toEntity(){
        GiaGoiTapEntity giaGoiTap = new GiaGoiTapEntity();
        giaGoiTap.setIdGia(this.idGia);
        giaGoiTap.setNgayApDung(this.ngayApDung);
        giaGoiTap.setGia(this.gia);
        return giaGoiTap;
    }
}
