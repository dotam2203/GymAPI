package com.api.controller;

import com.api.dto.NhanVienDTO;
import com.api.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/nhanvien")
@CrossOrigin(origins = "*", maxAge = 3600)
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;
    @GetMapping("/getds")
    public List<NhanVienDTO> layDSNhanVien() {
        return nhanVienService.layDSNhanVien();
    }
    @GetMapping("/get") // api/loaikh?maNV=1
    public NhanVienDTO layNhanVien(@RequestParam(value = "maNV") String maNV){
        return nhanVienService.layNhanVien(maNV);
    }
    @PostMapping("/post")
    public NhanVienDTO themNhanVien(@Valid @RequestBody NhanVienDTO nhanVienDTO) {
        return nhanVienService.themNhanVien(nhanVienDTO);
    }
    @PutMapping("/put")
    public NhanVienDTO suaNhanVien(@Valid @RequestBody NhanVienDTO nhanVienDTO) {
        return nhanVienService.suaNhanVien(nhanVienDTO);
    }
    @DeleteMapping("/delete/{maNV}")
    public void xoaNhanVien(@PathVariable String maNV) {
        nhanVienService.xoaNhanVien(maNV);
    }
}
