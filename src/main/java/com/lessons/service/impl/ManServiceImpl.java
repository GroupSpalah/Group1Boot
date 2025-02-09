package com.lessons.service.impl;

import com.lessons.domain.Man;
import com.lessons.repository.ManRepository;
import com.lessons.service.CrudService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.FileAlreadyExistsException;
import java.util.List;

@Service
@Transactional
public class ManServiceImpl implements CrudService<Man> {

    ManRepository repository;

    public ManServiceImpl(ManRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Man man) {
        useTransaction();
//        man.getEmails().forEach(email -> email.setMan(man));
        
        repository.save(man);
    }

    @Transactional(propagation = Propagation.NEVER)
    public void useTransaction() {
        System.out.println();
    }

    @Override
    public void update(Man man) {
        repository.save(man);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Transactional(readOnly = true, noRollbackFor = {NullPointerException.class},
            rollbackFor = FileAlreadyExistsException.class)
    @Override
    public Man findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public Man findByAgeAndName(int age, String name) {
        return repository.findByNameAndAge(name, age);
    }

    @Override
    public List<Man> usePagination(int page, int size) {

        PageRequest request = PageRequest.of(page, size);

        List<Man> all = repository.findAll(request).getContent();

        return all;
    }
}
