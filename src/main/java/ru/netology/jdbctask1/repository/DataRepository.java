package ru.netology.jdbctask1.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.stream.Collectors;
import java.io.InputStream;

@Repository
public class DataRepository {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public DataRepository() {

    }

    public String getOrder(String name) throws SQLException {
        var connection = dataSource.getConnection();
        var statement = connection.createStatement();

//        ResultSet resultSet = statement.executeQuery("SELECT * FROM netology.Orders INNER JOIN netology.Customers\n" +
//                "ON (netology.Orders.customer_id = netology.Customers.id)\n" +
//                "WHERE lower(Customers.name)="+"'"+name+"'");

        String sqlRequest = read("product_name.sql").replace("?", name);
        ResultSet resultSet = statement.executeQuery(sqlRequest);

        String result = "";

        while(resultSet.next()) {
            int id = resultSet.getInt(1);
            String date = resultSet.getString(2);
            String product = resultSet.getString(4);
            System.out.println("Result : id : "+id+" date : "+date);
            result = name +" "+id+" "+date+" "+product;
        }

        return result;
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
