package com.thoughtworks.assignment.repository;

import com.thoughtworks.assignment.domain.Buyer;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vrushali on 6/21/17.
 */
@Transactional
public interface BuyerRepository extends UserBaseRepository<Buyer> {
}
