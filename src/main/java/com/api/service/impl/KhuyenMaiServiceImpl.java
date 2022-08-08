package com.api.service.impl;

import com.api.dto.KhuyenMaiDTO;
import com.api.dto.TaiKhoanDTO;
import com.api.entity.KhuyenMaiEntity;
import com.api.entity.NhanVienEntity;
import com.api.entity.PhanQuyenEntity;
import com.api.entity.TaiKhoanEntity;
import com.api.repository.KhuyenMaiRepository;
import com.api.repository.NhanVienRepository;
import com.api.service.KhuyenMaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KhuyenMaiServiceImpl implements KhuyenMaiService {
    @Autowired
    KhuyenMaiRepository khuyenMaiRepository;
    @Autowired
    NhanVienRepository nhanVienRepository;
    @Override
    public List<KhuyenMaiDTO> layDSKhuyenMai() {
        List<KhuyenMaiEntity> dsKhuyenMai = khuyenMaiRepository.findAll();
        return dsKhuyenMai.stream().map(KhuyenMaiDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<KhuyenMaiDTO> layDSKhuyenMaiTheoNV(String maNV) {
        List<KhuyenMaiEntity> dsKhuyenMaiTheoNV = khuyenMaiRepository.findByNhanVien_MaNV(maNV);
        return dsKhuyenMaiTheoNV.stream().map(KhuyenMaiDTO::new).collect(Collectors.toList());
    }

    @Override
    public KhuyenMaiDTO layKhuyenMai(Integer idKM) {
        KhuyenMaiEntity khuyenMai = khuyenMaiRepository.getById(idKM);
        return new KhuyenMaiDTO(khuyenMai);
    }

    @Override
    public KhuyenMaiDTO themKhuyenMai(KhuyenMaiDTO khuyenMaiDTO) {
        NhanVienEntity nhanVien = nhanVienRepository.getById(khuyenMaiDTO.getMaNV());
        KhuyenMaiEntity khuyenMai = khuyenMaiDTO.toEntity();
        khuyenMai.setNhanVien(nhanVien);
        return new KhuyenMaiDTO(khuyenMaiRepository.save(khuyenMai));
    }

    @Override
    public KhuyenMaiDTO suaKhuyenMai(KhuyenMaiDTO khuyenMaiDTO) {
        NhanVienEntity nhanVien = nhanVienRepository.getById(khuyenMaiDTO.getMaNV());
        KhuyenMaiEntity khuyenMai = khuyenMaiRepository.getById(khuyenMaiDTO.getIdKM());
        khuyenMai.setNgayBD(khuyenMaiDTO.getNgayBD());
        khuyenMai.setNgayKT(khuyenMaiDTO.getNgayKT());
        khuyenMai.setMoTa(khuyenMaiDTO.getMoTa());
        khuyenMai.setNhanVien(nhanVien);
        KhuyenMaiEntity save = khuyenMaiRepository.save(khuyenMai);
        return new KhuyenMaiDTO(save);
    }

    @Override
    public void xoaKhuyenMai(Integer idKM) {
        khuyenMaiRepository.deleteById(idKM);
    }
}
