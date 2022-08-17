package com.api.controller;

import com.api.dto.HoaDonDTO;
import com.api.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/hoadon")
@CrossOrigin(origins = "*", maxAge = 3600)
public class HoaDonController {
    @Autowired
    private HoaDonService hoaDonService;
    @GetMapping("/getds")
    public List<HoaDonDTO> layDSHoaDon() {
        return hoaDonService.layDSHoaDon();
    }
    @GetMapping("/getngay")
    public List<HoaDonDTO> layDSHoaDonTheoNgayGiam() {
        return hoaDonService.layDSHoaDonTheoNgayGiam();
    }
    @GetMapping("/getnv")
    public List<HoaDonDTO> layDSHoaDonTheoNV(@RequestParam(value = "maNV") String maNV) {
        return hoaDonService.layDSHoaDonTheoNV(maNV);
    }
    @GetMapping("/getthe")
    public List<HoaDonDTO> layDSHoaDonTheoThe(@RequestParam(value = "maThe") String maThe) {
        return hoaDonService.layDSHoaDonTheoTheTap(maThe);
    }

    @GetMapping("/get")
    public HoaDonDTO layHoaDon(@RequestParam(value = "maHD") String maHD){
        return hoaDonService.layHoaDon(maHD);
    }

    @PostMapping("/post")
    public HoaDonDTO themHoaDon(@Valid @RequestBody HoaDonDTO hoaDonDTO) {
        return hoaDonService.themHoaDon(hoaDonDTO);
    }

    @PutMapping("/put")
    public HoaDonDTO suaHoaDon(@Valid @RequestBody HoaDonDTO hoaDonDTO) {
        return hoaDonService.suaHoaDon(hoaDonDTO);
    }

    @DeleteMapping("/delete/{maHD}")
    public void xoaHoaDon(@PathVariable String maHD) {
        hoaDonService.xoaHoaDon(maHD);
    }
}
