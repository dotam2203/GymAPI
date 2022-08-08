package com.api.controller;

import com.api.dto.BaiTapDTO;
import com.api.service.BaiTapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/baitap")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BaiTapController {
    @Autowired
    private BaiTapService baiTapService;

    @GetMapping("/getds")
    public List<BaiTapDTO> layDSBaiTap() {
        return baiTapService.layDSBaiTap();
    }

    @GetMapping("/get")
    public BaiTapDTO layBaiTap(@RequestParam(value = "idBT") Integer idBT) {
        return baiTapService.layBaiTap(idBT);
    }

    @PostMapping("/post")
    public BaiTapDTO themBaiTap(@Valid @RequestBody BaiTapDTO baiTapDTO) {
        return baiTapService.themBaiTap(baiTapDTO);
    }

    @PutMapping("/put")
    public BaiTapDTO suaBaiTap(@Valid @RequestBody BaiTapDTO baiTapDTO) {
        return baiTapService.suaBaiTap(baiTapDTO);
    }

    @DeleteMapping("/delete/{idBT}")
    public void xoaBaiTap(@PathVariable Integer idBT) {
        baiTapService.xoaBaiTap(idBT);
    }
}
