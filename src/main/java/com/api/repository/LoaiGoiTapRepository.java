package com.api.repository;

import com.api.entity.LoaiGoiTapEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  03/07/2022
 */
@Repository
public interface LoaiGoiTapRepository extends JpaRepository<LoaiGoiTapEntity,Integer> {
}
