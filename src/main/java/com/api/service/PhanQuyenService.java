package com.api.service;

import com.api.dto.PhanQuyenDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  04/07/2022
 */
public interface PhanQuyenService {
    List<PhanQuyenDTO> layDSQuyen();
    PhanQuyenDTO layQuyen(String maQuyen);
    PhanQuyenDTO themQuyen(PhanQuyenDTO phanQuyenDTO);
    PhanQuyenDTO suaQuyen(PhanQuyenDTO phanQuyenDTO);
    void xoaQuyen(String maQuyen);
}
