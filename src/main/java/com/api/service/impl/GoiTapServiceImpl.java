package com.api.service.impl;

import com.api.dto.GoiTapDTO;
import com.api.entity.GoiTapEntity;
import com.api.repository.GoiTapRepository;
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

    @Override
    public List<GoiTapDTO> layDSGoiTap() {
        List<GoiTapEntity> dsGoiTap = goiTapRepository.findAll();
        return dsGoiTap.stream().map(GoiTapDTO::new).collect(Collectors.toList());
    }

    @Override
    public GoiTapDTO themGoiTap(GoiTapDTO goiTapDTO) {
        return null;
    }

    @Override
    public GoiTapDTO suaGoiTap(GoiTapDTO goiTapDTO) {
        return null;
    }

    @Override
    public void xoaGoiTap(String maGoiTap) {

    }
}
