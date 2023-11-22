package com.alipay.plus.android.transport.b;

import com.alipay.iap.android.common.errorcode.IAPError;
import com.alipay.iap.android.common.errorcode.IAPException;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.plus.android.transport.sdk.HttpError;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7394a = a("HttpTransportUtils");

    public static Exception a(HttpError httpError, String str) {
        return new IAPException(new IAPError(httpError.getErrorCode(), str));
    }

    public static String a() {
        return Locale.getDefault().toString();
    }

    public static String a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("HttpTransport-");
        sb.append(str);
        return sb.toString();
    }

    public static void a(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e) {
            LoggerWrapper.w(f7394a, "Take it easy, just cannot close stream.", e);
        }
    }

    public static byte[] a(InputStream inputStream) {
        return a(inputStream, true);
    }

    public static byte[] a(InputStream inputStream, boolean z) {
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
                LoggerWrapper.e(f7394a, "readBytes exception", e);
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (z) {
            a((Closeable) inputStream);
        }
        return byteArray;
    }
}
