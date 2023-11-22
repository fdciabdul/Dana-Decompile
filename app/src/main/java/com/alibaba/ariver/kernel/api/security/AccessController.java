package com.alibaba.ariver.kernel.api.security;

import java.util.List;

/* loaded from: classes3.dex */
public interface AccessController {

    /* loaded from: classes6.dex */
    public interface ApplyCallback {
        void onFailure(List<? extends Permission> list);

        void onSuccess();
    }

    boolean check(Accessor accessor, List<? extends Guard> list, ApplyCallback applyCallback) throws AccessControlException;

    void setAccessControlManagement(AccessControlManagement accessControlManagement);
}
