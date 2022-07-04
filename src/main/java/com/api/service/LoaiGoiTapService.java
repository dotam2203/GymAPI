package com.api.service;

import com.api.dto.LoaiGoiTapDTO;

import java.util.List;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  03/07/2022
 */
public interface LoaiGoiTapService {
    List<LoaiGoiTapDTO> layDSLoaiGoiTap();
    LoaiGoiTapDTO themLoaiGoiTap(LoaiGoiTapDTO loaiGoitapDTO);
    LoaiGoiTapDTO suaLoaiGoiTap(LoaiGoiTapDTO loaiGoitapDTO);
    void xoaLoaiGoiTap(String maLoaiGT);
}
