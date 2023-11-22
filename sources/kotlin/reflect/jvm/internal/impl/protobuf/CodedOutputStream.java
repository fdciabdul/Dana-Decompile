package kotlin.reflect.jvm.internal.impl.protobuf;

import android.graphics.Color;
import android.os.Process;
import android.view.ViewConfiguration;
import com.alibaba.fastjson.parser.JSONLexer;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import kotlin.text.Typography;
import o.E;

/* loaded from: classes.dex */
public final class CodedOutputStream {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static int MyBillsEntityDataFactory = -956812108;
    private static char PlaceComponentResult = 13920;
    private static long getAuthRequestContext = 4360990799332652212L;
    private final byte[] buffer;
    private final int limit;
    private final OutputStream output;
    private int position;
    private int totalBytesWritten;

    public static int computeBoolSizeNoTag(boolean z) {
        int i = BuiltInFictitiousFunctionClassFactory + 103;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        try {
            int i3 = BuiltInFictitiousFunctionClassFactory + 35;
            try {
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                if (i3 % 2 != 0) {
                    Object[] objArr = null;
                    int length = objArr.length;
                    return 1;
                }
                return 1;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static int computeDoubleSizeNoTag(double d) {
        int i = BuiltInFictitiousFunctionClassFactory + 109;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 17;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        if ((i3 % 2 == 0 ? 'A' : '7') != '7') {
            Object obj = null;
            obj.hashCode();
            return 8;
        }
        return 8;
    }

    public static int computeFixed32SizeNoTag(int i) {
        try {
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 103;
            BuiltInFictitiousFunctionClassFactory = i2 % 128;
            return !(i2 % 2 != 0) ? 2 : 4;
        } catch (Exception e) {
            throw e;
        }
    }

    public static int computeFixed64SizeNoTag(long j) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 95;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = (i % 2 == 0 ? 'E' : '[') != '[' ? 73 : 8;
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 11;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        int i4 = i3 % 2;
        return i2;
    }

    public static int computeFloatSizeNoTag(float f) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 43;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 67;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        int i4 = i3 % 2;
        return 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0023, code lost:
    
        if ((r5 > 22373 ? 0 : '\r') != '\r') goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002b, code lost:
    
        if ((r5 > 4096) != true) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002d, code lost:
    
        r0 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.KClassImpl$Data$declaredNonStaticMembers$2 + 107;
        kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.BuiltInFictitiousFunctionClassFactory = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0037, code lost:
    
        if ((r0 % 2) != 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0039, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003a, code lost:
    
        if (r3 == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003c, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003d, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003e, code lost:
    
        r0.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0041, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0044, code lost:
    
        return 4096;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int computePreferredBufferSize(int r5) {
        /*
            int r0 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 27
            int r1 = r0 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            r1 = 10
            if (r0 != 0) goto L11
            r0 = 66
            goto L13
        L11:
            r0 = 10
        L13:
            r2 = 4096(0x1000, float:5.74E-42)
            r3 = 1
            r4 = 0
            if (r0 == r1) goto L26
            r0 = 22373(0x5765, float:3.1351E-41)
            r1 = 13
            if (r5 <= r0) goto L21
            r0 = 0
            goto L23
        L21:
            r0 = 13
        L23:
            if (r0 == r1) goto L2d
            goto L44
        L26:
            if (r5 <= r2) goto L2a
            r0 = 1
            goto L2b
        L2a:
            r0 = 0
        L2b:
            if (r0 == r3) goto L44
        L2d:
            int r0 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 107
            int r1 = r0 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L3a
            r3 = 0
        L3a:
            if (r3 == 0) goto L3d
            return r5
        L3d:
            r0 = 0
            r0.hashCode()     // Catch: java.lang.Throwable -> L42
            return r5
        L42:
            r5 = move-exception
            throw r5
        L44:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.computePreferredBufferSize(int):int");
    }

    public static int computeRawVarint32Size(int i) {
        int i2 = BuiltInFictitiousFunctionClassFactory + 97;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        if (i2 % 2 != 0) {
            if (((i | 31) == 0 ? (char) 7 : (char) 3) != 3) {
                return 1;
            }
        } else if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if ((((-2097152) & i) == 0 ? '8' : ':') != '8') {
            if (((i & (-268435456)) == 0 ? (char) 20 : (char) 16) != 20) {
                return 5;
            }
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 121;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            int i4 = i3 % 2;
            return 4;
        }
        return 3;
    }

    public static int computeRawVarint64Size(long j) {
        int i = BuiltInFictitiousFunctionClassFactory + 35;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        if ((((-128) & j) == 0 ? (char) 3 : '3') == 3) {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 117;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            int i4 = i3 % 2;
            return 1;
        } else if (((-16384) & j) == 0) {
            return 2;
        } else {
            if ((((-2097152) & j) == 0 ? 'L' : (char) 20) == 'L') {
                int i5 = BuiltInFictitiousFunctionClassFactory + 65;
                KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                return i5 % 2 != 0 ? 2 : 3;
            }
            if ((((-268435456) & j) == 0 ? (char) 23 : (char) 17) != 23) {
                if (((-34359738368L) & j) == 0) {
                    return 5;
                }
                if (((-4398046511104L) & j) == 0) {
                    int i6 = KClassImpl$Data$declaredNonStaticMembers$2 + 57;
                    BuiltInFictitiousFunctionClassFactory = i6 % 128;
                    return i6 % 2 == 0 ? 45 : 6;
                } else if (((-562949953421312L) & j) == 0) {
                    try {
                        int i7 = BuiltInFictitiousFunctionClassFactory + 59;
                        KClassImpl$Data$declaredNonStaticMembers$2 = i7 % 128;
                        return i7 % 2 != 0 ? 67 : 7;
                    } catch (Exception e) {
                        throw e;
                    }
                } else {
                    if ((((-72057594037927936L) & j) == 0 ? '+' : '1') == '+') {
                        int i8 = BuiltInFictitiousFunctionClassFactory + 69;
                        KClassImpl$Data$declaredNonStaticMembers$2 = i8 % 128;
                        int i9 = i8 % 2;
                        return 8;
                    } else if ((j & Long.MIN_VALUE) == 0) {
                        int i10 = KClassImpl$Data$declaredNonStaticMembers$2 + 35;
                        BuiltInFictitiousFunctionClassFactory = i10 % 128;
                        int i11 = i10 % 2;
                        int i12 = KClassImpl$Data$declaredNonStaticMembers$2 + 71;
                        BuiltInFictitiousFunctionClassFactory = i12 % 128;
                        int i13 = i12 % 2;
                        return 9;
                    } else {
                        return 10;
                    }
                }
            }
            return 4;
        }
    }

    public static int computeSFixed32SizeNoTag(int i) {
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 89;
        BuiltInFictitiousFunctionClassFactory = i2 % 128;
        int i3 = i2 % 2;
        int i4 = BuiltInFictitiousFunctionClassFactory + 61;
        KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
        if (i4 % 2 == 0) {
            return 4;
        }
        int i5 = 20 / 0;
        return 4;
    }

    public static int computeSFixed64SizeNoTag(long j) {
        int i = BuiltInFictitiousFunctionClassFactory + 75;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 77;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        if ((i3 % 2 == 0 ? ')' : Typography.greater) != '>') {
            int i4 = 25 / 0;
            return 8;
        }
        return 8;
    }

    public static int encodeZigZag32(int i) {
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 69;
        BuiltInFictitiousFunctionClassFactory = i2 % 128;
        int i3 = i2 % 2;
        int i4 = (i << 1) ^ (i >> 31);
        int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 5;
        BuiltInFictitiousFunctionClassFactory = i5 % 128;
        int i6 = i5 % 2;
        return i4;
    }

    public static long encodeZigZag64(long j) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 97;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        long j2 = !(i % 2 == 0) ? (j << 1) ^ (j >> 63) : (j >> 0) * (j << 31);
        try {
            int i2 = BuiltInFictitiousFunctionClassFactory + 27;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            if (i2 % 2 != 0) {
                Object obj = null;
                obj.hashCode();
                return j2;
            }
            return j2;
        } catch (Exception e) {
            throw e;
        }
    }

    private CodedOutputStream(OutputStream outputStream, byte[] bArr) {
        try {
            this.totalBytesWritten = 0;
            this.output = outputStream;
            this.buffer = bArr;
            this.position = 0;
            this.limit = bArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    public static CodedOutputStream newInstance(OutputStream outputStream, int i) {
        CodedOutputStream codedOutputStream = new CodedOutputStream(outputStream, new byte[i]);
        try {
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 7;
            try {
                BuiltInFictitiousFunctionClassFactory = i2 % 128;
                if ((i2 % 2 == 0 ? 'c' : (char) 31) != 'c') {
                    return codedOutputStream;
                }
                Object obj = null;
                obj.hashCode();
                return codedOutputStream;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final void writeDouble(int i, double d) throws IOException {
        int i2 = BuiltInFictitiousFunctionClassFactory + 83;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        if (i2 % 2 != 0) {
        }
        writeTag(i, 1);
        writeDoubleNoTag(d);
        int i3 = BuiltInFictitiousFunctionClassFactory + 47;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
    }

    public final void writeFloat(int i, float f) throws IOException {
        int i2 = BuiltInFictitiousFunctionClassFactory + 79;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        if ((i2 % 2 != 0 ? (char) 5 : '/') != 5) {
            writeTag(i, 5);
        } else {
            writeTag(i, 4);
        }
        writeFloatNoTag(f);
    }

    public final void writeInt32(int i, int i2) throws IOException {
        int i3 = BuiltInFictitiousFunctionClassFactory + 19;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        writeTag(i, (i3 % 2 != 0 ? 'D' : '3') != 'D' ? 0 : 1);
        writeInt32NoTag(i2);
        int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 29;
        BuiltInFictitiousFunctionClassFactory = i4 % 128;
        int i5 = i4 % 2;
    }

    public final void writeBool(int i, boolean z) throws IOException {
        int i2 = BuiltInFictitiousFunctionClassFactory + 47;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        int i3 = i2 % 2;
        try {
            writeTag(i, 0);
            try {
                writeBoolNoTag(z);
                int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 77;
                BuiltInFictitiousFunctionClassFactory = i4 % 128;
                int i5 = i4 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final void writeGroup(int i, MessageLite messageLite) throws IOException {
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 71;
        BuiltInFictitiousFunctionClassFactory = i2 % 128;
        if (i2 % 2 != 0) {
            try {
                writeTag(i, 3);
                writeGroupNoTag(messageLite);
                writeTag(i, 4);
            } catch (Exception e) {
                throw e;
            }
        } else {
            writeTag(i, 3);
            writeGroupNoTag(messageLite);
            writeTag(i, 4);
        }
        int i3 = BuiltInFictitiousFunctionClassFactory + 99;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if (i3 % 2 == 0) {
            return;
        }
        int i4 = 40 / 0;
    }

    public final void writeMessage(int i, MessageLite messageLite) throws IOException {
        try {
            int i2 = BuiltInFictitiousFunctionClassFactory + 59;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            int i3 = i2 % 2;
            writeTag(i, 2);
            writeMessageNoTag(messageLite);
            int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 123;
            BuiltInFictitiousFunctionClassFactory = i4 % 128;
            int i5 = i4 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public final void writeBytes(int i, ByteString byteString) throws IOException {
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 77;
        BuiltInFictitiousFunctionClassFactory = i2 % 128;
        int i3 = i2 % 2;
        writeTag(i, 2);
        writeBytesNoTag(byteString);
        try {
            int i4 = BuiltInFictitiousFunctionClassFactory + 105;
            KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
            if ((i4 % 2 != 0 ? (char) 6 : ';') != 6) {
                return;
            }
            int i5 = 67 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    public final void writeUInt32(int i, int i2) throws IOException {
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 99;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        if (i3 % 2 != 0) {
        }
        writeTag(i, 0);
        writeUInt32NoTag(i2);
    }

    public final void writeEnum(int i, int i2) throws IOException {
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 77;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        if (i3 % 2 == 0) {
            try {
                writeTag(i, 0);
                writeEnumNoTag(i2);
            } catch (Exception e) {
                throw e;
            }
        } else {
            writeTag(i, 0);
            writeEnumNoTag(i2);
        }
        int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 69;
        BuiltInFictitiousFunctionClassFactory = i4 % 128;
        int i5 = i4 % 2;
    }

    public final void writeSInt64(int i, long j) throws IOException {
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 93;
        BuiltInFictitiousFunctionClassFactory = i2 % 128;
        int i3 = i2 % 2;
        writeTag(i, 0);
        writeSInt64NoTag(j);
        try {
            int i4 = BuiltInFictitiousFunctionClassFactory + 71;
            KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
            if (i4 % 2 != 0) {
                Object obj = null;
                obj.hashCode();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public final void writeMessageSetExtension(int i, MessageLite messageLite) throws IOException {
        try {
            int i2 = BuiltInFictitiousFunctionClassFactory + 25;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            int i3 = i2 % 2;
            writeTag(1, 3);
            writeUInt32(2, i);
            writeMessage(3, messageLite);
            writeTag(1, 4);
            int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 111;
            BuiltInFictitiousFunctionClassFactory = i4 % 128;
            if (i4 % 2 != 0) {
                return;
            }
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    public final void writeDoubleNoTag(double d) throws IOException {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 55;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            Object[] objArr = null;
            if (i % 2 == 0) {
                writeRawLittleEndian64(Double.doubleToRawLongBits(d));
                int length = objArr.length;
            } else {
                try {
                    writeRawLittleEndian64(Double.doubleToRawLongBits(d));
                } catch (Exception e) {
                    throw e;
                }
            }
            int i2 = BuiltInFictitiousFunctionClassFactory + 3;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            if (!(i2 % 2 == 0)) {
                objArr.hashCode();
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final void writeFloatNoTag(float f) throws IOException {
        int i = BuiltInFictitiousFunctionClassFactory + 23;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        writeRawLittleEndian32(Float.floatToRawIntBits(f));
        int i3 = BuiltInFictitiousFunctionClassFactory + 57;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
    }

    public final void writeUInt64NoTag(long j) throws IOException {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 29;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        writeRawVarint64(j);
        try {
            int i3 = BuiltInFictitiousFunctionClassFactory + 37;
            try {
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                if ((i3 % 2 != 0 ? 'F' : (char) 11) != 11) {
                    Object obj = null;
                    obj.hashCode();
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final void writeInt64NoTag(long j) throws IOException {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 121;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if (!(i % 2 == 0)) {
            writeRawVarint64(j);
        } else {
            try {
                writeRawVarint64(j);
                int i2 = 72 / 0;
            } catch (Exception e) {
                throw e;
            }
        }
        try {
            int i3 = BuiltInFictitiousFunctionClassFactory + 17;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            if ((i3 % 2 != 0 ? 'P' : 'D') != 'P') {
                return;
            }
            Object obj = null;
            obj.hashCode();
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final void writeInt32NoTag(int i) throws IOException {
        int i2 = BuiltInFictitiousFunctionClassFactory + 91;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        int i3 = i2 % 2;
        if (i >= 0) {
            int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 69;
            BuiltInFictitiousFunctionClassFactory = i4 % 128;
            int i5 = i4 % 2;
            writeRawVarint32(i);
            return;
        }
        writeRawVarint64(i);
    }

    public final void writeFixed64NoTag(long j) throws IOException {
        int i = BuiltInFictitiousFunctionClassFactory + 107;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        writeRawLittleEndian64(j);
        int i3 = BuiltInFictitiousFunctionClassFactory + 41;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if ((i3 % 2 != 0 ? '7' : 'K') != 'K') {
            int i4 = 27 / 0;
        }
    }

    public final void writeFixed32NoTag(int i) throws IOException {
        try {
            int i2 = BuiltInFictitiousFunctionClassFactory + 69;
            try {
                KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
                int i3 = i2 % 2;
                writeRawLittleEndian32(i);
                int i4 = BuiltInFictitiousFunctionClassFactory + 67;
                KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
                int i5 = i4 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final void writeBoolNoTag(boolean z) throws IOException {
        int i = BuiltInFictitiousFunctionClassFactory + 53;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        char c = i % 2 != 0 ? '2' : '%';
        writeRawByte(z ? 1 : 0);
        if (c != '%') {
            Object obj = null;
            obj.hashCode();
        }
    }

    public final void writeStringNoTag(String str) throws IOException {
        int i = BuiltInFictitiousFunctionClassFactory + 47;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        Object[] objArr = new Object[1];
        a(new char[]{26983, 8869, 23160, 30328, 23854}, new char[]{56455, 41821, 11762, 28074}, (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 43565), new char[]{0, 0, 0, 0}, (Process.myPid() >> 22) - 224174628, objArr);
        byte[] bytes = str.getBytes(((String) objArr[0]).intern());
        writeRawVarint32(bytes.length);
        writeRawBytes(bytes);
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 19;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        if (i3 % 2 != 0) {
            return;
        }
        int i4 = 17 / 0;
    }

    public final void writeGroupNoTag(MessageLite messageLite) throws IOException {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 85;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        messageLite.writeTo(this);
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 65;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        int i4 = i3 % 2;
    }

    public final void writeMessageNoTag(MessageLite messageLite) throws IOException {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 67;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        try {
            try {
                writeRawVarint32(messageLite.getSerializedSize());
                messageLite.writeTo(this);
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 89;
                BuiltInFictitiousFunctionClassFactory = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final void writeBytesNoTag(ByteString byteString) throws IOException {
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 55;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            writeRawVarint32(byteString.size());
            writeRawBytes(byteString);
            int i3 = BuiltInFictitiousFunctionClassFactory + 77;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            if (!(i3 % 2 == 0)) {
                Object[] objArr = null;
                int length = objArr.length;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public final void writeByteArrayNoTag(byte[] bArr) throws IOException {
        int i = BuiltInFictitiousFunctionClassFactory + 45;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        writeRawVarint32(bArr.length);
        writeRawBytes(bArr);
        int i3 = BuiltInFictitiousFunctionClassFactory + 53;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
    }

    public final void writeUInt32NoTag(int i) throws IOException {
        int i2 = BuiltInFictitiousFunctionClassFactory + 73;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        boolean z = i2 % 2 == 0;
        writeRawVarint32(i);
        if (z) {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    public final void writeEnumNoTag(int i) throws IOException {
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 15;
        BuiltInFictitiousFunctionClassFactory = i2 % 128;
        int i3 = i2 % 2;
        try {
            writeInt32NoTag(i);
            int i4 = BuiltInFictitiousFunctionClassFactory + 93;
            KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
            if (i4 % 2 != 0) {
                Object[] objArr = null;
                int length = objArr.length;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public final void writeSFixed32NoTag(int i) throws IOException {
        try {
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 61;
            try {
                BuiltInFictitiousFunctionClassFactory = i2 % 128;
                if ((i2 % 2 == 0 ? (char) 6 : ']') != ']') {
                    writeRawLittleEndian32(i);
                    Object[] objArr = null;
                    int length = objArr.length;
                } else {
                    writeRawLittleEndian32(i);
                }
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 57;
                BuiltInFictitiousFunctionClassFactory = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final void writeSFixed64NoTag(long j) throws IOException {
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 31;
            try {
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                if (i % 2 == 0) {
                    writeRawLittleEndian64(j);
                } else {
                    writeRawLittleEndian64(j);
                    Object obj = null;
                    obj.hashCode();
                }
                int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 117;
                BuiltInFictitiousFunctionClassFactory = i2 % 128;
                int i3 = i2 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final void writeSInt32NoTag(int i) throws IOException {
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 111;
        BuiltInFictitiousFunctionClassFactory = i2 % 128;
        char c = i2 % 2 == 0 ? 'E' : 'G';
        writeRawVarint32(encodeZigZag32(i));
        if (c != 'G') {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    public final void writeSInt64NoTag(long j) throws IOException {
        int i = BuiltInFictitiousFunctionClassFactory + 19;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if ((i % 2 != 0 ? '\f' : (char) 3) != 3) {
            writeRawVarint64(encodeZigZag64(j));
            Object obj = null;
            obj.hashCode();
            return;
        }
        try {
            writeRawVarint64(encodeZigZag64(j));
        } catch (Exception e) {
            throw e;
        }
    }

    public static int computeDoubleSize(int i, double d) {
        try {
            int i2 = BuiltInFictitiousFunctionClassFactory + 87;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            return (i2 % 2 != 0 ? 'M' : 'L') != 'M' ? computeTagSize(i) + computeDoubleSizeNoTag(d) : computeTagSize(i) << computeDoubleSizeNoTag(d);
        } catch (Exception e) {
            throw e;
        }
    }

    public static int computeFloatSize(int i, float f) {
        int computeTagSize;
        int i2 = BuiltInFictitiousFunctionClassFactory + 73;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        if ((i2 % 2 != 0 ? '\f' : (char) 3) != 3) {
            try {
                computeTagSize = computeTagSize(i) >>> computeFloatSizeNoTag(f);
            } catch (Exception e) {
                throw e;
            }
        } else {
            computeTagSize = computeTagSize(i) + computeFloatSizeNoTag(f);
        }
        int i3 = BuiltInFictitiousFunctionClassFactory + 101;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if ((i3 % 2 != 0 ? (char) 19 : 'F') != 'F') {
            Object obj = null;
            obj.hashCode();
            return computeTagSize;
        }
        return computeTagSize;
    }

    public static int computeInt32Size(int i, int i2) {
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 15;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        int i4 = i3 % 2;
        try {
            int computeTagSize = computeTagSize(i) + computeInt32SizeNoTag(i2);
            int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 57;
            BuiltInFictitiousFunctionClassFactory = i5 % 128;
            if (!(i5 % 2 == 0)) {
                return computeTagSize;
            }
            Object obj = null;
            obj.hashCode();
            return computeTagSize;
        } catch (Exception e) {
            throw e;
        }
    }

    public static int computeBoolSize(int i, boolean z) {
        try {
            int i2 = BuiltInFictitiousFunctionClassFactory + 75;
            try {
                KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
                return i2 % 2 == 0 ? computeTagSize(i) + computeBoolSizeNoTag(z) : computeTagSize(i) << computeBoolSizeNoTag(z);
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static int computeMessageSize(int i, MessageLite messageLite) {
        int i2 = BuiltInFictitiousFunctionClassFactory + 35;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        int i3 = i2 % 2;
        int computeTagSize = computeTagSize(i) + computeMessageSizeNoTag(messageLite);
        int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 13;
        BuiltInFictitiousFunctionClassFactory = i4 % 128;
        if ((i4 % 2 == 0 ? JSONLexer.EOI : (char) 30) != 26) {
            return computeTagSize;
        }
        int i5 = 25 / 0;
        return computeTagSize;
    }

    public static int computeBytesSize(int i, ByteString byteString) {
        int i2 = BuiltInFictitiousFunctionClassFactory + 63;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        int i3 = i2 % 2;
        int computeTagSize = computeTagSize(i) + computeBytesSizeNoTag(byteString);
        int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 107;
        BuiltInFictitiousFunctionClassFactory = i4 % 128;
        if ((i4 % 2 == 0 ? '-' : 'Z') != 'Z') {
            Object[] objArr = null;
            int length = objArr.length;
            return computeTagSize;
        }
        return computeTagSize;
    }

    public static int computeEnumSize(int i, int i2) {
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 43;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        boolean z = i3 % 2 != 0;
        int computeTagSize = computeTagSize(i);
        int computeEnumSizeNoTag = computeEnumSizeNoTag(i2);
        return z ? computeTagSize + computeEnumSizeNoTag : computeTagSize * computeEnumSizeNoTag;
    }

    public static int computeSInt64Size(int i, long j) {
        int i2 = BuiltInFictitiousFunctionClassFactory + 19;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        int i3 = i2 % 2;
        try {
            try {
                int computeTagSize = computeTagSize(i) + computeSInt64SizeNoTag(j);
                int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 113;
                BuiltInFictitiousFunctionClassFactory = i4 % 128;
                if ((i4 % 2 == 0 ? '^' : ',') != '^') {
                    return computeTagSize;
                }
                Object obj = null;
                obj.hashCode();
                return computeTagSize;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static int computeUInt64SizeNoTag(long j) {
        int i = BuiltInFictitiousFunctionClassFactory + 99;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        int computeRawVarint64Size = computeRawVarint64Size(j);
        int i3 = BuiltInFictitiousFunctionClassFactory + 97;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if (!(i3 % 2 != 0)) {
            return computeRawVarint64Size;
        }
        int i4 = 76 / 0;
        return computeRawVarint64Size;
    }

    public static int computeInt64SizeNoTag(long j) {
        int i = BuiltInFictitiousFunctionClassFactory + 67;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        int computeRawVarint64Size = computeRawVarint64Size(j);
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 57;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        int i4 = i3 % 2;
        return computeRawVarint64Size;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
    
        if ((r3 < 0) != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:
    
        if (r3 >= 0) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0024, code lost:
    
        return computeRawVarint32Size(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0025, code lost:
    
        r0 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.BuiltInFictitiousFunctionClassFactory + 41;
        kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.KClassImpl$Data$declaredNonStaticMembers$2 = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0031, code lost:
    
        return 10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int computeInt32SizeNoTag(int r3) {
        /*
            int r0 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 43
            int r1 = r0 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            if (r0 == r2) goto L1a
            if (r3 < 0) goto L16
            goto L17
        L16:
            r1 = 1
        L17:
            if (r1 == 0) goto L20
            goto L25
        L1a:
            r0 = 0
            r0.hashCode()     // Catch: java.lang.Throwable -> L32
            if (r3 < 0) goto L25
        L20:
            int r3 = computeRawVarint32Size(r3)
            return r3
        L25:
            r3 = 10
            int r0 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 41
            int r1 = r0 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            return r3
        L32:
            r3 = move-exception
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.computeInt32SizeNoTag(int):int");
    }

    public static int computeStringSizeNoTag(String str) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 55;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        try {
            Object[] objArr = new Object[1];
            a(new char[]{26983, 8869, 23160, 30328, 23854}, new char[]{56455, 41821, 11762, 28074}, (char) (43565 - (ViewConfiguration.getJumpTapTimeout() >> 16)), new char[]{0, 0, 0, 0}, Color.blue(0) - 224174628, objArr);
            byte[] bytes = str.getBytes(((String) objArr[0]).intern());
            int computeRawVarint32Size = computeRawVarint32Size(bytes.length) + bytes.length;
            int i3 = BuiltInFictitiousFunctionClassFactory + 91;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            if ((i3 % 2 != 0 ? ']' : (char) 28) != ']') {
                return computeRawVarint32Size;
            }
            Object obj = null;
            obj.hashCode();
            return computeRawVarint32Size;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported.", e);
        }
    }

    public static int computeGroupSizeNoTag(MessageLite messageLite) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 123;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        int serializedSize = messageLite.getSerializedSize();
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 9;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        if (i3 % 2 == 0) {
            int i4 = 40 / 0;
            return serializedSize;
        }
        return serializedSize;
    }

    public static int computeMessageSizeNoTag(MessageLite messageLite) {
        int i = BuiltInFictitiousFunctionClassFactory + 23;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (i % 2 == 0) {
            int serializedSize = messageLite.getSerializedSize();
            return computeRawVarint32Size(serializedSize) + serializedSize;
        }
        int serializedSize2 = messageLite.getSerializedSize();
        return computeRawVarint32Size(serializedSize2) % serializedSize2;
    }

    public static int computeLazyFieldSizeNoTag(LazyFieldLite lazyFieldLite) {
        int i = BuiltInFictitiousFunctionClassFactory + 1;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        int serializedSize = lazyFieldLite.getSerializedSize();
        int computeRawVarint32Size = computeRawVarint32Size(serializedSize) + serializedSize;
        try {
            int i3 = BuiltInFictitiousFunctionClassFactory + 13;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
            return computeRawVarint32Size;
        } catch (Exception e) {
            throw e;
        }
    }

    public static int computeBytesSizeNoTag(ByteString byteString) {
        int i = BuiltInFictitiousFunctionClassFactory + 49;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        return (i % 2 != 0 ? '9' : (char) 23) != 23 ? computeRawVarint32Size(byteString.size()) - byteString.size() : computeRawVarint32Size(byteString.size()) + byteString.size();
    }

    public static int computeByteArraySizeNoTag(byte[] bArr) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 107;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        return i % 2 != 0 ? computeRawVarint32Size(bArr.length) + bArr.length : computeRawVarint32Size(bArr.length) >>> bArr.length;
    }

    public static int computeUInt32SizeNoTag(int i) {
        try {
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 109;
            BuiltInFictitiousFunctionClassFactory = i2 % 128;
            int i3 = i2 % 2;
            int computeRawVarint32Size = computeRawVarint32Size(i);
            int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 59;
            try {
                BuiltInFictitiousFunctionClassFactory = i4 % 128;
                if (!(i4 % 2 != 0)) {
                    Object obj = null;
                    obj.hashCode();
                    return computeRawVarint32Size;
                }
                return computeRawVarint32Size;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static int computeEnumSizeNoTag(int i) {
        int i2 = BuiltInFictitiousFunctionClassFactory + 107;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        int i3 = i2 % 2;
        int computeInt32SizeNoTag = computeInt32SizeNoTag(i);
        int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 25;
        BuiltInFictitiousFunctionClassFactory = i4 % 128;
        if ((i4 % 2 == 0 ? (char) 24 : 'b') != 'b') {
            Object[] objArr = null;
            int length = objArr.length;
            return computeInt32SizeNoTag;
        }
        return computeInt32SizeNoTag;
    }

    public static int computeSInt32SizeNoTag(int i) {
        int i2 = BuiltInFictitiousFunctionClassFactory + 61;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        char c = i2 % 2 != 0 ? (char) 23 : '^';
        int computeRawVarint32Size = computeRawVarint32Size(encodeZigZag32(i));
        if (c != '^') {
            Object[] objArr = null;
            int length = objArr.length;
        }
        try {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 107;
            try {
                BuiltInFictitiousFunctionClassFactory = i3 % 128;
                int i4 = i3 % 2;
                return computeRawVarint32Size;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static int computeSInt64SizeNoTag(long j) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 33;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        boolean z = i % 2 == 0;
        int computeRawVarint64Size = computeRawVarint64Size(encodeZigZag64(j));
        if (z) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        return computeRawVarint64Size;
    }

    private void refreshBuffer() throws IOException {
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 33;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            OutputStream outputStream = this.output;
            if ((outputStream != null ? Typography.quote : '6') != '\"') {
                throw new OutOfSpaceException();
            }
            outputStream.write(this.buffer, 0, this.position);
            this.position = 0;
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 73;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            if ((i3 % 2 == 0 ? 'a' : '[') != '[') {
                Object[] objArr = null;
                int length = objArr.length;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public final void flush() throws IOException {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 25;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if (i % 2 == 0) {
            OutputStream outputStream = this.output;
            Object[] objArr = null;
            int length = objArr.length;
            if ((outputStream != null ? '=' : '9') != '=') {
                return;
            }
        } else {
            if ((this.output != null ? 'T' : '\'') == '\'') {
                return;
            }
        }
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 47;
        BuiltInFictitiousFunctionClassFactory = i2 % 128;
        int i3 = i2 % 2;
        refreshBuffer();
        if (i3 == 0) {
            int i4 = 23 / 0;
        }
    }

    /* loaded from: classes.dex */
    public static class OutOfSpaceException extends IOException {
        OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0022, code lost:
    
        if ((r5.position != r5.limit) != true) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0024, code lost:
    
        refreshBuffer();
        r0 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.BuiltInFictitiousFunctionClassFactory + 89;
        kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.KClassImpl$Data$declaredNonStaticMembers$2 = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0014, code lost:
    
        if (r0 == r3) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void writeRawByte(byte r6) throws java.io.IOException {
        /*
            r5 = this;
            int r0 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> L5c
            int r0 = r0 + 41
            int r1 = r0 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.KClassImpl$Data$declaredNonStaticMembers$2 = r1     // Catch: java.lang.Exception -> L5c
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L19
            int r0 = r5.position
            int r3 = r5.limit
            r4 = 0
            int r4 = r4.length     // Catch: java.lang.Throwable -> L17
            if (r0 != r3) goto L31
            goto L24
        L17:
            r6 = move-exception
            throw r6
        L19:
            int r0 = r5.position
            int r3 = r5.limit
            if (r0 != r3) goto L21
            r0 = 0
            goto L22
        L21:
            r0 = 1
        L22:
            if (r0 == r2) goto L31
        L24:
            r5.refreshBuffer()
            int r0 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 89
            int r3 = r0 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.KClassImpl$Data$declaredNonStaticMembers$2 = r3
            int r0 = r0 % 2
        L31:
            byte[] r0 = r5.buffer
            int r3 = r5.position
            int r4 = r3 + 1
            r5.position = r4
            r0[r3] = r6
            int r6 = r5.totalBytesWritten
            int r6 = r6 + r2
            r5.totalBytesWritten = r6
            int r6 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.BuiltInFictitiousFunctionClassFactory
            int r6 = r6 + 73
            int r0 = r6 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.KClassImpl$Data$declaredNonStaticMembers$2 = r0
            int r6 = r6 % 2
            r0 = 83
            if (r6 == 0) goto L51
            r6 = 83
            goto L53
        L51:
            r6 = 45
        L53:
            if (r6 == r0) goto L56
            return
        L56:
            r6 = 14
            int r6 = r6 / r1
            return
        L5a:
            r6 = move-exception
            throw r6
        L5c:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.writeRawByte(byte):void");
    }

    public final void writeRawByte(int i) throws IOException {
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 79;
        BuiltInFictitiousFunctionClassFactory = i2 % 128;
        int i3 = i2 % 2;
        writeRawByte((byte) i);
        int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 67;
        BuiltInFictitiousFunctionClassFactory = i4 % 128;
        int i5 = i4 % 2;
    }

    public final void writeRawBytes(ByteString byteString) throws IOException {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 73;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        writeRawBytes(byteString, (i % 2 == 0 ? '`' : '\\') != '\\' ? 1 : 0, byteString.size());
    }

    public final void writeRawBytes(byte[] bArr) throws IOException {
        int i = BuiltInFictitiousFunctionClassFactory + 69;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        writeRawBytes(bArr, 0, bArr.length);
        try {
            int i3 = BuiltInFictitiousFunctionClassFactory + 67;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public final void writeRawBytes(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        int i4 = this.limit;
        int i5 = this.position;
        int i6 = i4 - i5;
        if (!(i6 >= i2)) {
            System.arraycopy(bArr, i, this.buffer, i5, i6);
            int i7 = i + i6;
            i2 -= i6;
            this.position = this.limit;
            this.totalBytesWritten += i6;
            refreshBuffer();
            if (!(i2 > this.limit)) {
                int i8 = BuiltInFictitiousFunctionClassFactory + 7;
                KClassImpl$Data$declaredNonStaticMembers$2 = i8 % 128;
                int i9 = i8 % 2;
                System.arraycopy(bArr, i7, this.buffer, 0, i2);
                this.position = i2;
                int i10 = BuiltInFictitiousFunctionClassFactory + 7;
                KClassImpl$Data$declaredNonStaticMembers$2 = i10 % 128;
                int i11 = i10 % 2;
            } else {
                try {
                    this.output.write(bArr, i7, i2);
                } catch (Exception e) {
                    throw e;
                }
            }
        } else {
            int i12 = KClassImpl$Data$declaredNonStaticMembers$2 + 97;
            BuiltInFictitiousFunctionClassFactory = i12 % 128;
            if (i12 % 2 == 0) {
                System.arraycopy(bArr, i, this.buffer, i5, i2);
                i3 = this.position - i2;
            } else {
                System.arraycopy(bArr, i, this.buffer, i5, i2);
                i3 = this.position + i2;
            }
            this.position = i3;
        }
        this.totalBytesWritten += i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002b, code lost:
    
        if ((r0 / r1 < r8) != true) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002d, code lost:
    
        r6.copyTo(r5.buffer, r7, r1, r8);
        r5.position += r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0038, code lost:
    
        r0 = r0 - r1;
        r6.copyTo(r5.buffer, r7, r1, r0);
        r7 = r7 + r0;
        r8 = r8 - r0;
        r5.position = r5.limit;
        r5.totalBytesWritten += r0;
        refreshBuffer();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004e, code lost:
    
        if (r8 > r5.limit) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0050, code lost:
    
        r0 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.BuiltInFictitiousFunctionClassFactory + 81;
        kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.KClassImpl$Data$declaredNonStaticMembers$2 = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005c, code lost:
    
        if ((r0 % 2) == 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005e, code lost:
    
        r0 = '^';
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0061, code lost:
    
        r0 = '7';
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0063, code lost:
    
        if (r0 == '7') goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0065, code lost:
    
        r6.copyTo(r5.buffer, r7, 0, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006b, code lost:
    
        r6.copyTo(r5.buffer, r7, 0, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0070, code lost:
    
        r5.position = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0073, code lost:
    
        r6.writeTo(r5.output, r7, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001c, code lost:
    
        if ((r0 - r1) >= r8) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void writeRawBytes(kotlin.reflect.jvm.internal.impl.protobuf.ByteString r6, int r7, int r8) throws java.io.IOException {
        /*
            r5 = this;
            int r0 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 53
            int r1 = r0 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            r1 = 29
            if (r0 == 0) goto L11
            r0 = 29
            goto L13
        L11:
            r0 = 22
        L13:
            r2 = 0
            if (r0 == r1) goto L1f
            int r0 = r5.limit
            int r1 = r5.position
            int r3 = r0 - r1
            if (r3 < r8) goto L38
            goto L2d
        L1f:
            int r0 = r5.limit     // Catch: java.lang.Exception -> L80
            int r1 = r5.position     // Catch: java.lang.Exception -> L80
            int r3 = r0 / r1
            r4 = 1
            if (r3 < r8) goto L2a
            r3 = 0
            goto L2b
        L2a:
            r3 = 1
        L2b:
            if (r3 == r4) goto L38
        L2d:
            byte[] r0 = r5.buffer
            r6.copyTo(r0, r7, r1, r8)
            int r6 = r5.position
            int r6 = r6 + r8
            r5.position = r6
            goto L78
        L38:
            int r0 = r0 - r1
            byte[] r3 = r5.buffer
            r6.copyTo(r3, r7, r1, r0)
            int r7 = r7 + r0
            int r8 = r8 - r0
            int r1 = r5.limit
            r5.position = r1
            int r1 = r5.totalBytesWritten
            int r1 = r1 + r0
            r5.totalBytesWritten = r1
            r5.refreshBuffer()
            int r0 = r5.limit
            if (r8 > r0) goto L73
            int r0 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 81
            int r1 = r0 % 128
            kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            r1 = 55
            if (r0 == 0) goto L61
            r0 = 94
            goto L63
        L61:
            r0 = 55
        L63:
            if (r0 == r1) goto L6b
            byte[] r0 = r5.buffer
            r6.copyTo(r0, r7, r2, r8)
            goto L70
        L6b:
            byte[] r0 = r5.buffer
            r6.copyTo(r0, r7, r2, r8)
        L70:
            r5.position = r8
            goto L78
        L73:
            java.io.OutputStream r0 = r5.output
            r6.writeTo(r0, r7, r8)
        L78:
            int r6 = r5.totalBytesWritten     // Catch: java.lang.Exception -> L80
            int r6 = r6 + r8
            r5.totalBytesWritten = r6     // Catch: java.lang.Exception -> L7e
            return
        L7e:
            r6 = move-exception
            throw r6
        L80:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.writeRawBytes(kotlin.reflect.jvm.internal.impl.protobuf.ByteString, int, int):void");
    }

    public final void writeTag(int i, int i2) throws IOException {
        try {
            int i3 = BuiltInFictitiousFunctionClassFactory + 109;
            try {
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                if ((i3 % 2 != 0 ? (char) 28 : 'R') != 'R') {
                    writeRawVarint32(WireFormat.makeTag(i, i2));
                    int i4 = 99 / 0;
                } else {
                    writeRawVarint32(WireFormat.makeTag(i, i2));
                }
                int i5 = BuiltInFictitiousFunctionClassFactory + 75;
                KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                if (i5 % 2 != 0) {
                    Object obj = null;
                    obj.hashCode();
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static int computeTagSize(int i) {
        try {
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 121;
            try {
                BuiltInFictitiousFunctionClassFactory = i2 % 128;
                int i3 = i2 % 2;
                int computeRawVarint32Size = computeRawVarint32Size(WireFormat.makeTag(i, 0));
                int i4 = BuiltInFictitiousFunctionClassFactory + 37;
                KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
                int i5 = i4 % 2;
                return computeRawVarint32Size;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final void writeRawVarint32(int i) throws IOException {
        while (true) {
            if (!((i & (-128)) != 0)) {
                int i2 = BuiltInFictitiousFunctionClassFactory + 73;
                KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
                int i3 = i2 % 2;
                writeRawByte(i);
                return;
            }
            writeRawByte((i & 127) | 128);
            i >>>= 7;
            int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 53;
            BuiltInFictitiousFunctionClassFactory = i4 % 128;
            int i5 = i4 % 2;
        }
    }

    public final void writeRawVarint64(long j) throws IOException {
        while (true) {
            if ((((-128) & j) == 0 ? 'c' : '\r') == 'c') {
                int i = BuiltInFictitiousFunctionClassFactory + 5;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
                try {
                    writeRawByte((int) j);
                    int i3 = BuiltInFictitiousFunctionClassFactory + 73;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                    int i4 = i3 % 2;
                    return;
                } catch (Exception e) {
                    throw e;
                }
            }
            writeRawByte((((int) j) & 127) | 128);
            j >>>= 7;
        }
    }

    public final void writeRawLittleEndian32(int i) throws IOException {
        int i2;
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 29;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        if ((i3 % 2 == 0 ? (char) 16 : (char) 24) != 24) {
            writeRawByte(i | 5079);
            writeRawByte((i >>> 118) ^ 28127);
            writeRawByte((i >>> 34) | 17143);
            i2 = (i % 44) ^ 19563;
        } else {
            writeRawByte(i & 255);
            writeRawByte((i >> 8) & 255);
            writeRawByte((i >> 16) & 255);
            i2 = (i >> 24) & 255;
        }
        writeRawByte(i2);
        int i4 = BuiltInFictitiousFunctionClassFactory + 79;
        KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
        if (!(i4 % 2 != 0)) {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    public final void writeRawLittleEndian64(long j) throws IOException {
        int i = BuiltInFictitiousFunctionClassFactory + 97;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        writeRawByte(((int) j) & 255);
        writeRawByte(((int) (j >> 8)) & 255);
        writeRawByte(((int) (j >> 16)) & 255);
        writeRawByte(((int) (j >> 24)) & 255);
        writeRawByte(((int) (j >> 32)) & 255);
        writeRawByte(((int) (j >> 40)) & 255);
        writeRawByte(((int) (j >> 48)) & 255);
        writeRawByte(((int) (j >> 56)) & 255);
        try {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 125;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            if ((i3 % 2 == 0 ? '#' : (char) 25) != '#') {
                return;
            }
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    private static void a(char[] cArr, char[] cArr2, char c, char[] cArr3, int i, Object[] objArr) {
        E e = new E();
        int length = cArr2.length;
        char[] cArr4 = new char[length];
        int length2 = cArr3.length;
        char[] cArr5 = new char[length2];
        System.arraycopy(cArr2, 0, cArr4, 0, length);
        System.arraycopy(cArr3, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr.length;
        char[] cArr6 = new char[length3];
        e.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        int i2 = $10 + 89;
        $11 = i2 % 128;
        int i3 = i2 % 2;
        while (true) {
            if (e.KClassImpl$Data$declaredNonStaticMembers$2 >= length3) {
                objArr[0] = new String(cArr6);
                return;
            }
            int i4 = $11 + 83;
            $10 = i4 % 128;
            int i5 = i4 % 2;
            int i6 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
            int i7 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
            e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i6]) % 65535);
            cArr5[i7] = (char) (((cArr4[i7] * 32718) + cArr5[i6]) / 65535);
            cArr4[i7] = e.MyBillsEntityDataFactory;
            cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i7] ^ cArr[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (getAuthRequestContext ^ 4360990799332652212L)) ^ ((int) (MyBillsEntityDataFactory ^ 4360990799332652212L))) ^ ((char) (PlaceComponentResult ^ 4360990799332652212L)));
            e.KClassImpl$Data$declaredNonStaticMembers$2++;
        }
    }
}
