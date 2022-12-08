package com.api.controller;

import com.api.dto.LoaiKhachHangDTO;
import com.api.service.LoaiKHService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/loaikh")
@CrossOrigin(origins = "*", maxAge = 3600)
public class LoaiKHController {
    @Autowired
    private LoaiKHService loaiKHService;
    @GetMapping("/getds")
    public List<LoaiKhachHangDTO> layDSLoaiKH() {
        return loaiKHService.layDSLoaiKH();
    }
    @GetMapping("/get") // api/get?idLoaiKH=1
    public LoaiKhachHangDTO layLoaiKH(@RequestParam(value = "idLoaiKH") Integer idLoaiKH){
        return loaiKHService.layLoaiKH(idLoaiKH);
    }
    @PostMapping("/post")
    public LoaiKhachHangDTO themLoaiKH(@Valid @RequestBody LoaiKhachHangDTO loaiKhachHangDTO) {
        return loaiKHService.themLoaiKH(loaiKhachHangDTO);
    }
    @PutMapping("/put")
    public LoaiKhachHangDTO suaLoaiKH(@Valid @RequestBody LoaiKhachHangDTO loaiKhachHangDTO) {
        return loaiKHService.suaLoaiKH(loaiKhachHangDTO);
    }
    @DeleteMapping("/delete/{idLoaiKH}")
    public void xoaLoaiKH(@PathVariable Integer idLoaiKH) {
        loaiKHService.xoaLoaiKH(idLoaiKH);
    }
}
