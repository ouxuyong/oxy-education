package com.oxygen.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.pagehelper.Page;
import lombok.Data;

/**
 * 分页实体
 * @author oxy
 */
@Data
public class OxyResPage {
    private long total;
    private Integer pages;
    public OxyResPage() {
    }

    @JsonIgnore
    public static OxyResPage of(long total, Integer pages) {
        OxyResPage page = new OxyResPage();
        page.total = total;
        page.pages = pages;

        return page;
    }

    @JsonIgnore
    public static OxyResPage of(Page<?> pageInfo) {
        return of(pageInfo.getTotal(), pageInfo.getPages());
    }
}
