package com.api.controller;

import com.api.dto.GiaGoiTapDTO;
import com.api.service.GiaGTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  19/07/2022
 */
@RestController
@RequestMapping("/gia")
@CrossOrigin(origins = "*", maxAge = 3600)
public class GiaGTController {
    @Autowired
    private GiaGTService giaGTService;
    @GetMapping("")
    public List<GiaGoiTapDTO> layDSGia() {
        return giaGTService.layDSGia();
    }
    @GetMapping("/gt")
    public List<GiaGoiTapDTO> layDSGiaTheoGoiTap(@RequestParam(value = "maGT") String maGT) {
        return giaGTService.layDSGiaTheoGoiTap(maGT);
    }
    @GetMapping("/nv")
    public List<GiaGoiTapDTO> layDSGiaTheoNhanVien(@RequestParam(value = "maNV") String maNV) {
        return giaGTService.layDSGiaTheoNhanVien(maNV);
    }
    @GetMapping("/gtnv")
    public List<GiaGoiTapDTO> layDSGiaTheoGoiTap(@RequestParam(value = "maGT") String maGT,@RequestParam(value = "maNV") String maNV) {
        return giaGTService.layDSGiaTheoGoiTap_NhanVien(maGT,maNV);
    }

    @GetMapping("/gia")//gia/gia?idGia=1
    public GiaGoiTapDTO layGia(@RequestParam(value = "idGia") Integer idGia){
        return giaGTService.layGia(idGia);
    }

    @PostMapping("")
    public GiaGoiTapDTO themGia(@Valid @RequestBody GiaGoiTapDTO giaGT) {
        return giaGTService.themGia(giaGT);
    }

    @PutMapping("")
    public GiaGoiTapDTO suaGia(@Valid @RequestBody GiaGoiTapDTO giaGT) {
        return giaGTService.suaGia(giaGT);
    }

    @DeleteMapping("/{idGia}")
    public void xoaGia(@PathVariable Integer idGia) {
        giaGTService.xoaGia(idGia);
    }
}
