package com.api.service;

import com.api.dto.KhuyenMaiDTO;

import java.util.List;

public interface KhuyenMaiService {
    List<KhuyenMaiDTO> layDSKhuyenMai();
    List<KhuyenMaiDTO> layDSKhuyenMaiTheoNV(String maNV);
    KhuyenMaiDTO layKhuyenMai(Integer idKM);
    KhuyenMaiDTO themKhuyenMai(KhuyenMaiDTO khuyenMaiDTO);
    KhuyenMaiDTO suaKhuyenMai(KhuyenMaiDTO khuyenMaiDTO);
    void xoaKhuyenMai(Integer idKM);
}
