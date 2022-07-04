package com.api.service.impl;

import com.api.dto.LoaiGoiTapDTO;
import com.api.entity.LoaiGoiTapEntity;
import com.api.repository.LoaiGoiTapRepository;
import com.api.service.LoaiGoiTapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  03/07/2022
 */
@Service
public class LoaiGoiTapServiceImpl implements LoaiGoiTapService {
    @Autowired
    LoaiGoiTapRepository loaiGoiTapRepository;

    @Override
    public List<LoaiGoiTapDTO> layDSLoaiGoiTap() {
        List<LoaiGoiTapEntity> dsLoaiGT = loaiGoiTapRepository.findAll();
        return dsLoaiGT.stream().map(LoaiGoiTapDTO::new).collect(Collectors.toList());
    }

    @Override
    public LoaiGoiTapDTO themLoaiGoiTap(LoaiGoiTapDTO loaiGoitapDTO) {
        return new LoaiGoiTapDTO(loaiGoiTapRepository.save(loaiGoitapDTO.toEntity()));
    }

    @Override
    public LoaiGoiTapDTO suaLoaiGoiTap(LoaiGoiTapDTO loaiGoitapDTO) {
        LoaiGoiTapEntity loaiGoiTap = loaiGoiTapRepository.getById(loaiGoitapDTO.getMaLoaiGT());
        loaiGoiTap.setMaLoaiGT(loaiGoiTap.getMaLoaiGT());
        loaiGoiTap.setTenLoaiGT(loaiGoiTap.getTenLoaiGT());
        loaiGoiTap.setTrangThai(loaiGoiTap.getTrangThai());
        return new LoaiGoiTapDTO(loaiGoiTapRepository.save(loaiGoitapDTO.toEntity()));
    }

    @Override
    public void xoaLoaiGoiTap(String maLoaiGT) {
        loaiGoiTapRepository.deleteById(maLoaiGT);
    }
}
