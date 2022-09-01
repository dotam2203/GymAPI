package com.api.dto;

import com.api.entity.TheTapEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TheTapDTO {
    private String maThe;
    private Date ngayDK;
    private Date ngayBD;
    private Date ngayKT;
    private String trangThai;
    private String maKH;
    private List<HoaDonDTO> hoaDons;

    public TheTapDTO(TheTapEntity theTap) {
        this.maThe = theTap.getMaThe();
        this.ngayDK = theTap.getNgayDK();
        this.ngayBD = theTap.getNgayBD();
        this.ngayKT = theTap.getNgayKT();
        this.trangThai = theTap.getTrangThai();
        this.maKH = theTap.getKhachHang().getMaKH();
        if(theTap.getHoaDons() != null)
            this.hoaDons = theTap.getHoaDons().stream().map(HoaDonDTO::new).collect(Collectors.toList());
    }

    public TheTapEntity toEntity(){
        TheTapEntity theTap = new TheTapEntity();
        theTap.setMaThe(this.maThe);
        theTap.setNgayDK(this.ngayDK);
        theTap.setNgayBD(this.ngayBD);
        theTap.setNgayKT(this.ngayKT);
        theTap.setTrangThai(this.trangThai);
        return theTap;
    }
}
