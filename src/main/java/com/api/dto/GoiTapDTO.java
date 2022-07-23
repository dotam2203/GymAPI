package com.api.dto;

import com.api.entity.GoiTapEntity;
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
public class GoiTapDTO {
    private String maGoiTap;
    private String tenGoiTap;
    private String moTa;
    private String trangThai;
    private Integer idLoaiGT;
    private List<GiaGoiTapDTO> giaGoiTaps;
    private List<CtTheTapDTO> ctTheTaps;
    private List<CtKhuyenMaiDTO> ctKhuyenMais;
    private List<CtBaiTapDTO> ctBaiTaps;

    public GoiTapDTO(GoiTapEntity goiTap) {
        this.maGoiTap = goiTap.getMaGoiTap();
        this.tenGoiTap = goiTap.getTenGoiTap();
        this.moTa = goiTap.getMoTa();
        this.trangThai = goiTap.getTrangThai();
        this.idLoaiGT = goiTap.getLoaiGT().getIdLoaiGT();
        if(goiTap.getGiaGoiTaps() != null)
            this.giaGoiTaps = goiTap.getGiaGoiTaps().stream().map(GiaGoiTapDTO::new).collect(Collectors.toList());
        if(goiTap.getCtTheTaps() != null)
            this.ctTheTaps = goiTap.getCtTheTaps().stream().map(CtTheTapDTO::new).collect(Collectors.toList());
        if(goiTap.getCtKhuyenMais() != null)
            this.ctKhuyenMais = goiTap.getCtKhuyenMais().stream().map(CtKhuyenMaiDTO::new).collect(Collectors.toList());
        if(goiTap.getCtBaiTaps() != null)
            this.ctBaiTaps = goiTap.getCtBaiTaps().stream().map(CtBaiTapDTO::new).collect(Collectors.toList());
    }
    public GoiTapEntity toEntity(){
        GoiTapEntity goiTap = new GoiTapEntity();
        goiTap.setMaGoiTap(this.maGoiTap);
        goiTap.setTenGoiTap(this.tenGoiTap);
        goiTap.setMoTa(this.moTa);
        goiTap.setTrangThai(this.trangThai);
        return goiTap;
    }
}
