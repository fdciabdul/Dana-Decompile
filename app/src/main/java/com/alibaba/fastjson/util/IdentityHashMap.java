package com.alibaba.fastjson.util;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import java.lang.reflect.Type;

/* loaded from: classes3.dex */
public class IdentityHashMap<V> {
    private final Entry<V>[] buckets;
    private final int indexMask;
    public static final byte[] getAuthRequestContext = {TarHeader.LF_CHR, -70, 75, 72, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int BuiltInFictitiousFunctionClassFactory = 95;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.alibaba.fastjson.util.IdentityHashMap.getAuthRequestContext
            int r7 = r7 * 2
            int r7 = 16 - r7
            int r8 = r8 + 105
            int r6 = r6 + 4
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L14
            r4 = r8
            r3 = 0
            r8 = r7
            r7 = r6
            goto L2c
        L14:
            r3 = 0
        L15:
            byte r4 = (byte) r8
            int r6 = r6 + 1
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r7) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L26:
            r4 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L2c:
            int r4 = -r4
            int r6 = r6 + r4
            int r6 = r6 + 2
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.IdentityHashMap.a(int, int, int, java.lang.Object[]):void");
    }

    public IdentityHashMap(int i) {
        this.indexMask = i - 1;
        this.buckets = new Entry[i];
    }

    public final V get(Type type) {
        try {
            Object[] objArr = new Object[1];
            a((byte) (BuiltInFictitiousFunctionClassFactory & 46), (byte) (getAuthRequestContext[5] - 1), getAuthRequestContext[5], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b = (byte) (-getAuthRequestContext[5]);
            byte b2 = (byte) (b + 1);
            Object[] objArr2 = new Object[1];
            a(b, b2, b2, objArr2);
            for (Entry<V> entry = this.buckets[((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, type)).intValue() & this.indexMask]; entry != null; entry = entry.next) {
                if (type == entry.key) {
                    return entry.value;
                }
            }
            return null;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public boolean put(Type type, V v) {
        try {
            Object[] objArr = new Object[1];
            a((byte) (BuiltInFictitiousFunctionClassFactory & 46), (byte) (getAuthRequestContext[5] - 1), getAuthRequestContext[5], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b = (byte) (-getAuthRequestContext[5]);
            byte b2 = (byte) (b + 1);
            Object[] objArr2 = new Object[1];
            a(b, b2, b2, objArr2);
            int intValue = ((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, type)).intValue();
            int i = this.indexMask & intValue;
            for (Entry<V> entry = this.buckets[i]; entry != null; entry = entry.next) {
                if (type == entry.key) {
                    entry.value = v;
                    return true;
                }
            }
            this.buckets[i] = new Entry<>(type, v, intValue, this.buckets[i]);
            return false;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public Class findClass(String str) {
        int i = 0;
        while (true) {
            Entry<V>[] entryArr = this.buckets;
            if (i >= entryArr.length) {
                return null;
            }
            Entry<V> entry = entryArr[i];
            if (entry != null) {
                for (Entry<V> entry2 = entry; entry2 != null; entry2 = entry2.next) {
                    Type type = entry.key;
                    if (type instanceof Class) {
                        Class cls = (Class) type;
                        if (cls.getName().equals(str)) {
                            return cls;
                        }
                    }
                }
            }
            i++;
        }
    }

    /* loaded from: classes3.dex */
    protected static final class Entry<V> {
        public final int hashCode;
        public final Type key;
        public final Entry<V> next;
        public V value;

        public Entry(Type type, V v, int i, Entry<V> entry) {
            this.key = type;
            this.value = v;
            this.next = entry;
            this.hashCode = i;
        }
    }
}
