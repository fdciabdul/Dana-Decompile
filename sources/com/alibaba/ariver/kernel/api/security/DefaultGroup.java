package com.alibaba.ariver.kernel.api.security;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public enum DefaultGroup implements Group {
    INTERNAL("internal", "first party"),
    PARTNER("partner", "second party"),
    EXTERNAL("external", "third party");

    private String description;
    private String groupName;
    private Map<String, Permission> permissions;

    DefaultGroup(String str, String str2) {
        this.groupName = str;
        this.description = str2;
    }

    @Override // com.alibaba.ariver.kernel.api.security.Group
    public final String groupName() {
        return this.groupName;
    }

    @Override // com.alibaba.ariver.kernel.api.security.Group
    public final String description() {
        return this.description;
    }

    @Override // com.alibaba.ariver.kernel.api.security.Group
    public final void assignPermissions(Map<String, ? extends Permission> map) {
        if (this.permissions == null) {
            this.permissions = new HashMap();
        }
        this.permissions.putAll(map);
    }

    @Override // com.alibaba.ariver.kernel.api.security.Group
    public final Map<String, ? extends Permission> permissions() {
        return this.permissions;
    }
}
