package com.api.controller;

import com.api.dto.LoaiKhachHangDTO;
import com.api.service.LoaiKHService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  04/07/2022
 */
@RestController
@RequestMapping("/loaikh")
@CrossOrigin(origins = "*", maxAge = 3600)
public class LoaiKHController {
    @Autowired
    private LoaiKHService loaiKHService;

    @GetMapping("")
    public List<LoaiKhachHangDTO> layDSLoaiKH() {
        return loaiKHService.layDSLoaiKH();
    }

    @PostMapping("")
    public LoaiKhachHangDTO themLoaiKH(@Valid @RequestBody LoaiKhachHangDTO loaiKhachHangDTO) {
        return loaiKHService.themLoaiKH(loaiKhachHangDTO);
    }

    @PutMapping("")
    public LoaiKhachHangDTO suaLoaiKH(@Valid @RequestBody LoaiKhachHangDTO loaiKhachHangDTO) {
        return loaiKHService.suaLoaiKH(loaiKhachHangDTO);
    }

    @DeleteMapping("/{maLoaiKH}")
    public void xoaLoaiKH(@PathVariable String maLoaiKH) {
        loaiKHService.xoaLoaiKH(maLoaiKH);
    }
}
