package com.thoughtworks.assignment.repository;

import com.thoughtworks.assignment.domain.Seller;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vrushali on 6/21/17.
 */
@Transactional
public interface SellerRepository extends UserBaseRepository<Seller> {
}
