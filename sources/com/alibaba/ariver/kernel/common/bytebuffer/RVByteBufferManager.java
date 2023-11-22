package com.alibaba.ariver.kernel.common.bytebuffer;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class RVByteBufferManager {
    public static void releaseAllBuffer() {
        try {
            a(RVByteBufferPool.sBufferPool);
            a(RVByteBufferPool.sDirectBufferPool);
        } catch (Throwable th) {
            RVLogger.e("AriverKernel:RVByteBufferManager", "releaseAllBuffer: ", th);
        }
    }

    private static void a(List<ByteBuffer> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<ByteBuffer> it = list.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        list.clear();
    }

    private static void a(ByteBuffer byteBuffer) {
        try {
            Method method = byteBuffer.getClass().getMethod("cleaner", new Class[0]);
            method.setAccessible(true);
            Object invoke = method.invoke(byteBuffer, new Object[0]);
            Method method2 = invoke.getClass().getMethod("clean", new Class[0]);
            method2.setAccessible(true);
            method2.invoke(invoke, new Object[0]);
        } catch (Throwable th) {
            RVLogger.e("AriverKernel:RVByteBufferManager", "releaseBuffer: ", th);
        }
    }
}
