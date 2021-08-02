package com.adobe.prj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.adobe.prj.dto.ReportDTO;
import com.adobe.prj.entity.Order;

public interface OrderDao extends JpaRepository<Order, Integer> {
	
	@Query("select new com.adobe.prj.dto.ReportDTO(c.email, c.firstName, o.orderDate, o.total) from Order o inner join o.customer c")
	List<ReportDTO> getReport();
 }


// @Query(value="write sql", nativeQuery=true)