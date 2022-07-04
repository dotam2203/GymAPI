package com.api.service.impl;

import com.api.dto.GoiTapDTO;
import com.api.entity.GoiTapEntity;
import com.api.entity.LoaiGoiTapEntity;
import com.api.repository.GoiTapRepository;
import com.api.repository.LoaiGoiTapRepository;
import com.api.service.GoiTapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  04/07/2022
 */
@Service
public class GoiTapServiceImpl implements GoiTapService {
    @Autowired
    GoiTapRepository goiTapRepository;
    @Autowired
    LoaiGoiTapRepository loaiGTRepository;

    @Override
    public List<GoiTapDTO> layDSGoiTap() {
        List<GoiTapEntity> dsGoiTap = goiTapRepository.findAll();
        return dsGoiTap.stream().map(GoiTapDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<GoiTapDTO> layDSGoiTapTheoLoaiGT(String maLoaiGT) {
        List<GoiTapEntity> dsGoiTapTheoLoaiGT = goiTapRepository.findByLoaiGT_MaLoaiGT(maLoaiGT);
        return dsGoiTapTheoLoaiGT.stream().map(GoiTapDTO::new).collect(Collectors.toList());
    }

    @Override
    public GoiTapDTO layGoiTap(String maGoiTap) {
        GoiTapEntity goiTap = goiTapRepository.findById(maGoiTap).orElseThrow(() -> new RuntimeException("Gói tập " + maGoiTap + " không tồn tại!"));
        return new GoiTapDTO(goiTap);
    }

    @Override
    public GoiTapDTO themGoiTap(GoiTapDTO goiTapDTO) {
        LoaiGoiTapEntity loaiGT = loaiGTRepository.getById(goiTapDTO.getMaLoaiGT());
        GoiTapEntity goiTap = goiTapDTO.toEntity();
        goiTap.setLoaiGT(loaiGT);
        return new GoiTapDTO(goiTapRepository.save(goiTap));
    }

    @Override
    public GoiTapDTO suaGoiTap(GoiTapDTO goiTapDTO) {
        LoaiGoiTapEntity loaiGT = loaiGTRepository.getById(goiTapDTO.getMaLoaiGT());
        GoiTapEntity goiTap = goiTapRepository.findById(goiTapDTO.getMaGoiTap()).orElseThrow(() -> new RuntimeException("Gói tập " + goiTapDTO.getMaGoiTap() + " không tồn tại!"));
        goiTap.setMaGoiTap(goiTap.getMaGoiTap());
        goiTap.setTenGoiTap(goiTap.getTenGoiTap());
        goiTap.setMoTa(goiTap.getMoTa());
        goiTap.setTrangThai(goiTap.getTrangThai());
        goiTap.setLoaiGT(loaiGT);
        return new GoiTapDTO(goiTapRepository.save(goiTapDTO.toEntity()));
    }

    @Override
    public void xoaGoiTap(String maGoiTap) {
        goiTapRepository.deleteById(maGoiTap);
    }
}
