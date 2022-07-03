package com.api.dto;

import com.api.entity.CtKhuyenMaiEntity;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  03/07/2022
 */
public class CtKhuyenMaiDTO {
    private Integer idCTKM;
    private Float phanTramGiam;
    private String maKM;
    private String maGoiTap;

    public CtKhuyenMaiDTO(CtKhuyenMaiEntity ctKhuyenMai) {
        this.idCTKM = ctKhuyenMai.getIdCTKM();
        this.phanTramGiam = ctKhuyenMai.getPhanTramGiam();
        this.maKM = ctKhuyenMai.getKhuyenMai().getMaKM();
        this.maGoiTap = ctKhuyenMai.getGoiTap().getMaGoiTap();
    }

    public CtKhuyenMaiEntity toEntity(){
        CtKhuyenMaiEntity ctKhuyenMai = new CtKhuyenMaiEntity();
        ctKhuyenMai.setIdCTKM(this.idCTKM);
        ctKhuyenMai.setPhanTramGiam(this.phanTramGiam);
        return ctKhuyenMai;
    }
}
