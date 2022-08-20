package com.api.controller;

import com.api.dto.GoiTapDTO;
import com.api.service.GoiTapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/goitap")
@CrossOrigin(origins = "*", maxAge = 3600)
public class GoiTapController {
    @Autowired
    private GoiTapService goiTapService;

    @GetMapping("/getds")
    public List<GoiTapDTO> layDSGoiTap() {
        return goiTapService.layDSGoiTap();
    }

    @GetMapping("/getloaigt")
    public List<GoiTapDTO> layDSGoiTapTheoLoaiGT(@RequestParam(value = "idLoaiGT") Integer idLoaiGT) {
        return goiTapService.layDSGoiTapTheoLoaiGT(idLoaiGT);
    }
    @GetMapping("/getgt")
    public GoiTapDTO layGoiTapTheoMaGTVaIdLoaiGT(@RequestParam(value = "maGT") String maGT,@RequestParam(value = "idLoaiGT") Integer idLoaiGT) {
        return goiTapService.layGoiTapTheoMaGTVaIDLoaiGT(maGT,idLoaiGT);
    }
    @GetMapping("/get")
    public GoiTapDTO layGoiTap(@RequestParam(value = "maGT") String maGT){
        return goiTapService.layGoiTap(maGT);
    }

    @PostMapping("/post")
    public GoiTapDTO themGoiTap(@Valid @RequestBody GoiTapDTO goiTapDTO) {
        return goiTapService.themGoiTap(goiTapDTO);
    }

    @PutMapping("/put")
    public GoiTapDTO suagoiTap(@Valid @RequestBody GoiTapDTO goiTapDTO) {
        return goiTapService.suaGoiTap(goiTapDTO);
    }

    @DeleteMapping("/delete/{maGT}")
    public void xoaGoiTap(@PathVariable String maGT) {
        goiTapService.xoaGoiTap(maGT);
    }
}
