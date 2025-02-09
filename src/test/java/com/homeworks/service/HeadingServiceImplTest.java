package com.homeworks.service;

import com.homeworks.domain.Heading;
import com.homeworks.service.impl.HeadingServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@DataJpaTest
@Sql(scripts = {"classpath:sql_scripts/truncate_tables.sql"},
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS)
//@ContextConfiguration(classes = ConfigApp.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//@Transactional
public class HeadingServiceImplTest {

/*    @BeforeEach
    void cleanDatabase(@Autowired JdbcTemplate jdbcTemplate) {
        jdbcTemplate.execute("DELETE FROM dependent_table");
        jdbcTemplate.execute("DELETE FROM heading");
        jdbcTemplate.execute("ALTER TABLE heading ALTER COLUMN id RESTART WITH 1");
    }*/

    @TestConfiguration
    @ComponentScan(basePackages = "com.*")
    public static class Config {
        @Bean(name = "mvcHandlerMappingIntrospector")
        public HandlerMappingIntrospector mvcHandlerMappingIntrospector() {
            return new HandlerMappingIntrospector();
        }
    }

    @Autowired
/*
    CrudService<Heading> service;
*/
    HeadingServiceImpl service;

    @Test
    //@DirtiesContext
    public void shouldSaveHeading() {
        Heading heading = Heading
                .builder()
                .name("Cars")
                .build();

        service.create(heading);

        Heading heading1 = service.getById(1);

        System.out.println();
    }
}

/**
 * save -> 1
 *  truncate tables
 */
