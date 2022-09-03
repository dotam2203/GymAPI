package com.api.service.impl;

import com.api.dto.CtTheTapDTO;
import com.api.dto.TaiKhoanDTO;
import com.api.entity.*;
import com.api.repository.CtTheTapRepository;
import com.api.repository.GoiTapRepository;
import com.api.repository.HoaDonRepository;
import com.api.repository.TheTapRepository;
import com.api.service.CtTheTapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CtTheTapServiceImpl implements CtTheTapService {
    @Autowired
    CtTheTapRepository ctTheTapRepository;
    @Autowired
    HoaDonRepository hoaDonRepository;
    @Autowired
    TheTapRepository theTapRepository;
    @Autowired
    GoiTapRepository goiTapRepository;
    @Override
    public List<CtTheTapDTO> layDSCtTheTap() {
        List<CtTheTapEntity> dsCtThe = ctTheTapRepository.findAll();
        List<CtTheTapEntity> temp = new ArrayList<>();
        int dem = 0;
        for(int i = 0; i < dsCtThe.size(); i++){
            if(i == 0){
                temp.add(dsCtThe.get(i));
            }
            else if(temp.get(dem).getGoiTap().getMaGT().equals(dsCtThe.get(i).getGoiTap().getMaGT())){
                long sum = tongDoanhThu(temp.get(dem).getDonGia() + tongDoanhThu(dsCtThe.get(i).getDonGia()));
                temp.get(dem).setDonGia(String.valueOf(sum));
            }
            else {
                temp.add(dsCtThe.get(i));
                dem++;
            }
        }
        return temp.stream().map(CtTheTapDTO::new).collect(Collectors.toList());
    }
    private Long tongDoanhThu(String donGia){
        String[] str1 = donGia.split(" ");
        String[] str2 = str1[0].split(",");
        String str = "";
        for(int i = 0; i <= str2.length; i++){
            str += str2[i];
        }
        return Long.parseLong(str.trim());
    }

    @Override
    public List<CtTheTapDTO> layDSCtTheTapTheoHD(String maHD) {
        List<CtTheTapEntity> dsCtTheTheoHD = ctTheTapRepository.findByHoaDon_MaHD(maHD);
        return dsCtTheTheoHD.stream().map(CtTheTapDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<CtTheTapDTO> layDSCtTheTapTheoGT(String maGT) {
        List<CtTheTapEntity> dsCtTheTheoGT = ctTheTapRepository.findByGoiTap_MaGT(maGT);
        return dsCtTheTheoGT.stream().map(CtTheTapDTO::new).collect(Collectors.toList());
    }

    @Override
    public CtTheTapDTO layCtTheTapTheoThe(String maThe) {
        CtTheTapEntity ctTheTheoThe = ctTheTapRepository.findByTheTap_MaThe(maThe);
        return new CtTheTapDTO(ctTheTheoThe);
    }

    @Override
    public CtTheTapDTO layCtTheTap(Integer idCTThe) {
        CtTheTapEntity ctTheTap = ctTheTapRepository.getById(idCTThe);
        return new CtTheTapDTO(ctTheTap);
    }

    @Override
    public CtTheTapDTO themCtTheTap(CtTheTapDTO ctTheTapDTO) {
        HoaDonEntity hoaDon = hoaDonRepository.getById(ctTheTapDTO.getMaHD());
        TheTapEntity theTap = theTapRepository.getById(ctTheTapDTO.getMaThe());
        GoiTapEntity goiTap = goiTapRepository.getById(ctTheTapDTO.getMaGT());
        CtTheTapEntity ctTheTap = ctTheTapDTO.toEntity();
        ctTheTap.setHoaDon(hoaDon);
        ctTheTap.setGoiTap(goiTap);
        ctTheTap.setTheTap(theTap);
        return new CtTheTapDTO(ctTheTapRepository.save(ctTheTap));
    }

    @Override
    public CtTheTapDTO suaCtTheTap(CtTheTapDTO ctTheTapDTO) {
        HoaDonEntity hoaDon = hoaDonRepository.getById(ctTheTapDTO.getMaHD());
        TheTapEntity theTap = theTapRepository.getById(ctTheTapDTO.getMaThe());
        GoiTapEntity goiTap = goiTapRepository.getById(ctTheTapDTO.getMaGT());
        CtTheTapEntity ctTheTap = ctTheTapRepository.getById(ctTheTapDTO.getIdCTThe());
        ctTheTap.setDonGia(ctTheTapDTO.getDonGia());
        ctTheTap.setHoaDon(hoaDon);
        ctTheTap.setGoiTap(goiTap);
        ctTheTap.setTheTap(theTap);
        CtTheTapEntity save = ctTheTapRepository.save(ctTheTap);
        return new CtTheTapDTO(save);
    }

    @Override
    public void xoaCtTheTap(Integer idCTThe) {
        ctTheTapRepository.deleteById(idCTThe);
    }
}
