package com.alibaba.wireless.security.jaq;

import android.content.Context;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;

/* loaded from: classes6.dex */
public class SecurityStorage {

    /* renamed from: a  reason: collision with root package name */
    private Context f6807a;

    public SecurityStorage(Context context) {
        if (context != null) {
            this.f6807a = context.getApplicationContext();
        }
    }

    public String getString(String str) throws JAQException {
        try {
            return SecurityGuardManager.getInstance(this.f6807a).getDynamicDataStoreComp().getString(str);
        } catch (SecException e) {
            throw new JAQException(e.getErrorCode());
        }
    }

    public int putString(String str, String str2) throws JAQException {
        try {
            return SecurityGuardManager.getInstance(this.f6807a).getDynamicDataStoreComp().putString(str, str2);
        } catch (SecException e) {
            throw new JAQException(e.getErrorCode());
        }
    }

    public void removeString(String str) throws JAQException {
        try {
            SecurityGuardManager.getInstance(this.f6807a).getDynamicDataStoreComp().removeString(str);
        } catch (SecException e) {
            throw new JAQException(e.getErrorCode());
        }
    }
}
