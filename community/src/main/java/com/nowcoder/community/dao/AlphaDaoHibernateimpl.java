package com.nowcoder.community.dao;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ClassName:AlphaDaoHibernateimpl
 * PackageIntelliJ IDEA
 * Description:
 *
 * @Author Lumy
 * Create 2024/6/8 17:51
 * @Version 1.0
 */

@Repository("alphaHibernate")
public class AlphaDaoHibernateimpl implements  AlphaDao{

    @Override
    public String select() {
        return "Hibernate";
    }
}
