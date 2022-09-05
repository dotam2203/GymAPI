package com.api.controller;

import com.api.dto.CtTheTapDTO;
import com.api.service.CtTheTapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/ctthe")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CtTheTapController {
    @Autowired
    private CtTheTapService ctTheTapService;

    @GetMapping("/getds")//getds?ngayDB=2022-09-01&ngayKT=2022-09-30
    public List<CtTheTapDTO> layDSCtTheTap() {
        return ctTheTapService.layDSCtTheTap();
    }
    @GetMapping("/sort_thang")//sort_thang?ngayDB=2022-09-01&ngayKT=2022-09-30
    public List<CtTheTapDTO> layLocDSCtTheTapThang(@RequestParam(value = "ngayBD") Date ngayBD, @RequestParam(value = "ngayKT") Date ngayKT) {
        return ctTheTapService.locDSCtTheTapThang(ngayBD,ngayKT);
    }
    @GetMapping("/sort_dv")//sort_dv?ngayDB=2022-09-01&ngayKT=2022-09-30
    public List<CtTheTapDTO> locDSCtTheTapTheoDV(@RequestParam(value = "ngayBD") Date ngayBD, @RequestParam(value = "ngayKT") Date ngayKT) {
        return ctTheTapService.locDSCtTheTapTheoDV(ngayBD,ngayKT);
    }

    @GetMapping("/gethd")
    public List<CtTheTapDTO> layDSCtTheTapTheoHD(@RequestParam(value = "maHD") String maHD) {
        return ctTheTapService.layDSCtTheTapTheoHD(maHD);
    }

    @GetMapping("/getgt")
    public List<CtTheTapDTO> layDSCtTheTapTheoGT(@RequestParam(value = "maGT") String maGT) {
        return ctTheTapService.layDSCtTheTapTheoGT(maGT);
    }

    @GetMapping("/getthe")
    public CtTheTapDTO layDSCtTheTapTheoThe(@RequestParam(value = "maThe") String maThe) {
        return ctTheTapService.layCtTheTapTheoThe(maThe);
    }

    @GetMapping("/get")
    public CtTheTapDTO layCtTheTap(@RequestParam(value = "id") Integer id) {
        return ctTheTapService.layCtTheTap(id);
    }

    @PostMapping("/post")
    public CtTheTapDTO themCtTheTap(@Valid @RequestBody CtTheTapDTO ctTheTapDTO) {
        return ctTheTapService.themCtTheTap(ctTheTapDTO);
    }

    @PutMapping("/put")
    public CtTheTapDTO suaCtTheTap(@Valid @RequestBody CtTheTapDTO ctTheTapDTO) {
        return ctTheTapService.suaCtTheTap(ctTheTapDTO);
    }

    @DeleteMapping("/delete/{idCTThe}")
    public void xoaCtTheTap(@PathVariable Integer idCTThe) {
        ctTheTapService.xoaCtTheTap(idCTThe);
    }
}
