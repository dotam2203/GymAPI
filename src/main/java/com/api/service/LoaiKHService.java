package com.api.service;

import com.api.dto.LoaiKhachHangDTO;

import java.util.List;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  04/07/2022
 */
public interface LoaiKHService {
    List<LoaiKhachHangDTO> layDSLoaiKH();
    LoaiKhachHangDTO layLoaiKH(Integer idLoaiKH);
    LoaiKhachHangDTO themLoaiKH(LoaiKhachHangDTO loaiKhachHangDTO);
    LoaiKhachHangDTO suaLoaiKH(LoaiKhachHangDTO loaiKhachHangDTO);
    void xoaLoaiKH(Integer idLoaiKH);
}
