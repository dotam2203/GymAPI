package com.api.controller;

import com.api.dto.KhachHangDTO;
import com.api.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  04/07/2022
 */
@RestController
@RequestMapping("/khachhang")
@CrossOrigin(origins = "*", maxAge = 3600)
public class KhachHangController {
    @Autowired
    private KhachHangService khachHangService;

    @GetMapping("/get")
    public List<KhachHangDTO> layDSKhachHang() {
        return khachHangService.layDSKhachHang();
    }

    @GetMapping("/getds")
    public List<KhachHangDTO> layDSKhachHangTheoLoaiKH(@RequestParam(value = "idLoaiKH") Integer idLoaiKH) {
            return khachHangService.layDSKhachHangTheoLoaiKH(idLoaiKH);
    }

    @GetMapping("/getkh")
    public KhachHangDTO layKhachHang(@RequestParam(value = "maKH") String maKH) {
        return khachHangService.layKhachHang(maKH);
    }

    @PostMapping("/post")
    public KhachHangDTO themKhachHang(@Valid @RequestBody KhachHangDTO khachHangDTO) {
        return khachHangService.themKhachHang(khachHangDTO);
    }

    @PutMapping("/put")
    public KhachHangDTO suaKhachHang(@Valid @RequestBody KhachHangDTO khachHangDTO) {
        return khachHangService.suaKhachHang(khachHangDTO);
    }

    @DeleteMapping("/delete/{maKH}")
    public void xoaGoiTap(@PathVariable String maKH) {
        khachHangService.xoaKhachHang(maKH);
    }
}
