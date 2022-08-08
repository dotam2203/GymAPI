package com.api.controller;

import com.api.dto.CtKhuyenMaiDTO;
import com.api.service.CtKhuyenMaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ctkm")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CtKhuyenMaiController {
    @Autowired
    private CtKhuyenMaiService ctKhuyenMaiService;

    @GetMapping("/getds")
    public List<CtKhuyenMaiDTO> layDSCtKhuyenMai() {
        return ctKhuyenMaiService.layDSCtKhuyenMai();
    }

    @GetMapping("/getgt")
    public List<CtKhuyenMaiDTO> layDSCtKhuyenMaiTheoGT(@RequestParam(value = "maGT") String maGT) {
        return ctKhuyenMaiService.layDSCtKhuyenMaiTheoGT(maGT);
    }

    @GetMapping("/getkm")
    public List<CtKhuyenMaiDTO> layDSCtKhuyenMaiTheoKM(@RequestParam(value = "idKM") Integer idKM) {
        return ctKhuyenMaiService.layDSCtKhuyenMaiTheoKM(idKM);
    }

    @GetMapping("/get")
    public CtKhuyenMaiDTO layCtKhuyenMai(@RequestParam(value = "idCTKM") Integer idCTKM){
        return ctKhuyenMaiService.layCtKhuyenMai(idCTKM);
    }

    @PostMapping("/post")
    public CtKhuyenMaiDTO themCtKhuyenMai(@Valid @RequestBody CtKhuyenMaiDTO ctKhuyenMaiDTO) {
        return ctKhuyenMaiService.themCtKhuyenMai(ctKhuyenMaiDTO);
    }

    @PutMapping("/put")
    public CtKhuyenMaiDTO suaCtKhuyenMai(@Valid @RequestBody CtKhuyenMaiDTO ctKhuyenMaiDTO) {
        return ctKhuyenMaiService.suaCtKhuyenMai(ctKhuyenMaiDTO);
    }

    @DeleteMapping("/delete/{idCTKM}")
    public void xoaCtKhuyenMai(@PathVariable Integer idCTKM) {
        ctKhuyenMaiService.xoaCtKhuyenMai(idCTKM);
    }
}
