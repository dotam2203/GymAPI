package com.api.repository;

import com.api.entity.HoaDonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDonEntity, String> {
    List<HoaDonEntity> findByNhanVien_MaNV(String maNV);
    List<HoaDonEntity> findByTheTap_MaThe(String maThe);
}
