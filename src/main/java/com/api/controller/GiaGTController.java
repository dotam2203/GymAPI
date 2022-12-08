package com.api.controller;
import com.api.dto.GiaGoiTapDTO;
import com.api.service.GiaGTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/gia")
@CrossOrigin(origins = "*", maxAge = 3600)
public class GiaGTController {
    @Autowired
    private GiaGTService giaGTService;
    @GetMapping("/getds")
    public List<GiaGoiTapDTO> layDSGia() {
        return giaGTService.layDSGia();
    }
    @GetMapping("/getgt")//gia/getgt?maGT=GT01
    public List<GiaGoiTapDTO> layDSGiaTheoGoiTap(@RequestParam(value = "maGT") String maGT) {
        return giaGTService.layDSGiaTheoGoiTap(maGT);
    }
    @GetMapping("/getnv")
    public List<GiaGoiTapDTO> layDSGiaTheoNhanVien(@RequestParam(value = "maNV") String maNV) {
        return giaGTService.layDSGiaTheoNhanVien(maNV);
    }
    @GetMapping("/get")//gia/get?idGia=1
    public GiaGoiTapDTO layGia(@RequestParam(value = "idGia") Integer idGia){
        return giaGTService.layGia(idGia);
    }
    @PostMapping("/post")
    public GiaGoiTapDTO themGia(@Valid @RequestBody GiaGoiTapDTO giaGT) {
        return giaGTService.themGia(giaGT);
    }
    @PutMapping("/put")
    public GiaGoiTapDTO suaGia(@Valid @RequestBody GiaGoiTapDTO giaGT) {
        return giaGTService.suaGia(giaGT);
    }
    @DeleteMapping("/delete/{idGia}")
    public void xoaGia(@PathVariable Integer idGia) {
        giaGTService.xoaGia(idGia);
    }
}
