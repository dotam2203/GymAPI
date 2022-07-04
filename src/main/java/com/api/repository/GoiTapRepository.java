package com.api.repository;

import com.api.entity.GoiTapEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  04/07/2022
 */
@Repository
public interface GoiTapRepository extends JpaRepository<GoiTapEntity,String> {
}
