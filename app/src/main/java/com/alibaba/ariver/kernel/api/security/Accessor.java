package com.alibaba.ariver.kernel.api.security;

import java.util.List;

/* loaded from: classes3.dex */
public interface Accessor {

    /* loaded from: classes6.dex */
    public interface InquiryCallback {
        void onComplete(List<? extends Permission> list, List<? extends Permission> list2);
    }

    Group getGroup();

    void inquiry(List<? extends Permission> list, InquiryCallback inquiryCallback);

    List<Permission> usePermissions();
}
