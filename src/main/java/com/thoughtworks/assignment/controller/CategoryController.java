package com.thoughtworks.assignment.controller;

import com.thoughtworks.assignment.controller.dto.CategoryDTO;
import com.thoughtworks.assignment.domain.Category;
import com.thoughtworks.assignment.domain.Item;
import com.thoughtworks.assignment.service.CategoryService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by vrushali on 6/20/17.
 */
@RestController("/categories")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET,value = "/{id}/items",
            consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Item> getItems(){

        return null;
    }

    @RequestMapping(method = RequestMethod.GET, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<CategoryDTO> getAllCategories(){

        return categoryService.getAll();
    }



}
