package com.api.service;

import com.api.dto.KhachHangDTO;

import java.util.List;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  04/07/2022
 */
public interface KhachHangService {
    List<KhachHangDTO> layDSKhachHang();
    List<KhachHangDTO> layDSKhachHangTheoLoaiKH(String maLoaiKH);
    KhachHangDTO layKhachHang(String maKH);
    KhachHangDTO themKhachHang(KhachHangDTO khachHangDTO);
    KhachHangDTO suaKhachHang(KhachHangDTO khachHangDTO);
    void xoaKhachHang(String maKH);
}
