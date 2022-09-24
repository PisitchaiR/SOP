package com.example.week6;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
    @Query(value="{name:'?0'}")
    public Book findByName(String name);
    @Query(value="{name:'?0'}", fields = "{'_id':0,'price':1}")
    public Book findByName2(String name);
    @Query(value="{price: {$gt:?0}}", count = true)
    public Integer countMoreThanX(int num);
    public Book updateBook(Book book);
}
