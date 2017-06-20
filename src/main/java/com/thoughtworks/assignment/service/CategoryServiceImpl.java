package com.thoughtworks.assignment.service;

import com.thoughtworks.assignment.controller.dto.CategoryDTO;
import com.thoughtworks.assignment.domain.Category;
import com.thoughtworks.assignment.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Created by dibyab on 6/20/17.
 */
@Service
public class CategoryServiceImpl implements  CategoryService {


     @Resource
    private CategoryRepository categoryRepo;


    @Override
    public List<CategoryDTO> getAll()
    {

    List<Category> categories = (List<Category>) categoryRepo.findAll();
     return categoryCategoryDTOFunction.apply(categories);
    }


    public static final Function<List<Category>, List<CategoryDTO>> categoryCategoryDTOFunction = categories -> {

        List<CategoryDTO> result =  new ArrayList<CategoryDTO>();


       for ( Category category : categories) {

           CategoryDTO dto = new CategoryDTO();

           dto.setId(category.getId());
           dto.setCategoryName(category.getCategoryName());

           result.add(dto);
       }

        return result;
    };
}
