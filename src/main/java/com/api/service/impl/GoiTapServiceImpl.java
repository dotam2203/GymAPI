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
    public List<GoiTapDTO> layDSGoiTapTheoLoaiGT(Integer idLoaiGT) {
        List<GoiTapEntity> dsGoiTapTheoLoaiGT = goiTapRepository.findByLoaiGT_IdLoaiGT(idLoaiGT);
        return dsGoiTapTheoLoaiGT.stream().map(GoiTapDTO::new).collect(Collectors.toList());
    }

    @Override
    public GoiTapDTO layGoiTap(String maGT) {
        GoiTapEntity goiTap = goiTapRepository.getById(maGT);
        return new GoiTapDTO(goiTap);
    }

    @Override
    public GoiTapDTO themGoiTap(GoiTapDTO goiTapDTO) {
        LoaiGoiTapEntity loaiGT = loaiGTRepository.getById(goiTapDTO.getIdLoaiGT());
        GoiTapEntity goiTap = goiTapDTO.toEntity();
        goiTap.setLoaiGT(loaiGT);
        return new GoiTapDTO(goiTapRepository.save(goiTap));
    }

    @Override
    public GoiTapDTO suaGoiTap(GoiTapDTO goiTapDTO) {
        LoaiGoiTapEntity loaiGT = loaiGTRepository.getById(goiTapDTO.getIdLoaiGT());
        GoiTapEntity goiTap = goiTapRepository.getById(goiTapDTO.getMaGT());
        goiTap.setTenGT(goiTapDTO.getTenGT());
        goiTap.setMoTa(goiTapDTO.getMoTa());
        goiTap.setTrangThai(goiTapDTO.getTrangThai());
        goiTap.setLoaiGT(loaiGT);
        GoiTapEntity saveGoiTap = goiTapRepository.save(goiTap);
        return new GoiTapDTO(saveGoiTap);
    }

    @Override
    public void xoaGoiTap(String maGT) {
        goiTapRepository.deleteById(maGT);
    }
}
