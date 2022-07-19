package com.api.dto;

import com.api.entity.NhanVienEntity;
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
public class NhanVienDTO {
    private String maNV;
    private String hoTen;
    private String email;
    private String sdt;
    private String phai;
    private String diaChi;
    private String hinhAnh;
    private List<GiaGoiTapDTO> giaGoiTaps;
    private List<KhuyenMaiDTO> khuyenMais;
    private List<HoaDonDTO> hoaDons;

    public NhanVienDTO(NhanVienEntity nhanVien) {
        this.maNV = nhanVien.getMaNV();
        this.hoTen = nhanVien.getHoTen();
        this.email = nhanVien.getEmail();
        this.sdt = nhanVien.getSdt();
        this.phai = nhanVien.getPhai();
        this.diaChi = nhanVien.getDiaChi();
        this.hinhAnh = nhanVien.getHinhAnh();
        this.giaGoiTaps = nhanVien.getGiaGoiTaps().stream().map(GiaGoiTapDTO::new).collect(Collectors.toList());
    }

    public NhanVienEntity toEntity(){
        NhanVienEntity nhanVien = new NhanVienEntity();
        nhanVien.setMaNV(this.maNV);
        nhanVien.setHoTen(this.hoTen);
        nhanVien.setEmail(this.email);
        nhanVien.setSdt(this.sdt);
        nhanVien.setPhai(this.phai);
        nhanVien.setDiaChi(this.diaChi);
        nhanVien.setHinhAnh(this.hinhAnh);
        return nhanVien;
    }
}
