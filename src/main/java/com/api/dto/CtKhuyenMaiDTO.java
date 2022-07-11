package com.api.dto;

import com.api.entity.CtKhuyenMaiEntity;
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
public class CtKhuyenMaiDTO {
    private Integer idCTKM;
    private Float phanTramGiam;
    private Integer idKM;
    private String maGoiTap;

    public CtKhuyenMaiDTO(CtKhuyenMaiEntity ctKhuyenMai) {
        this.idCTKM = ctKhuyenMai.getIdCTKM();
        this.phanTramGiam = ctKhuyenMai.getPhanTramGiam();
        this.idKM = ctKhuyenMai.getKhuyenMai().getIdKM();
        this.maGoiTap = ctKhuyenMai.getGoiTap().getMaGoiTap();
    }

    public CtKhuyenMaiEntity toEntity(){
        CtKhuyenMaiEntity ctKhuyenMai = new CtKhuyenMaiEntity();
        ctKhuyenMai.setIdCTKM(this.idCTKM);
        ctKhuyenMai.setPhanTramGiam(this.phanTramGiam);
        return ctKhuyenMai;
    }
}
