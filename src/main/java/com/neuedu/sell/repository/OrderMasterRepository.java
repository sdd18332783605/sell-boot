package com.neuedu.sell.repository;

import com.neuedu.sell.entity.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;




public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {

    /**
     * 根据微信OpenId查询订单信息
     * @param id
     * @param pageable
     * @return
     */
    Page<OrderMaster> findByBuyerOpenid(String id, Pageable pageable);
}
