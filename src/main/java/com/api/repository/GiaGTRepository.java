package com.api.repository;

import com.api.entity.GiaGoiTapEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  21/07/2022
 */
@Repository
public interface GiaGTRepository extends JpaRepository<GiaGoiTapEntity,Integer> {
    List<GiaGoiTapEntity> findByGoiTap_MaGT(String maGT);
    List<GiaGoiTapEntity> findByNhanVien_MaNV(String maNV);
    //List<GiaGoiTapEntity> findByNhanVien_MaGoiTap_MaNV(String maGT,String maNV);
}
