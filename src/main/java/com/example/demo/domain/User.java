package com.example.demo.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName: User
 * @Description:
 * @Author liminchuan
 * @Date:Create： 2021/3/3 16:28
 */
@Component
@ConfigurationProperties(prefix = "user")
public class User {
    String bigName;
    int age;

    public String getBigName() {
        return bigName;
    }

    public void setBigName(String bigName) {
        this.bigName = bigName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        StringBuilder bulider = new StringBuilder("User [");
        bulider.append("name=");
        bulider.append(bigName);
        bulider.append(",age=");
        bulider.append(age);
        bulider.append(']');
        return bulider.toString();
    }
}
