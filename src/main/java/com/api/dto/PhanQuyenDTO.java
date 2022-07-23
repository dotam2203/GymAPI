package com.api.dto;

import com.api.entity.PhanQuyenEntity;
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
public class PhanQuyenDTO {
    private String maQuyen;
    private String tenQuyen;
    private List<TaiKhoanDTO> taiKhoans;

    public PhanQuyenDTO(PhanQuyenEntity phanQuyen) {
        this.maQuyen = phanQuyen.getMaQuyen();
        this.tenQuyen = phanQuyen.getTenQuyen();
        if(phanQuyen.getTaiKhoans() != null)
            this.taiKhoans = phanQuyen.getTaiKhoans().stream().map(TaiKhoanDTO::new).collect(Collectors.toList());
    }

    public PhanQuyenEntity toEntity(){
        PhanQuyenEntity phanQuyen = new PhanQuyenEntity();
        phanQuyen.setMaQuyen(this.maQuyen);
        phanQuyen.setTenQuyen(this.tenQuyen);
        return phanQuyen;
    }
}
