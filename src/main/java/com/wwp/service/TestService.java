package com.wwp.service;

import com.wwp.dao.TestMapper;
import com.wwp.pojo.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TestService {
    @Autowired
    private TestMapper testMapper;

    public Test findById(String id) {
        return testMapper.findById(id);
    }
}
