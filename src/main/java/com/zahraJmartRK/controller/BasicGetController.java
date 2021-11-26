package com.zahraJmartRK.controller;

import com.zahraJmartRK.dbjson.Serializable;
import com.zahraJmartRK.dbjson.JsonTable;
import com.zahraJmartRK.Algorithm;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public interface BasicGetController <T extends Serializable>{
    @GetMapping("/page")
    default @ResponseBody List<T> getPage(@RequestParam(defaultValue="1") int page, @RequestParam(defaultValue="5") int pageSize){
        return Algorithm.<T>paginate(getJsonTable(),page,pageSize,e -> true);
    }

    @GetMapping("/id")
    default T getById(int id) {
        return Algorithm.<T>find(getJsonTable(), (e) -> e.id==id);
    }


    public abstract JsonTable <T> getJsonTable();

}