package com.redteamobile.matrix.model.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "UserPre", description = "用户偏好")
public class UserPre {

    @ApiModelProperty(value = "浏览器", required = true)
    private String browser;

    @ApiModelProperty(value = "输入法", required = true)
    private String password;

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserPre [browser=" + browser + ", password=" + password + "]";
    }

}
