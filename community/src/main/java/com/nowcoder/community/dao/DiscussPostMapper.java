package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ClassName:DiscussPostMapper
 * PackageIntelliJ IDEA
 * Description:
 *
 * @Author Lumy
 * Create 2024/6/10 10:13
 * @Version 1.0
 */
@Mapper
public interface DiscussPostMapper {
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);
    // @Param 注解用于给参数取别名
    // 如果只有一个参数 且在<if> 使用  必须加别名
    int selectDiscussPostRows(@Param("userId") int userId);
}
