package com.api.service;

import com.api.dto.LoaiGoitapDTO;

import java.util.List;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  03/07/2022
 */
public interface LoaiGoitapService {
    public List<LoaiGoitapDTO> layDSLoaiGoiTap();
    LoaiGoitapDTO themLoaiGoiTap(LoaiGoitapDTO loaiGoitapDTO);
    LoaiGoitapDTO suaLoaiGoiTap(LoaiGoitapDTO loaiGoitapDTO);
    void xoaLoaiGoiTap(String maLoaiGT);

}
