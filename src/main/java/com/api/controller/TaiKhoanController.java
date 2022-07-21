package com.api.controller;

import com.api.dto.TaiKhoanDTO;
import com.api.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  19/07/2022
 */
@RestController
@RequestMapping("/taikhoan")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TaiKhoanController {
    @Autowired
    private TaiKhoanService taiKhoanService;

    @GetMapping("")
    public List<TaiKhoanDTO> layDSTaiKhoan() {
        return taiKhoanService.layDSTaiKhoan();
    }

    @GetMapping("/dstk")
    public List<TaiKhoanDTO> layDSTaiKhoanTheoQuyen(@RequestParam(value = "maQuyen") String maQuyen) {
        return taiKhoanService.layDSTaiKhoanTheoQuyen(maQuyen);
    }

    @GetMapping("/tk")
    public TaiKhoanDTO layTaiKhoan(@RequestParam(value = "maTK") String maTK){
        return taiKhoanService.layTaiKhoan(maTK);
    }

    @PostMapping("")
    public TaiKhoanDTO themTaiKhoan(@Valid @RequestBody TaiKhoanDTO taiKhoanDTO) {
        return taiKhoanService.themTaiKhoan(taiKhoanDTO);
    }

    @PutMapping("")
    public TaiKhoanDTO suaTaiKhoan(@Valid @RequestBody TaiKhoanDTO taiKhoanDTO) {
        return taiKhoanService.suaTaiKhoan(taiKhoanDTO);
    }

    @DeleteMapping("/{maTK}")
    public void xoaTaiKhoan(@PathVariable String maTK) {
        taiKhoanService.xoaTaiKhoan(maTK);
    }
}
