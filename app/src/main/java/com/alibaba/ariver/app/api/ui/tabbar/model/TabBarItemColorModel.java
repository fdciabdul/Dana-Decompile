package com.alibaba.ariver.app.api.ui.tabbar.model;

import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: classes2.dex */
public class TabBarItemColorModel {
    @JSONField

    /* renamed from: a  reason: collision with root package name */
    private String f5979a;
    @JSONField
    private String b;

    public String getIcon() {
        return this.f5979a;
    }

    public void setIcon(String str) {
        this.f5979a = str;
    }

    public String getActiveIcon() {
        return this.b;
    }

    public void setActiveIcon(String str) {
        this.b = str;
    }
}
