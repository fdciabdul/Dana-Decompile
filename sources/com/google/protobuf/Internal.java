package com.google.protobuf;

import android.view.KeyEvent;
import com.alibaba.fastjson.parser.JSONLexer;
import id.dana.cashier.view.InputCardNumberView;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
import o.getOnBoardingScenario;

/* loaded from: classes.dex */
public final class Internal {
    private static int $10 = 0;
    private static int $11 = 1;
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final ByteBuffer EMPTY_BYTE_BUFFER;
    public static final CodedInputStream EMPTY_CODED_INPUT_STREAM;
    static final Charset ISO_8859_1;
    private static long KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static int PlaceComponentResult = 1;
    static final Charset UTF_8;
    private static int getAuthRequestContext;

    /* loaded from: classes.dex */
    public interface BooleanList extends ProtobufList<Boolean> {
        void addBoolean(boolean z);

        boolean getBoolean(int i);

        @Override // 
        ProtobufList<Boolean> mutableCopyWithCapacity(int i);

        boolean setBoolean(int i, boolean z);
    }

    /* loaded from: classes.dex */
    public interface DoubleList extends ProtobufList<Double> {
        void addDouble(double d);

        double getDouble(int i);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        ProtobufList<Double> mutableCopyWithCapacity(int i);

        double setDouble(int i, double d);
    }

    /* loaded from: classes.dex */
    public interface EnumLite {
        int getNumber();
    }

    /* loaded from: classes.dex */
    public interface EnumLiteMap<T extends EnumLite> {
        T findValueByNumber(int i);
    }

    /* loaded from: classes.dex */
    public interface EnumVerifier {
        boolean isInRange(int i);
    }

    /* loaded from: classes.dex */
    public interface FloatList extends ProtobufList<Float> {
        void addFloat(float f);

        float getFloat(int i);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        ProtobufList<Float> mutableCopyWithCapacity(int i);

        float setFloat(int i, float f);
    }

    /* loaded from: classes.dex */
    public interface IntList extends ProtobufList<Integer> {
        void addInt(int i);

        int getInt(int i);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        ProtobufList<Integer> mutableCopyWithCapacity(int i);

