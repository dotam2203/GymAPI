package com.api.service.impl;

import com.api.dto.LoaiKhachHangDTO;
import com.api.entity.LoaiKhachHangEntity;
import com.api.repository.LoaiKHRepository;
import com.api.service.LoaiKHService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  04/07/2022
 */
@Service
public class LoaiKHServiceImpl implements LoaiKHService {
    @Autowired
    LoaiKHRepository loaiKHRepository;
    @Override
    public List<LoaiKhachHangDTO> layDSLoaiKH() {
        List<LoaiKhachHangEntity> dsLoaiKH = loaiKHRepository.findAll();
        return dsLoaiKH.stream().map(LoaiKhachHangDTO::new).collect(Collectors.toList());
    }

    @Override
    public LoaiKhachHangDTO themLoaiKH(LoaiKhachHangDTO loaiKhachHangDTO) {
        return new LoaiKhachHangDTO(loaiKHRepository.save(loaiKhachHangDTO.toEntity()));
    }

    @Override
    public LoaiKhachHangDTO suaLoaiKH(LoaiKhachHangDTO loaiKhachHangDTO) {
        LoaiKhachHangEntity loaiKhachHang = loaiKHRepository.getById(loaiKhachHangDTO.getIdLoaiKH());
        loaiKhachHang.setIdLoaiKH(loaiKhachHangDTO.getIdLoaiKH());
        loaiKhachHang.setTenLoaiKH(loaiKhachHangDTO.getTenLoaiKH());
        return new LoaiKhachHangDTO(loaiKHRepository.save(loaiKhachHangDTO.toEntity()));
    }

    @Override
    public void xoaLoaiKH(Integer idLoaiKH) {
        loaiKHRepository.deleteById(idLoaiKH);
    }
}
