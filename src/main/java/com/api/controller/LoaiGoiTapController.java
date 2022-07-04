package com.api.controller;

import com.api.dto.LoaiGoiTapDTO;
import com.api.service.LoaiGoitapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  03/07/2022
 */
@RestController
@RequestMapping("/api/loaigt")
@CrossOrigin(origins = "*", maxAge = 3600)
public class LoaiGoiTapController {
    @Autowired
    private LoaiGoitapService loaiGoitapService;

    @GetMapping("")
    public List<LoaiGoiTapDTO> layDSLoaiGoiTap() {
        return loaiGoitapService.layDSLoaiGoiTap();
    }

    @PostMapping("")
    public LoaiGoiTapDTO themLoaiGoiTap(@Valid @RequestBody LoaiGoiTapDTO loaiGoitapDTO) {
        return loaiGoitapService.themLoaiGoiTap(loaiGoitapDTO);
    }

    @PutMapping("")
    public LoaiGoiTapDTO suaLoaiGoiTap(@Valid @RequestBody LoaiGoiTapDTO loaiGoitapDTO) {
        return loaiGoitapService.suaLoaiGoiTap(loaiGoitapDTO);
    }

    @DeleteMapping("/{maLoaiGT}")
    public void xoaLoaiGoiTap(@PathVariable String maLoaiGT) {
        loaiGoitapService.xoaLoaiGoiTap(maLoaiGT);
    }


}
