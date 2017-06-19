package com.thoughtworks.assignment.repository;

import com.thoughtworks.assignment.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by vrushali on 6/16/17.
 */
@Repository
public interface UserRepository extends CrudRepository<User,Integer> {

    User findByUsername(String userName);

    User findByEmail(String email);
}
