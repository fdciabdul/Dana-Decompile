package com.alipay.alipaysecuritysdk.common.e;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/* loaded from: classes6.dex */
public final class a {
    public static byte[] a(String str) {
        if (e.c(str) || !new File(str).exists()) {
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[10240];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (Exception unused) {
            return null;
        }
    }
}
