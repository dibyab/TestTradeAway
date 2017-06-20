package com.thoughtworks.assignment.repository;

import com.thoughtworks.assignment.domain.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
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

}