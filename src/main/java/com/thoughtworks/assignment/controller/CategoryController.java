package com.thoughtworks.assignment.controller;

import com.thoughtworks.assignment.domain.Item;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by vrushali on 6/20/17.
 */
@RestController("/categories")
public class CategoryController {


    @RequestMapping(method = RequestMethod.GET,value = "/{id}/items",
            consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Item> getItems(){

        return null;
    }

}
