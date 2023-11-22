package com.iap.ac.android.instance;

import android.content.Context;
import android.text.TextUtils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.utils.MiscUtils;
import com.iap.ac.android.instance.a.a;
import com.iap.ac.android.instance.a.b;
import java.nio.ByteBuffer;
import java.util.UUID;

/* loaded from: classes3.dex */
public class IAPInstanceInfo {
    public static String instanceId(Context context) {
        String md5;
        if (!TextUtils.isEmpty(a.f7577a)) {
            return a.f7577a;
        }
        String a2 = b.a(context);
        a.f7577a = a2;
        if (!TextUtils.isEmpty(a2)) {
            return a.f7577a;
        }
        UUID randomUUID = UUID.randomUUID();
        UUID randomUUID2 = UUID.randomUUID();
        ByteBuffer wrap = ByteBuffer.wrap(new byte[32]);
        wrap.putLong(randomUUID.getMostSignificantBits());
        wrap.putLong(randomUUID.getLeastSignificantBits());
        wrap.putLong(randomUUID2.getMostSignificantBits());
        wrap.putLong(randomUUID2.getLeastSignificantBits());
        byte[] array = wrap.array();
        try {
            md5 = a.a(array);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("generateInstanceIdFromSeed error: ");
            sb.append(th);
            ACLog.w("InstanceIdImpl", sb.toString());
            md5 = MiscUtils.md5(array);
        }
        a.f7577a = md5;
        try {
            context.getSharedPreferences("acInstanceInfo", 0).edit().putString("iapInstanceId", md5).apply();
        } catch (Throwable th2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("saveInstanceIdToSp error: ");
            sb2.append(th2);
            ACLog.w("com.iap.ac.android.instance.a.b", sb2.toString());
        }
        return a.f7577a;
    }

    public static void setInstanceId(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("setInstanceId: ");
        sb.append(str);
        ACLog.i("InstanceIdImpl", sb.toString());
        a.f7577a = str;
    }

    public static String tid(Context context) {
        try {
            return String.format("%s_%s", instanceId(context), MiscUtils.md5(context.getPackageName()).substring(0, 16).toUpperCase());
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("generate tid error: ");
            sb.append(th);
            ACLog.e("IAPInstanceInfo", sb.toString());
            return "";
        }
    }
}
