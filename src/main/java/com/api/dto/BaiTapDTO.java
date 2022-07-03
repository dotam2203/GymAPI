package com.api.dto;

import com.api.entity.BaiTapEntity;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  03/07/2022
 */
public class BaiTapDTO {
    private String maBT;
    private String tenBT;
    private String moTa;
    private String duongDan;
    private List<CtBaiTapDTO> ctBaiTaps;

    public BaiTapDTO(BaiTapEntity baiTap) {
        this.maBT = baiTap.getMaBT();
        this.tenBT = baiTap.getTenBT();
        this.moTa = baiTap.getMoTa();
        this.duongDan = baiTap.getDuongDan();
        this.ctBaiTaps = baiTap.getCtBaiTaps().stream().map(CtBaiTapDTO::new).collect(Collectors.toList());
    }

    public BaiTapEntity toEntity(){
        BaiTapEntity baiTap = new BaiTapEntity();
        baiTap.setMaBT(this.maBT);
        baiTap.setTenBT(this.tenBT);
        baiTap.setMoTa(this.moTa);
        baiTap.setDuongDan(this.duongDan);
        return baiTap;
    }

}
