package com.wwp.dao;

import com.wwp.pojo.Test;
import org.apache.ibatis.annotations.Param;

public interface TestMapper {
    Test findById(@Param("value")String id);
}
