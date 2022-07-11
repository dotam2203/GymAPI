package com.api.controller;

import com.api.dto.BaiTapDTO;
import com.api.service.BaiTapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  06/07/2022
 */
@RestController
@RequestMapping("/baitap")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BaiTapController {
    @Autowired
    private BaiTapService baiTapService;

    @GetMapping("")
    public List<BaiTapDTO> layDSBaiTap() {
        return baiTapService.layDSBaiTap();
    }

    @PostMapping("")
    public BaiTapDTO themBaiTap(@Valid @RequestBody BaiTapDTO baiTapDTO) {
        return baiTapService.themBaiTap(baiTapDTO);
    }

    @PutMapping("")
    public BaiTapDTO suaBaiTap(@Valid @RequestBody BaiTapDTO baiTapDTO) {
        return baiTapService.suaBaiTap(baiTapDTO);
    }

    @DeleteMapping("/{idBT}")
    public void xoaBaiTap(@PathVariable Integer idBT) {
        baiTapService.xoaBaiTap(idBT);
    }
}
