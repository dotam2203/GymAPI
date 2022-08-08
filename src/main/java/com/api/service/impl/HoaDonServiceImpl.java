package com.api.service.impl;

import com.api.dto.HoaDonDTO;
import com.api.entity.HoaDonEntity;
import com.api.entity.KhachHangEntity;
import com.api.entity.NhanVienEntity;
import com.api.entity.TheTapEntity;
import com.api.repository.HoaDonRepository;
import com.api.repository.KhachHangRepository;
import com.api.repository.NhanVienRepository;
import com.api.repository.TheTapRepository;
import com.api.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HoaDonServiceImpl implements HoaDonService {
    @Autowired
    HoaDonRepository hoaDonRepository;
    @Autowired
    NhanVienRepository nhanVienRepository;
    @Autowired
    TheTapRepository theTapRepository;

    @Override
    public List<HoaDonDTO> layDSHoaDon() {
        List<HoaDonEntity> dsHoaDon = hoaDonRepository.findAll();
        return dsHoaDon.stream().map(HoaDonDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<HoaDonDTO> layDSHoaDonTheoNV(String maNV) {
        List<HoaDonEntity> dsHoaDonTheoNV = hoaDonRepository.findByNhanVien_MaNV(maNV);
        return dsHoaDonTheoNV.stream().map(HoaDonDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<HoaDonDTO> layDSHoaDonTheoTheTap(String maThe) {
        List<HoaDonEntity> dsHoaDonTheoTheTap = hoaDonRepository.findByTheTap_MaThe(maThe);
        return dsHoaDonTheoTheTap.stream().map(HoaDonDTO::new).collect(Collectors.toList());
    }

    @Override
    public HoaDonDTO layHoaDon(String maHD) {
        HoaDonEntity hoaDon = hoaDonRepository.getById(maHD);
        return new HoaDonDTO(hoaDon);
    }

    @Override
    public HoaDonDTO themHoaDon(HoaDonDTO hoaDonDTO) {
        NhanVienEntity nhanVien = nhanVienRepository.getById(hoaDonDTO.getMaNV());
        TheTapEntity theTap = theTapRepository.getById(hoaDonDTO.getMaThe());
        HoaDonEntity hoaDon = hoaDonDTO.toEntity();
        hoaDon.setNhanVien(nhanVien);
        hoaDon.setTheTap(theTap);
        return new HoaDonDTO(hoaDonRepository.save(hoaDon));
    }

    @Override
    public HoaDonDTO suaHoaDon(HoaDonDTO hoaDonDTO) {
        TheTapEntity theTap = theTapRepository.getById(hoaDonDTO.getMaThe());
        NhanVienEntity nhanVien = nhanVienRepository.getById(hoaDonDTO.getMaNV());
        HoaDonEntity hoaDon = hoaDonRepository.getById(hoaDonDTO.getMaHD());
        hoaDon.setNgayLap(hoaDonDTO.getNgayLap());
        hoaDon.setTheTap(theTap);
        hoaDon.setNhanVien(nhanVien);
        HoaDonEntity save = hoaDonRepository.save(hoaDon);
        return new HoaDonDTO(save);
    }

    @Override
    public void xoaHoaDon(String maHD) {
        hoaDonRepository.deleteById(maHD);
    }
}
