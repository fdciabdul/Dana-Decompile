package com.huawei.secure.android.common.ssl.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes8.dex */
public abstract class f {
    public static void BuiltInFictitiousFunctionClassFactory() {
    }

    public static void BuiltInFictitiousFunctionClassFactory(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
                g.getAuthRequestContext("IOUtil", "closeSecure IOException");
            }
        }
    }

    public static void MyBillsEntityDataFactory(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException unused) {
                g.getAuthRequestContext("IOUtil", "closeSecure IOException");
            }
        }
    }
}
