package com.api.dto;

import com.api.entity.LoaiGoiTapEntity;
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
public class LoaiGoiTapDTO {
    private String maLoaiGT;
    private String tenLoaiGT;
    private String trangThai;
    private List<GoiTapDTO> goiTaps;

    public LoaiGoiTapDTO(LoaiGoiTapEntity loaiGoiTap) {
        this.maLoaiGT = loaiGoiTap.getMaLoaiGT();
        this.tenLoaiGT = loaiGoiTap.getTenLoaiGT();
        this.trangThai = loaiGoiTap.getTrangThai();
        this.goiTaps = loaiGoiTap.getGoiTaps().stream().map(GoiTapDTO::new).collect(Collectors.toList());
    }

    public LoaiGoiTapEntity toEntity(){
        LoaiGoiTapEntity loaiGoiTap = new LoaiGoiTapEntity();
        loaiGoiTap.setMaLoaiGT(this.maLoaiGT);
        loaiGoiTap.setTenLoaiGT(this.tenLoaiGT);
        loaiGoiTap.setTrangThai(this.trangThai);
        return loaiGoiTap;
    }
}
