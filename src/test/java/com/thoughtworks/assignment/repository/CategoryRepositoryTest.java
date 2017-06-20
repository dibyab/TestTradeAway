package com.thoughtworks.assignment.repository;

import com.thoughtworks.assignment.domain.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by vrushali on 6/20/17.
 */

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class CategoryRepositoryTest {

    @Resource
    private TestEntityManager testEntityManager;

    @Resource
    private CategoryRepository categoryRepository;

    @Test
    public void shouldBeAbleToSaveCategory() {

        final Category testCategory = categoryRepository.save(new Category("test_category"));
        assertNotNull( testCategory);

        final Category category = testEntityManager.find(Category.class, testCategory.getId());
        assertNotNull( "test_category",category.getCategoryName());
    }

    @Test
    public void shouldFindCategoryByName() throws Exception {
        final Category testCategory = categoryRepository.save(new Category("test_category"));
        testEntityManager.persist( testCategory);

        final Category result = categoryRepository.findByCategoryName("test_category");
        assertNotNull( result);
        assertEquals( "test_category",testCategory.getCategoryName());
    }

    @Test
    public void shouldReturnPaginatedResult() {

        final Category testCategory1 = categoryRepository.save(new Category("test_category1"));
        testEntityManager.persistAndFlush( testCategory1);

        final Category testCategory2 = categoryRepository.save(new Category("test_category2"));
        testEntityManager.persistAndFlush( testCategory2);

        final Category testCategory3 = categoryRepository.save(new Category("test_category3"));
        testEntityManager.persistAndFlush( testCategory3);

        final Category testCategory4 = categoryRepository.save(new Category("test_category4"));
        testEntityManager.persistAndFlush( testCategory4);

        final Category testCategory5 = categoryRepository.save(new Category("test_category5"));
        testEntityManager.persistAndFlush( testCategory5);

        final Page<Category> categoryPage = categoryRepository.findAll(new PageRequest(1, 2));

        assertNotNull( categoryPage);
        assertEquals(5, categoryPage.getTotalElements());
        assertEquals( 3,categoryPage.getTotalPages());


    }

}