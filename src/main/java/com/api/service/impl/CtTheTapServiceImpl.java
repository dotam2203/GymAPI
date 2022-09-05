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

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        return dsCtThe.stream().map(CtTheTapDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<CtTheTapDTO> layLocDSCtTheTap(Date ngayBD, Date ngayKT)  {
        List<CtTheTapEntity> dsCtThe = ctTheTapRepository.findAll();
        List<CtTheTapEntity> temp = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yyyy");
        String dateStart = dateFormat.format(ngayBD);
        String dateEnd = dateFormat.format(ngayKT);
        boolean xet = true;
        for (int i = 0; i < dsCtThe.size(); i++) {
            xet = true;
            String date = dateFormat.format(dsCtThe.get(i).getTheTap().getNgayDK());
            int result1 = date.compareTo(dateStart);
            int result2 = date.compareTo(dateEnd);
            /*System.out.println("\ndateS: " + dateStart);
            System.out.println("\ndate: " + date);
            System.out.println("\ndateE: " + dateEnd);*/
            if ((result1 >= 0 && result2 <= 0)){
                //System.out.println("\nds tháng: " + date);
                if(i == 0){
                    temp.add(dsCtThe.get(i));
                    //System.out.println("\n1Doanh thu tháng "+ date +":" + dsCtThe.get(i).getDonGia());
                }
                else{
                    for (CtTheTapEntity ctTheTap : temp) {
                        String date1 = dateFormat.format(ctTheTap.getTheTap().getNgayDK());
                        String date2 = dateFormat.format(dsCtThe.get(i).getTheTap().getNgayDK());
                        if (ctTheTap.getGoiTap().getMaGT().equals(dsCtThe.get(i).getGoiTap().getMaGT()) && (date1.compareTo(date2) == 0)) {
                            xet = false;
                            long sum = tongDoanhThu(ctTheTap.getDonGia()) + tongDoanhThu(dsCtThe.get(i).getDonGia());
                            ctTheTap.setDonGia(formatMoney(String.valueOf(sum)) + " đ");
                           // System.out.println("\n2Doanh thu tháng "+ date +":" + formatMoney(String.valueOf(sum)) + " đ");
                            break;
                        }
                    }
                    if(xet){
                        temp.add(dsCtThe.get(i));
                        //System.out.println("\n3Doanh thu tháng "+ date +":" + dsCtThe.get(i).getDonGia());
                    }
                }
            }
        }
        return temp.stream().map(CtTheTapDTO::new).collect(Collectors.toList());
    }

    private Long tongDoanhThu(String donGia){
        //100,000 đ
        String[] str1 = donGia.split(" ");
        String[] str2 = str1[0].split(",");
        String str = "";
        for (String s : str2) {
            str += s;
        }
        return Long.parseLong(str.trim());
    }
    private String formatMoney(String money){
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        numberFormat.setMaximumFractionDigits(0);
        return numberFormat.format(Integer.parseInt(money)).substring(1);
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
