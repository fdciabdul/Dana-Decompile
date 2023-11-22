package com.alibaba.ariver.permission.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class ApiPermissionInfo {

    /* renamed from: a  reason: collision with root package name */
    private boolean f6181a = false;
    private Map<String, List<String>> b = new HashMap();
    private Map<String, String> c = new HashMap();

    public boolean isHasPermissionFile() {
        return this.f6181a;
    }

    public void setHasPermissionFile(boolean z) {
        this.f6181a = z;
    }

    public List<String> getApiLevelList(String str) {
        return this.b.get(str);
    }

    public void setApiLevelList(String str, List<String> list) {
        this.b.put(str, list);
    }

    public String getApiLevelStr(String str) {
        return this.c.get(str);
    }

    public void setApiLevelStr(String str, String str2) {
        this.c.put(str, str2);
    }

    public void clear() {
        this.b.clear();
        this.b = null;
        this.c.clear();
        this.c = null;
    }
}
