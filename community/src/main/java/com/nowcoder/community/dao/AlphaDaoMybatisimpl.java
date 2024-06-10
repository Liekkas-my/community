package com.nowcoder.community.dao;

import jakarta.annotation.Priority;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * ClassName:AlphaDaoMybatisimpl
 * PackageIntelliJ IDEA
 * Description:
 *
 * @Author Lumy
 * Create 2024/6/8 17:55
 * @Version 1.0
 */
@Repository("alphaMybatis")
@Primary
public class AlphaDaoMybatisimpl implements AlphaDao{


    @Override
    public String select() {
        return "Mybatis";
    }
}
