package com.redteamobile.matrix.model.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "UserParam", description = "用户输入的对象")
public class UserParam extends CommonParam {

    @ApiModelProperty(value = "userName", required = true)
    private String name;

    @ApiModelProperty(value = "密码", required = true)
    private String password;

    @ApiModelProperty(value = "性别")
    private Integer sex;

    @ApiModelProperty(value = "用户偏好")
    private UserPre userPre;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public UserPre getUserPre() {
        return userPre;
    }

    public void setUserPre(UserPre userPre) {
        this.userPre = userPre;
    }

    @Override
    public String toString() {
        return "UserParam [name=" + name + ", password=" + password + ", sex=" + sex + ", userPre="
                + userPre + "]";
    }

}
