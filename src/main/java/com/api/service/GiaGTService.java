package com.api.service;

import com.api.dto.GiaGoiTapDTO;

import java.util.List;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  21/07/2022
 */
public interface GiaGTService {
    List<GiaGoiTapDTO> layDSGia();
    List<GiaGoiTapDTO> layDSGiaTheoNhanVien(String maNV);
    List<GiaGoiTapDTO> layDSGiaTheoGoiTap(String maGT);
    List<GiaGoiTapDTO> layDSGiaTheoGoiTap_NhanVien(String maGT, String maNV);
    GiaGoiTapDTO layGia(Integer idGia);
    GiaGoiTapDTO themGia(GiaGoiTapDTO giaGoiTapDTO);
    GiaGoiTapDTO suaGia(GiaGoiTapDTO giaGoiTapDTO);
    void xoaGia(Integer idGia);
}
