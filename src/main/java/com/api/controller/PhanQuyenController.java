package com.api.controller;

import com.api.dto.PhanQuyenDTO;
import com.api.service.PhanQuyenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  19/07/2022
 */
@RestController
@RequestMapping("/quyen")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PhanQuyenController {
    @Autowired
    private PhanQuyenService phanQuyenService;

    @GetMapping("")
    public List<PhanQuyenDTO> layDSQuyen() {
        return phanQuyenService.layDSQuyen();
    }

    @GetMapping("/loaiquyen") // api/loaiquyen?idQuyen=1
    public PhanQuyenDTO layQuyen(@RequestParam(value = "maQuyen") String maQuyen){
        return phanQuyenService.layQuyen(maQuyen);
    }

    @PostMapping("")
    public PhanQuyenDTO themQuyen(@Valid @RequestBody PhanQuyenDTO loaiKhachHangDTO) {
        return phanQuyenService.themQuyen(loaiKhachHangDTO);
    }

    @PutMapping("")
    public PhanQuyenDTO suaQuyen(@Valid @RequestBody PhanQuyenDTO loaiKhachHangDTO) {
        return phanQuyenService.suaQuyen(loaiKhachHangDTO);
    }

    @DeleteMapping("/{maQuyen}")
    public void xoaQuyen(@PathVariable String maQuyen) {
        phanQuyenService.xoaQuyen(maQuyen);
    }
}
