package ru.netology.jdbctask1.service;

import org.springframework.stereotype.Service;
import ru.netology.jdbctask1.repository.DataRepository;

import java.sql.SQLException;
import java.util.List;

@Service
public class DataService {
    DataRepository repository;

    public DataService(DataRepository repository) {
        this.repository = repository;
    }

    public List<String> getOrders(String name) throws SQLException {
        System.out.println("Customer : " + name);
        return repository.getOrders(name);

    }

}
