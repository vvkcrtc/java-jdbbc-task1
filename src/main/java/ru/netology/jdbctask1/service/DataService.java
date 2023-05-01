package ru.netology.jdbctask1.service;

import org.springframework.stereotype.Service;
import ru.netology.jdbctask1.repository.DataRepository;

import java.sql.SQLException;

@Service
public class DataService {
    DataRepository repository;
    public DataService(DataRepository repository) {
        this.repository = repository;
    }

    public String getName(String name) throws SQLException {
        System.out.println("Customer : "+name);
        return repository.getOrder(name);

    }

}
