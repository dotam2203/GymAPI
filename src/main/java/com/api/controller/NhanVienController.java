package com.api.controller;

import com.api.dto.NhanVienDTO;
import com.api.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  19/07/2022
 */
@RestController
@RequestMapping("/nhanvien")
@CrossOrigin(origins = "*", maxAge = 3600)
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping("")
    public List<NhanVienDTO> layDSNhanVien() {
        return nhanVienService.layDSNhanVien();
    }

    @GetMapping("/nv") // api/loaikh?maNV=1
    public NhanVienDTO layKhachHang(@RequestParam(value = "maNV") String maNV){
        return nhanVienService.layNhanVien(maNV);
    }

    @PostMapping("")
    public NhanVienDTO themNhanVien(@Valid @RequestBody NhanVienDTO nhanVienDTO) {
        return nhanVienService.themNhanVien(nhanVienDTO);
    }

    @PutMapping("")
    public NhanVienDTO suaNhanVien(@Valid @RequestBody NhanVienDTO nhanVienDTO) {
        return nhanVienService.suaNhanVien(nhanVienDTO);
    }

    @DeleteMapping("/{maNV}")
    public void xoaNhanVien(@PathVariable String maNV) {
        nhanVienService.xoaNhanVien(maNV);
    }
}
