package com.api.dto;

import com.api.entity.KhuyenMaiEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
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
public class KhuyenMaiDTO {
    private Integer idKM;
    private String moTa;
    private Date ngayBD;
    private Date ngayKT;
    private String nhanVien;
    private List<CtKhuyenMaiDTO> ctKhuyenMais;

    public KhuyenMaiDTO(KhuyenMaiEntity khuyenMai) {
        this.idKM = khuyenMai.getIdKM();
        this.moTa = khuyenMai.getMoTa();
        this.ngayBD = khuyenMai.getNgayBD();
        this.ngayKT = khuyenMai.getNgayKT();
        this.nhanVien = khuyenMai.getNhanVien().getMaNV();
        this.ctKhuyenMais = khuyenMai.getCtKhuyenMais().stream().map(CtKhuyenMaiDTO::new).collect(Collectors.toList());
    }

    public KhuyenMaiEntity toEntity(){
        KhuyenMaiEntity khuyenMai = new KhuyenMaiEntity();
        khuyenMai.setIdKM(this.idKM);
        khuyenMai.setMoTa(this.moTa);
        khuyenMai.setNgayBD(this.ngayBD);
        khuyenMai.setNgayKT(this.ngayKT);
        return khuyenMai;
    }
}
