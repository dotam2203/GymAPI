package com.api.repository;

import com.api.entity.KhachHangEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  04/07/2022
 */
@Repository
public interface KhachHangRepository extends JpaRepository<KhachHangEntity,String> {
    List<KhachHangEntity> findByLoaiKH_IdLoaiKH(Integer idLoaiKH);
}
