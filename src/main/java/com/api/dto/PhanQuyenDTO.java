package com.api.dto;

import com.api.entity.PhanQuyenEntity;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  03/07/2022
 */
public class PhanQuyenDTO {
    private String maQuyen;
    private String tenQuyen;
    private List<TaiKhoanDTO> taiKhoans;

    public PhanQuyenDTO(PhanQuyenEntity phanQuyen) {
        this.maQuyen = phanQuyen.getMaQuyen();
        this.tenQuyen = phanQuyen.getTenQuyen();
        this.taiKhoans = phanQuyen.getTaiKhoans().stream().map(TaiKhoanDTO::new).collect(Collectors.toList());
    }

    public PhanQuyenEntity toEntity(){
        PhanQuyenEntity phanQuyen = new PhanQuyenEntity();
        phanQuyen.setMaQuyen(this.maQuyen);
        phanQuyen.setTenQuyen(this.tenQuyen);
        return phanQuyen;
    }
}
