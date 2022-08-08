package com.api.controller;

import com.api.dto.CtBaiTapDTO;
import com.api.service.CtBaiTapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ctbt")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CtBaiTapController {
    @Autowired
    private CtBaiTapService ctBaiTapService;

    @GetMapping("/getds")
    public List<CtBaiTapDTO> layDSCtBaiTap() {
        return ctBaiTapService.layDSCtBaiTap();
    }

    @GetMapping("/getgt")
    public List<CtBaiTapDTO> layDSCtBaiTapTheoGT(@RequestParam(value = "maGT") String maGT) {
        return ctBaiTapService.layDSCtBaiTapTheoGT(maGT);
    }
    @GetMapping("/getbt")
    public List<CtBaiTapDTO> layDSCtBaiTapTheoBT(@RequestParam(value = "idBT") Integer idBT) {
        return ctBaiTapService.layDSCtBaiTapTheoBT(idBT);
    }

    @GetMapping("/get")
    public CtBaiTapDTO layCtBaiTap(@RequestParam(value = "idCTBT") Integer idCTBT){
        return ctBaiTapService.layCtBaiTap(idCTBT);
    }

    @PostMapping("/post")
    public CtBaiTapDTO themCtBaiTap(@Valid @RequestBody CtBaiTapDTO ctBaiTapDTO) {
        return ctBaiTapService.themCtBaiTap(ctBaiTapDTO);
    }

    @PutMapping("/put")
    public CtBaiTapDTO suaCtBaiTap(@Valid @RequestBody CtBaiTapDTO ctBaiTapDTO) {
        return ctBaiTapService.suaCtBaiTap(ctBaiTapDTO);
    }

    @DeleteMapping("/delete/{idCTBT}")
    public void xoaCtBaiTap(@PathVariable Integer idCTBT) {
        ctBaiTapService.xoaCtBaiTap(idCTBT);
    }
}
