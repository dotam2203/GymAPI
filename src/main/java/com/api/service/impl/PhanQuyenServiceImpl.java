package com.api.service.impl;

import com.api.dto.PhanQuyenDTO;
import com.api.entity.PhanQuyenEntity;
import com.api.repository.PhanQuyenRepository;
import com.api.service.PhanQuyenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  04/07/2022
 */
@Service
public class PhanQuyenServiceImpl implements PhanQuyenService {
    @Autowired
    PhanQuyenRepository phanQuyenRepository;

    @Override
    public List<PhanQuyenDTO> layDSQuyen(){
        List<PhanQuyenEntity> dsQuyen = phanQuyenRepository.findAll();
        return dsQuyen.stream().map(PhanQuyenDTO::new).collect(Collectors.toList());
    }
    @Override
    public PhanQuyenDTO layQuyen(String maQuyen){
        PhanQuyenEntity quyen = phanQuyenRepository.getById(maQuyen);
        return new PhanQuyenDTO(quyen);
    }

    @Override
    public PhanQuyenDTO themQuyen(PhanQuyenDTO phanQuyenDTO) {
        return new PhanQuyenDTO(phanQuyenRepository.save(phanQuyenDTO.toEntity()));
    }

    @Override
    public PhanQuyenDTO suaQuyen(PhanQuyenDTO phanQuyenDTO) {
        PhanQuyenEntity phanQuyen = phanQuyenRepository.getById(phanQuyenDTO.getMaQuyen());
        phanQuyen.setMaQuyen(phanQuyenDTO.getMaQuyen());
        phanQuyen.setTenQuyen(phanQuyenDTO.getMaQuyen());
        PhanQuyenEntity save = phanQuyenRepository.save(phanQuyenDTO.toEntity());
        return new PhanQuyenDTO(save);
    }

    @Override
    public void xoaQuyen(String maQuyen) {
        phanQuyenRepository.deleteById(maQuyen);
    }
}
