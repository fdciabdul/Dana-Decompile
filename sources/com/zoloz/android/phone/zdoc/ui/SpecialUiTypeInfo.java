package com.zoloz.android.phone.zdoc.ui;

import com.alibaba.fastjson.annotation.JSONField;
import com.alipay.mobile.zebra.data.BoxData;

/* loaded from: classes2.dex */
public class SpecialUiTypeInfo {
    @JSONField(name = BoxData.ATTR_LAYOUT)
    private String layout;
    @JSONField(name = "name")
    private String name;
    @JSONField(name = "textResId")
    private String testResId;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getLayout() {
        return this.layout;
    }

    public void setLayout(String str) {
        this.layout = str;
    }

    public String getTestResId() {
        return this.testResId;
    }

    public void setTestResId(String str) {
        this.testResId = str;
    }
}
