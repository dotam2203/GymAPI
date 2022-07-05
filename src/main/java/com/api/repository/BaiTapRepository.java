package com.api.repository;

import com.api.entity.BaiTapEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  06/07/2022
 */
@Repository
public interface BaiTapRepository extends JpaRepository<BaiTapEntity,String> {
}
