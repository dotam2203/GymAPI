package com.api.service.impl;

import com.api.dto.TaiKhoanDTO;
import com.api.entity.*;
import com.api.repository.NhanVienRepository;
import com.api.repository.PhanQuyenRepository;
import com.api.repository.TaiKhoanRepository;
import com.api.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  19/07/2022
 */
@Service
public class TaiKhoanServiceImpl implements TaiKhoanService {
    @Autowired
    TaiKhoanRepository taiKhoanRepository;
    @Autowired
    PhanQuyenRepository phanQuyenRepository;
    @Autowired
    NhanVienRepository nhanVienRepository;

    @Override
    public List<TaiKhoanDTO> layDSTaiKhoan() {
        List<TaiKhoanEntity> dsTaiKhoan = taiKhoanRepository.findAll();
        return dsTaiKhoan.stream().map(TaiKhoanDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<TaiKhoanDTO> layDSTaiKhoanTheoQuyen(String maQuyen) {
        List<TaiKhoanEntity> dsTaiKhoanTheoLoaiGT = taiKhoanRepository.findByPhanQuyen_MaQuyen(maQuyen);
        return dsTaiKhoanTheoLoaiGT.stream().map(TaiKhoanDTO::new).collect(Collectors.toList());
    }

    @Override
    public TaiKhoanEntity layTaiKhoanTheoNV(String maNV) {
        TaiKhoanEntity taiKhoan = taiKhoanRepository.findByNhanVien_MaNV(maNV);
        return taiKhoan;
    }

    @Override
    public TaiKhoanDTO layTaiKhoan(String maTK) {
        TaiKhoanEntity taiKhoan = taiKhoanRepository.getById(maTK);
        return new TaiKhoanDTO(taiKhoan);
    }

    @Override
    public TaiKhoanDTO themTaiKhoan(TaiKhoanDTO taiKhoanDTO) {
        PhanQuyenEntity phanQuyen = phanQuyenRepository.getById(taiKhoanDTO.getMaQuyen());
        NhanVienEntity nhanVien = nhanVienRepository.getById(taiKhoanDTO.getMaNV());
        TaiKhoanEntity taiKhoan = taiKhoanDTO.toEntity();
        taiKhoan.setPhanQuyen(phanQuyen);
        taiKhoan.setNhanVien(nhanVien);
        return new TaiKhoanDTO(taiKhoanRepository.save(taiKhoan));
    }

    @Override
    public TaiKhoanDTO suaTaiKhoan(TaiKhoanDTO taiKhoanDTO) {
        PhanQuyenEntity phanQuyen = phanQuyenRepository.getById(taiKhoanDTO.getMaQuyen());
        NhanVienEntity nhanVien = nhanVienRepository.getById(taiKhoanDTO.getMaNV());
        TaiKhoanEntity taiKhoan = taiKhoanRepository.getById(taiKhoanDTO.getMaTK());
        taiKhoan.setMatKhau(taiKhoanDTO.getMatKhau());
        taiKhoan.setTrangThai(taiKhoanDTO.getTrangThai());
        taiKhoan.setPhanQuyen(phanQuyen);
        taiKhoan.setNhanVien(nhanVien);
        TaiKhoanEntity save = taiKhoanRepository.save(taiKhoan);
        return new TaiKhoanDTO(save);
    }

    @Override
    public void xoaTaiKhoan(String maTK) {
        taiKhoanRepository.deleteById(maTK);
    }
}
