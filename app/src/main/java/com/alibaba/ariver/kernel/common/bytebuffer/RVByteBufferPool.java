package com.alibaba.ariver.kernel.common.bytebuffer;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes6.dex */
class RVByteBufferPool {
    static List<ByteBuffer> sBufferPool = new CopyOnWriteArrayList();
    static List<ByteBuffer> sDirectBufferPool = new CopyOnWriteArrayList();

    RVByteBufferPool() {
    }

    public static ByteBuffer get(byte[] bArr, int i, boolean z) {
        if (bArr == null) {
            RVLogger.w("AriverKernel:RVByteBufferPool", "get, data is null");
            return null;
        } else if (i <= 0 || i > 5242880) {
            StringBuilder sb = new StringBuilder();
            sb.append("length is smaller than zero or too large: ");
            sb.append(i);
            RVLogger.w("AriverKernel:RVByteBufferPool", sb.toString());
            return null;
        } else {
            ByteBuffer a2 = a(i, z);
            a(a2, bArr);
            return a2;
        }
    }

    private static void a(ByteBuffer byteBuffer, byte[] bArr) {
        try {
            byteBuffer.clear();
            byteBuffer.put(bArr);
            byteBuffer.flip();
        } catch (Throwable th) {
            RVLogger.e("AriverKernel:RVByteBufferPool", "fillData: ", th);
        }
    }

    private static ByteBuffer a(int i, boolean z) {
        int size;
        ByteBuffer b;
        if (z) {
            size = sDirectBufferPool.size();
        } else {
            size = sBufferPool.size();
        }
        return (size < 16 || (b = b(i, z)) == null) ? c(i, z) : b;
    }

    private static ByteBuffer b(int i, boolean z) {
        Iterator<ByteBuffer> it;
        if (z) {
            it = sDirectBufferPool.iterator();
        } else {
            it = sBufferPool.iterator();
        }
        while (it.hasNext()) {
            ByteBuffer next = it.next();
            if (next != null && !next.hasRemaining() && next.capacity() >= i) {
                return next;
            }
        }
        return null;
    }

    private static ByteBuffer c(int i, boolean z) {
        try {
            if (z) {
                return ByteBuffer.allocateDirect(i);
            }
            return ByteBuffer.allocate(i);
        } catch (Throwable th) {
            RVLogger.e("AriverKernel:RVByteBufferPool", "allocateBuffer: ", th);
            return null;
        }
    }
}
