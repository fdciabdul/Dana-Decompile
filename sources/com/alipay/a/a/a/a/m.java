package com.alipay.a.a.a.a;

import com.fullstory.instrumentation.InstrumentInjector;
import java.io.Closeable;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class m {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                InstrumentInjector.log_e("IOUtil", "", e);
            }
        }
    }
}
