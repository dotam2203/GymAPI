package com.api.dto;

import com.api.entity.BaiTapEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  03/07/2022
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaiTapDTO {
    private Integer idBT;
    private String tenBT;
    private String moTa;
    private String duongDan;
    private List<CtBaiTapDTO> ctBaiTaps;

    public BaiTapDTO(BaiTapEntity baiTap) {
        this.idBT = baiTap.getIdBT();
        this.tenBT = baiTap.getTenBT();
        this.moTa = baiTap.getMoTa();
        this.duongDan = baiTap.getDuongDan();
        if(baiTap.getCtBaiTaps() != null)
            this.ctBaiTaps = baiTap.getCtBaiTaps().stream().map(CtBaiTapDTO::new).collect(Collectors.toList());
    }

    public BaiTapEntity toEntity(){
        BaiTapEntity baiTap = new BaiTapEntity();
        baiTap.setIdBT(this.idBT);
        baiTap.setTenBT(this.tenBT);
        baiTap.setMoTa(this.moTa);
        baiTap.setDuongDan(this.duongDan);
        return baiTap;
    }

}
