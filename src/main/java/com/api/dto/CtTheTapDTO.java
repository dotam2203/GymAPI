package com.api.dto;

import com.api.entity.CtTheTapEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String maGoiTap;
    private String maHoaDon;
    private String maThe;

    public CtTheTapDTO(CtTheTapEntity ctTheTap) {
        this.idCTThe = ctTheTap.getIdCTThe();
        this.donGia = ctTheTap.getDonGia();
        this.maGoiTap = ctTheTap.getGoiTap().getMaGoiTap();
        this.maHoaDon = ctTheTap.getHoaDon().getMaHD();
        this.maThe = ctTheTap.getTheTap().getMaThe();
    }

    public CtTheTapEntity toEntity(){
        CtTheTapEntity ctTheTap = new CtTheTapEntity();
        ctTheTap.setIdCTThe(this.idCTThe);
        ctTheTap.setDonGia(this.donGia);
        return ctTheTap;
    }
}
