package component.dev.andersoncontreira.trainingddd.infrastructure.persistence.hibernate.repositories;

import component.AbstractComponentTestCase;
import dev.andersoncontreira.trainingddd.application.utils.ObjectUtils;
import dev.andersoncontreira.trainingddd.domain.entities.Category;
import dev.andersoncontreira.trainingddd.infrastructure.persistence.hibernate.repositories.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

class CategoryRepositoryTest extends AbstractComponentTestCase {
    CategoryRepository categoryRepository;
    @BeforeEach
    void setUp() {
        categoryRepository = (CategoryRepository) container.getBean(CategoryRepository.class);
    }

    @Test
    void list() {
        Class<?> currentClass = new Object() {}.getClass();
        logger.info(String.format("Running test: %s::%s - %s", getClassName(currentClass), getMethodName(currentClass), null));

        categoryRepository.list();
        Assertions.assertTrue(true);
    }

    @Test
    void find() {
        Class<?> currentClass = new Object() {}.getClass();
        logger.info(String.format("Running test: %s::%s - %s", getClassName(currentClass), getMethodName(currentClass), null));

        Category category = categoryRepository.find(1);
        logger.info(String.format("category: %s", ObjectUtils.object2Json(category)));
        Assertions.assertNotNull(category);
        assertThat(category, instanceOf(Category.class));
    }

    @Test
    void testFind() {
    }

    @Test
    void testList() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void deleted() {
    }
}