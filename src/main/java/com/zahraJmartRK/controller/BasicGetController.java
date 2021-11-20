package com.zahraJmartRK.controller;

import com.zahraJmartRK.Algorithm;
import com.zahraJmartRK.dbjson.JsonTable;
import com.zahraJmartRK.dbjson.Serializable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public interface BasicGetController<T extends Serializable> {
    @GetMapping("/id")
    default T getById(int id) {
        return Algorithm.<T>find(getJsonTable(), (e) -> e.id == id);
    }

    JsonTable<T> getJsonTable();

    @GetMapping("/page")
    default List<T> getPage(int page, int pageSize) {
        return Algorithm.<T>paginate(getJsonTable(), page, pageSize, e -> true);
    }
}