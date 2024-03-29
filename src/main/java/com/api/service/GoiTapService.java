package com.api.service;

import com.api.dto.GoiTapDTO;

import java.util.List;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  04/07/2022
 */
public interface GoiTapService {
    List<GoiTapDTO> layDSGoiTap();
    List<GoiTapDTO> layDSGoiTapTheoLoaiGT(Integer idLoaiGT);
    GoiTapDTO layGoiTapTheoMaGTVaIDLoaiGT(String maGT,Integer idLoaiGT);
    GoiTapDTO layGoiTap(String maGT);
    GoiTapDTO themGoiTap(GoiTapDTO goiTapDTO);
    GoiTapDTO suaGoiTap(GoiTapDTO goiTapDTO);
    void xoaGoiTap(String maGT);
}
