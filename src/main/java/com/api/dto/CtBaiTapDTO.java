package com.api.dto;

import com.api.entity.CtBaiTapEntity;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  03/07/2022
 */
public class CtBaiTapDTO {
    private Integer idCTBT;
    private String maBaiTap;
    private String maGoiTap;

    public CtBaiTapDTO(CtBaiTapEntity ctBaiTap) {
        this.idCTBT = ctBaiTap.getIdCTBT();
        this.maBaiTap = ctBaiTap.getBaiTap().getMaBT();
        this.maGoiTap = ctBaiTap.getGoiTap().getMaGoiTap();
    }

    public CtBaiTapEntity toEntity(){
        CtBaiTapEntity ctBaiTap = new CtBaiTapEntity();
        ctBaiTap.setIdCTBT(this.idCTBT);
        return ctBaiTap;
    }
}
