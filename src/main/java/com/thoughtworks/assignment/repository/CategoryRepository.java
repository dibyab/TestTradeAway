package com.thoughtworks.assignment.repository;

import com.thoughtworks.assignment.domain.Category;
import com.thoughtworks.assignment.domain.Item;
import com.thoughtworks.assignment.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dibyab on 6/20/17.
 */
@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category,Integer> {

    Category findByCategoryName(String categoryName);
}
