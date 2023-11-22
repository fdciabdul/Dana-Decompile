package com.alibaba.griver.core.model.applist;

import java.io.Serializable;

/* loaded from: classes6.dex */
public class CategoryInfo implements Serializable {
    private String category;
    private String category2;
    private String category3;
    private String categoryCode2;
    private String categoryCode3;
    private String categoryId;

    public CategoryInfo() {
    }

    public CategoryInfo(String str, String str2) {
        this.category = str;
        this.categoryId = str2;
    }

    public String getCategoryCode2() {
        return this.categoryCode2;
    }

    public void setCategoryCode2(String str) {
        this.categoryCode2 = str;
    }

    public String getCategoryCode3() {
        return this.categoryCode3;
    }

    public void setCategoryCode3(String str) {
        this.categoryCode3 = str;
    }

    public String getCategory2() {
        return this.category2;
    }

    public void setCategory2(String str) {
        this.category2 = str;
    }

    public String getCategory3() {
        return this.category3;
    }

    public void setCategory3(String str) {
        this.category3 = str;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public String getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(String str) {
        this.categoryId = str;
    }
}
