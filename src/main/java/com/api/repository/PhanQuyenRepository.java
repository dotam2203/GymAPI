package com.api.repository;

import com.api.entity.PhanQuyenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  06/07/2022
 */
@Repository
public interface PhanQuyenRepository extends JpaRepository<PhanQuyenEntity,String> {
}
