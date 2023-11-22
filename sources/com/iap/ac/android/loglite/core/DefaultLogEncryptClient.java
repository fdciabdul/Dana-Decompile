package com.iap.ac.android.loglite.core;

import android.text.TextUtils;
import com.iap.ac.android.loglite.utils.BizCodeMatchUtils;
import com.iap.ac.android.loglite.utils.LoggerWrapper;

/* loaded from: classes8.dex */
public class DefaultLogEncryptClient implements LogEncryptClient {
    @Override // com.iap.ac.android.loglite.core.LogEncryptClient
    public String decrypt(String str) {
        try {
            String a2 = BizCodeMatchUtils.a(str, "µµÿðæáýæÜÀáãëÐÛÐÜòÏîñúËÂ", "¹º»¼½¾¿°±¸¹º»¼½¾");
            if (TextUtils.isEmpty(a2) && !TextUtils.isEmpty(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append("decrypt value error!! value = ");
                sb.append(str);
                LoggerWrapper.w("DefaultLogEncryptClient", sb.toString());
            }
            return a2;
        } catch (Throwable th) {
            LoggerWrapper.w("DefaultLogEncryptClient", th);
            return null;
        }
    }

    @Override // com.iap.ac.android.loglite.core.LogEncryptClient
    public String encrypt(String str) {
        try {
            String b = BizCodeMatchUtils.b(str, "µµÿðæáýæÜÀáãëÐÛÐÜòÏîñúËÂ", "¹º»¼½¾¿°±¸¹º»¼½¾");
            if (TextUtils.isEmpty(b) && !TextUtils.isEmpty(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append("encrypt value error!! value = ");
                sb.append(str);
                LoggerWrapper.w("DefaultLogEncryptClient", sb.toString());
            }
            return b;
        } catch (Throwable th) {
            LoggerWrapper.w("DefaultLogEncryptClient", th);
            return null;
        }
    }
}
