package com.alibaba.ariver.kernel.api.security;

/* loaded from: classes6.dex */
public enum DefaultPermission implements Permission {
    ALL("all", "") { // from class: com.alibaba.ariver.kernel.api.security.DefaultPermission.1
    };

    private String authority;
    private String description;

    DefaultPermission(String str, String str2) {
        this.authority = str;
        this.description = str2;
    }

    @Override // com.alibaba.ariver.kernel.api.security.Permission
    public String authority() {
        return this.authority;
    }

    @Override // com.alibaba.ariver.kernel.api.security.Permission
    public String description() {
        return this.description;
    }
}
