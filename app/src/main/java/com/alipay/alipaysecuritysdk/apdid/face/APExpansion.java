package com.alipay.alipaysecuritysdk.apdid.face;

import com.alipay.alipaysecuritysdk.common.c.a;
import com.alipay.alipaysecuritysdk.common.c.b;
import java.util.Map;

/* loaded from: classes6.dex */
public class APExpansion {
    private static ExpansionForEvent mExpansionForEvent;
    private static ExpansionForLog mExpansionForLog;

    /* loaded from: classes6.dex */
    public interface ExpansionForEvent {
        void on(String str, String str2, String str3, Map<String, String> map);
    }

    /* loaded from: classes6.dex */
    public interface ExpansionForLog {
        void print(String str, String str2);
    }

    public static void registerLog(ExpansionForLog expansionForLog, ExpansionForEvent expansionForEvent) {
        mExpansionForLog = expansionForLog;
        b.f6869a = new b.a() { // from class: com.alipay.alipaysecuritysdk.apdid.face.APExpansion.1
            @Override // com.alipay.alipaysecuritysdk.common.c.b.a
            public final void print(String str, String str2) {
                try {
                    APExpansion.mExpansionForLog.print(str, str2);
                } catch (Throwable th) {
                    b.a("SEC_SDK-apdid", th);
                }
            }
        };
        mExpansionForEvent = expansionForEvent;
        a.f6868a = new a.InterfaceC0054a() { // from class: com.alipay.alipaysecuritysdk.apdid.face.APExpansion.2
            @Override // com.alipay.alipaysecuritysdk.common.c.a.InterfaceC0054a
            public final void on(String str, String str2, String str3, Map<String, String> map) {
                try {
                    APExpansion.mExpansionForEvent.on(str, str2, str3, map);
                } catch (Throwable th) {
                    b.a("SEC_SDK-apdid", th);
                }
            }
        };
    }
}
