package com.alibaba.griver.core.model.applist;

import java.io.Serializable;

/* loaded from: classes6.dex */
public class AppCategory implements Serializable {
    private String category2;
    private String category3;
    private String categoryCode2;
    private String categoryCode3;
    private String identifier;
    private String name;

    public AppCategory(String str, String str2, String str3, String str4, String str5, String str6) {
        this.name = str;
        this.identifier = str2;
        this.category2 = str3;
        this.category3 = str4;
        this.categoryCode2 = str5;
        this.categoryCode3 = str6;
    }

    public AppCategory() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(String str) {
        this.identifier = str;
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
}
