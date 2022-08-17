package com.api.repository;

import com.api.entity.TaiKhoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  19/07/2022
 */
@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoanEntity,String> {
    List<TaiKhoanEntity> findByPhanQuyen_MaQuyen(String maQuyen);
    TaiKhoanEntity findByNhanVien_MaNV(String maNV);
}
