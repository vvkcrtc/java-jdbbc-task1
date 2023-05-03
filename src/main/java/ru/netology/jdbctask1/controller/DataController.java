package ru.netology.jdbctask1.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.jdbctask1.service.DataService;

import java.sql.SQLException;
import java.util.List;

//@CrossOrigin
@RestController
public class DataController {
    DataService service;

    public DataController(DataService service) {
        this.service = service;
    }

    @GetMapping("/products/fetch-product")
    public List<String> getOrders(@RequestParam("name") @Validated String name) throws SQLException {
        return service.getOrders(name);
    }
}
