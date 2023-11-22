package com.alipay.mobile.embedview.mapbiz.utils;

import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.griver.base.common.env.GriverEnv;

/* loaded from: classes6.dex */
public final class RuntimeConstants {
    public static final RuntimeConstants INSTANCE = new RuntimeConstants();

    /* renamed from: a  reason: collision with root package name */
    private int f7190a = -1;
    private int b;

    private RuntimeConstants() {
    }

    public final boolean isDebug() {
        if (this.f7190a == -1) {
            this.f7190a = GriverEnv.isDebuggable() ? 1 : 0;
        }
        return this.f7190a == 1;
    }

    public final boolean isMainProcess() {
        if (this.b == -1) {
            this.b = ProcessUtils.isMainProcess() ? 1 : 0;
        }
        return this.b == 1;
    }
}
