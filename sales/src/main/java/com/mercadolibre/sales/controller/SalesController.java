package com.mercadolibre.sales.controller;

import com.mercadolibre.sales.dto.CreateSalesRequestDTO;
import com.mercadolibre.sales.persistence.domain.Sale;
import com.mercadolibre.sales.service.PublishService;
import com.mercadolibre.sales.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SalesController {

    private SalesService salesService;

    private PublishService publishService;

    @Autowired
    public SalesController(final SalesService salesService,
                           final PublishService publishService) {
        this.salesService = salesService;
        this.publishService = publishService;
    }

    @GetMapping
    public List<Sale> getAllSales() {
        return this.salesService.getAll();
    }

    @PutMapping
    public Sale createSale(@RequestBody CreateSalesRequestDTO request) {

        Sale sale = salesService.createSale(request);

        publishService.notifySalesCreated(sale);

        return sale;
    }
}
