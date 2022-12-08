package com.api.controller;

import com.api.dto.TaiKhoanDTO;
import com.api.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/taikhoan")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TaiKhoanController {
    @Autowired
    private TaiKhoanService taiKhoanService;
    @GetMapping("/getds")
    public List<TaiKhoanDTO> layDSTaiKhoan() {
        return taiKhoanService.layDSTaiKhoan();
    }
    @GetMapping("/getquyen")
    public List<TaiKhoanDTO> layDSTaiKhoanTheoQuyen(@RequestParam(value = "maQuyen") String maQuyen) {
        return taiKhoanService.layDSTaiKhoanTheoQuyen(maQuyen);
    }
    @GetMapping("/get")
    public TaiKhoanDTO layTaiKhoan(@RequestParam(value = "maTK") String maTK){
        return taiKhoanService.layTaiKhoan(maTK);
    }
    @PostMapping("/post")
    public TaiKhoanDTO themTaiKhoan(@Valid @RequestBody TaiKhoanDTO taiKhoanDTO) {
        return taiKhoanService.themTaiKhoan(taiKhoanDTO);
    }
    @PutMapping("/put")
    public TaiKhoanDTO suaTaiKhoan(@Valid @RequestBody TaiKhoanDTO taiKhoanDTO) {
        return taiKhoanService.suaTaiKhoan(taiKhoanDTO);
    }
    @DeleteMapping("/delete/{maTK}")
    public void xoaTaiKhoan(@PathVariable String maTK) {
        taiKhoanService.xoaTaiKhoan(maTK);
    }
}
