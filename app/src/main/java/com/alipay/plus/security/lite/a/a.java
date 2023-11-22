package com.alipay.plus.security.lite.a;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.griver.api.jsapi.diagnostic.RecordError;
import com.alipay.plus.security.lite.SecLiteException;
import com.alipay.plus.security.lite.SecurityGuardLiteNative;
import com.alipay.plus.security.lite.b.c;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public SecurityGuardLiteNative f7405a;
    public String b;

    public a(Context context, SecurityGuardLiteNative securityGuardLiteNative) {
        this.f7405a = securityGuardLiteNative;
        if (TextUtils.isEmpty(this.b)) {
            this.b = c.a(context);
        }
    }

    public String a(String str) throws SecLiteException {
        if (!TextUtils.isEmpty(this.b)) {
            try {
                return this.f7405a.decrypt(this.b, str);
            } catch (Throwable th) {
                if (RecordError.ERROR_APPID_EXCEPTION.equals(th.getMessage())) {
                    throw SecLiteException.DECRYPT_INTERNAL_ERROR;
                }
                throw SecLiteException.UNKNOWN_ERROR;
            }
        }
        throw SecLiteException.ENCRYPT_INTERNAL_ERROR;
    }

    public String b(String str) throws SecLiteException {
        if (!TextUtils.isEmpty(this.b)) {
            try {
                return this.f7405a.encrypt(this.b, str);
            } catch (Throwable th) {
                if (RecordError.ERROR_APP_LIFE_INVALID_URL.equals(th.getMessage())) {
                    throw SecLiteException.ENCRYPT_PARAMS_ERROR;
                }
                throw SecLiteException.UNKNOWN_ERROR;
            }
        }
        throw SecLiteException.ENCRYPT_INTERNAL_ERROR;
    }
}
