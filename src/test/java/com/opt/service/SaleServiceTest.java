package com.opt.service;


import com.opt.exception.CustomerNotFoundException;
import com.opt.repository.CustomerRepository;
import com.opt.repository.SaleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class SaleServiceTest {

    @InjectMocks
    private SaleService saleService;

    @Mock
    private SaleRepository saleRepository;

    @Mock
    private CustomerRepository customerRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetWishList_CustomerNotFound() {
        Long customerId = 1L;
        when(customerRepository.findById(customerId)).thenReturn(Optional.empty());

        assertThrows(CustomerNotFoundException.class, () -> saleService.getWishList(customerId));
    }

    @Test
    public void testGetTotalSalesOfCurrentDay() {
        when(saleRepository.findTotalSalesOfCurrentDay()).thenReturn(100.0);

        Double totalSales = saleService.getTotalSalesOfCurrentDay();
        assertEquals(100.0, totalSales);
    }

    @Test
    public void testGetMaxSaleDay() {
        Date startDate = new Date();
        Date endDate = new Date();
        Object[] maxSaleDayArray = {"2024-07-14", 200.0};
        List<Object[]> maxSaleDay = new ArrayList<>();
        maxSaleDay.add(maxSaleDayArray);

        when(saleRepository.findMaxSaleDay(startDate, endDate)).thenReturn(maxSaleDay);

        List<Object[]> result = saleService.getMaxSaleDay(startDate, endDate);
        assertEquals(maxSaleDay, result);
    }

    @Test
    public void testGetTopSellingItemsOfAllTime() {
        Date startDate = new Date();
        Date endDate = new Date();
        Object[] maxSaleDayArray = {"2024-07-14", 200.0};
        List<Object[]> topSellingItems = new ArrayList<>();
        topSellingItems.add(maxSaleDayArray);

        //List<Object[]> topSellingItems = List.of(new Object[]{"Item1", 1000.0}, new Object[]{"Item2", 800.0});
        Pageable pageable = PageRequest.of(0, 5);
        when(saleRepository.findTopSellingItemsOfAllTime(pageable)).thenReturn(topSellingItems);

        List<Object[]> result = saleService.getTopSellingItemsOfAllTime();
        assertEquals(topSellingItems, result);
    }

    @Test
    public void testGetTopSellingItemsOfLastMonth() {
        Date startDate = new Date();
        Date endDate = new Date();

        Object[] maxSaleDayArray = {"2024-07-14", 200.0};
        List<Object[]> topSellingItemsLastMonth = new ArrayList<>();
        topSellingItemsLastMonth.add(maxSaleDayArray);

   //     List<Object[]> topSellingItemsLastMonth = List.of(new Object[]{"Item1", 50}, new Object[]{"Item2", 40});
        Pageable pageable = PageRequest.of(0, 5);
        when(saleRepository.findTopSellingItemsOfLastMonth(startDate, endDate,pageable)).thenReturn(topSellingItemsLastMonth);

        List<Object[]> result = saleService.getTopSellingItemsOfLastMonth(startDate, endDate);
        assertEquals(topSellingItemsLastMonth, result);
    }
}
