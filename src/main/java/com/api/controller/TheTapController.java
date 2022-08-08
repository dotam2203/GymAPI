package com.api.controller;

import com.api.dto.TheTapDTO;
import com.api.service.TheTapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/thetap")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TheTapController {
    @Autowired
    private TheTapService theTapService;

    @GetMapping("/getds")
    public List<TheTapDTO> layDSTheTap(){
        return theTapService.layDSTheTap();
    }
    @GetMapping("/getkh")
    public List<TheTapDTO> layDSTheTapTheoKH(@RequestParam(value = "maKH") String maKH){
        return theTapService.layDSTheTapTheoKH(maKH);
    }
    @GetMapping("/get")
    public TheTapDTO layTheTap(@RequestParam(value = "maThe") String maThe){
        return theTapService.layTheTap(maThe);
    }
    @PostMapping("/post")
    public TheTapDTO themTheTap(@Valid @RequestBody TheTapDTO theTapDTO) {
        return theTapService.themTheTap(theTapDTO);
    }
    @PutMapping("/put")
    public TheTapDTO suaTheTap(@Valid @RequestBody TheTapDTO theTapDTO) {
        return theTapService.suaTheTap(theTapDTO);
    }
    @DeleteMapping("/delete/{maThe}")
    public void xoaTheTap(@PathVariable String maThe) {
        theTapService.xoaTheTap(maThe);
    }

}
