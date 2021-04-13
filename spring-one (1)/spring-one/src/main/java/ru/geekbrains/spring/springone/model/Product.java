package ru.geekbrains.spring.springone.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private long id;
    private int cost;
    private String name;
}
