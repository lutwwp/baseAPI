package com.wwp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 开启自动配置，并扫描App类所在包下面的
 * Component（@Service,@Repository,@Controller）注册成Bean
 */
@SpringBootApplication
@MapperScan("com.wwp.dao")
public class App
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class,args);
    }
}
