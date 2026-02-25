package org.example.sql.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OrderRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final String query;

    @Autowired
    public OrderRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.query = read("query.sql");
    }

    private String read(String fileName) {
        try (var is = new ClassPathResource(fileName).getInputStream();
             var reader = new BufferedReader(new InputStreamReader(is))) {
            return reader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException("Cannot read query file: " + fileName, e);
        }
    }

    public List<String> getProductNamesByCustomerName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return Collections.emptyList();
        }
        var params = Collections.singletonMap("name", name);
        return jdbcTemplate.queryForList(query, params, String.class);
    }
}
