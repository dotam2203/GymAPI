package com.api.repository;

import com.api.entity.GoiTapEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  04/07/2022
 */
@Repository
public interface GoiTapRepository extends JpaRepository<GoiTapEntity,String> {
    List<GoiTapEntity> findByLoaiGT_IdLoaiGT(Integer idLoaiGT);
    /*@Transactional
    @Modifying
    @Query("SELECT a FROM GoiTap a WHERE a.maGT=?1 AND a.LoaiGT.idLoaiGT=?2")
    *///GoiTapEntity findByMaGTAndIdLoaiGT(String maGT, Integer idLoaiGT);
    GoiTapEntity findByMaGTAndLoaiGT_IdLoaiGT(String maGT, Integer idLoaiGT);
}
