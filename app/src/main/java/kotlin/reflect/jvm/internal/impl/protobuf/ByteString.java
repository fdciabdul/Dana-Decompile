package kotlin.reflect.jvm.internal.impl.protobuf;

import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.text.Typography;
import o.whenAvailable;

/* loaded from: classes.dex */
public abstract class ByteString implements Iterable<Byte> {
    private static int $10 = 0;
    private static int $11 = 1;
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static long BuiltInFictitiousFunctionClassFactory = 0;
    public static final ByteString EMPTY;
    private static char[] KClassImpl$Data$declaredNonStaticMembers$2 = null;
    public static final int MyBillsEntityDataFactory;
    public static final byte[] PlaceComponentResult;
    private static int getAuthRequestContext = 0;
    private static int lookAheadTest = 1;

    /* loaded from: classes.dex */
    public interface ByteIterator extends Iterator<Byte> {
        byte nextByte();
    }

    static void MyBillsEntityDataFactory() {
        KClassImpl$Data$declaredNonStaticMembers$2 = new char[]{48363, 53658, 26136, 62659, 2374};
        BuiltInFictitiousFunctionClassFactory = -7942680373563580866L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0029, code lost:
    
        r3 = r1;
        r4 = 0;
        r1 = r0;
        r0 = r10;
        r10 = r9;
        r9 = r8;
        r8 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004d, code lost:
    
        if ((r0 == null ? 27 : kotlin.text.Typography.amp) != 27) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0050, code lost:
    
        r3 = r1;
        r4 = 0;
        r1 = r0;
        r0 = r10;
        r10 = r9;
        r9 = r8;
        r8 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0026, code lost:
    
        if (r0 == null) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0057 -> B:20:0x005e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(short r7, int r8, int r9, java.lang.Object[] r10) {
        /*
            int r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.getAuthRequestContext
            int r0 = r0 + 99
            int r1 = r0 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString.lookAheadTest = r1
            int r0 = r0 % 2
            r1 = 74
            if (r0 != 0) goto L11
            r0 = 74
            goto L13
        L11:
            r0 = 95
        L13:
            r2 = 0
            if (r0 == r1) goto L31
            int r9 = r9 + 105
            int r8 = r8 * 4
            int r8 = r8 + 16
            byte[] r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.PlaceComponentResult
            int r7 = r7 * 15
            int r7 = r7 + 4
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            if (r0 != 0) goto L29
            goto L50
        L29:
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            goto L5e
        L31:
            int r9 = r9 + 108
            r0 = 5
            int r8 = r0 << r8
            int r8 = r8 + 124
            byte[] r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.PlaceComponentResult
            r1 = 62
            int r7 = r1 >> r7
            int r7 = r7 + 13
            byte[] r1 = new byte[r8]
            int r8 = r8 + 36
            r3 = 27
            if (r0 != 0) goto L4b
            r4 = 27
            goto L4d
        L4b:
            r4 = 38
        L4d:
            if (r4 == r3) goto L50
            goto L29
        L50:
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            r8 = r7
        L57:
            int r7 = -r7
            int r8 = r8 + 1
            int r10 = r10 + r7
            int r7 = r10 + 2
            r10 = r7
        L5e:
            byte r7 = (byte) r10
            r3[r4] = r7
            if (r4 != r9) goto L6b
            java.lang.String r7 = new java.lang.String
            r7.<init>(r3, r2)
            r0[r2] = r7
            return
        L6b:
            r7 = r1[r8]
            int r4 = r4 + 1
            int r5 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.lookAheadTest
            int r5 = r5 + 117
            int r6 = r5 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString.getAuthRequestContext = r6
            int r5 = r5 % 2
            goto L57
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.ByteString.b(short, int, int, java.lang.Object[]):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void copyToInternal(byte[] bArr, int i, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int getTreeDepth();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean isBalanced();

    public abstract boolean isValidUtf8();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.Iterable
    public abstract Iterator<Byte> iterator();

    public abstract CodedInputStream newCodedInput();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int partialHash(int i, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int partialIsValidUtf8(int i, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int peekCachedHashCode();

    public abstract int size();

    public abstract String toString(String str) throws UnsupportedEncodingException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void writeToInternal(OutputStream outputStream, int i, int i2) throws IOException;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
        int i = getAuthRequestContext + 105;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        Iterator<Byte> it = iterator();
        int i3 = getAuthRequestContext + 117;
        lookAheadTest = i3 % 128;
        if ((i3 % 2 == 0 ? ')' : Typography.dollar) != ')') {
            return it;
        }
        int i4 = 31 / 0;
        return it;
    }

    static {
        MyBillsEntityDataFactory();
        PlaceComponentResult = new byte[]{109, -87, 105, -77, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
        MyBillsEntityDataFactory = 21;
        EMPTY = new LiteralByteString(new byte[0]);
        int i = lookAheadTest + 125;
        getAuthRequestContext = i % 128;
        if ((i % 2 != 0 ? '4' : (char) 2) != '4') {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0019, code lost:
    
        if ((r0 == 0) != true) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0022, code lost:
    
        if (size() == 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0024, code lost:
    
        r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.getAuthRequestContext + 59;
        kotlin.reflect.jvm.internal.impl.protobuf.ByteString.lookAheadTest = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002e, code lost:
    
        if ((r0 % 2) != 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0033, code lost:
    
        r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.getAuthRequestContext + 35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0037, code lost:
    
        kotlin.reflect.jvm.internal.impl.protobuf.ByteString.lookAheadTest = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
    
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003d, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003e, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003f, code lost:
    
        r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.getAuthRequestContext + 43;
        kotlin.reflect.jvm.internal.impl.protobuf.ByteString.lookAheadTest = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0049, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:?, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean isEmpty() {
        /*
            r4 = this;
            int r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.lookAheadTest     // Catch: java.lang.Exception -> L4a
            int r0 = r0 + 107
            int r1 = r0 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString.getAuthRequestContext = r1     // Catch: java.lang.Exception -> L4a
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L1e
            int r0 = r4.size()
            r3 = 0
            int r3 = r3.length     // Catch: java.lang.Throwable -> L1c
            if (r0 != 0) goto L18
            r0 = 1
            goto L19
        L18:
            r0 = 0
        L19:
            if (r0 == r1) goto L24
            goto L3f
        L1c:
            r0 = move-exception
            throw r0
        L1e:
            int r0 = r4.size()
            if (r0 != 0) goto L3f
        L24:
            int r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.getAuthRequestContext
            int r0 = r0 + 59
            int r3 = r0 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString.lookAheadTest = r3
            int r0 = r0 % 2
            if (r0 != 0) goto L31
            r1 = 0
        L31:
            int r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.getAuthRequestContext     // Catch: java.lang.Exception -> L3d
            int r0 = r0 + 35
            int r2 = r0 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString.lookAheadTest = r2     // Catch: java.lang.Exception -> L3d
            int r0 = r0 % 2
            r2 = r1
            goto L49
        L3d:
            r0 = move-exception
            throw r0
        L3f:
            int r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.getAuthRequestContext
            int r0 = r0 + 43
            int r1 = r0 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString.lookAheadTest = r1
            int r0 = r0 % 2
        L49:
            return r2
        L4a:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.ByteString.isEmpty():boolean");
    }

    public static ByteString copyFrom(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        LiteralByteString literalByteString = new LiteralByteString(bArr2);
        int i3 = getAuthRequestContext + 71;
        lookAheadTest = i3 % 128;
        int i4 = i3 % 2;
        return literalByteString;
    }

    public static ByteString copyFrom(byte[] bArr) {
        int i = lookAheadTest + 39;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        ByteString copyFrom = copyFrom(bArr, 0, bArr.length);
        int i3 = getAuthRequestContext + 121;
        lookAheadTest = i3 % 128;
        int i4 = i3 % 2;
        return copyFrom;
    }

    public static ByteString copyFromUtf8(String str) {
        try {
            Object[] objArr = new Object[1];
            a(TextUtils.getTrimmedLength(""), 4 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 20463), objArr);
            LiteralByteString literalByteString = new LiteralByteString(str.getBytes(((String) objArr[0]).intern()));
            int i = getAuthRequestContext + 23;
            lookAheadTest = i % 128;
            if ((i % 2 == 0 ? Typography.dollar : '?') != '$') {
                return literalByteString;
            }
            Object obj = null;
            obj.hashCode();
            return literalByteString;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }

    public ByteString concat(ByteString byteString) {
        int i = lookAheadTest + 61;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        try {
            int size = size();
            int size2 = byteString.size();
            if ((((long) size) + ((long) size2) < 2147483647L ? '%' : '5') != '%') {
                StringBuilder sb = new StringBuilder(53);
                sb.append("ByteString would be too long: ");
                sb.append(size);
                sb.append("+");
                sb.append(size2);
                throw new IllegalArgumentException(sb.toString());
            }
            int i3 = lookAheadTest + 51;
            getAuthRequestContext = i3 % 128;
            if (i3 % 2 == 0) {
                return RopeByteString.concatenate(this, byteString);
            }
            try {
                ByteString concatenate = RopeByteString.concatenate(this, byteString);
                Object obj = null;
                obj.hashCode();
                return concatenate;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static ByteString copyFrom(Iterable<ByteString> iterable) {
        Collection collection;
        if (iterable instanceof Collection) {
            collection = (Collection) iterable;
        } else {
            collection = new ArrayList();
            Iterator<ByteString> it = iterable.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                int i = lookAheadTest + 59;
                getAuthRequestContext = i % 128;
                if (i % 2 != 0) {
                    collection.add(it.next());
                    int i2 = 18 / 0;
                } else {
                    collection.add(it.next());
                }
            }
        }
        if (collection.isEmpty()) {
            try {
                int i3 = lookAheadTest + 45;
                getAuthRequestContext = i3 % 128;
                if (i3 % 2 != 0) {
                    ByteString byteString = EMPTY;
                    Object obj = null;
                    obj.hashCode();
                    return byteString;
                }
                return EMPTY;
            } catch (Exception e) {
                throw e;
            }
        }
        return balancedConcat(collection.iterator(), collection.size());
    }

    private static ByteString balancedConcat(Iterator<ByteString> it, int i) {
        ByteString next;
        int i2 = lookAheadTest + 55;
        getAuthRequestContext = i2 % 128;
        int i3 = i2 % 2;
        if ((i == 1 ? '\n' : '2') == '\n') {
            next = it.next();
            int i4 = lookAheadTest + 61;
            getAuthRequestContext = i4 % 128;
            int i5 = i4 % 2;
        } else {
            int i6 = i >>> 1;
            next = balancedConcat(it, i6).concat(balancedConcat(it, i - i6));
        }
        int i7 = getAuthRequestContext + 61;
        lookAheadTest = i7 % 128;
        int i8 = i7 % 2;
        return next;
    }

    public void copyTo(byte[] bArr, int i, int i2, int i3) {
        int i4;
        if (!(i >= 0)) {
            StringBuilder sb = new StringBuilder(30);
            sb.append("Source offset < 0: ");
            sb.append(i);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (i2 < 0) {
            StringBuilder sb2 = new StringBuilder(30);
            sb2.append("Target offset < 0: ");
            sb2.append(i2);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        try {
            if ((i3 >= 0 ? (char) 16 : 'N') == 16) {
                int i5 = getAuthRequestContext + 55;
                lookAheadTest = i5 % 128;
                int i6 = i5 % 2;
                int i7 = i + i3;
                if (i7 <= size()) {
                    int i8 = lookAheadTest + 49;
                    getAuthRequestContext = i8 % 128;
                    if ((i8 % 2 != 0 ? 'E' : '6') == '6' ? (i4 = i2 + i3) > bArr.length : (i4 = i2 >>> i3) > bArr.length) {
                        StringBuilder sb3 = new StringBuilder(34);
                        sb3.append("Target end offset < 0: ");
                        sb3.append(i4);
                        throw new IndexOutOfBoundsException(sb3.toString());
                    } else if (i3 > 0) {
                        copyToInternal(bArr, i, i2, i3);
                        int i9 = lookAheadTest + 99;
                        getAuthRequestContext = i9 % 128;
                        int i10 = i9 % 2;
                        return;
                    } else {
                        return;
                    }
                }
                StringBuilder sb4 = new StringBuilder(34);
                sb4.append("Source end offset < 0: ");
                sb4.append(i7);
                throw new IndexOutOfBoundsException(sb4.toString());
            }
            StringBuilder sb5 = new StringBuilder(23);
            sb5.append("Length < 0: ");
            sb5.append(i3);
            throw new IndexOutOfBoundsException(sb5.toString());
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
    
        if (r0 == 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002c, code lost:
    
        if ((r0 != 0) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002e, code lost:
    
        r1 = new byte[r0];
        copyToInternal(r1, 0, 0, r0);
        r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.lookAheadTest + 113;
        kotlin.reflect.jvm.internal.impl.protobuf.ByteString.getAuthRequestContext = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003d, code lost:
    
        if ((r0 % 2) == 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0041, code lost:
    
        r0 = 11 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0042, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0045, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0046, code lost:
    
        r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.getAuthRequestContext + 25;
        kotlin.reflect.jvm.internal.impl.protobuf.ByteString.lookAheadTest = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0050, code lost:
    
        if ((r0 % 2) != 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0052, code lost:
    
        r0 = kotlin.reflect.jvm.internal.impl.protobuf.Internal.EMPTY_BYTE_ARRAY;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0054, code lost:
    
        r1 = r2.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x005a, code lost:
    
        return kotlin.reflect.jvm.internal.impl.protobuf.Internal.EMPTY_BYTE_ARRAY;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:?, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] toByteArray() {
        /*
            r4 = this;
            int r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.lookAheadTest
            int r0 = r0 + 111
            int r1 = r0 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString.getAuthRequestContext = r1
            int r0 = r0 % 2
            r1 = 39
            if (r0 == 0) goto L11
            r0 = 76
            goto L13
        L11:
            r0 = 39
        L13:
            r2 = 0
            r3 = 0
            if (r0 == r1) goto L23
            int r0 = r4.size()     // Catch: java.lang.Exception -> L21
            int r1 = r2.length     // Catch: java.lang.Throwable -> L1f
            if (r0 != 0) goto L2e
            goto L46
        L1f:
            r0 = move-exception
            throw r0
        L21:
            r0 = move-exception
            goto L5b
        L23:
            int r0 = r4.size()     // Catch: java.lang.Exception -> L5c
            if (r0 != 0) goto L2b
            r1 = 0
            goto L2c
        L2b:
            r1 = 1
        L2c:
            if (r1 == 0) goto L46
        L2e:
            byte[] r1 = new byte[r0]
            r4.copyToInternal(r1, r3, r3, r0)
            int r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.lookAheadTest
            int r0 = r0 + 113
            int r2 = r0 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString.getAuthRequestContext = r2
            int r0 = r0 % 2
            if (r0 == 0) goto L45
            r0 = 11
            int r0 = r0 / r3
            return r1
        L43:
            r0 = move-exception
            throw r0
        L45:
            return r1
        L46:
            int r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.getAuthRequestContext     // Catch: java.lang.Exception -> L5c
            int r0 = r0 + 25
            int r1 = r0 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString.lookAheadTest = r1     // Catch: java.lang.Exception -> L5c
            int r0 = r0 % 2
            if (r0 != 0) goto L58
            byte[] r0 = kotlin.reflect.jvm.internal.impl.protobuf.Internal.EMPTY_BYTE_ARRAY
            int r1 = r2.length     // Catch: java.lang.Throwable -> L56
            goto L5a
        L56:
            r0 = move-exception
            throw r0
        L58:
            byte[] r0 = kotlin.reflect.jvm.internal.impl.protobuf.Internal.EMPTY_BYTE_ARRAY     // Catch: java.lang.Exception -> L21
        L5a:
            return r0
        L5b:
            throw r0
        L5c:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.ByteString.toByteArray():byte[]");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
    
        if (r5 >= 0) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0017, code lost:
    
        r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.lookAheadTest + 79;
        kotlin.reflect.jvm.internal.impl.protobuf.ByteString.getAuthRequestContext = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
    
        if (r6 < 0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0024, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0026, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
    
        if (r1 != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0029, code lost:
    
        r1 = r5 + r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
    
        if (r1 > size()) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0033, code lost:
    
        if (r6 <= 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0035, code lost:
    
        r2 = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0038, code lost:
    
        r2 = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003a, code lost:
    
        if (r2 == 15) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003c, code lost:
    
        r1 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.getAuthRequestContext + 77;
        kotlin.reflect.jvm.internal.impl.protobuf.ByteString.lookAheadTest = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0046, code lost:
    
        if ((r1 % 2) != 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0048, code lost:
    
        writeToInternal(r4, r5, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004d, code lost:
    
        r4 = 35 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0051, code lost:
    
        writeToInternal(r4, r5, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0054, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0055, code lost:
    
        r4 = new java.lang.StringBuilder(39);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005c, code lost:
    
        r4.append("Source end offset exceeded: ");
        r4.append(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006d, code lost:
    
        throw new java.lang.IndexOutOfBoundsException(r4.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006e, code lost:
    
        r4 = new java.lang.StringBuilder(23);
        r4.append("Length < 0: ");
        r4.append(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0086, code lost:
    
        throw new java.lang.IndexOutOfBoundsException(r4.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0087, code lost:
    
        r4 = new java.lang.StringBuilder(30);
        r4.append("Source offset < 0: ");
        r4.append(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x009f, code lost:
    
        throw new java.lang.IndexOutOfBoundsException(r4.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0010, code lost:
    
        if (r5 >= 0) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void writeTo(java.io.OutputStream r4, int r5, int r6) throws java.io.IOException {
        /*
            r3 = this;
            int r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.getAuthRequestContext     // Catch: java.lang.Exception -> La0
            int r0 = r0 + 87
            int r1 = r0 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString.lookAheadTest = r1     // Catch: java.lang.Exception -> La0
            int r0 = r0 % 2
            if (r0 != 0) goto L15
            r0 = 0
            r0.hashCode()     // Catch: java.lang.Throwable -> L13
            if (r5 < 0) goto L87
            goto L17
        L13:
            r4 = move-exception
            throw r4
        L15:
            if (r5 < 0) goto L87
        L17:
            int r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.lookAheadTest
            int r0 = r0 + 79
            int r1 = r0 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString.getAuthRequestContext = r1
            int r0 = r0 % 2
            r0 = 0
            if (r6 < 0) goto L26
            r1 = 0
            goto L27
        L26:
            r1 = 1
        L27:
            if (r1 != 0) goto L6e
            int r1 = r5 + r6
            int r2 = r3.size()
            if (r1 > r2) goto L55
            r1 = 15
            if (r6 <= 0) goto L38
            r2 = 17
            goto L3a
        L38:
            r2 = 15
        L3a:
            if (r2 == r1) goto L54
            int r1 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.getAuthRequestContext
            int r1 = r1 + 77
            int r2 = r1 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString.lookAheadTest = r2
            int r1 = r1 % 2
            if (r1 != 0) goto L51
            r3.writeToInternal(r4, r5, r6)
            r4 = 35
            int r4 = r4 / r0
            goto L54
        L4f:
            r4 = move-exception
            throw r4
        L51:
            r3.writeToInternal(r4, r5, r6)
        L54:
            return
        L55:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r5 = 39
            r4.<init>(r5)
            java.lang.String r5 = "Source end offset exceeded: "
            r4.append(r5)     // Catch: java.lang.Exception -> La0
            r4.append(r1)     // Catch: java.lang.Exception -> La0
            java.lang.IndexOutOfBoundsException r5 = new java.lang.IndexOutOfBoundsException     // Catch: java.lang.Exception -> La0
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> La0
            r5.<init>(r4)     // Catch: java.lang.Exception -> La0
            throw r5     // Catch: java.lang.Exception -> La0
        L6e:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r5 = 23
            r4.<init>(r5)
            java.lang.String r5 = "Length < 0: "
            r4.append(r5)
            r4.append(r6)
            java.lang.IndexOutOfBoundsException r5 = new java.lang.IndexOutOfBoundsException
            java.lang.String r4 = r4.toString()
            r5.<init>(r4)
            throw r5
        L87:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r6 = 30
            r4.<init>(r6)
            java.lang.String r6 = "Source offset < 0: "
            r4.append(r6)
            r4.append(r5)
            java.lang.IndexOutOfBoundsException r5 = new java.lang.IndexOutOfBoundsException
            java.lang.String r4 = r4.toString()
            r5.<init>(r4)
            throw r5
        La0:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.ByteString.writeTo(java.io.OutputStream, int, int):void");
    }

    public String toStringUtf8() {
        int i = lookAheadTest + 9;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        try {
            Object[] objArr = new Object[1];
            a((-1) - TextUtils.lastIndexOf("", '0', 0, 0), 5 - (Process.myPid() >> 22), (char) (20464 - View.MeasureSpec.makeMeasureSpec(0, 0)), objArr);
            String byteString = toString(((String) objArr[0]).intern());
            int i3 = getAuthRequestContext + 111;
            lookAheadTest = i3 % 128;
            int i4 = i3 % 2;
            return byteString;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }

    public static Output newOutput() {
        Output output = new Output(128);
        int i = lookAheadTest + 95;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        return output;
    }

    /* loaded from: classes.dex */
    public static final class Output extends OutputStream {
        private byte[] buffer;
        private int bufferPos;
        private final ArrayList<ByteString> flushedBuffers;
        private int flushedBuffersTotalBytes;
        private final int initialCapacity;
        public static final byte[] PlaceComponentResult = {112, -20, -94, -81, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
        public static final int MyBillsEntityDataFactory = 153;
        private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

        /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x002d). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void a(short r7, byte r8, short r9, java.lang.Object[] r10) {
            /*
                int r8 = r8 * 15
                int r8 = r8 + 4
                byte[] r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.Output.PlaceComponentResult
                int r7 = r7 * 3
                int r7 = r7 + 16
                int r9 = r9 + 105
                byte[] r1 = new byte[r7]
                r2 = 0
                if (r0 != 0) goto L15
                r3 = r9
                r4 = 0
                r9 = r8
                goto L2d
            L15:
                r3 = 0
            L16:
                r6 = r9
                r9 = r8
                r8 = r6
                int r4 = r3 + 1
                byte r5 = (byte) r8
                r1[r3] = r5
                if (r4 != r7) goto L28
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                r10[r2] = r7
                return
            L28:
                r3 = r0[r9]
                r6 = r9
                r9 = r8
                r8 = r6
            L2d:
                int r8 = r8 + 1
                int r3 = -r3
                int r9 = r9 + r3
                int r9 = r9 + 2
                r3 = r4
                goto L16
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.ByteString.Output.a(short, byte, short, java.lang.Object[]):void");
        }

        Output(int i) {
            if (i < 0) {
                throw new IllegalArgumentException("Buffer size < 0");
            }
            this.initialCapacity = i;
            this.flushedBuffers = new ArrayList<>();
            this.buffer = new byte[i];
        }

        @Override // java.io.OutputStream
        public final void write(int i) {
            synchronized (this) {
                if (this.bufferPos == this.buffer.length) {
                    flushFullBuffer(1);
                }
                byte[] bArr = this.buffer;
                int i2 = this.bufferPos;
                this.bufferPos = i2 + 1;
                bArr[i2] = (byte) i;
            }
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr, int i, int i2) {
            synchronized (this) {
                byte[] bArr2 = this.buffer;
                int length = bArr2.length;
                int i3 = this.bufferPos;
                if (i2 <= length - i3) {
                    System.arraycopy(bArr, i, bArr2, i3, i2);
                    this.bufferPos += i2;
                } else {
                    int length2 = bArr2.length - i3;
                    System.arraycopy(bArr, i, bArr2, i3, length2);
                    int i4 = i2 - length2;
                    flushFullBuffer(i4);
                    System.arraycopy(bArr, i + length2, this.buffer, 0, i4);
                    this.bufferPos = i4;
                }
            }
        }

        public final ByteString toByteString() {
            ByteString copyFrom;
            synchronized (this) {
                flushLastBuffer();
                copyFrom = ByteString.copyFrom(this.flushedBuffers);
            }
            return copyFrom;
        }

        private byte[] copyArray(byte[] bArr, int i) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i));
            return bArr2;
        }

        public final int size() {
            int i;
            int i2;
            synchronized (this) {
                i = this.flushedBuffersTotalBytes;
                i2 = this.bufferPos;
            }
            return i + i2;
        }

        public final String toString() {
            Object[] objArr = new Object[2];
            try {
                Object[] objArr2 = {this};
                byte b = (byte) (PlaceComponentResult[5] - 1);
                byte b2 = PlaceComponentResult[5];
                Object[] objArr3 = new Object[1];
                a(b, b2, b2, objArr3);
                Class<?> cls = Class.forName((String) objArr3[0]);
                byte b3 = (byte) (PlaceComponentResult[5] - 1);
                byte b4 = b3;
                Object[] objArr4 = new Object[1];
                a(b3, b4, b4, objArr4);
                objArr[0] = Integer.toHexString(((Integer) cls.getMethod((String) objArr4[0], Object.class).invoke(null, objArr2)).intValue());
                objArr[1] = Integer.valueOf(size());
                return String.format("<ByteString.Output@%s size=%d>", objArr);
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }

        private void flushFullBuffer(int i) {
            this.flushedBuffers.add(new LiteralByteString(this.buffer));
            int length = this.flushedBuffersTotalBytes + this.buffer.length;
            this.flushedBuffersTotalBytes = length;
            this.buffer = new byte[Math.max(this.initialCapacity, Math.max(i, length >>> 1))];
            this.bufferPos = 0;
        }

        private void flushLastBuffer() {
            int i = this.bufferPos;
            byte[] bArr = this.buffer;
            if (i >= bArr.length) {
                this.flushedBuffers.add(new LiteralByteString(this.buffer));
                this.buffer = EMPTY_BYTE_ARRAY;
            } else if (i > 0) {
                this.flushedBuffers.add(new LiteralByteString(copyArray(bArr, i)));
            }
            this.flushedBuffersTotalBytes += this.bufferPos;
            this.bufferPos = 0;
        }
    }

    public String toString() {
        Object[] objArr = new Object[2];
        int i = getAuthRequestContext + 13;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        try {
            Object[] objArr2 = {this};
            byte b = PlaceComponentResult[5];
            Object[] objArr3 = new Object[1];
            b(b, (byte) (b - 1), PlaceComponentResult[5], objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            byte b2 = (byte) (PlaceComponentResult[5] - 1);
            byte b3 = b2;
            Object[] objArr4 = new Object[1];
            b(b2, b3, b3, objArr4);
            try {
                objArr[0] = Integer.toHexString(((Integer) cls.getMethod((String) objArr4[0], Object.class).invoke(null, objArr2)).intValue());
                try {
                    objArr[1] = Integer.valueOf(size());
                    String format = String.format("<ByteString@%s size=%d>", objArr);
                    int i3 = lookAheadTest + 51;
                    getAuthRequestContext = i3 % 128;
                    int i4 = i3 % 2;
                    return format;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    private static void a(int i, int i2, char c, Object[] objArr) {
        char c2;
        int i3;
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (whenavailable.BuiltInFictitiousFunctionClassFactory < i2) {
            try {
                jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (KClassImpl$Data$declaredNonStaticMembers$2[whenavailable.BuiltInFictitiousFunctionClassFactory + i] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ BuiltInFictitiousFunctionClassFactory))) ^ c;
                whenavailable.BuiltInFictitiousFunctionClassFactory++;
            } catch (Exception e) {
                throw e;
            }
        }
        char[] cArr = new char[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (true) {
            int i4 = whenavailable.BuiltInFictitiousFunctionClassFactory;
            c2 = JSONLexer.EOI;
            if ((i4 < i2 ? JSONLexer.EOI : 'X') == 'X') {
                break;
            }
            try {
                int i5 = $10 + 117;
                $11 = i5 % 128;
                if (i5 % 2 == 0) {
                    cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
                    i3 = whenavailable.BuiltInFictitiousFunctionClassFactory % 0;
                } else {
                    cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
                    i3 = whenavailable.BuiltInFictitiousFunctionClassFactory + 1;
                }
                whenavailable.BuiltInFictitiousFunctionClassFactory = i3;
            } catch (Exception e2) {
                throw e2;
            }
            throw e2;
        }
        String str = new String(cArr);
        int i6 = $10 + 79;
        $11 = i6 % 128;
        if (i6 % 2 != 0) {
            c2 = 'Z';
        }
        if (c2 == 'Z') {
            objArr[0] = str;
            return;
        }
        int i7 = 3 / 0;
        objArr[0] = str;
    }
}
