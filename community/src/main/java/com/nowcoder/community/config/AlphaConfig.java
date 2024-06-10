package com.nowcoder.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

/**
 * ClassName:AlphaConfig
 * PackageIntelliJ IDEA
 * Description:
 *
 * @Author Lumy
 * Create 2024/6/8 20:13
 * @Version 1.0
 */
@Configuration
public class AlphaConfig {
    @Bean
//    方法装载到容器内
    public SimpleDateFormat impleDateFormat(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    }
}
