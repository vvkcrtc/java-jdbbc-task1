package ru.netology.jdbctask1.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.InputStream;

@Repository
public class DataRepository {

    private DataSource dataSource;
    @Autowired
    private NamedParameterJdbcTemplate template;
    String sqlRequest;

    public DataRepository() {
        sqlRequest = read("product_name.sql");
    }

    public List<String> getOrders(String name) throws SQLException {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);

        List<Orders> orders = template.query(sqlRequest, map, (rs, rowNum) -> new Orders(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(4),
                rs.getInt(5)
        ));

        List<String> result = new ArrayList<>();

        if (orders.size() > 0) {
            result.add("Orders "+name+":");
            for (Orders o : orders) {
                result.add(o.toString());
            }
        } else {
            result.add("Not found any order for " + name);
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
