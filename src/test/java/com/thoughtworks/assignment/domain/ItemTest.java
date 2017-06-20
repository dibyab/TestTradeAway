package com.thoughtworks.assignment.domain;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vrushali on 6/20/17.
 */
public class ItemTest {

    @Test
    public void shouldBeAbleToCreateItem() {
        assertNotNull( new Item("name","desc"));
    }

}