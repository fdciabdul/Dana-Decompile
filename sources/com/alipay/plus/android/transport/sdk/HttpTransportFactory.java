package com.alipay.plus.android.transport.sdk;

import com.alipay.plus.android.transport.a.a;

/* loaded from: classes7.dex */
public final class HttpTransportFactory {
    public static AbstractHttpTransport createHttpTransport() {
        return createHttpTransport(false);
    }

    public static AbstractHttpTransport createHttpTransport(boolean z) {
        return new a(z);
    }
}
