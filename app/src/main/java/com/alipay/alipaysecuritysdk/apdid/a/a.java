package com.alipay.alipaysecuritysdk.apdid.a;

import com.alipay.alipaysecuritysdk.apdid.face.Configuration;
import com.alipay.alipaysecuritysdk.common.c.b;
import java.util.Objects;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static Configuration f6846a;

    public static void a(Configuration configuration) {
        f6846a = configuration;
    }

    public static Configuration a() {
        Configuration configuration = f6846a;
        if (configuration != null) {
            return configuration;
        }
        throw new IllegalArgumentException("please invoke GlobalConfig.setConfiguration() method first");
    }

    public static void b() {
        Configuration configuration = f6846a;
        if (configuration == null) {
            b.b("SEC_SDK-apdid", "configuration is null");
            return;
        }
        Objects.toString(configuration.locale);
        String str = f6846a.gateway;
        boolean z = f6846a.needUmid;
        String str2 = f6846a.secret;
        int i = f6846a.envMode;
    }
}
