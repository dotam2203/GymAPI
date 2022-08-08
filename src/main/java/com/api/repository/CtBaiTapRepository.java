package com.api.repository;

import com.api.entity.CtBaiTapEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CtBaiTapRepository extends JpaRepository<CtBaiTapEntity,Integer> {
    List<CtBaiTapEntity> findByBaiTap_IdBT(Integer idBT);
    List<CtBaiTapEntity> findByGoiTap_MaGT(String maGT);
}
