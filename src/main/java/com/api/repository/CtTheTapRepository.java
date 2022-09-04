package com.api.repository;

import com.api.entity.CtTheTapEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface CtTheTapRepository extends JpaRepository<CtTheTapEntity,Integer> {
    List<CtTheTapEntity> findByHoaDon_MaHD(String maHD);
    CtTheTapEntity findByTheTap_MaThe(String maThe);
    List<CtTheTapEntity> findByGoiTap_MaGT(String maGT);
}
