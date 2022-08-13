package com.api.repository;

import com.api.entity.GiaGoiTapEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface GiaGTRepository extends JpaRepository<GiaGoiTapEntity,Integer> {
    List<GiaGoiTapEntity> findByGoiTap_MaGT(String maGT);
    List<GiaGoiTapEntity> findByNhanVien_MaNV(String maNV);

    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM GIAGOITAP WHERE MaGT =: maGT AND MaNV =: maNV", nativeQuery = true)
    List<GiaGoiTapEntity> findGiaGoiTap(@Param("maGT") String maGT, @Param("maNV") String maNV);
}
