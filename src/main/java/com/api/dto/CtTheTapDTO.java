package com.api.dto;

import com.api.entity.CtTheTapEntity;
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
public class CtTheTapDTO {
    private Integer idCTThe;
    private String donGia;
    private String maGT;
    private String maHD;
    private String maThe;

    private String maKH;
    private String tenGT;
    private String tenLoaiGT;
    private Date ngayBD;
    private Date ngayKT;
    private String trangThai;

    public CtTheTapDTO(CtTheTapEntity ctTheTap) {
        this.idCTThe = ctTheTap.getIdCTThe();
        this.donGia = ctTheTap.getDonGia();
        this.maGT = ctTheTap.getGoiTap().getMaGT();
        this.maHD = ctTheTap.getHoaDon().getMaHD();
        this.maThe = ctTheTap.getTheTap().getMaThe();

        this.maKH = ctTheTap.getTheTap().getKhachHang().getMaKH();
        this.tenGT = ctTheTap.getGoiTap().getTenGT();
        this.tenLoaiGT = ctTheTap.getGoiTap().getLoaiGT().getTenLoaiGT();
        this.trangThai = ctTheTap.getTheTap().getTrangThai();
        this.ngayBD = ctTheTap.getTheTap().getNgayBD();
        this.ngayKT = ctTheTap.getTheTap().getNgayKT();
    }

    public CtTheTapEntity toEntity(){
        CtTheTapEntity ctTheTap = new CtTheTapEntity();
        ctTheTap.setIdCTThe(this.idCTThe);
        ctTheTap.setDonGia(this.donGia);
        return ctTheTap;
    }
}
