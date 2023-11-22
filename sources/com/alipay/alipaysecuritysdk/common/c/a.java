package com.alipay.alipaysecuritysdk.common.c;

import java.util.Map;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static InterfaceC0054a f6868a;

    /* renamed from: com.alipay.alipaysecuritysdk.common.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0054a {
        void on(String str, String str2, String str3, Map<String, String> map);
    }

    public static void a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder("event: ");
        sb.append(str);
        sb.append(", ");
        sb.append(str2);
        sb.append(", ");
        sb.append(str3);
        sb.append(", ");
        b.a("SEC_SDK-event", sb.toString());
        InterfaceC0054a interfaceC0054a = f6868a;
        if (interfaceC0054a != null) {
            interfaceC0054a.on(str, str2, str3, null);
        }
    }
}
