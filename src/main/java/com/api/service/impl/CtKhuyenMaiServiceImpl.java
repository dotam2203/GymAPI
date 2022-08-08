package com.api.service.impl;

import com.api.dto.CtKhuyenMaiDTO;
import com.api.dto.TaiKhoanDTO;
import com.api.entity.*;
import com.api.repository.CtKhuyenMaiRepository;
import com.api.repository.GoiTapRepository;
import com.api.repository.KhuyenMaiRepository;
import com.api.service.CtKhuyenMaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CtKhuyenMaiServiceImpl implements CtKhuyenMaiService {
    @Autowired
    CtKhuyenMaiRepository ctKhuyenMaiRepository;
    @Autowired
    GoiTapRepository goiTapRepository;
    @Autowired
    KhuyenMaiRepository khuyenMaiRepository;
    @Override
    public List<CtKhuyenMaiDTO> layDSCtKhuyenMai() {
        List<CtKhuyenMaiEntity> dsCtKhuyenMai = ctKhuyenMaiRepository.findAll();
        return dsCtKhuyenMai.stream().map(CtKhuyenMaiDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<CtKhuyenMaiDTO> layDSCtKhuyenMaiTheoGT(String maGT) {
        List<CtKhuyenMaiEntity> dsCtKhuyenMaiTheoGT = ctKhuyenMaiRepository.findByGoiTap_MaGT(maGT);
        return dsCtKhuyenMaiTheoGT.stream().map(CtKhuyenMaiDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<CtKhuyenMaiDTO> layDSCtKhuyenMaiTheoKM(Integer idKM) {
        List<CtKhuyenMaiEntity> dsCtKhuyenMaiTheoGT = ctKhuyenMaiRepository.findByKhuyenMai_IdKM(idKM);
        return dsCtKhuyenMaiTheoGT.stream().map(CtKhuyenMaiDTO::new).collect(Collectors.toList());
    }

    @Override
    public CtKhuyenMaiDTO layCtKhuyenMai(Integer idCTKM) {
        CtKhuyenMaiEntity ctKhuyenMai = ctKhuyenMaiRepository.getById(idCTKM);
        return new CtKhuyenMaiDTO(ctKhuyenMai);
    }

    @Override
    public CtKhuyenMaiDTO themCtKhuyenMai(CtKhuyenMaiDTO ctKhuyenMaiDTO) {
        GoiTapEntity goiTap = goiTapRepository.getById(ctKhuyenMaiDTO.getMaGT());
        KhuyenMaiEntity khuyenMai = khuyenMaiRepository.getById(ctKhuyenMaiDTO.getIdKM());
        CtKhuyenMaiEntity ctKhuyenMai = ctKhuyenMaiDTO.toEntity();
        ctKhuyenMai.setGoiTap(goiTap);
        ctKhuyenMai.setKhuyenMai(khuyenMai);
        return new CtKhuyenMaiDTO(ctKhuyenMaiRepository.save(ctKhuyenMai));
    }

    @Override
    public CtKhuyenMaiDTO suaCtKhuyenMai(CtKhuyenMaiDTO ctKhuyenMaiDTO) {
        GoiTapEntity goiTap = goiTapRepository.getById(ctKhuyenMaiDTO.getMaGT());
        KhuyenMaiEntity khuyenMai = khuyenMaiRepository.getById(ctKhuyenMaiDTO.getIdKM());
        CtKhuyenMaiEntity ctKhuyenMai = ctKhuyenMaiRepository.getById(ctKhuyenMaiDTO.getIdCTKM());
        ctKhuyenMai.setPhanTramGiam(ctKhuyenMaiDTO.getPhanTramGiam());
        ctKhuyenMai.setGoiTap(goiTap);
        ctKhuyenMai.setKhuyenMai(khuyenMai);
        CtKhuyenMaiEntity save = ctKhuyenMaiRepository.save(ctKhuyenMai);
        return new CtKhuyenMaiDTO(save);
    }

    @Override
    public void xoaCtKhuyenMai(Integer idCTKM) {
        ctKhuyenMaiRepository.deleteById(idCTKM);
    }
}
