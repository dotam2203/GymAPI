package com.api.service;

import com.api.dto.TaiKhoanDTO;
import com.api.entity.TaiKhoanEntity;

import java.util.List;

public interface TaiKhoanService {
    List<TaiKhoanDTO> layDSTaiKhoan();

    List<TaiKhoanDTO> layDSTaiKhoanTheoQuyen(String maQuyen);

    TaiKhoanEntity layTaiKhoanTheoNV(String maNV);

    TaiKhoanDTO layTaiKhoan(String maTK);

    TaiKhoanDTO themTaiKhoan(TaiKhoanDTO taiKhoanDTO);

    TaiKhoanDTO suaTaiKhoan(TaiKhoanDTO taiKhoanDTO);

    void xoaTaiKhoan(String maTK);
}
