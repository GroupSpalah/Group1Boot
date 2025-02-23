package com.lessons.repository;

import com.lessons.domain.Man;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//@Repository("manRepository")
public interface ManRepository extends JpaRepository<Man, Integer> {
    Man findByName(String name);
    void deleteById(int id);
    //Man findById(int id);

//    Man findByNameAndAge(String name, int age);

    @Query(value = "FROM Man m WHERE m.age = :m_age AND m.name = :m_name")
    @EntityGraph(attributePaths = {"emails", "phone"})
    Man findByNameAndAge(@Param(value = "m_name") String name, @Param(value = "m_age") int age);

    @EntityGraph(attributePaths = {"emails", "phone"})
    Page<Man> findAll(Pageable pageable);

    boolean existsByName(String name);

}
