package com.thoughtworks.assignment.service;

import com.thoughtworks.assignment.domain.Category;
import com.thoughtworks.assignment.domain.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by vrushali on 6/20/17.
 */
public interface CategoryService {

    Page<Category> getAll(Pageable pageRequest);

    Category save(Category category);
}
