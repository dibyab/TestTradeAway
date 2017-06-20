package com.thoughtworks.assignment.service;

import com.thoughtworks.assignment.controller.dto.CategoryDTO;

import java.util.List;

/**
 * Created by vrushali on 6/20/17.
 */
public interface CategoryService {

    List<CategoryDTO> getAll();

}
