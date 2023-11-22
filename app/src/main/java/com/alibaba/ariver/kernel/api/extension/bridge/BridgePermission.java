package com.alibaba.ariver.kernel.api.extension.bridge;

import com.alibaba.ariver.kernel.api.security.Permission;

/* loaded from: classes6.dex */
public class BridgePermission implements Permission {

    /* renamed from: a  reason: collision with root package name */
    private String f6085a;
    private String b;

    public BridgePermission(String str, String str2) {
        this.f6085a = str;
        this.b = str2;
    }

    @Override // com.alibaba.ariver.kernel.api.security.Permission
    public String authority() {
        return this.f6085a;
    }

    @Override // com.alibaba.ariver.kernel.api.security.Permission
    public String description() {
        return this.b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("authority=");
        sb.append(this.f6085a);
        sb.append(",description=");
        sb.append(this.b);
        return sb.toString();
    }
}
