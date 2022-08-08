package com.api.service;

import com.api.dto.CtKhuyenMaiDTO;

import java.util.List;

public interface CtKhuyenMaiService {
    List<CtKhuyenMaiDTO> layDSCtKhuyenMai();
    List<CtKhuyenMaiDTO> layDSCtKhuyenMaiTheoGT(String maGT);
    List<CtKhuyenMaiDTO> layDSCtKhuyenMaiTheoKM(Integer idKM);
    CtKhuyenMaiDTO layCtKhuyenMai(Integer idCTKM);
    CtKhuyenMaiDTO themCtKhuyenMai(CtKhuyenMaiDTO ctKhuyenMaiDTO);
    CtKhuyenMaiDTO suaCtKhuyenMai(CtKhuyenMaiDTO ctKhuyenMaiDTO);
    void xoaCtKhuyenMai(Integer idCTKM);
}
