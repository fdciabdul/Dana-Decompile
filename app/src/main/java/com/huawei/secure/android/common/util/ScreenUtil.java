package com.huawei.secure.android.common.util;

import java.lang.reflect.Method;
import java.security.PrivilegedAction;

/* loaded from: classes8.dex */
public class ScreenUtil {

    /* loaded from: classes8.dex */
    static class a implements PrivilegedAction {
        Method MyBillsEntityDataFactory;

        @Override // java.security.PrivilegedAction
        public Object run() {
            Method method = this.MyBillsEntityDataFactory;
            if (method == null) {
                return null;
            }
            method.setAccessible(true);
            return null;
        }
    }
}
