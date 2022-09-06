package com.api.service.impl;

import com.api.dto.TheTapDTO;
import com.api.entity.KhachHangEntity;
import com.api.entity.TheTapEntity;
import com.api.repository.KhachHangRepository;
import com.api.repository.TheTapRepository;
import com.api.service.TheTapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class TheTapServiceImpl implements TheTapService {
    @Autowired
    TheTapRepository theTapRepository;
    @Autowired
    KhachHangRepository khachHangRepository;
    @Override
    public List<TheTapDTO> layDSTheTap() {
        List<TheTapEntity> dsTT = theTapRepository.findAll();
        return dsTT.stream().map(TheTapDTO::new).collect(Collectors.toList());
    }
    @Override
    public List<TheTapDTO> layDSTheTapTheoKH(String maKH) {
        List<TheTapEntity> dsTheTapTheoKH = theTapRepository.findByKhachHang_MaKH(maKH);
        return dsTheTapTheoKH.stream().map(TheTapDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<TheTapDTO> layDSTheTapTheoNgayBD() {
        List<TheTapEntity> dsTheTapTheoKH = theTapRepository.findAllByOrderByNgayBDDesc();
        return dsTheTapTheoKH.stream().map(TheTapDTO::new).collect(Collectors.toList());
    }

    @Override
    public TheTapDTO layTheTap(String maThe) {
        TheTapEntity theTap = theTapRepository.getById(maThe);
        return new TheTapDTO(theTap);
    }
    @Override
    public TheTapDTO themTheTap(TheTapDTO theTapDTO) {
        KhachHangEntity khachHang = khachHangRepository.getById(theTapDTO.getMaKH());
        TheTapEntity theTap = theTapDTO.toEntity();
        theTap.setKhachHang(khachHang);
        return new TheTapDTO(theTapRepository.save(theTap));
    }
    @Override
    public TheTapDTO suaTheTap(TheTapDTO theTapDTO) {
        KhachHangEntity khachHang = khachHangRepository.getById(theTapDTO.getMaKH());
        TheTapEntity theTap = theTapRepository.getById(theTapDTO.getMaThe());
        theTap.setMaThe(theTapDTO.getMaThe());
        theTap.setNgayDK(theTapDTO.getNgayDK());
        theTap.setNgayBD(theTapDTO.getNgayBD());
        theTap.setNgayKT(theTapDTO.getNgayKT());
        theTap.setTrangThai(theTapDTO.getTrangThai());
        theTap.setKhachHang(khachHang);
        return new TheTapDTO(theTapRepository.save(theTap));
    }
    @Override
    public void xoaTheTap(String maThe) {
        theTapRepository.deleteById(maThe);
    }
}
