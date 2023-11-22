package com.iap.ac.android.biz.common.http;

import com.iap.ac.android.common.log.ACLog;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

/* loaded from: classes8.dex */
public class HttpUtils {
    public static final String TAG = "HttpUtils";

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                ACLog.w(TAG, "Take it easy, just cannot close stream.", e);
            }
        }
    }

    public static String getLanguage() {
        return Locale.getDefault().toString();
    }

    public static byte[] readBytes(InputStream inputStream) {
        return readBytes(inputStream, true);
    }

    public static byte[] readBytes(InputStream inputStream, boolean z) {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (Throwable th) {
                ACLog.e(TAG, "readBytes exception", th);
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (z) {
            close(inputStream);
        }
        return byteArray;
    }
}
