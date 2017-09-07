package com.redteamobile.matrix.model.page;

import java.util.List;

/**
 * <p>
 * 一个返回给客户端的实体定义，我们不应该直接返回ResponseStruct,
 * </p>
 * <p>
 * ResponseStruct只是一个最简单返回的示范，包含了确定需要存在的公共字段
 * </p>
 */
public class SwaggerSamplePage extends ResponseStruct {

    private static final long serialVersionUID = -5394585048241102915L;

    private List<String> countries;

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

}