        int setInt(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface LongList extends ProtobufList<Long> {
        void addLong(long j);

        long getLong(int i);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        ProtobufList<Long> mutableCopyWithCapacity(int i);

        long setLong(int i, long j);
    }

    /* loaded from: classes.dex */
    public interface ProtobufList<E> extends List<E>, RandomAccess {
        boolean isModifiable();

        void makeImmutable();

        ProtobufList<E> mutableCopyWithCapacity(int i);
    }

    static void PlaceComponentResult() {
        KClassImpl$Data$declaredNonStaticMembers$2 = 89069421303252557L;
    }

    public static int hashBoolean(boolean z) {
        int i;
        int i2 = PlaceComponentResult + 101;
        getAuthRequestContext = i2 % 128;
        int i3 = i2 % 2;
        if (!z) {
            i = 1237;
        } else {
            int i4 = getAuthRequestContext + 119;
            PlaceComponentResult = i4 % 128;
            i = (i4 % 2 == 0 ? 'U' : (char) 19) != 19 ? 32652 : 1231;
        }
        try {
            int i5 = getAuthRequestContext + 125;
            PlaceComponentResult = i5 % 128;
            int i6 = i5 % 2;
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    public static int hashLong(long j) {
        int i = getAuthRequestContext + 1;
        PlaceComponentResult = i % 128;
        int i2 = (int) ((i % 2 == 0 ? (char) 27 : '@') != 27 ? j ^ (j >>> 32) : j / (j << 15));
        try {
            int i3 = getAuthRequestContext + 89;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            return i2;
        } catch (Exception e) {
            throw e;
        }
    }

    private Internal() {
    }

    static {
        PlaceComponentResult();
        Object[] objArr = new Object[1];
        a(42589 - (KeyEvent.getMaxKeyCode() >> 16), new char[]{38747, 12551, 56306, 25652, 3650}, objArr);
        UTF_8 = Charset.forName(((String) objArr[0]).intern());
        ISO_8859_1 = Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        EMPTY_BYTE_BUFFER = ByteBuffer.wrap(bArr);
        EMPTY_CODED_INPUT_STREAM = CodedInputStream.newInstance(bArr);
        int i = getAuthRequestContext + 99;
        PlaceComponentResult = i % 128;
        if ((i % 2 == 0 ? 'U' : '\n') != '\n') {
            Object obj = null;
            obj.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T checkNotNull(T t) {
        int i = getAuthRequestContext + 81;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        int i3 = getAuthRequestContext + 113;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
        return t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001c, code lost:
    
        if ((r2 != null ? '\\' : 'B') != 'B') goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0021, code lost:
    
        if (r2 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0023, code lost:
    
        r3 = com.google.protobuf.Internal.getAuthRequestContext + 11;
        com.google.protobuf.Internal.PlaceComponentResult = r3 % 128;
        r3 = r3 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002d, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0033, code lost:
    
        throw new java.lang.NullPointerException(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> T checkNotNull(T r2, java.lang.String r3) {
        /*
            int r0 = com.google.protobuf.Internal.PlaceComponentResult     // Catch: java.lang.Exception -> L36
            int r0 = r0 + 117
            int r1 = r0 % 128
            com.google.protobuf.Internal.getAuthRequestContext = r1     // Catch: java.lang.Exception -> L36
            int r0 = r0 % 2
            r1 = 5
            if (r0 == 0) goto Lf
            r0 = 5
            goto L11
        Lf:
            r0 = 60
        L11:
            if (r0 == r1) goto L1f
            r0 = 66
            if (r2 == 0) goto L1a
            r1 = 92
            goto L1c
        L1a:
            r1 = 66
        L1c:
            if (r1 == r0) goto L2e
            goto L23
        L1f:
            r0 = 0
            int r0 = r0.length     // Catch: java.lang.Throwable -> L34
            if (r2 == 0) goto L2e
        L23:
            int r3 = com.google.protobuf.Internal.getAuthRequestContext
            int r3 = r3 + 11
            int r0 = r3 % 128
            com.google.protobuf.Internal.PlaceComponentResult = r0
            int r3 = r3 % 2
            return r2
        L2e:
            java.lang.NullPointerException r2 = new java.lang.NullPointerException
            r2.<init>(r3)
            throw r2
        L34:
            r2 = move-exception
            throw r2
        L36:
            r2 = move-exception
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Internal.checkNotNull(java.lang.Object, java.lang.String):java.lang.Object");
    }

    public static String stringDefaultValue(String str) {
        String str2 = new String(str.getBytes(ISO_8859_1), UTF_8);
        int i = getAuthRequestContext + 63;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        return str2;
    }

    public static ByteString bytesDefaultValue(String str) {
        int i = getAuthRequestContext + 89;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        ByteString copyFrom = ByteString.copyFrom(str.getBytes(ISO_8859_1));
        int i3 = getAuthRequestContext + 27;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
        return copyFrom;
    }

    public static byte[] byteArrayDefaultValue(String str) {
        byte[] bytes;
        int i = PlaceComponentResult + 57;
        getAuthRequestContext = i % 128;
        if (i % 2 != 0) {
            bytes = str.getBytes(ISO_8859_1);
            int i2 = 92 / 0;
        } else {
            try {
                bytes = str.getBytes(ISO_8859_1);
            } catch (Exception e) {
                throw e;
            }
        }
        int i3 = getAuthRequestContext + 13;
        PlaceComponentResult = i3 % 128;
        if (!(i3 % 2 != 0)) {
            Object obj = null;
            obj.hashCode();
            return bytes;
        }
        return bytes;
    }

    public static ByteBuffer byteBufferDefaultValue(String str) {
        try {
            int i = PlaceComponentResult + 37;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            ByteBuffer wrap = ByteBuffer.wrap(byteArrayDefaultValue(str));
            int i3 = PlaceComponentResult + 81;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
            return wrap;
        } catch (Exception e) {
            throw e;
        }
    }

    public static ByteBuffer copyByteBuffer(ByteBuffer byteBuffer) {
        int i = PlaceComponentResult + 109;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.clear();
        ByteBuffer allocate = ByteBuffer.allocate(duplicate.capacity());
        allocate.put(duplicate);
        allocate.clear();
        int i3 = PlaceComponentResult + 83;
        getAuthRequestContext = i3 % 128;
        int i4 = i3 % 2;
        return allocate;
    }

    public static boolean isValidUtf8(ByteString byteString) {
        try {
            int i = getAuthRequestContext + 107;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            boolean isValidUtf8 = byteString.isValidUtf8();
            int i3 = PlaceComponentResult + 65;
            getAuthRequestContext = i3 % 128;
            if ((i3 % 2 != 0 ? (char) 16 : '\b') != 16) {
                return isValidUtf8;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return isValidUtf8;
        } catch (Exception e) {
            throw e;
        }
    }

    public static boolean isValidUtf8(byte[] bArr) {
        int i = PlaceComponentResult + 11;
        getAuthRequestContext = i % 128;
        if (!(i % 2 != 0)) {
            try {
                return Utf8.isValidUtf8(bArr);
            } catch (Exception e) {
                throw e;
            }
        }
        boolean isValidUtf8 = Utf8.isValidUtf8(bArr);
        Object obj = null;
        obj.hashCode();
        return isValidUtf8;
    }

    public static byte[] toByteArray(String str) {
        int i = getAuthRequestContext + 1;
        PlaceComponentResult = i % 128;
        if ((i % 2 == 0 ? '\t' : '\'') != '\t') {
            return str.getBytes(UTF_8);
        }
        byte[] bytes = str.getBytes(UTF_8);
        Object obj = null;
        obj.hashCode();
        return bytes;
    }

    public static String toStringUtf8(byte[] bArr) {
        String str = new String(bArr, UTF_8);
        int i = getAuthRequestContext + 19;
        PlaceComponentResult = i % 128;
        if (!(i % 2 != 0)) {
            Object[] objArr = null;
            int length = objArr.length;
            return str;
        }
        return str;
    }

    public static int hashEnum(EnumLite enumLite) {
        int i = getAuthRequestContext + 7;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        int number = enumLite.getNumber();
        int i3 = PlaceComponentResult + 61;
        getAuthRequestContext = i3 % 128;
        if (!(i3 % 2 == 0)) {
            int i4 = 59 / 0;
            return number;
        }
        return number;
    }

    public static int hashEnumList(List<? extends EnumLite> list) {
        int i = PlaceComponentResult + 43;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        try {
            Iterator<? extends EnumLite> it = list.iterator();
            int i3 = 1;
            while (true) {
                if (!it.hasNext()) {
                    int i4 = PlaceComponentResult + 49;
                    getAuthRequestContext = i4 % 128;
                    int i5 = i4 % 2;
                    return i3;
                }
                i3 = (i3 * 31) + hashEnum(it.next());
                int i6 = getAuthRequestContext + 19;
                PlaceComponentResult = i6 % 128;
                int i7 = i6 % 2;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0023, code lost:
    
        if (r0 != r1) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
    
        if ((r5.size() != r6.size()) != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0037, code lost:
    
        r5 = com.google.protobuf.Internal.PlaceComponentResult + 125;
        com.google.protobuf.Internal.getAuthRequestContext = r5 % 128;
        r5 = r5 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0041, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0042, code lost:
    
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0049, code lost:
    
        if (r0 >= r5.size()) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004b, code lost:
    
        r1 = kotlin.text.Typography.dollar;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004e, code lost:
    
        r1 = '%';
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:
    
        if (r1 == '$') goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0052, code lost:
    
        r5 = com.google.protobuf.Internal.PlaceComponentResult + 11;
        com.google.protobuf.Internal.getAuthRequestContext = r5 % 128;
        r5 = r5 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005c, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006d, code lost:
    
        if (java.util.Arrays.equals(r5.get(r0), r6.get(r0)) != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0071, code lost:
    
        r5 = com.google.protobuf.Internal.getAuthRequestContext + 53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0075, code lost:
    
        com.google.protobuf.Internal.PlaceComponentResult = r5 % 128;
        r5 = r5 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0079, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007a, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007b, code lost:
    
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007c, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x007d, code lost:
    
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x007e, code lost:
    
        r0 = r0 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean equals(java.util.List<byte[]> r5, java.util.List<byte[]> r6) {
        /*
            int r0 = com.google.protobuf.Internal.PlaceComponentResult
            int r0 = r0 + 13
            int r1 = r0 % 128
            com.google.protobuf.Internal.getAuthRequestContext = r1
            int r0 = r0 % 2
            r1 = 88
            if (r0 == 0) goto L11
            r0 = 63
            goto L13
        L11:
            r0 = 88
        L13:
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L28
            int r0 = r5.size()
            int r1 = r6.size()
            r4 = 0
            r4.hashCode()     // Catch: java.lang.Throwable -> L26
            if (r0 == r1) goto L42
            goto L37
        L26:
            r5 = move-exception
            throw r5
        L28:
            int r0 = r5.size()
            int r1 = r6.size()
            if (r0 == r1) goto L34
            r0 = 1
            goto L35
        L34:
            r0 = 0
        L35:
            if (r0 == 0) goto L42
        L37:
            int r5 = com.google.protobuf.Internal.PlaceComponentResult
            int r5 = r5 + 125
            int r6 = r5 % 128
            com.google.protobuf.Internal.getAuthRequestContext = r6
            int r5 = r5 % 2
            return r3
        L42:
            r0 = 0
        L43:
            int r1 = r5.size()
            r4 = 36
            if (r0 >= r1) goto L4e
            r1 = 36
            goto L50
        L4e:
            r1 = 37
        L50:
            if (r1 == r4) goto L5d
            int r5 = com.google.protobuf.Internal.PlaceComponentResult
            int r5 = r5 + 11
            int r6 = r5 % 128
            com.google.protobuf.Internal.getAuthRequestContext = r6
            int r5 = r5 % 2
            return r2
        L5d:
            java.lang.Object r1 = r5.get(r0)
            byte[] r1 = (byte[]) r1
            java.lang.Object r4 = r6.get(r0)
            byte[] r4 = (byte[]) r4
            boolean r1 = java.util.Arrays.equals(r1, r4)
            if (r1 != 0) goto L7e
            int r5 = com.google.protobuf.Internal.getAuthRequestContext     // Catch: java.lang.Exception -> L7c
            int r5 = r5 + 53
            int r6 = r5 % 128
            com.google.protobuf.Internal.PlaceComponentResult = r6     // Catch: java.lang.Exception -> L7a
            int r5 = r5 % 2
            return r3
        L7a:
            r5 = move-exception
            throw r5
        L7c:
            r5 = move-exception
            throw r5
        L7e:
            int r0 = r0 + 1
            goto L43
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Internal.equals(java.util.List, java.util.List):boolean");
    }

    public static int hashCode(List<byte[]> list) {
        int i = getAuthRequestContext + 51;
        PlaceComponentResult = i % 128;
        char c = i % 2 == 0 ? 'E' : InputCardNumberView.DIVIDER;
        Iterator<byte[]> it = list.iterator();
        int i2 = c != ' ' ? 0 : 1;
        while (true) {
            if (!(it.hasNext())) {
                break;
            }
            try {
                int i3 = getAuthRequestContext + 77;
                try {
                    PlaceComponentResult = i3 % 128;
                    int i4 = i3 % 2;
                    i2 = (i2 * 31) + hashCode(it.next());
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
            throw e;
        }
        int i5 = getAuthRequestContext + 5;
        PlaceComponentResult = i5 % 128;
        if (i5 % 2 != 0) {
            return i2;
        }
        int i6 = 78 / 0;
        return i2;
    }

    public static int hashCode(byte[] bArr) {
        int i = PlaceComponentResult + 75;
        getAuthRequestContext = i % 128;
        if ((i % 2 != 0 ? 'G' : '[') != '[') {
            return hashCode(bArr, 0, bArr.length);
        }
        try {
            return hashCode(bArr, 0, bArr.length);
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
    
        if ((r3 == 0 ? '#' : 'a') != 'a') goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
    
        r2 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:
    
        if ((r3 == 0) != true) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0033, code lost:
    
        r3 = com.google.protobuf.Internal.getAuthRequestContext + 11;
        com.google.protobuf.Internal.PlaceComponentResult = r3 % 128;
        r3 = r3 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003d, code lost:
    
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static int hashCode(byte[] r3, int r4, int r5) {
        /*
            int r0 = com.google.protobuf.Internal.getAuthRequestContext
            int r0 = r0 + 45
            int r1 = r0 % 128
            com.google.protobuf.Internal.PlaceComponentResult = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            if (r0 == 0) goto L25
            int r3 = partialHash(r5, r3, r4, r5)
            r4 = 97
            if (r3 != 0) goto L1e
            r5 = 35
            goto L20
        L1e:
            r5 = 97
        L20:
            if (r5 == r4) goto L23
            goto L33
        L23:
            r2 = r3
            goto L33
        L25:
            int r3 = partialHash(r5, r3, r4, r5)
            r4 = 0
            r4.hashCode()     // Catch: java.lang.Throwable -> L3e
            if (r3 != 0) goto L30
            r1 = 1
        L30:
            if (r1 == r2) goto L33
            goto L23
        L33:
            int r3 = com.google.protobuf.Internal.getAuthRequestContext
            int r3 = r3 + 11
            int r4 = r3 % 128
            com.google.protobuf.Internal.PlaceComponentResult = r4
            int r3 = r3 % 2
            return r2
        L3e:
            r3 = move-exception
            goto L41
        L40:
            throw r3
        L41:
            goto L40
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Internal.hashCode(byte[], int, int):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int partialHash(int i, byte[] bArr, int i2, int i3) {
        try {
            int i4 = PlaceComponentResult + 53;
            getAuthRequestContext = i4 % 128;
            if (!(i4 % 2 == 0)) {
                int i5 = 91 / 0;
            }
            int i6 = i2;
            while (true) {
                if (!(i6 < i2 + i3)) {
                    return i;
                }
                int i7 = PlaceComponentResult + 99;
                getAuthRequestContext = i7 % 128;
                int i8 = i7 % 2;
                i = (i * 31) + bArr[i6];
                i6++;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static boolean equalsByteBuffer(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        int i = PlaceComponentResult + 71;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        if (!(byteBuffer.capacity() == byteBuffer2.capacity())) {
            return false;
        }
        boolean equals = byteBuffer.duplicate().clear().equals(byteBuffer2.duplicate().clear());
        int i3 = getAuthRequestContext + 41;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
        return equals;
    }

    public static boolean equalsByteBuffer(List<ByteBuffer> list, List<ByteBuffer> list2) {
        try {
            int i = PlaceComponentResult + 111;
            try {
                getAuthRequestContext = i % 128;
                int i2 = i % 2;
                if (list.size() != list2.size()) {
                    return false;
                }
                int i3 = 0;
                while (true) {
                    if ((i3 < list.size() ? JSONLexer.EOI : '^') != 26) {
                        return true;
                    }
                    if ((!equalsByteBuffer(list.get(i3), list2.get(i3)) ? '3' : (char) 22) != 22) {
                        int i4 = getAuthRequestContext + 69;
                        PlaceComponentResult = i4 % 128;
                        int i5 = i4 % 2;
                        int i6 = getAuthRequestContext + 103;
                        PlaceComponentResult = i6 % 128;
                        int i7 = i6 % 2;
                        return false;
                    }
                    i3++;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static int hashCodeByteBuffer(List<ByteBuffer> list) {
        ByteBuffer next;
        int i;
        int i2 = getAuthRequestContext + 93;
        PlaceComponentResult = i2 % 128;
        int i3 = i2 % 2;
        try {
            Iterator<ByteBuffer> it = list.iterator();
            try {
                int i4 = getAuthRequestContext + 15;
                PlaceComponentResult = i4 % 128;
                int i5 = i4 % 2;
                int i6 = 1;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    int i7 = getAuthRequestContext + 97;
                    PlaceComponentResult = i7 % 128;
                    if (i7 % 2 == 0) {
                        next = it.next();
                        i = i6 * 121;
                    } else {
                        next = it.next();
                        i = i6 * 31;
                    }
                    i6 = i + hashCodeByteBuffer(next);
                }
                int i8 = PlaceComponentResult + 37;
                getAuthRequestContext = i8 % 128;
                if ((i8 % 2 != 0 ? (char) 17 : '%') != '%') {
                    int i9 = 60 / 0;
                    return i6;
                }
                return i6;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static int hashCodeByteBuffer(ByteBuffer byteBuffer) {
        try {
            if (!byteBuffer.hasArray()) {
                int i = 4096;
                if ((byteBuffer.capacity() <= 4096 ? (char) 28 : 'X') == 28) {
                    i = byteBuffer.capacity();
                    int i2 = PlaceComponentResult + 91;
                    getAuthRequestContext = i2 % 128;
                    int i3 = i2 % 2;
                }
                byte[] bArr = new byte[i];
                ByteBuffer duplicate = byteBuffer.duplicate();
                try {
                    duplicate.clear();
                    int capacity = byteBuffer.capacity();
                    while (true) {
                        if ((duplicate.remaining() > 0 ? 'c' : 'E') != 'c') {
                            break;
                        }
                        int remaining = (duplicate.remaining() <= i ? '=' : '!') != '=' ? i : duplicate.remaining();
                        duplicate.get(bArr, 0, remaining);
                        capacity = partialHash(capacity, bArr, 0, remaining);
                    }
                    if (capacity == 0) {
                        int i4 = PlaceComponentResult + 7;
                        getAuthRequestContext = i4 % 128;
                        int i5 = i4 % 2;
                        return 1;
                    }
                    return capacity;
                } catch (Exception e) {
                    throw e;
                }
            }
            int i6 = PlaceComponentResult + 61;
            getAuthRequestContext = i6 % 128;
            int i7 = i6 % 2;
            int partialHash = partialHash(byteBuffer.capacity(), byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
            if (partialHash != 0) {
                return partialHash;
            }
            return 1;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static <T extends MessageLite> T getDefaultInstance(Class<T> cls) {
        int i = PlaceComponentResult + 61;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        try {
            java.lang.reflect.Method method = cls.getMethod("getDefaultInstance", new Class[0]);
            T t = (T) method.invoke(method, new Object[0]);
            try {
                int i3 = PlaceComponentResult + 31;
                try {
                    getAuthRequestContext = i3 % 128;
                    int i4 = i3 % 2;
                    return t;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        } catch (Exception e3) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to get default instance for ");
            sb.append(cls);
            throw new RuntimeException(sb.toString(), e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object mergeMessage(Object obj, Object obj2) {
        int i = getAuthRequestContext + 49;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        MessageLite buildPartial = ((MessageLite) obj).toBuilder().mergeFrom((MessageLite) obj2).buildPartial();
        int i3 = getAuthRequestContext + 61;
        PlaceComponentResult = i3 % 128;
        if ((i3 % 2 == 0 ? 'O' : '=') != '=') {
            int i4 = 48 / 0;
            return buildPartial;
        }
        return buildPartial;
    }

    /* loaded from: classes.dex */
    public static class ListAdapter<F, T> extends AbstractList<T> {
        private final Converter<F, T> converter;
        private final List<F> fromList;

        /* loaded from: classes.dex */
        public interface Converter<F, T> {
            T convert(F f);
        }

        public ListAdapter(List<F> list, Converter<F, T> converter) {
            this.fromList = list;
            this.converter = converter;
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int i) {
            return this.converter.convert(this.fromList.get(i));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }
    }

    /* loaded from: classes.dex */
    public static class MapAdapter<K, V, RealValue> extends AbstractMap<K, V> {
        private final Map<K, RealValue> realMap;
        private final Converter<RealValue, V> valueConverter;

        /* loaded from: classes7.dex */
        public interface Converter<A, B> {
            A doBackward(B b);

            B doForward(A a2);
        }

        public static <T extends EnumLite> Converter<Integer, T> newEnumConverter(final EnumLiteMap<T> enumLiteMap, final T t) {
            return (Converter<Integer, T>) new Converter<Integer, T>() { // from class: com.google.protobuf.Internal.MapAdapter.1
                /* JADX WARN: Incorrect return type in method signature: (Ljava/lang/Integer;)TT; */
                @Override // com.google.protobuf.Internal.MapAdapter.Converter
                public final EnumLite doForward(Integer num) {
                    EnumLite findValueByNumber = EnumLiteMap.this.findValueByNumber(num.intValue());
                    return findValueByNumber == null ? t : findValueByNumber;
                }

                /* JADX WARN: Incorrect types in method signature: (TT;)Ljava/lang/Integer; */
                @Override // com.google.protobuf.Internal.MapAdapter.Converter
                public final Integer doBackward(EnumLite enumLite) {
                    return Integer.valueOf(enumLite.getNumber());
                }
            };
        }

        public MapAdapter(Map<K, RealValue> map, Converter<RealValue, V> converter) {
            this.realMap = map;
            this.valueConverter = converter;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            RealValue realvalue = this.realMap.get(obj);
            if (realvalue == null) {
                return null;
            }
            return this.valueConverter.doForward(realvalue);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K k, V v) {
            RealValue put = this.realMap.put(k, this.valueConverter.doBackward(v));
            if (put == null) {
                return null;
            }
            return this.valueConverter.doForward(put);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return new SetAdapter(this.realMap.entrySet());
        }

        /* loaded from: classes7.dex */
        class SetAdapter extends AbstractSet<Map.Entry<K, V>> {
            private final Set<Map.Entry<K, RealValue>> realSet;

            public SetAdapter(Set<Map.Entry<K, RealValue>> set) {
                this.realSet = set;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                return new IteratorAdapter(this.realSet.iterator());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return this.realSet.size();
            }
        }

        /* loaded from: classes7.dex */
        class IteratorAdapter implements Iterator<Map.Entry<K, V>>, j$.util.Iterator {
            private final Iterator<Map.Entry<K, RealValue>> realIterator;

            @Override // j$.util.Iterator
            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                Iterator.CC.getAuthRequestContext(this, consumer);
            }

            @Override // java.util.Iterator
            public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
            }

            public IteratorAdapter(java.util.Iterator<Map.Entry<K, RealValue>> it) {
                this.realIterator = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.realIterator.hasNext();
            }

            @Override // java.util.Iterator
            public Map.Entry<K, V> next() {
                return new EntryAdapter(this.realIterator.next());
            }

            @Override // java.util.Iterator
            public void remove() {
                this.realIterator.remove();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes7.dex */
        public class EntryAdapter implements Map.Entry<K, V> {
            private final Map.Entry<K, RealValue> realEntry;

            public EntryAdapter(Map.Entry<K, RealValue> entry) {
                this.realEntry = entry;
            }

            @Override // java.util.Map.Entry
            public K getKey() {
                return this.realEntry.getKey();
            }

            @Override // java.util.Map.Entry
            public V getValue() {
                return (V) MapAdapter.this.valueConverter.doForward(this.realEntry.getValue());
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Map.Entry
            public V setValue(V v) {
                Object value = this.realEntry.setValue(MapAdapter.this.valueConverter.doBackward(v));
                if (value == null) {
                    return null;
                }
                return (V) MapAdapter.this.valueConverter.doForward(value);
            }

            @Override // java.util.Map.Entry
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                return (obj instanceof Map.Entry) && getKey().equals(((Map.Entry) obj).getKey()) && getValue().equals(getValue());
            }

            @Override // java.util.Map.Entry
            public int hashCode() {
                return this.realEntry.hashCode();
            }
        }
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        getonboardingscenario.MyBillsEntityDataFactory = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (true) {
            if ((getonboardingscenario.getAuthRequestContext < cArr.length ? (char) 3 : 'Y') == 'Y') {
                break;
            }
            int i2 = $10 + 3;
            $11 = i2 % 128;
            int i3 = i2 % 2;
            try {
                jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (KClassImpl$Data$declaredNonStaticMembers$2 ^ 4796183387843776835L);
                getonboardingscenario.getAuthRequestContext++;
            } catch (Exception e) {
                throw e;
            }
        }
        char[] cArr2 = new char[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (true) {
            if (getonboardingscenario.getAuthRequestContext >= cArr.length) {
                objArr[0] = new String(cArr2);
                return;
            }
            int i4 = $11 + 49;
            $10 = i4 % 128;
            if (i4 % 2 == 0) {
                cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
                getonboardingscenario.getAuthRequestContext++;
            } else {
                try {
                    cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
                    getonboardingscenario.getAuthRequestContext >>>= 0;
                } catch (Exception e2) {
                    throw e2;
                }
            }
        }
    }
}
