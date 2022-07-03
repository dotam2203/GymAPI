package com.api.dto;

import com.api.entity.KhachHangEntity;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  03/07/2022
 */
public class KhachHangDTO {
    private String maKH;
    private String hoTen;
    private String email;
    private String sdt;
    private String phai;
    private String diaChi;
    private String hinhAnh;
    private String maLoaiKH;
    private List<TheTapDTO> theTaps;

    public KhachHangDTO(KhachHangEntity khachHang) {
        this.maKH = khachHang.getMaKH();
        this.hoTen = khachHang.getHoTen();
        this.email = khachHang.getEmail();
        this.sdt = khachHang.getSdt();
        this.phai = khachHang.getPhai();
        this.diaChi = khachHang.getDiaChi();
        this.hinhAnh = khachHang.getHinhAnh();
        this.maLoaiKH = khachHang.getLoaiKH().getMaLoaiKH();
        this.theTaps = khachHang.getTheTaps().stream().map(TheTapDTO::new).collect(Collectors.toList());
    }

    public KhachHangEntity toEntity(){
        KhachHangEntity khachHang = new KhachHangEntity();
        khachHang.setMaKH(this.maKH);
        khachHang.setHoTen(this.hoTen);
        khachHang.setEmail(this.email);
        khachHang.setSdt(this.sdt);
        khachHang.setPhai(this.phai);
        khachHang.setDiaChi(this.diaChi);
        khachHang.setHinhAnh(this.hinhAnh);
        return khachHang;
    }
}