package kotlin.reflect.jvm.internal.impl.protobuf;

import android.text.TextUtils;
import android.view.ViewConfiguration;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.text.Typography;
import o.D;

/* loaded from: classes.dex */
public final class CodedInputStream {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static long PlaceComponentResult = -9205770631708954080L;
    private final byte[] buffer;
    private final boolean bufferIsImmutable;
    private int bufferPos;
    private int bufferSize;
    private int bufferSizeAfterLimit;
    private int currentLimit;
    private boolean enableAliasing;
    private final InputStream input;
    private int lastTag;
    private int recursionDepth;
    private int recursionLimit;
    private RefillCallback refillCallback;
    private int sizeLimit;
    private int totalBytesRetired;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface RefillCallback {
        void onRefill();
    }

    public static int decodeZigZag32(int i) {
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 49;
        BuiltInFictitiousFunctionClassFactory = i2 % 128;
        int i3 = !(i2 % 2 != 0) ? (i + 0) & (-(i | 0)) : (i >>> 1) ^ (-(i & 1));
        int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 125;
        BuiltInFictitiousFunctionClassFactory = i4 % 128;
        if (i4 % 2 == 0) {
            Object[] objArr = null;
            int length = objArr.length;
            return i3;
        }
        return i3;
    }

    public static long decodeZigZag64(long j) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 75;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if (i % 2 != 0) {
            return (j >>> 1) ^ (-(1 & j));
        }
        return (j << 0) + (-(0 * j));
    }

    public static CodedInputStream newInstance(InputStream inputStream) {
        CodedInputStream codedInputStream = new CodedInputStream(inputStream);
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 63;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        return codedInputStream;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CodedInputStream newInstance(LiteralByteString literalByteString) {
        CodedInputStream codedInputStream = new CodedInputStream(literalByteString);
        try {
            codedInputStream.pushLimit(literalByteString.size());
            int i = BuiltInFictitiousFunctionClassFactory + 103;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            return codedInputStream;
        } catch (InvalidProtocolBufferException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public final int readTag() throws IOException {
        int i;
        try {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            int readRawVarint32 = readRawVarint32();
            this.lastTag = readRawVarint32;
            if (WireFormat.getTagFieldNumber(readRawVarint32) != 0) {
                int i2 = BuiltInFictitiousFunctionClassFactory + 7;
                KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
                if (i2 % 2 == 0) {
                    i = this.lastTag;
                } else {
                    i = this.lastTag;
                    Object[] objArr = null;
                    int length = objArr.length;
                }
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 75;
                BuiltInFictitiousFunctionClassFactory = i3 % 128;
                int i4 = i3 % 2;
                return i;
            }
            throw InvalidProtocolBufferException.invalidTag();
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0020, code lost:
    
        if (r2.lastTag == r3) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0022, code lost:
    
        r3 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory + 61;
        kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2 = r3 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002e, code lost:
    
        if ((r3 % 2) == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0030, code lost:
    
        r3 = '^';
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0033, code lost:
    
        r3 = 'b';
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0035, code lost:
    
        if (r3 == 'b') goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0039, code lost:
    
        r3 = 20 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003b, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003e, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0043, code lost:
    
        throw kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException.invalidEndTag();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0044, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0045, code lost:
    
        throw r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
    
        if (r0 == r3) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void checkLastTagWas(int r3) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
        /*
            r2 = this;
            int r0 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 123
            int r1 = r0 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            r1 = 22
            if (r0 != 0) goto L11
            r0 = 95
            goto L13
        L11:
            r0 = 22
        L13:
            if (r0 == r1) goto L1e
            int r0 = r2.lastTag
            r1 = 0
            int r1 = r1.length     // Catch: java.lang.Throwable -> L1c
            if (r0 != r3) goto L3f
            goto L22
        L1c:
            r3 = move-exception
            throw r3
        L1e:
            int r0 = r2.lastTag
            if (r0 != r3) goto L3f
        L22:
            int r3 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory
            int r3 = r3 + 61
            int r0 = r3 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2 = r0
            int r3 = r3 % 2
            r0 = 98
            if (r3 == 0) goto L33
            r3 = 94
            goto L35
        L33:
            r3 = 98
        L35:
            if (r3 == r0) goto L3e
            r3 = 20
            int r3 = r3 / 0
            return
        L3c:
            r3 = move-exception
            throw r3
        L3e:
            return
        L3f:
            kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r3 = kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException.invalidEndTag()     // Catch: java.lang.Exception -> L44
            throw r3     // Catch: java.lang.Exception -> L44
        L44:
            r3 = move-exception
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.checkLastTagWas(int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
    
        if (r0 != 0) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0024, code lost:
    
        r4 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2 + 55;
        kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory = r4 % 128;
        r4 = r4 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
    
        if (r0 == 1) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
    
        if (r0 == 2) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0034, code lost:
    
        r1 = 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0036, code lost:
    
        r1 = '\'';
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0038, code lost:
    
        if (r1 == '\'') goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003d, code lost:
    
        if (r0 == 3) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003f, code lost:
    
        r1 = '2';
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0042, code lost:
    
        r1 = 'c';
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0045, code lost:
    
        if (r1 == 'c') goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0047, code lost:
    
        if (r0 == 4) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0049, code lost:
    
        r1 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004b, code lost:
    
        r1 = 20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004d, code lost:
    
        if (r1 == 1) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004f, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0050, code lost:
    
        if (r0 != 5) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0052, code lost:
    
        r0 = readRawLittleEndian32();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0056, code lost:
    
        r9.writeRawVarint32(r8);
        r9.writeFixed32NoTag(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005c, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x005d, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x005e, code lost:
    
        throw r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0063, code lost:
    
        throw kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException.invalidWireType();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0064, code lost:
    
        r9.writeRawVarint32(r8);
        skipMessage(r9);
        r8 = kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.makeTag(kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.getTagFieldNumber(r8), 4);
        checkLastTagWas(r8);
        r9.writeRawVarint32(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0078, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0079, code lost:
    
        r0 = readBytes();
        r9.writeRawVarint32(r8);
        r9.writeBytesNoTag(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0083, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0084, code lost:
    
        r0 = readRawLittleEndian64();
        r9.writeRawVarint32(r8);
        r9.writeFixed64NoTag(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x008e, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x008f, code lost:
    
        r0 = readInt64();
        r9.writeRawVarint32(r8);
        r9.writeUInt64NoTag(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0099, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0017, code lost:
    
        if (r0 != 0) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean skipField(int r8, kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream r9) throws java.io.IOException {
        /*
            r7 = this;
            int r0 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 57
            int r1 = r0 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            if (r0 == r3) goto L1a
            int r0 = kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.getTagWireType(r8)
            if (r0 == 0) goto L8f
            goto L24
        L1a:
            int r0 = kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.getTagWireType(r8)
            r4 = 0
            r4.hashCode()     // Catch: java.lang.Throwable -> L9c
            if (r0 == 0) goto L8f
        L24:
            int r4 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2
            int r4 = r4 + 55
            int r5 = r4 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory = r5
            int r4 = r4 % r1
            if (r0 == r3) goto L84
            r4 = 5
            r5 = 39
            if (r0 == r1) goto L36
            r1 = 5
            goto L38
        L36:
            r1 = 39
        L38:
            if (r1 == r5) goto L79
            r1 = 3
            r5 = 99
            if (r0 == r1) goto L42
            r1 = 50
            goto L44
        L42:
            r1 = 99
        L44:
            r6 = 4
            if (r1 == r5) goto L64
            if (r0 == r6) goto L4b
            r1 = 1
            goto L4d
        L4b:
            r1 = 20
        L4d:
            if (r1 == r3) goto L50
            return r2
        L50:
            if (r0 != r4) goto L5f
            int r0 = r7.readRawLittleEndian32()     // Catch: java.lang.Exception -> L5d
            r9.writeRawVarint32(r8)     // Catch: java.lang.Exception -> L9a
            r9.writeFixed32NoTag(r0)     // Catch: java.lang.Exception -> L9a
            return r3
        L5d:
            r8 = move-exception
            throw r8
        L5f:
            kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r8 = kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException.invalidWireType()
            throw r8
        L64:
            r9.writeRawVarint32(r8)
            r7.skipMessage(r9)
            int r8 = kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.getTagFieldNumber(r8)
            int r8 = kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.makeTag(r8, r6)
            r7.checkLastTagWas(r8)
            r9.writeRawVarint32(r8)
            return r3
        L79:
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString r0 = r7.readBytes()
            r9.writeRawVarint32(r8)
            r9.writeBytesNoTag(r0)
            return r3
        L84:
            long r0 = r7.readRawLittleEndian64()
            r9.writeRawVarint32(r8)
            r9.writeFixed64NoTag(r0)
            return r3
        L8f:
            long r0 = r7.readInt64()     // Catch: java.lang.Exception -> L9a
            r9.writeRawVarint32(r8)     // Catch: java.lang.Exception -> L9a
            r9.writeUInt64NoTag(r0)     // Catch: java.lang.Exception -> L9a
            return r3
        L9a:
            r8 = move-exception
            throw r8
        L9c:
            r8 = move-exception
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.skipField(int, kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream):boolean");
    }

    public final void skipMessage(CodedOutputStream codedOutputStream) throws IOException {
        while (true) {
            int readTag = readTag();
            if (readTag == 0) {
                break;
            }
            int i = BuiltInFictitiousFunctionClassFactory + 43;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            if (!(i % 2 == 0)) {
                int i2 = 58 / 0;
                if (!skipField(readTag, codedOutputStream)) {
                    break;
                }
            } else {
                try {
                    if (!skipField(readTag, codedOutputStream)) {
                        break;
                    }
                } catch (Exception e) {
                    throw e;
                }
            }
        }
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 29;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        int i4 = i3 % 2;
    }

    public final double readDouble() throws IOException {
        int i = BuiltInFictitiousFunctionClassFactory + 9;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        double longBitsToDouble = Double.longBitsToDouble(readRawLittleEndian64());
        int i3 = BuiltInFictitiousFunctionClassFactory + 123;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
        return longBitsToDouble;
    }

    public final float readFloat() throws IOException {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 49;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if ((i % 2 == 0 ? '8' : 'B') != 'B') {
            int i2 = 6 / 0;
            return Float.intBitsToFloat(readRawLittleEndian32());
        }
        return Float.intBitsToFloat(readRawLittleEndian32());
    }

    public final long readUInt64() throws IOException {
        int i = BuiltInFictitiousFunctionClassFactory + 49;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        long readRawVarint64 = readRawVarint64();
        try {
            int i3 = BuiltInFictitiousFunctionClassFactory + 67;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
            return readRawVarint64;
        } catch (Exception e) {
            throw e;
        }
    }

    public final long readInt64() throws IOException {
        long readRawVarint64;
        int i = BuiltInFictitiousFunctionClassFactory + 25;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (!(i % 2 == 0)) {
            try {
                readRawVarint64 = readRawVarint64();
                Object obj = null;
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        } else {
            readRawVarint64 = readRawVarint64();
        }
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 99;
        BuiltInFictitiousFunctionClassFactory = i2 % 128;
        int i3 = i2 % 2;
        return readRawVarint64;
    }

    public final int readInt32() throws IOException {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 45;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        int readRawVarint32 = readRawVarint32();
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 125;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        if ((i3 % 2 == 0 ? (char) 24 : '3') != 24) {
            return readRawVarint32;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return readRawVarint32;
    }

    public final long readFixed64() throws IOException {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 121;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if ((i % 2 == 0 ? (char) 0 : (char) 21) != 21) {
            int i2 = 82 / 0;
            return readRawLittleEndian64();
        }
        return readRawLittleEndian64();
    }

    public final int readFixed32() throws IOException {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 105;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        try {
            int readRawLittleEndian32 = readRawLittleEndian32();
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 1;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            int i4 = i3 % 2;
            return readRawLittleEndian32;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0031, code lost:
    
        if ((readRawVarint64() != 0 ? 21 : 'F') != 21) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0033, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0035, code lost:
    
        r0 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2 + 51;
        kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003f, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0040, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001d, code lost:
    
        if (readRawVarint64() != 1) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean readBool() throws java.io.IOException {
        /*
            r7 = this;
            int r0 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 11
            int r1 = r0 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 13
            if (r0 == 0) goto L11
            r0 = 1
            goto L13
        L11:
            r0 = 13
        L13:
            if (r0 == r2) goto L20
            long r2 = r7.readRawVarint64()
            r4 = 1
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L33
            goto L35
        L20:
            long r2 = r7.readRawVarint64()
            r4 = 0
            r0 = 21
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L2f
            r2 = 21
            goto L31
        L2f:
            r2 = 70
        L31:
            if (r2 == r0) goto L35
        L33:
            r1 = 0
            goto L3f
        L35:
            int r0 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L40
            int r0 = r0 + 51
            int r2 = r0 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory = r2     // Catch: java.lang.Exception -> L40
            int r0 = r0 % 2
        L3f:
            return r1
        L40:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.readBool():boolean");
    }

    public final String readString() throws IOException {
        int readRawVarint32 = readRawVarint32();
        int i = this.bufferSize;
        int i2 = this.bufferPos;
        if ((readRawVarint32 <= i - i2 ? 'I' : 'X') == 'I') {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 43;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            int i4 = i3 % 2;
            if (readRawVarint32 > 0) {
                byte[] bArr = this.buffer;
                Object[] objArr = new Object[1];
                a(TextUtils.indexOf((CharSequence) "", '0', 0) + 1, new char[]{19316, 11978, 17122, 19233, 40285, 53590, 48436, 25128, 46188}, objArr);
                String str = new String(bArr, i2, readRawVarint32, ((String) objArr[0]).intern());
                this.bufferPos += readRawVarint32;
                return str;
            }
        }
        if (readRawVarint32 != 0) {
            byte[] readRawBytesSlowPath = readRawBytesSlowPath(readRawVarint32);
            Object[] objArr2 = new Object[1];
            a(1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), new char[]{19316, 11978, 17122, 19233, 40285, 53590, 48436, 25128, 46188}, objArr2);
            String str2 = new String(readRawBytesSlowPath, ((String) objArr2[0]).intern());
            int i5 = BuiltInFictitiousFunctionClassFactory + 19;
            KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
            int i6 = i5 % 2;
            return str2;
        }
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String readStringRequireUtf8() throws java.io.IOException {
        /*
            r8 = this;
            int r0 = r8.readRawVarint32()
            int r1 = r8.bufferPos
            int r2 = r8.bufferSize
            int r2 = r2 - r1
            r3 = 0
            if (r0 > r2) goto L42
            int r2 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory
            int r2 = r2 + 17
            int r4 = r2 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2 = r4
            int r2 = r2 % 2
            r2 = 13
            if (r0 <= 0) goto L1d
            r4 = 24
            goto L1f
        L1d:
            r4 = 13
        L1f:
            if (r4 == r2) goto L42
            int r2 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory
            int r2 = r2 + 39
            int r4 = r2 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2 = r4
            int r2 = r2 % 2
            r4 = 45
            if (r2 == 0) goto L32
            r2 = 42
            goto L34
        L32:
            r2 = 45
        L34:
            if (r2 == r4) goto L3d
            byte[] r2 = r8.buffer
            int r4 = r1 << r0
        L3a:
            r8.bufferPos = r4
            goto L4c
        L3d:
            byte[] r2 = r8.buffer
            int r4 = r1 + r0
            goto L3a
        L42:
            if (r0 != 0) goto L47
            java.lang.String r0 = ""
            return r0
        L47:
            byte[] r2 = r8.readRawBytesSlowPath(r0)
            r1 = 0
        L4c:
            int r4 = r1 + r0
            boolean r4 = kotlin.reflect.jvm.internal.impl.protobuf.Utf8.isValidUtf8(r2, r1, r4)
            if (r4 == 0) goto L75
            java.lang.String r4 = new java.lang.String
            int r5 = android.view.ViewConfiguration.getTouchSlop()
            int r5 = r5 >> 8
            r6 = 9
            char[] r6 = new char[r6]
            r6 = {x007c: FILL_ARRAY_DATA , data: [19316, 11978, 17122, 19233, -25251, -11946, -17100, 25128, -19348} // fill-array
            r7 = 1
            java.lang.Object[] r7 = new java.lang.Object[r7]
            a(r5, r6, r7)
            r3 = r7[r3]
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r3 = r3.intern()
            r4.<init>(r2, r1, r0, r3)
            return r4
        L75:
            kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r0 = kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException.invalidUtf8()
            goto L7b
        L7a:
            throw r0
        L7b:
            goto L7a
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.readStringRequireUtf8():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
    
        if ((r0 < r2 ? '6' : 'T') == '6') goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002a, code lost:
    
        if ((r0 < r4.recursionLimit) == true) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002c, code lost:
    
        r4.recursionDepth = r0 + 1;
        r6.mergeFrom(r4, r7);
        checkLastTagWas(kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.makeTag(r5, 4));
        r4.recursionDepth--;
        r5 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2 + 21;
        kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory = r5 % 128;
        r5 = r5 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0049, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004e, code lost:
    
        throw kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException.recursionLimitExceeded();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void readGroup(int r5, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder r6, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r7) throws java.io.IOException {
        /*
            r4 = this;
            int r0 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 111
            int r1 = r0 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            r1 = 1
            if (r0 == 0) goto L21
            int r0 = r4.recursionDepth
            int r2 = r4.recursionLimit
            r3 = 0
            int r3 = r3.length     // Catch: java.lang.Throwable -> L1f
            r3 = 54
            if (r0 >= r2) goto L1a
            r2 = 54
            goto L1c
        L1a:
            r2 = 84
        L1c:
            if (r2 != r3) goto L4a
            goto L2c
        L1f:
            r5 = move-exception
            throw r5
        L21:
            int r0 = r4.recursionDepth
            int r2 = r4.recursionLimit
            if (r0 >= r2) goto L29
            r2 = 1
            goto L2a
        L29:
            r2 = 0
        L2a:
            if (r2 != r1) goto L4a
        L2c:
            int r0 = r0 + r1
            r4.recursionDepth = r0
            r6.mergeFrom(r4, r7)
            r6 = 4
            int r5 = kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.makeTag(r5, r6)
            r4.checkLastTagWas(r5)
            int r5 = r4.recursionDepth
            int r5 = r5 - r1
            r4.recursionDepth = r5
            int r5 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2
            int r5 = r5 + 21
            int r6 = r5 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory = r6
            int r5 = r5 % 2
            return
        L4a:
            kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r5 = kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException.recursionLimitExceeded()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.readGroup(int, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite$Builder, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0035, code lost:
    
        if ((r5.recursionDepth < r5.recursionLimit ? '.' : 'Z') == '.') goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0037, code lost:
    
        r1 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2 + 69;
        kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory = r1 % 128;
        r1 = r1 % 2;
        r0 = pushLimit(r0);
        r5.recursionDepth++;
        r6.mergeFrom(r5, r7);
        checkLastTagWas(0);
        r5.recursionDepth--;
        popLimit(r0);
        r6 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2 + 25;
        kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory = r6 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0064, code lost:
    
        if ((r6 % 2) != 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0067, code lost:
    
        r6 = 3 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0068, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006b, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0070, code lost:
    
        throw kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException.recursionLimitExceeded();
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001e, code lost:
    
        if (r5.recursionDepth < r5.recursionLimit) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void readMessage(kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder r6, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r7) throws java.io.IOException {
        /*
            r5 = this;
            int r0 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 45
            int r1 = r0 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            r1 = 85
            if (r0 != 0) goto L11
            r0 = 85
            goto L13
        L11:
            r0 = 28
        L13:
            r2 = 0
            if (r0 == r1) goto L21
            int r0 = r5.readRawVarint32()
            int r1 = r5.recursionDepth
            int r3 = r5.recursionLimit
            if (r1 >= r3) goto L6c
            goto L37
        L21:
            int r0 = r5.readRawVarint32()
            int r1 = r5.recursionDepth
            int r3 = r5.recursionLimit
            r4 = 17
            int r4 = r4 / r2
            r4 = 46
            if (r1 >= r3) goto L33
            r1 = 46
            goto L35
        L33:
            r1 = 90
        L35:
            if (r1 != r4) goto L6c
        L37:
            int r1 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2
            int r1 = r1 + 69
            int r3 = r1 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory = r3
            int r1 = r1 % 2
            int r0 = r5.pushLimit(r0)
            int r1 = r5.recursionDepth
            int r1 = r1 + 1
            r5.recursionDepth = r1
            r6.mergeFrom(r5, r7)
            r5.checkLastTagWas(r2)
            int r6 = r5.recursionDepth
            int r6 = r6 + (-1)
            r5.recursionDepth = r6
            r5.popLimit(r0)
            int r6 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2
            int r6 = r6 + 25
            int r7 = r6 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory = r7
            int r6 = r6 % 2
            if (r6 != 0) goto L6b
            r6 = 3
            int r6 = r6 / r2
            return
        L69:
            r6 = move-exception
            throw r6
        L6b:
            return
        L6c:
            kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r6 = kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException.recursionLimitExceeded()
            throw r6
        L71:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.readMessage(kotlin.reflect.jvm.internal.impl.protobuf.MessageLite$Builder, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite):void");
    }

    public final <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 117;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        int readRawVarint32 = readRawVarint32();
        if (this.recursionDepth >= this.recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 119;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        int i4 = i3 % 2;
        int pushLimit = pushLimit(readRawVarint32);
        this.recursionDepth++;
        T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
        checkLastTagWas(0);
        this.recursionDepth--;
        popLimit(pushLimit);
        return parsePartialFrom;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0037, code lost:
    
        if ((r1 ? '\n' : kotlin.text.Typography.amp) != '\n') goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0040, code lost:
    
        if (r6.bufferIsImmutable != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0042, code lost:
    
        r1 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory + 105;
        kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2 = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004e, code lost:
    
        if (r6.enableAliasing == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0052, code lost:
    
        r1 = new kotlin.reflect.jvm.internal.impl.protobuf.BoundedByteString(r6.buffer, r6.bufferPos, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005a, code lost:
    
        r1 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.copyFrom(r6.buffer, r2, r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final kotlin.reflect.jvm.internal.impl.protobuf.ByteString readBytes() throws java.io.IOException {
        /*
            r6 = this;
            int r0 = r6.readRawVarint32()
            int r1 = r6.bufferSize
            int r2 = r6.bufferPos
            int r1 = r1 - r2
            r3 = 91
            if (r0 > r1) goto L10
            r1 = 93
            goto L12
        L10:
            r1 = 91
        L12:
            r4 = 0
            r5 = 0
            if (r1 == r3) goto L69
            if (r0 <= 0) goto L1a
            r1 = 0
            goto L1c
        L1a:
            r1 = 89
        L1c:
            if (r1 == 0) goto L1f
            goto L69
        L1f:
            int r1 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory
            int r1 = r1 + 23
            int r3 = r1 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2 = r3
            int r1 = r1 % 2
            if (r1 == 0) goto L3e
            boolean r1 = r6.bufferIsImmutable     // Catch: java.lang.Exception -> L3c
            int r3 = r4.length     // Catch: java.lang.Throwable -> L3a
            r3 = 10
            if (r1 == 0) goto L35
            r1 = 10
            goto L37
        L35:
            r1 = 38
        L37:
            if (r1 == r3) goto L42
            goto L5a
        L3a:
            r0 = move-exception
            throw r0
        L3c:
            r0 = move-exception
            goto L66
        L3e:
            boolean r1 = r6.bufferIsImmutable
            if (r1 == 0) goto L5a
        L42:
            int r1 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory
            int r1 = r1 + 105
            int r3 = r1 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2 = r3
            int r1 = r1 % 2
            boolean r1 = r6.enableAliasing
            if (r1 == 0) goto L5a
            kotlin.reflect.jvm.internal.impl.protobuf.BoundedByteString r1 = new kotlin.reflect.jvm.internal.impl.protobuf.BoundedByteString
            byte[] r2 = r6.buffer     // Catch: java.lang.Exception -> L3c
            int r3 = r6.bufferPos     // Catch: java.lang.Exception -> L3c
            r1.<init>(r2, r3, r0)     // Catch: java.lang.Exception -> L3c
            goto L60
        L5a:
            byte[] r1 = r6.buffer
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString r1 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.copyFrom(r1, r2, r0)
        L60:
            int r2 = r6.bufferPos     // Catch: java.lang.Exception -> L67
            int r2 = r2 + r0
            r6.bufferPos = r2     // Catch: java.lang.Exception -> L3c
            return r1
        L66:
            throw r0
        L67:
            r0 = move-exception
            throw r0
        L69:
            if (r0 != 0) goto L84
            int r0 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + r3
            int r1 = r0 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            r1 = 1
            if (r0 != 0) goto L78
            goto L79
        L78:
            r5 = 1
        L79:
            if (r5 == r1) goto L81
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.EMPTY
            int r1 = r4.length     // Catch: java.lang.Throwable -> L7f
            return r0
        L7f:
            r0 = move-exception
            throw r0
        L81:
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString r0 = kotlin.reflect.jvm.internal.impl.protobuf.ByteString.EMPTY
            return r0
        L84:
            kotlin.reflect.jvm.internal.impl.protobuf.LiteralByteString r1 = new kotlin.reflect.jvm.internal.impl.protobuf.LiteralByteString
            byte[] r0 = r6.readRawBytesSlowPath(r0)
            r1.<init>(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.readBytes():kotlin.reflect.jvm.internal.impl.protobuf.ByteString");
    }

    public final int readUInt32() throws IOException {
        int i = BuiltInFictitiousFunctionClassFactory + 7;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        int readRawVarint32 = readRawVarint32();
        try {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 63;
            try {
                BuiltInFictitiousFunctionClassFactory = i3 % 128;
                int i4 = i3 % 2;
                return readRawVarint32;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final int readEnum() throws IOException {
        int readRawVarint32;
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 51;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            if ((i % 2 != 0 ? Typography.quote : 'Y') != 'Y') {
                readRawVarint32 = readRawVarint32();
                Object obj = null;
                obj.hashCode();
            } else {
                readRawVarint32 = readRawVarint32();
            }
            int i2 = BuiltInFictitiousFunctionClassFactory + 15;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            int i3 = i2 % 2;
            return readRawVarint32;
        } catch (Exception e) {
            throw e;
        }
    }

    public final int readSFixed32() throws IOException {
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 93;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            if ((i % 2 != 0 ? '\f' : (char) 7) != '\f') {
                return readRawLittleEndian32();
            }
            int i2 = 10 / 0;
            return readRawLittleEndian32();
        } catch (Exception e) {
            throw e;
        }
    }

    public final long readSFixed64() throws IOException {
        int i = BuiltInFictitiousFunctionClassFactory + 83;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        try {
            long readRawLittleEndian64 = readRawLittleEndian64();
            int i3 = BuiltInFictitiousFunctionClassFactory + 75;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
            return readRawLittleEndian64;
        } catch (Exception e) {
            throw e;
        }
    }

    public final int readSInt32() throws IOException {
        int i = BuiltInFictitiousFunctionClassFactory + 113;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        int decodeZigZag32 = decodeZigZag32(readRawVarint32());
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 27;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        int i4 = i3 % 2;
        return decodeZigZag32;
    }

    public final long readSInt64() throws IOException {
        long decodeZigZag64;
        int i = BuiltInFictitiousFunctionClassFactory + 37;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if ((i % 2 != 0 ? 'O' : 'L') != 'O') {
            decodeZigZag64 = decodeZigZag64(readRawVarint64());
        } else {
            decodeZigZag64 = decodeZigZag64(readRawVarint64());
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = BuiltInFictitiousFunctionClassFactory + 59;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        int i3 = i2 % 2;
        return decodeZigZag64;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0036, code lost:
    
        if (r3 < 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0045, code lost:
    
        if (r3 < 1) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0047, code lost:
    
        r5 = -128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004a, code lost:
    
        r3 = r1 + 1;
        r0 = r0 ^ (r2[r1] << 14);
        r9 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0057, code lost:
    
        if (r9 < 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0059, code lost:
    
        r5 = '_';
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005c, code lost:
    
        r5 = '=';
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005e, code lost:
    
        if (r5 == '=') goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0060, code lost:
    
        r1 = (int) (16256 ^ r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0066, code lost:
    
        r1 = r3 + 1;
        r9 = r0 ^ (r2[r3] << com.google.common.base.Ascii.NAK);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0072, code lost:
    
        if (r9 >= 0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0074, code lost:
    
        r5 = '\b';
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0077, code lost:
    
        r5 = '`';
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0079, code lost:
    
        if (r5 == '`') goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x007b, code lost:
    
        r0 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory + 41;
        kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2 = r0 % 128;
        r0 = r0 % 2;
        r0 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory + 9;
        kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2 = r0 % 128;
        r0 = r0 % 2;
        r5 = -2080896;
        r3 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0093, code lost:
    
        r0 = (int) (r3 ^ r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0097, code lost:
    
        r3 = r1 + 1;
        r0 = (int) ((r0 ^ (r1 << com.google.common.base.Ascii.FS)) ^ 266354560);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a7, code lost:
    
        if (r2[r1] >= 0) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a9, code lost:
    
        r1 = 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ab, code lost:
    
        r1 = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ad, code lost:
    
        if (r1 == 5) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00af, code lost:
    
        r1 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b1, code lost:
    
        r1 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b5, code lost:
    
        if (r2[r3] >= 0) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b7, code lost:
    
        r3 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00bb, code lost:
    
        if (r2[r1] >= 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00bd, code lost:
    
        r1 = 14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00c0, code lost:
    
        r1 = '?';
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00c2, code lost:
    
        if (r1 == 14) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00c5, code lost:
    
        r1 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2 + 29;
        kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00cf, code lost:
    
        if ((r1 % 2) != 0) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00d1, code lost:
    
        r1 = r3 >>> 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00d5, code lost:
    
        if (r2[r3] >= 0) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00d8, code lost:
    
        r1 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00dc, code lost:
    
        if (r2[r3] >= 0) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00de, code lost:
    
        r3 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00e4, code lost:
    
        if (r2[r1] >= 0) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00e6, code lost:
    
        r1 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00e8, code lost:
    
        r1 = 'Z';
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00ea, code lost:
    
        if (r1 == 'Z') goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00ec, code lost:
    
        r1 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2 + 17;
        kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory = r1 % 128;
        r1 = r1 % 2;
        r1 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00f9, code lost:
    
        if (r2[r3] >= 0) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00fc, code lost:
    
        r0 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2 + 39;
        kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory = r0 % 128;
        r0 = r0 % 2;
        r0 = r1;
        r1 = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int readRawVarint32() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 298
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.readRawVarint32():int");
    }

    public static int readRawVarint32(int i, InputStream inputStream) throws IOException {
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 107;
        BuiltInFictitiousFunctionClassFactory = i2 % 128;
        int i3 = i2 % 2;
        if ((i & 128) == 0) {
            int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 117;
            BuiltInFictitiousFunctionClassFactory = i4 % 128;
            int i5 = i4 % 2;
            return i;
        }
        int i6 = i & 127;
        int i7 = 7;
        while (true) {
            if (i7 < 32) {
                try {
                    int read = inputStream.read();
                    if (read == -1) {
                        throw InvalidProtocolBufferException.truncatedMessage();
                    }
                    i6 |= (read & 127) << i7;
                    if ((read & 128) == 0) {
                        return i6;
                    }
                    i7 += 7;
                } catch (Exception e) {
                    throw e;
                }
            } else {
                while (true) {
                    if ((i7 < 64 ? (char) 3 : '\n') != '\n') {
                        int read2 = inputStream.read();
                        if ((read2 != -1 ? 'T' : 'L') != 'T') {
                            throw InvalidProtocolBufferException.truncatedMessage();
                        }
                        if ((read2 & 128) == 0) {
                            return i6;
                        }
                        i7 += 7;
                    } else {
                        throw InvalidProtocolBufferException.malformedVarint();
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00da, code lost:
    
        if (r4[r0] < 0) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long readRawVarint64() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.readRawVarint64():long");
    }

    final long readRawVarint64SlowPath() throws IOException {
        int i = BuiltInFictitiousFunctionClassFactory + 79;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (i % 2 != 0) {
        }
        long j = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            j |= (r5 & Byte.MAX_VALUE) << i2;
            if (!((readRawByte() & 128) != 0)) {
                int i3 = BuiltInFictitiousFunctionClassFactory + 9;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                int i4 = i3 % 2;
                return j;
            }
        }
        try {
            throw InvalidProtocolBufferException.malformedVarint();
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0029, code lost:
    
        if ((r6.bufferSize * r0 < 2 ? '2' : ',') != '2') goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int readRawLittleEndian32() throws java.io.IOException {
        /*
            r6 = this;
            int r0 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 91
            int r1 = r0 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            r1 = 2
            int r0 = r0 % r1
            if (r0 == 0) goto Le
            r0 = 0
            goto Lf
        Le:
            r0 = 1
        Lf:
            r2 = 4
            if (r0 == 0) goto L1a
            int r0 = r6.bufferPos     // Catch: java.lang.Exception -> L62
            int r3 = r6.bufferSize     // Catch: java.lang.Exception -> L62
            int r3 = r3 - r0
            if (r3 >= r2) goto L31
            goto L2c
        L1a:
            int r0 = r6.bufferPos     // Catch: java.lang.Exception -> L62
            int r3 = r6.bufferSize     // Catch: java.lang.Exception -> L62
            int r3 = r3 * r0
            r4 = 50
            if (r3 >= r1) goto L27
            r3 = 50
            goto L29
        L27:
            r3 = 44
        L29:
            if (r3 == r4) goto L2c
            goto L31
        L2c:
            r6.refillBuffer(r2)
            int r0 = r6.bufferPos
        L31:
            byte[] r2 = r6.buffer     // Catch: java.lang.Exception -> L62
            int r3 = r0 + 4
            r6.bufferPos = r3     // Catch: java.lang.Exception -> L60
            r3 = r2[r0]     // Catch: java.lang.Exception -> L60
            int r4 = r0 + 1
            r4 = r2[r4]     // Catch: java.lang.Exception -> L60
            int r5 = r0 + 2
            r5 = r2[r5]     // Catch: java.lang.Exception -> L60
            int r0 = r0 + 3
            r0 = r2[r0]     // Catch: java.lang.Exception -> L60
            r0 = r0 & 255(0xff, float:3.57E-43)
            int r0 = r0 << 24
            r2 = r3 & 255(0xff, float:3.57E-43)
            r3 = r4 & 255(0xff, float:3.57E-43)
            int r3 = r3 << 8
            r2 = r2 | r3
            r3 = r5 & 255(0xff, float:3.57E-43)
            int r3 = r3 << 16
            r2 = r2 | r3
            r0 = r0 | r2
            int r2 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory
            int r2 = r2 + 95
            int r3 = r2 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2 = r3
            int r2 = r2 % r1
            return r0
        L60:
            r0 = move-exception
            throw r0
        L62:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.readRawLittleEndian32():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
    
        if ((r21.bufferSize - r1 < 8 ? '9' : 6) != 6) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0034, code lost:
    
        if ((r21.bufferSize % r1 < 4 ? '\\' : 'N') != 'N') goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0036, code lost:
    
        refillBuffer(8);
        r1 = r21.bufferPos;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long readRawLittleEndian64() throws java.io.IOException {
        /*
            r21 = this;
            r0 = r21
            int r1 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory
            int r1 = r1 + 85
            int r2 = r1 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2 = r2
            int r1 = r1 % 2
            if (r1 == 0) goto L10
            r1 = 0
            goto L12
        L10:
            r1 = 36
        L12:
            r2 = 8
            if (r1 == 0) goto L25
            int r1 = r0.bufferPos
            int r3 = r0.bufferSize
            int r3 = r3 - r1
            r4 = 6
            if (r3 >= r2) goto L21
            r3 = 57
            goto L22
        L21:
            r3 = 6
        L22:
            if (r3 == r4) goto L3b
            goto L36
        L25:
            int r1 = r0.bufferPos
            int r3 = r0.bufferSize
            int r3 = r3 % r1
            r4 = 78
            r5 = 4
            if (r3 >= r5) goto L32
            r3 = 92
            goto L34
        L32:
            r3 = 78
        L34:
            if (r3 == r4) goto L3b
        L36:
            r0.refillBuffer(r2)
            int r1 = r0.bufferPos
        L3b:
            byte[] r3 = r0.buffer
            int r4 = r1 + 8
            r0.bufferPos = r4
            r4 = r3[r1]
            long r4 = (long) r4
            int r6 = r1 + 1
            r6 = r3[r6]
            long r6 = (long) r6
            int r8 = r1 + 2
            r8 = r3[r8]
            long r8 = (long) r8
            int r10 = r1 + 3
            r10 = r3[r10]
            long r10 = (long) r10
            int r12 = r1 + 4
            r12 = r3[r12]
            long r12 = (long) r12
            int r14 = r1 + 5
            r14 = r3[r14]
            long r14 = (long) r14
            int r16 = r1 + 6
            r2 = r3[r16]
            r17 = r14
            long r14 = (long) r2
            int r1 = r1 + 7
            r1 = r3[r1]
            long r1 = (long) r1
            r19 = 255(0xff, double:1.26E-321)
            long r1 = r1 & r19
            r3 = 56
            long r1 = r1 << r3
            long r4 = r4 & r19
            long r6 = r6 & r19
            r3 = 8
            long r6 = r6 << r3
            long r4 = r4 | r6
            long r6 = r8 & r19
            r3 = 16
            long r6 = r6 << r3
            long r4 = r4 | r6
            long r6 = r10 & r19
            r3 = 24
            long r6 = r6 << r3
            long r4 = r4 | r6
            long r6 = r12 & r19
            r3 = 32
            long r6 = r6 << r3
            long r4 = r4 | r6
            long r6 = r17 & r19
            r3 = 40
            long r6 = r6 << r3
            long r4 = r4 | r6
            long r6 = r14 & r19
            r3 = 48
            long r6 = r6 << r3
            long r4 = r4 | r6
            long r1 = r1 | r4
            int r3 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2
            int r3 = r3 + 61
            int r4 = r3 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory = r4
            int r3 = r3 % 2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.readRawLittleEndian64():long");
    }

    private CodedInputStream(InputStream inputStream) {
        this.enableAliasing = false;
        this.currentLimit = Integer.MAX_VALUE;
        this.recursionLimit = 64;
        this.sizeLimit = 67108864;
        this.refillCallback = null;
        this.buffer = new byte[4096];
        this.bufferSize = 0;
        this.bufferPos = 0;
        this.totalBytesRetired = 0;
        this.input = inputStream;
        this.bufferIsImmutable = false;
    }

    private CodedInputStream(LiteralByteString literalByteString) {
        this.enableAliasing = false;
        this.currentLimit = Integer.MAX_VALUE;
        this.recursionLimit = 64;
        this.sizeLimit = 67108864;
        this.refillCallback = null;
        this.buffer = literalByteString.bytes;
        int offsetIntoBytes = literalByteString.getOffsetIntoBytes();
        this.bufferPos = offsetIntoBytes;
        this.bufferSize = offsetIntoBytes + literalByteString.size();
        this.totalBytesRetired = -this.bufferPos;
        this.input = null;
        this.bufferIsImmutable = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0019, code lost:
    
        if ((r7 >= 0) != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0022, code lost:
    
        if ((r7 >= 0) == true) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0024, code lost:
    
        r7 = r7 + (r6.totalBytesRetired + r6.bufferPos);
        r0 = r6.currentLimit;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002c, code lost:
    
        if (r7 > r0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002e, code lost:
    
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0030, code lost:
    
        r4 = 7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0031, code lost:
    
        if (r4 != 0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0035, code lost:
    
        r4 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory + 111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0039, code lost:
    
        kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2 = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003d, code lost:
    
        if ((r4 % 2) == 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003f, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0040, code lost:
    
        if (r1 == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0042, code lost:
    
        r6.currentLimit = r7;
        recomputeBufferSizeAfterLimit();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0047, code lost:
    
        r7 = r3.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x004b, code lost:
    
        r6.currentLimit = r7;
        recomputeBufferSizeAfterLimit();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0050, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0051, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0052, code lost:
    
        throw r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0053, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0054, code lost:
    
        throw r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0059, code lost:
    
        throw kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException.truncatedMessage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x005e, code lost:
    
        throw kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException.negativeSize();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int pushLimit(int r7) throws kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException {
        /*
            r6 = this;
            int r0 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 125
            int r1 = r0 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            r3 = 0
            if (r0 == 0) goto L1c
            if (r7 < 0) goto L18
            r0 = 1
            goto L19
        L18:
            r0 = 0
        L19:
            if (r0 == 0) goto L5a
            goto L24
        L1c:
            int r0 = r3.length     // Catch: java.lang.Throwable -> L5f
            if (r7 < 0) goto L21
            r0 = 1
            goto L22
        L21:
            r0 = 0
        L22:
            if (r0 != r2) goto L5a
        L24:
            int r0 = r6.totalBytesRetired
            int r4 = r6.bufferPos
            int r0 = r0 + r4
            int r7 = r7 + r0
            int r0 = r6.currentLimit
            if (r7 > r0) goto L30
            r4 = 0
            goto L31
        L30:
            r4 = 7
        L31:
            if (r4 != 0) goto L55
            int r4 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> L53
            int r4 = r4 + 111
            int r5 = r4 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2 = r5     // Catch: java.lang.Exception -> L51
            int r4 = r4 % 2
            if (r4 == 0) goto L40
            r1 = 1
        L40:
            if (r1 == 0) goto L4b
            r6.currentLimit = r7
            r6.recomputeBufferSizeAfterLimit()
            int r7 = r3.length     // Catch: java.lang.Throwable -> L49
            goto L50
        L49:
            r7 = move-exception
            throw r7
        L4b:
            r6.currentLimit = r7
            r6.recomputeBufferSizeAfterLimit()
        L50:
            return r0
        L51:
            r7 = move-exception
            throw r7
        L53:
            r7 = move-exception
            throw r7
        L55:
            kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r7 = kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException.truncatedMessage()
            throw r7
        L5a:
            kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r7 = kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException.negativeSize()
            throw r7
        L5f:
            r7 = move-exception
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.pushLimit(int):int");
    }

    private void recomputeBufferSizeAfterLimit() {
        try {
            int i = this.bufferSize + this.bufferSizeAfterLimit;
            this.bufferSize = i;
            int i2 = this.totalBytesRetired + i;
            int i3 = this.currentLimit;
            if (!(i2 <= i3)) {
                int i4 = BuiltInFictitiousFunctionClassFactory + 81;
                KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
                int i5 = i4 % 2;
                int i6 = i2 - i3;
                this.bufferSizeAfterLimit = i6;
                this.bufferSize = i - i6;
                int i7 = BuiltInFictitiousFunctionClassFactory + 11;
                KClassImpl$Data$declaredNonStaticMembers$2 = i7 % 128;
                int i8 = i7 % 2;
                return;
            }
            this.bufferSizeAfterLimit = 0;
        } catch (Exception e) {
            throw e;
        }
    }

    public final void popLimit(int i) {
        int i2 = BuiltInFictitiousFunctionClassFactory + 63;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        int i3 = i2 % 2;
        this.currentLimit = i;
        recomputeBufferSizeAfterLimit();
        int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 43;
        BuiltInFictitiousFunctionClassFactory = i4 % 128;
        int i5 = i4 % 2;
    }

    public final int getBytesUntilLimit() {
        int i = this.currentLimit;
        if (!(i != Integer.MAX_VALUE)) {
            int i2 = BuiltInFictitiousFunctionClassFactory + 83;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            int i3 = i2 % 2;
            int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 105;
            BuiltInFictitiousFunctionClassFactory = i4 % 128;
            if (!(i4 % 2 == 0)) {
                return -1;
            }
            int i5 = 69 / 0;
            return -1;
        }
        return i - (this.totalBytesRetired + this.bufferPos);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean isAtEnd() throws java.io.IOException {
        /*
            r6 = this;
            int r0 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 95
            int r1 = r0 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L20
            int r0 = r6.bufferPos
            int r4 = r6.bufferSize
            r5 = 19
            if (r0 != r4) goto L19
            r0 = 19
            goto L1b
        L19:
            r0 = 68
        L1b:
            if (r0 == r5) goto L1e
            goto L44
        L1e:
            r0 = 0
            goto L30
        L20:
            int r0 = r6.bufferPos     // Catch: java.lang.Exception -> L50
            int r4 = r6.bufferSize     // Catch: java.lang.Exception -> L50
            r5 = 78
            if (r0 != r4) goto L2b
            r0 = 78
            goto L2c
        L2b:
            r0 = 2
        L2c:
            if (r0 == r5) goto L2f
            goto L44
        L2f:
            r0 = 1
        L30:
            int r4 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2
            int r4 = r4 + 51
            int r5 = r4 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory = r5
            int r4 = r4 % r1
            boolean r4 = r6.tryRefillBuffer(r3)
            if (r4 == 0) goto L41
            r4 = 0
            goto L42
        L41:
            r4 = 1
        L42:
            if (r4 == r3) goto L4e
        L44:
            int r0 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 33
            int r3 = r0 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory = r3
            int r0 = r0 % r1
            goto L4f
        L4e:
            r2 = r0
        L4f:
            return r2
        L50:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.isAtEnd():boolean");
    }

    private void ensureAvailable(int i) throws IOException {
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 59;
        BuiltInFictitiousFunctionClassFactory = i2 % 128;
        int i3 = i2 % 2;
        try {
            if ((this.bufferSize - this.bufferPos < i ? '[' : (char) 29) != 29) {
                int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 113;
                try {
                    BuiltInFictitiousFunctionClassFactory = i4 % 128;
                    int i5 = i4 % 2;
                    refillBuffer(i);
                } catch (Exception e) {
                    throw e;
                }
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
    
        if (r3 != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0022, code lost:
    
        r3 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory + 115;
        kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2 = r3 % 128;
        r3 = r3 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002c, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0031, code lost:
    
        throw kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException.truncatedMessage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
    
        if (r3 != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void refillBuffer(int r3) throws java.io.IOException {
        /*
            r2 = this;
            int r0 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 55
            int r1 = r0 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            r1 = 33
            if (r0 != 0) goto L11
            r0 = 33
            goto L13
        L11:
            r0 = 46
        L13:
            boolean r3 = r2.tryRefillBuffer(r3)
            if (r0 == r1) goto L1c
            if (r3 == 0) goto L2d
            goto L22
        L1c:
            r0 = 0
            r0.hashCode()     // Catch: java.lang.Throwable -> L32
            if (r3 == 0) goto L2d
        L22:
            int r3 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory
            int r3 = r3 + 115
            int r0 = r3 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2 = r0
            int r3 = r3 % 2
            return
        L2d:
            kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r3 = kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException.truncatedMessage()
            throw r3
        L32:
            r3 = move-exception
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.refillBuffer(int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0030, code lost:
    
        if (((r6.totalBytesRetired + r0) + r7 > r6.currentLimit ? 'L' : '`') != 'L') goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0032, code lost:
    
        r0 = r6.refillCallback;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0034, code lost:
    
        if (r0 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0036, code lost:
    
        r0.onRefill();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003b, code lost:
    
        r0 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory + 73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003f, code lost:
    
        kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2 = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0044, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0046, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004c, code lost:
    
        if (r6.input == null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004e, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0050, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0051, code lost:
    
        if (r0 == true) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0055, code lost:
    
        r0 = r6.bufferPos;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0057, code lost:
    
        if (r0 <= 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0059, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005b, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x005c, code lost:
    
        if (r3 == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x005f, code lost:
    
        r3 = r6.bufferSize;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0061, code lost:
    
        if (r3 <= r0) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0063, code lost:
    
        r4 = r6.buffer;
        java.lang.System.arraycopy(r4, r0, r4, 0, r3 - r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x006a, code lost:
    
        throw r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x006b, code lost:
    
        r6.totalBytesRetired += r0;
        r6.bufferSize -= r0;
        r6.bufferPos = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0077, code lost:
    
        r0 = r6.input;
        r3 = r6.buffer;
        r4 = r6.bufferSize;
        r0 = r0.read(r3, r4, r3.length - r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0083, code lost:
    
        if (r0 == 0) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0085, code lost:
    
        r3 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2 + 5;
        kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory = r3 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0090, code lost:
    
        if ((r3 % 2) != 0) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0094, code lost:
    
        r3 = 57 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0095, code lost:
    
        if (r0 < (-1)) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x009a, code lost:
    
        if (r0 < (-1)) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x009c, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x009e, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x009f, code lost:
    
        if (r3 == false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00a4, code lost:
    
        if (r0 > r6.buffer.length) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00a6, code lost:
    
        r3 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2 + 111;
        kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory = r3 % 128;
        r3 = r3 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00b0, code lost:
    
        if (r0 <= 0) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00b2, code lost:
    
        r2 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2 + 59;
        kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory = r2 % 128;
        r2 = r2 % 2;
        r6.bufferSize += r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00c7, code lost:
    
        if (((r6.totalBytesRetired + r7) - r6.sizeLimit) > 0) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00c9, code lost:
    
        recomputeBufferSizeAfterLimit();
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00d0, code lost:
    
        if (r6.bufferSize < r7) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00d2, code lost:
    
        r0 = 14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00d5, code lost:
    
        r0 = '\t';
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00d7, code lost:
    
        if (r0 == 14) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00d9, code lost:
    
        r1 = tryRefillBuffer(r7);
        r7 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2 + 119;
        kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory = r7 % 128;
        r7 = r7 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00e7, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00ec, code lost:
    
        throw kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException.sizeLimitExceeded();
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00ed, code lost:
    
        throw r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00ee, code lost:
    
        r7 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory + 115;
        kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2 = r7 % 128;
        r7 = r7 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00f8, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00f9, code lost:
    
        r7 = new java.lang.StringBuilder(102);
        r7.append("InputStream#read(byte[]) returned invalid result: ");
        r7.append(r0);
        r7.append("\nThe InputStream implementation is buggy.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0116, code lost:
    
        throw new java.lang.IllegalStateException(r7.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0117, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001d, code lost:
    
        if (((r6.totalBytesRetired * r0) << r7) > r6.currentLimit) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:?, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean tryRefillBuffer(int r7) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.tryRefillBuffer(int):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002a, code lost:
    
        if ((r0 == r2 ? '(' : 'X') != 'X') goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002c, code lost:
    
        refillBuffer(1);
        r0 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2 + 115;
        kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0039, code lost:
    
        r0 = r4.buffer;
        r1 = r4.bufferPos;
        r4.bufferPos = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0043, code lost:
    
        return r0[r1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0016, code lost:
    
        if (r4.bufferPos == r4.bufferSize) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final byte readRawByte() throws java.io.IOException {
        /*
            r4 = this;
            int r0 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 125
            int r1 = r0 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            r1 = 1
            if (r0 != 0) goto Lf
            r0 = 0
            goto L10
        Lf:
            r0 = 1
        L10:
            if (r0 == 0) goto L1b
            int r0 = r4.bufferPos     // Catch: java.lang.Exception -> L19
            int r2 = r4.bufferSize     // Catch: java.lang.Exception -> L19
            if (r0 != r2) goto L39
            goto L2c
        L19:
            r0 = move-exception
            throw r0
        L1b:
            int r0 = r4.bufferPos
            int r2 = r4.bufferSize
            r3 = 0
            int r3 = r3.length     // Catch: java.lang.Throwable -> L44
            r3 = 88
            if (r0 != r2) goto L28
            r0 = 40
            goto L2a
        L28:
            r0 = 88
        L2a:
            if (r0 == r3) goto L39
        L2c:
            r4.refillBuffer(r1)
            int r0 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 115
            int r1 = r0 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
        L39:
            byte[] r0 = r4.buffer
            int r1 = r4.bufferPos
            int r2 = r1 + 1
            r4.bufferPos = r2
            r0 = r0[r1]
            return r0
        L44:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.readRawByte():byte");
    }

    private byte[] readRawBytesSlowPath(int i) throws IOException {
        int i2 = BuiltInFictitiousFunctionClassFactory + 113;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        int i3 = i2 % 2;
        if (!(i > 0)) {
            if (i == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            }
            throw InvalidProtocolBufferException.negativeSize();
        }
        int i4 = this.totalBytesRetired;
        int i5 = this.bufferPos;
        int i6 = this.currentLimit;
        if (i4 + i5 + i > i6) {
            skipRawBytes((i6 - i4) - i5);
            throw InvalidProtocolBufferException.truncatedMessage();
        } else if (i < 4096) {
            byte[] bArr = new byte[i];
            try {
                int i7 = this.bufferSize - i5;
                System.arraycopy(this.buffer, i5, bArr, 0, i7);
                this.bufferPos = this.bufferSize;
                int i8 = i - i7;
                ensureAvailable(i8);
                System.arraycopy(this.buffer, 0, bArr, i7, i8);
                this.bufferPos = i8;
                return bArr;
            } catch (Exception e) {
                throw e;
            }
        } else {
            int i9 = this.bufferSize;
            this.totalBytesRetired = i4 + i9;
            this.bufferPos = 0;
            this.bufferSize = 0;
            int i10 = i9 - i5;
            int i11 = i - i10;
            ArrayList arrayList = new ArrayList();
            while (true) {
                if (i11 <= 0) {
                    byte[] bArr2 = new byte[i];
                    System.arraycopy(this.buffer, i5, bArr2, 0, i10);
                    Iterator it = arrayList.iterator();
                    while (true) {
                        if ((it.hasNext() ? 'B' : ')') == ')') {
                            break;
                        }
                        int i12 = KClassImpl$Data$declaredNonStaticMembers$2 + 113;
                        BuiltInFictitiousFunctionClassFactory = i12 % 128;
                        if (i12 % 2 == 0) {
                            byte[] bArr3 = (byte[]) it.next();
                            System.arraycopy(bArr3, 1, bArr2, i10, bArr3.length);
                            i10 /= bArr3.length;
                        } else {
                            byte[] bArr4 = (byte[]) it.next();
                            System.arraycopy(bArr4, 0, bArr2, i10, bArr4.length);
                            i10 += bArr4.length;
                        }
                    }
                    int i13 = KClassImpl$Data$declaredNonStaticMembers$2 + 9;
                    BuiltInFictitiousFunctionClassFactory = i13 % 128;
                    if (i13 % 2 == 0) {
                        int i14 = 96 / 0;
                        return bArr2;
                    }
                    return bArr2;
                }
                int i15 = KClassImpl$Data$declaredNonStaticMembers$2 + 71;
                BuiltInFictitiousFunctionClassFactory = i15 % 128;
                int i16 = i15 % 2;
                int min = Math.min(i11, 4096);
                byte[] bArr5 = new byte[min];
                int i17 = 0;
                while (i17 < min) {
                    InputStream inputStream = this.input;
                    int read = inputStream == null ? -1 : inputStream.read(bArr5, i17, min - i17);
                    if (read == -1) {
                        throw InvalidProtocolBufferException.truncatedMessage();
                    }
                    int i18 = BuiltInFictitiousFunctionClassFactory + 3;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i18 % 128;
                    int i19 = i18 % 2;
                    this.totalBytesRetired += read;
                    i17 += read;
                }
                i11 -= min;
                arrayList.add(bArr5);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0028, code lost:
    
        if ((r4 >= 0 ? com.alibaba.fastjson.parser.JSONLexer.EOI : '@') != 26) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002d, code lost:
    
        if (r4 >= 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0030, code lost:
    
        r3.bufferPos = r1 + r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0032, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0033, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0034, code lost:
    
        throw r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void skipRawBytes(int r4) throws java.io.IOException {
        /*
            r3 = this;
            int r0 = r3.bufferSize
            int r1 = r3.bufferPos
            int r0 = r0 - r1
            r2 = 52
            if (r4 > r0) goto Lc
            r0 = 52
            goto Le
        Lc:
            r0 = 16
        Le:
            if (r0 == r2) goto L11
            goto L35
        L11:
            int r0 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 79
            int r2 = r0 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory = r2
            int r0 = r0 % 2
            if (r0 != 0) goto L2d
            r0 = 0
            int r0 = r0.length     // Catch: java.lang.Throwable -> L2b
            r0 = 26
            if (r4 < 0) goto L26
            r2 = 26
            goto L28
        L26:
            r2 = 64
        L28:
            if (r2 == r0) goto L2f
            goto L35
        L2b:
            r4 = move-exception
            throw r4
        L2d:
            if (r4 < 0) goto L35
        L2f:
            int r1 = r1 + r4
            r3.bufferPos = r1     // Catch: java.lang.Exception -> L33
            return
        L33:
            r4 = move-exception
            throw r4
        L35:
            r3.skipRawBytesSlowPath(r4)
            int r4 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L43
            int r4 = r4 + 105
            int r0 = r4 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory = r0     // Catch: java.lang.Exception -> L43
            int r4 = r4 % 2
            return
        L43:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.skipRawBytes(int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0027, code lost:
    
        if (((r0 + r2) + r7) <= r3) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0033, code lost:
    
        if (((r0 + r2) + r7) <= r3) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0035, code lost:
    
        r0 = r6.bufferSize;
        r2 = r0 - r2;
        r6.bufferPos = r0;
        refillBuffer(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003e, code lost:
    
        r0 = r7 - r2;
        r3 = r6.bufferSize;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0044, code lost:
    
        if (r0 <= r3) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0046, code lost:
    
        r5 = 'G';
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0049, code lost:
    
        r5 = '\f';
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004b, code lost:
    
        if (r5 == 'G') goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004d, code lost:
    
        r6.bufferPos = r0;
        r7 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory + 107;
        kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2 = r7 % 128;
        r7 = r7 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0059, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005a, code lost:
    
        r0 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory + 19;
        kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2 = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0066, code lost:
    
        if ((r0 % 2) == 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006d, code lost:
    
        r2 = r2 + r3;
        r6.bufferPos = r3;
        refillBuffer(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0074, code lost:
    
        skipRawBytes((r3 - r0) - r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007d, code lost:
    
        throw kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException.truncatedMessage();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void skipRawBytesSlowPath(int r7) throws java.io.IOException {
        /*
            r6 = this;
            int r0 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 113
            int r1 = r0 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            if (r7 < 0) goto L7e
            int r0 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 113
            int r1 = r0 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            r1 = 1
            if (r0 != 0) goto L1b
            r0 = 1
            goto L1c
        L1b:
            r0 = 0
        L1c:
            if (r0 == 0) goto L2a
            int r0 = r6.totalBytesRetired
            int r2 = r6.bufferPos
            int r3 = r6.currentLimit
            int r4 = r0 + r2
            int r4 = r4 + r7
            if (r4 > r3) goto L74
            goto L35
        L2a:
            int r0 = r6.totalBytesRetired
            int r2 = r6.bufferPos
            int r3 = r6.currentLimit
            int r4 = r0 + r2
            int r4 = r4 + r7
            if (r4 > r3) goto L74
        L35:
            int r0 = r6.bufferSize     // Catch: java.lang.Exception -> L83
            int r2 = r0 - r2
            r6.bufferPos = r0     // Catch: java.lang.Exception -> L83
            r6.refillBuffer(r1)     // Catch: java.lang.Exception -> L83
        L3e:
            int r0 = r7 - r2
            int r3 = r6.bufferSize
            r4 = 71
            if (r0 <= r3) goto L49
            r5 = 71
            goto L4b
        L49:
            r5 = 12
        L4b:
            if (r5 == r4) goto L5a
            r6.bufferPos = r0
            int r7 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory
            int r7 = r7 + 107
            int r0 = r7 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2 = r0
            int r7 = r7 % 2
            return
        L5a:
            int r0 = kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 19
            int r4 = r0 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.KClassImpl$Data$declaredNonStaticMembers$2 = r4
            int r0 = r0 % 2
            r4 = 69
            if (r0 == 0) goto L6b
            r0 = 59
            goto L6d
        L6b:
            r0 = 69
        L6d:
            int r2 = r2 + r3
            r6.bufferPos = r3
            r6.refillBuffer(r1)
            goto L3e
        L74:
            int r3 = r3 - r0
            int r3 = r3 - r2
            r6.skipRawBytes(r3)
            kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r7 = kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException.truncatedMessage()
            throw r7
        L7e:
            kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r7 = kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException.negativeSize()     // Catch: java.lang.Exception -> L83
            throw r7     // Catch: java.lang.Exception -> L83
        L83:
            r7 = move-exception
            goto L86
        L85:
            throw r7
        L86:
            goto L85
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.skipRawBytesSlowPath(int):void");
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        char[] KClassImpl$Data$declaredNonStaticMembers$22 = D.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult ^ 3919452569568103912L, cArr, i);
        d.MyBillsEntityDataFactory = 4;
        int i2 = $11 + 51;
        $10 = i2 % 128;
        int i3 = i2 % 2;
        while (true) {
            if ((d.MyBillsEntityDataFactory < KClassImpl$Data$declaredNonStaticMembers$22.length ? (char) 2 : 'C') == 2) {
                d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
                KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (PlaceComponentResult ^ 3919452569568103912L)));
                d.MyBillsEntityDataFactory++;
            } else {
                String str = new String(KClassImpl$Data$declaredNonStaticMembers$22, 4, KClassImpl$Data$declaredNonStaticMembers$22.length - 4);
                int i4 = $10 + 9;
                $11 = i4 % 128;
                int i5 = i4 % 2;
                objArr[0] = str;
                return;
            }
        }
    }
}
