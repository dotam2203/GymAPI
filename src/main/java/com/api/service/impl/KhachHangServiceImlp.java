package com.api.service.impl;

import com.api.dto.KhachHangDTO;
import com.api.entity.KhachHangEntity;
import com.api.entity.LoaiKhachHangEntity;
import com.api.repository.KhachHangRepository;
import com.api.repository.LoaiKHRepository;
import com.api.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  04/07/2022
 */
@Service
public class KhachHangServiceImlp implements KhachHangService {
    @Autowired
    KhachHangRepository khachHangRepository;
    @Autowired
    LoaiKHRepository loaiKHRepository;

    @Override
    public List<KhachHangDTO> layDSKhachHang() {
        List<KhachHangEntity> dsKhachHang = khachHangRepository.findAll();
        return dsKhachHang.stream().map(KhachHangDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<KhachHangDTO> layDSKhachHangTheoLoaiKH(String maLoaiKH) {
        List<KhachHangEntity> dsKhachHangTheoLoaiKH = khachHangRepository.findByLoaiKH_MaLoaiKH(maLoaiKH);
        return dsKhachHangTheoLoaiKH.stream().map(KhachHangDTO::new).collect(Collectors.toList());
    }

    @Override
    public KhachHangDTO layKhachHang(String maKH) {
        KhachHangEntity khachHang = khachHangRepository.getById(maKH);
        return new KhachHangDTO(khachHang);
    }

    @Override
    public KhachHangDTO themKhachHang(KhachHangDTO khachHangDTO) {
        LoaiKhachHangEntity loaiKH = loaiKHRepository.getById(khachHangDTO.getMaLoaiKH());
        KhachHangEntity khachHang = khachHangDTO.toEntity();
        khachHang.setLoaiKH(loaiKH);
        return new KhachHangDTO(khachHangRepository.save(khachHang));
    }

    @Override
    public KhachHangDTO suaKhachHang(KhachHangDTO khachHangDTO) {
        LoaiKhachHangEntity loaiKH = loaiKHRepository.getById(khachHangDTO.getMaLoaiKH());
        KhachHangEntity khachHang = khachHangRepository.getById(khachHangDTO.getMaKH());
        khachHang.setHoTen(khachHang.getHoTen());
        khachHang.setEmail(khachHang.getEmail());
        khachHang.setSdt(khachHang.getSdt());
        khachHang.setPhai(khachHang.getPhai());
        khachHang.setDiaChi(khachHang.getDiaChi());
        khachHang.setHinhAnh(khachHang.getHinhAnh());
        khachHang.setLoaiKH(loaiKH);
        KhachHangEntity saveKhachHang = khachHangRepository.save(khachHang);
        return new KhachHangDTO(saveKhachHang);
    }

    @Override
    public void xoaKhachHang(String maKH) {
        khachHangRepository.deleteById(maKH);
    }
}
