package com.api.controller;

import com.api.dto.LoaiGoiTapDTO;
import com.api.service.LoaiGoiTapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  03/07/2022
 */
@RestController
@RequestMapping("/loaigt")
@CrossOrigin(origins = "*", maxAge = 3600)
public class LoaiGoiTapController {
    @Autowired
    private LoaiGoiTapService loaiGoiTapService;

    @GetMapping("")
    public List<LoaiGoiTapDTO> layDSLoaiGoiTap() {
        return loaiGoiTapService.layDSLoaiGoiTap();
    }
    @GetMapping("/lgt")
    public LoaiGoiTapDTO layLoaiGoiTap(@RequestParam(value = "idLoaiKH") Integer idLoaiKH) {
        return loaiGoiTapService.layLoaiGoiTap(idLoaiKH);
    }

    @PostMapping("")
    public LoaiGoiTapDTO themLoaiGoiTap(@Valid @RequestBody LoaiGoiTapDTO loaiGoiTapDTO) {
        return loaiGoiTapService.themLoaiGoiTap(loaiGoiTapDTO);
    }

    @PutMapping("")
    public LoaiGoiTapDTO suaLoaiGoiTap(@Valid @RequestBody LoaiGoiTapDTO loaiGoiTapDTO) {
        return loaiGoiTapService.suaLoaiGoiTap(loaiGoiTapDTO);
    }

    @DeleteMapping("/{idLoaiGT}")
    public void xoaLoaiGoiTap(@PathVariable Integer idLoaiGT) {
        loaiGoiTapService.xoaLoaiGoiTap(idLoaiGT);
    }
}
