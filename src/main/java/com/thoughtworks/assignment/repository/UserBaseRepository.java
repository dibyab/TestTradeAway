package com.thoughtworks.assignment.repository;

import com.thoughtworks.assignment.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

/**
 * Created by vrushali on 6/16/17.
 */
@NoRepositoryBean
public interface UserBaseRepository<T extends User> extends CrudRepository<T,Integer> {

    T findByUsername(String userName);

    T findByEmail(String email);
}
