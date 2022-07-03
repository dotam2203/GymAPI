package com.api.dto;

import com.api.entity.TaiKhoanEntity;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  03/07/2022
 */
public class TaiKhoanDTO {
    private String maTK;
    private String matKhau;
    private String trangThai;
    private String maQuyen;
    private String maNV;

    public TaiKhoanDTO(TaiKhoanEntity taiKhoan) {
        this.maTK = taiKhoan.getMaTK();
        this.matKhau = taiKhoan.getMatKhau();
        this.trangThai = taiKhoan.getTrangThai();
        this.maQuyen = taiKhoan.getPhanQuyen().getMaQuyen();
        this.maNV = taiKhoan.getNhanVien().getMaNV();
    }

    public TaiKhoanEntity toEntity(){
        TaiKhoanEntity taiKhoan = new TaiKhoanEntity();
        taiKhoan.setMaTK(this.maTK);
        taiKhoan.setMatKhau(this.matKhau);
        taiKhoan.setTrangThai(this.trangThai);
        return taiKhoan;
    }
}
