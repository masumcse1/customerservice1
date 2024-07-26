package com.opt.contoller;


import com.opt.service.SaleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class SaleControllerTest {

    @InjectMocks
    private SaleController saleController;

    @Mock
    private SaleService saleService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(saleController).build();
    }

    @Test
    public void testGetWishList() throws Exception {
        Long customerId = 1L;

        mockMvc.perform(get("/api/wishlist/{customerId}", customerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetTotalSalesOfCurrentDay() throws Exception {
        when(saleService.getTotalSalesOfCurrentDay()).thenReturn(100.0);

        mockMvc.perform(get("/api/total-sales-today")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }



    @Test
    public void testGetTopSellingItemsOfAllTime() throws Exception {
        mockMvc.perform(get("/api/top-selling-items-all-time")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


}
