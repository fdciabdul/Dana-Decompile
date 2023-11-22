package com.alipay.alipaysecuritysdk.apdid.f;

import android.content.Context;
import com.alipay.alipaysecuritysdk.common.e.e;
import com.taobao.dp.DeviceSecuritySDK;
import com.taobao.dp.client.IInitResultListener;
import com.taobao.dp.http.IUrlRequestService;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile String f6858a = "";
    private static volatile boolean b;

    static /* synthetic */ boolean a() {
        b = true;
        return true;
    }

    public static String a(Context context) {
        String str;
        String str2;
        synchronized (a.class) {
            if (e.c(f6858a)) {
                f6858a = com.alipay.alipaysecuritysdk.common.d.a.a(context, "xxxwww_v2", "umidtk");
                if (e.c(f6858a)) {
                    try {
                        str2 = DeviceSecuritySDK.getInstance(context).getSecurityToken();
                    } catch (Throwable th) {
                        com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-apdid", th);
                        str2 = "";
                    }
                    f6858a = a(context, str2);
                }
            }
            str = f6858a;
        }
        return str;
    }

    public static String b(Context context) {
        String str = "";
        try {
            b = false;
            DeviceSecuritySDK.getInstance(context).initAsync("", 0, (IUrlRequestService) null, new IInitResultListener() { // from class: com.alipay.alipaysecuritysdk.apdid.f.a.1
                public final void onInitFinished(String str2, int i) {
                    a.a();
                }
            });
            for (int i = 3000; !b && i > 0; i -= 10) {
                Thread.sleep(10L);
            }
            str = DeviceSecuritySDK.getInstance(context).getSecurityToken();
        } catch (Throwable th) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-apdid", "umid request error", th);
        }
        String a2 = a(context, str);
        if (e.d(a2)) {
            com.alipay.alipaysecuritysdk.common.d.a.a(context, "xxxwww_v2", "umidtk", a2);
            f6858a = a2;
        }
        return a2;
    }

    private static String a(Context context, String str) {
        if (e.c(str) || e.a(str, "000000000000000000000000")) {
            String a2 = b.a(context);
            return ((a2 == null || !a2.contains("?")) && !e.c(a2)) ? a2 : "";
        }
        return str;
    }
}
