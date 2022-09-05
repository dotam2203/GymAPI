package com.api.service;

import com.api.dto.CtTheTapDTO;

import java.util.Date;
import java.util.List;

public interface CtTheTapService {
    List<CtTheTapDTO> layDSCtTheTap();
    List<CtTheTapDTO> locDSCtTheTapThang(Date ngayBD, Date ngayKT);
    List<CtTheTapDTO> locDSCtTheTapTheoDV(Date ngayBD, Date ngayKT);
    List<CtTheTapDTO> layDSCtTheTapTheoHD(String maHD);
    List<CtTheTapDTO> layDSCtTheTapTheoGT(String maGT);
    CtTheTapDTO layCtTheTapTheoThe(String maThe);
    CtTheTapDTO layCtTheTap(Integer Id);
    CtTheTapDTO themCtTheTap(CtTheTapDTO ctTheTapDTO);
    CtTheTapDTO suaCtTheTap(CtTheTapDTO ctTheTapDTO);
    void xoaCtTheTap(Integer idCTThe);
}
