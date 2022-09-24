package com.example.week6;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Book {
    @Id
    private String _id;
    private String name;
    private String category;
    private int price;

    public Book() {}

    public Book(String _id, String name, String category, int price) {
        this._id = _id;
        this.name = name;
        this.category = category;
        this.price = price;
    }
}

