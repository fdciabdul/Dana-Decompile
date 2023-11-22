package com.alibaba.ariver.kernel.api.extension.bridge;

import com.alibaba.ariver.kernel.api.security.Guard;
import com.alibaba.ariver.kernel.api.security.Permission;

/* loaded from: classes6.dex */
public class BridgeGuard implements Guard {

    /* renamed from: a  reason: collision with root package name */
    private Permission f6084a;

    public BridgeGuard(Permission permission) {
        this.f6084a = permission;
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return this.f6084a;
    }
}
