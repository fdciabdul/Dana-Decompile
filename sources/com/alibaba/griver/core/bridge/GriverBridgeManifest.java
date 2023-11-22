package com.alibaba.griver.core.bridge;

import java.util.List;

/* loaded from: classes3.dex */
public class GriverBridgeManifest {

    /* renamed from: a  reason: collision with root package name */
    private String f6393a;
    private String b;
    private List<String> c;

    public String getPackageName() {
        return this.f6393a;
    }

    public String getClassName() {
        return this.b;
    }

    public List<String> getActionList() {
        return this.c;
    }

    public void setClassName(String str) {
        this.b = str;
    }

    public void setActionList(List<String> list) {
        this.c = list;
    }

    public GriverBridgeManifest(String str, List<String> list) {
        this.f6393a = "com.alibaba.griver.outer";
        this.b = str;
        this.c = list;
    }

    public GriverBridgeManifest(Class cls, List<String> list) {
        if (cls != null) {
            this.f6393a = cls.getPackage().getName();
            this.b = cls.getName();
        }
        this.c = list;
    }
}
