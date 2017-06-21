package com.thoughtworks.assignment.service;

import com.thoughtworks.assignment.domain.Category;
import com.thoughtworks.assignment.repository.CategoryRepository;
import com.thoughtworks.assignment.repository.ItemRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by dibyab on 6/20/17.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryRepository categoryRepo;

    @Override
    public Page<Category> getAll(Pageable pageRequest) {
        return categoryRepo.findAll(pageRequest);
    }

    @Override
    public Category save(Category category) {
        return categoryRepo.save(category);
    }
}
