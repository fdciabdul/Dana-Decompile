package com.iap.ac.android.instance.a;

import android.util.Base64;
import com.iap.ac.android.common.log.ACLog;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f7577a;

    public static String a(byte[] bArr) throws Throwable {
        ACLog.d("InstanceIdImpl", "will generateInstanceIdInternal");
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int random = (int) (Math.random() * 1000.0d);
        ByteBuffer allocate = ByteBuffer.allocate(32);
        allocate.putInt(currentTimeMillis);
        allocate.putInt(random);
        if (bArr.length >= 23) {
            allocate.put(bArr, 0, 23);
        } else {
            allocate.put(bArr);
            allocate.put(new byte[23 - bArr.length]);
        }
        byte[] array = allocate.array();
        new com.iap.ac.android.instance.b.a().update(array, 0, 31);
        array[31] = (byte) r0.getValue();
        return Base64.encodeToString(array, 2);
    }
}
