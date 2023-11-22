package com.alibaba.griver.base.common.account;

import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.griver.api.common.account.GriverAccountExtension;

/* loaded from: classes2.dex */
public class GriverAccount {
    public static String getUserId() {
        GriverAccountExtension a2 = a();
        return a2 != null ? a2.getUserId() : "";
    }

    private static GriverAccountExtension a() {
        return (GriverAccountExtension) RVProxy.get(GriverAccountExtension.class);
    }
}
