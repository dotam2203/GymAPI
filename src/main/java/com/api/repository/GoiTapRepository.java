package com.api.repository;

import com.api.entity.GoiTapEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  04/07/2022
 */
@Repository
public interface GoiTapRepository extends JpaRepository<GoiTapEntity,String> {
    List<GoiTapEntity> findByLoaiGT_IdLoaiGT(Integer idLoaiGT);
    //GoiTapEntity findByMaGTAndLoaiGT_IdLoaiGT(String maGT, Integer idLoaiGT);
    @Query(value = "SELECT * FROM GoiTap WHERE maGT = :maGT and loaiGT.idLoaiGT = :idLoaiGT", nativeQuery = true)
    GoiTapEntity findGoiTapByParams(@Param("maGT") String maGT, @Param("idLoaiGT") Integer idLoaiGT);
}
