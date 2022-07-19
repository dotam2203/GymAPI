package com.api.service.impl;

import com.api.dto.NhanVienDTO;
import com.api.dto.NhanVienDTO;
import com.api.dto.NhanVienDTO;
import com.api.entity.LoaiKhachHangEntity;
import com.api.entity.NhanVienEntity;
import com.api.repository.NhanVienRepository;
import com.api.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  19/07/2022
 */
@Service
public class NhanVienServiceImpl implements NhanVienService {
    @Autowired
    NhanVienRepository nhanVienRepository;

    @Override
    public List<NhanVienDTO> layDSNhanVien() {
        List<NhanVienEntity> dsNhanVien = nhanVienRepository.findAll();
        return dsNhanVien.stream().map(NhanVienDTO::new).collect(Collectors.toList());
    }

    @Override
    public NhanVienDTO layNhanVien(String maNV) {
        NhanVienEntity nhanVien = nhanVienRepository.getById(maNV);
        return new NhanVienDTO(nhanVien);
    }

    @Override
    public NhanVienDTO themNhanVien(NhanVienDTO nhanVienDTO) {
        return new NhanVienDTO(nhanVienRepository.save(nhanVienDTO.toEntity()));
    }

    @Override
    public NhanVienDTO suaNhanVien(NhanVienDTO nhanVienDTO) {
        NhanVienEntity nhanVien = nhanVienRepository.getById(nhanVienDTO.getMaNV());
        nhanVien.setMaNV(nhanVienDTO.getMaNV());
        nhanVien.setHoTen(nhanVienDTO.getHoTen());
        nhanVien.setEmail(nhanVienDTO.getEmail());
        nhanVien.setPhai(nhanVienDTO.getPhai());
        nhanVien.setSdt(nhanVienDTO.getSdt());
        nhanVien.setDiaChi(nhanVienDTO.getDiaChi());
        nhanVien.setHinhAnh(nhanVienDTO.getHinhAnh());
        NhanVienEntity save = nhanVienRepository.save(nhanVienDTO.toEntity());
        return new NhanVienDTO(save);
    }

    @Override
    public void xoaNhanVien(String maNV) {
        nhanVienRepository.deleteById(maNV);
    }
}
