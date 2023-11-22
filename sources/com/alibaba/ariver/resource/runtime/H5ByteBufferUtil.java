package com.alibaba.ariver.resource.runtime;

import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.content.ResourceQuery;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public class H5ByteBufferUtil {
    public static final String TAG = "H5ByteBufferUtil";
    public static byte[] JS_INLINE_SNIPPET_TO_SEARCH_START = "<!-- start path=".getBytes();
    public static byte[] JS_INLINE_SNIPPET_TO_SEARCH_END = " -->".getBytes();
    public static byte[] JAVASCRIPT_TAG_START = "<script>\n".getBytes();
    public static byte[] JAVASCRIPT_TAG_END = "\n</script>".getBytes();

    public static byte[] replaceJsFile(byte[] bArr, byte[] bArr2, byte[] bArr3, String str, ContentProviderImpl contentProviderImpl) {
        ByteBuffer wrap;
        int i;
        ByteBuffer allocate;
        boolean z;
        boolean z2;
        boolean z3;
        try {
            wrap = ByteBuffer.wrap(bArr);
        } catch (Throwable th) {
            RVLogger.e(TAG, "replaceJsFile error: ", th);
        }
        if (wrap == null || bArr2 == null || bArr3 == null) {
            return null;
        }
        int i2 = -1;
        ByteBuffer byteBuffer = null;
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = 0;
        while (wrap.hasRemaining()) {
            while (true) {
                if (!wrap.hasRemaining()) {
                    break;
                }
                int length = bArr2.length;
                int i7 = 0;
                while (true) {
                    if (i7 >= length) {
                        z3 = true;
                        break;
                    }
                    if (wrap.get() != bArr2[i7]) {
                        z3 = false;
                        break;
                    }
                    i7++;
                }
                if (z3) {
                    i3 = wrap.position() - bArr2.length;
                    break;
                }
            }
            while (true) {
                if (!wrap.hasRemaining()) {
                    break;
                }
                int length2 = bArr3.length;
                int i8 = 0;
                while (true) {
                    if (i8 >= length2) {
                        z2 = true;
                        break;
                    }
                    if (wrap.get() != bArr3[i8]) {
                        z2 = false;
                        break;
                    }
                    i8++;
                }
                if (z2) {
                    i4 = wrap.position() - bArr3.length;
                    break;
                }
            }
            while (true) {
                if (!wrap.hasRemaining()) {
                    i = i5;
                    break;
                }
                int length3 = bArr3.length;
                int i9 = 0;
                while (true) {
                    if (i9 >= length3) {
                        z = true;
                        break;
                    }
                    if (wrap.get() != bArr3[i9]) {
                        z = false;
                        break;
                    }
                    i9++;
                }
                if (z) {
                    i = wrap.position() - bArr3.length;
                    break;
                }
            }
            if (i == i2) {
                RVLogger.d(TAG, "replaceJsFile not find TAG in appx.js");
                return null;
            } else if (i5 == i) {
                int length4 = i + bArr3.length;
                int capacity = wrap.capacity() - length4;
                ByteBuffer allocate2 = ByteBuffer.allocate(capacity);
                wrap.position(length4);
                wrap.get(allocate2.array(), 0, capacity);
                ByteBuffer allocate3 = ByteBuffer.allocate(allocate2.capacity() + byteBuffer.capacity());
                byteBuffer.position(0);
                allocate3.put(byteBuffer);
                allocate3.put(allocate2);
                return allocate3.array();
            } else {
                ByteBuffer a2 = a(bArr, i3, i4, str, contentProviderImpl);
                ByteBuffer allocate4 = ByteBuffer.allocate((i3 - i6) + a2.capacity());
                ByteBuffer a3 = a(wrap, i6, i3);
                a3.position(0);
                a2.position(0);
                allocate4.put(a3);
                allocate4.put(a2);
                if (byteBuffer == null) {
                    allocate = ByteBuffer.allocate(allocate4.capacity());
                    allocate4.position(0);
                    allocate.put(allocate4);
                } else {
                    allocate = ByteBuffer.allocate(byteBuffer.capacity() + allocate4.capacity());
                    byteBuffer.position(0);
                    allocate4.position(0);
                    allocate.put(byteBuffer);
                    allocate.put(allocate4);
                }
                byteBuffer = allocate;
                i6 = i + JS_INLINE_SNIPPET_TO_SEARCH_END.length;
                i5 = i;
                i2 = -1;
            }
        }
        return null;
    }

    private static ByteBuffer a(ByteBuffer byteBuffer, int i, int i2) {
        int position = byteBuffer.position();
        byteBuffer.position(i);
        int i3 = i2 - i;
        ByteBuffer allocate = ByteBuffer.allocate(i3);
        byteBuffer.get(allocate.array(), 0, i3);
        byteBuffer.position(position);
        return allocate;
    }

    private static ByteBuffer a(byte[] bArr, int i, int i2, String str, ContentProviderImpl contentProviderImpl) {
        byte[] bytes;
        byte[] bArr2 = JS_INLINE_SNIPPET_TO_SEARCH_START;
        int length = (i2 - i) - bArr2.length;
        if (length <= 0) {
            return null;
        }
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArr, i + bArr2.length, bArr3, 0, length);
        String str2 = new String(bArr3);
        Resource rawResource = contentProviderImpl.getRawResource(new ResourceQuery(str2));
        if ((rawResource == null && (rawResource = contentProviderImpl.getRawResource(new ResourceQuery(FileUtils.combinePath(str, str2)))) == null) || (bytes = rawResource.getBytes()) == null) {
            return null;
        }
        ByteBuffer allocate = ByteBuffer.allocate(bytes.length + JAVASCRIPT_TAG_START.length + JAVASCRIPT_TAG_END.length);
        allocate.put(JAVASCRIPT_TAG_START);
        allocate.put(bytes);
        allocate.put(JAVASCRIPT_TAG_END);
        return allocate;
    }
}
