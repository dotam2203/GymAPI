package com.api.dto;

import com.api.entity.CtBaiTapEntity;
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
public class CtBaiTapDTO {
    private Integer idCTBT;
    private Integer idBT;
    private String maGT;

    public CtBaiTapDTO(CtBaiTapEntity ctBaiTap) {
        this.idCTBT = ctBaiTap.getIdCTBT();
        this.idBT = ctBaiTap.getBaiTap().getIdBT();
        this.maGT = ctBaiTap.getGoiTap().getMaGT();
    }

    public CtBaiTapEntity toEntity(){
        CtBaiTapEntity ctBaiTap = new CtBaiTapEntity();
        ctBaiTap.setIdCTBT(this.idCTBT);
        return ctBaiTap;
    }
}
