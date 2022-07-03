package com.api.dto;

import com.api.entity.HoaDonEntity;
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
public class HoaDonDTO {
    private String maHD;
    private Date ngayLap;
    private List<CtTheTapDTO> ctTheTaps;
    private String maNV;
    private String maThe;

    public HoaDonDTO(HoaDonEntity hoaDon) {
        this.maHD = hoaDon.getMaHD();
        this.ngayLap = hoaDon.getNgayLap();
        this.ctTheTaps = hoaDon.getCtTheTaps().stream().map(CtTheTapDTO::new).collect(Collectors.toList());
        this.maNV = hoaDon.getNhanVien().getMaNV();
        this.maThe = hoaDon.getTheTap().getMaThe();
    }

    public HoaDonEntity toEntity(){
        HoaDonEntity hoaDon = new HoaDonEntity();
        hoaDon.setMaHD(this.maHD);
        hoaDon.setNgayLap(this.ngayLap);
        return hoaDon;
    }
}
