package com.zoloz.wire;

import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import com.alibaba.fastjson.parser.JSONLexer;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import kotlin.text.Typography;
import o.B;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class WireInput {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static final String ENCOUNTERED_A_MALFORMED_VARINT = "WireInput encountered a malformed varint.";
    private static final String ENCOUNTERED_A_NEGATIVE_SIZE = "Encountered a negative size";
    private static final String INPUT_ENDED_UNEXPECTEDLY = "The input ended unexpectedly in the middle of a field";
    private static short[] KClassImpl$Data$declaredNonStaticMembers$2 = null;
    private static byte[] MyBillsEntityDataFactory = null;
    private static final String PROTOCOL_MESSAGE_CONTAINED_AN_INVALID_TAG_ZERO = "Protocol message contained an invalid tag (zero).";
    private static final String PROTOCOL_MESSAGE_END_GROUP_TAG_DID_NOT_MATCH_EXPECTED_TAG = "Protocol message end-group tag did not match expected tag.";
    private static int PlaceComponentResult = 0;
    public static final int RECURSION_LIMIT = 64;
    private static final Charset UTF_8;
    private static int getAuthRequestContext = 0;
    private static int getErrorConfigVersion = 1;
    private static int lookAheadTest;
    private int lastTag;
    public int recursionDepth;
    private final BufferedSource source;
    private int pos = 0;
    private int currentLimit = Integer.MAX_VALUE;

    public static int decodeZigZag32(int i) {
        try {
            int i2 = lookAheadTest + 119;
            getErrorConfigVersion = i2 % 128;
            if ((i2 % 2 == 0 ? (char) 15 : (char) 19) != 19) {
                return (i >>> 1) | (-(i | 0));
            }
            return (i >>> 1) ^ (-(i & 1));
        } catch (Exception e) {
            throw e;
        }
    }

    public static long decodeZigZag64(long j) {
        int i = getErrorConfigVersion + 37;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        long j2 = (j >>> 1) ^ (-(1 & j));
        try {
            int i3 = getErrorConfigVersion + 69;
            lookAheadTest = i3 % 128;
            if ((i3 % 2 != 0 ? '0' : (char) 4) != 4) {
                Object obj = null;
                obj.hashCode();
                return j2;
            }
            return j2;
        } catch (Exception e) {
            throw e;
        }
    }

    static void getAuthRequestContext() {
        BuiltInFictitiousFunctionClassFactory = 1257195770;
        PlaceComponentResult = 897186218;
        MyBillsEntityDataFactory = new byte[]{63, -93, 79, 90, 87};
        getAuthRequestContext = -956651018;
    }

    static {
        getAuthRequestContext();
        Object[] objArr = new Object[1];
        a(1944723096 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (-102) - TextUtils.indexOf("", "", 0), (short) (ViewConfiguration.getDoubleTapTimeout() >> 16), TextUtils.indexOf("", "") - 2140582112, (byte) (55 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))), objArr);
        UTF_8 = Charset.forName(((String) objArr[0]).intern());
        int i = getErrorConfigVersion + 105;
        lookAheadTest = i % 128;
        int i2 = i % 2;
    }

    public static WireInput newInstance(byte[] bArr) {
        WireInput wireInput = new WireInput(new Buffer().KClassImpl$Data$declaredNonStaticMembers$2(bArr));
        int i = lookAheadTest + 43;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        return wireInput;
    }

    public static WireInput newInstance(byte[] bArr, int i, int i2) {
        try {
            WireInput wireInput = new WireInput(new Buffer().MyBillsEntityDataFactory(bArr, i, i2));
            int i3 = getErrorConfigVersion + 99;
            lookAheadTest = i3 % 128;
            int i4 = i3 % 2;
            return wireInput;
        } catch (Exception e) {
            throw e;
        }
    }

    public static WireInput newInstance(InputStream inputStream) {
        WireInput wireInput = new WireInput(Okio.KClassImpl$Data$declaredNonStaticMembers$2(Okio.getAuthRequestContext(inputStream)));
        int i = lookAheadTest + 7;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        return wireInput;
    }

    public static WireInput newInstance(Source source) {
        WireInput wireInput = new WireInput(Okio.KClassImpl$Data$declaredNonStaticMembers$2(source));
        try {
            int i = lookAheadTest + 61;
            try {
                getErrorConfigVersion = i % 128;
                int i2 = i % 2;
                return wireInput;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final int readTag() throws IOException {
        if ((isAtEnd() ? (char) 29 : ']') == 29) {
            int i = getErrorConfigVersion + 41;
            lookAheadTest = i % 128;
            if (i % 2 == 0) {
                this.lastTag = 0;
                return 0;
            }
            this.lastTag = 1;
            return 1;
        }
        int readVarint32 = readVarint32();
        this.lastTag = readVarint32;
        if (readVarint32 != 0) {
            int i2 = getErrorConfigVersion + 19;
            lookAheadTest = i2 % 128;
            if (!(i2 % 2 != 0)) {
                return readVarint32;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return readVarint32;
        }
        throw new IOException(PROTOCOL_MESSAGE_CONTAINED_AN_INVALID_TAG_ZERO);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001d, code lost:
    
        if (r2.lastTag == r3) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x001f, code lost:
    
        r3 = com.zoloz.wire.WireInput.lookAheadTest + 11;
        com.zoloz.wire.WireInput.getErrorConfigVersion = r3 % 128;
        r3 = r3 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0029, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0031, code lost:
    
        throw new java.io.IOException(com.zoloz.wire.WireInput.PROTOCOL_MESSAGE_END_GROUP_TAG_DID_NOT_MATCH_EXPECTED_TAG);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
    
        if (r0 == r3) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void checkLastTagWas(int r3) throws java.io.IOException {
        /*
            r2 = this;
            int r0 = com.zoloz.wire.WireInput.getErrorConfigVersion
            int r0 = r0 + 21
            int r1 = r0 % 128
            com.zoloz.wire.WireInput.lookAheadTest = r1
            int r0 = r0 % 2
            r1 = 1
            if (r0 == 0) goto Lf
            r0 = 0
            goto L10
        Lf:
            r0 = 1
        L10:
            if (r0 == r1) goto L1b
            int r0 = r2.lastTag
            r1 = 0
            int r1 = r1.length     // Catch: java.lang.Throwable -> L19
            if (r0 != r3) goto L2a
            goto L1f
        L19:
            r3 = move-exception
            throw r3
        L1b:
            int r0 = r2.lastTag
            if (r0 != r3) goto L2a
        L1f:
            int r3 = com.zoloz.wire.WireInput.lookAheadTest
            int r3 = r3 + 11
            int r0 = r3 % 128
            com.zoloz.wire.WireInput.getErrorConfigVersion = r0
            int r3 = r3 % 2
            return
        L2a:
            java.io.IOException r3 = new java.io.IOException
            java.lang.String r0 = "Protocol message end-group tag did not match expected tag."
            r3.<init>(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zoloz.wire.WireInput.checkLastTagWas(int):void");
    }

    public final String readString() throws IOException {
        int i = getErrorConfigVersion + 1;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        try {
            int readVarint32 = readVarint32();
            this.pos += readVarint32;
            String KClassImpl$Data$declaredNonStaticMembers$22 = this.source.KClassImpl$Data$declaredNonStaticMembers$2(readVarint32, UTF_8);
            int i3 = getErrorConfigVersion + 99;
            lookAheadTest = i3 % 128;
            int i4 = i3 % 2;
            return KClassImpl$Data$declaredNonStaticMembers$22;
        } catch (Exception e) {
            throw e;
        }
    }

    public final ByteString readBytes() throws IOException {
        try {
            int i = lookAheadTest + 23;
            getErrorConfigVersion = i % 128;
            int i2 = i % 2;
            ByteString readBytes = readBytes(readVarint32());
            try {
                int i3 = getErrorConfigVersion + 3;
                lookAheadTest = i3 % 128;
                if ((i3 % 2 != 0 ? '(' : (char) 18) != '(') {
                    return readBytes;
                }
                int i4 = 48 / 0;
                return readBytes;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final ByteString readBytes(int i) throws IOException {
        try {
            int i2 = getErrorConfigVersion + 17;
            lookAheadTest = i2 % 128;
            this.pos = (i2 % 2 != 0 ? JSONLexer.EOI : 'a') != 'a' ? this.pos << i : this.pos + i;
            long j = i;
            this.source.lookAheadTest(j);
            ByteString MyBillsEntityDataFactory2 = this.source.MyBillsEntityDataFactory(j);
            int i3 = getErrorConfigVersion + 37;
            lookAheadTest = i3 % 128;
            if (!(i3 % 2 == 0)) {
                Object obj = null;
                obj.hashCode();
                return MyBillsEntityDataFactory2;
            }
            return MyBillsEntityDataFactory2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
    
        if (r0 >= 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0039, code lost:
    
        if ((r0 >= 0 ? '^' : '\n') != '\n') goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003b, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003c, code lost:
    
        r0 = r0 & Byte.MAX_VALUE;
        r6.pos++;
        r1 = r6.source.initRecordTimeStamp();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004b, code lost:
    
        if (r1 < 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004d, code lost:
    
        r5 = '`';
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0050, code lost:
    
        r5 = 'A';
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0052, code lost:
    
        if (r5 == 'A') goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0054, code lost:
    
        r1 = r1 << 7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0057, code lost:
    
        r0 = r0 | ((r1 & Byte.MAX_VALUE) << 7);
        r6.pos++;
        r1 = r6.source.initRecordTimeStamp();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0067, code lost:
    
        if (r1 < 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006b, code lost:
    
        r2 = com.zoloz.wire.WireInput.getErrorConfigVersion + 89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006f, code lost:
    
        com.zoloz.wire.WireInput.lookAheadTest = r2 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0073, code lost:
    
        if ((r2 % 2) == 0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0075, code lost:
    
        r1 = r1 - 51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0078, code lost:
    
        r1 = r1 << 14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007b, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x007c, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007d, code lost:
    
        r0 = r0 | ((r1 & Byte.MAX_VALUE) << 14);
        r6.pos++;
        r1 = r6.source.initRecordTimeStamp();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x008d, code lost:
    
        if (r1 < 0) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x008f, code lost:
    
        r4 = com.zoloz.wire.WireInput.getErrorConfigVersion + 121;
        com.zoloz.wire.WireInput.lookAheadTest = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0099, code lost:
    
        if ((r4 % 2) == 0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x009b, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x009c, code lost:
    
        if (r2 == true) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x009e, code lost:
    
        r1 = r1 << com.google.common.base.Ascii.NAK;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a1, code lost:
    
        r1 = r1 >> 40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a5, code lost:
    
        r6.pos++;
        r4 = r6.source.initRecordTimeStamp();
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b0, code lost:
    
        r0 = (r0 | ((r1 & Byte.MAX_VALUE) << 21)) | (r4 << com.google.common.base.Ascii.FS);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ba, code lost:
    
        if (r4 >= 0) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00bc, code lost:
    
        r4 = '0';
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00bf, code lost:
    
        r4 = '\\';
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00c1, code lost:
    
        if (r4 == '\\') goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00c3, code lost:
    
        r1 = com.zoloz.wire.WireInput.lookAheadTest + 125;
        com.zoloz.wire.WireInput.getErrorConfigVersion = r1 % 128;
        r1 = r1 % 2;
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00cf, code lost:
    
        if (r1 >= 5) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00d1, code lost:
    
        r6.pos++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00dc, code lost:
    
        if (r6.source.initRecordTimeStamp() < 0) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00de, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00e0, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00e1, code lost:
    
        if (r4 == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00e3, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00e4, code lost:
    
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00ee, code lost:
    
        throw new java.io.IOException(com.zoloz.wire.WireInput.ENCOUNTERED_A_MALFORMED_VARINT);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00ef, code lost:
    
        return r0 | r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:?, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int readVarint32() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zoloz.wire.WireInput.readVarint32():int");
    }

    public final long readVarint64() throws IOException {
        int i = lookAheadTest + 41;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        long j = 0;
        for (int i3 = 0; i3 < 64; i3 += 7) {
            int i4 = getErrorConfigVersion + 85;
            lookAheadTest = i4 % 128;
            if ((i4 % 2 != 0 ? '6' : 'J') != '6') {
                this.pos++;
                j |= (r4 & Byte.MAX_VALUE) << i3;
                if ((this.source.initRecordTimeStamp() & 128) == 0) {
                    return j;
                }
            } else {
                this.pos >>>= 0;
                j /= (r4 & 103) >>> i3;
                if (((this.source.initRecordTimeStamp() | 30815) == 0 ? ']' : (char) 17) != 17) {
                    return j;
                }
            }
        }
        throw new IOException(ENCOUNTERED_A_MALFORMED_VARINT);
    }

    public final int readFixed32() throws IOException {
        int i = getErrorConfigVersion + 7;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        try {
            this.pos += 4;
            int NetworkUserEntityData$$ExternalSyntheticLambda7 = this.source.NetworkUserEntityData$$ExternalSyntheticLambda7();
            int i3 = lookAheadTest + 7;
            getErrorConfigVersion = i3 % 128;
            if (!(i3 % 2 == 0)) {
                return NetworkUserEntityData$$ExternalSyntheticLambda7;
            }
            Object obj = null;
            obj.hashCode();
            return NetworkUserEntityData$$ExternalSyntheticLambda7;
        } catch (Exception e) {
            throw e;
        }
    }

    public final long readFixed64() throws IOException {
        int i = getErrorConfigVersion + 57;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        this.pos += 8;
        long PrepareContext = this.source.PrepareContext();
        try {
            int i3 = lookAheadTest + 33;
            try {
                getErrorConfigVersion = i3 % 128;
                int i4 = i3 % 2;
                return PrepareContext;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private WireInput(BufferedSource bufferedSource) {
        this.source = bufferedSource;
    }

    public final int pushLimit(int i) throws IOException {
        if ((i >= 0 ? Typography.less : 'A') != '<') {
            throw new IOException(ENCOUNTERED_A_NEGATIVE_SIZE);
        }
        int i2 = i + this.pos;
        int i3 = this.currentLimit;
        if ((i2 <= i3 ? '^' : 'Z') != '^') {
            throw new EOFException(INPUT_ENDED_UNEXPECTEDLY);
        }
        int i4 = getErrorConfigVersion + 71;
        lookAheadTest = i4 % 128;
        int i5 = i4 % 2;
        this.currentLimit = i2;
        int i6 = getErrorConfigVersion + 87;
        lookAheadTest = i6 % 128;
        if (i6 % 2 != 0) {
            Object[] objArr = null;
            int length = objArr.length;
            return i3;
        }
        return i3;
    }

    public final void popLimit(int i) {
        int i2 = lookAheadTest + 95;
        getErrorConfigVersion = i2 % 128;
        int i3 = i2 % 2;
        this.currentLimit = i;
        int i4 = getErrorConfigVersion + 89;
        lookAheadTest = i4 % 128;
        if (!(i4 % 2 == 0)) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    private boolean isAtEnd() throws IOException {
        int i = getErrorConfigVersion + 123;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        if (getPosition() == ((long) this.currentLimit)) {
            int i3 = getErrorConfigVersion + 27;
            lookAheadTest = i3 % 128;
            int i4 = i3 % 2;
            int i5 = lookAheadTest + 23;
            getErrorConfigVersion = i5 % 128;
            int i6 = i5 % 2;
            return true;
        }
        try {
            return this.source.lookAheadTest();
        } catch (Exception e) {
            throw e;
        }
    }

    public final long getPosition() {
        int i = getErrorConfigVersion + 117;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        try {
            long j = this.pos;
            int i3 = getErrorConfigVersion + 75;
            lookAheadTest = i3 % 128;
            int i4 = i3 % 2;
            return j;
        } catch (Exception e) {
            throw e;
        }
    }

    public final void skipGroup() throws IOException {
        int readTag;
        try {
            do {
                readTag = readTag();
                if (readTag != 0) {
                    int i = getErrorConfigVersion + 87;
                    lookAheadTest = i % 128;
                    int i2 = i % 2;
                }
                break;
            } while (!skipField(readTag));
            break;
            int i3 = lookAheadTest + 117;
            getErrorConfigVersion = i3 % 128;
            if (!(i3 % 2 == 0)) {
                return;
            }
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.zoloz.wire.WireInput$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$squareup$wire$WireType;

        static {
            int[] iArr = new int[WireType.values().length];
            $SwitchMap$com$squareup$wire$WireType = iArr;
            try {
                iArr[WireType.VARINT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$squareup$wire$WireType[WireType.FIXED32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$squareup$wire$WireType[WireType.FIXED64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$squareup$wire$WireType[WireType.LENGTH_DELIMITED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$squareup$wire$WireType[WireType.START_GROUP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$squareup$wire$WireType[WireType.END_GROUP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private boolean skipField(int i) throws IOException {
        try {
            int i2 = lookAheadTest + 107;
            getErrorConfigVersion = i2 % 128;
            int i3 = i2 % 2;
            switch (AnonymousClass1.$SwitchMap$com$squareup$wire$WireType[WireType.valueOf(i).ordinal()]) {
                case 1:
                    readVarint64();
                    return false;
                case 2:
                    readFixed32();
                    return false;
                case 3:
                    readFixed64();
                    return false;
                case 4:
                    skip(readVarint32());
                    return false;
                case 5:
                    skipGroup();
                    checkLastTagWas((i & (-8)) | WireType.END_GROUP.value());
                    return false;
                case 6:
                    int i4 = getErrorConfigVersion + 99;
                    lookAheadTest = i4 % 128;
                    if (!(i4 % 2 == 0)) {
                        Object[] objArr = null;
                        int length = objArr.length;
                        return true;
                    }
                    return true;
                default:
                    throw new AssertionError();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private void skip(long j) throws IOException {
        int i = getErrorConfigVersion + 43;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        this.pos = (int) (this.pos + j);
        this.source.NetworkUserEntityData$$ExternalSyntheticLambda0(j);
        try {
            int i3 = lookAheadTest + 49;
            getErrorConfigVersion = i3 % 128;
            if ((i3 % 2 == 0 ? 'D' : (char) 18) != 'D') {
                return;
            }
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    private static void a(int i, int i2, short s, int i3, byte b, Object[] objArr) {
        boolean z;
        boolean z2;
        int length;
        byte[] bArr;
        int i4;
        B b2 = new B();
        StringBuilder sb = new StringBuilder();
        int i5 = i2 + ((int) (BuiltInFictitiousFunctionClassFactory ^ 3097486228508854431L));
        if (i5 == -1) {
            int i6 = $10 + 55;
            $11 = i6 % 128;
            if (i6 % 2 == 0) {
            }
            z = true;
        } else {
            z = false;
        }
        if (z) {
            byte[] bArr2 = MyBillsEntityDataFactory;
            if (bArr2 != null) {
                int i7 = $11 + 125;
                $10 = i7 % 128;
                if (i7 % 2 != 0) {
                    length = bArr2.length;
                    bArr = new byte[length];
                    i4 = 1;
                } else {
                    length = bArr2.length;
                    bArr = new byte[length];
                    i4 = 0;
                }
                while (true) {
                    if (!(i4 < length)) {
                        break;
                    }
                    bArr[i4] = (byte) (bArr2[i4] ^ 3097486228508854431L);
                    i4++;
                }
                bArr2 = bArr;
            }
            i5 = (bArr2 != null ? (char) 20 : (char) 6) != 6 ? (byte) (((byte) (MyBillsEntityDataFactory[i + ((int) (getAuthRequestContext ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (BuiltInFictitiousFunctionClassFactory ^ 3097486228508854431L))) : (short) (((short) (KClassImpl$Data$declaredNonStaticMembers$2[i + ((int) (getAuthRequestContext ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (BuiltInFictitiousFunctionClassFactory ^ 3097486228508854431L)));
        }
        if (i5 > 0) {
            b2.getAuthRequestContext = ((i + i5) - 2) + ((int) (getAuthRequestContext ^ 3097486228508854431L)) + (z ? 1 : 0);
            b2.MyBillsEntityDataFactory = (char) (i3 + ((int) (PlaceComponentResult ^ 3097486228508854431L)));
            sb.append(b2.MyBillsEntityDataFactory);
            b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
            byte[] bArr3 = MyBillsEntityDataFactory;
            if (bArr3 != null) {
                int length2 = bArr3.length;
                byte[] bArr4 = new byte[length2];
                int i8 = $11 + 5;
                $10 = i8 % 128;
                int i9 = i8 % 2;
                for (int i10 = 0; i10 < length2; i10++) {
                    try {
                        int i11 = $10 + 29;
                        try {
                            $11 = i11 % 128;
                            int i12 = i11 % 2;
                            bArr4[i10] = (byte) (bArr3[i10] ^ 3097486228508854431L);
                        } catch (Exception e) {
                            throw e;
                        }
                    } catch (Exception e2) {
                        throw e2;
                    }
                }
                bArr3 = bArr4;
            }
            if ((bArr3 == null ? (char) 5 : (char) 20) != 5) {
                int i13 = $10 + 109;
                $11 = i13 % 128;
                int i14 = i13 % 2;
                z2 = true;
            } else {
                z2 = false;
            }
            b2.KClassImpl$Data$declaredNonStaticMembers$2 = 1;
            while (b2.KClassImpl$Data$declaredNonStaticMembers$2 < i5) {
                if ((z2 ? 'I' : '?') != '?') {
                    byte[] bArr5 = MyBillsEntityDataFactory;
                    b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                    b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((byte) (((byte) (bArr5[r10] ^ 3097486228508854431L)) + s)) ^ b));
                } else {
                    short[] sArr = KClassImpl$Data$declaredNonStaticMembers$2;
                    b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                    b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((short) (((short) (sArr[r10] ^ 3097486228508854431L)) + s)) ^ b));
                }
                sb.append(b2.MyBillsEntityDataFactory);
                b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
                b2.KClassImpl$Data$declaredNonStaticMembers$2++;
            }
        }
        String sb2 = sb.toString();
        int i15 = $10 + 73;
        $11 = i15 % 128;
        int i16 = i15 % 2;
        objArr[0] = sb2;
    }
}
