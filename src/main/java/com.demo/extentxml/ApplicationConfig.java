package com.demo.extentxml;

/**
 * @Author: Dely
 * @Date: 2019/12/12 15:11
 */

public class ApplicationConfig {
    private String name;

    public ApplicationConfig() {
    }

    public ApplicationConfig(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
