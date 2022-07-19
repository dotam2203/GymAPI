package com.api.repository;

import com.api.entity.NhanVienEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  19/07/2022
 */
@Repository
public interface NhanVienRepository extends JpaRepository<NhanVienEntity, String> {
}
