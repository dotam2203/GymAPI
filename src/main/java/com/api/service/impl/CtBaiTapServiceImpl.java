package com.api.service.impl;

import com.api.dto.CtBaiTapDTO;
import com.api.dto.TaiKhoanDTO;
import com.api.entity.*;
import com.api.repository.BaiTapRepository;
import com.api.repository.CtBaiTapRepository;
import com.api.repository.GoiTapRepository;
import com.api.service.CtBaiTapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CtBaiTapServiceImpl implements CtBaiTapService {
    @Autowired
    CtBaiTapRepository ctBaiTapRepository;
    @Autowired
    GoiTapRepository goiTapRepository;
    @Autowired
    BaiTapRepository baiTapRepository;
    @Override
    public List<CtBaiTapDTO> layDSCtBaiTap() {
        List<CtBaiTapEntity> dsCtBaiTap = ctBaiTapRepository.findAll();
        return dsCtBaiTap.stream().map(CtBaiTapDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<CtBaiTapDTO> layDSCtBaiTapTheoGT(String maGT) {
        List<CtBaiTapEntity> dsCtBaiTapTheoGT = ctBaiTapRepository.findByGoiTap_MaGT(maGT);
        return dsCtBaiTapTheoGT.stream().map(CtBaiTapDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<CtBaiTapDTO> layDSCtBaiTapTheoBT(Integer idBT) {
        List<CtBaiTapEntity> dsCtBaiTapTheoBT = ctBaiTapRepository.findByBaiTap_IdBT(idBT);
        return dsCtBaiTapTheoBT.stream().map(CtBaiTapDTO::new).collect(Collectors.toList());
    }

    @Override
    public CtBaiTapDTO layCtBaiTap(Integer idCTBT) {
        CtBaiTapEntity ctBaiTap = ctBaiTapRepository.getById(idCTBT);
        return new CtBaiTapDTO(ctBaiTap);
    }

    @Override
    public CtBaiTapDTO themCtBaiTap(CtBaiTapDTO ctBaiTapDTO) {
        GoiTapEntity goiTap = goiTapRepository.getById(ctBaiTapDTO.getMaGT());
        BaiTapEntity baiTap = baiTapRepository.getById(ctBaiTapDTO.getIdBT());
        CtBaiTapEntity ctBaiTap = ctBaiTapDTO.toEntity();
        ctBaiTap.setBaiTap(baiTap);
        ctBaiTap.setGoiTap(goiTap);
        return new CtBaiTapDTO(ctBaiTapRepository.save(ctBaiTap));
    }

    @Override
    public CtBaiTapDTO suaCtBaiTap(CtBaiTapDTO ctBaiTapDTO) {
        GoiTapEntity goiTap = goiTapRepository.getById(ctBaiTapDTO.getMaGT());
        BaiTapEntity baiTap = baiTapRepository.getById(ctBaiTapDTO.getIdBT());
        CtBaiTapEntity ctBaiTap = ctBaiTapDTO.toEntity();
        ctBaiTap.setBaiTap(baiTap);
        ctBaiTap.setGoiTap(goiTap);
        return new CtBaiTapDTO(ctBaiTapRepository.save(ctBaiTap));
    }

    @Override
    public void xoaCtBaiTap(Integer idCTBT) {
        ctBaiTapRepository.deleteById(idCTBT);
    }
}
