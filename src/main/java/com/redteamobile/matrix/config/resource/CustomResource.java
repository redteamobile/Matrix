package com.redteamobile.matrix.config.resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CustomResource {

    // 绑定到资源文件*.properties中的值
    private @Value("${matrix.config.custom.name}") String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
