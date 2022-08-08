package com.api.controller;

import com.api.dto.KhuyenMaiDTO;
import com.api.service.KhuyenMaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/khuyenmai")
@CrossOrigin(origins = "*", maxAge = 3600)
public class KhuyenMaiController {
    @Autowired
    private KhuyenMaiService khuyenMaiService;
    @GetMapping("/getds")
    public List<KhuyenMaiDTO> layDSKhuyenMai() {
        return khuyenMaiService.layDSKhuyenMai();
    }

    @GetMapping("/getnv")
    public List<KhuyenMaiDTO> layDSKhuyenMaiTheoNV(@RequestParam(value = "maNV") String maNV) {
        return khuyenMaiService.layDSKhuyenMaiTheoNV(maNV);
    }

    @GetMapping("/get")
    public KhuyenMaiDTO layKhuyenMai(@RequestParam(value = "idKM") Integer idKM){
        return khuyenMaiService.layKhuyenMai(idKM);
    }

    @PostMapping("/post")
    public KhuyenMaiDTO themKhuyenMai(@Valid @RequestBody KhuyenMaiDTO khuyenMaiDTO) {
        return khuyenMaiService.themKhuyenMai(khuyenMaiDTO);
    }

    @PutMapping("/put")
    public KhuyenMaiDTO suaKhuyenMai(@Valid @RequestBody KhuyenMaiDTO khuyenMaiDTO) {
        return khuyenMaiService.suaKhuyenMai(khuyenMaiDTO);
    }

    @DeleteMapping("/delete/{idKM}")
    public void xoaKhuyenMai(@PathVariable Integer idKM) {
        khuyenMaiService.xoaKhuyenMai(idKM);
    }
}
