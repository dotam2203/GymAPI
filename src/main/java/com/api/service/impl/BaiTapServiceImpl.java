package com.api.service.impl;

import com.api.dto.BaiTapDTO;
import com.api.entity.BaiTapEntity;
import com.api.repository.BaiTapRepository;
import com.api.service.BaiTapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  06/07/2022
 */
@Service
public class BaiTapServiceImpl implements BaiTapService {
    @Autowired
    BaiTapRepository baiTapRepository;
    @Override
    public List<BaiTapDTO> layDSBaiTap() {
        List<BaiTapEntity> baiTaps = baiTapRepository.findAll();
        return baiTaps.stream().map(BaiTapDTO::new).collect(Collectors.toList());
    }

    @Override
    public BaiTapDTO themBaiTap(BaiTapDTO baiTapDTO) {
        if(baiTapDTO != null){
            return new BaiTapDTO(baiTapRepository.save(baiTapDTO.toEntity()));
        }
        return null;
    }

    @Override
    public BaiTapDTO suaBaiTap(BaiTapDTO baiTapDTO) {
        if(baiTapDTO != null){
            BaiTapEntity baiTap = baiTapRepository.getById(baiTapDTO.getMaBT());
            baiTap.setTenBT(baiTapDTO.getTenBT());
            baiTap.setMoTa(baiTapDTO.getMoTa());
            baiTap.setDuongDan(baiTapDTO.getDuongDan());
            return new BaiTapDTO(baiTapRepository.save(baiTapDTO.toEntity()));
        }
        return null;
    }

    @Override
    public void xoaBaiTap(String maBT) {
        if(maBT != null){
            baiTapRepository.deleteById(maBT);
        }
    }
}
