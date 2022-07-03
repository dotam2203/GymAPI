package com.api.dto;

import com.api.entity.LoaiKhachHangEntity;
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
public class LoaiKhachHangDTO {
    private String maLoaiKH;
    private String tenLoaiKH;
    private List<KhachHangDTO> khachHangs;

    public LoaiKhachHangDTO(LoaiKhachHangEntity loaiKH) {
        this.maLoaiKH = loaiKH.getMaLoaiKH();
        this.tenLoaiKH = loaiKH.getTenLoaiKH();
        this.khachHangs = loaiKH.getKhachHangs().stream().map(KhachHangDTO::new).collect(Collectors.toList());
    }

    public LoaiKhachHangEntity toEntity(){
        LoaiKhachHangEntity loaiKH = new LoaiKhachHangEntity();
        loaiKH.setMaLoaiKH(this.maLoaiKH);
        loaiKH.setTenLoaiKH(this.tenLoaiKH);
        return loaiKH;
    }
}
