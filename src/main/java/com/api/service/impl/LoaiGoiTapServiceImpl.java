package com.api.service.impl;

import com.api.dto.LoaiGoitapDTO;
import com.api.entity.LoaiGoiTapEntity;
import com.api.repository.LoaiGoiTapRepository;
import com.api.service.LoaiGoitapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  03/07/2022
 */
@Service
public class LoaiGoiTapServiceImpl implements LoaiGoitapService {
    @Autowired
    LoaiGoiTapRepository loaiGoiTapRepository;

    @Override
    public List<LoaiGoitapDTO> layDSLoaiGoiTap() {
        List<LoaiGoiTapEntity> dsLoaiGT = loaiGoiTapRepository.findAll();
        return dsLoaiGT.stream().map(LoaiGoitapDTO::new).collect(Collectors.toList());
    }

    @Override
    public LoaiGoitapDTO themLoaiGoiTap(LoaiGoitapDTO loaiGoitapDTO) {
        LoaiGoiTapEntity luuLoaiGT = loaiGoiTapRepository.save(loaiGoitapDTO.toEntity());
        return new LoaiGoitapDTO(luuLoaiGT);
    }

    @Override
    public LoaiGoitapDTO suaLoaiGoiTap(LoaiGoitapDTO loaiGoitapDTO) {
        LoaiGoiTapEntity loaiGoiTap = loaiGoiTapRepository.getById(loaiGoitapDTO.getMaLoaiGT());
        loaiGoiTap.setMaLoaiGT(loaiGoiTap.getMaLoaiGT());
        loaiGoiTap.setTenLoaiGT(loaiGoiTap.getTenLoaiGT());
        loaiGoiTap.setTrangThai(loaiGoiTap.getTrangThai());
        LoaiGoiTapEntity luuLoaiGT = loaiGoiTapRepository.save(loaiGoitapDTO.toEntity());
        return new LoaiGoitapDTO(luuLoaiGT);
    }

    @Override
    public void xoaLoaiGoiTap(String maLoaiGT) {
        loaiGoiTapRepository.deleteById(maLoaiGT);
    }
}