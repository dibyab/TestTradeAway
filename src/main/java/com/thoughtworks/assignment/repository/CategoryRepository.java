package com.thoughtworks.assignment.repository;

import com.thoughtworks.assignment.domain.Category;
import com.thoughtworks.assignment.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by dibyab on 6/20/17.
 */
public interface CategoryRepository extends CrudRepository<Category,Integer> {


}
