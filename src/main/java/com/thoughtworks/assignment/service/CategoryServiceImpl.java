package com.thoughtworks.assignment.service;

import com.thoughtworks.assignment.controller.dto.CategoryDTO;
import com.thoughtworks.assignment.domain.Category;
import com.thoughtworks.assignment.domain.Item;
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
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryRepository categoryRepo;

    @Override
    public List<Category> getAll() {
        return (List<Category>) categoryRepo.findAll();
    }

    @Override
    public List<Item> getItemsByCategory(int categoryId) {
        return null;
    }
}
