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
    private Integer idLoaiKH;
    private String tenLoaiKH;
    private List<KhachHangDTO> khachHangs;

    public LoaiKhachHangDTO(LoaiKhachHangEntity loaiKH) {
        this.idLoaiKH = loaiKH.getIdLoaiKH();
        this.tenLoaiKH = loaiKH.getTenLoaiKH();
        if(loaiKH.getKhachHangs() != null)
            this.khachHangs = loaiKH.getKhachHangs().stream().map(KhachHangDTO::new).collect(Collectors.toList());
    }

    public LoaiKhachHangEntity toEntity(){
        LoaiKhachHangEntity loaiKH = new LoaiKhachHangEntity();
        loaiKH.setIdLoaiKH(this.idLoaiKH);
        loaiKH.setTenLoaiKH(this.tenLoaiKH);
        return loaiKH;
    }
}
