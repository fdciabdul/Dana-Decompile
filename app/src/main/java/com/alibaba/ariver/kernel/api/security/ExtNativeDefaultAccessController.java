package com.alibaba.ariver.kernel.api.security;

import com.alibaba.ariver.kernel.api.security.AccessController;
import java.util.List;

/* loaded from: classes6.dex */
public class ExtNativeDefaultAccessController implements AccessController {

    /* renamed from: a  reason: collision with root package name */
    private AccessControlManagement f6105a;

    @Override // com.alibaba.ariver.kernel.api.security.AccessController
    public boolean check(Accessor accessor, List<? extends Guard> list, AccessController.ApplyCallback applyCallback) throws AccessControlException {
        return false;
    }

    @Override // com.alibaba.ariver.kernel.api.security.AccessController
    public void setAccessControlManagement(AccessControlManagement accessControlManagement) {
        this.f6105a = accessControlManagement;
    }
}
