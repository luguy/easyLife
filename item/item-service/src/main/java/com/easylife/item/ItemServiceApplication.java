package com.easylife.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author luguy
 * @date 2019/9/28 - 0:51
 * @Description:
 * @Version:
 */

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.easylife.item.mapper")
public class ItemServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItemServiceApplication.class, args);
    }

}
