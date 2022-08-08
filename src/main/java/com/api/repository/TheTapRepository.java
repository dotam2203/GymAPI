package com.api.repository;

import com.api.entity.TheTapEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheTapRepository extends JpaRepository<TheTapEntity,String> {
    List<TheTapEntity> findByKhachHang_MaKH(String maKH);
}
