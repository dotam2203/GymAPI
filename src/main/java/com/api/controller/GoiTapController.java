package com.api.controller;

import com.api.dto.GoiTapDTO;
import com.api.service.GoiTapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  04/07/2022
 */
@RestController
@RequestMapping("/api/goitap")
@CrossOrigin(origins = "*", maxAge = 3600)
public class GoiTapController {
    @Autowired
    private GoiTapService goiTapService;

    @GetMapping("")
    public List<GoiTapDTO> layDSGoiTap() {
        return goiTapService.layDSGoiTap();
    }

    @GetMapping("/dsgt")
    public List<GoiTapDTO> layDSGoiTapTheoLoaiGT(@RequestParam(value = "maLoaiGT") String maLoaiGT) {
        return goiTapService.layDSGoiTapTheoLoaiGT(maLoaiGT);
    }

    @GetMapping("/gt")
    public GoiTapDTO layGoiTap(@RequestParam(value = "maGoiTap") String maGoiTap){
        return goiTapService.layGoiTap(maGoiTap);
    }

    @PostMapping("")
    public GoiTapDTO themGoiTap(@Valid @RequestBody GoiTapDTO goiTapDTO) {
        return goiTapService.themGoiTap(goiTapDTO);
    }

    @PutMapping("")
    public GoiTapDTO suagoiTap(@Valid @RequestBody GoiTapDTO goiTapDTO) {
        return goiTapService.suaGoiTap(goiTapDTO);
    }

    @DeleteMapping("/{maGoiTap}")
    public void xoaGoiTap(@PathVariable String maGoiTap) {
        goiTapService.xoaGoiTap(maGoiTap);
    }
}
