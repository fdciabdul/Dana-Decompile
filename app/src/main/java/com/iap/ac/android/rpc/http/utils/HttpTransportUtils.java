package com.iap.ac.android.rpc.http.utils;

import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.rpc.http.error.HttpError;
import com.iap.ac.android.rpc.http.error.HttpException;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

/* loaded from: classes3.dex */
public class HttpTransportUtils {
    public static final String TAG = logTag("HttpTransportUtils");

    public static boolean checkClassExist(String str) {
        try {
            return Class.forName(str) != null;
        } catch (Throwable th) {
            String str2 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("check class [");
            sb.append(str);
            sb.append("] exception: ");
            sb.append(th);
            ACLog.e(str2, sb.toString());
            return false;
        }
    }

    public static void close(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e) {
            ACLog.w(TAG, "Take it easy, just cannot close stream.", e);
        }
    }

    public static Exception createException(HttpError httpError, String str) {
        return new HttpException(httpError.getErrorCode(), str);
    }

    public static String getLanguage() {
        return Locale.getDefault().toString();
    }

    public static String logTag(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("HttpTransport-");
        sb.append(str);
        return sb.toString();
    }

    public static byte[] readBytes(InputStream inputStream) {
        return readBytes(inputStream, true);
    }

    public static Exception createException(String str, String str2) {
        return new HttpException(str, str2);
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
            } catch (Exception e) {
                ACLog.e(TAG, "readBytes exception", e);
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (z) {
            close(inputStream);
        }
        return byteArray;
    }
}
