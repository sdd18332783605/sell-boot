package com.neuedu.sell.repository;

import com.neuedu.sell.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {

}
