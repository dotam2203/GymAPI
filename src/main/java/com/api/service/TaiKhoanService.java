package com.api.service;

import com.api.dto.TaiKhoanDTO;

import java.util.List;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  19/07/2022
 */
public interface TaiKhoanService {
    List<TaiKhoanDTO> layDSTaiKhoan();
    List<TaiKhoanDTO> layDSTaiKhoanTheoQuyen(String maQuyen);
    TaiKhoanDTO layTaiKhoan(String maTK);
    TaiKhoanDTO themTaiKhoan(TaiKhoanDTO taiKhoanDTO);
    TaiKhoanDTO suaTaiKhoan(TaiKhoanDTO taiKhoanDTO);
    void xoaTaiKhoan(String maTK);
}
