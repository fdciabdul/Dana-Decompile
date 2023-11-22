package com.alipay.mobile.rome.syncsdk.util;

import com.alipay.mobile.common.logging.api.LoggerFactory;
import com.alipay.mobile.common.logging.api.trace.TraceLogger;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7268a = "f";

    public static <T extends Message> T a(byte[] bArr, Class<T> cls) {
        try {
            return (T) new Wire(new Class[0]).parseFrom(Arrays.copyOfRange(bArr, 0, bArr.length), cls);
        } catch (IOException unused) {
            String str = f7268a;
            StringBuilder sb = new StringBuilder("parsePBObject thrown exception after parse: ");
            sb.append(cls);
            c.d(str, sb.toString());
            return null;
        }
    }

    public static int a(byte[] bArr) {
        return (bArr[2] & 255) | ((bArr[1] & 255) << 8);
    }

    public static byte[] a(Message message, int i) {
        byte[] bArr = null;
        if (message == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.write(1);
            dataOutputStream.writeShort(i);
            dataOutputStream.write(message.toByteArray());
            dataOutputStream.flush();
            bArr = byteArrayOutputStream.toByteArray();
            dataOutputStream.close();
            return bArr;
        } catch (IOException unused) {
            String str = f7268a;
            StringBuilder sb = new StringBuilder("convertPBToByteArray: ");
            sb.append(i);
            c.d(str, sb.toString());
            return bArr;
        }
    }

    public static byte[] a(Message message) {
        byte[] bArr;
        DataOutputStream dataOutputStream;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.write(message.toByteArray());
            dataOutputStream.flush();
            bArr = byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
            bArr = null;
        }
        try {
            dataOutputStream.close();
        } catch (IOException unused2) {
            c.d(f7268a, "convertLinkPBToByteArray  ");
            return bArr;
        }
        return bArr;
    }

    public static boolean b(byte[] bArr) {
        int i = bArr[0] & 255;
        String str = f7268a;
        StringBuilder sb = new StringBuilder("syncMsg version is: ");
        sb.append(i);
        String obj = sb.toString();
        if (c.f7265a == null) {
            c.f7265a = LoggerFactory.getTraceLogger();
        }
        TraceLogger traceLogger = c.f7265a;
        StringBuilder sb2 = new StringBuilder("sync_");
        sb2.append(str);
        traceLogger.verbose(sb2.toString(), obj);
        return i == 1;
    }
}
