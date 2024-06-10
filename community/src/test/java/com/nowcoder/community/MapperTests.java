package com.nowcoder.community;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * ClassName:MapperTests
 * PackageIntelliJ IDEA
 * Description:
 * Create 2024/6/10 8:13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes =  CommunityApplication.class)
public class MapperTests {
    @Autowired
    private UserMapper usermapper;
    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Test
    public void testSelectUser(){
        User user = usermapper.selectById(101);
        System.out.println(user);
        user = usermapper.selectByName("liubei");
        System.out.println(user);
        user = usermapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user);
    }
    @Test
    public void testInsertUser(){
        User user= new User();
        user.setUsername("lumengya");
        user.setPassword("123456");
        user.setSalt("abd");
        user.setEmail("test@qq.com");
        user.setHeaderUrl("http://www.nowcoder.com/101.png");
        user.setCreateTime(new Date());

        int rows = usermapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }
    @Test
    public void updateUser(){
        int rows = usermapper.updateStatus(150,1);
        System.out.println(rows);
        rows = usermapper.updateHeader(150,"http://www.nowcoder.com/102.png");
        System.out.println(rows);
        rows = usermapper.updatePassword(150,"25251");
        System.out.println(rows);
    }

    @Test
    public void testSelectPosts(){
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(149,0,10);
        for(DiscussPost post:list){
            System.out.println(post);
        }
        int rows = discussPostMapper.selectDiscussPostRows(149);
        System.out.println(rows);


    }


}
