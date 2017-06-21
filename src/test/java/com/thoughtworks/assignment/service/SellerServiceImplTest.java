package com.thoughtworks.assignment.service;

import org.junit.Test;
import org.mockito.InjectMocks;

import static org.junit.Assert.*;

/**
 * Created by vrushali on 6/21/17.
 */
public class SellerServiceImplTest {

    @InjectMocks
    private SellerServiceImpl sellerService = new SellerServiceImpl();

    @Test
    public void shouldReturnNewItemsForSeller() throws Exception {
      //  assertNotNull( sellerService.getNewItemsForSeller("test_id"));
    }

}