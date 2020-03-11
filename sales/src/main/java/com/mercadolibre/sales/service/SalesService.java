package com.mercadolibre.sales.service;

import com.mercadolibre.sales.dto.CreateSalesRequestDTO;
import com.mercadolibre.sales.persistence.domain.Sale;
import com.mercadolibre.sales.persistence.repository.SalesRepository;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Calendar;
import java.util.List;
import java.util.Objects;

@Service
public class SalesService {

    private static final Logger log = LoggerFactory.getLogger(SalesService.class);

    private final String USER_SERVICE = "users";

    private SalesRepository salesRepository;

    private RestTemplate restTemplate;

    private EurekaClient eurekaClient;

    @Autowired
    public SalesService(final SalesRepository salesRepository,
                        @Qualifier("eurekaClient") final EurekaClient discoveryClient) {
        this.salesRepository = salesRepository;
        this.eurekaClient = discoveryClient;
        restTemplate = new RestTemplate();

    }

    public List<Sale> getAll() {
        return this.salesRepository.findAll();
    }

    public Sale createSale(CreateSalesRequestDTO request) {

        //Find the user
        String userId = findUserById(request.getUsername());

        Sale sale = new Sale();
        sale.setAmount(request.getAmount());
        sale.setUserId(userId);
        sale.setDate(Calendar.getInstance().getTime());
        return salesRepository.save(sale);
    }


    private String findUserById(String userId) {

        //Find the User Microservice
        InstanceInfo userInstance = eurekaClient.getApplication(USER_SERVICE).getInstances().get(0);

        //Get the service URL
        String serviceUrl = String.format("http://%s:%s/findByName?username=%s",userInstance.getIPAddr(), userInstance.getPort(),userId);

        log.info("User service url: {}", serviceUrl);

        //Get the user
        ResponseEntity<JSONObject> response = restTemplate.getForEntity(serviceUrl, JSONObject.class);

        log.info("Response: {}", response.getBody());

        return (String) Objects.requireNonNull(response.getBody()).get("id");

    }
}
