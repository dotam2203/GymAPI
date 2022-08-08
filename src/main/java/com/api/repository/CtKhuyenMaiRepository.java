package com.api.repository;

import com.api.entity.CtKhuyenMaiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CtKhuyenMaiRepository extends JpaRepository<CtKhuyenMaiEntity,Integer> {
    List<CtKhuyenMaiEntity> findByGoiTap_MaGT(String maGT);
    List<CtKhuyenMaiEntity> findByKhuyenMai_IdKM(Integer idKM);
}
