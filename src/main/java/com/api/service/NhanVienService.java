package com.api.service;

import com.api.dto.NhanVienDTO;

import java.util.List;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  19/07/2022
 */
public interface NhanVienService {
    List<NhanVienDTO> layDSNhanVien();
    NhanVienDTO layNhanVien(String maNV);
    NhanVienDTO themNhanVien(NhanVienDTO nhanVienDTO);
    NhanVienDTO suaNhanVien(NhanVienDTO nhanVienDTO);
    void xoaNhanVien(String maNV);
}
