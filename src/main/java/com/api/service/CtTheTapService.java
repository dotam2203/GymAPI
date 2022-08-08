package com.api.service;

import com.api.dto.CtTheTapDTO;

import java.util.List;

public interface CtTheTapService {
    List<CtTheTapDTO> layDSCtTheTap();
    List<CtTheTapDTO> layDSCtTheTapTheoHD(String maHD);
    List<CtTheTapDTO> layDSCtTheTapTheoGT(String maGT);
    List<CtTheTapDTO> layDSCtTheTapTheoThe(String maThe);
    CtTheTapDTO layCtTheTap(Integer Id);
    CtTheTapDTO themCtTheTap(CtTheTapDTO ctTheTapDTO);
    CtTheTapDTO suaCtTheTap(CtTheTapDTO ctTheTapDTO);
    void xoaCtTheTap(Integer Id);
}
