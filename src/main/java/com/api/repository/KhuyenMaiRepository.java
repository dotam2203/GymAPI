package com.api.repository;

import com.api.entity.KhuyenMaiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KhuyenMaiRepository extends JpaRepository<KhuyenMaiEntity,Integer> {
    List<KhuyenMaiEntity> findByNhanVien_MaNV(String maNV);
}
