package com.api.controller;

import com.api.dto.LoaiGoiTapDTO;
import com.api.service.LoaiGoiTapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/loaigt")
@CrossOrigin(origins = "*", maxAge = 3600)
public class LoaiGoiTapController {
    @Autowired
    private LoaiGoiTapService loaiGoiTapService;

    @GetMapping("/getds")
    public List<LoaiGoiTapDTO> layDSLoaiGoiTap() {
        return loaiGoiTapService.layDSLoaiGoiTap();
    }
    @GetMapping("/get")//get?idLoaiGT=2
    public LoaiGoiTapDTO layLoaiGoiTap(@RequestParam(value = "idLoaiGT") Integer idLoaiGT) {
        return loaiGoiTapService.layLoaiGoiTap(idLoaiGT);
    }

    @PostMapping("/post")
    public LoaiGoiTapDTO themLoaiGoiTap(@Valid @RequestBody LoaiGoiTapDTO loaiGoiTapDTO) {
        return loaiGoiTapService.themLoaiGoiTap(loaiGoiTapDTO);
    }

    @PutMapping("/put")
    public LoaiGoiTapDTO suaLoaiGoiTap(@Valid @RequestBody LoaiGoiTapDTO loaiGoiTapDTO) {
        return loaiGoiTapService.suaLoaiGoiTap(loaiGoiTapDTO);
    }

    @DeleteMapping("/delete/{idLoaiGT}")
    public void xoaLoaiGoiTap(@PathVariable Integer idLoaiGT) {
        loaiGoiTapService.xoaLoaiGoiTap(idLoaiGT);
    }
}
