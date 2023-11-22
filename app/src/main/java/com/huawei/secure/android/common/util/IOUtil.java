package com.huawei.secure.android.common.util;

import com.fullstory.instrumentation.InstrumentInjector;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes8.dex */
public class IOUtil {
    public static void BuiltInFictitiousFunctionClassFactory(File file) {
        if (!file.exists() || file.delete()) {
            return;
        }
        InstrumentInjector.log_e("IOUtil", "deleteSecure exception");
    }

    public static void PlaceComponentResult(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
                InstrumentInjector.log_e("IOUtil", "closeSecure IOException");
            }
        }
    }

    public static void getAuthRequestContext(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException unused) {
                InstrumentInjector.log_e("IOUtil", "closeSecure IOException");
            }
        }
    }
}
