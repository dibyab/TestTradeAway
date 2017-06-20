package com.thoughtworks.assignment.controller;

import com.thoughtworks.assignment.controller.dto.CategoryDTO;
import com.thoughtworks.assignment.domain.Category;
import com.thoughtworks.assignment.domain.Item;
import com.thoughtworks.assignment.service.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Created by vrushali on 6/20/17.
 */
@RestController
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    private static final Function<List<Category>, List<CategoryDTO>> categoryCategoryDTOFunction = categories -> {

        List<CategoryDTO> result = new ArrayList<CategoryDTO>();

        for (Category category : categories) {

            CategoryDTO dto = new CategoryDTO();

            dto.setId(category.getId());
            dto.setCategoryName(category.getCategoryName());

            result.add(dto);
        }

        return result;
    };

    @RequestMapping( method = RequestMethod.GET,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Page<CategoryDTO> getAllCategories(@RequestParam(defaultValue = "5") final int pageSize,
                                              @RequestParam(defaultValue = "1") final int pageNum){

        final Page<Category> categoryPage = categoryService.getAll(new PageRequest(pageNum, pageSize));
        final List<CategoryDTO> categoryDTOS = categoryCategoryDTOFunction.apply(categoryPage.getContent());
        return new PageImpl<>(categoryDTOS,new PageRequest(pageNum, pageSize),categoryPage.getTotalElements());
    }

    @RequestMapping(method = RequestMethod.GET,value = "/{categoryId}/items",
            consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Item> getItems(@PathVariable(value = "categoryId") int categoryId){
        return categoryService.getItemsByCategory(categoryId);
    }

    @RequestMapping(
            value = "/categories",
            method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public void create( @RequestBody final Category category){
        categoryService.save(category);
    }


}
