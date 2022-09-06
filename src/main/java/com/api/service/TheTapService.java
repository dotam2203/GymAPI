package com.api.service;

import com.api.dto.TheTapDTO;

import java.util.List;

public interface TheTapService {
    List<TheTapDTO> layDSTheTap();
    List<TheTapDTO> layDSTheTapTheoKH(String maKH);
    List<TheTapDTO> layDSTheTapTheoNgayBD();
    TheTapDTO layTheTap(String maThe);
    TheTapDTO themTheTap(TheTapDTO theTapDTO);
    TheTapDTO suaTheTap(TheTapDTO theTapDTO);
    void xoaTheTap(String maThe);
}
