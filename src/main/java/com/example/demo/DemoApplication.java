package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.SpringFactoriesLoader;

@SpringBootApplication
//也可用另外三个替代
//@Configuration  //相当于把标注的类作为配置文件
//@EnableAutoConfiguration  //帮助SpringBoot应用将所有符合条件的@Configuration配置都加载到当前SpringBoot，并创建对应配置类的Bean，并把该Bean实体交给IoC容器进行管理。
//@ComponentScan  //定义扫描的路径从中找出标识了需要装配的类自动装配到spring的bean容器中
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}


