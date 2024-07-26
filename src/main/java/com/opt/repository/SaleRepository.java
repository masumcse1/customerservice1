package com.opt.repository;


import com.opt.entity.Sale;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    @Query("SELECT SUM(s.totalAmount) FROM Sale s WHERE s.date = CURRENT_DATE")
    Double findTotalSalesOfCurrentDay();

    @Query("SELECT s.date, SUM(s.totalAmount) as total FROM Sale s WHERE s.date BETWEEN :startDate AND :endDate GROUP BY s.date ORDER BY total DESC")
    List<Object[]> findMaxSaleDay(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query("SELECT s.item, SUM(s.totalAmount) as total FROM Sale s GROUP BY s.item ORDER BY total DESC")
    List<Object[]> findTopSellingItemsOfAllTime(Pageable pageable);

    @Query("SELECT s.item, COUNT(s.id) as count FROM Sale s WHERE s.date BETWEEN :startDate AND :endDate GROUP BY s.item ORDER BY count DESC")
    List<Object[]> findTopSellingItemsOfLastMonth(@Param("startDate") Date startDate, @Param("endDate") Date endDate, Pageable pageable);


    @Query(value = "select * from sale s where s.customer_id=:customerid", nativeQuery = true)
    List<Sale> findByCustomer(@Param("customerid") int customerid);

}
