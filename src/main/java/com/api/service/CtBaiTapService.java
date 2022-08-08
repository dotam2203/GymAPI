package com.api.service;

import com.api.dto.CtBaiTapDTO;

import java.util.List;

public interface CtBaiTapService {
    List<CtBaiTapDTO> layDSCtBaiTap();
    List<CtBaiTapDTO> layDSCtBaiTapTheoGT(String maGT);
    List<CtBaiTapDTO> layDSCtBaiTapTheoBT(Integer idBT);
    CtBaiTapDTO layCtBaiTap(Integer idCTBT);
    CtBaiTapDTO themCtBaiTap(CtBaiTapDTO ctBaiTapDTO);
    CtBaiTapDTO suaCtBaiTap(CtBaiTapDTO ctBaiTapDTO);
    void xoaCtBaiTap(Integer idCTBT);
}
