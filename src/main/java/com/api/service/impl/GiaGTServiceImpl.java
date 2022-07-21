package com.api.service.impl;

import com.api.dto.GiaGoiTapDTO;
import com.api.entity.GiaGoiTapEntity;
import com.api.entity.GoiTapEntity;
import com.api.entity.NhanVienEntity;
import com.api.repository.GiaGTRepository;
import com.api.repository.GoiTapRepository;
import com.api.repository.NhanVienRepository;
import com.api.service.GiaGTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  21/07/2022
 */
@Service
public class GiaGTServiceImpl implements GiaGTService {
    @Autowired
    GiaGTRepository giaRepository;
    @Autowired
    GoiTapRepository goiTapRepository;
    @Autowired
    NhanVienRepository nhanVienRepository;
    @Override
    public List<GiaGoiTapDTO> layDSGia() {
        List<GiaGoiTapEntity> dsGia = giaRepository.findAll();
        return dsGia.stream().map(GiaGoiTapDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<GiaGoiTapDTO> layDSGiaTheoNhanVien(String maNV) {
        List<GiaGoiTapEntity> dsGiaNV = giaRepository.findByNhanVien_MaNV(maNV);
        return dsGiaNV.stream().map(GiaGoiTapDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<GiaGoiTapDTO> layDSGiaTheoGoiTap(String maGT) {
        List<GiaGoiTapEntity> dsGiaGT = giaRepository.findByGoiTap_MaGoiTap(maGT);
        return dsGiaGT.stream().map(GiaGoiTapDTO::new).collect(Collectors.toList());
    }

    /*@Override
    public List<GiaGoiTapDTO> layDSGiaTheoGoiTap_NhanVien(String maGT, String maNV) {
        List<GiaGoiTapEntity> dsGiaGT_NV = giaRepository.findByNhanVien_MaGoiTap_MaNV(maGT,maNV);
        return dsGiaGT_NV.stream().map(GiaGoiTapDTO::new).collect(Collectors.toList());
    }*/

    @Override
    public GiaGoiTapDTO layGia(Integer idGia) {
        GiaGoiTapEntity gia = giaRepository.getById(idGia);
        return new GiaGoiTapDTO(gia);
    }

    @Override
    public GiaGoiTapDTO themGia(GiaGoiTapDTO giaGoiTapDTO) {
        GoiTapEntity goiTap = goiTapRepository.getById(giaGoiTapDTO.getMaGoiTap());
        NhanVienEntity nhanVien = nhanVienRepository.getById(giaGoiTapDTO.getMaNV());
        GiaGoiTapEntity gia = giaGoiTapDTO.toEntity();
        gia.setGoiTap(goiTap);
        gia.setNhanVien(nhanVien);
        return new GiaGoiTapDTO(giaRepository.save(gia));
    }

    @Override
    public GiaGoiTapDTO suaGia(GiaGoiTapDTO giaGoiTapDTO) {
        GoiTapEntity goiTap = goiTapRepository.getById(giaGoiTapDTO.getMaGoiTap());
        NhanVienEntity nhanVien = nhanVienRepository.getById(giaGoiTapDTO.getMaNV());
        GiaGoiTapEntity gia = giaRepository.getById(giaGoiTapDTO.getIdGia());
        gia.setNgayApDung(gia.getNgayApDung());
        gia.setGia(gia.getGia());
        gia.setGoiTap(goiTap);
        gia.setNhanVien(nhanVien);
        return new GiaGoiTapDTO(giaRepository.save(gia));
    }

    @Override
    public void xoaGia(Integer idGia) {
        giaRepository.deleteById(idGia);
    }
}
