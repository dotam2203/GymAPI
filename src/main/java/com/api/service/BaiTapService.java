package com.api.service;

import com.api.dto.BaiTapDTO;

import java.util.List;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  06/07/2022
 */
public interface BaiTapService {
    List<BaiTapDTO> layDSBaiTap();
    BaiTapDTO layBaiTap(Integer idBT);
    BaiTapDTO themBaiTap(BaiTapDTO baiTapDTO);
    BaiTapDTO suaBaiTap(BaiTapDTO baiTapDTO);
    void xoaBaiTap(Integer idBT);
}
