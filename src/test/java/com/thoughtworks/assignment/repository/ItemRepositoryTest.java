package com.thoughtworks.assignment.repository;

import com.thoughtworks.assignment.domain.Category;
import com.thoughtworks.assignment.domain.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by vrushali on 6/21/17.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles(value = "test")
public class ItemRepositoryTest {

    @Resource
    private TestEntityManager testEntityManager;

    @Resource
    private ItemRepository itemRepository;

    @Test
    public void shouldFindByCategoryId() throws Exception {

        Category category = new Category("test_category");
        category.addItem(new Item("test_item1", "description1"));
        category.addItem(new Item("test_item2", "description2"));

        final Category persist = testEntityManager.persistAndFlush(category);

        final List<Item> byCategoryId = itemRepository.findByCategory_Id( persist.getId());

        assertNotNull( byCategoryId);
        assertEquals( 2, byCategoryId.size());
    }


    @Test
    public void shouldSaveItem() {
        assertNotNull(itemRepository.save( new Item("test_item1", "description1")));
    }

    @Test
    public void shouldFindByCategoryName() throws Exception {

        Category category = new Category("test_category");
        category.addItem(new Item("test_item1", "description1"));
        category.addItem(new Item("test_item2", "description2"));

        final Category persist = testEntityManager.persistAndFlush(category);

        final Page<Item> itemPage = itemRepository.findByCategory_CategoryName( "test_category",new PageRequest(0,10));

        assertNotNull( itemPage);
        assertEquals( 1, itemPage.getTotalPages());
        assertEquals( 2, itemPage.getContent().size());
    }

    @Test
    public void shouldFindByCategoryNameWithPagination() throws Exception {

        Category category = new Category("test_category");
        category.addItem(new Item("test_item1", "description1"));
        category.addItem(new Item("test_item2", "description2"));
        category.addItem(new Item("test_item2", "description3"));
        category.addItem(new Item("test_item2", "description4"));
        category.addItem(new Item("test_item2", "description5"));

        final Category persist = testEntityManager.persistAndFlush(category);

        final Page<Item> itemPage = itemRepository.findByCategory_CategoryName( "test_category",new PageRequest(0,2));

        assertNotNull( itemPage);
        assertEquals( 3, itemPage.getTotalPages());
        assertEquals( 2, itemPage.getContent().size());
    }

}