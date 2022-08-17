package com.api.service;

import com.api.dto.HoaDonDTO;

import java.util.List;

public interface HoaDonService {
    List<HoaDonDTO> layDSHoaDon();
    List<HoaDonDTO> layDSHoaDonTheoNV(String maNV);
    List<HoaDonDTO> layDSHoaDonTheoTheTap(String maThe);
    List<HoaDonDTO> layDSHoaDonTheoNgayGiam();
    HoaDonDTO layHoaDon(String maHD);
    HoaDonDTO themHoaDon(HoaDonDTO hoaDonDTO);
    HoaDonDTO suaHoaDon(HoaDonDTO hoaDonDTO);
    void xoaHoaDon(String maHD);
}
